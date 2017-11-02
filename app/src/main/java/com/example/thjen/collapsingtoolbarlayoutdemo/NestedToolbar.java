package com.example.thjen.collapsingtoolbarlayoutdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.transition.Transition;
import android.support.transition.Visibility;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.type;

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

        if ( isNetworkConnected() ) {
            Toast.makeText(this, "Is connection", Toast.LENGTH_SHORT).show();
        } else {

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setTitle("No internet");
            dialog.setMessage("Would you want to enable wifi");

            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            });

            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            dialog.show();

        }

    }

    private void setData() {
        stringArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stringArrayList.add("Item " + (i + 1));
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}
