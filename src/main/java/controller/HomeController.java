package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Thoughtworks on 15/8/28.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "home";
    }
}
