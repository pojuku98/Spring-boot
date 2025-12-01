package com.example.cartBackTest.service;

import com.example.cartBackTest.dto.CartItemDTO;
import com.example.cartBackTest.entity.CartItem;
import com.example.cartBackTest.dao.CartItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemService {

    @Autowired
    private CartItemDAO cartItemDAO;

    public List<CartItemDTO> getAllItems() {
        return cartItemDAO.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CartItemDTO getItemById(Long id) {
        CartItem item = cartItemDAO.findById(id);
        return item != null ? convertToDTO(item) : null;
    }

    public CartItemDTO createItem(CartItemDTO dto) {
        CartItem item = convertToEntity(dto);
        cartItemDAO.save(item);
        return convertToDTO(item);
    }

    public CartItemDTO updateItem(Long id, CartItemDTO dto) {
        CartItem item = cartItemDAO.findById(id);
        if (item == null) {
            throw new RuntimeException("Item not found");
        }
        item.setProductName(dto.getProductName());
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
        cartItemDAO.update(item);
        return convertToDTO(item);
    }

    public void deleteItem(Long id) {
        cartItemDAO.deleteById(id);
    }

    private CartItem convertToEntity(CartItemDTO dto) {
        CartItem item = new CartItem();
        item.setId(dto.getProductId());
        item.setProductName(dto.getProductName());
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
        return item;
    }

    private CartItemDTO convertToDTO(CartItem item) {
        CartItemDTO dto = new CartItemDTO();
        dto.setProductId(item.getId());
        dto.setProductName(item.getProductName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }
}
