package com.didi.foundation.sdk.service;

import android.content.Context;
import com.didi.foundation.sdk.tts.PlayData;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface AudioServiceProvider {
    void init(Context context);

    boolean isInit();

    boolean isPlaying();

    void pause();

    void play(PlayData playData);

    void playAudioResource(int i);

    void playTts(String str);

    void release();

    void resume();

    void stop();
}
