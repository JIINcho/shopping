package com.example.shopping.service;

import com.example.shopping.dto.ContactDTO;
import com.example.shopping.entity.ContactEntity;
import com.example.shopping.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public void save(ContactDTO contactDTO) {
        ContactEntity contactEntity = ContactEntity.toSaveEntity(contactDTO);
        contactRepository.save(contactEntity);
    }
    public List<ContactDTO> findAll() {
        List<ContactEntity> contactEntityList = contactRepository.findAll();
        List<ContactDTO> contactDTOList = new ArrayList<>();

        for(ContactEntity contactEntity: contactEntityList) {
            contactDTOList.add(ContactDTO.toContactDTO(contactEntity));
        }
        return contactDTOList;
    }

    public ContactDTO findById(Long id) {
        Optional<ContactEntity> optionalContactEntity = contactRepository.findById(id);
        if(optionalContactEntity.isPresent()) {
            ContactEntity contactEntity = optionalContactEntity.get();
            ContactDTO contactDTO = ContactDTO.toContactDTO(contactEntity);
            return contactDTO;
        }
        else {
            return null;
        }
    }

    @Transactional
    public void updateHits(Long id) {
        contactRepository.updateHit(id);
    }
}
