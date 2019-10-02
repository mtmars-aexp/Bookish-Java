
package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.User;
import org.softwire.training.bookish.models.page.UsersPageModel;
import org.softwire.training.bookish.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    ModelAndView users() {


        List<User> users = userService.getAllUsers();

        UsersPageModel usersPageModel = new UsersPageModel();
        usersPageModel.setUsers(users);

        return new ModelAndView("users", "model", usersPageModel);
    }
}

