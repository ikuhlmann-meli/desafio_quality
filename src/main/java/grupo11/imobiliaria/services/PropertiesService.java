package grupo11.imobiliaria.services;

import grupo11.imobiliaria.DTO.RoomDTO;
import grupo11.imobiliaria.entity.District;
import grupo11.imobiliaria.entity.Property;
import grupo11.imobiliaria.exceptions.BusinessException;
import grupo11.imobiliaria.exceptions.NotFoundException;
import grupo11.imobiliaria.repository.PropertiesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertiesService {

    PropertiesRepository propertiesRepository;
    List<Property> props;

    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
        this.props = propertiesRepository.getPropertiesList();
    }

    public String value(String property){
        Double propertyValue = area(property) * 800;
        return "O valor do imóvel " + property + " é de R$ " + propertyValue;
    }

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

    public Double area(String property){
        List<RoomDTO> rooms = roomAreas(property);
        Double totalArea = 0d;

        for (int i = 0; i < rooms.size(); i++){
            totalArea += rooms.get(i).getArea();
        }

        return totalArea;
    }

    public List<RoomDTO> roomAreas(String property){
        List<RoomDTO> rooms = new ArrayList<>();
        for (int i = 0; i < props.size(); i++){
            if (property.equals(props.get(i).getName())){
                for (int j = 0; j < props.get(i).getRooms().size(); j++){
                    rooms.add(RoomDTO.convert(props.get(i).getRooms().get(j)));
                }
            }
        }
        if (rooms.size() == 0) throw new NotFoundException("A propriedade " + property + " não existe");
        return rooms;
    }
    public Property newProperty(Property property){
        for (District d: propertiesRepository.getDistrictList()) {
            if(d.equals(property.getDistrict())){
                propertiesRepository.newProperty(property);
                return property;
            }
        } throw new BusinessException("Não é permito cadastro de casas em bairros não registrados");
    }


}
