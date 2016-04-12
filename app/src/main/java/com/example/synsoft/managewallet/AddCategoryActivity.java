package com.example.synsoft.managewallet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.synsoft.managewallet.model.Category;
import com.example.synsoft.managewallet.util.Utility;

public class AddCategoryActivity extends AppCompatActivity {

    EditText editText_category_name;
    RadioGroup radioGroup=null;
    Category category=null;
    int expenditureType=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        radioGroup=(RadioGroup)findViewById(R.id.expense_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radio_expense) {

                    expenditureType = 1;
                } else if (checkedId == R.id.radio_income) {

                    expenditureType = 2;


                }
            }
        });

        editText_category_name=(EditText)findViewById(R.id.editText_category_name);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               Category category = new Category();
                category.setName(editText_category_name.getText().toString());
                addCategory(category);
            }
        });
    }

    public  void  addCategory(Category category)
    {
        Utility.getIntance().addCategory(category,(MyApplication) getApplicationContext(),expenditureType);
    }
}
