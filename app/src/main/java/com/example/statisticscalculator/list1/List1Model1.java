package com.example.statisticscalculator.list1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.statisticscalculator.MainActivity;
import com.example.statisticscalculator.R;
import com.example.statisticscalculator.StatisticsUtil;
import java.util.ArrayList;
import java.util.List;

public class List1Model1 extends MainActivity {

    StatisticsUtil stat = new StatisticsUtil();
    EditText average;
    Button calculate;
    String[] avString;
    List<Double> doubleList = new ArrayList<>();
    String meanValue;
    TextView outputAverage;
    Button mCalculate;
    EditText uAlphaAndSigma;
    String[] stringUAlphaAndSigma;
    Double uAlpha;
    Double sigma;
    Double avg;
    String mFinalValue;
    TextView outputM;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_model1);

        setComponents();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(average.getText().toString().length() == 0){
                    Toast.makeText(List1Model1.this, "The field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                avString = average.getText().toString().split(",");
                doubleList = StatisticsUtil.TabStringToDoubleList(avString);
                meanValue = "x̄ = " + StatisticsUtil.calculateAverage(doubleList);
                stat.setAverage(StatisticsUtil.calculateAverage(doubleList));
                outputAverage.setText(meanValue);
            }
        });

        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uAlphaAndSigma.getText().toString().length() == 0){
                    Toast.makeText(List1Model1.this, "The field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                stringUAlphaAndSigma = uAlphaAndSigma.getText().toString().split(",");
                uAlpha = Double.parseDouble(stringUAlphaAndSigma[0]);
                sigma = Double.parseDouble(stringUAlphaAndSigma[1]);
                n = Integer.parseInt(stringUAlphaAndSigma[2]);
                avg = stat.getAverage();
                mFinalValue = "For assumed trust ratio 1- \u03B1 = we obtain trust range P{ " + StatisticsUtil.calculateMinusMModel1(avg, uAlpha, sigma, n) + " <m< " + StatisticsUtil.calculatePlusMModel1(avg, uAlpha, sigma, n) + "}";
                outputM.setText(mFinalValue);
            }
        });

    }

    public void setComponents(){

        average = findViewById(R.id.average_edit_text);
        calculate = findViewById(R.id.calculate);
        outputAverage = findViewById(R.id.average_output_text_view);
        mCalculate = findViewById(R.id.calculate_m);
        uAlphaAndSigma = findViewById(R.id.write_u_alpha_and_sigma_edit_text);
        outputM = findViewById(R.id.output_m);
    }
}
