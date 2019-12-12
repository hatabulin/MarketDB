package com.example.test.model.events;

import com.example.test.model.models.StockModel;

import java.util.List;

public interface StockListEvent {

    void result(List<StockModel> responseStockList);
}
