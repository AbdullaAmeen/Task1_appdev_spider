package com.example.appdev_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Calendar;

public class SpiFactor extends AppCompatActivity {
    TextView tv_SF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spi_factor);

      //  final Double[] SF = new Double[1];

        tv_SF = findViewById(R.id.tv_SF);

        Handler handler = new Handler();


        Runnable run = new Runnable() {
            @Override
            public void run() {
                Calendar currentTime = Calendar.getInstance();
                int currentHour = currentTime.get(Calendar.HOUR)==0?12:currentTime.get(Calendar.HOUR);
                int minutes = currentTime.get(Calendar.MINUTE);
                int seconds = currentTime.get(Calendar.SECOND);
                Double SF = (double)fact(currentHour)/(minutes*minutes*minutes + seconds);
                tv_SF.setText(String.format("%.10f",SF));
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run);

    }
    int fact(int x){
        return  x==0?1:x*fact(x-1);
    }
}