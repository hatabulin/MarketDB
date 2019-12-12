package com.example.test.ui.markets;


import com.example.test.model.models.MarketModel;
import com.example.test.ui.base.BaseView;

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
