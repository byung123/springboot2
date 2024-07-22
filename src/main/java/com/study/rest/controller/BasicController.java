package com.study.rest.controller;

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
}
