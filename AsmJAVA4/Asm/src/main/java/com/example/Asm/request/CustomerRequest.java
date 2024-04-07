package com.example.Asm.request;

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
@ToString
@Builder
public class CustomerRequest {

    private Integer id;
    private String code;
    private String firstName; // Tên
    private String middleName; // Tên đệm
    private String lastName; // Họ
    private Date dateOfBirth; // Ngày sinh
    private String dateStr;
    private String phoneNumber;
    private String address;
    private String city; // Thành phố
    private String country;// Quốc gia
    private String password;
}
