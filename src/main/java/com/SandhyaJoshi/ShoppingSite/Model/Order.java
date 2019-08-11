package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "OrderID")
    private int OrderID;

    private Product Product_ID;
    private int quantity;

    //you need every single thing about product in this class

}

