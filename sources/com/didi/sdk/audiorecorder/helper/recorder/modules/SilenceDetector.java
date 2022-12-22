package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.audiorecorder.helper.recorder.AudioProcessModule;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SilenceDetector extends AudioProcessModule implements Supporter.Pcm8kConsumer, Runnable {

    /* renamed from: a */
    private static final String f35399a = "SilenceDetector -> ";

    /* renamed from: b */
    private static final int f35400b = 3;

    /* renamed from: c */
    private static final int f35401c = 50;

    /* renamed from: d */
    private static final int f35402d = -1;

    /* renamed from: e */
    private static final int f35403e = 0;

    /* renamed from: f */
    private static final int f35404f = 0;

    /* renamed from: g */
    private static final int f35405g = 1;

    /* renamed from: h */
    private static final int f35406h = -1;

    /* renamed from: i */
    private ExecutorService f35407i = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-processor-silence_detector");
        }
    });

    /* renamed from: j */
    private final byte[] f35408j = new byte[48000];

    /* renamed from: k */
    private int f35409k;

    /* renamed from: l */
    private int f35410l;

    /* renamed from: m */
    private Supporter.Pcm8kProvider f35411m;

    private native int detect(byte[] bArr, int i);

    private native int init();

    private native int release();

    private native int reset();

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("sd");
            System.loadLibrary("native_silence_detect");
        } catch (Throwable unused) {
        }
    }

    public void setPcm8kProvider(Supporter.Pcm8kProvider pcm8kProvider) {
        this.f35411m = pcm8kProvider;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean performStart() {
        this.f35411m.addPcm8kConsumer(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        this.f35411m.removePcm8kConsumer(this);
        this.f35409k = 0;
        this.f35410l = 0;
        Arrays.fill(this.f35408j, (byte) 0);
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        int i2;
        if (isStarted()) {
            int i3 = this.f35410l;
            int i4 = i3 + 1;
            this.f35410l = i4;
            if (i3 > 50 && (i2 = this.f35409k) >= 0) {
                int i5 = i2 + i;
                byte[] bArr2 = this.f35408j;
                if (i5 <= bArr2.length) {
                    this.f35410l = i4 + 1;
                    System.arraycopy(bArr, 0, bArr2, i2, i);
                    int i6 = this.f35409k + i;
                    this.f35409k = i6;
                    if (i6 >= this.f35408j.length) {
                        this.f35409k = -1;
                        this.f35407i.execute(this);
                    }
                }
            }
        }
    }

    public void run() {
        if (isStarted()) {
            try {
                if (init() == 0) {
                    int reset = reset();
                    LogUtil.log(f35399a, "reset " + reset);
                    if (reset == 0) {
                        int detect = detect(this.f35408j, this.f35408j.length);
                        LogUtil.log(f35399a, "detect " + detect);
                        if (isStarted() && detect == 1) {
                            notifyError(16);
                        }
                    }
                }
                release();
            } catch (Exception e) {
                LogUtil.log("SilenceDetector -> detect fail. ", e);
            }
            stop();
        }
    }
}
