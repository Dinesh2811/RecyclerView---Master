package com.dinesh.recyclerview_masterv10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvMain extends AppCompatActivity implements RvInterface {

    ArrayList<RvModel> rvModels = new ArrayList<>();
    RvAdapter rvAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_main);
        recyclerView = findViewById(R.id.recyclerView);

//sample Model data
        for (int i = 0; i < 50; i++) {
            rvModels.add(new RvModel("" + i, "Dinesh" + i, "dk" + i + "@gmail.com", "866" + i));
        }

        rvAdapter = new RvAdapter(rvModels, RvMain.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(rvAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, NewLayout.class);
        intent.putExtra("ID", rvModels.get(position).id);
        intent.putExtra("NAME", rvModels.get(position).name);
        intent.putExtra("Email", rvModels.get(position).name);
        intent.putExtra("Mobile", rvModels.get(position).email);
        startActivity(intent);

    }
}
