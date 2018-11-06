package com.example.root.appconversao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Problem2Activity extends AppCompatActivity {

    private Button btnResultProblem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_app_conversao);

        btnResultProblem2 = findViewById(R.id.btnResult);
        btnResultProblem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to do
                //openResultProblem2();
            }
        });
    }

    //to do
    //public openResultProblem2(){
    //
    //}
}
