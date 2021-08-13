package com.mastery.java.task.rest;


import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("users", employeeService.findAll());
        return "homePage";

    }

    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> Params, Model model) {
        try {
            model.addAttribute("users", employeeService.SearchById(Long.parseLong(Params.getOrDefault("id", "0"))));
            return "search";
        } catch (NumberFormatException e) {
            return "search";
        }

    }

    @PostMapping("/remove/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add(@RequestParam Map<String, String> Params) {
        if (employeeService.edit(Params)) {
            return "redirect:/";
        }
        return "add";
    }
}
