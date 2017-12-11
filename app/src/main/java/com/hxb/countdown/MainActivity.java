package com.hxb.countdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ItemData> mRecDataList = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(mRecDataList);
        mRecyclerView.setAdapter(mAdapter);



        ItemData itemData= new ItemData();
        itemData.setMillisecond(15*1000); //15秒
        mRecDataList.add(itemData);



        Random random = new Random();
        for (int i = 0;i<20;i++){
           ItemData data= new ItemData();
            long time = random.nextInt(10) * 1000 * 60 * 60 * 24;
            data.setMillisecond(time);
            mRecDataList.add(data);
            Log.d(getClass().getCanonicalName(), "最初的时间: " +time);
        }


        mAdapter.notifyDataSetChanged();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在合适的位置停止倒计时
        mAdapter.getTextViewManager().stop();
    }
}
