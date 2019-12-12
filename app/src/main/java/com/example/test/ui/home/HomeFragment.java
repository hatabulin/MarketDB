package com.example.test.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.test.R;
import com.example.test.model.events.FragmentChangedEvent;
import com.example.test.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeFragmentView.View {

    private HomeFragmentView.Presenter presenter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public interface OnFragmentInteractionListener extends FragmentChangedEvent {

    }
}
