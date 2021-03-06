package com.example.synsoft.managewallet.model;

import com.example.synsoft.managewallet.model.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "INCOME_EXPENSE".
 */
public class IncomeExpense {

    private Long id;
    private Double value;
    private java.util.Date entry_date;
    private String note;
    private String receipt_photo;
    private Long categoryId;
    private Long expenditureId;
    private Long currencyId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient IncomeExpenseDao myDao;

    private Category category;
    private Long category__resolvedKey;

    private ExpenditureType expenditureType;
    private Long expenditureType__resolvedKey;

    private Currency currency;
    private Long currency__resolvedKey;


    public IncomeExpense() {
    }

    public IncomeExpense(Long id) {
        this.id = id;
    }

    public IncomeExpense(Long id, Double value, java.util.Date entry_date, String note, String receipt_photo, Long categoryId, Long expenditureId, Long currencyId) {
        this.id = id;
        this.value = value;
        this.entry_date = entry_date;
        this.note = note;
        this.receipt_photo = receipt_photo;
        this.categoryId = categoryId;
        this.expenditureId = expenditureId;
        this.currencyId = currencyId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getIncomeExpenseDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public java.util.Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(java.util.Date entry_date) {
        this.entry_date = entry_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReceipt_photo() {
        return receipt_photo;
    }

    public void setReceipt_photo(String receipt_photo) {
        this.receipt_photo = receipt_photo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(Long expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    /** To-one relationship, resolved on first access. */
    public Category getCategory() {
        Long __key = this.categoryId;
        if (category__resolvedKey == null || !category__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CategoryDao targetDao = daoSession.getCategoryDao();
            Category categoryNew = targetDao.load(__key);
            synchronized (this) {
                category = categoryNew;
            	category__resolvedKey = __key;
            }
        }
        return category;
    }

    public void setCategory(Category category) {
        synchronized (this) {
            this.category = category;
            categoryId = category == null ? null : category.getId();
            category__resolvedKey = categoryId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public ExpenditureType getExpenditureType() {
        Long __key = this.expenditureId;
        if (expenditureType__resolvedKey == null || !expenditureType__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ExpenditureTypeDao targetDao = daoSession.getExpenditureTypeDao();
            ExpenditureType expenditureTypeNew = targetDao.load(__key);
            synchronized (this) {
                expenditureType = expenditureTypeNew;
            	expenditureType__resolvedKey = __key;
            }
        }
        return expenditureType;
    }

    public void setExpenditureType(ExpenditureType expenditureType) {
        synchronized (this) {
            this.expenditureType = expenditureType;
            expenditureId = expenditureType == null ? null : expenditureType.getId();
            expenditureType__resolvedKey = expenditureId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Currency getCurrency() {
        Long __key = this.currencyId;
        if (currency__resolvedKey == null || !currency__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CurrencyDao targetDao = daoSession.getCurrencyDao();
            Currency currencyNew = targetDao.load(__key);
            synchronized (this) {
                currency = currencyNew;
            	currency__resolvedKey = __key;
            }
        }
        return currency;
    }

    public void setCurrency(Currency currency) {
        synchronized (this) {
            this.currency = currency;
            currencyId = currency == null ? null : currency.getId();
            currency__resolvedKey = currencyId;
        }
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
        return ""+getValue()+" "+getNote();
    }
}
