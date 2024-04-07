package com.example.Asm.request;

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
public class OrderRequest {
    private Integer id;
    private String code;
    private Date createdDate;
    private String createDateStr;
    private Date paymentDate;
    private String paymentDateStr;
    private String status;
    private String recipientName;
    private String address;
    private String phoneNumber;
    // customer
    private Integer customerId;
}
