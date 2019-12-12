package com.example.test.model.interactor.interactors;

import com.example.test.model.events.BooleanEvent;
import com.example.test.model.events.MarketListEvent;
import com.example.test.model.events.SuccessEvent;
import com.example.test.model.interactor.Interactor;
import com.example.test.model.models.MarketModel;
import com.example.test.model.repositorys.DatabaseRepository;

import java.util.List;

public class MarketInteractor implements Interactor.interactorMarket {

    private DatabaseRepository mDatabaseRepository;

    public MarketInteractor(DatabaseRepository repository) {
        mDatabaseRepository = repository;
    }


    @Override
    public void getListMarkets(final MarketListEvent event) {

        MarketModel modelMarket = new MarketModel();
        mDatabaseRepository.getAllRecordsFtomTable(modelMarket, new MarketListEvent() {
            @Override
            public void result(List<MarketModel> responseMarketList) {

                if (responseMarketList != null) {
                    mDatabaseRepository.closeBase();
                    event.result(responseMarketList);
                }
            }
        });

    }

    @Override
    public void setSelectedMarket(int id, SuccessEvent event) {

    }

    @Override
    public void addNewMarket(final SuccessEvent event) {

        MarketModel modelMarket = new MarketModel();
        mDatabaseRepository.addRecordToTable(modelMarket, new BooleanEvent() {
            @Override
            public void result(boolean result) {
                event.done();
            }
        });
    }

//    @Override
//    public void addNewMarket() {
//
//        MarketModel modelMarket = new MarketModel();
//        mDatabaseRepository.addRecordToTable(final MarketModel model)
//    }
}
