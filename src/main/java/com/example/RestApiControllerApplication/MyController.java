package com.example.RestApiControllerApplication;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MyController {

    Map<Integer, User> users = new HashMap<>();
    @GetMapping("/get_user")
    public List<User> getUsers(){
        List<User> listOfUsers = new ArrayList<>();
        for(User user : users.values())
            listOfUsers.add(user);
        return listOfUsers;
    }
    @GetMapping("/get_users/{id}")
    public User getUser(@PathVariable("id") int id){
        return users.get(id);
    }
    @PostMapping("/add_user")
    public void addUser(@RequestParam("id") int id, @RequestParam("name") String name,
                        @RequestParam("country") String country, @RequestParam("age") int age){
        User user = new User(id, name, country, age);
        users.put(id, user);
    }
    @PostMapping("/add_user_body")
    public void addUserBody(@RequestBody(required = true) User user){
        users.put(user.getId(), user);
    }
    @PutMapping("update_user")
    public void updateUser(@RequestParam("id") int id, @RequestParam("name") String name,
                           @RequestParam("country") String country, @RequestParam("age") int age){
        User user = new User(id, name, country, age);
        users.put(id, user);
    }
    @PutMapping("update_users/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody(required = true)User user){
        users.put(id, user);
    }
    @DeleteMapping("/delte_user")
    public void deleteUser(@RequestParam("id") int id){
        users.remove(id);
    }
    @DeleteMapping("/delte_users/{id}")
    public void deleteUsers(@PathVariable("id") int id){
        users.remove(id);
    }

}
