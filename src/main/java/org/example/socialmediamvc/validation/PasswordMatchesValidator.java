package org.example.socialmediamvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.example.socialmediamvc.utils.CommonUtil;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.stereotype.Component;

@Component
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegistrationRequestDto> {

    public boolean isValid(RegistrationRequestDto registrationRequestDto, ConstraintValidatorContext context) {
        if(CommonUtil.isNullOrEmpty(registrationRequestDto.getPassword()) || CommonUtil.isNullOrEmpty(registrationRequestDto.getConfirmPassword())) {
            return false;
        }
        boolean isMatched= registrationRequestDto.getPassword().equals(registrationRequestDto.getConfirmPassword());
        if(!isMatched) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Constants.ErrorMessage.PASSWORD_MISMATCH).addPropertyNode("confirmPassword").addConstraintViolation();
        }
        return isMatched;
    }
}