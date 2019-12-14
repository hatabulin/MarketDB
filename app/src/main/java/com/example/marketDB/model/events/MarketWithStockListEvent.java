package com.example.marketDB.model.events;

import com.example.marketDB.model.models.MarketWithStockModel;

import java.util.List;

public interface MarketWithStockListEvent {

    void result(List<MarketWithStockModel> responseMarketWithStockList);
}
