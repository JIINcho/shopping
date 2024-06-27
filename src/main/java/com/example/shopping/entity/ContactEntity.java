package com.example.shopping.entity;

import com.example.shopping.dto.ContactDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contact")
public class ContactEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String contactTitle;
    @Column
    private String contactName;
    @Column
    private String contactContent;
    @Column
    private int contactHit;

    public static ContactEntity toSaveEntity(ContactDTO contactDTO) {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactTitle(contactDTO.getContactTitle());
        contactEntity.setContactName(contactDTO.getContactName());
        contactEntity.setContactContent(contactDTO.getContactContent());
        contactEntity.setContactHit(contactDTO.getContactHit());
        return contactEntity;
    }
}
