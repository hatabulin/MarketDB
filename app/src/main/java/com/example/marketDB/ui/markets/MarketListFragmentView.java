package com.example.marketDB.ui.markets;


import com.example.marketDB.model.models.MarketModel;
import com.example.marketDB.ui.base.BaseView;

import java.util.List;

public interface MarketListFragmentView {

    interface View extends BaseView.RootView {

        void viewListMarkets(List<MarketModel> list);

        void openMarket();
    }

    interface Presenter extends BaseView.Presenter<View> {

        void setSelectedId(Long id);

    }
}
