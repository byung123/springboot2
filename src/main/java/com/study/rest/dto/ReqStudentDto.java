package com.study.rest.dto;

import lombok.Data;
import lombok.ToString;

// getter, setter를 통해서 값이 전달 받음??
@Data // 백엔드에서 데이터를 전달받을 때 JSON 형태로 받기 때문에 이 어노테이션을 꼭 백엔드에서 사용해야한다.라고하심??
public class ReqStudentDto {
    private String schoolName;
    private String department;
    private int grade;
    private String name;
}
