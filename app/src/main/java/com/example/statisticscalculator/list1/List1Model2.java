package com.example.statisticscalculator.list1;

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

public class List1Model2 extends MainActivity {

//    DescriptiveStatistics stats = new DescriptiveStatistics();
    StatisticsUtil stat = new StatisticsUtil();
    EditText average;
    TextView outputAverage;
    Button calculate;
    List<Double> doubleList = new ArrayList<>();
    String[] avString;
    String meanValue;
    EditText tAlphatext;
    Button calculateM;
    Double tAlpha;
    Double stdDev;
    Double avg;
    String mFinalValue;
    TextView outputM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_model2);

        setComponents();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(average.getText().toString().length() == 0){
                    Toast.makeText(List1Model2.this, "The field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                avString = average.getText().toString().split(",");
                doubleList = StatisticsUtil.TabStringToDoubleList(avString);
                meanValue = "x̄ = " + StatisticsUtil.calculateAverage(doubleList) + "\ns = " + StatisticsUtil.calculateStdDev(doubleList);
                stat.setAverage(StatisticsUtil.calculateAverage(doubleList));
                stat.setStdDev(StatisticsUtil.calculateStdDev(doubleList));
                outputAverage.setText(meanValue);
            }
        });

        calculateM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tAlphatext.getText().toString().length() == 0){
                    Toast.makeText(List1Model2.this, "The field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                tAlpha = Double.parseDouble(tAlphatext.getText().toString());
                avg = stat.getAverage();
                stdDev = stat.getStdDev();
                mFinalValue = "For assumed trust ratio 1- \u03B1 = we obtain trust range P{ " + StatisticsUtil.calculateMinusMModel2(avg, stdDev, tAlpha) + " <m< " + StatisticsUtil.calculatePlusMModel2(avg, stdDev, tAlpha) + "}";
                outputM.setText(mFinalValue);
            }
        });
    }

    private void setComponents(){
        calculate = findViewById(R.id.calculate);
        average = findViewById(R.id.average_edit_text);
        outputAverage = findViewById(R.id.average_output_text_view);
        tAlphatext = findViewById(R.id.write_t_alpha_edit_text);
        calculateM = findViewById(R.id.calculate_m);
        outputM = findViewById(R.id.output_m);
    }
}