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
public class OrderResponse {

    private Integer id;
    private String code;
    private Date createdDate;
    private String createDateStr;
    private Date paymentDate;
    private String paymentDateStr;
    private String status;
    private String recipientName;//Tên người nhận
    private String address;
    private String phoneNumber;
    // customer
    private Integer customerId;
    private String customerCode;


}
