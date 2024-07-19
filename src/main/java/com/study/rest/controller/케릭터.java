package com.study.rest.controller;

import com.study.rest.di.무기;
import com.study.rest.di.방패;
import com.study.rest.di.칼;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.TypedValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class 케릭터 {

    @Autowired
    @Qualifier("총")   // 무기를 총으로 받겠다 -> 안적으면 총과 칼 중에서 뭘 넣어야할지 컴퓨터가 정하지 못함
    private 무기 weapon;
    @Autowired
    @Qualifier("물리공격방패")
    private 방패 shield;

    @Autowired
    private TypedValue typedValue;

    
    @ResponseBody
    @GetMapping("/maple/attack")
    public Object mapleattack() {
//        weapon = new 칼(); // 이러면 결합도가 높은 코드가 됨 그래서 위에서 생성자를 통해 메소드를 주입 받아야한다
        weapon.공격();
        return null;
    }
    
    @ResponseBody
    @GetMapping("/maple/defence")
    public Object mapleshield() {
        shield.방어();
        return null;
    }
}
