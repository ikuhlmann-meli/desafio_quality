package grupo11.imobiliaria.DTO;

import grupo11.imobiliaria.entity.Room;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoomDTO {

    private String nome;
    private Double area;

    public static RoomDTO convert(Room room){
     return RoomDTO
             .builder()
             .nome(room.getName())
             .area(room.getWidth() * room.getLength())
             .build();
    }
}
