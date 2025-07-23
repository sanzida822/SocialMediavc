package org.example.socialmediamvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.service.UserService;
import org.example.socialmediamvc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private final UserService userService;
    public boolean isValid(String email, ConstraintValidatorContext context) {
        UserDto userDto=new UserDto();
        userDto=userService.emailExists(email);
        return CommonUtil.isNullOrEmpty(email) ||userDto==null;
    }
}
