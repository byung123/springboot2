package com.study.rest.di;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class A {

    private B b = new B();

    public void aCall() {
        System.out.println("A 객체에서 메서드 호출");
        b.bCall();
    }
}
