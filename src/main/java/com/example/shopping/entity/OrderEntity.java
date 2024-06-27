package com.example.shopping.entity;

import com.example.shopping.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orderlist")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String userPhone;

    @Column
    private String reuserName;

    @Column
    private String reuserPhone;

    @Column
    private String userPost;

    @Column
    private String userEmail;

    @Column
    private String userMemo;


    public static OrderEntity toSaveEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setUserName(orderDTO.getUserName());
        orderEntity.setUserPhone(orderDTO.getUserPhone());
        orderEntity.setReuserName(orderDTO.getReuserName());
        orderEntity.setReuserPhone(orderDTO.getReuserPhone());
        orderEntity.setUserPost(orderDTO.getUserPost());
        orderEntity.setUserEmail(orderDTO.getUserEmail());
        orderEntity.setUserMemo(orderDTO.getUserMemo());
        return orderEntity;
    }
}
