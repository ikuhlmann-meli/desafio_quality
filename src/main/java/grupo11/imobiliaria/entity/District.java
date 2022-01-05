package grupo11.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class District {

    @NotNull(message = "O bairro não pode estar vazio.")
    @NotEmpty(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres")
    private String name;

    @NotNull(message = "O valor do metro quadrado no bairro não pode estar vazio.")
    @Digits(integer=11, fraction=2, message = "O valor do metro quadrado no bairro não pode estar vazio.")
    private BigDecimal squaredMeterValue;

}
