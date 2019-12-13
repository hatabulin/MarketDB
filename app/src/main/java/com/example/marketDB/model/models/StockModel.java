
package com.example.marketDB.model.models;

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

public class StockModel {

    private long id;

    private long product_id;

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

    public long getProductID() {

        return product_id;
    }

    public void setProductID(long product_id) {
        this.product_id = product_id;
    }
}
