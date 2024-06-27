package com.example.shopping.repository;

import com.example.shopping.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    // 게시물을 클릭했을 때 마다 조회수가 올라감
    @Modifying
    @Query(value = "update NoticeEntity b set b.noticeHit = b.noticeHit + 1 where b.id=:id") // NoticeEntity를 b로 약식을 잡는다
    void updateHit(@Param("id") Long id);

    @Query("SELECT p FROM NoticeEntity p ORDER BY p.id DESC")
    List<NoticeEntity> findAllDesc();
}
