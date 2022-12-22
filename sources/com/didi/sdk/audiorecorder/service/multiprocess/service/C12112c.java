package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.IDurationChangedListener;
import com.didi.sdk.audiorecorder.IRecordListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.c */
/* compiled from: RecordListenerWrapper */
final class C12112c implements AudioRecorder.DurationChangedListener, AudioRecorder.RecordListener2 {

    /* renamed from: a */
    private static final String f35527a = "RecordListenerWrapper -> ";

    /* renamed from: b */
    private AudioRecorder f35528b;

    /* renamed from: c */
    private AudioRecorder.FileSlicer f35529c;

    /* renamed from: d */
    private ExecutorService f35530d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IRecordListener f35531e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IDurationChangedListener f35532f;

    /* renamed from: g */
    private int f35533g;

    /* renamed from: h */
    private volatile int f35534h;

    /* renamed from: i */
    private long f35535i;

    /* renamed from: j */
    private long f35536j;

    public void onGetPcmStream(byte[] bArr, int i, int i2) {
    }

    C12112c(AudioRecorder audioRecorder, AudioRecorder.FileSlicer fileSlicer, ExecutorService executorService) {
        this.f35528b = audioRecorder;
        this.f35529c = fileSlicer;
        this.f35530d = executorService;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91222a(IRecordListener iRecordListener) {
        this.f35531e = iRecordListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91221a(IDurationChangedListener iDurationChangedListener) {
        this.f35532f = iDurationChangedListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91220a(int i) {
        this.f35533g = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo91224b(int i) {
        this.f35534h = i;
    }

    /* renamed from: a */
    public int mo91219a() {
        return this.f35534h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo91223b() {
        this.f35536j = this.f35535i;
    }

    public void onStart() {
        if (m25143d()) {
            LogUtil.log(f35527a, "onStart handled. (final record state = ", this.f35534h + ")");
            return;
        }
        LogUtil.log(f35527a, "onStart");
        if (this.f35531e != null) {
            this.f35530d.execute(new RecordListenerWrapper$1(this));
        }
    }

    public void onResume() {
        if (m25142c()) {
            LogUtil.log("RecordListenerWrapper -> onResume handled. (final record state = ", this.f35534h + ")");
            return;
        }
        LogUtil.log(f35527a, "onResume");
        if (this.f35531e != null) {
            this.f35530d.execute(new RecordListenerWrapper$2(this));
        }
    }

    public void onPause() {
        if (m25144e()) {
            LogUtil.log("RecordListenerWrapper -> onPause handled. (final record state = " + this.f35534h + ")");
            return;
        }
        LogUtil.log(f35527a, "onPause");
        if (this.f35531e != null) {
            this.f35530d.execute(new RecordListenerWrapper$3(this));
        }
    }

    public void onStop() {
        this.f35535i = 0;
        if (m25145f()) {
            LogUtil.log("RecordListenerWrapper -> onStop handled. (final record state = " + this.f35534h + ")");
            return;
        }
        LogUtil.log(f35527a, "onStop");
        if (this.f35531e != null) {
            this.f35530d.execute(new RecordListenerWrapper$4(this));
        }
    }

    public void onTimeTick(int i) {
        this.f35535i = (long) i;
        if (this.f35532f != null) {
            this.f35530d.execute(new RecordListenerWrapper$5(this, i));
        }
        m25146g();
    }

    /* renamed from: c */
    private boolean m25142c() {
        return m25143d();
    }

    /* renamed from: d */
    private boolean m25143d() {
        if (this.f35534h == 2) {
            this.f35528b.stopRecord();
            return true;
        } else if (this.f35534h != 4) {
            return false;
        } else {
            this.f35528b.pauseRecord();
            return true;
        }
    }

    /* renamed from: e */
    private boolean m25144e() {
        return m25145f();
    }

    /* renamed from: f */
    private boolean m25145f() {
        if (this.f35534h == 3) {
            this.f35528b.resumeRecord();
            return true;
        } else if (this.f35534h != 1) {
            return false;
        } else {
            this.f35528b.startRecord();
            return true;
        }
    }

    /* renamed from: g */
    private void m25146g() {
        int i;
        long j = this.f35535i;
        if (j != 0 && (i = this.f35533g) != 0 && (j - this.f35536j) % ((long) i) == 0) {
            LogUtil.log(f35527a, "sliceAudioIfNeed : recordDuration = " + j + ", segmentDuration = " + this.f35533g + ", mLatestSliceDuration = " + this.f35536j);
            this.f35529c.sliceAudioFile();
        }
    }
}
