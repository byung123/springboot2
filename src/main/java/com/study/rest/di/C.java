package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component란, 개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 Annotation이다.
// 그러면 @Controller, @Service, @Repository 어노테이션은 무엇일까?
// 이것들은 Component 어노테이션의 구체화된 형태입니다.
// 어노테이션을 세분화 함으로써 가독성 측면에서 해당 각각의 어노테이션을 가진 클래스의 역할을 알 수 있게 됩니다.
// @Bean이란, 개발자가 직접 제어가 불가능한 외부 라이브러리 등을 Bean으로 만들려고 할 때 사용한다.
// @Autowired는 filed(속성), setter, method, constructor(생성자)에서 사용하며 type에 따라 자동으로 bean을 주입합니다.

// 참고로 세가지 Annotation의 목적은 모두 같다.
// controller, service, repository의 어노테이션은 모두 컴포넌트 스캔이 가능하게 만드는 수단입니다.
// 여기서 말하는 컴포넌트 스캔이란 @Component 와 연관이 있는데 해당 어노테이션이 붙으면
// 스프링이 어노테이션을 분석하고 자동으로 Bean클래스를 생성 해줍니다.
// 1. 클라이언트가 서버에 페이지를 요청한다.
// 2. Dispatcher Servlet은 사용자의 요청에 알맞는 @Controller를 찾는다.
// 3. 만약 DB데이터를 이용한 처리 과정이 없다면, 단순히 View를 보여주면 여기서 끝이다.
// 4. 만약 DB가 필요하다면 @Controller는 알맞은 @Service로 가서 비지니스 로직을 수행한다.
// 5.수행하는 과정중 DB를 접근하기 위하여 @Repository에 요청하여 DB로 부터 필요한 값을 가져온다.
// 6. 순서대로 @Controller까지 결과값을 가지고 return을 하게 되며, Model에 담은 다음에 View를 찾아 보여준다.
// 일단 위에 3가지 어노테이션을 알기전에 기본적으로 모두 포함되있는 @Component를 먼저 알아봐야 합니다.
//@Component 어노테이션이 지정 되면 해당 객체는 Bean으로 등록되고 스프링 컨테이너가 해당 Bean을 관리하게 됩니다.
//해당 기능을 스프링에서는 컴포넌트 스캔이라고 말합니다.

// @Controller
// @Controller라고 명시가 되면, 해당 클래스는 @Component에 의해 자동으로 Bean이 등록 됩니다.
// 클라이언트가 특정 요청을 하게 되면 처리하기 위해서 스프링은 제일 먼저 해당하는 Controller를 찾게 되는데
// 이때 @Controller라고 명시된 클래스들을 탐색합니다. 그리고 난 다음에 Mapping주소가 일치하는 메소드의 내용을 실행하게 됩니다.
//추가적으로 @RestController가 존재하는데, 요 아이는 @ResponseBody 사용한것과 동일하게
// View를 반환하는게 아닌 객체(보통 JSON) 를 반환하게 된다.

// @Service
//@Service 라고 명시된 클래스는 비지니스 로직에 대한 정보들이 담겨 있어야 합니다.
// 즉 사용자의 요청에 따라서 DB에 접근하여 데이터를 추가, 삭제, 수정, 선택과 같은 요청을 처리할 수 있어야 합니다.
// 프로젝트의 규모가 커질수록 Service에 대한 내용이 매우 방대해지니,
// 처음에 설계할때 비슷한 서비스끼리 잘 나눠서 정리해야합니다. 유지보수 및 기능확장 측면에서 매우 유용합니다.

// @Repository
// @Repository라고 명시되있으면 DB에 접근을 하는 객체입니다.
// @Repository 어노테이션은 해당 객체는 DB에서 CRUD와 같은 명렁을 하게 되며,
// 간단하게 DB 접근이 가능한 객체라고 생각하면 됩니다.

// 그러면 bean이 무엇인가?
// Spring IoC 컨테이너가 관리하는 자바 객체
// Spring에서는 직접 new를 이용하여 생성한 객체가 아니라, 필요한 객체를 생성하고 객체에 의존을 주입한다.
// Spring에 의하여 생성되고 관리되는 자바 객체를 Bean이라 한다

@Component
public class C {

    @Autowired(required = false)
    private D d;

    public void cCall() {
        System.out.println("C 객체에서 메서드 호출");
        d.dCall();
    }
}
