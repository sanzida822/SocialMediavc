package org.example.socialmediamvc.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.validation.UniqueEmail;

@NoArgsConstructor
@Data
public class LoginRequestDto {
    @Email
    @NotBlank

    private String email;
    @NotBlank
    private String password;
}
