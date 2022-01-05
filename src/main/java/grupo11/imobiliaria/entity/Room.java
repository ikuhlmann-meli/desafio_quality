package grupo11.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Room {

    @NotEmpty(message = "O campo nome não pode estar vazio")
    @NotNull(message = "O campo nome não pode estar vazio")
    private String name;

    @NotNull(message = "Largura não pode ser nula")
    @Digits(integer = 28, fraction = 2, message = "A largura do cômodo não pode exceder 30 caracteres.")
    @Min(value = 1, message = "Valor minimo é 1")
    private Double width;

    @NotNull(message = "Comprimento não pode ser nula")
    @Min(value = 1, message = "Valor minimo é 1")
    private Double length;
}
