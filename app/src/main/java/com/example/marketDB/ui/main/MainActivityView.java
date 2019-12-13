package com.example.marketDB.ui.main;

import com.example.marketDB.model.events.FragmentChangedEvent;
import com.example.marketDB.ui.base.BaseView;
import com.example.marketDB.utils.fragments.FragmentsId;

public interface MainActivityView {

    interface View extends BaseView.RootView, FragmentChangedEvent {

        void closeApplication();

        void openUpdateDialog();
    }

    interface Presenter extends BaseView.Presenter<View> {

        FragmentsId getSelectedPage();

        void setSelectedPage(FragmentsId selectedPage);

        void closeApplication();
    }
}
