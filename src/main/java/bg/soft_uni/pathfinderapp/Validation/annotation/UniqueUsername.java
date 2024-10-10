package bg.soft_uni.pathfinderapp.Validation.annotation;

import bg.soft_uni.pathfinderapp.Validation.validator.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {
    String message() default "Username is already in use!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
