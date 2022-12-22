package com.didi.foundation.sdk.tts;

public abstract class AbstractAudio implements IAudio, IPlayListener {
    public final Object mMutex = new Object();
}
