package bg.soft_uni.pathfinderapp.Web;
import bg.soft_uni.pathfinderapp.Model.Dtos.RegisterSeedDto;
import bg.soft_uni.pathfinderapp.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register(Model model){
        if(!model.containsAttribute("registerSeedDto")){
            model.addAttribute("registerSeedDto", new RegisterSeedDto());
        }
        return "register";
    }
    @PostMapping("/users/register")
    public String peopleInfo(@Valid RegisterSeedDto registerSeedDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        boolean second=!registerSeedDto.getPassword().equals(registerSeedDto.getConfirmPassword());
        boolean third=bindingResult.hasErrors();
        if(second || third){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerSeedDto", bindingResult);
            redirectAttributes.addFlashAttribute("registerSeedDto", registerSeedDto);
            return "redirect:/users/register";
        }else{
            this.userService.addUser(registerSeedDto);
            return "redirect:login";
        }
    }

}
