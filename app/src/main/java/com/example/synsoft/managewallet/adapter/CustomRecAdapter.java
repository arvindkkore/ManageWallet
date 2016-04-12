package com.example.synsoft.managewallet.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.synsoft.managewallet.R;
import com.example.synsoft.managewallet.model.IncomeExpense;

import java.util.List;

/**
 * Created by synsoft on 08/04/16.
 */
public class CustomRecAdapter extends RecyclerView.Adapter<CustomRecAdapter.MyViewHolder> {

    private List<IncomeExpense> incomeExpenseList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //public TextView title, year, genre;
        public TextView income_expense_title;

        public MyViewHolder(View view) {
            super(view);
             income_expense_title = (TextView) view.findViewById(R.id.income_name);
           /* title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);*/
        }
    }


    public CustomRecAdapter(List<IncomeExpense> incomeExpenseList) {
        this.incomeExpenseList = incomeExpenseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.incomeexpense_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        IncomeExpense movie = incomeExpenseList.get(position);
        holder.income_expense_title.setText(""+movie.getValue());
      /*  holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());*/
    }

    @Override
    public int getItemCount() {
        return incomeExpenseList.size();
    }
    public void getIncomeExpense()
    {
        
    }
}
