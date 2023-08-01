package com.studentdata.studentdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import lombok.AllArgsConstructor;





@Controller
@AllArgsConstructor  // check what it do, it uses lombok(lib).
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index() {
        //Task 6: Implement the Index Controller
        // if the user access url:/ , automatically redirect to student.html
        return "students";  // todo: it's now only working when i use students:, replace: redirect:/students
    }
     
}
