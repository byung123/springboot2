package com.study.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data                 // anotation 4개 고정
public class Color {
    private int colorId;
    private String colorName;

}
