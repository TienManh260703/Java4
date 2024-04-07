package com.example.Asm.response;

import com.example.Asm.entity.Color;
import com.example.Asm.entity.Producer;
import com.example.Asm.entity.Product;
import com.example.Asm.entity.ProductLine;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductDetailResponse {
    private int id;
    private int warrantyYear;// Năm bảo hành
    private String describe;// Mô tả
    private String quantity;// Số lượng
    private Float importPrice;
    private Float price;
    private Integer status;
    //    Color
    private Integer colorId;
    private String colorCode;
    private String colorName;
    // product
    private Integer productId;
    private String productCode;
    private String productName;
    // Nhà sản producer xuất
    private Integer producerId;
    private String producerCode;
    private String producerName;
    // productLine
    private Integer productLineId;
    private String productLineCode;
    private String productLineName;
}
