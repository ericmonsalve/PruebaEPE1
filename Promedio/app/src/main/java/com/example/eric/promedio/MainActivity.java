package com.example.eric.promedio;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText nota1,nota2,nota3,nota4;

     EditText et_va1,et_va2,et_va3,et_va4,et_exa;
     Button calcular, datos, btn_final;
     TextView resultado, resultado_final;
     double almacenar_solemnes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 =(EditText) findViewById(R.id.et_nota1);
        nota2 =(EditText) findViewById(R.id.et_nota2);
        nota3 =(EditText) findViewById(R.id.et_nota3);
        nota4 =(EditText) findViewById(R.id.et_nota4);

        et_va1 =(EditText) findViewById(R.id.et_eva1);
        et_va2 =(EditText) findViewById(R.id.et_eva2);
        et_va3 =(EditText) findViewById(R.id.et_eva3);
        et_va4 =(EditText) findViewById(R.id.et_eva4);
        et_exa =(EditText) findViewById(R.id.et_examen);

        calcular = (Button) findViewById(R.id.btn_calcular);
        btn_final = (Button) findViewById(R.id.btn_final);

        resultado = (TextView) findViewById(R.id.tv_resultado);

        datos = (Button) findViewById(R.id.btn_datos);

    }

    public void calcular(View v){

        double epr1 = 10*(0.10*Integer.valueOf(nota1.getText().toString()))/100;
        double epe1 = 15*(0.10*Integer.valueOf(nota2.getText().toString()))/100;
        double epr2 = 20*(0.10*Integer.valueOf(nota3.getText().toString()))/100;
        double epe2 = 25*(0.10*Integer.valueOf(nota4.getText().toString()))/100;

        double eva1 = Integer.valueOf(et_va1.getText().toString())*0.1;
        double eva2 = Integer.valueOf(et_va2.getText().toString())*0.1;
        double eva3 = Integer.valueOf(et_va3.getText().toString())*0.1;
        double eva4 = Integer.valueOf(et_va4.getText().toString())*0.1;

        double suma_solemne = epr1+epe1+epr2+epe2;
        double suma_evas = ((eva1+eva2+eva3+eva4)/4)*0.3;
        double promedio_final = suma_solemne+suma_evas ;

        almacenar_solemnes = promedio_final;

        resultado.setText(Double.toString(promedio_final));

        if (promedio_final<5.5){
            et_exa.setEnabled(true);
            btn_final.setEnabled(true);
            et_exa.requestFocus();

        }
        else{
            Context cuadro = getApplicationContext();
            Toast.makeText(cuadro, "Alumno Eximido y Aprobado",Toast.LENGTH_SHORT).show();
        }


    }

    public void calcular_promfinal(View v ){

        double porcentaje_solemne =  almacenar_solemnes*0.7;
        double porcentaje_examen = 30*(0.10*Integer.valueOf(et_exa.getText().toString()))/100;

        double suma_porcentajes = porcentaje_examen+porcentaje_solemne;

        resultado_final = (TextView) findViewById(R.id.tv_resultado_final);
        resultado_final.setText(Double.toString(suma_porcentajes));

        if (suma_porcentajes<4.0){

            Context dialogo = getApplicationContext();
            Toast.makeText(dialogo, "Alumno Reprobado",Toast.LENGTH_SHORT).show();
        }
        else{
            Context dialogo = getApplicationContext();
            Toast.makeText(dialogo, "Alumno Aprobado",Toast.LENGTH_SHORT).show();
        }

    }

    public void enviar_datos(View v){

        startActivity(new Intent(MainActivity.this,datosActivity.class));


    }


}
