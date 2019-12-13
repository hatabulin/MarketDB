package com.example.marketDB.ui.markets;

import com.example.marketDB.model.events.MarketListEvent;
import com.example.marketDB.model.events.SuccessEvent;
import com.example.marketDB.model.interactor.Interactor;
import com.example.marketDB.model.models.MarketModel;

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

        mInteractorMarket.getListMarkets(new MarketListEvent() {
            @Override
            public void result(List<MarketModel> responseMarketList) {
                if (mView != null) {
                    if (responseMarketList != null) {
                        mView.viewListMarkets(responseMarketList);
                    }
                }
            }
        });
    }

    @Override
    public void setSelectedId(Long id) {
        mInteractorMarket.setSelectedMarket(id.intValue(), new SuccessEvent() {
            @Override
            public void done() {
                if (mView != null) {
                    mView.openMarket();
                }
            }
        });
    }
}