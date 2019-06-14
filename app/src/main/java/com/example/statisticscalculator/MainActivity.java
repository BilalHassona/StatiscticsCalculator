package com.example.statisticscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.statisticscalculator.list1.List1Model2;
import com.example.statisticscalculator.list1.List1Model1;
import com.example.statisticscalculator.list1.List1Model3;

public class MainActivity extends AppCompatActivity {

//    Button model1;
//    Button model2;
//    Button model3;
    Button list1;
    Button graphics;
    Button list4;
    Button list5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAllButtons();
    }

    private void setAllButtons(){

//        model1 = findViewById(R.id.model1);
//        model2 = findViewById(R.id.model2);
//        model3 = findViewById(R.id.model3);
        list1 = findViewById(R.id.list1);
        list4 = findViewById(R.id.list4);
        list5 = findViewById(R.id.list5);
        graphics = findViewById(R.id.graphics);

        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, List1Activity.class);
                startActivity(intent);
            }
        });

        list4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, List4Activity.class);
                startActivity(intent);
            }
        });

        list5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, List5Activity.class);
                startActivity(intent);
            }
        });


//        model1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, List1Model1.class);
//                startActivity(intent);
//            }
//        });
//
//        model2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, List1Model2.class);
//                startActivity(intent);
//            }
//        });
//
//        model3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, List1Model3.class);
//                startActivity(intent);
//            }
//        });

        graphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Graphics.class);
                startActivity(intent);
            }
        });
    }

}
