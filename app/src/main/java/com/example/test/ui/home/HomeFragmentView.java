package com.example.test.ui.home;


import com.example.test.ui.base.BaseView;

public interface HomeFragmentView {

    interface View extends BaseView.RootView {

    }

    interface Presenter extends BaseView.Presenter<View> {

        void setSelectedId(Long id);

    }
}
