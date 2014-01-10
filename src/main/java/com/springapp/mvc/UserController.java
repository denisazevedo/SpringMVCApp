package com.springapp.mvc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * User Controller.
 *
 * Created by denisazevedo on 09/01/2014.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
    public String addUser(@ModelAttribute("user") User user) {

        userRepository.save(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String edit(@PathVariable("userId") Long userId, ModelMap model) {
        User user = userRepository.findOne(userId);
        model.addAttribute("user", user);
        model.addAttribute("userId", userId);
        return "editUser";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateUser(@ModelAttribute("user") User user, BindingResult result) {
    public String updateUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {

        userRepository.delete(userRepository.findOne(userId));

        return "redirect:/";
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
//    public @ResponseBody String listUsersJson (ModelMap model) throws JSONException {
    public @ResponseBody String listUsersJson () throws JSONException {
        JSONArray userArray = new JSONArray();
        for (User user : userRepository.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", user.getId());
            userJSON.put("firstName", user.getFirstName());
            userJSON.put("lastName", user.getLastName());
            userJSON.put("email", user.getEmail());
            userArray.put(userJSON);
        }
        return userArray.toString();
    }
}
