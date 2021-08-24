package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping(path = "/", produces = "application/json;charset=UTF-8")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String indexUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/user/{id}")
    public String usersId(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @PatchMapping(value = "/user/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String showNewUserPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "createuser";
    }

    @PostMapping(value = "/newuser")
    public String createUser(@ModelAttribute("user") User user, ModelMap model) {
        if (user != null) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
        }
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}")
    public String deletUser(@PathVariable("id") int id) {
        System.out.println(id);
        userService.removeUserById(id);
        return "redirect:/";
    }
}