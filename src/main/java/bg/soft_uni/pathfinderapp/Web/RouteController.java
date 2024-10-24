package bg.soft_uni.pathfinderapp.Web;

import bg.soft_uni.pathfinderapp.Services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public ModelAndView allRoutes(ModelAndView modelAndView){
        modelAndView.addObject("routes", routeService.getAllRoutes());
        modelAndView.setViewName("routes");
        return modelAndView;
    }
}
