package com.example.appdev_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt_goToLF, bt_goToSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_goToLF=findViewById(R.id.bt_goToLF);
        bt_goToSP=findViewById(R.id.bt_goToSP);

        bt_goToSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_goToLF = new Intent(MainActivity.this, SpiFactor.class);
                startActivity(it_goToLF);
            }
        });

        bt_goToLF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_goToLF = new Intent(MainActivity.this, LorentzFactor.class);
                startActivity(it_goToLF);
            }
        });







    }
}