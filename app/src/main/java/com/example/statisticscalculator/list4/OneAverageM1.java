package com.example.statisticscalculator.list4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.statisticscalculator.List4Activity;
import com.example.statisticscalculator.R;

public class OneAverageM1 extends List4Activity {

    RadioGroup radioGroup;
    Button calculateButton;
    EditText m;
    EditText m0;
    EditText otherData;
    TextView output;
    RadioButton radioButton;
    Double[] data;
    String outcomeString;
    Button answerButton;
    TextView answerTextView;
    String answerString;
    EditText uAlphaEditText;
    TextView uAlphaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list4_one_average_m1);
        setAllComponents();


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
                data = getData();
                outcomeString = "u = " + calculateU(data).toString();
                output.setText(outcomeString);
            }
        });

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeRadioButton();
                answerString = compareDataFromRadioButton();
                answerString += checkCondition();
                answerTextView.setText(answerString);
            }
        });

    }

    private void setAllComponents() {
        radioGroup = findViewById(R.id.radio_group);
        calculateButton = findViewById(R.id.calculate);
        m = findViewById(R.id.m);
        m0 = findViewById(R.id.m0);
        otherData = findViewById(R.id.other_data);
        output = findViewById(R.id.output);
        answerButton = findViewById(R.id.answer_button);
        answerTextView = findViewById(R.id.answer_text_view);
        uAlphaEditText = findViewById(R.id.u_alpha_edit_text);
        uAlphaTextView = findViewById(R.id.u_alpha_text_view);
    }

    private void checkData(){
        if(m.getText().toString().equals("") || m0.getText().toString().equals("") || otherData.getText().toString().equals("")){
            Toast.makeText(this, "Fields are empty!", Toast.LENGTH_SHORT).show();
        }
    }

    private Double[] getData(){

        String[] otherDataStringArray;
        double mDouble;
        double m0Double;
        double sigma;
        double n;
        Double[] finalData;

        mDouble = Double.parseDouble(m.getText().toString());
        m0Double = Double.parseDouble(m0.getText().toString());
        otherDataStringArray = otherData.getText().toString().split(",");
        sigma = Double.parseDouble(otherDataStringArray[0]);
        n = Double.parseDouble(otherDataStringArray[1]);
        finalData = new Double[] {mDouble, m0Double, sigma, n};

        return finalData;
    }

    private Double calculateU(Double[] data){

        Double output;

        output = (((data[0] - data[1])*Math.sqrt(data[3]))/data[2]);

        return output;
    }

    private void initializeRadioButton(){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);
    }

    private String compareDataFromRadioButton(){
        String rbData;
        String answer;

        rbData = radioButton.getText().toString();
        rbData = rbData.replace(" ", "");

        answer = "H<sub>0</sub>: m " + rbData + " m<sub>0</sub> , H<sub>1</sub>: m";

        switch (rbData){
            case ">": answer += "< m<sub>0</sub>"; break;
            case "=": answer += " \u2260 m<sub>0</sub>"; break;
            case "<": answer += "> m<sub>0</sub>"; break;
        }

        return answer;
    }

    private String checkCondition(){
        String rbData;
        String answer ="";
        Double uAlpha;
        Double u;
        String str;

        uAlpha = Double.parseDouble(uAlphaEditText.getText().toString());
        str = outcomeString.replace("u = ", "");
        u = Double.parseDouble(str);

        rbData = radioButton.getText().toString();
        rbData = rbData.replace(" ", "");

        switch (rbData){
            case ">": {
                if(u>uAlpha){
                    answer = "\nWe must reject hypothesis H<sub>0</sub> for alternative H<sub>1</sub>";
                } else {
                    answer = "\nWe have no proof to reject hypothesis H<sub>0</sub>";
                }
            } break;
            case "=": {
                if (Math.abs(u)>=uAlpha) {
                    answer = "\nWe must reject hypothesis H<sub>0</sub> for alternative H<sub>1</sub>";
                } else {
                    answer = "\nWe have no proof to reject hypothesis H<sub>0</sub>";
                }
            } break;
            case "<": {
                if(u<(-uAlpha)){
                    answer = "\nWe must reject hypothesis H<sub>0</sub> for alternative H<sub>1</sub>";
                } else {
                    answer = "\nWe have no proof to reject hypothesis H<sub>0</sub>";
                }
            }
            break;
        }

        return answer;
    }
}