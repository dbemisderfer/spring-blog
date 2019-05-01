package com.codeup.blog;

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
    public int addition(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtraction(@PathVariable int num1, @PathVariable int num2) {
        return num2 - num1;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiplication(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public int division(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2;
    }

}
