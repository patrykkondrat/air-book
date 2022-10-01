package api;

import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @GetMapping
    public List<User> getAllUsers(){
        return null;
    }

    @GetMapping(value = "/{username}")
    public User getUserByUserName(String username) {
        return null;
    }

    @PostMapping(value = "/admin/{username}/{password}")
    public int addAdmin(String username, String password) {
        return 1;
    }

    @PostMapping(value = "/user/{username}/{password}")
    public int addUser(String username, String password) {
        return 1;
    }

    @PostMapping(value = "/admin/del/{username}/{password}")
    public int delAdmin(String username, String password) {
        return 1;
    }

    @PostMapping(value = "/user/del/{username}/{password}")
    public int delUser(String username, String password) {
        return 1;
    }

    @PostMapping(value = "/chpass/{username}/{password}")
    public int changePassword(String username, String oldPassword, String newPassword) {
        return 1;
    }
}
