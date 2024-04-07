package com.example.Asm.response;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
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
public class EmployeeResponse {
    private Integer id;
    private String code;
    private String firstName; // Tên
    private String middleName; // Tên đệm
    private String lastName; // Họ
    private String gender;
    private Date dateOfBirth; // Ngày sinh
    private String dateStr;
    private String address;
    private String phoneNumber;
    private String password;
    private int status;
    // Shop
    private Integer shopId;
    private String shopCode;
    private String shopName;
    private String shopAddress;
    private String shopCity;
    private String shopCountry;
    // Position
    private Integer positionId;
    private String positionCode;
    private String positionName;
}
