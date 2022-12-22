package com.didi.soda.customer.biz.order;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

class OrderMonitorLooper {

    /* renamed from: a */
    private static final String f40422a = "OrderMonitorLooper";

    /* renamed from: b */
    private boolean f40423b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f40424c = 30000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<MonitorLooperListener> f40425d = new ArrayList();

    /* renamed from: e */
    private OrderHandler f40426e = new OrderHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            for (MonitorLooperListener looperWork : OrderMonitorLooper.this.f40425d) {
                looperWork.looperWork();
            }
        }
    });

    public interface MonitorLooperListener {
        void looperWork();
    }

    OrderMonitorLooper() {
    }

    /* renamed from: a */
    public boolean mo102013a() {
        return this.f40423b;
    }

    /* renamed from: a */
    public void mo102012a(MonitorLooperListener monitorLooperListener) {
        if (monitorLooperListener != null && !this.f40425d.contains(monitorLooperListener)) {
            this.f40425d.add(monitorLooperListener);
        }
    }

    /* renamed from: b */
    public void mo102014b() {
        this.f40423b = true;
        this.f40426e.sendEmptyMessage(4);
    }

    /* renamed from: a */
    public void mo102011a(int i) {
        this.f40424c = i;
    }

    /* renamed from: c */
    public void mo102016c() {
        if (!this.f40423b) {
            this.f40423b = true;
            this.f40426e.sendEmptyMessage(2);
        }
    }

    /* renamed from: d */
    public void mo102017d() {
        if (this.f40423b) {
            this.f40423b = false;
            this.f40426e.sendEmptyMessage(3);
        }
    }

    /* renamed from: b */
    public void mo102015b(MonitorLooperListener monitorLooperListener) {
        this.f40425d.remove(monitorLooperListener);
    }

    class OrderHandler extends Handler {
        public static final int DO_LOOP = 2;
        public static final int RESET_TIMER = 4;
        public static final int SHUT_DOWN = 3;
        private Runnable mRunnable;

        OrderHandler(Looper looper, Runnable runnable) {
            super(looper);
            this.mRunnable = runnable;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                LogUtil.m29100d(OrderMonitorLooper.f40422a, "loop mType: DO_LOOP");
                this.mRunnable.run();
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) OrderMonitorLooper.this.f40424c);
            } else if (i == 3) {
                LogUtil.m29100d(OrderMonitorLooper.f40422a, "loop mType: SHUT_DOWN");
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m29100d(OrderMonitorLooper.f40422a, "loop mType: RESET_TIMER");
                removeMessages(4);
                removeMessages(2);
                sendEmptyMessageDelayed(2, 0);
            }
        }
    }
}
