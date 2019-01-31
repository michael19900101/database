package com.example.aotuman.database.room.Db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.aotuman.database.room.Bean.Shop;
import com.example.aotuman.database.room.Dao.LoveDao;

@Database(entities = {Shop.class}, version = 1, exportSchema = false)
@TypeConverters({ConversionFactory.class})
public abstract class ShopDatabase extends RoomDatabase {

    private static ShopDatabase INSTANCE;

    public static ShopDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ShopDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(), ShopDatabase.class, "shop_room.db")
                                    .allowMainThreadQueries()
                                    .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract LoveDao getLoveDao();
}