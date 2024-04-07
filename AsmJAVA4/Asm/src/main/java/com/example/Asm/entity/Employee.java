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
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "NhanVien")
@Entity
public class Employee {// Nhân viên
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "GioiTinh")
    private String gender;
    @Column(name = "NgaySinh")
    private Date dateOfBirth; // Ngày sinh
    @Column(name = "DiaChi")
    private String address;
    @Column(name = "Sdt")
    private String phoneNumber;
    @Column(name = "MatKhau")
    private String password;
    @Column(name = "TrangThai")
    private int status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCH", referencedColumnName = "Id")
    private Shop shop;
    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "IdCV" , referencedColumnName = "Id")
    private Position position;
}
