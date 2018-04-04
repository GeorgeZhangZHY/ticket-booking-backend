package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServ userServ;

    @GetMapping("/activate")
    public String activateUser(@RequestParam(value = "userId") int userId) {
        userServ.activateUser(userId);
        return "账号已激活";
    }

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "userId") int userId) {
        return userServ.getUser(userId);
    }

    @PostMapping("/user")
    public User applyForNewUser(@RequestBody User newUser) {
        return userServ.applyForNewUser(newUser);
    }

    @Secured({"ROLE_USER"})
    @PutMapping("/user")
    public User modifyUser(@RequestBody User modifiedUser) {
        return userServ.modifyUser(modifiedUser);
    }
}
