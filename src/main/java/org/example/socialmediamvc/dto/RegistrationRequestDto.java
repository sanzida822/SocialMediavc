package org.example.socialmediamvc.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.utils.Constants;
import org.example.socialmediamvc.validation.ImageFile;
import org.example.socialmediamvc.validation.PasswordMatches;
import org.example.socialmediamvc.validation.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@PasswordMatches
public class RegistrationRequestDto {
        @NotBlank(message = Constants.ErrorMessage.USERNAME_REQUIRED)
        @Size(min = 4, max=30, message = Constants.ErrorMessage.USERNAME_LENGTH)
        private String userName;

        @NotBlank(message = Constants.ErrorMessage.EMAIL_REQUIRED)
        @Email(message = Constants.ErrorMessage.INVALID_EMAIL)
        @UniqueEmail
        private String email;

        @NotBlank(message = Constants.ErrorMessage.PASSWORD_REQUIRED)
        @Size(min = 4, max=15, message = Constants.ErrorMessage.PASSWORD_LENGTH)
        private String password;

        @NotBlank(message = Constants.ErrorMessage.PASSWORD_REQUIRED)
        private String confirmPassword;
       //  @ImageFile
       //  private MultipartFile profileImage;
    }


