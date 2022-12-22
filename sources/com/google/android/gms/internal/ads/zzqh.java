package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqh implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzqh zzbmu = new zzqh();
    private final Handler handler;
    public volatile long zzbmt;
    private final HandlerThread zzbmv;
    private Choreographer zzbmw;
    private int zzbmx;

    public static zzqh zzjt() {
        return zzbmu;
    }

    private zzqh() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.zzbmv = handlerThread;
        handlerThread.start();
        Handler handler2 = new Handler(this.zzbmv.getLooper(), this);
        this.handler = handler2;
        handler2.sendEmptyMessage(0);
    }

    public final void zzju() {
        this.handler.sendEmptyMessage(1);
    }

    public final void removeObserver() {
        this.handler.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.zzbmt = j;
        this.zzbmw.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zzbmw = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.zzbmx + 1;
            this.zzbmx = i2;
            if (i2 == 1) {
                this.zzbmw.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.zzbmx - 1;
            this.zzbmx = i3;
            if (i3 == 0) {
                this.zzbmw.removeFrameCallback(this);
                this.zzbmt = 0;
            }
            return true;
        }
    }
}
