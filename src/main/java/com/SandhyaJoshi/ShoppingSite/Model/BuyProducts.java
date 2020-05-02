package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "buy_products")
public class BuyProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "Purchase_Date")
    private LocalDateTime purchaseDate;

    @Column(name = "Total_Price")
    private long totalPrice;

}
