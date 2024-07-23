package com.study.rest.controller;

import com.study.rest.dto.ReqProductDto;
import com.study.rest.dto.ReqStudentDto;
import com.study.rest.dto.ReqTeacherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Rest API : 데이터 통신(요청, 응답)만 하는 API들의 집합이다.
@Slf4j // 로그를 찍을 때 쓰는 라이브러리
@RestController // 데이터만 요청하고 데이터만 응답받는 형태 (Responsebody 쓰기 귀찮아서 사용) - view리턴 안하는 것- JSON형태로 응답
                // Controller + Responsebody 합쳐놓은것 -> 경로 타고 들어가면 보임)
public class BasicController {

    /**
     * REST API
     * 데이터 통신을 위한 HTTP 요청 방식
     * HTTP(프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
     * 1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자
     *  - 데이터 추가(등록)은  POST 요청으로 하자. 그리고 post 요청은 JSON 데이터로 요청하자.
     *  - 데이터 조회는 GET 요청으로 하자.
     *      그리고 GET 요청은 QueryString(Params)으로 요청하자
     *      예) 주소?key1=value&key2=value2 <- queryString 형태
     *  - 데이터 수정은 PUT, Patch 요청으로 하자, JSON으로 요청하자
     *      PUT 요청과 PATCH 요청의 차이점
     *      * PUT 요청: 공백 또는 NULL인 데이터도 수정을 함.
     *      * PATCH 요청: 공백 또는 NULL은 수정하지 않음. - 공백이나 NULL 데이터가 넘어오면 기존 데이터가 수정되지 않음 반대도 마찬가지
     *      * 사실 둘다 공백과 NULL을 받을 수 있는데(둘다 같은 기능) 개발자끼리의 약속임(구별을 위한 목적).
     *  - 데이터 삭제는 DELETE 요청으로 하자. params로 요청하자
     * 2. 주소(URL) 요청 메세지(Resource) 자원 작성법
     *  - URL은 가능한 동사를 사용하지 않는다
     *  - 계층 구조로 작성한다.
     *      예) /집/주방/가스레인지, /식당/주방/가스레인지
     *  - 요청 메소드 마다 작성하는 방법이 다르다
     *      예) 상품 등록(POST) /product
     *          상품 하나(단건) 조회(GET) /product/1(id or key값)
     *          상품 여러개(다건) 조회(GET) /products(전체), /products?page=2&count=30(한 페이지에 30개 조회)
     *          상품 수정(PUT) /product/1(id, key) 1번 상품을 수정해라.
     *          상품 삭제(DELETE) /product/1(id, key)
     * 3. 주소는 가능한 대문자를 사용하지 않는다.
     *
     */

    @CrossOrigin
    @PostMapping("/basic/student")
    // ResponseEntity : 응답 객체(response)를 들고와줄 수 있는 것 - 응답에 대한 정보들을 담고 있음
    // 응답 데이터의 타입이 여러개(객체, 리스트 등등) 형태로 올 수 있기 때문에 ?로
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) { // JSON 형태로 요청 올때는 무조건 @RequestBody를 무조건 써야함
        log.info("reqStudent: {}", reqStudentDto); // 중괄호 안으로 reqStudentDto 값이 들어감 - 로그로 출력해주는것
        // sout대신 이것을 씀 : sout안쓰는 이유 : sout은 서버가 모든 요청에 대한 것들을 콘솔창에 전부 띄어줌
        // log.info 를 사용하면 내가 서버를 시작하고 종료될 때까지의 로그 내용들을 파일로 기록(저장)시켜줌 - 나중에 개발자들이 검색해서 찾을 수 있음
        return ResponseEntity.badRequest().body(null); // ok : 상태코드가 200(잘 실행됨)이라는 뜻
    }

    @CrossOrigin
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> basicPost2(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("reqTeacher: {}", reqTeacherDto);
        return ResponseEntity.ok().body("잘 들어왔습니다.");
    }

    @CrossOrigin
    @PostMapping("/basic/product")
    public ResponseEntity<?> responseProduct(@RequestBody ReqProductDto reqProductDto) {
        log.info("{}", reqProductDto);
        return ResponseEntity.ok().body(null);
    }
}
