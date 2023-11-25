package com.example.apnidiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class DiaryAndQuotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_and_quotes);
        String key=getIntent().getStringExtra("fragment");
        if(Objects.equals(key, "diary"))
        openFragment2(new DiaryFragment());
        else if(Objects.equals(key, "quotes"))
            openFragment2(new QuotesFragment());
    }

    public void openFragment2(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.DiaryAndQuotes_framelayout,fragment);
        ft.commit();
    }
}