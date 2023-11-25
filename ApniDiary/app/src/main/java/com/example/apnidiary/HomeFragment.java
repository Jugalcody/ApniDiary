package com.example.apnidiary;

import com.example.apnidiary.DiaryAndQuotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
CardView card1,card2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        card1=view.findViewById(R.id.homeFragment_card1);
        card2=view.findViewById(R.id.homeFragment_card2);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent i=new Intent(getActivity(), DiaryAndQuotes.class);
                i.putExtra("fragment","diary");
               startActivity(i);
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getActivity(), DiaryAndQuotes.class);
                i.putExtra("fragment","quotes");
                startActivity(i);
            }
        });
        return view;
    }
}