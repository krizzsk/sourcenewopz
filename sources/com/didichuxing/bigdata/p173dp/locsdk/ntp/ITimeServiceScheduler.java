package com.didichuxing.bigdata.p173dp.locsdk.ntp;

import android.content.Context;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.ITimeServiceScheduler */
public interface ITimeServiceScheduler {

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.ITimeServiceScheduler$OnTimeScheduleListener */
    public interface OnTimeScheduleListener {
        void onTimeTick(Context context);
    }

    void setOnTimeScheduleListener(OnTimeScheduleListener onTimeScheduleListener);

    void start();

    void stop();
}
