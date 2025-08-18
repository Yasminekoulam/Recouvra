package recouvra.example.recouvra.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class loginDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
