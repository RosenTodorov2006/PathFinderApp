package bg.soft_uni.pathfinderapp.Validation.annotation;
import bg.soft_uni.pathfinderapp.Validation.validator.ValidatePasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ValidatePasswordValidator.class)
public @interface ValidatePassword {
    String message() default "Password and confirm password must be equals!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
