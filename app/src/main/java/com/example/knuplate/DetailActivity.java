package com.example.knuplate;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    Button button;
    RecyclerView recyclerView;
    int CODE_ALBUM_REQUEST = 111;
    Fragment review_fragment, menu_fragment, location_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        button= findViewById(R.id.button);
        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //리사이클러뷰 사진선택 code
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, CODE_ALBUM_REQUEST);
            }
        });

        //TabLayout-FragmentLayout
        review_fragment = new Fragment_Review();
        menu_fragment = new Fragment_Menu();
        location_fragment = new Fragment_Location();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, review_fragment).commit();
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                                          @Override
                                          public void onTabSelected(TabLayout.Tab tab) {

                                              int position = tab.getPosition();

                                              Fragment selected = null;

                                              if(position == 0){
                                                  selected = review_fragment;
                                              }
                                              else if (position == 1){
                                                  selected = location_fragment;
                                              }
                                              else if (position == 2){
                                                  selected = menu_fragment;
                                              }

                                              getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
                                          }

                                          @Override
                                          public void onTabUnselected(TabLayout.Tab tab) {

                                          }

                                          @Override
                                          public void onTabReselected(TabLayout.Tab tab) {

                                          }
                                      });
    }

        //앨범 이미지 가져오기
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            //갤러리 이미지 가져오기
            if (requestCode == CODE_ALBUM_REQUEST && resultCode == RESULT_OK && data != null) {
                ArrayList<Uri> uriList = new ArrayList<>();
                if (data.getClipData() != null) {
                    ClipData clipData = data.getClipData();
                    if (clipData.getItemCount() > 10) { // 10개 초과하여 이미지를 선택한 경우
                        Toast.makeText(DetailActivity.this, "사진은 10개까지 선택가능 합니다.", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (clipData.getItemCount() == 1) { //멀티선택에서 하나만 선택한 경우
                        Uri filePath = clipData.getItemAt(0).getUri();
                        uriList.add(filePath);
                    } else if (clipData.getItemCount() > 1 && clipData.getItemCount() <= 10) { //1개초과  10개 이하의 이미지선택한 경우
                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            uriList.add(clipData.getItemAt(i).getUri());
                        }
                    }
                }
                //리사이클러뷰에 보여주기
                UriImageAdapter adapter = new UriImageAdapter(uriList, DetailActivity.this);
                recyclerView.setAdapter(adapter);
            }
        } //end of onActivityResult


    } //end of Activity

