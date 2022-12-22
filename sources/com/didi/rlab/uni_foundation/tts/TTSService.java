package com.didi.rlab.uni_foundation.tts;

public interface TTSService {

    public interface Result<T> {
        void success(T t);
    }

    void playFile(String str, long j, String str2, long j2, Result<Long> result);

    void playText(String str, long j, long j2, Result<Long> result);

    void playVibrate();

    void stopPlayingAudio();
}
