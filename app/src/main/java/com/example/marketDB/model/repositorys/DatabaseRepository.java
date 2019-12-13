package com.example.marketDB.model.repositorys;

import com.example.marketDB.model.events.BooleanEvent;
import com.example.marketDB.model.events.MarketListEvent;
import com.example.marketDB.model.models.MarketModel;

public interface DatabaseRepository {

    void addRecordToTable(MarketModel logRequestModel, BooleanEvent event);

    void checkTable(BooleanEvent event);

    void getAllRecordsFtomTable(MarketModel model, MarketListEvent event);

    void getAllRecordsFtomTableStock(MarketModel model, MarketListEvent event);

    void clearDB(BooleanEvent event);

    void fillTable();

    void getAllRecordsFtomTable(MarketModel model);

    void closeBase();
}
