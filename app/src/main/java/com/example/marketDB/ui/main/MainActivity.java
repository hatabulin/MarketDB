package com.example.marketDB.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.marketDB.R;
import com.example.marketDB.ui.base.BaseActivity;
import com.example.marketDB.ui.markets.MarketListFragment;
import com.example.marketDB.utils.fragments.FragmentsAnimationId;
import com.example.marketDB.utils.fragments.FragmentsId;

public class MainActivity extends BaseActivity implements MainActivityView.View,
        MarketListFragment.OnFragmentInteractionListener {

    private static final int FRAGMENTS_CONTEINER = R.id.containerFragments;
    MainActivityView.Presenter presenter;
    private MarketListFragment marketsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marketsListFragment = new MarketListFragment();

        presenter = new MainActivityPresenter();

        presenter.bindView(this);
        presenter.onViewCreated();
    }

    @Override
    public void closeApplication() {

    }

    @Override
    public void openUpdateDialog() {

    }

    @Override
    public void changeFragment(FragmentsId fragmentsId, FragmentsAnimationId fragmentsAnimationId) {
        changeFragmentWithAnimation(getSupportFragmentManager(), getFragmentById(fragmentsId), FRAGMENTS_CONTEINER, fragmentsAnimationId);
    }

    @Override
    public void setFragment(FragmentsId fragmentsId) {
        setFragment(getSupportFragmentManager(), getFragmentById(fragmentsId), FRAGMENTS_CONTEINER);
    }

    private Fragment getFragmentById(FragmentsId fragmentsId) {
        presenter.setSelectedPage(fragmentsId);
        switch (fragmentsId) {
            case LIST_MARKETS:
                return marketsListFragment;
            case LIST_STOCKS:
//                return stocksListFragment;
            case LIST_PRODUCTS:
//                return productsListFragment;
            case DETAILS_MARKET:
//                return marketDetailsFragment;
            case DETAILS_STOCK:
//                return stockDetailsFragment;
            default:
                return marketsListFragment;
        }
    }
}
