package com.example.recyclerview_retrofit;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface Methods {
    @FormUrlEncoded
    @POST("/api/users")
    Call<Model> getUserInformation(@Field("name") String name, @Field("job") String job);
}


