package com.iamdevnoel.course.entities.enums;

public enum OrderStatus {
    CANCELLED(0),
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4);

    private int code;

    // constructor obrigatório para que enums com numeração informada manualmente funcione
    // professor recomendou que, no caso de enums, o constructor seja private
    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        OrderStatus result = null;
        for (OrderStatus value : OrderStatus.values()) {
            if (code == value.getCode()) {
                result = value;
            } else {
                throw new IllegalArgumentException("Invalid OrderStatus code");
            }
        }
        return result;
    }
}
