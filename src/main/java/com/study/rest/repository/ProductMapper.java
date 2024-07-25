package com.study.rest.repository;

import com.study.rest.entity.Color;
import com.study.rest.entity.Product;
import com.study.rest.entity.Size;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper 
public interface ProductMapper { // 여기에 몰아쓰지 말고 따로 size, color repository를 만들어라 -> 몰아쓰면 나중에 구분이 어려움
    int save(Product product); // 건수라서 타입을 int로 해줌, select 빼곤 성공횟수를 반환 해주려고 int타입을 사용

}
