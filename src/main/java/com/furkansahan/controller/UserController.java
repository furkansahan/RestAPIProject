package com.furkansahan.controller;

import com.furkansahan.model.User;
import com.furkansahan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    ///////
    // @NamedQuery part
//
    @GetMapping("/")
    public List<User> getUserByName(Model model){
        return userService.getAllUsers();
    }

    ////

    @RequestMapping("/users")
    public List<User> getAllUsers(){
       return userService.getAllUsers();

    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public User saveUser( @RequestBody User user) {
        return  userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/users/{id}")
    public User updateUser(Long id, User user) {
        return userService.updateUser(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{id}")
    public void deleteUser(Long id) {
        userService.deleteUser(id);

    }

}
