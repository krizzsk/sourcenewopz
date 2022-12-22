package com.didi.travel.psnger.core.poll.impl;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.core.poll.BasePoller;
import com.didi.travel.psnger.core.poll.IPollCallbackProtocol;
import com.didi.travel.psnger.utils.LogUtil;

public class DefaultPoller extends BasePoller {

    /* renamed from: a */
    private static final int f44196a = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IPollCallbackProtocol f44197b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f44198c = 0;

    /* renamed from: d */
    private final int f44199d = 1000;

    /* renamed from: e */
    private CountDownTimer f44200e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f44201f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f44202g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public HandlerThread f44203h = null;

    public void registerPollCallback(IPollCallbackProtocol iPollCallbackProtocol) {
        super.registerPollCallback(iPollCallbackProtocol);
        this.f44197b = iPollCallbackProtocol;
    }

    public void startPoll(long j, long j2, long j3) {
        super.startPoll(j, j2, j3);
        LogUtil.m31432fi("startOrderStatusPoll");
        startPoll(j, j2, j3, false);
    }

    public void startPoll(long j, long j2, long j3, boolean z) {
        super.startPoll(j, j2, j3, z);
        LogUtil.m31432fi("startOrderStatusPoll isDelay=" + z);
        this.f44201f = false;
        this.mFrequencyTime = j2;
        m31403a(z);
        m31402a(j, j3);
    }

    public int getPollRunningTime() {
        return this.f44198c;
    }

    public synchronized void stopPoll() {
        super.stopPoll();
        LogUtil.m31432fi("stopPoll");
        if (this.f44200e != null) {
            this.f44200e.cancel();
            this.f44200e = null;
        }
        if (this.f44203h != null) {
            this.f44203h.quit();
            this.f44203h = null;
        }
        if (this.f44202g != null) {
            this.f44202g.removeMessages(1);
            this.f44202g = null;
        }
        if (this.f44197b != null) {
            this.f44197b.onPollStop();
        }
        this.f44201f = true;
    }

    public boolean checkPollerRunning() {
        super.checkPollerRunning();
        return !this.f44201f;
    }

    /* renamed from: a */
    private synchronized void m31403a(boolean z) {
        HandlerThread handlerThread = new HandlerThread("CHECK ORDER STATUS");
        this.f44203h = handlerThread;
        handlerThread.start();
        C143481 r0 = new Handler(this.f44203h.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            if (DefaultPoller.this.f44197b != null) {
                                DefaultPoller.this.f44197b.onSendRequest(DefaultPoller.this.f44198c);
                            }
                        }
                    });
                    DefaultPoller.this.m31401a();
                }
            }
        };
        this.f44202g = r0;
        if (z) {
            r0.sendEmptyMessageDelayed(1, this.mFrequencyTime);
        } else {
            r0.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    private void m31402a(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        C143502 r0 = new CountDownTimer(j, 1000) {
            public void onTick(long j) {
                int unused = DefaultPoller.this.f44198c = (int) (((j3 / 1000) - ((long) (((int) j) / 1000))) + (j4 / 1000));
                if (DefaultPoller.this.f44197b != null) {
                    DefaultPoller.this.f44197b.onNotifyUpdateUI(DefaultPoller.this.f44198c);
                }
            }

            public void onFinish() {
                int unused = DefaultPoller.this.f44198c = (int) (j3 / 1000);
                boolean unused2 = DefaultPoller.this.f44201f = true;
                synchronized (DefaultPoller.this) {
                    if (DefaultPoller.this.f44203h != null) {
                        DefaultPoller.this.f44203h.quit();
                        HandlerThread unused3 = DefaultPoller.this.f44203h = null;
                    }
                    if (DefaultPoller.this.f44202g != null) {
                        DefaultPoller.this.f44202g.removeMessages(1);
                        Handler unused4 = DefaultPoller.this.f44202g = null;
                    }
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultPoller.this.f44197b != null) {
                            DefaultPoller.this.f44197b.onPollTimeout();
                        }
                    }
                });
            }
        };
        this.f44200e = r0;
        r0.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m31401a() {
        if (this.f44202g != null) {
            Message obtain = Message.obtain();
            if (obtain == null) {
                this.f44202g.sendEmptyMessageDelayed(1, this.mFrequencyTime);
            } else {
                obtain.what = 1;
                this.f44202g.sendMessageDelayed(obtain, this.mFrequencyTime);
            }
        }
    }

    public synchronized void updatePollFrequenceTime(long j) {
        if (this.mFrequencyTime != j) {
            super.updatePollFrequenceTime(j);
            if (this.f44202g != null) {
                this.f44202g.removeMessages(1);
                m31401a();
            }
        }
    }
}
