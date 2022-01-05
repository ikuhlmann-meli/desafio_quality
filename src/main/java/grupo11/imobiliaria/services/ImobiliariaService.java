package grupo11.imobiliaria.services;

import grupo11.imobiliaria.ImobiliariaDTO.ComodoDTO;
import grupo11.imobiliaria.entity.Prop;
import grupo11.imobiliaria.entity.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImobiliariaService {

    private Room com1 = Room.builder().room_name("cozinha").room_width(3d).room_length(5d).build();
    private Room com2 = Room.builder().room_name("sala").room_width(5d).room_length(6d).build();
    private  List<Room> rooms = Arrays.asList(com1, com2);

    private Prop propTeste = Prop.builder()
            .prop_name("casaTeste")
            .prop_district("Rua dos bobos numero 0")
            .prop_rooms(Arrays.asList(
                    Room.builder()
                            .room_name("quarto")
                            .room_width(5d)
                            .room_length(4d)
                            .build(),
                    Room.builder()
                            .room_name("banheiro")
                            .room_width(3d)
                            .room_length(2d)
                            .build())).build();


    private  List<Prop> props = Arrays.asList(
            Prop.builder()
                    .prop_name("maurosHouse")
                    .prop_district("Rua Tal, numero 0")
                    .prop_rooms(rooms).build(),
            Prop.builder()
                    .prop_name("iberesHouse")
                    .prop_district("Rua dos bobos numero 0")
                    .prop_rooms(Arrays.asList(
                            Room.builder()
                                    .room_name("quarto")
                                    .room_width(5d)
                                    .room_length(4d)
                                    .build(),
                            Room.builder()
                                    .room_name("banheiro")
                                    .room_width(3d)
                                    .room_length(2d)
                                    .build()))
                    .build());

    public String valor(String casa){
        Double valorCasa = area(casa) * 800;
        return "O valor da casa " + casa + " é de R$ " + valorCasa;
    }

    public String maiorComodo(String casa){
        List<ComodoDTO> comodos = areaComodos(casa);
        String maior = "";
        Float tamanho = 0f;

        for (int i = 0; i < comodos.size(); i++){
            if (comodos.get(i).getArea() > tamanho){
                maior = comodos.get(i).getNome();
            }
        }
        return maior;
    }

    public Double area(String casa){
        List<ComodoDTO> comodos = areaComodos(casa);
        Double areaTotal = 0d;

        for (int i = 0; i < comodos.size(); i++){
            areaTotal += comodos.get(i).getArea();
        }

        return areaTotal;
    }

    public List<ComodoDTO> areaComodos(String casa){
        List<ComodoDTO> comodos = new ArrayList<>();
        for (int i = 0; i < props.size(); i++){
            if (casa.equals(props.get(i).getProp_name())){
                for (int j = 0; j < props.get(i).getProp_rooms().size(); j++){
                    comodos.add(ComodoDTO.converte(props.get(i).getProp_rooms().get(j)));
                }
            }
        }
        return comodos;
    }
}
