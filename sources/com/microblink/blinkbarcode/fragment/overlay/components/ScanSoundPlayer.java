package com.microblink.blinkbarcode.fragment.overlay.components;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;

/* compiled from: line */
public class ScanSoundPlayer {
    private int IlIllIlIIl = -1;
    private SoundPool llIIlIlIIl;

    public void clear() {
        SoundPool soundPool = this.llIIlIlIIl;
        if (soundPool != null) {
            try {
                soundPool.release();
            } catch (IllegalStateException unused) {
            }
            this.llIIlIlIIl = null;
            this.IlIllIlIIl = -1;
        }
    }

    public void initialize(Context context, int i) {
        if (i > 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.llIIlIlIIl = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).build();
            } else {
                this.llIIlIlIIl = new SoundPool(1, 3, 0);
            }
            this.IlIllIlIIl = this.llIIlIlIIl.load(context, i, 1);
        }
    }

    public void play() {
        int i;
        SoundPool soundPool = this.llIIlIlIIl;
        if (soundPool != null && (i = this.IlIllIlIIl) != -1) {
            soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }
}
