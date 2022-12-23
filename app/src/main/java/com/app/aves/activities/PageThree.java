package com.app.aves.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.aves.R;
import com.app.aves.databinding.PageThreeBinding;
import com.bumptech.glide.Glide;

import java.util.Objects;

public class PageThree extends AppCompatActivity {

    PageThreeBinding pageThreeBinding;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageThreeBinding=PageThreeBinding.inflate(getLayoutInflater());
        setContentView(pageThreeBinding.getRoot());

        toolbar=pageThreeBinding.toolbar;


        toolbar.setTitle("PROFILE");
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(view -> finish());
        String dp=getIntent().getStringExtra("DP");
        Glide.with(this).load(dp).into(pageThreeBinding.dp);
        pageThreeBinding.textView5.setText(getIntent().getStringExtra("UN"));
        pageThreeBinding.textView6.setText("Location");
        pageThreeBinding.textView7.setText(getIntent().getStringExtra("BIO"));









    }
}
