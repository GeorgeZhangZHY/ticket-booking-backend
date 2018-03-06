package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServ userServ;

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "userId") String userId) {
        return userServ.getUser(Integer.parseInt((userId)));
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User newUser) {
        return userServ.applyForNewUser(newUser);
    }

    @PutMapping("/user")
    public User modifyUser(@RequestBody User modifiedUser) {
        return userServ.modifyUser(modifiedUser);
    }
}
