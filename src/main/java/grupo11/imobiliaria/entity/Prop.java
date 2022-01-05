package grupo11.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Prop {

    @NotNull(message = "O nome não pode estar vazio.")
    @NotEmpty(message = "O nome não pode estar vazio.")
    @Pattern(regexp = "^[A-Z]", message = "O nome deve comecar com uma letra maiúscula")
    private String prop_name;

    @NotNull(message = "O bairro nao pode estar")
    @NotEmpty(message = "O bairro não pode estar vazio.")
    private String prop_district;

    @NotNull(message = "Os comodos não podem estar vazio.")
    @NotEmpty(message = "Os comodos não podem estar vazio.")
    private List<Room> prop_rooms;

}
