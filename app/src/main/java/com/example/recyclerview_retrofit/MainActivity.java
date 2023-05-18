package com.example.recyclerview_retrofit;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///photos
public class MainActivity extends AppCompatActivity {
    private Button btnSendPostRequest;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendPostRequest = findViewById(R.id.btnSendPostRequest);
        btnSendPostRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSendPostRequest();
            }
        });
    }

    private void btnSendPostRequest() {
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<Model> call = methods.getUserInformation(" madhu keerthana", "Android Develper");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.e(TAG, "onResponse: " + response.code());
                Log.e(TAG, "onResponse: name : " + response.body().getName());
                Log.e(TAG, "onResponse: job : " + response.body().getJob());
                Log.e(TAG, "onResponse:  created at : " + response.body().getCreatedAt());
                Log.e(TAG, "onResponse:  id : " + response.body().getId());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e(TAG, "OnFailure: " + t.getMessage());

            }
        });

    }
}