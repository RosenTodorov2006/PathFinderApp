package bg.soft_uni.pathfinderapp.Validation.annotation;
import bg.soft_uni.pathfinderapp.Validation.validator.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "Email is already in use!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
