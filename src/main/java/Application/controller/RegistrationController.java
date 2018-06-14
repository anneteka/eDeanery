package Application.controller;

import Application.model.Users;
import Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping ("/registration")
    public String getRegistrationPage(Model model) {
        List<Users> users = userService.findAll();
        model.addAttribute("userRequests", users);
        return "registration";
    }

    @PostMapping("/registration")
    public String getRegistrationPage(HttpServletRequest request, Model model) {
        Users user = new Users(request.getParameter("firstName"),request.getParameter("lastName")
        ,request.getParameter("password"),request.getParameter("email"));
       userService.save(user);
        List<Users> users = userService.findAll();
        model.addAttribute("users", users);
        return "registration";
    }
}