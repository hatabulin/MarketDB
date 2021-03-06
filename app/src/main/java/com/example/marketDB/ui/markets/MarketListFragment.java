package com.example.marketDB.ui.markets;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketDB.R;
import com.example.marketDB.model.events.FragmentChangedEvent;
import com.example.marketDB.model.interactor.interactors.MarketInteractor;
import com.example.marketDB.model.models.MarketWithStockModel;
import com.example.marketDB.model.repositorys.DatabaseRepositoryImpl;
import com.example.marketDB.ui.base.BaseFragment;
import com.example.marketDB.ui.base.dialogs.AddRecordDialog;
import com.example.marketDB.utils.fragments.FragmentsAnimationId;
import com.example.marketDB.utils.fragments.FragmentsId;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MarketListFragment extends BaseFragment implements MarketListFragmentView.View {


    private MarketListFragmentView.Presenter presenter;

    private OnFragmentInteractionListener mListener;
    private MarketWithStockAdapter adapter;
    //    private MarketAdapter adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton btn_add;

    public MarketListFragment() {
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
        adapter = new MarketWithStockAdapter(getContext());
        recyclerView = v.findViewById(R.id.recyclerView);

        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.recycler_layout_item_animation);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        btn_add = v.findViewById(R.id.fab_market);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddRecordDialog addRecordDialog = new AddRecordDialog();

                addRecordDialog.registerEvent(new AddRecordDialog.Event() {
                    @Override
                    public void confirm(String nameMarket, int stockId) {
                        presenter.addRecord(nameMarket, stockId);
                    }

                    @Override
                    public void failed() {

                    }

                    @Override
                    public void isDismis() {

                    }
                });
                addRecordDialog.show(getChildFragmentManager(), addRecordDialog.getClass().getSimpleName());
            }
        });

        adapter.registerEvent(new MarketWithStockAdapter.Event() {
            @Override
            public void click(Long id) {
                presenter.setSelectedId(id);
            }
        });

        ImageView iv_toolbar_back = v.findViewById(R.id.iv_toolbar_back);
        iv_toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //        mListener.changeFragment(FragmentsId.HOME, FragmentsAnimationId.LEFT_TO_RIGHT);
            }
        });

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
