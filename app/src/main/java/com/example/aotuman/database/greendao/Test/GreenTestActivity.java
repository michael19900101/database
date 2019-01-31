package com.example.aotuman.database.greendao.Test;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aotuman.database.R;
import com.example.aotuman.database.greendao.Bean.Shop;
import com.example.aotuman.database.greendao.Dao.LoveDao;
import com.example.common.util.L;

import java.util.ArrayList;
import java.util.List;

public class GreenTestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_add, bt_delete, bt_update, bt_query;
    private TextView tv_result;
    private List<Shop> shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao_test);

        bt_add = findViewById(R.id.bt_add);
        bt_delete = findViewById(R.id.bt_delete);
        bt_update = findViewById(R.id.bt_update);
        bt_query = findViewById(R.id.bt_query);
        tv_result = findViewById(R.id.result);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);
        shops = new ArrayList<>();
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
            int size = shops.size();
            long begin = SystemClock.uptimeMillis();
            String logBeginStr = "开始时间:"+begin;
            L.d(logBeginStr);

            LoveDao.deleteLove(shops);

            long end = SystemClock.uptimeMillis();
            String logEndStr = "结束时间:"+end;
            L.d(logEndStr);
            long spendtime = end - begin;
            tv_result.setText("删除【"+ size +"】条数据"+ "\n" + logBeginStr + "\n" + logEndStr +"\n" + "耗时:"+spendtime);
        }
    }

    private void queryDate() {
        long begin = SystemClock.uptimeMillis();
        String logBeginStr = "开始时间:"+begin;
        L.d(logBeginStr);

        List<Shop> shops = LoveDao.queryLove();

        long end = SystemClock.uptimeMillis();
        String logEndStr = "结束时间:"+end;
        L.d(logEndStr);
        long spendtime = end - begin;
        tv_result.setText("查询【"+shops.size() +"】条数据"+ "\n" + logBeginStr + "\n" + logEndStr +"\n" + "耗时:"+spendtime);
    }

    private void addDate() {
        int num = 100000;
        for(int i = 0;i < num;i ++){
            Shop shop = new Shop();
            shop.setType(Shop.TYPE_LOVE);
            shop.setAddress("广东深圳");
            shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
            shop.setPrice("19.40");
            shop.setSell_num(15263);
            shop.setName("正宗梅菜扣肉 聪厨梅干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i++);
            shops.add(shop);
        }
        long begin = SystemClock.uptimeMillis();
        String logBeginStr = "开始时间:"+begin;
        L.d(logBeginStr);

        LoveDao.insertLove(shops);

        long end = SystemClock.uptimeMillis();
        String logEndStr = "结束时间:"+end;
        L.d(logEndStr);
        long spendtime = end - begin;
        tv_result.setText("插入【"+ num +"】条数据"+ "\n" + logBeginStr + "\n" + logEndStr +"\n" + "耗时:"+spendtime);
    }

    private void updateDate() {
        if (!shops.isEmpty()) {
            for(Shop shop:shops){
                shop.setName("我是修改的名字");
            }

            long begin = SystemClock.uptimeMillis();
            String logBeginStr = "开始时间:"+begin;
            L.d(logBeginStr);

            LoveDao.updateLove(shops);

            long end = SystemClock.uptimeMillis();
            String logEndStr = "结束时间:"+end;
            L.d(logEndStr);
            long spendtime = end - begin;
            tv_result.setText("更新【"+ shops.size() +"】条数据"+ "\n" + logBeginStr + "\n" + logEndStr +"\n" + "耗时:"+spendtime);
        }
    }
}
