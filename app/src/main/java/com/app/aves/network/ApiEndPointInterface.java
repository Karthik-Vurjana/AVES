package com.app.aves.network;

import com.app.aves.Response;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiEndPointInterface {


    @GET("/photos/?client_id=8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8")
    Call<List<Response>>fetchPhotos();




}
