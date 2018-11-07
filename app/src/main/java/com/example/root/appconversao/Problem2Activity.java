package com.example.root.appconversao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2Activity extends AppCompatActivity {

    private Button btnResultProblem2;
    private Spinner dropdownEnsaio;
    public double[] results;

    public static final String EXTRA_ENSAIO = "com.example.application.appconversao.EXTRA_ENSAIO";
    public static final String EXTRA_TENSAO = "com.example.application.appconversao.EXTRA_TENSAO";
    public static final String EXTRA_CORRENTE = "com.example.application.appconversao.EXTRA_CORRENTE";
    public static final String EXTRA_POTENCIA = "com.example.application.appconversao.EXTRA_POTENCIA";
    public static final String EXTRA_RESULTS = "com.example.application.appconversao.EXTRA_RESULTS";

    private String ensaio;
    private double tensaoValue;
    private double correnteValue;
    private double potenciaValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_app_conversao);

        dropdownEnsaio = findViewById(R.id.spinnerEnsaio);
        String[] items = new String[]{ "Circuito Aberto", "Curto-Circuito" };
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdownEnsaio.setAdapter(adapter);

        btnResultProblem2 = findViewById(R.id.btnResult);
        btnResultProblem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to do
                openResultProblem2();
            }
        });
    }

    //to do
    public void openResultProblem2(){
        ensaio = dropdownEnsaio.getSelectedItem().toString();

        EditText tensao = findViewById(R.id.tensaoInputada);
        tensaoValue = Double.parseDouble(tensao.getText().toString());

        EditText corrente = findViewById(R.id.correnteInputada);
        correnteValue = Double.parseDouble(corrente.getText().toString());

        EditText potencia = findViewById(R.id.potenciaInputada);
        potenciaValue = Double.parseDouble(potencia.getText().toString());

        results = calculateResults();

        Intent intent = new Intent(this, ResultProblem2Activity.class);
        intent.putExtra(EXTRA_ENSAIO, ensaio);
        intent.putExtra(EXTRA_TENSAO, tensaoValue);
        intent.putExtra(EXTRA_CORRENTE, correnteValue);
        intent.putExtra(EXTRA_POTENCIA, potenciaValue);
        intent.putExtra(EXTRA_RESULTS, results);
        startActivity(intent);
    }

    private double[] calculateResults(){
        //result indexes
        //0 = rc, 1 = xm
        //2 = r1, 3 = x1, 4 = r2, 5 = x2
        double[] result = new double[6];

        //Circuito Aberto
        //rc = V² / P
        result[0] = Math.pow(tensaoValue, 2) / potenciaValue;

        //xm = V²/Q, onde Q = sqrt(S² - P²), logo xm = V² / sqrt(S² - P²)
        //result[1] = Math.pow(tensaoValue, 2) / Math.sqrt(Math.pow(1000, 2) - Math.pow(potenciaValue, 2));
        result[1] = 1 / Math.sqrt(Math.pow((1 / Math.abs(tensaoValue/correnteValue)), 2) - Math.pow((1 / result[0]), 2));


        //Curto Circuito
        //r1 = r2 = req / 2, pois precisamos inferir
        //req = P / I², logo r1 e r2 = (P/I²) / 2
        result[2] = result[4] = (potenciaValue/Math.pow(correnteValue, 2)) / 2;

        //x1 = x2 = xeq / 2, pois precisamos inferir
        //xeq = sqrt(abs(zeq)² - req²)) e zeq = V/I, logo
        //xeq = sqrt(abs(V/I)² - req²))
        result[3] = result[5] = Math.sqrt(
                Math.abs(Math.pow((tensaoValue / correnteValue), 2)) -
                Math.pow(potenciaValue / Math.pow(correnteValue, 2), 2)
        ) / 2;


        if (Double.isNaN(result[3])){
            //cálculo deu errado
            result[3] = result[5] = 0;
        }

        return result;
    }
}
