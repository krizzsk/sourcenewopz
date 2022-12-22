package com.didi.sdk.audiorecorder;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.sdk.audiorecorder.exception.IlegalBusinessAliasException;
import com.didi.sdk.audiorecorder.exception.RecordContextNotFoundException;
import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecordActionListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.RecordListenerSets;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.multiprocess.service.MultiProcessRecordService;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import com.didi.sdk.audiorecorder.utils.ProcessUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class AudioRecordManager implements AudioRecorder {
    public static final int ERR_BAD_READ_VALUE = -2;
    public static final int ERR_CREATE_AUDIO_FILE = 2;
    public static final int ERR_CREATE_CACHE_DIR = 1;
    public static final int ERR_DISABLE_QUERY_HARDWARE = 13;
    public static final int ERR_FAIL_TO_ACQUIRE_AUDIO_DATA = 15;
    public static final int ERR_ILLEGAL_RECORD_BUFFER_SIZE = 14;
    public static final int ERR_INVALID_READ_OPERATION = -3;
    public static final int ERR_READ_DATA = -1;
    public static final int ERR_READ_DEAD_OBJECT = -6;
    public static final int ERR_RECORD_EXCEPTION = 8;
    public static final int ERR_RECORD_FAIL = 7;
    public static final int ERR_RECORD_INIT_FAIL = 5;
    public static final int ERR_RECORD_START_FAIL = 6;
    public static final int ERR_RELEASE_RECORDER = 11;
    public static final int ERR_RESAMPLE_STREAM = 9;
    public static final int ERR_SILENCE_DETECTED = 16;
    public static final int ERR_STOP_RECORDER = 10;
    public static final int ERR_SWITCH_DATA_STREAM = 3;
    public static final int ERR_UNKNOWN = 0;
    public static final int ERR_UNSUPPORTED_RECORD_PARAMS = 12;
    public static final int ERR_WRITE_AMR_HEADER = 4;

    /* renamed from: a */
    private static volatile AudioRecordManager f35275a;

    /* renamed from: b */
    private String f35276b;

    /* renamed from: c */
    private AudioRecordContext f35277c;

    /* renamed from: d */
    private final Map<String, AudioRecordContext> f35278d = new HashMap();

    /* renamed from: e */
    private final RecordLifecycleHandler f35279e;

    /* renamed from: f */
    private final RecordListenerSets f35280f = new RecordListenerSets();

    public static AudioRecordManager get() {
        if (f35275a == null) {
            synchronized (AudioRecordManager.class) {
                if (f35275a == null) {
                    f35275a = new AudioRecordManager();
                }
            }
        }
        return f35275a;
    }

    private AudioRecordManager() {
        m24972a(this.f35278d);
        RecordLifecycleHandler recordLifecycleHandler = new RecordLifecycleHandler(this.f35278d);
        this.f35279e = recordLifecycleHandler;
        recordLifecycleHandler.setRecordListener(this.f35280f);
    }

    /* renamed from: a */
    private void m24972a(Map<String, AudioRecordContext> map) throws IllegalArgumentException, RecordContextNotFoundException {
        Iterator<S> it = ServiceLoader.load(AudioRecordContext.class).iterator();
        while (it.hasNext()) {
            AudioRecordContext audioRecordContext = (AudioRecordContext) it.next();
            String alias = ((ServiceProvider) audioRecordContext.getClass().getAnnotation(ServiceProvider.class)).alias();
            if (!TextUtils.isEmpty(alias)) {
                map.put(alias, audioRecordContext);
                LogUtil.log("Succeed in loading AudioRecordContext with alias named: ", alias, " ~ ", audioRecordContext.getClass().getName());
            } else {
                throw new IllegalArgumentException("The annotation alias of the ServiceProvider(" + audioRecordContext.getClass().getName() + ") shouldn't be empty.");
            }
        }
        if (map.isEmpty()) {
            throw new RecordContextNotFoundException("No AudioRecordContext was found.");
        }
    }

    public synchronized void startRecord() throws IlegalBusinessAliasException {
        m24971a(this.f35276b);
        LogUtil.log(InternalJSMethod.START_RECORD);
        this.f35280f.onTriggerStart();
        this.f35279e.startRecord();
    }

    public synchronized void stopRecord() throws IlegalBusinessAliasException {
        m24971a(this.f35276b);
        LogUtil.log(InternalJSMethod.STOP_RECORD);
        this.f35279e.stopRecord();
    }

    public synchronized void resumeRecord() throws IlegalBusinessAliasException {
        m24971a(this.f35276b);
        LogUtil.log("resumeRecord");
        this.f35280f.onTriggerResume();
        this.f35279e.resumeRecord();
    }

    public synchronized void pauseRecord() throws IlegalBusinessAliasException {
        m24971a(this.f35276b);
        LogUtil.log("pauseRecord");
        this.f35279e.pauseRecord();
    }

    public boolean isRecording() throws IlegalBusinessAliasException {
        return this.f35279e.isRecording();
    }

    public synchronized void setRecordListener(AudioRecorder.RecordListener recordListener) throws IlegalBusinessAliasException {
        this.f35280f.addRecordListener(recordListener);
    }

    public synchronized void removeRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f35280f.removeRecordListener(recordListener);
    }

    public void addRecordActionListener(AudioRecordActionListener audioRecordActionListener) {
        this.f35280f.addActionListener(audioRecordActionListener);
    }

    public void removeRecordActionListener(AudioRecordActionListener audioRecordActionListener) {
        this.f35280f.removeActionListener(audioRecordActionListener);
    }

    public synchronized void setDurationChangedListener(AudioRecorder.DurationChangedListener durationChangedListener) throws IlegalBusinessAliasException {
        m24971a(this.f35276b);
        this.f35279e.mo90968a(durationChangedListener);
    }

    public synchronized void setOnErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f35279e.setOnErrorListener(onErrorListener);
    }

    public synchronized void setUploadListener(AudioUploader.UploadListener uploadListener) throws IlegalBusinessAliasException {
        m24971a(this.f35276b);
        this.f35279e.mo90967a(uploadListener);
    }

    public synchronized void resumeUploadTasks() throws IlegalBusinessAliasException {
        m24971a(this.f35276b);
        LogUtil.log("resumeUploadTasks START");
        this.f35279e.mo90973b();
    }

    public synchronized void updateSpeechDetectParams(JSONObject jSONObject) {
        this.f35279e.mo90972a(jSONObject);
    }

    public synchronized void sliceAudioFile() {
        this.f35279e.mo90966a();
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        this.f35279e.mo90969a(fileSliceListener);
    }

    public synchronized void setBusinessAlias(String str) throws IlegalBusinessAliasException {
        m24971a(str);
        if (!TextUtils.equals(this.f35276b, str)) {
            AudioRecordContext audioRecordContext = this.f35278d.get(str);
            if (audioRecordContext != null) {
                LogUtil.init(audioRecordContext.getAppContext(), audioRecordContext.debugable());
                LogUtil.log("setBusinessAlias: change from " + this.f35276b + " to " + str);
                this.f35276b = str;
                this.f35277c = audioRecordContext;
                this.f35279e.mo90971a(str, audioRecordContext);
            } else {
                throw new RecordContextNotFoundException("No AudioRecordContext was found with the alias named: " + str);
            }
        }
    }

    public String getBusinessAlias() {
        return this.f35276b;
    }

    public String getUserPhone() {
        AudioRecordContext audioRecordContext = this.f35277c;
        if (audioRecordContext != null) {
            return audioRecordContext.getUserPhone();
        }
        return null;
    }

    public static boolean isRecordProcess(Context context) {
        return ProcessUtil.isTargetProcess(context, context.getPackageName() + MultiProcessRecordService.PROCESS_NAME);
    }

    public void clearTTSData() {
        try {
            m24971a(this.f35276b);
            this.f35279e.mo90975c();
        } catch (IlegalBusinessAliasException unused) {
        }
    }

    /* renamed from: a */
    private void m24971a(String str) throws IlegalBusinessAliasException {
        if (TextUtils.isEmpty(str)) {
            throw new IlegalBusinessAliasException("BusinessAlias shouldn't be empty.");
        }
    }

    public void register16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f35279e.mo90970a(pcm16kConsumer);
    }

    public void unregister16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f35279e.mo90974b(pcm16kConsumer);
    }
}
