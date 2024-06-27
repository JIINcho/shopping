package com.example.shopping.repository;

import com.example.shopping.entity.GoodsFileEntity;
import jakarta.persistence.metamodel.IdentifiableType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsFileRepositroy extends JpaRepository<GoodsFileEntity, Long> {

}
