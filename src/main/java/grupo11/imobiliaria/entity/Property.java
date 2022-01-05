package grupo11.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Property {

    @NotNull(message = "O campo nome não pode estar vazio.")
    @NotEmpty(message = "O campo nome não pode estar vazio.")
    @Pattern(regexp = "^([A-Z]{1})([a-z0-9]{1,})$", message = "Nome deve comecar com letra maiuscula")
    private String name;

    @Valid
    private District district;

    @Valid
    @NotNull(message = "Os comodos não podem estar vazio.")
    @NotEmpty(message = "Os comodos não podem estar vazio.")
    private List<Room> rooms;

}
