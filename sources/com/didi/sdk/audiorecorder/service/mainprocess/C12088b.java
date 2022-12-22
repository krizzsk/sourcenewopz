package com.didi.sdk.audiorecorder.service.mainprocess;

import android.content.Context;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.IRecordService;
import com.didi.sdk.audiorecorder.speechdetect.TTServerWrapper;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.b */
/* compiled from: MainProcessRecordService */
class C12088b implements AudioRecorder.FileSlicer, IRecordService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AudioRecorderImpl f35446a;

    /* renamed from: b */
    private C12090d f35447b;

    /* renamed from: c */
    private TTServerWrapper f35448c = new TTServerWrapper();

    C12088b() {
    }

    /* renamed from: a */
    public void mo91160a(String str, AudioRecordContext audioRecordContext) {
        LogUtil.updateUserPhone(audioRecordContext.getUserPhone());
        Context appContext = audioRecordContext.getAppContext();
        if (this.f35446a == null) {
            AudioRecorderImpl audioRecorderImpl = new AudioRecorderImpl(appContext, appContext.getFilesDir().getAbsolutePath() + IRecordService.DEFAULT_AUDIO_CACHE_FOLDER);
            this.f35446a = audioRecorderImpl;
            C12090d dVar = new C12090d(audioRecorderImpl, this);
            this.f35447b = dVar;
            audioRecorderImpl.setRecordListener(dVar);
            this.f35446a.setDurationChangedListener(this.f35447b);
        }
        this.f35447b.mo91162a(audioRecordContext.getAudioSegmentDuration());
        this.f35448c.getTTServerName(new MainProcessRecordService$1(this, audioRecordContext, str));
    }

    public void startRecord() {
        if (this.f35446a != null) {
            this.f35447b.mo91166b(1);
            this.f35446a.startRecord();
        }
    }

    public void stopRecord() {
        if (this.f35446a != null) {
            this.f35447b.mo91166b(2);
            this.f35446a.stopRecord();
        }
    }

    public void resumeRecord() {
        if (this.f35446a != null) {
            this.f35447b.mo91166b(3);
            this.f35446a.resumeRecord();
        }
    }

    public void pauseRecord() {
        if (this.f35446a != null) {
            this.f35447b.mo91166b(4);
            this.f35446a.pauseRecord();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f35447b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRecording() {
        /*
            r1 = this;
            com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl r0 = r1.f35446a
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isRecording()
            if (r0 == 0) goto L_0x0016
            com.didi.sdk.audiorecorder.service.mainprocess.d r0 = r1.f35447b
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.mo91167c()
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.mainprocess.C12088b.isRecording():boolean");
    }

    public void sliceAudioFile() {
        C12090d dVar = this.f35447b;
        if (dVar != null) {
            dVar.mo91165b();
        }
        AudioRecorderImpl audioRecorderImpl = this.f35446a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.sliceAudioFile();
        }
    }

    public void updateSpeechDetectParams(String str) {
        AudioRecorderImpl audioRecorderImpl = this.f35446a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.updateSpeechDetectParams(str);
        }
    }

    public void clearTtsDataCache() {
        AudioRecorderImpl audioRecorderImpl = this.f35446a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.clearTtsDataCache();
        }
    }

    public void setRecordStateListener(AudioRecorder.RecordListener recordListener) {
        C12090d dVar = this.f35447b;
        if (dVar != null) {
            dVar.mo91164a(recordListener);
        }
    }

    public void setRecordErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        AudioRecorderImpl audioRecorderImpl = this.f35446a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setOnErrorListener(onErrorListener);
        }
    }

    public void setRecordDurationListener(AudioRecorder.DurationChangedListener durationChangedListener) {
        C12090d dVar = this.f35447b;
        if (dVar != null) {
            dVar.mo91163a(durationChangedListener);
        }
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        AudioRecorderImpl audioRecorderImpl = this.f35446a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setFileSliceListener(fileSliceListener);
        }
    }

    public void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
        AudioRecorderImpl audioRecorderImpl = this.f35446a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setSpeechDetectListener(wordsDetectListener);
        }
    }

    public void set16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        AudioRecorderImpl audioRecorderImpl = this.f35446a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setPcm16kConsumer(pcm16kConsumer);
        }
    }
}
