package com.example.marketDB.ui.home;


import com.example.marketDB.ui.base.BaseView;

public interface HomeFragmentView {

    interface View extends BaseView.RootView {

    }

    interface Presenter extends BaseView.Presenter<View> {

        void setSelectedId(Long id);

    }
}
