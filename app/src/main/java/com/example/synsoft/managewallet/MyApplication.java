package com.example.synsoft.managewallet;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.synsoft.managewallet.model.DaoMaster;
import com.example.synsoft.managewallet.model.DaoSession;

/**
 * Created by synsoft on 11/03/16.
 */
public class MyApplication extends Application
{
    public DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "lease-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
