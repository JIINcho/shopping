package com.example.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp // 등록시간
    @Column(updatable = false) // 업데이트에서는 관련하지 마라
    private LocalDateTime createdTime;

    @UpdateTimestamp // 수정시간
    @Column(insertable = false) // 입력하는 insert에서는 관여하지 마라
    private LocalDateTime updatedTime;
}
