package com.klu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    // Mapping for root URL
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home"); // Looks for home.jsp in /WEB-INF/views/
    }

    // Mapping for demo1
    @GetMapping("/demo1")
    public ModelAndView demo1() {
        return new ModelAndView("admin"); // Looks for admin.jsp in /WEB-INF/views/
    }

    // Mapping for demo2
    @GetMapping("/demo2")
    public ModelAndView demo2() {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("name", "klu");
        return modelAndView;
    }

    // Mapping for demo3
    @GetMapping("/demo3")
    public ModelAndView demo3() {
        ModelAndView modelAndView = new ModelAndView("about");
        modelAndView.addObject("msg", "Hello World");
        return modelAndView;
    }

    // Mapping for demo4: Returns plain text as response body
    @GetMapping("/demo4")
    @ResponseBody
    public String demo4() {
        return "JFSD";
    }
    
    //http://localhost:8080/Experiment5/demo5?a=10&b=20
    @GetMapping("/demo5")
    @ResponseBody
    public String demo5(@RequestParam("a") int a, @RequestParam("b") int b) {
        int sum = a + b;
        return "The sum is: " + sum;
    }
    
    //http://localhost:8080/Experiment5/demo6/Manasa/Eamani
    @GetMapping("/demo6/{fname}/{lname}")
    public ModelAndView demo6(@PathVariable("fname") String firstName, @PathVariable("lname") String lastName) {
        String fullName = firstName + " " + lastName;
        ModelAndView modelAndView = new ModelAndView("demo"); // The view should be demo.jsp
        modelAndView.addObject("name", fullName);
        return modelAndView;
    }
}
