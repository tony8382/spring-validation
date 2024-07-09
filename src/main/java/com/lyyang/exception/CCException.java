package com.lyyang.exception;

import com.lyyang.dto.BigModelDto;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class CCException extends RuntimeException {
    private String message;
    private List<String> errors;

    public CCException(String message, Set<ConstraintViolation<BigModelDto>> violations) {
        super(message);
        errors = new ArrayList<>();
        for (ConstraintViolation<BigModelDto> v : violations) {
            log.warn("v:{} ", v);
            errors.add(v.getMessage());
        }

        this.message = message;
    }
}