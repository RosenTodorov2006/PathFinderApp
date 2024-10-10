package bg.soft_uni.pathfinderapp.Validation.validator;

import bg.soft_uni.pathfinderapp.Services.UserService;
import bg.soft_uni.pathfinderapp.Validation.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(email == null || email.isEmpty()){
            return true;
        }
        return this.userService.validEmail(email);
    }
}
