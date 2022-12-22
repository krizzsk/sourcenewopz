package com.didi.foundation.sdk.tts;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;

public class AudioTaskDispatcher implements IPlayListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f21355a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TtsDeque f21356b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PlayData f21357c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbstractAudio f21358d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f21359e;

    /* renamed from: f */
    private Thread f21360f;

    private static class Holder {
        /* access modifiers changed from: private */
        public static final AudioTaskDispatcher INSTANCE = new AudioTaskDispatcher();

        private Holder() {
        }
    }

    private AudioTaskDispatcher() {
        this.f21355a = LogService.getLogger(AudioTaskDispatcher.class.getSimpleName());
        this.f21359e = true;
    }

    public static AudioTaskDispatcher getInstance() {
        return Holder.INSTANCE;
    }

    public void onCompleted() {
        this.f21358d.onCompleted();
    }

    public void initialize(final AudioManager audioManager) {
        this.f21358d = audioManager;
        this.f21356b = new TtsDeque();
        this.f21359e = true;
        this.f21355a.debug("AudioTaskDispatcher initialize: ", new Object[0]);
        C84021 r0 = new Thread() {
            public void run() {
                SystemUtils.setProcessThreadPriority(-16);
                while (AudioTaskDispatcher.this.f21359e) {
                    try {
                        AudioTaskDispatcher.this.f21355a.debug("AudioTaskDispatcher is running ", new Object[0]);
                        PlayData unused = AudioTaskDispatcher.this.f21357c = AudioTaskDispatcher.this.f21356b.get();
                        AudioTaskDispatcher.this.f21358d.play(AudioTaskDispatcher.this.f21357c);
                        synchronized (audioManager.mMutex) {
                            Logger b = AudioTaskDispatcher.this.f21355a;
                            b.debug("AudioTaskDispatcher is wait  " + AudioTaskDispatcher.this.f21357c.getTts(), new Object[0]);
                            audioManager.mMutex.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        this.f21360f = r0;
        r0.start();
    }

    public void addTask(PlayData playData) {
        if (playData != null) {
            if (this.f21357c != null && playData.f21373a.ordinal() > this.f21357c.f21373a.ordinal()) {
                this.f21358d.stop();
            }
            Logger logger = this.f21355a;
            logger.debug("AudioTaskDispatcher data: " + playData.getTts() + playData.f21373a, new Object[0]);
            this.f21356b.add(playData);
        }
    }

    public void release() {
        this.f21359e = false;
        this.f21356b.clear();
        this.f21360f.interrupt();
    }
}
