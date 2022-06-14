package com.dinesh.recyclerview_masterv10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewLayout extends AppCompatActivity {
    TextView textView5,textView6,textView7,textView8;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);


        String ID = getIntent().getStringExtra("ID");
        String movieName = getIntent().getStringExtra("NAME");
        String Email = getIntent().getStringExtra("Email");
        String Mobile = getIntent().getStringExtra("Mobile");
        textView5.setText(ID);
        textView6.setText(movieName);
        textView7.setText(Email);
        textView8.setText(Mobile);
    }
}
