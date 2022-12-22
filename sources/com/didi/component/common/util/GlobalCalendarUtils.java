package com.didi.component.common.util;

import android.content.Context;
import com.taxis99.R;
import java.util.Calendar;
import java.util.Date;

public class GlobalCalendarUtils {
    public static String getTimeDescribe(long j, Context context) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j * 1000));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date(System.currentTimeMillis()));
        instance2.set(11, 0);
        instance2.set(12, 0);
        if (instance.after(instance2)) {
            return context.getString(R.string.today);
        }
        instance2.add(5, -1);
        if (instance.after(instance2)) {
            return context.getString(R.string.yesterday);
        }
        String[] stringArray = context.getResources().getStringArray(R.array.global_week_list);
        int i = instance.get(7) - 1;
        return i < stringArray.length ? stringArray[i] : "";
    }
}
