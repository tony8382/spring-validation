package com.lyyang.dto.validator;

import com.lyyang.service.Test2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
@RequiredArgsConstructor
public class BFieldValidator implements ConstraintValidator<ValidbFieldNumber, String> {

    private final Test2Service test2Service;

    @Override
    public void initialize(ValidbFieldNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {

        test2Service.func1();
        if (phoneNumber == null) {
            return false;
        }

        return phoneNumber.matches("^09\\d{8}$");
    }
}