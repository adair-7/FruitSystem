package com.zt.entity;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/1/23.
 */
@Component
public class FruitStock {
    private  int fruitId;
    private String fruitName;
    private int stockTop;
    private int stockAccount;

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

    public int getStockTop() {
        return stockTop;
    }

    public void setStockTop(int stockTop) {
        this.stockTop = stockTop;
    }

    public int getStockAccount() {
        return stockAccount;
    }

    public void setStockAccount(int stockAccount) {
        this.stockAccount = stockAccount;
    }

    @Override
    public String toString() {
        return "FruitStock{" +
                "fruitId=" + fruitId +
                ", fruitName='" + fruitName + '\'' +
                ", stockTop=" + stockTop +
                ", stockAccount=" + stockAccount +
                '}';
    }
}
