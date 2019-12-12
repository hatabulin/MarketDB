package com.example.test.model.repositorys;

import com.example.test.model.events.BooleanEvent;
import com.example.test.model.events.MarketListEvent;
import com.example.test.model.models.MarketModel;

public interface DatabaseRepository {

    void addRecordToTable(MarketModel logRequestModel, BooleanEvent event);

    void checkTable(BooleanEvent event);

    void getAllRecordsFtomTable(MarketModel model, MarketListEvent event);

    void clearDB(BooleanEvent event);

    void fillTable();

    void getAllRecordsFtomTable(MarketModel model);

    void closeBase();
}
