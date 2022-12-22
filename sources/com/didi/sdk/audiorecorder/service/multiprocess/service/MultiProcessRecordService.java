package com.didi.sdk.audiorecorder.service.multiprocess.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl;
import com.didi.sdk.audiorecorder.model.AudioRecordContextParcel;
import com.didi.sdk.audiorecorder.service.IRecordService;
import com.didi.sdk.audiorecorder.service.multiprocess.service.RecordBinder;
import com.didi.sdk.audiorecorder.utils.BroadcastHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MultiProcessRecordService extends Service implements AudioRecorder.FileSlicer, RecordBinder.ServiceManager {
    public static final String PROCESS_NAME = ":didi_recorder";

    /* renamed from: a */
    private static final String f35503a = "MultiProcessRecordService -> ";

    /* renamed from: b */
    private static final String f35504b = "recordContext";

    /* renamed from: c */
    private Binder f35505c;

    /* renamed from: d */
    private AudioRecorderImpl f35506d;

    /* renamed from: e */
    private C12112c f35507e;

    /* renamed from: f */
    private AudioRecordContextParcel f35508f;

    /* renamed from: g */
    private ExecutorService f35509g;

    public static void bind(Context context, ServiceConnection serviceConnection, AudioRecordContextParcel audioRecordContextParcel) {
        Intent intent = new Intent(context, MultiProcessRecordService.class);
        intent.putExtra(f35504b, audioRecordContextParcel);
        context.bindService(intent, serviceConnection, 1);
    }

    public static void unbind(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        LogUtil.init(applicationContext, false);
        BroadcastHelper.getInstance().init(applicationContext);
        LogUtil.log(f35503a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
        this.f35509g = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "didi-recorder-service");
            }
        });
        AudioRecorderImpl audioRecorderImpl = new AudioRecorderImpl(applicationContext, getFilesDir().getAbsolutePath() + IRecordService.DEFAULT_AUDIO_CACHE_FOLDER);
        this.f35506d = audioRecorderImpl;
        C12112c cVar = new C12112c(audioRecorderImpl, this, this.f35509g);
        this.f35507e = cVar;
        audioRecorderImpl.setRecordListener(cVar);
        this.f35506d.setDurationChangedListener(this.f35507e);
        C12113d dVar = new C12113d(this.f35509g);
        this.f35506d.setSpeechDetectListener(dVar);
        C12110a aVar = new C12110a(this.f35509g);
        this.f35506d.setOnErrorListener(aVar);
        C12111b bVar = new C12111b(this.f35509g);
        this.f35506d.setFileSliceListener(bVar);
        this.f35505c = new RecordBinder(this.f35506d, this, this.f35507e, aVar, bVar, dVar, this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        LogUtil.log(f35503a, "onStartCommand");
        m25131a(intent);
        return 1;
    }

    public IBinder onBind(Intent intent) {
        LogUtil.log(f35503a, "onBind");
        m25132b(intent);
        BroadcastHelper.getInstance().sendBroadcast(13, "3");
        return this.f35505c;
    }

    public void onRebind(Intent intent) {
        m25131a(intent);
    }

    public void onDestroy() {
        LogUtil.log("MultiProcessRecordService ->  -> onDestroy");
        this.f35505c = null;
        this.f35507e.mo91224b(2);
        this.f35506d.stopRecord();
        this.f35509g.shutdownNow();
        BroadcastHelper.getInstance().sendBroadcast(13, "5");
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }

    public void sliceAudioFile() {
        this.f35507e.mo91223b();
        this.f35506d.sliceAudioFile();
    }

    /* renamed from: a */
    private void m25131a(Intent intent) {
        if (m25132b(intent) && this.f35506d.isRecording()) {
            LogUtil.log(f35503a, "handleParamsReceived -> sliceAudio");
            sliceAudioFile();
        }
    }

    /* renamed from: b */
    private boolean m25132b(Intent intent) {
        AudioRecordContextParcel audioRecordContextParcel = (AudioRecordContextParcel) intent.getParcelableExtra(f35504b);
        if (audioRecordContextParcel == null) {
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed cancel.(empty businessAlias)");
            return false;
        } else if (audioRecordContextParcel.equals(this.f35508f)) {
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed cancel.(the same RecordContextParcel)");
            return false;
        } else {
            this.f35508f = audioRecordContextParcel;
            LogUtil.init(getApplicationContext(), audioRecordContextParcel.debugable);
            LogUtil.updateUserPhone(audioRecordContextParcel.userPhone);
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed recordContextParcel = " + audioRecordContextParcel);
            this.f35507e.mo91220a(audioRecordContextParcel.audioSegmentDuration);
            this.f35506d.update((AudioRecordContext) null, audioRecordContextParcel, audioRecordContextParcel.businessAlias, audioRecordContextParcel.isBluetoothRecordEnable, audioRecordContextParcel.audioCacheDir, audioRecordContextParcel.ttsServerName);
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed succ");
            return true;
        }
    }
}
