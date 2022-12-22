package com.didi.sdk.audiorecorder.service.mainprocess;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.d */
/* compiled from: RecordListenerWrapper */
final class C12090d implements AudioRecorder.DurationChangedListener, AudioRecorder.RecordListener {

    /* renamed from: a */
    private static final String f35450a = "RecordListenerWrapper -> ";

    /* renamed from: b */
    private AudioRecorder f35451b;

    /* renamed from: c */
    private AudioRecorder.FileSlicer f35452c;

    /* renamed from: d */
    private AudioRecorder.RecordListener f35453d;

    /* renamed from: e */
    private AudioRecorder.DurationChangedListener f35454e;

    /* renamed from: f */
    private int f35455f;

    /* renamed from: g */
    private volatile int f35456g;

    /* renamed from: h */
    private long f35457h;

    /* renamed from: i */
    private long f35458i;

    C12090d(AudioRecorder audioRecorder, AudioRecorder.FileSlicer fileSlicer) {
        this.f35451b = audioRecorder;
        this.f35452c = fileSlicer;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91164a(AudioRecorder.RecordListener recordListener) {
        this.f35453d = recordListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91163a(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f35454e = durationChangedListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91162a(int i) {
        this.f35455f = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo91166b(int i) {
        this.f35456g = i;
    }

    /* renamed from: a */
    public int mo91161a() {
        return this.f35456g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo91165b() {
        this.f35458i = this.f35457h;
    }

    public void onStart() {
        if (m25095e()) {
            LogUtil.log(f35450a, "onStart handled. (final record state = ", this.f35456g + ")");
            return;
        }
        LogUtil.log(f35450a, "onStart");
        AudioRecorder.RecordListener recordListener = this.f35453d;
        if (recordListener != null) {
            try {
                recordListener.onStart();
            } catch (Exception e) {
                LogUtil.log("RecordListenerWrapper -> Failed to callback onStart. ", e);
            }
        }
    }

    public void onResume() {
        if (m25094d()) {
            LogUtil.log("RecordListenerWrapper -> onResume handled. (final record state = ", this.f35456g + ")");
            return;
        }
        LogUtil.log(f35450a, "onResume");
        AudioRecorder.RecordListener recordListener = this.f35453d;
        if (recordListener != null) {
            try {
                recordListener.onResume();
            } catch (Exception e) {
                LogUtil.log("Failed to callback onResume. ", e);
            }
        }
    }

    public void onPause() {
        if (m25096f()) {
            LogUtil.log("RecordListenerWrapper -> onPause handled. (final record state = " + this.f35456g + ")");
            return;
        }
        LogUtil.log(f35450a, "onPause");
        AudioRecorder.RecordListener recordListener = this.f35453d;
        if (recordListener != null) {
            try {
                recordListener.onPause();
            } catch (Exception e) {
                LogUtil.log("Failed to callback onPause. ", e);
            }
        }
    }

    public void onStop() {
        this.f35457h = 0;
        if (m25097g()) {
            LogUtil.log("RecordListenerWrapper -> onStop handled. (final record state = " + this.f35456g + ")");
            return;
        }
        LogUtil.log(f35450a, "onStop");
        AudioRecorder.RecordListener recordListener = this.f35453d;
        if (recordListener != null) {
            try {
                recordListener.onStop();
            } catch (Exception e) {
                LogUtil.log("Failed to callback onStop listener ", e);
            }
        }
    }

    public void onTimeTick(int i) {
        this.f35457h = (long) i;
        AudioRecorder.DurationChangedListener durationChangedListener = this.f35454e;
        if (durationChangedListener != null) {
            try {
                durationChangedListener.onTimeTick(i);
            } catch (Exception e) {
                LogUtil.log("Failed to callback onTimeTick listener, recordDuration = " + i, e);
            }
        }
        m25098h();
    }

    /* renamed from: d */
    private boolean m25094d() {
        return m25095e();
    }

    /* renamed from: e */
    private boolean m25095e() {
        if (this.f35456g == 2) {
            this.f35451b.stopRecord();
            return true;
        } else if (this.f35456g != 4) {
            return false;
        } else {
            this.f35451b.pauseRecord();
            return true;
        }
    }

    /* renamed from: f */
    private boolean m25096f() {
        return m25097g();
    }

    /* renamed from: g */
    private boolean m25097g() {
        if (this.f35456g == 3) {
            this.f35451b.resumeRecord();
            return true;
        } else if (this.f35456g != 1) {
            return false;
        } else {
            this.f35451b.startRecord();
            return true;
        }
    }

    /* renamed from: h */
    private void m25098h() {
        int i;
        long j = this.f35457h;
        if (j != 0 && (i = this.f35455f) != 0 && (j - this.f35458i) % ((long) i) == 0) {
            LogUtil.log(f35450a, "sliceAudioIfNeed : recordDuration = " + j + ", segmentDuration = " + this.f35455f + ", mLatestSliceDuration = " + this.f35458i);
            this.f35452c.sliceAudioFile();
        }
    }

    /* renamed from: c */
    public boolean mo91167c() {
        return this.f35456g == 1 || this.f35456g == 3;
    }
}
