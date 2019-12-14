
package com.example.marketDB.model.models;

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

public class MarketWithStockModel {

    private long id;

    private String name;

    private String stock_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStockName() {

        return stock_name;
    }

    public void setStockName(String stock_name) {
        this.stock_name = stock_name;
    }
}
