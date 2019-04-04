package com.vogella.android.picsum;

import com.vogella.android.picsum.Modèle.Picsum;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ProgressBar loader;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_picsum);
        loader = findViewById(R.id.loader_main_activity);

        controller = new MainController(this);
        controller.onCreate();
    }

    public void showLoader(){
        loader.setVisibility(View.VISIBLE);
    }

    public void hideLoader(){
        loader.setVisibility(View.GONE);
    }

    public void showList(List<Picsum> list){
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(list);
        recyclerView.setAdapter(mAdapter);
    }
}
