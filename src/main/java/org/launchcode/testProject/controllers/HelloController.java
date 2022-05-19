package org.launchcode.testProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    //Handles request at path/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "GoodBye, Spring!";
    }

//    //Handles request of the form /hello?name=Launchcode
//    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello,"+name+"!";
//    }


    //Handles thymleaf
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")

    public String hello(@RequestParam String name, Model model){
        String greetText = "Hello, "+ name+ "!";
        model.addAttribute("greeting",greetText);
        return "Hello";
    }

    //Handles thymeleaf
    @GetMapping("hello/{name}")
    public String helloPathParam(@PathVariable String name,Model model){
        String greetText = "Hello, "+ name+ "!!!";
        model.addAttribute("greeting",greetText);
        return "Hello";
    }

//    //Handles request of the form /hello/Launchcode
//    @GetMapping("hello/{name}")
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello,"+name+"!";
//    }

    //Handles request of the form /hello/Launchcode
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    //List of names
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> greetNames = new ArrayList<>();
        greetNames.add("Java");
        greetNames.add("LaunchCode");
        greetNames.add("Fun");
        model.addAttribute("names",greetNames);
        return "hello-list";
    }

}
