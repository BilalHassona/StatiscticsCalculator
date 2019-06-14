package com.example.statisticscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.statisticscalculator.list1.List1Model1;
import com.example.statisticscalculator.list1.List1Model2;
import com.example.statisticscalculator.list1.List1Model3;

public class List1Activity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_1);

        Button model1;
        Button model2;
        Button model3;

        model1 = findViewById(R.id.model1);
        model2 = findViewById(R.id.model2);
        model3 = findViewById(R.id.model3);

        model1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List1Activity.this, List1Model1.class);
                startActivity(intent);
            }
        });

        model2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List1Activity.this, List1Model2.class);
                startActivity(intent);
            }
        });

        model3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List1Activity.this, List1Model3.class);
                startActivity(intent);
            }
        });

    }
}
