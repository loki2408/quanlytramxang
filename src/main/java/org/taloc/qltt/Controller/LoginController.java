package org.taloc.qltt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // This returns the login.html template
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // This returns the index.html template after a successful login
    }
}
