package com.nguyenkunquan.interchange.controller;

import com.nguyenkunquan.interchange.model.Supplier;
import com.nguyenkunquan.interchange.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/list")
    public String getlist(Model model) {
        model.addAttribute("supList", supplierService.getList());
        return "supplier/list";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("newSup", new Supplier());
        return "supplier/save";
    }
    @PostMapping("/savechanges")
    public String saveChanges(@ModelAttribute Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:list";
    }

}
