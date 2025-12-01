package com.example.cartBackTest.dao;

import com.example.cartBackTest.entity.CartItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartItemDAO {

    List<CartItem> findAll();

    CartItem findById(Long id);

    void save(CartItem item);

    void update(CartItem item);

    void deleteById(Long id);
}

