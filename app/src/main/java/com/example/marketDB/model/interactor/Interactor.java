package com.example.marketDB.model.interactor;

import com.example.marketDB.model.events.MarketListEvent;
import com.example.marketDB.model.events.StockListEvent;
import com.example.marketDB.model.events.SuccessEvent;

public interface Interactor {

    interface interactorMarket {

        void getListMarkets(MarketListEvent event);

        void setSelectedMarket(int id, SuccessEvent event);

        void addNewMarket(SuccessEvent event);
    }

    interface interactorStock {

        void getListStocks(StockListEvent event);

        void setSelectedStock(int id, SuccessEvent event);
    }
}
