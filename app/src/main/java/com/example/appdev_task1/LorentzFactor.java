package com.example.appdev_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LorentzFactor extends AppCompatActivity {
    Button bt_calcLF, ;
    TextView tv_inputV;
    TextView tv_LF;
    static final long c = 299792458;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorentz_factor2);
        bt_calcLF = findViewById(R.id.bt_calcLF);
        tv_inputV = findViewById(R.id.tv_inputV);
        tv_LF = findViewById(R.id.tv_LF);

        bt_calcLF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findAnswer();
            }

        });







    }
    void findAnswer(){
        Double v,answer;
        v= Double.parseDouble(tv_inputV.getText().toString());
        if(v>=c) {
            Toast.makeText(this, "V can't be greater that C", Toast.LENGTH_SHORT).show();
        }
        else {
            answer = (1 / (Math.sqrt((1 - (v * v / (c * c))))));
            //tv_LF.setText(Float.toString(v));
            tv_LF.setText(Double.toString(answer));
        }
    }
}