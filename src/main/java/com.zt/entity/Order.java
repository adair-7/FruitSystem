package com.zt.entity;

import java.util.Date;

/**
 * Created by admin on 2018/3/18.
 */
public class Order {
    private int orderId;
    private int userId;
    private String userName;
    private int fruitId;
    private String fruitName;
    private Date orderDate;
    private int fruitNum;
    private float orderPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getFruitNum() {
        return fruitNum;
    }

    public void setFruitNum(int fruitNum) {
        this.fruitNum = fruitNum;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", fruitId=" + fruitId +
                ", fruitName='" + fruitName + '\'' +
                ", orderDate=" + orderDate +
                ", fruitNum=" + fruitNum +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
