package grupo11.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Room {

    @NotEmpty(message = "O campo não pode estar vazio")
    @NotNull(message = "O campo não pode estar vazio")
    private String room_name;

    @NotEmpty
    @NotNull
    @Digits(integer = 28, fraction = 2, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private Double room_width;

    @NotEmpty(message = "O campo não pode estar vazio")
    @NotNull(message = "O campo não pode estar vazio")
    private Double room_length;
}
