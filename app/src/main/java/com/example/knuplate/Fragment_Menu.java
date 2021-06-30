package com.example.knuplate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_Menu extends Fragment {

    public static Fragment_Menu newInstance() {
        return new Fragment_Menu();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.menu_fragment, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //test
        ArrayList<MenuData> arrayList = new ArrayList<>();
        MenuAdapter menuAdapter = new MenuAdapter(arrayList);
        recyclerView.setAdapter(menuAdapter);

        MenuData testdata1 = new MenuData("TestData1", 80);
        MenuData testdata2 = new MenuData("TestData2", 20);
        MenuData testdata3 = new MenuData("TestData3", 38);
        arrayList.add(testdata1);
        arrayList.add(testdata2);
        arrayList.add(testdata3);
        arrayList.add(testdata2);
        arrayList.add(testdata1);
        arrayList.add(testdata2);
        arrayList.add(testdata3);


        return v;
    }
}