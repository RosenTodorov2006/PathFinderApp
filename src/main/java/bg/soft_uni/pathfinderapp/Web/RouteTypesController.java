package bg.soft_uni.pathfinderapp.Web;

import bg.soft_uni.pathfinderapp.Services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteTypesController {
    private final RouteService routeService;

    public RouteTypesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("routes/{type}")
    public ModelAndView type(@PathVariable String type, ModelAndView modelAndView){
        modelAndView.addObject("routes",routeService.getByType(type));
        modelAndView.setViewName(type.toLowerCase());
        return modelAndView;
    }
}
