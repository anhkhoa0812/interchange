package com.nguyenkunquan.interchange.service;

import com.nguyenkunquan.interchange.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductService {
    Product getByID(int id);
    int save(Product product);
    ArrayList<Product> getList();
    List<Map<String, Object>> getMaterialProduct();
    List<Map<String, Object>> getCategoryProduct();
    void insertSupplierProduct(int supID, int proID, float price);
    List<Map<String, Object>> getDetailsList();
    void insertIsCustomized(int productID, boolean length, boolean width, boolean height);
    Map<String, Object> getDetailByID(int id);
    Map<String, Object> getIsCustomizedByID(int id);
}
