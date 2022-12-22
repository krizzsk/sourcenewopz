package com.kwai.koom.javaoom.monitor;

import android.os.Handler;
import android.os.HandlerThread;
import com.didi.sdk.apm.SystemUtils;
import com.kwai.koom.javaoom.common.KConstants;
import java.util.ArrayList;
import java.util.List;

public class MonitorThread {

    /* renamed from: a */
    private static final String f55634a = "MonitorThread";

    /* renamed from: b */
    private HandlerThread f55635b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f55636c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MonitorTriggerListener f55637d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f55638e = false;

    public MonitorThread() {
        HandlerThread handlerThread = new HandlerThread(f55634a);
        this.f55635b = handlerThread;
        handlerThread.start();
        this.f55636c = new Handler(this.f55635b.getLooper());
    }

    public void start(List<Monitor> list) {
        this.f55638e = false;
        SystemUtils.log(4, f55634a, "start", (Throwable) null, "com.kwai.koom.javaoom.monitor.MonitorThread", 45);
        ArrayList<Runnable> arrayList = new ArrayList<>();
        for (Monitor next : list) {
            next.start();
            arrayList.add(new MonitorRunnable(next));
        }
        for (Runnable post : arrayList) {
            this.f55636c.post(post);
        }
    }

    public void stop() {
        this.f55638e = true;
    }

    public void setMonitorTriggerListener(MonitorTriggerListener monitorTriggerListener) {
        this.f55637d = monitorTriggerListener;
    }

    class MonitorRunnable implements Runnable {
        private Monitor monitor;

        public MonitorRunnable(Monitor monitor2) {
            this.monitor = monitor2;
        }

        public void run() {
            if (!MonitorThread.this.f55638e) {
                boolean z = KConstants.Debug.VERBOSE_LOG;
                if (this.monitor.isTrigger()) {
                    SystemUtils.log(4, MonitorThread.f55634a, this.monitor.monitorType() + " monitor " + this.monitor.monitorType() + " trigger", (Throwable) null, "com.kwai.koom.javaoom.monitor.MonitorThread$MonitorRunnable", 88);
                    MonitorThread monitorThread = MonitorThread.this;
                    boolean unused = monitorThread.f55638e = monitorThread.f55637d.onTrigger(this.monitor.monitorType(), this.monitor.getTriggerReason());
                }
                if (!MonitorThread.this.f55638e) {
                    MonitorThread.this.f55636c.postDelayed(this, (long) this.monitor.pollInterval());
                }
            }
        }
    }
}
