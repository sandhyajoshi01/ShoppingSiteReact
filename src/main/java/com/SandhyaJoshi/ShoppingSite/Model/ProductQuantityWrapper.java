package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

@Data  //is generating getters and setters
public class ProductQuantityWrapper {
    private Product Product_ID;
    private int Quantity;
}
