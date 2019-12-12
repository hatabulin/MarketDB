package com.example.test.model.events;

import com.example.test.model.models.MarketModel;

import java.util.List;

public interface MarketListEvent {

    void result(List<MarketModel> responseMarketList);
}
