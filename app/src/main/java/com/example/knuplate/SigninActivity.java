package com.example.knuplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knuplate.model.UserData;
import com.example.knuplate.network.RetrofitClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        final HashMap<String, String> loginMap = new HashMap();

        Button signin_button = findViewById(R.id.signin_button);
        EditText user_name = findViewById(R.id.signin_edit1);
        EditText password = findViewById(R.id.signin_edit2);

        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginMap.put("user_name", user_name.getText().toString());
                loginMap.put("password", password.getText().toString());
                RetrofitClient.request(cbLogin, "call_login", loginMap);
            }
        });
    }

    Callback cbLogin = new Callback<UserData>() {
        private final static String TAG = "RetrofitCommunication";
        String cbTAG = "레트로핏 - cbLogin()";

        @Override
        public void onResponse(Call<UserData> call, Response<UserData> response) {
            if (response.isSuccessful()) {
                UserData userData = response.body();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<UserData> call, Throwable t) {
            Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(2) " + t);
        }
    };

}