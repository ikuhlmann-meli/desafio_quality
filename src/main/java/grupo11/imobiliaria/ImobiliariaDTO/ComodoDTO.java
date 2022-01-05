package grupo11.imobiliaria.ImobiliariaDTO;

import grupo11.imobiliaria.entity.Room;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ComodoDTO {

    private String nome;
    private Double area;

    public static ComodoDTO converte(Room room){
     return ComodoDTO
             .builder()
             .nome(room.getRoom_name())
             .area(room.getRoom_width() * room.getRoom_length()).build();
    }

}
