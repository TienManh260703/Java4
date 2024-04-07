package com.example.Asm.request;

import com.example.Asm.entity.Color;
import com.example.Asm.entity.Producer;
import com.example.Asm.entity.Product;
import com.example.Asm.entity.ProductLine;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDetailRequest {

    private int id;
    private Integer productId;
    private Integer producerId;// Nhà sản xuất
    private Integer colorId; //
    private Integer productLineId; // Dòng sản phẩm
    private Integer  warrantyYear;// Năm bảo hành
    private String describe;// Mô tả
    private String quantity;// Số lượng
    private Float importPrice;
    private Float price;
    private Integer status;
}
