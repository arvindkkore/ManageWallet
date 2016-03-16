package com.example.synsoft.managewallet;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.synsoft.managewallet.dialog.CategoryDialog;
import com.example.synsoft.managewallet.model.Category;
import com.example.synsoft.managewallet.model.ExpenditureType;
import com.example.synsoft.managewallet.util.Utility;

import java.util.List;

public class AddExpenditureActivity extends AppCompatActivity implements  View.OnClickListener,CategoryDialog.NoticeDialogListener{

    EditText editText_value;
    EditText editText_note;
    Button button_select_date;
    Button button_select_category;
    Button button_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenditure);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button_select_category=(Button)this.findViewById(R.id.select_category);
        button_select_category.setOnClickListener(this);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               //addCurrency();
                //getCurrencies();
               // addCategories();
                showExpenditure();
            }
        });
    }

    /*public void addExpeditureType()
    {
        Utility.getIntance().addExpenditureType((MyApplication) getApplicationContext());
    }*/

    public void showExpenditure()
    {
        Log.e("test",""+((ExpenditureType)Utility.getIntance().getExpenditureType((MyApplication) getApplicationContext()).get(1)).getCategories());
    }
    public void addCurrency()
    {
        Utility.getIntance().addCurrencies((MyApplication) getApplicationContext());

    }
    public void getCurrencies()
    {
        Log.e("test",""+Utility.getIntance().getCurrencies((MyApplication) getApplicationContext()));

    }
    public void addCategories()
    {
//        Category category=new Category();
//        category.setName("Salary");
//        Utility.getIntance().addCategory(category,(MyApplication) getApplicationContext(),2);

        Category category1=new Category();
        category1.setName("Rent");
        Utility.getIntance().addCategory(category1,(MyApplication)getApplicationContext(),1);
    }
   @Override
    public  void onClick(View v)
   {
    switch (v.getId())
    {
        case R.id.select_date:
            break;
        case  R.id.select_category:
            showNoticeDialog();
            break;
        case R.id.save_entries:
            break;
        default:
    }
   }

    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        //DialogFragment dialog = new CategoryDialog();
        //dialog.show(getFragmentManager(), "NoticeDialogFragment");
        AlertDialog.Builder builder=new AlertDialog.Builder(AddExpenditureActivity.this);
        builder.setTitle("Categories");

        LayoutInflater inflater = this.getLayoutInflater();
        View view=inflater.inflate(R.layout.expenditure_dialog,null);
        builder.setView(view);
        final String[] content1={"Cloth","Rent","Grocery"};
        final String[] content2={"Salary","Room Rent"};
        final TabLayout tabLayout=(TabLayout) view.findViewById(R.id.tabs);
        final ListView listView=(ListView) view.findViewById(R.id.expense_expenditure_type);
        ArrayAdapter<String>  arrayAdapter=new ArrayAdapter<String>(AddExpenditureActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, content1);
        listView.setAdapter(arrayAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Expense"));
        tabLayout.addTab(tabLayout.newTab().setText("Income"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ArrayAdapter<String> arrayAdapter=null;
                switch (tab.getPosition())
                {
                    case 0:
                        arrayAdapter=new ArrayAdapter<String>(AddExpenditureActivity.this,
                                android.R.layout.simple_list_item_1, android.R.id.text1, content1);
                        listView.setAdapter(arrayAdapter);
                        break;

                    case 1:
                        arrayAdapter=new ArrayAdapter<String>(AddExpenditureActivity.this,
                                android.R.layout.simple_list_item_1, android.R.id.text1, content1);
                        break;
                }
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
