package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class InjectedPcmRecorder extends PcmRecorder implements Supporter.Pcm16kConsumer, Runnable {

    /* renamed from: a */
    private static final String f35376a = "InjectedPcmRecorder -> ";

    /* renamed from: b */
    private final LinkedBlockingQueue<byte[]> f35377b = new LinkedBlockingQueue<>();

    /* renamed from: c */
    private final ExecutorService f35378c = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-processor-injected_recorder");
        }
    });

    /* renamed from: d */
    private Supporter.Pcm16kProvider f35379d;

    /* access modifiers changed from: protected */
    public boolean performStart() {
        boolean performStart = super.performStart();
        if (performStart) {
            Supporter.Pcm16kProvider pcm16kProvider = this.f35379d;
            if (pcm16kProvider != null) {
                pcm16kProvider.addPcm16kConsumer(this);
            }
            this.f35378c.execute(this);
        }
        return performStart;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        super.performStop();
        LogUtil.log("performStop, clear len = " + this.f35377b.size());
        this.f35377b.clear();
        Supporter.Pcm16kProvider pcm16kProvider = this.f35379d;
        if (pcm16kProvider != null) {
            pcm16kProvider.removePcm16kConsumer(this);
        }
    }

    public void onPcm16kFeed(byte[] bArr, int i) {
        if (bArr != null && i == 640) {
            try {
                this.f35377b.put(bArr);
            } catch (Exception unused) {
            }
        }
    }

    public void setPcm16kProvider(Supporter.Pcm16kProvider pcm16kProvider) {
        this.f35379d = pcm16kProvider;
        if (isStarted()) {
            this.f35379d.addPcm16kConsumer(this);
        }
    }

    public void run() {
        while (isStarted()) {
            try {
                byte[] take = this.f35377b.take();
                dispatchPcm16k(take, take.length);
                byte[] resample16kTo8k = resample16kTo8k(take, take.length);
                if (resample16kTo8k != null) {
                    dispatchPcm8k(resample16kTo8k, resample16kTo8k.length);
                }
            } catch (Exception e) {
                LogUtil.log("InjectedPcmRecorder -> run -> resample fail", e);
            }
        }
    }
}
