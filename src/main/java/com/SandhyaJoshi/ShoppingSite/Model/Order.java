package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "OrderID")
    private int OrderID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Order_Date")
    private LocalDateTime Order_Date;

}

