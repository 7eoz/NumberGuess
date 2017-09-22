package com.studies.sandrini.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int num, tries;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
        num = r.nextInt(100)+1;
        System.out.println(num);
        tries = 0;

    }

    public void guess(View view){
        EditText guessInput = (EditText) findViewById(R.id.guess_input);
        TextView guessResult = (TextView) findViewById(R.id.guess_result);

        if(guessInput.length() == 0){
            Toast.makeText(getApplicationContext(), "Forneça um número", Toast.LENGTH_SHORT).show();
        }else{
            String tip;
            int inputNumber = Integer.parseInt(guessInput.getText().toString());
            tries++;
            if(num > inputNumber){
                tip = "Numero sorteado é maior";
            }else if(num < inputNumber){
                tip = "Número sorteado é menor";
            }else{
                tip = "Você acertou! Você usou " + tries + " tentativas!";
            }
            guessResult.setText(tip);
        }
    }
}
