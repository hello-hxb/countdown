package com.hxb.countdown;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hxb.libcountdown.TextViewManager;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by hxb♬ on 2017/12/11.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ItemData> mDataList;
    private final TextViewManager mTextViewManager;

    public MyAdapter(List<ItemData> dataList) {
        mDataList = dataList;

        //第一步
        mTextViewManager = new TextViewManager(dataList,  "倒计时已结束!");
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = View.inflate(context, R.layout.item_rec, null);

        return new RecyclerView.ViewHolder(view) {

        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textView = holder.itemView.findViewById(R.id.tv_millis);

        mTextViewManager.attach(textView,holder);

    }

    public TextViewManager getTextViewManager() {
        return mTextViewManager;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
