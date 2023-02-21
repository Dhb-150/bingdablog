package love.dabing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author DHB
 * @version 1.0
 * Create by 2023/1/28 19:40
 */

@Controller
@RequestMapping("/")
public class DemoController {


    @RequestMapping("/")
    public String ll(Model model){
        model.addAttribute("UserName","大冰");
        return "index";
    }

    @RequestMapping("/user")
    public String userIndex(Model model){
        model.addAttribute("Welcome","Hello World!");
        return "user";
    }
}
