package com.example.appdev_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class LorentzFactor extends AppCompatActivity {
    Button bt_calcLF, bt_checkLF;
    TextView tv_inputV, tv_inputLF;
    TextView tv_LF;
    View lt_bg;
    Vibrator vibrator;
    static final long c = 299792458;
    double vel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorentz_factor2);
        vibrator = (Vibrator) LorentzFactor.this.getSystemService(Context.VIBRATOR_SERVICE);
        bt_calcLF = findViewById(R.id.bt_calcLF);
        tv_inputV = findViewById(R.id.tv_inputV);
        tv_inputLF = findViewById(R.id.tv_inputLF);
        bt_checkLF = findViewById(R.id.bt_checkLF);
        lt_bg = findViewById(R.id.lt_bg);

        tv_LF = findViewById(R.id.tv_LF);

        bt_checkLF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(tv_inputV.getText().toString())) {
                    vel = Double.parseDouble("0"+tv_inputV.getText().toString());
                    if (CheckV()) {
                        CheckAnswer();
                    }
                }
                else{
                    Toast.makeText(LorentzFactor.this, "Please Enter V", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_calcLF.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(!TextUtils.isEmpty(tv_inputV.getText().toString())) {
                    vel = Double.parseDouble(tv_inputV.getText().toString());
                    if (CheckV()) {
                        Answer();
                    }
                }
                else{
                    Toast.makeText(LorentzFactor.this, "Please Enter V", Toast.LENGTH_SHORT).show();
                }

            }

        });







    }
    boolean CheckV(){
        if(vel>=c) {
            Toast.makeText(this, "V can't be greater that C", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    void CheckAnswer(){
        String answer;

        answer = tv_inputLF.getText().toString();
        if(answer.equals(getAnswer(vel))){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }
        else{
            lt_bg.setBackgroundColor(Color.parseColor("#C62828"));
            vibrator.vibrate(500);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    lt_bg.setBackgroundColor(Color.parseColor("#FCBB6D"));
                }
            }, 500);
            tv_LF.setText(getAnswer(vel));
        }
    }
    void Answer(){
            tv_LF.setText(getAnswer(vel));
    }

    String getAnswer(double v){
        return  String.format("%.8f",(1 / (Math.sqrt((1 - (v * v / (c * c)))))));
    }

}