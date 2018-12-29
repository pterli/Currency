package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Currency extends AppCompatActivity {

    private EditText edNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        findViews();
    }

    private void findViews() {
        edNtd = findViewById(R.id.ed_ntd);
    }

    public void Calculation(View view){
        String N = edNtd.getText().toString();
        if(N.equals("")){
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount !!")
                    .setPositiveButton("OK", null)
                    .show();
        }

        else{
            float ntd = Float.parseFloat(N);
            float Calculation = ntd / 30.9f;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + Calculation)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }

    }
}



