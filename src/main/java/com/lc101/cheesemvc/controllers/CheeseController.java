package com.lc101.cheesemvc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Cheese MVC");
        model.addAttribute("heading", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value ="add", method= RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value ="add", method= RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        if(!cheeseName.isEmpty()) {
            cheeses.put(cheeseName, cheeseDescription);
        }

        return "redirect:";

    }
}


