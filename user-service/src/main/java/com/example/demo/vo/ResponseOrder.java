package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer uniPrice;
    private Integer totalPrice;
    private Date createAt;

    private String orderId;
}
