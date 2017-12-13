package com.hxb.libcountdown;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hxb♬ on 2017/12/11.
 */

public class TextViewManager {
    private final List<? extends ITime> mDataList;
    /**
     * 用一个集合保存已经开始更新的textview
     */
    private List<TextView> mTextViewList = new ArrayList<>();
    private boolean stop;
    private String mEndStr;
    private final CountDownWorker mCountDownWorker;


    public TextViewManager(List<? extends ITime> dataList, String endStr) {
        mDataList = dataList;
        mEndStr = endStr;
        mCountDownWorker = new CountDownWorker(dataList);
        mCountDownWorker.start();
    }

    public void attach(final TextView textView, final RecyclerView.ViewHolder viewHolder) {
        setTextViewText(viewHolder, textView);
        boolean contains = mTextViewList.contains(textView);

        if (!contains) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (stop) {
                        return;
                    }
                    setTextViewText(viewHolder, textView);

                    textView.postDelayed(this, 1000);
                }
            };
            mTextViewList.add(textView);
            textView.post(runnable);
        }
    }

    private void setTextViewText(RecyclerView.ViewHolder viewHolder, TextView textView) {
        //获取当前的位置
        int position = viewHolder.getLayoutPosition();
        if (mDataList != null && position >= 0 && position < mDataList.size()) {

            ITime time = mDataList.get(position);
            long millis = time.getMillisecond();
            String str;
            if (millis > 0) {
                str = time.mill2Str(millis);
            } else {
                str = mEndStr;
            }
            textView.setText(str);
        }
    }

    public void stop() {
        stop = true;
        mCountDownWorker.stop();
    }
}
