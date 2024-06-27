package com.example.shopping.dto;

import com.example.shopping.entity.ContactEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContactDTO {
    private Long id;
    private String contactTitle;
    private String contactName;
    private String contactContent;
    private int contactHit;
    private LocalDateTime contactCreatedTime;
    private LocalDateTime contactUpdatedTime;

    public static ContactDTO toContactDTO(ContactEntity contactEntity) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contactEntity.getId());
        contactDTO.setContactTitle(contactEntity.getContactTitle());
        contactDTO.setContactName(contactEntity.getContactName());
        contactDTO.setContactContent(contactEntity.getContactContent());
        contactDTO.setContactHit(contactEntity.getContactHit());
        contactDTO.setContactCreatedTime(contactEntity.getCreatedTime());
        contactDTO.setContactUpdatedTime(contactEntity.getUpdatedTime());
        return contactDTO;
    }
}
