package com.example.android2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.AlertDialog;
import android.widget.Toast;

public class Exercicio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AlertDialog.Builder dialog= new AlertDialog.Builder(this);
        dialog.setTitle("titulo");
        dialog.setMessage("Mensagem");
        dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //logica do botao neutro
            }
        });
        dialog.setPositiveButton(R.string.next, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //logica do botao positivo
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("No",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //logica do botao negativo
            }
        });
        dialog.create();
        dialog.show();

        Toast.makeText(this, "Resuming activity...", Toast.LENGTH_LONG).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1);

        Button bt=(Button) findViewById(R.id.buttonExercicio1);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText campoFaltas=(EditText) findViewById(R.id.editTextTextPersonQtdeFaltas);
                EditText campoAulas=(EditText) findViewById(R.id.editTextTextPersonQtdeAulas);
                TextView tvResultado=(TextView) findViewById(R.id.textResultado);
                TextView tvPercentual=(TextView) findViewById(R.id.textViewPercentual);

                int qtdFaltas=Integer.valueOf(campoFaltas.getText().toString());
                int qtdAulas=Integer.valueOf(campoAulas.getText().toString());
                double percentual=qtdFaltas/qtdAulas;
                if(percentual>=0.7){
                    tvResultado.setText("Reprovado");
                }
                String percentualFormatado=String.valueOf(Math.round(percentual*100))+"%";
                tvPercentual.setText(percentualFormatado);
                v.getContext().getApplicationContext();

            }

        });
    }
}