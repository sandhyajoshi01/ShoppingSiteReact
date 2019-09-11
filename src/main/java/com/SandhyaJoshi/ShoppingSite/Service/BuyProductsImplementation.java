package com.SandhyaJoshi.ShoppingSite.Service;
import com.SandhyaJoshi.ShoppingSite.Model.BuyProducts;
import com.SandhyaJoshi.ShoppingSite.Repository.BuyProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class BuyProductsImplementation implements BuyProductsService {

    @Autowired
    private BuyProductsRepository buyProductsRepository;

    @Override
    public BuyProducts saveTransaction(BuyProducts buyProducts) {
        return buyProductsRepository.save(buyProducts);
    }

}
