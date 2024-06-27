package com.example.shopping.repository;

import com.example.shopping.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    @Modifying
    @Query(value = "update NoticeEntity b set b.noticeHit = b.noticeHit + 1 where b.id=:id")
    void updateHit(@Param("id") Long id);
}
