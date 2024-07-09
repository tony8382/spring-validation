package com.lyyang.service;

import com.lyyang.dto.BigModelDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Test2Service {

    public String func1() {
        log.info("hi HI");
        return "BG";
    }
}
