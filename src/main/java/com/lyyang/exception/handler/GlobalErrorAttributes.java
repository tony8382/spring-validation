package com.lyyang.exception.handler;

import com.lyyang.exception.AAException;
import com.lyyang.exception.CCException;
import com.lyyang.exception.enums.ErrorAttributesKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    public static final Map<Class<?>, HttpStatus> exceptionsRules;

    static {
        exceptionsRules = new HashMap<>();
        exceptionsRules.put(AAException.class, HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Throwable error = getError(request);

        final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

        Map<String, Object> errorAttrs = new HashMap<>();
        Map<String, Object> parentErrorAttrs = super.getErrorAttributes(request, options);
        if (exceptionsRules.containsKey(error.getClass())) {
            errorAttrs.put(ErrorAttributesKey.STATUS.getKey(), exceptionsRules.get(error.getClass()).value());
        } else {

            errorAttrs.put(ErrorAttributesKey.STATUS.getKey(), parentErrorAttrs.get(ErrorAttributesKey.STATUS.getKey()));
        }

        if (error.getClass().equals(CCException.class)) {
            log.info("GGGG:{}", parentErrorAttrs);
            errorAttrs.put(ErrorAttributesKey.ERRORS.getKey(), parentErrorAttrs.get(ErrorAttributesKey.ERRORS.getKey()));

        }

        errorAttrs.put(ErrorAttributesKey.MESSAGE.getKey(), error.getMessage());
        errorAttrs.put(ErrorAttributesKey.TIME.getKey(), timestamp);
        return errorAttrs;
    }


}