package com.example.test.model.interactor;

import com.example.test.model.events.MarketListEvent;
import com.example.test.model.events.SuccessEvent;

public interface Interactor {

    interface interactorMarket {

        void getListMarkets(MarketListEvent event);

        void setSelectedMarket(int id, SuccessEvent event);

        void addNewMarket(SuccessEvent event);
    }

    interface interactorStock {

        void setSelectedStock(int id, SuccessEvent event);
    }
}
