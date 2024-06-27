package com.example.shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "goods_file")
public class GoodsFileEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    private String originalFilename;

    @Column
    private String storedFilename;

    @ManyToOne(fetch = FetchType.LAZY) // 다수가 하나
    @JoinColumn(name = "goods_id") // 외래키 매핑
    private GoodsEntity goodsEntity;

    public static GoodsFileEntity toGoodsFileEntity(GoodsEntity goodsEntity, String originalFilename, String storedFilename) {
        GoodsFileEntity goodsFileEntity = new GoodsFileEntity();
        goodsFileEntity.setOriginalFilename(originalFilename);
        goodsFileEntity.setStoredFilename(storedFilename);
        goodsFileEntity.setGoodsEntity(goodsEntity);
        return goodsFileEntity;
    }
}


//id 1
//name 홍길동
//
//        id  file  g_id
//        1  A.GIIF 5