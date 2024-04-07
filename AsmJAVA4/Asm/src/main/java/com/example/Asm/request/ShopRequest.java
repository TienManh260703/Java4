package com.example.Asm.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopRequest {
    private Integer id;
    private String code;
    // xem lai DB
    private String name;
    private String address;
    private String city;
    private String country;
}
