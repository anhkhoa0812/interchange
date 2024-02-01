package com.nguyenkunquan.interchange.service.impl;

import com.nguyenkunquan.interchange.model.Product;
import com.nguyenkunquan.interchange.repository.ProductRepository;
import com.nguyenkunquan.interchange.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public int save(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct.getProductId();
    }

    @Override
    public ArrayList<Product> getList() {
        return (ArrayList<Product>)productRepository.findAll();
    }

    @Override
    public List<Map<String, Object>> getMaterialProduct() {
        return productRepository.getMaterialProduct();
    }

    @Override
    public List<Map<String, Object>> getCategoryProduct() {
        return productRepository.getCategoryProduct();
    }

    @Override
    public void insertSupplierProduct(int supID, int proID, float price) {
        productRepository.insertSupplierProduct(supID, proID, price);
    }

    @Override
    public List<Map<String, Object>> getDetailsList() {
        return productRepository.getDetailsList();
    }

}
