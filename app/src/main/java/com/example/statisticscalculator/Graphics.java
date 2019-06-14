package com.example.statisticscalculator;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;

public class Graphics extends MainActivity{

    Button calculate;
    TextView output;
    EditText editInput;

    String strInput;
    double value;
    String strValue;
    private static final Double CONSTANT = 0.37966;
    int valueInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);

        editInput = findViewById(R.id.average_edit_text);
        output = findViewById(R.id.average_output_text_view);
        calculate = findViewById(R.id.calculate);

        editInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    calculate();
                    return true;
                }
                return false;
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public void calculate(){

        strInput = editInput.getText().toString();

        if(strInput.equals("")){
            Toast.makeText(Graphics.this, "There field is empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        value = Double.parseDouble(strInput);
        value = value/CONSTANT;
        value = StatisticsUtil.round(value, 2)*100;
        strValue = Integer.toString((int)value);
        output.setText(strValue);
    }

}
