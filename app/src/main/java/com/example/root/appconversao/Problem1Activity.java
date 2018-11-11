package com.example.root.appconversao;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class Problem1Activity extends AppCompatActivity {

    private Button btnChange;
    private Button btnBackHome;
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphic_app_conversao);

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
                //to do
                //openScreenChangeParameters();
            }
        });

        lineChart = findViewById(R.id.lineChart);

        ArrayList<String> xAXES = new ArrayList<>();
        ArrayList<Entry> yAXESsin = new ArrayList<>();
        ArrayList<Entry> yAXEScos = new ArrayList<>();
        double x = 0;
        int numDataPoints = 1000;

        for(int i = 0; i < numDataPoints; i++){
            float sinFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            float cosFunction = Float.parseFloat(String.valueOf(Math.cos(x)));

            x += 0.1;

            yAXESsin.add(new Entry(sinFunction, i));
            yAXEScos.add(new Entry(cosFunction, i));
            xAXES.add(i, String.valueOf(x));
        }

        String[] xaxes = new String[xAXES.size()];
        for(int i = 0; i < xAXES.size(); i++){
            xaxes[i] = xAXES.get(i).toString();
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet lineDataSet1 = new LineDataSet(yAXEScos, "cos");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);

        LineDataSet lineDataSet2 = new LineDataSet(yAXESsin, "sin");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);

        //add as duas linhas de dados
        //lineChart.setData(new LineData(xaxes, lineDataSets));
        lineChart.setData(new LineData(lineDataSets));

        lineChart.setVisibleXRangeMaximum(65f);
    }

    public void goToHome(){
        Intent intent = new Intent(this, AppConversao.class);
        startActivity(intent);
    }
}
