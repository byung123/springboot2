package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.dto.ReqUpdateComputerDto;
import com.study.rest.service.ComputerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1") // 이걸 하면 모든 mapping 주소앞에 자동으로 할당 된다는 뜻이다
public class ComputerController {

    @Autowired
    private ComputerServiceImpl computerService;

    @PostMapping("/computer") // 자동으로 /api/v1/computer로 연결시켜줌 (맨 위에 RequestMapping으로 인해)
    public ResponseEntity<?> registerApi(@RequestBody ReqRegisterComputerDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.registerCount(reqDto));
    }

    @PutMapping("/computer/{computerId}")
    public ResponseEntity<?> modifyApi(@PathVariable int computerId, @RequestBody ReqUpdateComputerDto reqDto) {
        return ResponseEntity.ok().body(computerService.updateComputer(reqDto));
    }

    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ReqGetListDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.getComputerList(reqDto));
    }

    // PathVariable: 경로 변수를 표시하기 위해 메서드 매개변수로 사용한다는 뜻
    // 경로 변수 : 중괄호{}로 둘러싸인 값을 나타낸다
    // URL 경로에서 변수 값을 추출하여 매개변수에 할당한다
    // 기본적으로 경로변수는 반드시 값을 가져야하며, 값이 없는 경우 404에러가 발생한다
    // 주로 조회, 수정, 삭제와 같은 작업에서 리소스 식별자로 사용된다
    // http://localhost:8080/api/v1/computer/3 이런식으로 날림
    @GetMapping("/computer/{computerId}")
    public ResponseEntity<?> getApi(@PathVariable int computerId) { // 위의 어노테이션 computerId값을 인수로 받음(자료형 같게 하기)
        log.info("{}", computerId);
        return ResponseEntity.ok().body(computerService.getComputer(computerId));
    }

    @DeleteMapping("/computer/{computerId}")
    public ResponseEntity<?> removeApi(@PathVariable int computerId) {
        return ResponseEntity.ok().body(computerService.deleteComputer(computerId));
    }

}
