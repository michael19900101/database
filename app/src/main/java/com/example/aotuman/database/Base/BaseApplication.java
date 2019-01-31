package com.example.aotuman.database.Base;

import android.database.sqlite.SQLiteDatabase;

import com.example.aotuman.database.greendao.Bean.DaoMaster;
import com.example.aotuman.database.greendao.Bean.DaoSession;
import com.example.common.app.BaseApp;
import com.facebook.stetho.Stetho;


public class BaseApplication extends BaseApp {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        //配置数据库
        setupDatabase();
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop_greendao.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
