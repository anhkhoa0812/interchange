package com.nguyenkunquan.interchange.controller;

import com.nguyenkunquan.interchange.model.Product;
import com.nguyenkunquan.interchange.service.ProductService;
import com.nguyenkunquan.interchange.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    SupplierService supplierService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("proList", productService.getDetailsList());
        return "product/list";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("pro", new Product());
        model.addAttribute("supList", supplierService.getList());
        model.addAttribute("materialList", productService.getMaterialProduct());
        model.addAttribute("categoryList", productService.getCategoryProduct());
        return "product/save";
    }
    @PostMapping("/savechanges")
    public String saveChanges(@ModelAttribute Product product, @RequestParam int supID, @RequestParam float price) {
        int id = productService.save(product);
        product.setProductId(id);
        productService.insertSupplierProduct(supID, product.getProductId(), price);
        return "redirect:list";
    }
}
