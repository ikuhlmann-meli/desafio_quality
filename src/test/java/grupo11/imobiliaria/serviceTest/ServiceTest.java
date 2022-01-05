package grupo11.imobiliaria.serviceTest;

import grupo11.imobiliaria.entity.District;
import grupo11.imobiliaria.entity.Prop;
import grupo11.imobiliaria.entity.Room;
import grupo11.imobiliaria.exceptions.BusinessException;
import grupo11.imobiliaria.repository.ImobiliariaRepository;
import grupo11.imobiliaria.services.ImobiliariaService;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    public void deveCalcularOsMetrosQuadrados(){
        //arrange
        Room room1 = Room.builder().room_name("cozinha").room_width(3d).room_length(5d).build();
        Room room2 = Room.builder().room_name("sala").room_width(5d).room_length(6d).build();

        District district1 = new District("Bairro do Limoeiro", new BigDecimal(200));

        Prop prop1 = Prop.builder()
                .prop_name("casa1")
                .prop_district(district1)
                .prop_rooms(Arrays.asList(room1, room2)).build();

        List<Prop> propList = new ArrayList<Prop>();
        propList.add(prop1);

        ImobiliariaRepository mock = Mockito.mock(ImobiliariaRepository.class);
        Mockito.when(mock.getPropertiesList()).thenReturn(propList);
        ImobiliariaService propService = new ImobiliariaService(mock);

        //act
        Double total = propService.area("casa1");

        //assertion
        assertEquals(total, 45);
    }

    @Test
    public void deveLancarExececaoAoCadastrarCasaComBairroInexistente(){

        District district1 = new District("Bairro do Limoeiro", new BigDecimal(200));
        District district2 = new District("Bairro Ipiranga", new BigDecimal(200));

        List<District> dist = new ArrayList<District>();

        dist.add(district1);

        Room room1 = Room.builder().room_name("cozinha").room_width(3d).room_length(5d).build();
        Room room2 = Room.builder().room_name("sala").room_width(5d).room_length(6d).build();

        Prop prop1 = Prop.builder()
                .prop_name("casa1")
                .prop_district(district2)
                .prop_rooms(Arrays.asList(room1, room2)).build();

        ImobiliariaRepository mock = Mockito.mock(ImobiliariaRepository.class);
        Mockito.when(mock.getDistrictList()).thenReturn(dist);
        ImobiliariaService propService = new ImobiliariaService(mock);

         //act
         BusinessException excecaoEsperada = assertThrows(
                BusinessException.class,
                () -> propService.casaNova(prop1)
        );

        //assertion
        assertTrue(excecaoEsperada.getMessage().contains("Não é permito cadastro de casas em bairros não registrados"));
    }

    @Test
    public void deveCadastrarCasaComBairroPreExistente(){

        District district1 = new District("Bairro do Limoeiro", new BigDecimal(200));

        List<District> dist = new ArrayList<District>();

        dist.add(district1);

        Room room1 = Room.builder().room_name("cozinha").room_width(3d).room_length(5d).build();
        Room room2 = Room.builder().room_name("sala").room_width(5d).room_length(6d).build();

        Prop prop1 = Prop.builder()
                .prop_name("casa1")
                .prop_district(district1)
                .prop_rooms(Arrays.asList(room1, room2)).build();

        ImobiliariaRepository mock = Mockito.mock(ImobiliariaRepository.class);
        Mockito.when(mock.getDistrictList()).thenReturn(dist);
        ImobiliariaService propService = new ImobiliariaService(mock);

        //act
        Prop p = propService.casaNova(prop1);

        //assertion
        assertTrue(p.equals(prop1));
    }
}
