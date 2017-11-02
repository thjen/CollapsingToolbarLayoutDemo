package com.example.thjen.collapsingtoolbarlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView paralaxActivity = (TextView)findViewById(R.id.parallax);
        TextView expandingActivity = (TextView)findViewById(R.id.expandable);
        TextView hideActivity = (TextView)findViewById(R.id.hide);
        TextView nested = (TextView)findViewById(R.id.netedscroll);

        expandingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpandableToolBarActivity.class));
            }
        });

        paralaxActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ParalaxToolbarActivity.class));
            }
        });

        hideActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HiddenToolbar.class));
            }
        });

        nested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NestedToolbar.class));
            }
        });


    }

}
