package org.demo.web;

import org.demo.domains.Bird;
import org.demo.exceptions.ApplicationLogicException;
import org.demo.response.BaseResponse;
import org.demo.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    public MainController() {
        System.out.println("Controller created");
    }

    @RequestMapping(value = {"/main/get-some-data", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<String[]> getSomeData(Integer param1, Double param2, String param3) throws ApplicationLogicException {
        System.out.println("Controller method invoked");
        if (param1 == null) {
            throw new ApplicationLogicException("Param param1 is null");
        } else if (param2 == null) {
            throw new RuntimeException("Param2 is null");
        }
        SuccessResponse<String[]> response = new SuccessResponse<String[]>();
        response.setData(new String[]{"1111", "2222", "333"});
        return response;
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

    @ExceptionHandler(ApplicationLogicException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleApplicationLogicException() {
        return "Some error happens.";
    }
}
