package JibberJabber.Posts.controller;

import JibberJabber.Posts.model.User;
import JibberJabber.Posts.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping
    List<User> getAll() {return userService.getAllUsers();}

    User save(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @GetMapping("/{id}")
    User find(@PathVariable Long id) {
        return userService.find(id);
    }

    @GetMapping("/{id}")
    User replace(@RequestBody User newUser, @PathVariable Long id) {
        return userService.replace(newUser, id);
    }

    @GetMapping("/{id}")
    void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
