package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.Order;
import com.SandhyaJoshi.ShoppingSite.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImplementation implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
