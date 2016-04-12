package com.example.synsoft.managewallet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.synsoft.managewallet.model.Currency;
import com.example.synsoft.managewallet.util.Utility;

public class CurrencyActivity extends AppCompatActivity {

    EditText editText_name,editText_notation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editText_name=(EditText) findViewById(R.id.editText_Name);
        editText_notation=(EditText) findViewById(R.id.editText_notation);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Currency currency=new Currency();
                currency.setName(editText_name.getText().toString());
                currency.setNotation(editText_notation.getText().toString());
                addCategory(currency);
            }
        });
    }

    public  void  addCategory(Currency currency)
    {
        Utility.getIntance().addCurrency((MyApplication) getApplicationContext(),currency);

    }
}
