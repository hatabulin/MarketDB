package com.example.marketDB.model.repositorys;

import com.example.marketDB.model.events.BooleanEvent;
import com.example.marketDB.model.events.MarketListEvent;
import com.example.marketDB.model.events.MarketWithStockListEvent;
import com.example.marketDB.model.models.MarketModel;
import com.example.marketDB.model.models.MarketWithStockModel;

public interface DatabaseRepository {

    void addRecordToTable(MarketModel logRequestModel, BooleanEvent event);

    void checkTable(BooleanEvent event);

    void getAllRecordsFtomTableMarket(MarketModel model, MarketListEvent event);

    void getAllRecordsFtomTableMarketWithStock(MarketWithStockModel model, MarketWithStockListEvent event);

    void getAllRecordsFtomTableStock(MarketModel model, MarketListEvent event);

    void clearDB(BooleanEvent event);

    void fillTable();

    void getAllRecordsFtomTableMarket(MarketModel model);

    void closeBase();
}
