package com.example.Asm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@ToString
@Builder

@Table(name = "KhachHang")
@Entity
public class Customer {// Khách hàng


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Ma")
    private String code;
    @Column(name = "Ten")
    private String firstName; // Tên
    @Column(name = "TenDem")
    private String middleName; // Tên đệm
    @Column(name = "Ho")
    private String lastName; // Họ
    @Column(name = "NgaySinh")
    private Date dateOfBirth; // Ngày sinh
    @Column(name = "Sdt")
    private String phoneNumber;
    @Column(name = "DiaChi")
    private String address;
    @Column(name = "ThanhPho")
    private String city; // Thành phố
    @Column(name = "QuocGia")
    private String country;// Quốc gia
    @Column(name = "MatKhau")
    private String password;
    private Integer status;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> orders;
}
