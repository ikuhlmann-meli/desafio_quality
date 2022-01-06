package grupo11.imobiliaria.services;

import grupo11.imobiliaria.DTO.RoomDTO;
import grupo11.imobiliaria.entity.District;
import grupo11.imobiliaria.entity.Property;
import grupo11.imobiliaria.exceptions.BusinessException;
import grupo11.imobiliaria.exceptions.NotFoundException;
import grupo11.imobiliaria.repository.PropertiesRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author grupo11
 * @version 0.0.1
 */
@Service
public class PropertiesService {


    PropertiesRepository propertiesRepository;
    List<Property> props;

    /**
     *
     * @param propertiesRepository injeta dependencia de repository
     */
    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
        this.props = propertiesRepository.getPropertiesList();
    }

    /**
     * Calcula o valor de uma propriedade
     * @param property uma String com o nome da propriedade
     * @return returna uma String com o valor da propriedade
     */
    public String value(String property){

        BigDecimal propertyValue = getProperty(property).getDistrict().getSquaredMeterValue().multiply(new BigDecimal(area(property)));
        return "O valor do imóvel " + property + " é de R$ " + propertyValue;
    }

    /**
     * Retorna um objeto property
     * @param property Uma String com o nome da propriedade
     * @return
     */
    private Property getProperty(String property){
        for (int i = 0; i < props.size(); i++){
            if (property.equals(props.get(i).getName())){
                return props.get(i);
            }
        } throw new NotFoundException("A propriedade " + property + " não existe");
    }

    /**
     * Retorna o maior comodo
     * @param property Uma String com o nome da propriedade
     * @return
     */
    public String biggestRoom(String property){
        List<RoomDTO> rooms = roomAreas(property);
        String biggest = "";
        Float size = 0f;

        for (int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getArea() > size){
                biggest = rooms.get(i).getNome();
            }
        }
        return biggest;
    }

    /**
     * Calcula e retorna a area de uma propriedade
     * @param property Uma String com o nome da propriedade
     * @return
     */
    public Double area(String property){
        List<RoomDTO> rooms = roomAreas(property);
        Double totalArea = 0d;

        for (int i = 0; i < rooms.size(); i++){
            totalArea += rooms.get(i).getArea();
        }

        return totalArea;
    }

    /**
     * Retorna uma lista com as areas de cada comodo
     * @param p Uma String com o nome da propriedade
     * @return
     */
    public List<RoomDTO> roomAreas(String p){
        List<RoomDTO> rooms = new ArrayList<>();
        Property property = getProperty(p);
                for (int j = 0; j < property.getRooms().size(); j++){
                    rooms.add(RoomDTO.convert(property.getRooms().get(j)));
        }
        return rooms;
    }

    /**
     * Cadastra uma nova propriedade
     * @param property Uma String com o nome da propriedade
     * @return
     */
    public Property newProperty(Property property){
        for (District d: propertiesRepository.getDistrictList()) {
            if(d.equals(property.getDistrict())){
                propertiesRepository.newProperty(property);
                return property;
            }
        } throw new BusinessException("Não é permitido cadastro de casas em bairros não registrados");
    }


}
