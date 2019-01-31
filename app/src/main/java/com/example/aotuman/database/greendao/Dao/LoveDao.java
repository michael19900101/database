package com.example.aotuman.database.greendao.Dao;


import com.example.aotuman.database.Base.BaseApplication;
import com.example.aotuman.database.greendao.Bean.Shop;
import com.example.aotuman.database.greendao.Bean.ShopDao;

import java.util.List;

/**
 * Created by aotuman on 2018/4/19.
 */
public class LoveDao {

    /**
     * 添加数据
     *
     * @param shop
     */
    public static void insertLove(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().insert(shop);
    }

    public static void insertLove(List<Shop> shops) {
        BaseApplication.getDaoInstant().getShopDao().insertInTx(shops);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        BaseApplication.getDaoInstant().getShopDao().deleteByKey(id);
    }

    public static void deleteLove(List<Shop> shops) {
        BaseApplication.getDaoInstant().getShopDao().deleteInTx(shops);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().update(shop);
    }

    public static void updateLove(List<Shop> shops) {
        BaseApplication.getDaoInstant().getShopDao().updateInTx(shops);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Shop> queryLove() {
        return BaseApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }
}
