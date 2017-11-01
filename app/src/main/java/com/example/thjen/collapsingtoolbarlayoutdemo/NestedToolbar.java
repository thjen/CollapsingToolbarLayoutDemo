package com.example.thjen.collapsingtoolbarlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by thjen on 1/11/2017.
 */

public class NestedToolbar extends AppCompatActivity {

    private ArrayList<String> stringArrayList;
    private ListView recyclerView;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_scroll);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (ListView) findViewById(R.id.recycler);

        ViewCompat.setNestedScrollingEnabled(recyclerView, true);

        setData(); //adding data to array list
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArrayList);
        recyclerView.setAdapter(adapter);

    }

    private void setData() {
        stringArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stringArrayList.add("Item " + (i + 1));
        }
    }

}
