package com.recipe.recipe_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

    @GetMapping("/")
    public ModelAndView mainPage(){
        ModelAndView mv =  new ModelAndView("/chat/chatLayout");
        mv.addObject("name","안녕하세요.");
        return mv;
    }
}
