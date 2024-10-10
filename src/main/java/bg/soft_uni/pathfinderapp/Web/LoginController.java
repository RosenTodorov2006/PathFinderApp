package bg.soft_uni.pathfinderapp.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("users/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        modelAndView.addObject("invalidData", false);
        return modelAndView;
    }
    @GetMapping("users/login-error")
    public ModelAndView loginError(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        modelAndView.addObject("invalidData", true);
        return modelAndView;
    }
}
