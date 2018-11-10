package com.example.root.appconversao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class GraphicActivity extends AppCompatActivity {
    private Button btnBackHome;
    private Button btnChange;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphic_app_conversao);

        Intent intent = getIntent();

        btnBackHome = findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });

        btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });
    }

    public void goToHome(){
        Intent intent = new Intent(this, AppConversao.class);
        startActivity(intent);
    }

    public void change(){
        Intent intent = new Intent(this, changeActivity.class);
        startActivity(intent);
    }


}
