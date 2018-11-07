package com.example.root.appconversao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultProblem2Activity extends AppCompatActivity {

    private Button btnBackHome;
    private Button btnBackProb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_app_conversao);

        Intent intent = getIntent();

        String ensaio = intent.getStringExtra(Problem2Activity.EXTRA_ENSAIO);
        double tensao = intent.getDoubleExtra(Problem2Activity.EXTRA_TENSAO, 0);
        double corrente = intent.getDoubleExtra(Problem2Activity.EXTRA_CORRENTE, 0);
        double potencia = intent.getDoubleExtra(Problem2Activity.EXTRA_POTENCIA, 0);
        double[] results = intent.getDoubleArrayExtra(Problem2Activity.EXTRA_RESULTS);

        //Inputs
        TextView ensaioInputado = findViewById(R.id.ensaioInputado);
        ensaioInputado.setText(ensaio);

        TextView tensaoInputada = findViewById(R.id.tensaoInputada);
        tensaoInputada.setText(String.format("V = " + "%.2f" + " [V]", tensao));

        TextView correnteInputada = findViewById(R.id.correnteInputada);
        correnteInputada.setText(String.format("I = %.2f" + " [A]", corrente));

        TextView potenciaInputada = findViewById(R.id.potenciaInputada);
        potenciaInputada.setText(String.format("P = %.0f" + " [W]", potencia));

        //Results
        if (ensaio.equals("Circuito Aberto")){
            //Setar Rc e Xm (indexes 0 e 1 do array results)
            TextView rc = findViewById(R.id.rcOutput);
            rc.setText(String.format("Rc = %f", results[0]));

            TextView xm = findViewById(R.id.xmOutput);
            xm.setText(String.format("Xm = %f", results[1]));
        } else {
            //Setar R1, X1, R2 e X2 (indexes de 2 a 5 do array results)
            TextView r1 = findViewById(R.id.r1Output);
            r1.setText(String.format("R1 = %f", results[2]));

            TextView x1 = findViewById(R.id.x1Output);
            x1.setText(String.format("X1 = %f", results[3]));

            TextView r2 = findViewById(R.id.r2Output);
            r2.setText(String.format("R2 = %f", results[4]));

            TextView x2 = findViewById(R.id.x2Output);
            x2.setText(String.format("X2 = %f", results[5]));
        }

        btnBackHome = findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });

        btnBackProb2 = findViewById(R.id.btnBackProb2);
        btnBackProb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProb2();
            }
        });
    }

    public void goToHome(){
        Intent intent = new Intent(this, AppConversao.class);
        startActivity(intent);
    }

    public void goToProb2(){
        Intent intent = new Intent(this, Problem2Activity.class);
        startActivity(intent);
    }
}
