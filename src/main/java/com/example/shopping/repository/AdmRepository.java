package com.example.shopping.repository;

import com.example.shopping.entity.AdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmRepository extends JpaRepository<AdmEntity, Long> {
    // select * from admin where admId = ?
    Optional<AdmEntity> findByAdmId(String AdmId); // AdmEntity에서 AdmId에 대한 값을 찾는다

}
