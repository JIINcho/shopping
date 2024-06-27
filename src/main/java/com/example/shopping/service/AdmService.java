package com.example.shopping.service;

import com.example.shopping.dto.AdmDTO;
import com.example.shopping.entity.AdmEntity;
import com.example.shopping.repository.AdmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmService {
    private final AdmRepository admRepository; // 데이터베이스와 연결되는 부분

    public void save(AdmDTO admDTO) {
        // DTO를 Entity로 변환
        AdmEntity admEntity = AdmEntity.toAdminEntity(admDTO);
        admRepository.save(admEntity);
    }

    public AdmDTO login(AdmDTO admDTO) {
        // 입력했던 아이디를 DB에서 조회 --> DB에 있는 비밀번호와 입력했던 비번을 일치하는지 확인
        Optional<AdmEntity> byAdmId = admRepository.findByAdmId(admDTO.getAdmId());
        if (byAdmId.isPresent()){
            // 조회된 결과가 있다면 비밀번호 비교
            AdmEntity admEntity = byAdmId.get();
            if (admEntity.getAdmPass().equals(admDTO.getAdmPass())) {
                // 비밀번호가 일치하면
                // Entity --> DTO로 변환
                AdmDTO dto = AdmDTO.toAdmDTO(admEntity);
                return dto;
            }
            else {
                // 비밀번호 불일치

            }
        }
        else {
            // 조회 결과가 없다면
            return null;
        }
        return null;
    }
}
