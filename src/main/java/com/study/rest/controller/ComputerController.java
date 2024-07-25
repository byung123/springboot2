package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
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

    public ResponseEntity<?> modifyApi() {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ReqGetListDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.getComputerList(reqDto));
    }

    public ResponseEntity<?> getApi() {
        return ResponseEntity.ok().body(null);
    }

    public ResponseEntity<?> removeApi() {
        return ResponseEntity.ok().body(null);
    }
}
