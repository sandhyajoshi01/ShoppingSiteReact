package com.SandhyaJoshi.ShoppingSite.Controller;

import com.SandhyaJoshi.ShoppingSite.Model.BuyProducts;
import com.SandhyaJoshi.ShoppingSite.Model.Role;
import com.SandhyaJoshi.ShoppingSite.Model.User;
import com.SandhyaJoshi.ShoppingSite.Service.BuyProductsService;
import com.SandhyaJoshi.ShoppingSite.Service.ProductService;
import com.SandhyaJoshi.ShoppingSite.Service.ShoppingCartService;
import com.SandhyaJoshi.ShoppingSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController //this will convert whatever is returned into json format in response
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private BuyProductsService buyProductsService;

    //the API methods
    @PostMapping("api/user/signup")
    public ResponseEntity<?> RegisterUser(@RequestBody User user){
        if (userService.findUserByUsername(user.getUsername())!=null){  //if id not null already, send conflict
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.CUSTOMER);
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("api/user/login")
    public ResponseEntity<?> getUser(Principal principal) {
        if (principal == null || principal.getName() == null) {
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findUserByUsername(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("api/user/products")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.ListProduct(), HttpStatus.OK);
    }

    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> buyProducts(@RequestBody BuyProducts buyProducts){
        buyProducts.setPurchaseDate(LocalDateTime.now());
        buyProductsService.saveTransaction(buyProducts);
        return new ResponseEntity<>(buyProducts, HttpStatus.CREATED);
    }


}
