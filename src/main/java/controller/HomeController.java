package controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.jvm.hotspot.debugger.cdbg.Sym;

/**
 * Created by Thoughtworks on 15/8/28.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    @ResponseBody
    String home(@RequestBody Car car){
        System.out.println("=======" + car.toString());
        return "home";
    }
}
