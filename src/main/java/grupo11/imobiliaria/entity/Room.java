package grupo11.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Room {

    @NotNull(message = "O campo nome do cômodo não pode ser nulo.")
    @Pattern(regexp = "^([A-Z]{1})([a-z0-9]{1,})$", message = "O campo nome do cômodo deve começar com letra maiúscula, não possuir espaços, nem caracteres especiais e ter ao menos dois caracteres.")
    @Size(max = 30, message = "O nome do comodo não pode exceder 30 caracteres.")
    private String name;

    @NotNull(message = "Largura não pode ser nula")
    @Max(value= 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    @Min(value = 1, message = "A largura mínima permitida por cômodo é de 1 metro.")
    private Double width;

    @NotNull(message = "Comprimento não pode ser nulo")
    @Max(value= 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    @Min(value = 1, message = "O comprimento mínimo permitido por cômodo é de 1 metro.")
    private Double length;
}
