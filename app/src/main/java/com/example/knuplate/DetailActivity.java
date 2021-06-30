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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    Button button;
    RecyclerView recyclerView;
    int CODE_ALBUM_REQUEST = 111;
    Fragment review_fragment, menu_fragment, location_fragment;
    ArrayList<Uri> uriList = new ArrayList<>();
    UriImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView likebut_detail = findViewById(R.id.likebut_detail);
        ImageView ratebut_detail = findViewById(R.id.ratebut_detail);

        button= findViewById(R.id.button);
        recyclerView= findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
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

        //하트, 별 클릭리스너
        likebut_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likebut_detail != null) {
                    likebut_detail.setSelected(!likebut_detail.isSelected());
                }
            }
        });

        ratebut_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ratebut_detail != null) {
                    ratebut_detail.setSelected(!ratebut_detail.isSelected());
                }
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
            if(data == null){   // 어떤 이미지도 선택하지 않은 경우
                Toast.makeText(getApplicationContext(), "이미지를 선택하지 않았습니다.", Toast.LENGTH_LONG).show();
            }
            else {   // 이미지를 하나라도 선택한 경우
                if (data.getClipData() == null) {     // 이미지를 하나만 선택한 경우
                    Log.e("single choice: ", String.valueOf(data.getData()));
                    Uri imageUri = data.getData();
                    uriList.add(imageUri);

                    adapter = new UriImageAdapter(uriList, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
                } else {      // 이미지를 여러장 선택한 경우
                    ClipData clipData = data.getClipData();
                    Log.e("clipData", String.valueOf(clipData.getItemCount()));

                    if (clipData.getItemCount() > 10) {   // 선택한 이미지가 11장 이상인 경우
                        Toast.makeText(getApplicationContext(), "사진은 10장까지 선택 가능합니다.", Toast.LENGTH_LONG).show();
                    } else {   // 선택한 이미지가 1장 이상 10장 이하인 경우

                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            Uri imageUri = clipData.getItemAt(i).getUri();  // 선택한 이미지들의 uri를 가져온다.
                            try {
                                uriList.add(imageUri);  //uri를 list에 담는다.

                            } catch (Exception e) {

                            }
                        }
                        adapter = new UriImageAdapter(uriList, getApplicationContext());
                        recyclerView.setAdapter(adapter);   // 리사이클러뷰에 어댑터 세팅
                        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));     // 리사이클러뷰 수평 스크롤 적용
                    }
                }
            }
    } //end of onActivityResult


} //end of Activity


