package com.didi.foundation.sdk.tts;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;

public final class IAudioService implements IAudio {

    /* renamed from: a */
    private final IAudio f21366a;

    private IAudioService() {
        this.f21366a = (IAudio) ServiceLoader.load(IAudio.class).get();
    }

    public static final IAudioService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void init(IPlayListener iPlayListener, Context context) {
        IAudio iAudio = this.f21366a;
        if (iAudio != null) {
            iAudio.init(iPlayListener, context);
        }
    }

    public final void play(PlayData playData) {
        IAudio iAudio = this.f21366a;
        if (iAudio != null) {
            iAudio.play(playData);
        }
    }

    public final void stop() {
        IAudio iAudio = this.f21366a;
        if (iAudio != null) {
            iAudio.stop();
        }
    }

    public final void release() {
        IAudio iAudio = this.f21366a;
        if (iAudio != null) {
            iAudio.release();
        }
    }

    public final void pause() {
        IAudio iAudio = this.f21366a;
        if (iAudio != null) {
            iAudio.pause();
        }
    }

    public final void resumeSpeaking() {
        IAudio iAudio = this.f21366a;
        if (iAudio != null) {
            iAudio.resumeSpeaking();
        }
    }

    public final boolean isPlaying() {
        IAudio iAudio = this.f21366a;
        return iAudio != null && iAudio.isPlaying();
    }

    private static final class Singleton {
        static final IAudioService INSTANCE = new IAudioService();

        private Singleton() {
        }
    }
}
