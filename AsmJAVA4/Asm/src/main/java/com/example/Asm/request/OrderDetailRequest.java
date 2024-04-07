package com.example.Asm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDetailRequest {
    private int productDetailId;
    private int orderId;
    private int quantity;
    private int unitPrice;

}
