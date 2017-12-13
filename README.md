# countdown

 ![image](https://github.com/hello-hxb/countdown/blob/master/6DF43D0C5E3B24BC69D297249C65B059.gif)
 
## Android 中RecycleView中倒计时的实现

### 1. 让你的List中bean实现ITime接口
``` java
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

```

### 2.在adapter的构造方法中创建TextViewManager
```java
   mTextViewManager = new TextViewManager(dataList,  "倒计时已结束!");
```

### 3.在onBindViewHolder调用 mTextViewManager.attach(textView,holder);
```java
  TextView textView = holder.itemView.findViewById(R.id.tv_millis);

     mTextViewManager.attach(textView,holder);

```

### 最后,记得在合适的位置停止循环
```java
 @Override
    protected void onDestroy() {
        super.onDestroy();
        //在合适的位置停止倒计时
        mAdapter.getTextViewManager().stop();
    }
```