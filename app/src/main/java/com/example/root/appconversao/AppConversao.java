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

public class AppConversao extends AppCompatActivity {
    private Button btnProblem1;
    private Button btnProblem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_app_conversao);

        btnProblem2 = findViewById(R.id.button2);
        btnProblem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProblem2();
            }
        });

        btnProblem1 = findViewById(R.id.button1);
        btnProblem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to do
                openProblem1();
            }
        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void openProblem1(){
        Intent intent = new Intent(this, Problem2Activity.class);
        startActivity(intent);
    }

    public void openProblem2(){
        Intent intent = new Intent(this, Problem2Activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_app_conversao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
