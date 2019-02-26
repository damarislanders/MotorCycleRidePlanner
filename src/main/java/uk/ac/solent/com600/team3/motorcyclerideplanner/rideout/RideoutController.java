package uk.ac.solent.com600.team3.motorcyclerideplanner.rideout;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/rideout")
public class RideoutController {
    private final RideoutService service;

    public RideoutController(RideoutService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("rideouts", service.rideouts());
        return "rideout/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Rideout rideout = service.rideout(id).orElse(null);
        if (rideout == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        model.addAttribute("rideout", rideout);
        return "rideout/edit";
    }

    @PostMapping("/{id}/edit")
    public String editSubmit(@ModelAttribute Rideout rideout) {
        service.edit(rideout);
        return "redirect:/rideout";
    }
}
