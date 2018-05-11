package com.example.kaga.calcapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonwa = (Button) findViewById(R.id.buttonwa);
        buttonwa.setOnClickListener(this);

        Button buttonsa = (Button) findViewById(R.id.buttonsa);
        buttonsa.setOnClickListener(this);

        Button buttonjyo = (Button) findViewById(R.id.buttonjyo);
        buttonjyo.setOnClickListener(this);

        Button buttonsyo = (Button) findViewById(R.id.buttonsyo);
        buttonsyo.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        String stext1 = mEditText1.getText().toString();
        String stext2 = mEditText2.getText().toString();
        double result = 0;
        int stopflag = 0;

        try {
            double num1 = Double.parseDouble(stext1);
            double num2 = Double.parseDouble(stext2);

            if (v.getId() == R.id.buttonwa) {
                result = num1 + num2;
            } else if (v.getId() == R.id.buttonsa) {
                result = num1 - num2;
                ;
            } else if (v.getId() == R.id.buttonjyo) {
                result = num1 * num2;
            } else if (v.getId() == R.id.buttonsyo) {
                if (num2 == 0) {
                    stopflag = 1;
                } else
                    result = num1 / num2;
            }
        } catch (Exception e) {
            stopflag = 2;
        }
        View view = findViewById(android.R.id.content);
        if (stopflag == 0) {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("VALUE1", result);
            startActivity(intent);
        } else if (stopflag == 1) {
            Snackbar.make(view, "0で割れません", Snackbar.LENGTH_INDEFINITE).show();
        } else
            Snackbar.make(view, "何か数値を入れてください", Snackbar.LENGTH_INDEFINITE).show();
        ;
    }
}
