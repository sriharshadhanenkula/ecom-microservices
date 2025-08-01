package com.app.ecom.controller;

import com.app.ecom.dto.CartItemRequest;
import com.app.ecom.model.CartItem;
import com.app.ecom.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestHeader("X-User-ID") String userId,
                                          @RequestBody CartItemRequest request ){

        if(!cartService.addToCart(userId,request)){
            return ResponseEntity.badRequest().body("Product out of stock or user not found or product not found");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/items/{productId}")
    public ResponseEntity<String> removeFromCart(@RequestHeader("X-User-ID") String userId, @PathVariable Long productId){
       boolean result =  cartService.deleteItemFromCart(userId,productId);
       if(result){
           return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
       }
       else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found or user not found");
       }
    }

    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getCart(@RequestHeader("X-User-ID") String userId){

        return ResponseEntity.ok(cartService.getCart(userId));

    }

}
