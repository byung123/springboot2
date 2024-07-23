package com.study.rest.dto;

import lombok.Data;

@Data
public class ReqProductDto {
    private String productName;
    private int price;
    private int sizeId; // dize지만 id값으로 넘어올 거기때문에 int형
    private int colorId;
}
