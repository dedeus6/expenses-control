package io.github.dedeus6.expense.control.validator.impl;

import io.github.dedeus6.expense.control.validator.EnumValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValueImpl implements ConstraintValidator<EnumValue, String>{

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        try {
            Enum<?>[] enumValues = enumClass.getEnumConstants();
            for (Enum<?> enumValue : enumValues) {
                if (enumValue.name().equals(value)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
