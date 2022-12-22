package com.didi.foundation.sdk.tts;

import android.content.Context;

public class AudioManager extends AbstractAudio {

    /* renamed from: a */
    private final IAudio f21351a = IAudioService.getInstance();

    /* renamed from: b */
    private final IAudio f21352b = new MediaAudio();

    /* renamed from: c */
    private PlayData f21353c;

    /* renamed from: d */
    private IAudio f21354d;

    public void init(IPlayListener iPlayListener, Context context) {
        this.f21351a.init(iPlayListener, context);
        this.f21352b.init(iPlayListener, context);
    }

    public void play(PlayData playData) {
        this.f21353c = playData;
        IAudio iAudio = playData.f21374b ? this.f21351a : this.f21352b;
        this.f21354d = iAudio;
        iAudio.play(playData);
    }

    public void stop() {
        IAudio iAudio = this.f21354d;
        if (iAudio != null) {
            iAudio.stop();
            this.f21353c = null;
            synchronized (this.mMutex) {
                this.mMutex.notifyAll();
            }
        }
    }

    public void release() {
        this.f21351a.release();
        this.f21352b.release();
    }

    public void pause() {
        this.f21354d.pause();
    }

    public void resumeSpeaking() {
        this.f21354d.resumeSpeaking();
    }

    public boolean isPlaying() {
        IAudio iAudio = this.f21354d;
        return iAudio != null && iAudio.isPlaying();
    }

    public void onCompleted() {
        PlayData playData = this.f21353c;
        if (playData == null || playData.getNext() == null) {
            synchronized (this.mMutex) {
                this.mMutex.notifyAll();
            }
            return;
        }
        PlayData next = this.f21353c.getNext();
        this.f21353c = next;
        play(next);
    }
}
