package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IRecordListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.atomic.AtomicBoolean;

final class BinderRecordStateListener extends IRecordListener.Stub {

    /* renamed from: d */
    private static final String f35459d = "BinderRecordStateListener -> ";

    /* renamed from: a */
    final LoopCheckTask f35460a = new LoopCheckTask();

    /* renamed from: b */
    AudioRecorder.RecordListener f35461b;

    /* renamed from: c */
    volatile int f35462c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f35463e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final MultiProcessRecordServiceConnection f35464f;

    BinderRecordStateListener(Handler handler, MultiProcessRecordServiceConnection multiProcessRecordServiceConnection) {
        this.f35463e = handler;
        this.f35464f = multiProcessRecordServiceConnection;
    }

    public void onStart() {
        LogUtil.log("BinderRecordStateListener -> onStart -> finalRecordState = " + this.f35462c);
        this.f35460a.start();
        if (this.f35461b != null) {
            this.f35463e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f35461b != null) {
                        BinderRecordStateListener.this.f35461b.onStart();
                    }
                }
            });
        }
    }

    public void onResume() {
        LogUtil.log("BinderRecordStateListener -> onResume -> finalRecordState = " + this.f35462c);
        this.f35460a.start();
        if (this.f35461b != null) {
            this.f35463e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f35461b != null) {
                        BinderRecordStateListener.this.f35461b.onResume();
                    }
                }
            });
        }
    }

    public void onPause() {
        LogUtil.log("BinderRecordStateListener -> onPause -> finalRecordState = " + this.f35462c);
        this.f35460a.cancel();
        if (this.f35461b != null) {
            this.f35463e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f35461b != null) {
                        BinderRecordStateListener.this.f35461b.onPause();
                    }
                }
            });
        }
    }

    public void onStop() {
        LogUtil.log("BinderRecordStateListener -> onStop -> finalRecordState = " + this.f35462c);
        this.f35460a.cancel();
        if (this.f35461b != null) {
            this.f35463e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f35461b != null) {
                        BinderRecordStateListener.this.f35461b.onStop();
                    }
                }
            });
        }
    }

    class LoopCheckTask implements Runnable {
        private final long LOOP_INTERVAL = 10000;
        private AtomicBoolean mRunFlag = new AtomicBoolean(false);

        LoopCheckTask() {
        }

        /* access modifiers changed from: package-private */
        public void start() {
            start(10000);
        }

        /* access modifiers changed from: package-private */
        public void start(long j) {
            cancel();
            BinderRecordStateListener.this.f35463e.postDelayed(this, j);
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            this.mRunFlag.set(false);
            BinderRecordStateListener.this.f35463e.removeCallbacks(this);
        }

        public void run() {
            if (!this.mRunFlag.get()) {
                this.mRunFlag.set(true);
                BinderRecordStateListener.this.f35464f.f35474a.execute(this);
                return;
            }
            boolean z = BinderRecordStateListener.this.f35462c == 1 || BinderRecordStateListener.this.f35462c == 3;
            LogUtil.log("BinderRecordStateListener -> loopCheckTask finalRecordState = " + BinderRecordStateListener.this.f35462c);
            if (z) {
                if (!BinderRecordStateListener.this.f35464f.isRecording()) {
                    LogUtil.log("BinderRecordStateListener -> loopCheckTask run. record status illegal");
                    if (BinderRecordStateListener.this.f35462c == 1) {
                        BinderRecordStateListener.this.f35464f.startRecord();
                    } else {
                        BinderRecordStateListener.this.f35464f.resumeRecord();
                    }
                }
                if (this.mRunFlag.get()) {
                    this.mRunFlag.set(false);
                    BinderRecordStateListener.this.f35463e.postDelayed(this, 10000);
                }
            }
        }
    }
}
