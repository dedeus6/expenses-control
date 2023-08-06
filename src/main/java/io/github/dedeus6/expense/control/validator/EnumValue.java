package io.github.dedeus6.expense.control.validator;

import io.github.dedeus6.expense.control.validator.impl.EnumValueImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static io.github.dedeus6.expense.control.constants.Errors.INVALID_ENUM_VALUE;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueImpl.class)
public @interface EnumValue {
    String message() default INVALID_ENUM_VALUE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends Enum<?>> enumClass();
}
