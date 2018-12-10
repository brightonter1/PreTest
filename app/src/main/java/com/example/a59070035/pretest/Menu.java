package com.example.a59070035.pretest;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a59070035.pretest.SqlLite.AccountFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    private ListView lMenu;
    private String[] mMenu = {"Image", "Write", "SQLite"};


    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayAdapter<String> mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mMenu);
        lMenu = getView().findViewById(R.id.menu_list);
        lMenu.setAdapter(mAdapter);
        lMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (mAdapter.getItem(i)){
                    case "Image":
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new Image())
                                .addToBackStack(null)
                                .commit();
                    case "Write":
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new Write())
                                .addToBackStack(null)
                                .commit();
                    case "SQLite":
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new AccountFragment())
                                .addToBackStack(null)
                                .commit();
                }
            }
        });

        sharedPreference();
    }

    public void sharedPreference(){
        SharedPreferences sp = getActivity().getSharedPreferences("Center", Context.MODE_PRIVATE);
        sp.edit().putString("name", "Chayut Aroonsang").apply();
        Log.d("System", sp.getString("name", "0"));

    }
}
