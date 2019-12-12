
package com.example.test.model.models;

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

public class MarketModel {

    private long id;

    private long stock_id;

    private String name;

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

    public long getStockID() {

        return stock_id;
    }

    public void setStockID(long stock_id) {
        this.stock_id = stock_id;
    }
}
