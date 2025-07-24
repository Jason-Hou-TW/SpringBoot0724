package com.example.demo4.controller;

import com.example.demo4.entity.Beverage;
import com.example.demo4.form.BeverageForm;
import com.example.demo4.repository.BeverageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeverageController {

    @Autowired
    BeverageRepository repository;

    @GetMapping("/beverages/all")
    public String getAllBeverage(Model model) {
        model.addAttribute("beverages", repository.findByOrderByPriceAsc());
        return "beverages/list";
    }

    @GetMapping("/beverages/add")
    public String showAddBeverage(Model model) {
        BeverageForm f  = new BeverageForm();
        model.addAttribute("form", f);
        return "beverages/add";
    }

    @PostMapping("/beverages/add")
    public String AddBeverageAndShow(BeverageForm form) {
        Beverage beverage = new Beverage();
        BeanUtils.copyProperties(form,beverage);
        repository.save(beverage);
        return "redirect:/beverages/all";
    }

    @GetMapping("/beverages/delete")
    public String delAction(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/beverages/all";
    }

    @GetMapping("/beverages/modify")
    public String showModifyBeverage(@RequestParam() Long  id,Model model) {
        Beverage b = repository.findById(id).get();
        BeverageForm f = new BeverageForm();
        BeanUtils.copyProperties(b, f);
        model.addAttribute("form", f);
        return "beverages/modify"; // need to do later
    }

    @PostMapping("/beverages/modify")
    public String ModifyBeverageAndShow(BeverageForm form) {
        Beverage beverage = new Beverage();
        BeanUtils.copyProperties(form,beverage);
        repository.save(beverage);
        return "redirect:/beverages/all";
    }
}
