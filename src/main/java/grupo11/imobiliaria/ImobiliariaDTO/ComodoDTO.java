package grupo11.imobiliaria.ImobiliariaDTO;

import grupo11.imobiliaria.entity.Comodo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ComodoDTO {

    private String nome;
    private Float area;

    public static ComodoDTO converte(Comodo comodo){
     return ComodoDTO
             .builder()
             .nome(comodo.getNome())
             .area(comodo.getLargura() * comodo.getComprimento()).build();
    }

}
