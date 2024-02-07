package com.example.cis4900.spring.template.ggs;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ggs")
public class GGSController {
    // private DummyService dummyService;

    // @Autowired
    // GGSController(DummyService dummyService) {
    //     this.dummyService = dummyService;
    // }

    @GetMapping("/dummyData")
    public List<String> getDummy() {
        // return "hello from ggs!";
        // return dummyService.getDummyData();
        Vector<String> myVector = new Vector<String>();
        myVector.add("one line of data");
        myVector.add("another line of data");
        myVector.add("one final line of data");

        return myVector;
    }
}