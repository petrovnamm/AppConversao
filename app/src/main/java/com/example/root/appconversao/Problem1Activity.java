package com.example.root.appconversao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Problem1Activity extends AppCompatActivity {

    private Button btnResultProblem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphic_app_conversao);

        btnResultProblem1 = findViewById(R.id.btnResult);
        btnResultProblem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to do
                //openResultProblem2();
            }
        });

    }

}
