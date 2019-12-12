package com.example.test.ui.home;

import android.os.Handler;

public class HomeFragmentPresenter implements HomeFragmentView.Presenter {

    private HomeFragmentView.View mView;

    public HomeFragmentPresenter() {

    }

    @Override
    public void bindView(HomeFragmentView.View view) {
        mView = view;
    }

    @Override
    public void unbindView() {
        mView = null;
    }

    @Override
    public void onViewCreated() {
        final Handler handler = new Handler();

//        mInteractorMarket.getMarketsStringList(new MarketListEvent() {
//            @Override
//            public void result(List<MarketModel> list) {
//                if (mView != null) {
//                    if (list != null) {
//                        mView.viewListMarkets(list);
//                    }
//                }
//            }
//        });
    }

    @Override
    public void setSelectedId(Long id) {
    }
}
