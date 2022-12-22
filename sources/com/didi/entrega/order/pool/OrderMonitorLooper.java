package com.didi.entrega.order.pool;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

class OrderMonitorLooper {

    /* renamed from: a */
    private static final String f20923a = "EntregaOrderMonitorLooper";

    /* renamed from: b */
    private boolean f20924b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f20925c = 30000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<MonitorLooperListener> f20926d = new ArrayList();

    /* renamed from: e */
    private OrderHandler f20927e = new OrderHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            for (MonitorLooperListener looperWork : OrderMonitorLooper.this.f20926d) {
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
    public boolean mo62470a() {
        return this.f20924b;
    }

    /* renamed from: b */
    public void mo62471b() {
        this.f20924b = true;
        this.f20927e.sendEmptyMessage(4);
    }

    /* renamed from: a */
    public void mo62468a(int i) {
        this.f20925c = i;
    }

    /* renamed from: c */
    public void mo62473c() {
        if (!this.f20924b) {
            this.f20924b = true;
            this.f20927e.sendEmptyMessage(2);
        }
    }

    /* renamed from: d */
    public void mo62474d() {
        if (this.f20924b) {
            this.f20924b = false;
            this.f20927e.sendEmptyMessage(3);
        }
    }

    /* renamed from: a */
    public void mo62469a(MonitorLooperListener monitorLooperListener) {
        if (monitorLooperListener != null && !this.f20926d.contains(monitorLooperListener)) {
            this.f20926d.add(monitorLooperListener);
        }
    }

    /* renamed from: b */
    public void mo62472b(MonitorLooperListener monitorLooperListener) {
        this.f20926d.remove(monitorLooperListener);
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
                LogUtil.m14761d(OrderMonitorLooper.f20923a, "loop mType: DO_LOOP");
                this.mRunnable.run();
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) OrderMonitorLooper.this.f20925c);
            } else if (i == 3) {
                LogUtil.m14761d(OrderMonitorLooper.f20923a, "loop mType: SHUT_DOWN");
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m14761d(OrderMonitorLooper.f20923a, "loop mType: RESET_TIMER");
                removeMessages(4);
                removeMessages(2);
                sendEmptyMessageDelayed(2, 0);
            }
        }
    }
}
