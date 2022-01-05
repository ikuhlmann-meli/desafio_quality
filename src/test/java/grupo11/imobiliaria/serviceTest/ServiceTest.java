package grupo11.imobiliaria.serviceTest;

import grupo11.imobiliaria.DTO.RoomDTO;
import grupo11.imobiliaria.entity.District;
import grupo11.imobiliaria.entity.Property;
import grupo11.imobiliaria.entity.Room;
import grupo11.imobiliaria.exceptions.BusinessException;
import grupo11.imobiliaria.repository.PropertiesRepository;
import grupo11.imobiliaria.services.PropertiesService;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private List<Property> mockedPropertiesList(){
        Room room1 = Room.builder().name("cozinha").width(3d).length(5d).build();
        Room room2 = Room.builder().name("sala").width(5d).length(6d).build();
        District district1 = new District("Bairro do Limoeiro", new BigDecimal(200));
        Property prop1 = Property.builder()
                .name("casa1")
                .district(district1)
                .rooms(Arrays.asList(room1, room2)).build();

        List<Property> propertiesList = new ArrayList<Property>();
        propertiesList.add(prop1);

        return propertiesList;
    }

    @Test
    public void deveCalcularOsMetrosQuadrados(){

        //arrange
        PropertiesRepository mock = Mockito.mock(PropertiesRepository.class);
        Mockito.when(mock.getPropertiesList()).thenReturn(mockedPropertiesList());
        PropertiesService propertyService = new PropertiesService(mock);

        //act
        Double total = propertyService.area("casa1");

        //assertion
        assertEquals(total, 45);
    }

    @Test
    public void deveLancarExececaoAoCadastrarCasaComBairroInexistente(){

        District district2 = new District("Bairro Ipiranga", new BigDecimal(200));
        List<District> districts = new ArrayList<District>();
        districts.add(district2);

        PropertiesRepository mock = Mockito.mock(PropertiesRepository.class);
        Mockito.when(mock.getDistrictList()).thenReturn(districts);
        PropertiesService propService = new PropertiesService(mock);

         //act
         BusinessException excecaoEsperada = assertThrows(
                BusinessException.class,
                () -> propService.newProperty(mockedPropertiesList().get(0)));

        //assertion
        assertTrue(excecaoEsperada.getMessage().contains("Não é permito cadastro de casas em bairros não registrados"));
    }

    @Test
    public void deveCadastrarCasaComBairroPreExistente(){

        District district1 = new District("Bairro do Limoeiro", new BigDecimal(200));
        List<District> districts = new ArrayList<District>();
        districts.add(district1);

        Property prop1 = mockedPropertiesList().get(0);
        PropertiesRepository mock = Mockito.mock(PropertiesRepository.class);
        Mockito.when(mock.getDistrictList()).thenReturn(districts);
        PropertiesService propService = new PropertiesService(mock);

        //act
        Property p = propService.newProperty(prop1);

        //assertion
        assertTrue(p.equals(prop1));
    }

    @Test
    public void verificaSeMaiorComodoFoiDevolvido(){
        List<Property> properties = mockedPropertiesList();

        PropertiesRepository mock = Mockito.mock(PropertiesRepository.class);
        Mockito.when(mock.getPropertiesList()).thenReturn(properties);
        PropertiesService propService = new PropertiesService(mock);

        //act
        String biggestRoom = propService.biggestRoom(properties.get(0).getName());

        //assert
        assertEquals(biggestRoom, properties.get(0).getRooms().get(1).getName());
    }

    @Test
    public void verificaSeRetornaTotalM2(){
        List<Property> properties = mockedPropertiesList();
        Property property = properties.get(0);

        PropertiesRepository mock = Mockito.mock(PropertiesRepository.class);
        Mockito.when(mock.getPropertiesList()).thenReturn(properties);
        PropertiesService propService = new PropertiesService(mock);

        //act
        List<RoomDTO> listComodos = propService.roomAreas(property.getName());

        //assert
        for (int i=0; i < listComodos.size(); i+=1) {
            Double area = property.getRooms().get(i).getLength() * property.getRooms().get(i).getWidth();
            assertEquals(listComodos.get(i).getArea(), area);
        }
    }
}
