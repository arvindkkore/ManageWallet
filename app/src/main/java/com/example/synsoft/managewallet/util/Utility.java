package com.example.synsoft.managewallet.util;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.synsoft.managewallet.MyApplication;

import com.example.synsoft.managewallet.model.Category;
import com.example.synsoft.managewallet.model.CategoryDao;
import com.example.synsoft.managewallet.model.Currency;
import com.example.synsoft.managewallet.model.CurrencyDao;
import com.example.synsoft.managewallet.model.DaoSession;
import com.example.synsoft.managewallet.model.ExpenditureType;
import com.example.synsoft.managewallet.model.ExpenditureTypeDao;
import com.example.synsoft.managewallet.model.IncomeExpense;
import com.example.synsoft.managewallet.model.IncomeExpenseDao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by synsoft on 11/03/16.
 */
public  class Utility
{

    public static Utility utility;

     public static Utility getIntance()
     {
      if (utility==null)
      {
         utility=new Utility();
      }
         return  utility;
     }

    public  void addExpenditureType(MyApplication application)
    {
        DaoSession daoSession = application.getDaoSession();
        ExpenditureTypeDao expenditureTypeDao=daoSession.getExpenditureTypeDao();

        ExpenditureType  expenditureType=new ExpenditureType();
        expenditureType.setName("Expenses");
        expenditureType.setStatus(true);

        ExpenditureType  expenditureType1=new ExpenditureType();
        expenditureType1.setName("Income");
        expenditureType1.setStatus(true);
        expenditureTypeDao.insert(expenditureType);
        expenditureTypeDao.insert(expenditureType1);
  }


    public  List getExpenditureType(MyApplication application)
    {

        DaoSession daoSession = application.getDaoSession();
        ExpenditureTypeDao expenditureTypeDao=daoSession.getExpenditureTypeDao();
                List expenditures = expenditureTypeDao.queryBuilder().orderAsc(ExpenditureTypeDao.Properties.Name)
            .list();

       return expenditures;

    }
    public  List<Category> getCategories(MyApplication application,int expenditureType)
    {

        DaoSession daoSession = application.getDaoSession();
        CategoryDao categoryDao=daoSession.getCategoryDao();
        List <Category> expenditures = categoryDao.queryBuilder().where(
                CategoryDao.Properties.ExpenditureId.eq(expenditureType)).orderAsc(CategoryDao.Properties.Id)
                .list();

        return expenditures;

    }

    public  List getIncomeExpenses(MyApplication application,int expenditure_type)
    {

        DaoSession daoSession = application.getDaoSession();
        IncomeExpenseDao incomeExpenseDao=daoSession.getIncomeExpenseDao();
        List incomeExpensesList = incomeExpenseDao.queryBuilder().orderAsc(IncomeExpenseDao.Properties.Id).list();
        return incomeExpensesList;

    }
    public  void addCategories(MyApplication application,int expenditure_type)
    {

        DaoSession daoSession = application.getDaoSession();
        CategoryDao categoryDao=daoSession.getCategoryDao();
        Category category=new Category();
        category.setName("Salary");
        Category category1=new Category();
        category.setName("Cloth");
        categoryDao.insert(category);
        categoryDao.insert(category1);
    }

    public  void addCategory(Category category,MyApplication application,int expenditure_type)
    {

        DaoSession daoSession = application.getDaoSession();
        ExpenditureTypeDao expenditureTypeDao=daoSession.getExpenditureTypeDao();
        CategoryDao categoryDao=daoSession.getCategoryDao();


        Query query = expenditureTypeDao.queryBuilder().where(
                ExpenditureTypeDao.Properties.Id.eq(expenditure_type)).build();
        ExpenditureType expenditureTypeObj=null;
        List expenditure_list = query.list();
        if (expenditure_list.size()>0)
        {
            expenditureTypeObj=(ExpenditureType) expenditure_list.get(0);

            category.setExpenditureType(expenditureTypeObj);
            category.setExpenditureId(expenditureTypeObj.getId());
            List<Category> list = expenditureTypeObj.getCategories();
            list.add(category);
            categoryDao.insert(category);

        }

    }

    public  void addCurrency(MyApplication application,Currency currency)
    {
        try {
            DaoSession daoSession = application.getDaoSession();
            CurrencyDao currencyDao=daoSession.getCurrencyDao();
            currencyDao.insert(currency);
        }
        catch (Exception e)
        {

        }

    }

    public  void addCurrencies(MyApplication application)
     {
       try {
           DaoSession daoSession = application.getDaoSession();
           CurrencyDao currencyDao=daoSession.getCurrencyDao();
           Currency currency=new Currency();
           currency.setName("Indian Rupees");
           currency.setNotation("INR");
           Currency currency1=new Currency();
           currency1.setName("USD");
           currency1.setNotation("USD");
           currencyDao.insert(currency);
           currencyDao.insert(currency1);


       }catch (Exception e)
       {

       }

    }

    public void addIncomeExpense(IncomeExpense incomeExpense,MyApplication application)
    {
        DaoSession daoSession = application.getDaoSession();
        IncomeExpenseDao incomeExpenseDao=daoSession.getIncomeExpenseDao();
        //ExpenditureTypeDao expenditureTypeDao=daoSession.getExpenditureTypeDao();
        //CurrencyDao currencyDao=daoSession.getCurrencyDao();
        //CategoryDao categoryDao=daoSession.getCategoryDao();

        incomeExpense.setExpenditureId(incomeExpense.getExpenditureType().getId());
        incomeExpense.setCategoryId(incomeExpense.getCategory().getId());
        incomeExpense.setCurrencyId(incomeExpense.getCurrency().getId());
        List<IncomeExpense> incomeExpenses1=incomeExpense.getExpenditureType().getIncomeExpenses();
        List<IncomeExpense> incomeExpenses2=incomeExpense.getCategory().getIncomeExpenses();
        List<IncomeExpense> incomeExpenses3=incomeExpense.getCategory().getIncomeExpenses();
        incomeExpenseDao.insert(incomeExpense);
        incomeExpenses1.add(incomeExpense);
        incomeExpenses2.add(incomeExpense);
        incomeExpenses3.add(incomeExpense);
    }
  public void deleteIncomeExpense(IncomeExpense incomeExpense,MyApplication application)
  {
      DaoSession daoSession = application.getDaoSession();
      IncomeExpenseDao incomeExpenseDao=daoSession.getIncomeExpenseDao();

      incomeExpense.setExpenditureId(incomeExpense.getExpenditureType().getId());
      incomeExpense.setCategoryId(incomeExpense.getCategory().getId());
      incomeExpense.setCurrencyId(incomeExpense.getCurrency().getId());
      List<IncomeExpense> incomeExpenses1=incomeExpense.getExpenditureType().getIncomeExpenses();
      List<IncomeExpense> incomeExpenses2=incomeExpense.getCategory().getIncomeExpenses();
      List<IncomeExpense> incomeExpenses3=incomeExpense.getCategory().getIncomeExpenses();

      incomeExpenseDao.delete(incomeExpense);
      incomeExpenses1.remove(incomeExpense);
      incomeExpenses2.remove(incomeExpense);
      incomeExpenses3.remove(incomeExpense);


  }

    public List<Currency> getCurrencies(MyApplication applicationContext) {


        DaoSession daoSession = applicationContext.getDaoSession();
        CurrencyDao currencyDao=daoSession.getCurrencyDao();
        List currencies = currencyDao.queryBuilder().orderAsc(CurrencyDao.Properties.Name)
                .list();
        return currencies;
    }
}
