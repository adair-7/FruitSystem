package com.zt.entity;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/1/19.
 */
@Component
public class Wallet {
    private int walletId;
    private  int userId;
    private  String userName;
    private  String walletPwd;
    private float amount;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
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

    public String getWalletPwd() {
        return walletPwd;
    }

    public void setWalletPwd(String walletPwd) {
        this.walletPwd = walletPwd;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", walletPwd='" + walletPwd + '\'' +
                ", amount=" + amount +
                '}';
    }
}
