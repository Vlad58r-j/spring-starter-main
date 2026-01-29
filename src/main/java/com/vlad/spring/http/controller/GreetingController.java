package com.vlad.spring.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
public class GreetingController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET) -> менее актуально
    @GetMapping(value = "/hello")
    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }

    @GetMapping(value = "/bye")
    public ModelAndView bye() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting/bye");

        return modelAndView;
    }


}
