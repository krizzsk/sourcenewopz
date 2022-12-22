package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.helper.recorder.AudioProcessModule;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.ByteArrayAllocator;
import com.didi.sdk.audiorecorder.utils.log.LogService;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class PcmRecorder extends AudioProcessModule implements Supporter.Pcm16kProvider, Supporter.Pcm8kProvider {

    /* renamed from: a */
    private static final String f35394a = "PcmRecorder -> ";
    protected final int FRAME_SIZE_FOR_16K_PCM = 640;
    protected final int FRAME_SIZE_FOR_8K_PCM = 320;
    protected final int SAMPLE_RATE_16K = 16000;
    protected final int SAMPLE_RATE_8K = 8000;

    /* renamed from: b */
    private final Set<Supporter.Pcm8kConsumer> f35395b = new CopyOnWriteArraySet();

    /* renamed from: c */
    private final Set<Supporter.Pcm16kConsumer> f35396c = new CopyOnWriteArraySet();

    /* renamed from: d */
    private final int[] f35397d = {320};

    /* renamed from: e */
    private boolean f35398e;

    private native int init(int i, int i2);

    private native int release();

    private native int resample(byte[] bArr, int i, byte[] bArr2, int[] iArr);

    private native int reset();

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("resample");
            System.loadLibrary("native_pcm_resample");
        } catch (Throwable unused) {
            LogService.log2sd4RecordService("PcmRecorder -> Failed to load resample lib");
        }
    }

    /* access modifiers changed from: protected */
    public boolean performStart() {
        try {
            this.f35398e = init(16000, 8000) == 0;
        } catch (Exception unused) {
            SystemUtils.log(4, f35394a, "Failed to init pcm resampler.", (Throwable) null, "com.didi.sdk.audiorecorder.helper.recorder.modules.PcmRecorder", 49);
        }
        return this.f35398e;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        try {
            release();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f35398e = false;
            throw th;
        }
        this.f35398e = false;
    }

    public void addPcm8kConsumer(Supporter.Pcm8kConsumer pcm8kConsumer) {
        synchronized (this.f35395b) {
            this.f35395b.add(pcm8kConsumer);
        }
    }

    public void removePcm8kConsumer(Supporter.Pcm8kConsumer pcm8kConsumer) {
        synchronized (this.f35395b) {
            this.f35395b.remove(pcm8kConsumer);
        }
    }

    public void addPcm16kConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        synchronized (this.f35396c) {
            pcm16kConsumer.setPcm16kProvider(this);
            this.f35396c.add(pcm16kConsumer);
        }
    }

    public void removePcm16kConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        synchronized (this.f35396c) {
            pcm16kConsumer.setPcm16kProvider((Supporter.Pcm16kProvider) null);
            this.f35396c.remove(pcm16kConsumer);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchPcm16k(byte[] bArr, int i) {
        m25082a(this.f35396c, bArr, i);
    }

    /* access modifiers changed from: protected */
    public void dispatchPcm8k(byte[] bArr, int i) {
        m25082a(this.f35395b, bArr, i);
    }

    /* access modifiers changed from: protected */
    public byte[] resample16kTo8k(byte[] bArr, int i) {
        byte[] allocate;
        if (!this.f35398e || i != 640 || (allocate = ByteArrayAllocator.allocate(320)) == null || resample(bArr, i, allocate, this.f35397d) != 0) {
            return null;
        }
        return allocate;
    }

    /* renamed from: a */
    private void m25082a(Set set, byte[] bArr, int i) {
        boolean z = true;
        if (set.size() <= 1) {
            z = false;
        }
        byte[] bArr2 = null;
        for (Object next : set) {
            if ((z || bArr2 == null) && (bArr2 = ByteArrayAllocator.allocate(i)) != null) {
                System.arraycopy(bArr, 0, bArr2, 0, i);
            }
            if (bArr2 == null) {
                bArr2 = bArr;
            }
            if (next instanceof Supporter.Pcm16kConsumer) {
                ((Supporter.Pcm16kConsumer) next).onPcm16kFeed(bArr2, i);
            } else {
                ((Supporter.Pcm8kConsumer) next).onPcm8kFeed(bArr2, i);
            }
        }
    }
}
