package com.app.aves.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.app.aves.databinding.PageTwoBinding;
import com.bumptech.glide.Glide;

public class PageTwo extends AppCompatActivity {

    PageTwoBinding pageTwoBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageTwoBinding=PageTwoBinding.inflate(getLayoutInflater());
        setContentView(pageTwoBinding.getRoot());

        String image=getIntent().getStringExtra("IMAGE");
        Glide.with(this).load(image).into(pageTwoBinding.imageView3);
        pageTwoBinding.imageView2.setOnClickListener(view -> finish());


    }
}
