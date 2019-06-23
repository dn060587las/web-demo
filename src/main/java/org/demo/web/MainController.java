package main.java.org.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("main")
public class MainController {

    public MainController() {
        System.out.println("Controller created");
    }

    @RequestMapping("get-some-data")
    @ResponseBody
    public String[] getSomeData() {
        System.out.println("Controller method invoked");
        return new String[]{"1111", "2222", "333"};
    }
}
