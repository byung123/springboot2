package com.study.rest.dto;

import com.study.rest.entity.Product;
import lombok.Builder;
import lombok.Data;

public class ProductDto { // 내부클래스를 사용해서 Dto 관리하는건 지금 하기 어려워서 다음에 하기로 함.

    @Data
    public static class Register {
        private String productName;
        private int price;
        private int sizeId;
        private int colorId;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .price(price)
                    .sizeId(sizeId)
                    .colorId(colorId)
                    .build();
        }
    }
}
