package com.example.bmibackground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txname, txheight, txweight;      //tx = TeXt
    private TextView txvShow;                   //txv = TeXtView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int size = 15;  //sp
    public void response(View v){

        txname = findViewById(R.id.editTextName);
        txheight = findViewById(R.id.editTextHeight);
        txweight = findViewById(R.id.editTextWeight);
        txvShow = findViewById(R.id.textViewShow);

        float height = Float.parseFloat(txheight.getText().toString());
        float weight = Float.parseFloat(txweight.getText().toString());
        float bmiNum = calculateBMI(height, weight);
        String bmi = String.valueOf(bmiNum);

        txvShow.setTextSize(size);
        txvShow.setText("Hello " + txname.getText().toString() + " ~\n" + "Your BMI is" + bmi);
        Toast.makeText(this, standardBMI(bmiNum), Toast.LENGTH_LONG).show();
    }

    private float calculateBMI(float hei, float wei){
        float BMI = (float)(wei / Math.pow((hei / 100), 2));
        return BMI;
    }

    private String standardBMI(float bmi){
        String alert = "";

        if((int)bmi > 25){
            alert = String.valueOf("TOO HEAVY :(");
            getWindow().setBackgroundDrawableResource(R.drawable.cat1);
        }
        else if((int)(bmi*10) < 185){
            alert = String.valueOf("TOO SLIM ><");
            getWindow().setBackgroundDrawableResource(R.drawable.cat2);
        }
        else{
            alert = String.valueOf("GOOD BODY :)");
            getWindow().setBackgroundDrawableResource(R.drawable.cat3);
        }

        return alert;
    }

}
