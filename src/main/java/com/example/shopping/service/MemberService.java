package com.example.shopping.service;

import com.example.shopping.dto.MemberDTO;
import com.example.shopping.entity.MemberEntity;
import com.example.shopping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byUserId = memberRepository.findByUserId(memberDTO.getUserId());
        if(byUserId.isPresent()) {
            // 조회된 결과가 있다면 비밀번호를 비교
            MemberEntity memberEntity = byUserId.get();
            if(memberEntity.getUserPass().equals(memberDTO.getUserPass())) {
                // 비밀번호가 일치한다면
                // Entity -> DTO로 변환
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }
            else {
                // 비밀번호 불일치
            }
        }
        else {
            return  null;
        }
        return null;
    }

    public String idCheck(String userId) {
        Optional<MemberEntity> byUserId = memberRepository.findByUserId(userId);
        if(byUserId.isPresent()) {
            // 조회결과가 있다 -> 등록된 아이디가 있다 (사용할 수 없다)
            return null;
        }
        else {
            // 조회결과가 없다 -> 사용 가능하다
            return "ok";
        }
    }

    @Transactional
    public void deleteMember(String userId) {
        memberRepository.deleteByUserId(userId);
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO>  memberDTOList = new ArrayList<>();

        for(MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }
}
