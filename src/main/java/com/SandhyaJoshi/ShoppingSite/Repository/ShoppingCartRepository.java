package com.SandhyaJoshi.ShoppingSite.Repository;

import com.SandhyaJoshi.ShoppingSite.Model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
