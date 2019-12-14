package com.example.marketDB.ui.markets;

import com.example.marketDB.model.events.MarketWithStockListEvent;
import com.example.marketDB.model.interactor.Interactor;
import com.example.marketDB.model.models.MarketWithStockModel;

import java.util.List;

public class MarketListFragmentPresenter implements MarketListFragmentView.Presenter {

    private MarketListFragmentView.View mView;
    private Interactor.interactorMarket mInteractorMarket;

    public MarketListFragmentPresenter(Interactor.interactorMarket interactorMarket) {
        mInteractorMarket = interactorMarket;
    }

    @Override
    public void bindView(MarketListFragmentView.View view) {
        mView = view;
    }

    @Override
    public void unbindView() {
        mView = null;
    }

    @Override
    public void onViewCreated() {

        mInteractorMarket.getListMarkets(new MarketWithStockListEvent() {
            @Override
            public void result(List<MarketWithStockModel> responseMarketWithStockList) {
                mView.viewListMarkets(responseMarketWithStockList);
            }
        });
    }

    @Override
    public void setSelectedId(Long id) {
        if (mView != null) {
            mView.openMarket();
        }
    }
}
