package com.lumina.pos.model;

import lombok.Data;

@Data
public class Address {
    private Integer region;
    private String city;
    private String state;
    private String quarter;
}
