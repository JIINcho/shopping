package com.example.shopping.dto;

import com.example.shopping.entity.AdmEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdmDTO {
    private Long id; // 고유번호
    private String admId; // 관리자 아이디
    private String admPass; // 관리자 비밀번호
    private String admName; // 관리자 이름

    public static AdmDTO toAdmDTO(AdmEntity admEntity) {
        AdmDTO admDTO = new AdmDTO();
        admDTO.setId(admEntity.getId());
        admDTO.setAdmId(admEntity.getAdmId());
        admDTO.setAdmPass(admEntity.getAdmPass());
        admDTO.setAdmName(admEntity.getAdmName());
        return admDTO;
    }
}
