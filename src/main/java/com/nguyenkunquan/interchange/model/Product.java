package com.nguyenkunquan.interchange.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "interior_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productDescription;
    private int materialId;
    private String productColor;
    private float productLength;
    private float productWidth;
    private float productHeight;
    private int productCategoryID;

}
