package com.example.shopping.entity;

import com.example.shopping.dto.AdmDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "admin")
public class AdmEntity {
    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement(자동증가)
    private Long id;

    @Column()
    private String admId;

    @Column()
    private String admPass;

    @Column()
    private String admName;

    public static AdmEntity toAdminEntity(AdmDTO admDTO) { // DTO를 Entity로 변환
        AdmEntity admEntity = new AdmEntity();
        admEntity.setAdmId(admDTO.getAdmId());
        admEntity.setAdmPass(admDTO.getAdmPass());
        admEntity.setAdmName(admDTO.getAdmName());
        return admEntity;
    }

}
