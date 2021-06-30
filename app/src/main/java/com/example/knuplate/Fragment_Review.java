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

        ReviewData testdata = new ReviewData(R.drawable.profile_icon_default, "testdata1", R.drawable.testpicture, R.drawable.star_rating_unfilled, "test1");
        ReviewData testdata2 = new ReviewData(R.drawable.location_icon, "testdata2", R.drawable.testpicture, R.drawable.star_rating, "test2");
        ReviewData testdata3 = new ReviewData(R.drawable.star_rating_unfilled, "testdata3", R.drawable.testpicture, R.drawable.star_rating, "test3");
        arrayList.add(testdata);
        arrayList.add(testdata2);
        arrayList.add(testdata3);
        arrayList.add(testdata);
        arrayList.add(testdata2);


        return v;
    }
}