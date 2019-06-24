package main.java.org.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    public MainController() {
        logger.info("Controller created");
//        System.out.println("Controller created");
    }

    @RequestMapping("get-some-data")
    @ResponseBody
    public String[] getSomeData() {
        logger.info("Controller method invoked");
//        System.out.println("Controller method invoked");
        return new String[]{"1111", "2222", "333"};
    }
}
