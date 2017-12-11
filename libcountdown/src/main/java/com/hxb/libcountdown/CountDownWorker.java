package com.hxb.libcountdown;

import android.os.Handler;
import android.util.Log;

import java.util.List;

/**
 * Created by hxb♬ on 2017/12/11.
 */

public class CountDownWorker {

    private final List<? extends ITime> mDataList;
    private Handler mHandler;
    private boolean stop;
    private Runnable mRunnable;

    public CountDownWorker(List<? extends ITime> dataList) {
        mHandler = new Handler();
        mDataList = dataList;
    }

    /**
     * 开始倒计时
     */
    public void start() {

        if (mRunnable != null) {
            //如果已经开始倒计时则返回
            return;
        }
        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (stop) {
                    return;
                }
                if (mDataList != null) {
                    for (ITime time : mDataList) {
                        long millisecond = time.getMillisecond();
                        long now = millisecond - 1000;
                        time.setMillisecond(now);
//                        Log.d("CountDownWorker"  , "倒计时: " + now);
                    }
                }
                mHandler.postDelayed(this, 1000); //每1000毫秒进行一次
            }
        };
        mHandler.post(mRunnable);
    }

    /**
     * 停止倒计时
     */
    public void stop() {
        stop = true;
    }

}
