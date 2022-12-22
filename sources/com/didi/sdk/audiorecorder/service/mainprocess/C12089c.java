package com.didi.sdk.audiorecorder.service.mainprocess;

import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.IRecordServiceConnection;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.c */
/* compiled from: MainProcessRecordServiceConnection */
class C12089c implements IRecordServiceConnection {

    /* renamed from: a */
    private C12088b f35449a = new C12088b();

    C12089c() {
    }

    public void updateRecordContext(String str, AudioRecordContext audioRecordContext) {
        this.f35449a.mo91160a(str, audioRecordContext);
    }

    public void startRecord() {
        this.f35449a.startRecord();
    }

    public void stopRecord() {
        this.f35449a.stopRecord();
    }

    public void resumeRecord() {
        this.f35449a.resumeRecord();
    }

    public void pauseRecord() {
        this.f35449a.pauseRecord();
    }

    public boolean isRecording() {
        return this.f35449a.isRecording();
    }

    public void sliceAudioFile() {
        this.f35449a.sliceAudioFile();
    }

    public void updateSpeechDetectParams(String str) {
        this.f35449a.updateSpeechDetectParams(str);
    }

    public void clearTtsDataCache() {
        this.f35449a.clearTtsDataCache();
    }

    public void setRecordStateListener(AudioRecorder.RecordListener recordListener) {
        this.f35449a.setRecordStateListener(recordListener);
    }

    public void setRecordErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f35449a.setRecordErrorListener(onErrorListener);
    }

    public void setRecordDurationListener(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f35449a.setRecordDurationListener(durationChangedListener);
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        this.f35449a.setFileSliceListener(fileSliceListener);
    }

    public void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
        this.f35449a.setSpeechDetectListener(wordsDetectListener);
    }

    public void set16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f35449a.set16kPcmConsumer(pcm16kConsumer);
    }
}
