package com.example.booking.common;

import com.example.booking.exception.FieldValidationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FieldValidator {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void verify(Object object) throws FieldValidationException {

        Set<ConstraintViolation<Object>> validates = validator.validate(object);
        if (!validates.isEmpty()) {
            throw new FieldValidationException(validates.stream()
                    .map(v -> new FieldError(v.getPropertyPath().toString(), v.getMessage()))
                    .collect(Collectors.toList()).toString());
        }
    }
}
