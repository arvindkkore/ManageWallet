package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class Generator
{
    public  static  void main(String[] args) {
        try{

        Schema schema = new Schema(1, "com.example.synsoft.managewallet.model");

            /** 1
             * Currency
             * {
             * id
             * name
             * notation
             * }
             *
             */


            /** 2
             * ExpenditureType
             * {
             * id
             * name
             * status
             * List<Category>
             * List<IncomeExpense>
             * }
             *
             */

            /** 3
             * Category
             * {
             * id
             * name
             * ExpenditureType expenditure
             * List<IncomeExpense>
             * }
             *
             */

            /** 4
             * IncomeExpense
             * {
             * id
             * name
             * ExpenditureType expenditure
             * Category category;
             * Currency currency;
             * }
             *
             */

        /** Entity 1 */
            Entity currency = schema.addEntity("Currency");
            currency.addIdProperty();
            currency.addStringProperty("name").notNull();
            currency.addStringProperty("notation").notNull();




        /** Entity 2 */
            Entity expenditureType = schema.addEntity("ExpenditureType");
            expenditureType.addIdProperty();
            expenditureType.addStringProperty("name");
            expenditureType.addBooleanProperty("status");

        /** Entity 3 */

         Entity category = schema.addEntity("Category");
        category.addIdProperty();
        category.addStringProperty("name");

            Property expenditureId = category.addLongProperty("expenditureId").getProperty();
            category.addToOne(expenditureType, expenditureId);
            ToMany expenditureToCategory = expenditureType.addToMany(category, expenditureId);
            expenditureToCategory.setName("categories");


        /** Entity 4 */
            Entity incomeExpense = schema.addEntity("IncomeExpense");
            incomeExpense.addIdProperty();
            incomeExpense.addDoubleProperty("value");
            Property orderDate=incomeExpense.addDateProperty("entry_date").getProperty();
            incomeExpense.addStringProperty("note");
            incomeExpense.addStringProperty("receipt_photo");


            Property categoryId = incomeExpense.addLongProperty("categoryId").getProperty();
            incomeExpense.addToOne(category, categoryId);
            ToMany cateforyToIncomeExpense = category.addToMany(incomeExpense, categoryId);
            cateforyToIncomeExpense.setName("incomeExpenses");


            Property expenditureId1 = incomeExpense.addLongProperty("expenditureId").getProperty();
            incomeExpense.addToOne(expenditureType, expenditureId1);
            ToMany expenditureToIncomeExpense = expenditureType.addToMany(incomeExpense, expenditureId1);
            expenditureToIncomeExpense.setName("incomeExpenses");


            Property currencyId = incomeExpense.addLongProperty("currencyId").getProperty();
            incomeExpense.addToOne(currency, currencyId);
            ToMany currencyToIncomeExpense = currency.addToMany(incomeExpense, currencyId);
            currencyToIncomeExpense.setName("incomeExpenses");



           new DaoGenerator().generateAll(schema, "../app/src/main/java");

    }catch(Exception exception)
    {

    }

}
}
