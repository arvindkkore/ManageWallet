package com.example.synsoft.managewallet.model;

import java.util.List;
import com.example.synsoft.managewallet.model.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "EXPENDITURE_TYPE".
 */
public class ExpenditureType {

    private Long id;
    private String name;
    private Boolean status;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ExpenditureTypeDao myDao;

    private List<Category> categories;
    private List<IncomeExpense> incomeExpenses;

    public ExpenditureType() {
    }

    public ExpenditureType(Long id) {
        this.id = id;
    }

    public ExpenditureType(Long id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getExpenditureTypeDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Category> getCategories() {
        if (categories == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CategoryDao targetDao = daoSession.getCategoryDao();
            List<Category> categoriesNew = targetDao._queryExpenditureType_Categories(id);
            synchronized (this) {
                if(categories == null) {
                    categories = categoriesNew;
                }
            }
        }
        return categories;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetCategories() {
        categories = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<IncomeExpense> getIncomeExpenses() {
        if (incomeExpenses == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IncomeExpenseDao targetDao = daoSession.getIncomeExpenseDao();
            List<IncomeExpense> incomeExpensesNew = targetDao._queryExpenditureType_IncomeExpenses(id);
            synchronized (this) {
                if(incomeExpenses == null) {
                    incomeExpenses = incomeExpensesNew;
                }
            }
        }
        return incomeExpenses;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetIncomeExpenses() {
        incomeExpenses = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    @Override
    public String toString() {
        return ""+getName();
    }
}
