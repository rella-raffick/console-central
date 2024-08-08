package dev.rellaraffick.consolecentral.controllers;


import dev.rellaraffick.consolecentral.records.ConsoleCentralUser;
import dev.rellaraffick.consolecentral.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    List<ConsoleCentralUser> findAll(){
        return userService.getAllUsers();
    }

    @PutMapping("update/{id}")
    ConsoleCentralUser updateUser(@PathVariable Integer id, @RequestBody ConsoleCentralUser user){
        return userService.updateUser(id, user);
    }

    @PostMapping("/create")
    void createUser(@RequestBody ConsoleCentralUser user){
        userService.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
