package com.example.recyclercard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class listfrag extends Fragment {

 RecyclerView recyclerView;
 RecyclerView.Adapter myadapter;
 RecyclerView.LayoutManager manager;
 View view;


    public listfrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listfrag, container, false);
        // Inflate the layout for this fragment
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        manager  = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(manager);
        myadapter = new Personadapter(this.getActivity(),ApplicationClass.people);
        recyclerView.setAdapter(myadapter);
    }
    public void notifyDataChanged()
    {
        myadapter.notifyDataSetChanged();
    }
}