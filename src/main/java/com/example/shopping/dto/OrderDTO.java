package com.example.shopping.dto;

import com.example.shopping.entity.OrderEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderDTO {

    private Long id;
    private String userName;
    private String userPhone;
    private String reuserName;
    private String reuserPhone;
    private String userPost;
    private String userEmail;
    private String userMemo;


    public static OrderDTO toOrderDTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setUserName(orderEntity.getUserName());
        orderDTO.setUserPhone(orderEntity.getUserPhone());
        orderDTO.setReuserName(orderEntity.getReuserName());
        orderDTO.setReuserPhone(orderEntity.getReuserPhone());
        orderDTO.setUserPost(orderEntity.getUserPost());
        orderDTO.setUserEmail(orderEntity.getUserEmail());
        orderDTO.setUserMemo(orderEntity.getUserMemo());
        return orderDTO;
    }
}
