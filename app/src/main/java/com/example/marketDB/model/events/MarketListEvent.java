package com.example.marketDB.model.events;

import com.example.marketDB.model.models.MarketModel;

import java.util.List;

public interface MarketListEvent {

    void result(List<MarketModel> responseMarketList);
}
