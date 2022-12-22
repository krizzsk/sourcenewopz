package com.didichuxing.mlcp.drtc.utils;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didichuxing.mlcp.drtc.utils.d */
/* compiled from: ExAudioRecorder */
public class C15919d implements Runnable {

    /* renamed from: a */
    private boolean f48452a = false;

    /* renamed from: b */
    private AudioRecord f48453b = m34725d();

    /* renamed from: c */
    private C15920a f48454c = null;

    /* renamed from: d */
    private volatile boolean f48455d = true;

    /* renamed from: com.didichuxing.mlcp.drtc.utils.d$a */
    /* compiled from: ExAudioRecorder */
    public interface C15920a {
        /* renamed from: a */
        void mo118996a(byte[] bArr);
    }

    private C15919d() {
    }

    /* renamed from: c */
    public static C15919d m34724c() {
        return new C15919d();
    }

    /* renamed from: d */
    private synchronized AudioRecord m34725d() {
        AudioRecord audioRecord;
        audioRecord = null;
        int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
        if (minBufferSize == -2) {
            SystemUtils.log(3, "ExAudioRecorder -> ", "createAudioRecord -> error_bad_value.", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 3);
        } else if (minBufferSize == -1) {
            SystemUtils.log(3, "ExAudioRecorder -> ", "createAudioRecord -> error.", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 5);
        } else if (minBufferSize <= 0) {
            SystemUtils.log(3, "ExAudioRecorder -> ", "createAudioRecord -> illegal buffer size: " + minBufferSize, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 7);
        } else {
            audioRecord = Build.VERSION.SDK_INT >= 23 ? m34722a(7, 8000, 16, 2, minBufferSize * 2) : m34723b(7, 8000, 16, 2, minBufferSize * 2);
        }
        return audioRecord;
    }

    /* renamed from: a */
    public boolean mo119057a() {
        return this.f48452a;
    }

    /* renamed from: b */
    public void mo119058b() {
        this.f48455d = false;
    }

    public void run() {
        this.f48453b.startRecording();
        this.f48452a = true;
        this.f48455d = true;
        while (this.f48455d) {
            try {
                byte[] a = C15917b.m34719a(160);
                if (a == null) {
                    SystemUtils.log(2, "ExAudioRecorder", "read record buff is null", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 8);
                } else if (this.f48453b.read(a, 0, a.length) > 0 && this.f48454c != null) {
                    this.f48454c.mo118996a(a);
                }
            } catch (Throwable th) {
                SystemUtils.log(3, "ExAudioRecorder -> ", th.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 19);
            }
        }
        this.f48452a = false;
        AudioRecord audioRecord = this.f48453b;
        if (audioRecord != null) {
            audioRecord.stop();
        }
    }

    /* renamed from: a */
    private static AudioRecord m34722a(int i, int i2, int i3, int i4, int i5) {
        return new AudioRecord.Builder().setAudioSource(i).setAudioFormat(new AudioFormat.Builder().setEncoding(i4).setSampleRate(i2).setChannelMask(i3).build()).setBufferSizeInBytes(i5).build();
    }

    /* renamed from: a */
    public void mo119056a(C15920a aVar) {
        if (this.f48454c == null) {
            this.f48454c = aVar;
        }
    }

    /* renamed from: b */
    private static AudioRecord m34723b(int i, int i2, int i3, int i4, int i5) {
        return new AudioRecord(i, i2, i3, i4, i5);
    }
}
