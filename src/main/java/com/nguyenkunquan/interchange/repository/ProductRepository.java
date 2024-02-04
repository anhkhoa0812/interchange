package com.nguyenkunquan.interchange.repository;

import com.nguyenkunquan.interchange.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM material_product", nativeQuery = true)
    List<Map<String, Object>> getMaterialProduct();
    @Query(value = "SELECT * FROM category_product", nativeQuery = true)
    List<Map<String, Object>> getCategoryProduct();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO supplier_product(supplier_id, product_id, product_price) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void insertSupplierProduct(int supID, int proID, float price);

    @Query(value = "SELECT i.*, cp.category_name, mp.material_name, s.supplier_name, sp.product_price FROM interior_product i JOIN supplier_product sp ON i.product_id = sp.product_id JOIN supplier s ON sp.supplier_id = s.supplierid\n" +
            "JOIN category_product cp ON i.product_categoryid = cp.product_category_id JOIN material_product mp ON i.material_id = mp.material_id", nativeQuery = true)
    List<Map<String, Object>> getDetailsList();

    @Query(value = "SELECT i.*, cp.category_name, mp.material_name, s.supplier_name, sp.product_price FROM interior_product i JOIN supplier_product sp ON i.product_id = sp.product_id JOIN supplier s ON sp.supplier_id = s.supplierid\n" +
            "JOIN category_product cp ON i.product_categoryid = cp.product_category_id JOIN material_product mp ON i.material_id = mp.material_id WHERE i.product_id = ?", nativeQuery = true)
    Map<String, Object> getDetailByID(int id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO is_customized(product_id, length, width, height) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertIsCustomized(int productID, boolean length, boolean width, boolean height);

    @Query(value = "SELECT * FROM is_customized WHERE product_id = ?", nativeQuery = true)
    Map<String, Object> getIsCustomizedByID(int id);
}
