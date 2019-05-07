package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

//    @GetMapping("/add/{num1}/and/{num2}")
//    @ResponseBody
//    public int addition(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
//        return num1 + num2;
//    }

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable Integer num1, @PathVariable Integer num2) {

        return String.valueOf(num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtraction(@PathVariable Integer num1, @PathVariable Integer num2) {
        return String.valueOf(num2 - num1);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplication(@PathVariable Integer num1, @PathVariable Integer num2) {

        return String.valueOf(num1 * num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public double division(@PathVariable double num1, @PathVariable double num2) {

        return num1 / num2;
    }

}
