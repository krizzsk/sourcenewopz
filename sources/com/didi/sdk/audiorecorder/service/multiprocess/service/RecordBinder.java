package com.didi.sdk.audiorecorder.service.multiprocess.service;

import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.audiorecorder.IAudioRecord;
import com.didi.sdk.audiorecorder.IDurationChangedListener;
import com.didi.sdk.audiorecorder.IErrorListener;
import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.IGetDataServerAddressCallback;
import com.didi.sdk.audiorecorder.IRecordListener;
import com.didi.sdk.audiorecorder.ISpeechDetectListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer;
import com.didi.sdk.audiorecorder.utils.LogUtil;

final class RecordBinder extends IAudioRecord.Stub {

    /* renamed from: a */
    private static final String f35510a = "RecordBinder -> ";

    /* renamed from: j */
    private static final Handler f35511j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AudioRecorderImpl f35512b;

    /* renamed from: c */
    private AudioRecorder.FileSlicer f35513c;

    /* renamed from: d */
    private C12112c f35514d;

    /* renamed from: e */
    private C12110a f35515e;

    /* renamed from: f */
    private C12111b f35516f;

    /* renamed from: g */
    private C12113d f35517g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ServiceManager f35518h;

    /* renamed from: i */
    private final long f35519i;

    /* renamed from: k */
    private final Runnable f35520k = new Runnable() {
        public void run() {
            LogUtil.log(RecordBinder.f35510a, "StartRecordTask run");
            RecordBinder.this.f35512b.startRecord();
        }
    };

    /* renamed from: l */
    private final Runnable f35521l = new Runnable() {
        public void run() {
            LogUtil.log(RecordBinder.f35510a, "ResumeRecordTask run");
            RecordBinder.this.f35512b.resumeRecord();
        }
    };

    /* renamed from: m */
    private final Runnable f35522m = new Runnable() {
        public void run() {
            LogUtil.log(RecordBinder.f35510a, "StopServiceTask run");
            RecordBinder.this.f35518h.stopSelf();
        }
    };

    interface ServiceManager {
        void stopSelf();
    }

    RecordBinder(AudioRecorderImpl audioRecorderImpl, AudioRecorder.FileSlicer fileSlicer, C12112c cVar, C12110a aVar, C12111b bVar, C12113d dVar, ServiceManager serviceManager) {
        this.f35512b = audioRecorderImpl;
        this.f35513c = fileSlicer;
        this.f35514d = cVar;
        this.f35515e = aVar;
        this.f35516f = bVar;
        this.f35517g = dVar;
        this.f35518h = serviceManager;
        this.f35519i = System.currentTimeMillis();
    }

    public void start() {
        LogUtil.log(f35510a, "start");
        this.f35514d.mo91224b(1);
        f35511j.removeCallbacks(this.f35520k);
        f35511j.removeCallbacks(this.f35521l);
        f35511j.removeCallbacks(this.f35522m);
        long a = m25133a();
        if (a > 0) {
            f35511j.postDelayed(this.f35520k, a);
        } else {
            this.f35520k.run();
        }
    }

    public void stop() {
        LogUtil.log(f35510a, "stop");
        this.f35514d.mo91224b(2);
        f35511j.removeCallbacks(this.f35520k);
        f35511j.removeCallbacks(this.f35521l);
        f35511j.removeCallbacks(this.f35522m);
        f35511j.postDelayed(this.f35522m, 60000);
        this.f35512b.stopRecord();
    }

    public void pause() {
        LogUtil.log(f35510a, "pause");
        this.f35514d.mo91224b(4);
        f35511j.removeCallbacks(this.f35520k);
        f35511j.removeCallbacks(this.f35521l);
        f35511j.removeCallbacks(this.f35522m);
        this.f35512b.pauseRecord();
    }

    public void resume() {
        LogUtil.log(f35510a, "resume");
        this.f35514d.mo91224b(3);
        f35511j.removeCallbacks(this.f35520k);
        f35511j.removeCallbacks(this.f35521l);
        f35511j.removeCallbacks(this.f35522m);
        long a = m25133a();
        if (a > 0) {
            f35511j.postDelayed(this.f35521l, a);
        } else {
            this.f35521l.run();
        }
    }

    public boolean isRecording() {
        int a = this.f35514d.mo91219a();
        boolean z = this.f35512b.isRecording() && (a == 1 || a == 3);
        LogUtil.log(f35510a, "isRecording = " + z);
        return z;
    }

    public void updateSpeechDetectParams(String str) {
        LogUtil.log(f35510a, "updateSpeechDetectParams ： " + str);
        this.f35512b.updateSpeechDetectParams(str);
    }

    public void regRecordListener(IRecordListener iRecordListener) {
        this.f35514d.mo91222a(iRecordListener);
    }

    public void unregRecordListener() {
        this.f35514d.mo91222a((IRecordListener) null);
    }

    public void regDurationChangedListener(IDurationChangedListener iDurationChangedListener) {
        this.f35514d.mo91221a(iDurationChangedListener);
    }

    public void unregDurationChangedListener() {
        this.f35514d.mo91221a((IDurationChangedListener) null);
    }

    public void regErrorListener(IErrorListener iErrorListener) {
        this.f35515e.mo91217a(iErrorListener);
    }

    public void unregErrorListener() {
        LogUtil.log(f35510a, "unregErrorListener");
        this.f35515e.mo91217a((IErrorListener) null);
    }

    public void regFileSliceListener(IFileSliceListener iFileSliceListener) {
        this.f35516f.mo91218a(iFileSliceListener);
    }

    public void unregFileSliceListener() {
        this.f35516f.mo91218a((IFileSliceListener) null);
    }

    public void regSpeechDetectListener(ISpeechDetectListener iSpeechDetectListener) {
        this.f35517g.mo91225a(iSpeechDetectListener);
    }

    public void unregSpeechDetectListener() {
        this.f35517g.mo91225a((ISpeechDetectListener) null);
    }

    public void start16kPcmServer(final IGetDataServerAddressCallback iGetDataServerAddressCallback) {
        DataTransferServer.getInstance().startServer().acquireServerName(new DataTransferServer.AcquireServerNameCallback() {
            public void onAcquired(String str) {
                try {
                    iGetDataServerAddressCallback.onGetAddress(str);
                } catch (Exception unused) {
                }
            }
        });
        this.f35512b.setPcm16kConsumer(DataTransferServer.getInstance());
    }

    public void stop16kPcmServer() {
        this.f35512b.setPcm16kConsumer((Supporter.Pcm16kConsumer) null);
        DataTransferServer.getInstance().stopServer();
    }

    public void clearTTSData() {
        this.f35512b.clearTtsDataCache();
    }

    public void sliceAudioFile() {
        LogUtil.log(f35510a, "sliceAudioFile");
        this.f35513c.sliceAudioFile();
    }

    /* renamed from: a */
    private long m25133a() {
        return System.currentTimeMillis() - this.f35519i < 1000 ? 1000 : 0;
    }
}
