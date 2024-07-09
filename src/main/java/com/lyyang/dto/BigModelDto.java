package com.lyyang.dto;

import com.lyyang.dto.validator.ValidbFieldNumber;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BigModelDto {

    @NotNull
    @Size(max = 1, message = "aField must be between 0 to 1")
    private String aField;

    @ValidbFieldNumber
    private String bField;

    private String cField;
    private String dField;
}
