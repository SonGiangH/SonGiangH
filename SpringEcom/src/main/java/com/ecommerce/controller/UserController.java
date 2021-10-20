package com.ecommerce.controller;

import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import com.ecommerce.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Autowired with Constructor injection
    private final UserValidator userValidator;

    private final UserService userService;

    @Autowired
    public UserController(UserValidator userValidator, UserService userService) {

        this.userValidator = userValidator;
        this.userService = userService;
    }

    // ADD USER
    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String addUser(HttpServletRequest request) {

        request.setAttribute("user",new User());            // Add user thi truyen sang 1 doi tuong new User trang

        return "user/addUser";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request,
                          @ModelAttribute("user") User user,
                          BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {                    // Dung bien BindingResult de kiem tra loi
            return "user/addUser";                          // Neu co loi thi tra ve trang add user
        }
        userService.addUser(user);

        return "redirect:/all-user";
    }

    // LIST ALL USERS
    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    public String listUser(HttpServletRequest request) {

        List<User> users = userService.getAllUser();

        request.setAttribute("users",users);

        return "user/listUser";                      // listUser.jsp nam trong folder User
    }

    // DETAIL USER
    @RequestMapping(value = "/user-detail/{userId}", method = RequestMethod.GET)
    public String detailUser(HttpServletRequest request,
                             @PathVariable(name = "userId") int userId) {
        request.setAttribute("user", userService.getUserById(userId));

        return "user/viewUser";
    }

    // DELETE USER BY ID
    @RequestMapping(value = "/delete-user/{userId}", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request,
                             @PathVariable(name = "userId") int userId) {
        userService.deleteUserById(userId);

        return "redirect:/all-user";
    }

    // EDIT USER
    @RequestMapping(value = "/update-user/{id}", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request,
                             @PathVariable(name = "id") int userID) {

        User userUpdate = userService.getUserById(userID);       // lay user by Id muon edit trong database ra, gan vao userUpdate

        request.setAttribute("userUpdate", userUpdate);

        return "user/updateUser";
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public String updateUser(HttpServletRequest request,
                             @ModelAttribute("userUpdate") User userUpdate,
                             BindingResult bindingResult) {

        userValidator.validate(userUpdate, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/updateUser";
        }
        userService.UpdateUser(userUpdate);

        return "redirect:/all-user";
    }
}
