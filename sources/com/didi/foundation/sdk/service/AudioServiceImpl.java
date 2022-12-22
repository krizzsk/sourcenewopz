package com.didi.foundation.sdk.service;

import android.content.Context;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.tts.AudioManager;
import com.didi.foundation.sdk.tts.AudioTaskDispatcher;
import com.didi.foundation.sdk.tts.IAudio;
import com.didi.foundation.sdk.tts.PlayData;
import com.didi.sdk.logging.Logger;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Locale;

@ServiceProvider({AudioServiceProvider.class})
public class AudioServiceImpl implements AudioServiceProvider, LocaleServiceProvider.OnLocaleChangedListener {

    /* renamed from: a */
    private Logger f21298a = LogService.getLogger("AudioServiceImpl");

    /* renamed from: b */
    private IAudio f21299b;

    /* renamed from: c */
    private AudioTaskDispatcher f21300c = AudioTaskDispatcher.getInstance();

    /* renamed from: d */
    private boolean f21301d = false;

    /* renamed from: e */
    private Context f21302e;

    public void init(Context context) {
        AudioManager audioManager = new AudioManager();
        this.f21299b = audioManager;
        audioManager.init(this.f21300c, context);
        this.f21300c.initialize((AudioManager) this.f21299b);
        this.f21302e = context;
        this.f21301d = true;
        LocaleService.getInstance().removeOnLocaleChangedListener(this);
        LocaleService.getInstance().addOnLocaleChangedListener(this);
    }

    public boolean isInit() {
        return this.f21301d;
    }

    public void onLocaleChanged(Locale locale, Locale locale2) {
        this.f21299b.release();
        this.f21300c.release();
        this.f21300c.initialize((AudioManager) this.f21299b);
        this.f21299b.init(this.f21300c, this.f21302e);
        this.f21301d = true;
    }

    public void stop() {
        if (this.f21301d) {
            this.f21299b.stop();
        }
    }

    public void pause() {
        if (this.f21301d) {
            this.f21299b.pause();
        }
    }

    public void resume() {
        if (this.f21301d) {
            this.f21299b.resumeSpeaking();
        }
    }

    public void release() {
        this.f21299b.release();
        this.f21300c.release();
        this.f21301d = false;
    }

    public boolean isPlaying() {
        return this.f21301d && this.f21299b.isPlaying();
    }

    public void play(PlayData playData) {
        if (playData != null) {
            if (!this.f21301d) {
                this.f21298a.debug("audio not init!", new Object[0]);
            } else {
                this.f21300c.addTask(playData);
            }
        }
    }

    public void playTts(String str) {
        play(new PlayData.Builder().tts(str).build());
    }

    public void playAudioResource(int i) {
        play(new PlayData.Builder().rawId(i).build());
    }
}
