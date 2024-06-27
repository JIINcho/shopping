package com.example.shopping.entity;

import com.example.shopping.dto.GoodsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "goods")
public class GoodsEntity extends BaseEntity { //BaseEntity 날짜 관련 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String goodsCategory;

    @Column()
    private String goodsName;

    @Column(length = 20)
    private String goodsCost;

    @Column(length = 500)
    private String goodsMemo;

    @Column(length = 20)
    private String goodsState;

    @Column
    private int fileAttached; //파일첨부

    // 여러개를 받아올 수도 있어 List로 받아옴
    @OneToMany(mappedBy = "goodsEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<GoodsFileEntity> goodsFileEntityList = new ArrayList<>();



    public static GoodsEntity toSaveEntity(GoodsDTO goodsDTO) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsCategory(goodsDTO.getGoodsCategory());
        goodsEntity.setGoodsName(goodsDTO.getGoodsName());
        goodsEntity.setGoodsCost(goodsDTO.getGoodsCost());
        goodsEntity.setGoodsMemo(goodsDTO.getGoodsMemo());
        goodsEntity.setGoodsState(goodsDTO.getGoodsState());
        goodsEntity.setFileAttached(0);
        return goodsEntity;
    }

    public static GoodsEntity toSaveFileEntity(GoodsDTO goodsDTO) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsCategory(goodsDTO.getGoodsCategory());
        goodsEntity.setGoodsName(goodsDTO.getGoodsName());
        goodsEntity.setGoodsCost(goodsDTO.getGoodsCost());
        goodsEntity.setGoodsMemo(goodsDTO.getGoodsMemo());
        goodsEntity.setGoodsState(goodsDTO.getGoodsState());
        goodsEntity.setFileAttached(1);
        return goodsEntity;
    }

}
