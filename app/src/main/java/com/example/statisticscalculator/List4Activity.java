package com.example.statisticscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.statisticscalculator.list4.OneAverageM1;
import com.example.statisticscalculator.list4.OneAverageM2;
import com.example.statisticscalculator.list4.OneAverageM3;
import com.example.statisticscalculator.list4.StructureFactor;
import com.example.statisticscalculator.list4.TwoAveragesM1;
import com.example.statisticscalculator.list4.TwoAveragesM2;
import com.example.statisticscalculator.list4.TwoAveragesM3;

public class List4Activity extends MainActivity {

    Button oneM1;
    Button oneM2;
    Button oneM3;
    Button twoM1;
    Button twoM2;
    Button twoM3;
    Button structureFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_4);
        setAllComponents();

        oneM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List4Activity.this, OneAverageM1.class);
                startActivity(intent);
            }
        });

        oneM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List4Activity.this, OneAverageM2.class);
                startActivity(intent);
            }
        });

        oneM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List4Activity.this, OneAverageM3.class);
                startActivity(intent);
            }
        });

        twoM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List4Activity.this, TwoAveragesM1.class);
                startActivity(intent);
            }
        });

        twoM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List4Activity.this, TwoAveragesM2.class);
                startActivity(intent);
            }
        });

        twoM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List4Activity.this, TwoAveragesM3.class);
                startActivity(intent);
            }
        });

        structureFactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List4Activity.this, StructureFactor.class);
                startActivity(intent);
            }
        });

    }

    private void setAllComponents(){

        oneM1 = findViewById(R.id.one_m_1);
        oneM2 = findViewById(R.id.one_m_2);
        oneM3 = findViewById(R.id.one_m_3);
        twoM1 = findViewById(R.id.two_m_1);
        twoM2 = findViewById(R.id.two_m_2);
        twoM3 = findViewById(R.id.two_m_3);
        structureFactor = findViewById(R.id.structure_factor);

    }

}