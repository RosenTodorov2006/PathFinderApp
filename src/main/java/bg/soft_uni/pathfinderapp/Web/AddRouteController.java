package bg.soft_uni.pathfinderapp.Web;
import bg.soft_uni.pathfinderapp.Model.Dtos.AddRouteDto;
import bg.soft_uni.pathfinderapp.Model.Entities.Enums.CategoryType;
import bg.soft_uni.pathfinderapp.Services.RouteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class AddRouteController {
    private final RouteService routeService;

    public AddRouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/new-route")
    public String newRoute(Model model){
        if(!model.containsAttribute("addRouteDto")){
            model.addAttribute(new AddRouteDto());
        }
        model.addAttribute("categories", CategoryType.values());
        return "add-route";
    }
    @PostMapping("/new-route")
    public String newRouteGetInfo(@Valid AddRouteDto addRouteDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  @RequestParam("gpxCoordinates") MultipartFile multipartFile,
                                  Principal principal
                                  ) throws IllegalAccessException {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRouteDto", bindingResult);
            redirectAttributes.addFlashAttribute("addRouteDto", addRouteDto);
            return "redirect:/new-route";
        }
        this.routeService.addRoute(addRouteDto, multipartFile, principal);
        return "redirect:/";
    }
}
