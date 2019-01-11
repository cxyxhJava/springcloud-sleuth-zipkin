package com.frank.controller;

import com.frank.entity.Test;
import com.frank.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:29 2019-01-03
 * @ Description：
 * @ Modified By：
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @Autowired
    private TestRepository repository;

    @PostMapping("")
    public String save(){
        repository.save(new Test(System.currentTimeMillis(),LocalDateTime.now().toString(),"HELLO WORLD"));
        return "success";
    }


    @GetMapping("")
    public List<Test> findAll(){
        List<Test> testList = new ArrayList<>();
        Iterable<Test>  testIterable = repository.findAll();
        if (testIterable!=null){
            testIterable.forEach(test ->testList.add(new Test(test.getId(),test.getName(),test.getValue())));
        }
        return testList;
    }

}
