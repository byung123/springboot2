package com.study.rest.controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 의존성 주입과 빈 등록은 다른 것인데 일단 IoC 컨테이너에 빈으로 등록이 돼야 의존성 주입을 할 수 있다.
// 의존성 주입하는 방법으로 @Autowiredfmf 사용하여 의존성 주입을 할 수 있다
// Autowired란 필요한 의존 객체의 '타입'에 해당하는 빈을 찾아 주입한다. (생성자, 필드, setter)에 가능
// Autowired는 기본값이 true이기 때문에 의존성 주입을 할 대상을 찾지 못한다면 애플리케이션 구동에 실패한다.

@Controller
public class DiAndIoC {

    @Autowired
    private C c; // new C();를 안해도 @Autowired를 달아주면, DiAndIoC 객체 안에 C란 객체(컴포넌트)가 생성되어져 있다.

    @Autowired
    @Qualifier("ts")
    private TestService testService1;
    @Autowired
    @Qualifier("newTestServiceImpl") // bean 객체가 2개가 있으므로 @Qualifier로 각 빈의 객체를 구분시켜 사용한다.
    private TestService testService2;

    @ResponseBody // 응답하려는 본문의 내용을 가져다주는 어노테이션 - > HTML 형식을 JSON 형식으로 보여주는 것
    @GetMapping("/di") // @getMapping을 사용하면 Controller가 특정 view의 화면을 사용자에게 보여줄 수 있게된다.
    public Object di() {
        // A가 B를 의존하는 관계
        B b = new B();
        A a = new A(b);
        a.aCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/test")
    public Object startTest(@RequestParam String type) {
        if("old".equals(type)) {
            testService1.test();
        } else {
            testService2.test();
        }
        return null;
    }
}
