package com.dwj.jdbc.entity;

import lombok.Data;

/**
 * @author Chen Wenqun
 */
@Data
public class Order {

    private long orderId;

    private int userId;

    private long addressId;

    private String status;
}
