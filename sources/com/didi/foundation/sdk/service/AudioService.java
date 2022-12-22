package com.didi.foundation.sdk.service;

import android.content.Context;
import com.didi.foundation.sdk.tts.PlayData;
import com.didichuxing.foundation.spi.ServiceLoader;

public final class AudioService implements AudioServiceProvider {

    /* renamed from: a */
    private final AudioServiceProvider f21297a;

    private AudioService() {
        this.f21297a = (AudioServiceProvider) ServiceLoader.load(AudioServiceProvider.class).get();
    }

    public static final AudioService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void init(Context context) {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.init(context);
        }
    }

    public final boolean isInit() {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        return audioServiceProvider != null && audioServiceProvider.isInit();
    }

    public final void stop() {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.stop();
        }
    }

    public final void pause() {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.pause();
        }
    }

    public final void resume() {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.resume();
        }
    }

    public final void release() {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.release();
        }
    }

    public final boolean isPlaying() {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        return audioServiceProvider != null && audioServiceProvider.isPlaying();
    }

    public final void play(PlayData playData) {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.play(playData);
        }
    }

    public final void playTts(String str) {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.playTts(str);
        }
    }

    public final void playAudioResource(int i) {
        AudioServiceProvider audioServiceProvider = this.f21297a;
        if (audioServiceProvider != null) {
            audioServiceProvider.playAudioResource(i);
        }
    }

    private static final class Singleton {
        static final AudioService INSTANCE = new AudioService();

        private Singleton() {
        }
    }
}
