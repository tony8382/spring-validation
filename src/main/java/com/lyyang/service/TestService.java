package com.lyyang.service;

import com.lyyang.dto.BigModelDto;
import com.lyyang.exception.CCException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final Validator validator;

    public String func1(BigModelDto bigModel) {

        Set<ConstraintViolation<BigModelDto>> violations = validator.validate(bigModel);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<BigModelDto> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new CCException("Error occurred: " + sb.toString(), violations);
        }

        log.info("hi big:{}", bigModel);
        return "GGG";
    }
}
