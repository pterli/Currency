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

    public void calculate(View view){
        String N = edNtd.getText().toString();
        if(N.equals("")){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.please_enter_ntd)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }

        else{
            float ntd = Float.parseFloat(N);
            float calculate = ntd / 30.9f;
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is) + calculate)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }

    }
}



