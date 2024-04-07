package com.example.Asm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ShopResponse {
    private Integer id;
    private String code;
    private String name;
    private String address;
    private String city;
    private String country;
}
