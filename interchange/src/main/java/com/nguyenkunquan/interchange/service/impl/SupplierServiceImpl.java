package com.nguyenkunquan.interchange.service.impl;

import com.nguyenkunquan.interchange.model.Supplier;
import com.nguyenkunquan.interchange.repository.SupplierRepository;
import com.nguyenkunquan.interchange.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public ArrayList<Supplier> getList() {
        return (ArrayList<Supplier>) supplierRepository.findAll();
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
