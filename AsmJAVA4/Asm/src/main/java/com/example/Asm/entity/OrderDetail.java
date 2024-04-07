package com.example.Asm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HoaDonChiTiet")
public class OrderDetail  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
    private ProductDetail productDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private Order order;
    @Column(name = "SoLuong")
    private Integer quantity;
    @Column(name = "DonGia")
    private Float unitPrice;
}
