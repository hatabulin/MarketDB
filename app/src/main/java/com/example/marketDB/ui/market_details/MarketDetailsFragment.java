package com.example.marketDB.ui.market_details;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.marketDB.R;
import com.example.marketDB.model.events.FragmentChangedEvent;
import com.example.marketDB.model.interactor.interactors.MarketInteractor;
import com.example.marketDB.model.models.MarketWithStockModel;
import com.example.marketDB.model.repositorys.DatabaseRepositoryImpl;
import com.example.marketDB.ui.base.BaseFragment;
import com.example.marketDB.ui.markets.MarketListFragmentPresenter;
import com.example.marketDB.ui.markets.MarketListFragmentView;
import com.example.marketDB.ui.markets.MarketWithStockAdapter;
import com.example.marketDB.utils.fragments.FragmentsAnimationId;
import com.example.marketDB.utils.fragments.FragmentsId;

import java.util.List;

public class MarketDetailsFragment extends BaseFragment implements MarketListFragmentView.View {


    private MarketListFragmentView.Presenter presenter;

    private OnFragmentInteractionListener mListener;
    private MarketWithStockAdapter adapter;
    //    private MarketAdapter adapter;
    private RecyclerView recyclerView;
    private Button btnAddRecord;

    public MarketDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Injectors.get(getActivity()).plus(new MarketListFragmentModule()).inject(this);
        presenter = new MarketListFragmentPresenter(new MarketInteractor(new DatabaseRepositoryImpl()));
        presenter.bindView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_markets, container, false);
        initView(v);
        presenter.onViewCreated();
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initView(View v) {
    }

    @Override
    public void viewListMarkets(List<MarketWithStockModel> listMarketModel) {

        adapter.addList(listMarketModel);
        //RecycleAdapter adapter = new RecycleAdapter(populateRecycler);//and then populate your recycler adapter
        recyclerView.scheduleLayoutAnimation();
    }

    @Override
    public void openMarket() {
        mListener.changeFragment(FragmentsId.DETAILS_MARKET, FragmentsAnimationId.RIGHT_TO_LEFT);
    }

    public interface OnFragmentInteractionListener extends FragmentChangedEvent {

    }
}
