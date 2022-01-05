package grupo11.imobiliaria.repository;

import grupo11.imobiliaria.entity.District;
import grupo11.imobiliaria.entity.Prop;
import grupo11.imobiliaria.entity.Room;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ImobiliariaRepository {

    private Room room1 = Room.builder().room_name("cozinha").room_width(3d).room_length(5d).build();
    private Room room2 = Room.builder().room_name("sala").room_width(5d).room_length(6d).build();
    private Room room3 = Room.builder().room_name("quarto").room_width(4d).room_length(6d).build();
    private Room room4 = Room.builder().room_name("quarto").room_width(5d).room_length(7d).build();
    private Room room5 = Room.builder().room_name("banheiro").room_width(2d).room_length(2d).build();
    private Room room6 = Room.builder().room_name("sala de jantar").room_width(5d).room_length(6d).build();

    private District district1 = new District("Bairro do Limoeiro", new BigDecimal(200));
    private District district2 = new District("Centro", new BigDecimal(300));
    private District district3 = new District("Bairro do Abacateiro", new BigDecimal(400));

    public ImobiliariaRepository() {
        this.propertiesList.add(prop1);
        this.propertiesList.add(prop2);
        this.propertiesList.add(prop3);

        this.districtsList.add(district1);
        this.districtsList.add(district2);
        this.districtsList.add(district3);
    }

    private Prop prop1 = Prop.builder()
            .prop_name("casa1")
            .prop_district(district1)
            .prop_rooms(Arrays.asList(room1, room2)).build();

    private Prop prop2 = Prop.builder()
            .prop_name("casa2")
            .prop_district(district2)
            .prop_rooms(Arrays.asList(room3, room4)).build();

    private Prop prop3 = Prop.builder()
            .prop_name("casa3")
            .prop_district(district3)
            .prop_rooms(Arrays.asList(room5, room6)).build();



    private List<Prop> propertiesList = new ArrayList<Prop>();


    public List<Prop> getPropertiesList(){

        return propertiesList;
    }
    public Prop casaNova(Prop prop){
        System.out.println(prop);

        propertiesList.add(prop);
        return prop;
    }

    private List<District> districtsList = new ArrayList<District>();

    public List<District> getDistrictList() {
        return districtsList;
    }
}
