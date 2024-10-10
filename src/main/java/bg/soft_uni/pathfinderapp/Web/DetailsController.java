package bg.soft_uni.pathfinderapp.Web;

import bg.soft_uni.pathfinderapp.Services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetailsController{
    private final RouteService routeService;

    public DetailsController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes_details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("route", this.routeService.getRouteById(id));
        return "route-details";
    }

}
