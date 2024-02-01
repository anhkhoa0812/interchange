package com.nguyenkunquan.interchange.service;

import com.nguyenkunquan.interchange.model.Supplier;

import java.util.ArrayList;

public interface SupplierService {
    ArrayList<Supplier> getList();
    void save(Supplier supplier);
}
