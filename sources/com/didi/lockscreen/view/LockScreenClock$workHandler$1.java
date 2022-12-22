package com.didi.lockscreen.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.TimeStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/lockscreen/view/LockScreenClock$workHandler$1", "Landroid/os/Handler;", "getClock", "", "timeStamp", "", "getTime", "handleMessage", "", "msg", "Landroid/os/Message;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LockScreenClock.kt */
public final class LockScreenClock$workHandler$1 extends Handler {
    final /* synthetic */ LockScreenClock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LockScreenClock$workHandler$1(LockScreenClock lockScreenClock, Looper looper) {
        super(looper);
        this.this$0 = lockScreenClock;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, "msg");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (message.what == 10029) {
            this.this$0.f24412a.setText(getClock(currentTimeMillis));
        }
        if (message.what == 10030) {
            this.this$0.f24413b.setText(getTime(currentTimeMillis));
        }
    }

    public final String getClock(long j) {
        return Elvish.Companion.getInstance().formatDateTime(j, DateStyle.NONE, TimeStyle.TIME_HH_MM, false);
    }

    public final String getTime(long j) {
        return Elvish.Companion.getInstance().formatDateTime(j, DateStyle.DATE_EEE_DD_MTH, TimeStyle.NONE, false);
    }
}
