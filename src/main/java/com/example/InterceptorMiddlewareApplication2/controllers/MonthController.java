package com.example.InterceptorMiddlewareApplication2.controllers;

import com.example.InterceptorMiddlewareApplication2.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthController {

    @GetMapping("/months")
    public Month getMonth(@RequestAttribute("month") Month month) {
        return month;
    }
}
