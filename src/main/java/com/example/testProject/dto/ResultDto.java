package com.example.testProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ResultDto {
    private boolean result;
    private String message;


    public ResultDto(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
}
