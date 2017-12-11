package com.hxb.countdown;

import com.hxb.libcountdown.ITime;

/**
 * Created by hxb♬ on 2017/12/11.
 */

public class ItemData implements ITime {

    private long millis ;


    @Override
    public void setMillisecond(long millisecond) {
        millis=millisecond;
    }

    @Override
    public long getMillisecond() {
        return millis;
    }

    @Override
    public String mill2Str(long millisecond) {
        if (millisecond <= 0 ) return "";
        StringBuilder sb = new StringBuilder();
        String[] units = {"天", "小时", "分钟", "秒", "毫秒"};
        int[] unitLen = {86400000, 3600000, 60000, 1000, 1};
        for (int i = 0; i < 4; i++) {
            if (millisecond >= unitLen[i]) {
                long mode = millisecond / unitLen[i];
                millisecond -= mode * unitLen[i];
                sb.append(mode).append(units[i]);
            }
        }
        return sb.toString();
    }


}
