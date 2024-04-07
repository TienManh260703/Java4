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


import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "HoaDon")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ma")
    private String code;

    @Column(name = "NgayTao")
    private Date createdDate;

    @Column(name = "NgayThanhToan")
    private Date paymentDate;

//    @Column(name = "NgayShip")
//    private Date shippingDate;
//
//    @Column(name = "NgayNhan")
//    private Date receivedDate;

    @Column(name = "TinhTrang")
    private String status;

    @Column(name = "TenNguoiNhan")
    private String recipientName;

    @Column(name = "DiaChi")
    private String address;

    @Column(name = "Sdt")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH", referencedColumnName = "Id")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetail > orderDetails;
}

