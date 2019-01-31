package com.example.aotuman.database.room.Bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 默认情况下，Room使用类名作为表名，使用字段名作为列名。
 * 我们可以通过@Entity的tableName属性定义自己的表名，
 * 通过@ColumnInfo的name属性定义自己的列名。
 */
@Entity(tableName = "shop")
public class Shop {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private String price;
    private int sell_num;
    private String image_url;
    private String address;
    private int type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSell_num() {
        return sell_num;
    }

    public void setSell_num(int sell_num) {
        this.sell_num = sell_num;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
