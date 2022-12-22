package com.didichuxing.dfbasesdk.utils;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimingTicker implements Handler.Callback {
    public static final int MSG_STOP = 2;
    public static final int MSG_TICKER = 1;

    /* renamed from: a */
    private final int f46756a;

    /* renamed from: b */
    private final ITicker f46757b;

    /* renamed from: c */
    private final int f46758c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f46759d;

    /* renamed from: e */
    private Timer f46760e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Handler f46761f = new Handler(this);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f46762g;

    public interface ITicker {
        void onStop();

        void onTicker(int i);
    }

    public static class TickerAdapter implements ITicker {
        public void onStop() {
        }

        public void onTicker(int i) {
        }
    }

    public TimingTicker(int i, int i2, int i3, TimeUnit timeUnit, ITicker iTicker) {
        this.f46756a = (int) timeUnit.toSeconds((long) i);
        this.f46757b = iTicker;
        this.f46758c = (int) timeUnit.toMillis((long) i2);
        this.f46759d = (int) timeUnit.toMillis((long) i3);
    }

    public void start() {
        if (this.f46760e != null) {
            exit();
        }
        Timer timer = new Timer();
        this.f46760e = timer;
        this.f46762g = this.f46756a;
        timer.schedule(new TimerTask() {
            public void run() {
                if (TimingTicker.this.f46762g <= 0) {
                    TimingTicker.this.exit();
                    TimingTicker.this.f46761f.obtainMessage(2).sendToTarget();
                } else {
                    TimingTicker.this.f46761f.obtainMessage(1, TimingTicker.this.f46762g, 0).sendToTarget();
                }
                TimingTicker timingTicker = TimingTicker.this;
                int unused = timingTicker.f46762g = timingTicker.f46762g - (TimingTicker.this.f46759d / 1000);
            }
        }, (long) this.f46758c, (long) this.f46759d);
    }

    public void exit() {
        Timer timer = this.f46760e;
        if (timer != null) {
            timer.cancel();
            this.f46760e.purge();
            this.f46760e = null;
        }
    }

    public boolean handleMessage(Message message) {
        ITicker iTicker;
        int i = message.what;
        if (i == 1) {
            ITicker iTicker2 = this.f46757b;
            if (iTicker2 == null) {
                return false;
            }
            iTicker2.onTicker(message.arg1);
            return false;
        } else if (i != 2 || (iTicker = this.f46757b) == null) {
            return false;
        } else {
            iTicker.onStop();
            return false;
        }
    }
}
