package com.didi.sdk.audiorecorder.service;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IRecordService {
    public static final String DEFAULT_AUDIO_CACHE_FOLDER = "/audio/";

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecordState {
        public static final int PAUSE = 4;
        public static final int PAUSED = 8;
        public static final int RESUME = 3;
        public static final int RESUMED = 7;
        public static final int START = 1;
        public static final int STARTED = 5;
        public static final int STOP = 2;
        public static final int STOPED = 6;
    }

    void clearTtsDataCache();

    boolean isRecording();

    void pauseRecord();

    void resumeRecord();

    void set16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer);

    void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener);

    void setRecordDurationListener(AudioRecorder.DurationChangedListener durationChangedListener);

    void setRecordErrorListener(AudioRecorder.OnErrorListener onErrorListener);

    void setRecordStateListener(AudioRecorder.RecordListener recordListener);

    void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener);

    void sliceAudioFile();

    void startRecord();

    void stopRecord();

    void updateSpeechDetectParams(String str);
}
