package com.example.Asm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "ChiTietSP")
@Entity
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "NamBH")
    private int warrantyYear;// Năm bảo hành
    @Column(name = "MoTa")
    private String describe;// Mô tả
    @Column(name = "SoLuongTon")
    private String quantity;// Số lượng
    @Column(name = "GiaNhap")
    private Float importPrice;
    @Column(name = "GiaBan")
    private Float price;
    private Integer status;
    // Color
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private Color color;
    // Product
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private Product product;
    // Nhà sản xuất
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id")
    private Producer producer;
    // Dòng sản phẩm
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private ProductLine productLine;

    @OneToMany(mappedBy = "productDetail", fetch = FetchType.EAGER)
    private List<OrderDetail > orderDetails;


}
