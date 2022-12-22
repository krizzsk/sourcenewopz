package com.didi.unifylogin.utils;

import android.os.CountDownTimer;
import java.lang.ref.WeakReference;

public class TimerCount extends CountDownTimer {

    /* renamed from: a */
    WeakReference<TimerListener> f44946a;

    public interface TimerListener {
        void onFinish();

        void onTick(long j);
    }

    public TimerCount(long j, long j2, TimerListener timerListener) {
        super(j, j2);
        this.f44946a = new WeakReference<>(timerListener);
    }

    public void onTick(long j) {
        TimerListener timerListener = (TimerListener) this.f44946a.get();
        if (timerListener != null) {
            timerListener.onTick(j);
        }
    }

    public void onFinish() {
        TimerListener timerListener = (TimerListener) this.f44946a.get();
        if (timerListener != null) {
            timerListener.onFinish();
        }
    }
}
