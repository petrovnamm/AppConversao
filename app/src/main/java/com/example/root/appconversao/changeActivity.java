package com.example.root.appconversao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class changeActivity extends AppCompatActivity {

    private Button btnResultChange;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_graphic);

        btnResultChange = findViewById(R.id.btnResultG);
        btnResultChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGraphic();
            }
        });
    }
    public void openGraphic(){
        Intent intent = new Intent(this, GraphicActivity.class);
        startActivity(intent);
    }

}
