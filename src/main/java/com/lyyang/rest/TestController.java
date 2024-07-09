package com.lyyang.rest;

import com.lyyang.dto.BigModelMapper;
import com.lyyang.service.TestService;
import com.lyyang.vo.BigModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestService testService;
    private final BigModelMapper bigModelMapper;

    @GetMapping("a")
    public String test(BigModel bigModel) {

        return testService.func1(bigModelMapper.toDTO(bigModel));
    }
}
