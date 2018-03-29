package jp.co.tlzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorld {
	    @RequestMapping("/index")
	    public ModelAndView index(HttpServletRequest request){
	    	ModelAndView ma = new ModelAndView("helloWorld");
			ma.addObject("title", "helloWorld Demo");
		    ma.addObject("message", "这是测试用的 Demo");
	        return ma;
	}
}
