package com.example.cartBackTest.controller;

import com.example.cartBackTest.dto.CartItemDTO;
import com.example.cartBackTest.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173/") // 設置允許來自 Vue 端的跨域請求
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public List<CartItemDTO> getAllItems() {
        return cartItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemDTO> getItemById(@PathVariable Long id) {
        CartItemDTO item = cartItemService.getItemById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CartItemDTO createItem(@RequestBody CartItemDTO dto) {
        return cartItemService.createItem(dto);
    }

    @PutMapping("/{id}")
    public CartItemDTO updateItem(@PathVariable Long id, @RequestBody CartItemDTO dto) {
        return cartItemService.updateItem(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        cartItemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
