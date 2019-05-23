package com.kpi.markushevskiy.controller;

import com.kpi.markushevskiy.model.Role;
import com.kpi.markushevskiy.model.User;
import com.kpi.markushevskiy.service.AuthService;
import com.kpi.markushevskiy.service.RoleService;
import com.kpi.markushevskiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String add(@RequestParam Map<String, String> allRequestParams, Model model){
        if(userService.find(allRequestParams.get("username"))!=null){
            model.addAttribute("err", "Пользователь с таким ником уже существует");
            return "redirect:/";
        }

        if(!allRequestParams.get("password1").equals(allRequestParams.get("password2"))){
            model.addAttribute("err", "Введенные пароли не совпадают");
            return "redirect:/";
        }

        User user = new User();
        Role role = roleService.find("USER");
        user.setUsername(allRequestParams.get("username"));
        user.setPassword(allRequestParams.get("password1"));
        user.setRole(role);
        user.setEnabled(true);
        userService.add(user);
        authService.add(user.getUsername(), user.getRole().getName());
        return "redirect:/";
    }
}
