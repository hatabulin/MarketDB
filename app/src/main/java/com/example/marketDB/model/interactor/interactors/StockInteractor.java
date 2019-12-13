package com.example.marketDB.model.interactor.interactors;

import com.example.marketDB.model.events.StockListEvent;
import com.example.marketDB.model.events.SuccessEvent;
import com.example.marketDB.model.interactor.Interactor;
import com.example.marketDB.model.models.StockModel;
import com.example.marketDB.model.repositorys.DatabaseRepository;

public class StockInteractor implements Interactor.interactorStock {

    private DatabaseRepository mDatabaseRepository;

    public StockInteractor(DatabaseRepository repository) {
        mDatabaseRepository = repository;
    }

    @Override
    public void getListStocks(StockListEvent event) {

        StockModel modelStock = new StockModel();
//        mDatabaseRepository.getAllRecordsFtomTableStock(modelStock, new StockListEvent() {
//            @Override
//            public void result(List<StockModel> responseStockList) {
//
//                if (responseStockList != null) {
//                    event.result(responseStockList);
//                }
//            }
//        });
    }

    @Override
    public void setSelectedStock(int id, SuccessEvent event) {

    }
}
