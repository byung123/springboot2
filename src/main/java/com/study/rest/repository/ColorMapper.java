package com.study.rest.repository;

import com.study.rest.entity.Color;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColorMapper { // Mapper도 같이 만들어줘야함
    int save(Color color);
    List<Color> findAll(); // 이제 findAll 메소드만 호출해주면 mapper에 잇는 쿼리문을 자동으로 실행해준다
}
