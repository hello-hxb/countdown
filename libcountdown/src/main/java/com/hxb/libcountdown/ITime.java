package com.hxb.libcountdown;

/**
 * Created by hxb♬ on 2017/12/11.
 */

public interface ITime {
    /**
     * 设置当前的毫秒数
     * @param millisecond
     */
    void setMillisecond(long millisecond);

    /**
     * 得到当前的毫秒数
     * @return
     */
    long getMillisecond();

    /**
     * 将当前毫秒数转化成直观的信息,比如将1000转化成1秒
     * @param millisecond
     * @return
     */
    String mill2Str(long millisecond);
}
