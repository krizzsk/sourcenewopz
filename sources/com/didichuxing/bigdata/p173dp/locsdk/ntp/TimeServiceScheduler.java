package com.didichuxing.bigdata.p173dp.locsdk.ntp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.ITimeServiceScheduler;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceScheduler */
public class TimeServiceScheduler implements ITimeServiceScheduler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f46033a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ITimeServiceScheduler.OnTimeScheduleListener f46034b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f46035c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Runnable f46036d = new Runnable() {
        public void run() {
            if (TimeServiceScheduler.this.f46034b != null) {
                TimeServiceScheduler.this.f46034b.onTimeTick(TimeServiceScheduler.this.f46033a);
            }
            if (TimeServiceScheduler.this.f46035c != null) {
                TimeServiceScheduler.this.f46035c.postDelayed(TimeServiceScheduler.this.f46036d, 60000);
            }
        }
    };

    public TimeServiceScheduler(Context context) {
        this.f46033a = context;
        this.f46035c = new Handler(Looper.getMainLooper());
    }

    public void setOnTimeScheduleListener(ITimeServiceScheduler.OnTimeScheduleListener onTimeScheduleListener) {
        this.f46034b = onTimeScheduleListener;
    }

    public void start() {
        Handler handler = this.f46035c;
        if (handler != null) {
            handler.postDelayed(this.f46036d, 60000);
        }
    }

    public void stop() {
        Handler handler = this.f46035c;
        if (handler != null) {
            handler.removeCallbacks(this.f46036d);
        }
    }
}
