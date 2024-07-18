package com.study.rest.service;

import org.springframework.stereotype.Service;

@Service("ts") // 이름을 짧게 컴포넌트 이름을 설정
public class TestServiceImpl implements TestService{

    @Override
    public void test() {
        System.out.println("기존 단위 테스트 실행");
    }
}
