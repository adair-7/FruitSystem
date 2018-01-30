package com.zt.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by admin on 2018/1/23.
 */
@Component
public class FruitCategory {
    private String fruitName;
    private float unitPrice;
    private String introduction;
    private String iconUrl;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "FruitCategory{" +
                "fruitName='" + fruitName + '\'' +
                ", unitPrice=" + unitPrice +
                ", introduction='" + introduction + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}
