package com.example.test.ui.main;

import com.example.test.utils.fragments.FragmentsAnimationId;
import com.example.test.utils.fragments.FragmentsId;

public class MainActivityPresenter implements MainActivityView.Presenter {

    MainActivityView.View mView;
    private FragmentsId mSelectedPage;

    @Override
    public FragmentsId getSelectedPage() {
        return mSelectedPage;
    }

    @Override
    public void setSelectedPage(FragmentsId selectedPage) {
        mSelectedPage = selectedPage;
    }

    @Override
    public void closeApplication() {
        if (mView != null) {
            mView.closeApplication();
        }
    }

    @Override
    public void bindView(MainActivityView.View view) {
        mView = view;
    }

    @Override
    public void unbindView() {
        mView = null;
    }

    @Override
    public void onViewCreated() {

        if (mView != null) {

            mSelectedPage = FragmentsId.LIST_MARKETS;
            mView.changeFragment(mSelectedPage, FragmentsAnimationId.ALPHA);
        }
    }
}
