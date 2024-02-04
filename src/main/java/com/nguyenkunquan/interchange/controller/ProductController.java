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
    public String saveChanges(@ModelAttribute Product product, @RequestParam int supID, @RequestParam float price,
                              @RequestParam boolean isCustomizedLength, @RequestParam boolean isCustomizedWidth, @RequestParam boolean isCustomizedHeight) {
        int id = productService.save(product);
        product.setProductId(id);
        productService.insertSupplierProduct(supID, product.getProductId(), price);
        productService.insertIsCustomized(id, isCustomizedLength, isCustomizedWidth, isCustomizedHeight);
        return "redirect:list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int proID, Model model) {
        model.addAttribute("proDetail", productService.getDetailByID(proID));
        model.addAttribute("isCustomized", productService.getIsCustomizedByID(proID));
        return "product/detail";
    }
    @GetMapping("/update")
    public String update(@RequestParam int proID, Model model) {
        model.addAttribute("pro", productService.getByID(proID));
        model.addAttribute("supList", supplierService.getList());
        model.addAttribute("materialList", productService.getMaterialProduct());
        model.addAttribute("categoryList", productService.getCategoryProduct());
        return "product/save";
    }
}
