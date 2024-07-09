package com.lyyang.exception.enums;


import lombok.Getter;

@Getter
public enum ErrorAttributesKey {
    STATUS("status"),
    MESSAGE("message"),
    TIME("timestamp"),
    ERRORS("errors");

    private final String key;

    ErrorAttributesKey(String key) {
        this.key = key;
    }
}