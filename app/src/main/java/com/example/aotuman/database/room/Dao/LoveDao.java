package com.example.aotuman.database.room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.aotuman.database.room.Bean.Shop;

import java.util.List;

@Dao
public interface LoveDao {

    /**
     * 添加数据
     *
     * @param shop
     */
    @Insert
    void insertLove(Shop shop);

    /**
     * 删除数据
     *
     * @param shop
     */
    @Delete
    void deleteLove(Shop shop);

    /**
     * 更新数据
     *
     * @param shop
     */
    @Update
    void updateLove(Shop shop) ;

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    @Query("SELECT * FROM shop where type = 2")
    List<Shop> queryLove();


    @Query("SELECT * FROM shop where id = :id")
    List<Shop> queryLove(long id);
}
