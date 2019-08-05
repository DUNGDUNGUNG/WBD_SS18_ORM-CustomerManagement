package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ModelAndView index() {
        return new ModelAndView("list", "customers", customerService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "customers", new Customer());
    }

    @PostMapping("/save")
    public ModelAndView save(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return new ModelAndView("redirect:/list");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("edit", "customers", customerService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return new ModelAndView("redirect:/list");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        return new ModelAndView("delete", "customers", customerService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView remove(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return new ModelAndView("redirect:/list");

    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Long id) {
        return new ModelAndView("view", "customers", customerService.findById(id));
    }

}
