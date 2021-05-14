package com.example.knuplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.knuplate.model.SignUpData;
import com.example.knuplate.model.UserData;
import com.example.knuplate.network.RetrofitClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    //ui
    EditText user_name;
    EditText display_name;
    EditText password;
    EditText mail_address;
    Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final HashMap<String, String> signUpMap = new HashMap();

        user_name = (EditText)findViewById(R.id.signup_edit1);
        display_name = (EditText)findViewById(R.id.signup_edit2);
        password = (EditText)findViewById(R.id.signup_edit3);
        mail_address = (EditText)findViewById(R.id.signup_edit5); //ui 수정해야함
        signup_btn = (Button) findViewById(R.id.signup_button);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpMap.put("user_name", user_name.getText().toString());
                signUpMap.put("display_name", display_name.getText().toString());
                signUpMap.put("password", password.getText().toString());
                signUpMap.put("mail_address", mail_address.getText().toString());

                RetrofitClient.request(cbSignUp,"call_signup",signUpMap);
            }
        });
    }

    Callback cbSignUp = new Callback<SignUpData>() {
        private final static String TAG = "RetrofitCommunication";
        String cbTAG = "레트로핏 - cbSignUp()";

        @Override
        public void onResponse(Call<SignUpData> call, Response<SignUpData> response) {
            if (response.isSuccessful()) {
                SignUpData signUpData = response.body();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            } else {
                Log.e(TAG, cbTAG + "레트로핏 콜백 요청 실패(1) ");
                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call call, Throwable t) {

        }
    };
}