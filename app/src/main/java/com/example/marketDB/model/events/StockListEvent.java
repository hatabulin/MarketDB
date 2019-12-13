package com.example.marketDB.model.events;

import com.example.marketDB.model.models.StockModel;

import java.util.List;

public interface StockListEvent {

    void result(List<StockModel> responseStockList);
}
