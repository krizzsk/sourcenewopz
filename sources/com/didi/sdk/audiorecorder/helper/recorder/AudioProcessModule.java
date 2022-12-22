package com.didi.sdk.audiorecorder.helper.recorder;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;

public abstract class AudioProcessModule implements Supporter.ErrorObservable, Supporter.OnOffSwitcher {

    /* renamed from: a */
    private AudioRecorder.OnErrorListener f35320a;

    /* renamed from: b */
    private volatile boolean f35321b;

    /* access modifiers changed from: protected */
    public abstract boolean performStart();

    /* access modifiers changed from: protected */
    public abstract void performStop();

    public final synchronized void start() {
        if (!this.f35321b) {
            this.f35321b = performStart();
        }
    }

    public final synchronized void stop() {
        if (this.f35321b) {
            this.f35321b = false;
            performStop();
        }
    }

    public final synchronized boolean isStarted() {
        return this.f35321b;
    }

    public final void setOnErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f35320a = onErrorListener;
    }

    /* access modifiers changed from: protected */
    public void notifyError(int i) {
        AudioRecorder.OnErrorListener onErrorListener = this.f35320a;
        if (onErrorListener != null) {
            onErrorListener.onError(i);
        }
    }
}
