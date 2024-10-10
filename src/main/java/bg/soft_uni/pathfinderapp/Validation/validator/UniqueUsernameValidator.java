package bg.soft_uni.pathfinderapp.Validation.validator;

import bg.soft_uni.pathfinderapp.Services.UserService;
import bg.soft_uni.pathfinderapp.Validation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(username==null || username.isEmpty()){
            return true;
        }
        return this.userService.validUsername(username);
    }
}
