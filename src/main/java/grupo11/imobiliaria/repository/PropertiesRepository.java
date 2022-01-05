package grupo11.imobiliaria.repository;

import grupo11.imobiliaria.entity.District;
import grupo11.imobiliaria.entity.Property;
import grupo11.imobiliaria.entity.Room;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PropertiesRepository {

    private Room room1 = Room.builder().name("cozinha").width(3d).length(5d).build();
    private Room room2 = Room.builder().name("sala").width(5d).length(6d).build();
    private Room room3 = Room.builder().name("quarto").width(4d).length(6d).build();
    private Room room4 = Room.builder().name("quarto").width(5d).length(7d).build();
    private Room room5 = Room.builder().name("banheiro").width(2d).length(2d).build();
    private Room room6 = Room.builder().name("sala de jantar").width(5d).length(6d).build();

    private District district1 = new District("Bairro do Limoeiro", new BigDecimal(200));
    private District district2 = new District("Centro", new BigDecimal(300));
    private District district3 = new District("Bairro do Abacateiro", new BigDecimal(400));

    public PropertiesRepository() {
        this.propertiesList.add(prop1);
        this.propertiesList.add(prop2);
        this.propertiesList.add(prop3);

        this.districtsList.add(district1);
        this.districtsList.add(district2);
        this.districtsList.add(district3);
    }

    private Property prop1 = Property.builder()
            .name("casa1")
            .district(district1)
            .rooms(Arrays.asList(room1, room2)).build();

    private Property prop2 = Property.builder()
            .name("casa2")
            .district(district2)
            .rooms(Arrays.asList(room3, room4)).build();

    private Property prop3 = Property.builder()
            .name("casa3")
            .district(district3)
            .rooms(Arrays.asList(room5, room6)).build();

    private List<Property> propertiesList = new ArrayList<Property>();

    public List<Property> getPropertiesList(){

        return propertiesList;
    }
    public Property newProperty(Property property){
        propertiesList.add(property);
        return property;
    }

    private List<District> districtsList = new ArrayList<District>();

    public List<District> getDistrictList() {
        return districtsList;
    }
}
