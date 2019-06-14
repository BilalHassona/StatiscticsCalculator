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

public class List1Model3 extends MainActivity {

    StatisticsUtil stat = new StatisticsUtil();
    EditText xj;
    EditText nj;
    Button calculateX2;
    TextView x2TextView;
    TextView stdDevTextView;
    String[] xjString;
    String[] njString;
    List<Double> xjList = new ArrayList<>();
    List<Double> njList = new ArrayList<>();
    String x2OutputString;
    String stdDevOutputString;
    Button calculateS;
    Button calculateM;
    EditText uAlphaEditText;
    Double uAlpha;
    Double avg2;
    Double stdDev2;
    String mFinalValue;
    TextView outputM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_model3);

        setComponents();

        calculateX2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(xj.getText().toString().length() == 0 || nj.getText().toString().length() == 0){
                    Toast.makeText(List1Model3.this, "The field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                xjString = xj.getText().toString().split(",");
                njString = nj.getText().toString().split(",");
                xjList = StatisticsUtil.TabStringToDoubleList(xjString);
                njList = StatisticsUtil.TabStringToDoubleList(njString);
                x2OutputString = "x̄ = " + StatisticsUtil.calculateAverage2(xjList, njList);
                stat.setAverage(StatisticsUtil.calculateAverage2(xjList, njList));
                x2TextView.setText(x2OutputString);
//                stat.setStdDevModel3(StatisticsUtil.calculateStdDev(doubleList));
            }
        });

        calculateS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(xj.getText().toString().length() == 0 || nj.getText().toString().length() == 0){
                    Toast.makeText(List1Model3.this, "The field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                xjString = xj.getText().toString().split(",");
                njString = nj.getText().toString().split(",");
                xjList = StatisticsUtil.TabStringToDoubleList(xjString);
                njList = StatisticsUtil.TabStringToDoubleList(njString);
//                meanValue = "x̄ = " + StatisticsUtil.calculateAverage(doubleList) + "\ns = " + StatisticsUtil.calculateStdDevModel3(doubleList);
                stdDevOutputString = "s = " + StatisticsUtil.calculateStdDev2(xjList, njList);
                stat.setStdDev(StatisticsUtil.calculateStdDev2(xjList, njList));
                stdDevTextView.setText(stdDevOutputString);
//                stat.setStdDevModel3(StatisticsUtil.calculateStdDev(doubleList));
//                outputAverage.setText(meanValue);
            }
        });

        calculateM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uAlphaEditText.getText().toString().length() == 0){
                    Toast.makeText(List1Model3.this, "The field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                uAlpha = Double.parseDouble(uAlphaEditText.getText().toString());
                avg2 = stat.getAverage();
                stdDev2 = stat.getStdDev();
                mFinalValue = "For assumed trust ratio 1- \u03B1 = we obtain trust range P{ " +
                        StatisticsUtil.calculateMinusMModel2(avg2, stdDev2, uAlpha) +
                        " <m< " +
                        StatisticsUtil.calculatePlusMModel2(avg2, stdDev2, uAlpha) +
                        "}";
                outputM.setText(mFinalValue);
            }
        });

    }

    private void setComponents(){
        xj = findViewById(R.id.xj_edit_text);
        nj = findViewById(R.id.nj_edit_text);
        calculateX2 = findViewById(R.id.calculate_x2);
        x2TextView = findViewById(R.id.x2_output_text_view);
        stdDevTextView = findViewById(R.id.std_dev2_output_text_view);
        calculateS = findViewById(R.id.calculate_std_dev2);
        calculateM = findViewById(R.id.calculate_m);
        uAlphaEditText = findViewById(R.id.write_u_alpha_edit_text);
        outputM = findViewById(R.id.output_m);
    }
}
