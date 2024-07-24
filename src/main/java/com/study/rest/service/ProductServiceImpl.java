package com.study.rest.service;

import com.study.rest.dto.CommonResponseDto;
import com.study.rest.dto.ProductDto;
import com.study.rest.dto.SizeDto;
import com.study.rest.entity.Color;
import com.study.rest.entity.Size;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;

    @Override  // ctrl + i 눌러서 자동 완성
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<Color> getColorListAll() {
        return colorMapper.findAll();
    }

    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register) {
        return CommonResponseDto.ofDefault(productMapper.save(register.toEntity()));
    }
}
