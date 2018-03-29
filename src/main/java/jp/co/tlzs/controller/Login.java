package jp.co.tlzs.controller;

import jp.co.tlzs.po.User;
import jp.co.tlzs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class Login {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String loginForm(Model model, HttpServletRequest request, @RequestParam String account){
//      String username = request.getParameter("username");
        String password = request.getParameter("password");
        model.addAttribute("account",account);
        model.addAttribute("password",password);
        User user = userService.login(account);
        if(user == null){
            model.addAttribute("message", "账号不存在");
            return "login";
        }
        if(user.getPassword().equals(password)){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            model.addAttribute("message", "wrong password");
        }
        return "login";
    }

    @RequestMapping(value = "registr",method = RequestMethod.GET)
    public String registr(Model model/*@RequestBody User user*/){
        model.addAttribute("message","bbbbb");
        return "register";
    }

    @RequestMapping(value = "registr",method = RequestMethod.POST)
    public String registrForm(User user){
        String account=user.getAccount();
        String password=user.getPassword();
       // user.setDepartment("it depart");
        if(account!="" && password!=""){
           userService.register(user);

        }
        //model.addAttribute("message","bbbbb");
        return "login";
    }
}
