package com.example.test.ui.main;

import com.example.test.model.events.FragmentChangedEvent;
import com.example.test.ui.base.BaseView;
import com.example.test.utils.fragments.FragmentsId;

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
