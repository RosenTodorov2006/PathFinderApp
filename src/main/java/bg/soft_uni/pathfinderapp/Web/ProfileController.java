package bg.soft_uni.pathfinderapp.Web;

import bg.soft_uni.pathfinderapp.Model.Entities.User;
import bg.soft_uni.pathfinderapp.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/profile")
    public ModelAndView profile(Principal principal, ModelAndView modelAndView) throws IllegalAccessException {
        User userByUsername = this.userService.findUserByUsername(principal.getName());
        modelAndView.addObject("user", userByUsername);
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
