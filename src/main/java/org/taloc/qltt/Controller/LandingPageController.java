package org.taloc.qltt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/")
    public String landingPage() {
        return "landingPage";
    }

    @GetMapping("/map")
    public String viewMap() {
        return "map"; // Replace with your actual map view template
    }
}
