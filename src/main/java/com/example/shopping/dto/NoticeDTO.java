package com.example.shopping.dto;

import com.example.shopping.entity.NoticeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NoticeDTO {
    private Long id;
    private String noticeTitle;
    private String noticeName;
    private String noticeContent;
    private int noticeHit;
    private LocalDateTime noticeCreatedTime;
    private LocalDateTime noticeUpdatedTime;

    public static NoticeDTO toNoticeDTO(NoticeEntity noticeEntity) {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setId(noticeEntity.getId());
        noticeDTO.setNoticeTitle(noticeEntity.getNoticeTitle());
        noticeDTO.setNoticeName(noticeEntity.getNoticeName());
        noticeDTO.setNoticeContent(noticeEntity.getNoticeContent());
        noticeDTO.setNoticeHit(noticeEntity.getNoticeHit());
        noticeDTO.setNoticeCreatedTime(noticeEntity.getCreatedTime());
        noticeDTO.setNoticeUpdatedTime(noticeEntity.getUpdatedTime());
        return noticeDTO;
    }
}
