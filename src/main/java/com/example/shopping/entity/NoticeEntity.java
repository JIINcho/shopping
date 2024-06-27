package com.example.shopping.entity;

import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.repository.NoticeRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notice")
public class NoticeEntity extends BaseEntity { // BaseEntity와 연동

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String noticeTitle;

    @Column(length = 20, nullable = false)
    private String noticeName;

    @Column(length = 500)
    private String noticeContent;

    @Column
    private int noticeHit;

    public static NoticeEntity toSaveEntity(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeName(noticeDTO.getNoticeName());
        noticeEntity.setNoticeContent(noticeDTO.getNoticeContent());
        noticeEntity.setNoticeHit(noticeDTO.getNoticeHit());
        return noticeEntity;
    }
}
