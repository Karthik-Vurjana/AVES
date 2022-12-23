package com.app.aves.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app.aves.Response;
import com.app.aves.adapters.PhotosAdapter;
import com.app.aves.databinding.ActivityMainBinding;
import com.app.aves.network.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        recyclerView=activityMainBinding.recyclerView;

        fetchPhotos();

    }

    private void fetchPhotos() {

        Call<List<com.app.aves.Response>> call= RetrofitBuilder.getInstance().getRetrofit().fetchPhotos();
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    assert response.body() != null;

                    bindDataFromApi(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                Log.e("Error",t.toString());
            }
        });



    }

    private void bindDataFromApi(List<Response> response) {

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        PhotosAdapter photosAdapter=new PhotosAdapter(response,this);
        recyclerView.setAdapter(photosAdapter);


    }
}