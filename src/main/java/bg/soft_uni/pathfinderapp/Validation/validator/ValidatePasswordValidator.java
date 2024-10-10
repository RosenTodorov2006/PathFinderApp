package bg.soft_uni.pathfinderapp.Validation.validator;

import bg.soft_uni.pathfinderapp.Model.Dtos.RegisterSeedDto;
import bg.soft_uni.pathfinderapp.Validation.annotation.ValidatePassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ValidatePasswordValidator implements ConstraintValidator<ValidatePassword, RegisterSeedDto> {
    private String message;
    @Override
    public void initialize(ValidatePassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(RegisterSeedDto registerSeedDto, ConstraintValidatorContext constraintValidatorContext) {
        String password = registerSeedDto.getPassword();
        String confirmPassword = registerSeedDto.getConfirmPassword();
        if(password == null || confirmPassword == null){
            return true;
        }
        boolean isValid = confirmPassword.equals(password);

        if(!isValid) {
            constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class)
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
