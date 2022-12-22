package com.didi.component.business.polling;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.didi.sdk.util.UiThreadHandler;

public class PollingManager {

    /* renamed from: c */
    private static final int f11328c = 1;

    /* renamed from: a */
    private HandlerThread f11329a;

    /* renamed from: b */
    private Handler f11330b;

    private PollingManager() {
    }

    private static final class Singleton {
        /* access modifiers changed from: private */
        public static final PollingManager sInstance = new PollingManager();

        private Singleton() {
        }
    }

    public static PollingManager getInstance() {
        return Singleton.sInstance;
    }

    public void startLoop(PollingTask pollingTask) {
        m7644b(pollingTask);
        stopLoop();
        m7643a(pollingTask);
    }

    public synchronized void stopLoop() {
        if (this.f11329a != null) {
            this.f11329a.quit();
            this.f11329a = null;
        }
        if (this.f11330b != null) {
            this.f11330b.removeMessages(1);
            this.f11330b = null;
        }
    }

    /* renamed from: a */
    private synchronized void m7643a(final PollingTask pollingTask) {
        if (pollingTask != null) {
            if (pollingTask.matchPollCondication()) {
                if (pollingTask.loopInterval() > 0) {
                    HandlerThread handlerThread = new HandlerThread("LOOP_THREAD", 10);
                    this.f11329a = handlerThread;
                    handlerThread.start();
                    C46351 r0 = new Handler(this.f11329a.getLooper()) {
                        public void handleMessage(Message message) {
                            super.handleMessage(message);
                            if (message.what == 1) {
                                UiThreadHandler.post(new Runnable() {
                                    public void run() {
                                        if (pollingTask != null) {
                                            pollingTask.run();
                                        }
                                    }
                                });
                                sendEmptyMessageDelayed(1, pollingTask.loopInterval());
                            }
                        }
                    };
                    this.f11330b = r0;
                    r0.sendEmptyMessageDelayed(1, pollingTask.loopInterval());
                }
            }
        }
    }

    /* renamed from: b */
    private void m7644b(PollingTask pollingTask) {
        if (pollingTask == null) {
            throw new IllegalArgumentException("PollingTask must not be null!");
        }
    }
}
