package grupo11.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Property {

    @NotNull(message = "O campo nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^([A-Z]{1})([a-z0-9]{1,})$", message = "O campo nome da propriedade deve começar com letra maiúscula, não possuir espaços, nem caracteres especiais e ter ao menos dois caracteres.")
    @Size(max = 30, message = "O nome da propriedade não pode exceder 30 caracteres.")
    private String name;

    @Valid
    private District district;

    @Valid
    @NotNull(message = "Os comodos não podem estar vazios.")
    @NotEmpty(message = "Os comodos não podem estar vazios.")
    private List<Room> rooms;

}
