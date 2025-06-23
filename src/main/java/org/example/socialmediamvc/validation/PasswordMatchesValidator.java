package org.example.socialmediamvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.example.socialmediamvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegistrationRequestDto> {

    public boolean isValid(RegistrationRequestDto registrationRequestDto, ConstraintValidatorContext context) {
     return registrationRequestDto.getPassword().equals(registrationRequestDto.getConfirmPassword());
    }
}
