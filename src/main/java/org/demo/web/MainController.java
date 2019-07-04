package org.demo.web;

import org.demo.domains.Bird;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    public MainController() {
        System.out.println("Controller created");
    }

    @RequestMapping(value = {"/main/get-some-data", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public String[] getSomeData(Integer param1, Double param2, String param3) {
        System.out.println("Controller method invoked");
        return new String[]{"1111", "2222", "333"};
    }

    @RequestMapping(value = "main/add-new-bird", method = RequestMethod.PUT)
    @ResponseBody
    public Bird addNewBird(String name) {
        Bird b = new Bird();
        b.setName(name);
        //generate id
        b.setId(1);
        return b;
    }
}
