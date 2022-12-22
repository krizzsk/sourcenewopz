package com.didi.sdk.audiorecorder.speechdetect;

import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;

public class SensitiveWordsUploadWrapper implements AudioRecorder.WordsDetectListener {
    public void onWordDetected(String str) {
    }

    public SensitiveWordsUploadWrapper(AudioRecordContext audioRecordContext) {
    }
}
