package com.zt.entity;

/**
 * Created by admin on 2018/4/17.
 */
public class Recommend {
    private int userId;
    private int fruitId;
    private int fruitNum;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public int getFruitNum() {
        return fruitNum;
    }

    public void setFruitNum(int fruitNum) {
        this.fruitNum = fruitNum;
    }
}
