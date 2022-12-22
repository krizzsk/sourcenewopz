package com.didi.sdk.audiorecorder.helper.recorder;

import com.didi.sdk.audiorecorder.helper.recorder.Supporter;

public interface AudioRecorder {

    public interface DurationChangedListener {
        void onTimeTick(int i);
    }

    public interface FileSliceListener {
        void onAudioFileCreated(String str);

        void onAudioFileSliced(String str);
    }

    public interface FileSlicer {
        void sliceAudioFile();
    }

    public interface Inner {
        void setDurationChangedListener(DurationChangedListener durationChangedListener);

        void setFileSliceListener(FileSliceListener fileSliceListener);

        void setPcm16kConsumer(Supporter.Pcm16kConsumer pcm16kConsumer);

        void setSpeechDetectListener(WordsDetectListener wordsDetectListener);
    }

    public interface OnErrorListener {
        void onError(int i);
    }

    public interface RecordListener {
        void onPause();

        void onResume();

        void onStart();

        void onStop();
    }

    public interface RecordListener2 extends RecordListener {
        void onGetPcmStream(byte[] bArr, int i, int i2);
    }

    public interface WordsDetectListener {
        void onWordDetected(String str);
    }

    boolean isRecording();

    void pauseRecord();

    void resumeRecord();

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setRecordListener(RecordListener recordListener);

    void startRecord();

    void stopRecord();
}
