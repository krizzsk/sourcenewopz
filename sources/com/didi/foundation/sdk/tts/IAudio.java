package com.didi.foundation.sdk.tts;

import android.content.Context;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface IAudio {
    void init(IPlayListener iPlayListener, Context context);

    boolean isPlaying();

    void pause();

    void play(PlayData playData);

    void release();

    void resumeSpeaking();

    void stop();
}
