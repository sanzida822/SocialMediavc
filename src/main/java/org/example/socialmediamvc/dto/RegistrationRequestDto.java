package org.example.socialmediamvc.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.validation.ImageFile;
import org.example.socialmediamvc.validation.PasswordMatches;
import org.example.socialmediamvc.validation.UniqueEmail;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@PasswordMatches
public class RegistrationRequestDto {
        @NotBlank(message = "{error.username.required}")
        @Size(min = 4, max=30, message = "{error.username.size}")
        private String userName;

        @NotBlank(message = "{error.email.required}")
        @Email(message = "{error.email.invalid}")
        private String email;

        @NotBlank(message = "{error.password.required}")
        @Size(min = 4, max=30, message = "{error.password.size}")
        private String password;

        @NotBlank(message = "{error.password.required}")
        private String confirmPassword;
        @ImageFile
        private MultipartFile profileImage;
    }


