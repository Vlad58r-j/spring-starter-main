package com.vlad.spring.http.controller;

import com.vlad.spring.database.entity.Role;
import com.vlad.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.util.Arrays.*;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles() {
        return asList(Role.values());
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET) -> менее актуально
    @GetMapping(value = "/hello")
    public String hello(Model model, HttpServletRequest request, UserReadDto userReadDto) {
//        model.addAttribute("user", new UserReadDto(1L, "Ivan"));

        return "greeting/hello";
    }

    @GetMapping(value = "/bye")
    public String bye(@SessionAttribute("user") UserReadDto user) {

        return "greeting/bye";
    }

    @GetMapping(value = "/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @CookieValue("JSESSIONID") String jsessionId,
                              @PathVariable Integer id) {
        var ageParamValue = request.getParameter("age");
        var acceptHeader = request.getHeader("accept");
        var cookies = request.getCookies();
        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }


}
