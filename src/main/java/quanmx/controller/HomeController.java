package quanmx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String homePage() {
        return null;
    }
}
