package com.example.camilovelasco.notascamilovelasco;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView t1,t2;
    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(prefe.getString("",""));
        et2.setText(prefe.getString("",""));
        et3.setText(prefe.getString("",""));
    }
    public void acercade(View view) {
        Intent i = new Intent(this, Acercade.class );
        startActivity(i);
    }

    public void calcular(View view)
    {

        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("", et1.getText().toString());
        editor.putString("", et2.getText().toString());
        editor.putString("", et3.getText().toString());
        editor.commit();

        String valor1=et1.getText().toString();
        Float valor2=Float.parseFloat(et2.getText().toString());
        Float valor3=Float.parseFloat(et3.getText().toString());
        double nro1=Integer.parseInt(valor1);
        double  nro2 = valor2;
       double  nro3 = valor3;
        DecimalFormat df =new DecimalFormat("####.##");
        //double form= (nro1+nro2+nro3) /3;
        double form= ((nro1*0.3)+(nro2*0.3)+(nro3*0.4));
        t1.setText(df.format(form));
    }

       public void falta(View view)
    {
        String valor1=et1.getText().toString();
        Float valor2=Float.parseFloat(et2.getText().toString());

        double nro1=Integer.parseInt(valor1);
        double  nro2 = valor2;

        DecimalFormat df =new DecimalFormat("####.##");
        double form= (nro1+nro2) /3;
        t2.setText(df.format(form));



        }



    }


