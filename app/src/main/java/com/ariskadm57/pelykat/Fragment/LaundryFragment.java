package com.ariskadm57.pelykat.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariskadm57.pelykat.Activity.MainActivity;
import com.ariskadm57.pelykat.Adapter.LaundryAdapter;
import com.ariskadm57.pelykat.Model.Laundry;
import com.ariskadm57.pelykat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaundryFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    private List<Laundry> list_laundry = new ArrayList<>();
    private RecyclerView recyclerView;
    private LaundryAdapter laundryAdapter;

    public LaundryFragment() {
    }

    public static LaundryFragment newInstance() {
        return new LaundryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laundry, container, false);
        recyclerView = view.findViewById(R.id.rv_laundry);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        list_laundry = ((MainActivity)getActivity()).getDataLaundryList();
        laundryAdapter = new LaundryAdapter(getActivity(), list_laundry );
        laundryAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(laundryAdapter);


//        recyclerView.addOnItemTouchListener();

        return view;

    }

    public interface OnFragmentInteractionListener {
    }

}
