package com.study.rest.service;

import com.study.rest.dto.CommonResponseDto;
import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.dto.RespGetListDto;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl {

    @Autowired
    private ComputerMapper computerMapper;

    public int registerCount(ReqRegisterComputerDto reqDto) {
        Computer computer = Computer.builder() // save() 안에 객체가 들어가야해서 여기서 computer 객체를 하나 만듦
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();

        return computerMapper.save(computer);
    }

//    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
//        List<RespGetListDto> respDtos = new ArrayList<>();
//
//        Computer computer = Computer.builder()
//                .company(reqDto.getCompany())
//                .cpu(reqDto.getCpu())
//                .build();
//
//        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);
//
//        for(Computer com : computers) {
//            RespGetListDto dto = RespGetListDto.builder()
//                    .computerId(com.getComputerId())
//                    .company(com.getCompany())
//                    .build();
//
//            respDtos.add(dto);
//        }
//
//        return respDtos;
//    }

    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {

        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .build();

        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);

        return computers.stream().map(com => RespGetListDto.builder()
                .computerId(com.getComputerId())
                .company(com.getCompany())
                .build()
        ).collect(Collectors.toList());
    }
}
