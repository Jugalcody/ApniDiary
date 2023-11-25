package com.example.apnidiary;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
AppCompatButton login;
EditText e1,e2;
ImageView back;
TextView signup_login_text;
CardView card_login,card_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login=findViewById(R.id.login);
        e1=findViewById(R.id.login_edit1);
        e2=findViewById(R.id.login_edit2);

        back=findViewById(R.id.backArrow);

        card_login=findViewById(R.id.card_login);
        card_register=findViewById(R.id.card_register);


        signup_login_text=findViewById(R.id.signup_login_text);
        signup_login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_login.setVisibility(View.GONE);
                card_register.setVisibility(View.VISIBLE);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_login.setVisibility(View.VISIBLE);
                card_register.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onBackPressed() {
   if(card_login.getVisibility()==View.GONE){
       Intent i=new Intent(getApplicationContext(), LoginPage.class);
       startActivity(i);
        }
        super.onBackPressed();
    }
}