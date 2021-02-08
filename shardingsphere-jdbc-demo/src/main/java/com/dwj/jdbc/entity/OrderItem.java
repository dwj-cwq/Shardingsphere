package com.dwj.jdbc.entity;

import lombok.Data;

/**
 * @author Chen Wenqun
 */
@Data
public class OrderItem {

    private long orderItemId;

    private long orderId;

    private int userId;

    private String status;
}
