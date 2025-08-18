package recouvra.example.recouvra.Controller;


import recouvra.example.recouvra.Entity.User;
import recouvra.example.recouvra.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user, Model model) {
        boolean success = userService.register(user);

        if (success) {
            return "redirect:/dashboard";
        } else {

            model.addAttribute("error", "Username or Email already exists");
            return "register";
        }
    }
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "index"; // index.html dans templates/
    }
}
