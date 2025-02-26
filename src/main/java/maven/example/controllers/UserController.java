package maven.example.controllers;

import maven.example.DAO.UserDAO;
import maven.example.model.User;
import maven.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

//    @PostMapping("/new")
//    public String addUser(@RequestParam("name") String name,
//                          @RequestParam("surname") String surname,
//                          @RequestParam("email") String email, Model model) {
//        User user = new User(name, surname, email);
//        model.addAttribute("user", user);
//        return "userInfo";
//    }

    @RequestMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("usID") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("usID") int id) {
        User user = userService.getUser(id);
        userService.deleteUser(id);
        return "redirect:/";
    }



//    @PostMapping("/delete")
//    public String deleteUser(@RequestParam("id") int id, Model model) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
//
//    @PostMapping("/update")
//    public String updateUser(@RequestParam("id") int id,
//                             @RequestParam("name") String name,
//                             @RequestParam ("surname") String surname,
//                             @RequestParam("email") String email,
//                             Model model) {
//        User user = userService.getUser(id);
//        if(name != null) {user.setName(name);}
//        if(surname != null) {user.setSurname(surname);}
//        if(email!=null){user.setEmail(email);}
//        return "redirect:/users";
//    }

}
