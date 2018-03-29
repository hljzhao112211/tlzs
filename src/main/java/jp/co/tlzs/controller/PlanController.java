package jp.co.tlzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class PlanController {
    @RequestMapping("")
    public String list(Model model){
        return "table";
    }

    @RequestMapping(value = "plan",method = RequestMethod.GET)
    public String planForm(Model model){
        return "forms";
    }
}
