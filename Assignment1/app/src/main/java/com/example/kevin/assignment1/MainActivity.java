package com.example.kevin.assignment1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void valueRetrieved(View view) {

        EditText bill = (EditText) findViewById(R.id.bill);
        if (!bill.getText().toString().equals("")) {
            int id = view.getId();
            if (id == R.id.button10) {
                updateTip(view, 10);
            } else if (id == R.id.button15) {
                updateTip(view, 15);
            } else if (id == R.id.button20) {
                updateTip(view, 20);
            } else if (id == R.id.tipInput) {
                EditText tipInput = (EditText) findViewById(R.id.tipInput);
                double dTip = Double.parseDouble(tipInput.getText().toString());
                updateTip(view, dTip);
            }
            //View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

        }
        else {
            Toast.makeText(this, "Enter bill total first", Toast.LENGTH_SHORT).show();
        }
    }




    public void updateTip(View view, double newTip){
        TextView tipDisplay = (TextView) findViewById(R.id.tipDisplay);
        EditText bill = (EditText) findViewById(R.id.bill);
        double dBill = Double.parseDouble(bill.getText().toString());
        double dTip = dBill*newTip/100;
        dTip = dTip - (dTip % 0.01);
        tipDisplay.setText(Double.toString(dTip));
    }
}
