package controller;

import com.alibaba.fastjson.JSONObject;
import model.Car;
import model.ResultInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import repository.ErrorInfo;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import static org.springframework.http.HttpStatus.*;
import static repository.ErrorInfo.*;
import static repository.ErrorInfo.request_checkcode_too_soon;

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

    @RequestMapping("/home1")
    @ResponseBody
    @ResponseStatus(value = BAD_REQUEST)
    ResultInfo err(){
        return new ResultInfo(ErrorInfo.request_checkcode_too_soon);
    }
}
