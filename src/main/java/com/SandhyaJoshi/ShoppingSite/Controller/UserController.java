package com.SandhyaJoshi.ShoppingSite.Controller;

import com.SandhyaJoshi.ShoppingSite.Model.Role;
import com.SandhyaJoshi.ShoppingSite.Model.User;
import com.SandhyaJoshi.ShoppingSite.Service.ProductService;
import com.SandhyaJoshi.ShoppingSite.Service.ShoppingCartService;
import com.SandhyaJoshi.ShoppingSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController //this will convert whatever is returned into json format in response
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    //the API methods
    @PostMapping("api/user/registration")
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



}
