package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.audiorecorder.helper.recorder.AudioProcessModule;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.AmrHelperFactory;
import com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.IAmrHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class AmrEncoder extends AudioProcessModule implements Supporter.AmrConsumer, Supporter.AmrProvider, Supporter.Pcm8kConsumer, Runnable {

    /* renamed from: a */
    private static final String f35364a = "AmrEncoder -> ";

    /* renamed from: b */
    private final LinkedBlockingQueue<byte[]> f35365b = new LinkedBlockingQueue<>();

    /* renamed from: c */
    private ExecutorService f35366c = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-processor-amr_encoder");
        }
    });

    /* renamed from: d */
    private IAmrHelper f35367d;

    /* renamed from: e */
    private Supporter.AmrConsumer f35368e;

    /* renamed from: f */
    private int f35369f;

    /* renamed from: g */
    private int f35370g;

    public void setConfig(int i, int i2) {
        this.f35369f = i;
        this.f35370g = i2;
    }

    /* access modifiers changed from: protected */
    public boolean performStart() {
        IAmrHelper create = AmrHelperFactory.create(this.f35369f, this.f35370g);
        this.f35367d = create;
        create.setAmrConsumer(this);
        this.f35367d.start();
        this.f35365b.clear();
        this.f35366c.execute(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        try {
            this.f35367d.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f35367d = null;
            throw th;
        }
        this.f35367d = null;
        this.f35365b.clear();
    }

    /* renamed from: a */
    private void m25061a(byte[] bArr) {
        IAmrHelper iAmrHelper = this.f35367d;
        if (iAmrHelper != null) {
            iAmrHelper.handleFrame(bArr);
        }
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        this.f35365b.add(bArr);
    }

    public void setAmrConsumer(Supporter.AmrConsumer amrConsumer) {
        this.f35368e = amrConsumer;
    }

    public void run() {
        while (isStarted()) {
            try {
                m25061a(this.f35365b.take());
            } catch (Exception unused) {
                LogUtil.log(f35364a, "failed to take frame");
            }
        }
    }

    public void onAmrFeed(byte[] bArr, int i) {
        Supporter.AmrConsumer amrConsumer;
        if (bArr != null && i > 0 && (amrConsumer = this.f35368e) != null) {
            amrConsumer.onAmrFeed(bArr, i);
        }
    }
}
