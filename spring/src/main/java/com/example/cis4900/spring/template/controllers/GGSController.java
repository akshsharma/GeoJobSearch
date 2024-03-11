package com.example.cis4900.spring.template.controllers;

import java.util.List;
import java.util.Vector;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/ggs")
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

    @GetMapping("/hardCodedJSON") // hard coded JSON
    public String getHardCodedJSON(){
        // Vector<JSONObject> myVector = new Vector<String>();
        // myVector.add("{\"Job Title\": \"Software Engineer\"}");
        // myVector.add("lafjeklajfljfakl");
        String myString = "{\r\n" + //
                        "  \"jobs\":\r\n" + //
                        "  [\r\n" + //
                        "      {\r\n" + //
                        "          \"job\": {\r\n" + //
                        "              \"job_id\":\"1\",\r\n" + //
                        "              \"job_title\":\"Software Engineer\",\r\n" + //
                        "              \"job_description\":\"Develop and maintain software applications\",\r\n" + //
                        "              \"job_location\":\"New York\",\r\n" + //
                        "              \"job_salary_min\":60000.00,\r\n" + //
                        "              \"job_salary_max\":80000.00\r\n" + //
                        "          },\r\n" + //
                        "          \"employer\": {\r\n" + //
                        "              \"employer_name\":\"ABC Company\"\r\n" + //
                        "          }\r\n" + //
                        "      },\r\n" + //
                        "      {\r\n" + //
                        "          \"job\": {\r\n" + //
                        "              \"job_id\":\"2\",\r\n" + //
                        "              \"job_title\":\"Hardware Engineer\",\r\n" + //
                        "              \"job_description\":\"Develop and maintain computer hardware\",\r\n" + //
                        "              \"job_location\":\"Toronto\",\r\n" + //
                        "              \"job_salary_min\":70000.00,\r\n" + //
                        "              \"job_salary_max\":90000.00\r\n" + //
                        "          },\r\n" + //
                        "          \"employer\": {\r\n" + //
                        "              \"employer_name\":\"XYZ Company\"\r\n" + //
                        "          }\r\n" + //
                        "      },\r\n" + //
                        "      {\r\n" + //
                        "          \"job\": {\r\n" + //
                        "              \"job_id\":\"3\",\r\n" + //
                        "              \"job_title\":\"Tech Support\",\r\n" + //
                        "              \"job_description\":\"Provide technical support to users\",\r\n" + //
                        "              \"job_location\":\"Boston\",\r\n" + //
                        "              \"job_salary_min\":50000.00,\r\n" + //
                        "              \"job_salary_max\":70000.00\r\n" + //
                        "          },\r\n" + //
                        "          \"employer\": {\r\n" + //
                        "              \"employer_name\":\"123 Company\"\r\n" + //
                        "          }\r\n" + //
                        "      }\r\n" + //
                        "   ]\r\n" + //
                        "}" + //
                        "";

        return myString;
    }
}