package com.example.marketDB.model.interactor;

import com.example.marketDB.model.events.MarketWithStockListEvent;
import com.example.marketDB.model.events.StockListEvent;
import com.example.marketDB.model.events.SuccessEvent;

public interface Interactor {

    interface interactorMarket {

        void getListMarkets(MarketWithStockListEvent event);

        void setSelectedMarket(int id, SuccessEvent event);

        void addNewMarket(String name, int stockId);
    }

    interface interactorStock {

        void getListStocks(StockListEvent event);

        void setSelectedStock(int id, SuccessEvent event);
    }
}
