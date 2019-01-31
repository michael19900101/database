package com.example.aotuman.database.room.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.aotuman.database.R;
import com.example.aotuman.database.room.Adapter.ShopListAdapter;
import com.example.aotuman.database.room.Bean.Shop;
import com.example.aotuman.database.room.Dao.LoveDao;
import com.example.aotuman.database.room.Db.ShopDatabase;

import java.util.ArrayList;
import java.util.List;

public class RoomMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_add, bt_delete, bt_update, bt_query;
    private ListView lv_content;
    private ShopListAdapter adapter;
    private List<Shop> shops;
    private static int i = 10;
    private LoveDao loveDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loveDao = ShopDatabase.getInstance(getApplicationContext()).getLoveDao();
        setContentView(R.layout.activity_main);

        bt_add = findViewById(R.id.bt_add);
        bt_delete = findViewById(R.id.bt_delete);
        bt_update = findViewById(R.id.bt_update);
        bt_query = findViewById(R.id.bt_query);
        lv_content = findViewById(R.id.lv_content);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);

        queryDate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                addDate();
                break;
            case R.id.bt_delete:
                deleteDate();
                break;
            case R.id.bt_update:
                updateDate();
                break;
            case R.id.bt_query:
                queryDate();
                break;
        }
    }

    private void deleteDate() {
        if (!shops.isEmpty()) {
            loveDao.deleteLove(shops.get(0));
            queryDate();
        }
    }

    private void queryDate() {
        shops = new ArrayList<>();
        shops = loveDao.queryLove();
        adapter = new ShopListAdapter(this, shops);
        lv_content.setAdapter(adapter);
    }

    private void addDate() {
        Shop shop = new Shop();
        shop.setType(2);
        shop.setAddress("广东深圳");
        shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
        shop.setPrice("19.40");
        shop.setSell_num(15263);
        shop.setName("正宗梅菜扣肉 聪厨梅干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i++);
        loveDao.insertLove(shop);
        queryDate();
    }

    private void updateDate() {
        if (!shops.isEmpty()) {
            Shop shop = shops.get(0);
            shop.setName("我是修改的名字");
            loveDao.updateLove(shop);
            queryDate();
        }
    }
}
