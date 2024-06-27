package com.example.shopping.repository;

import com.example.shopping.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<GoodsEntity ,Long> {


    void deleteById(Long id);
}
