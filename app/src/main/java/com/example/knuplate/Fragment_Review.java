package com.example.knuplate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment_Review extends Fragment {

    public static Fragment_Review newInstance() {
        return new Fragment_Review();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.review_fragment, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //test
        ArrayList<ReviewData> arrayList = new ArrayList<>();
        ReviewAdapter reviewAdapter = new ReviewAdapter(arrayList);
        recyclerView.setAdapter(reviewAdapter);
        recyclerView.setAdapter(reviewAdapter);

        ReviewData testdata = new ReviewData(R.drawable.profile_icon_default, "test", R.drawable.testpicture, R.drawable.star_rating_unfilled, "test");
        arrayList.add(testdata);
        arrayList.add(testdata);
        arrayList.add(testdata);
        arrayList.add(testdata);
        arrayList.add(testdata);


        return v;
    }



}