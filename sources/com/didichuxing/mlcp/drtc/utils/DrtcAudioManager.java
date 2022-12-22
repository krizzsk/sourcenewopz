package com.didichuxing.mlcp.drtc.utils;

import android.content.Context;
import android.media.AudioManager;
import com.didi.sdk.apm.SystemUtils;
import org.webrtc.ThreadUtils;

public class DrtcAudioManager {

    /* renamed from: a */
    private AudioManager f48441a;

    /* renamed from: b */
    private AudioManagerState f48442b;

    /* renamed from: c */
    private int f48443c = 2;

    /* renamed from: d */
    private boolean f48444d;

    /* renamed from: e */
    private boolean f48445e;

    public enum AudioDevice {
        SPEAKER_PHONE,
        WIRED_HEADSET,
        EARPIECE,
        BLUETOOTH,
        NONE
    }

    public enum AudioManagerState {
        UNINITIALIZED,
        PREINITIALIZED,
        RUNNING
    }

    /* renamed from: com.didichuxing.mlcp.drtc.utils.DrtcAudioManager$a */
    public interface C15915a {
    }

    private DrtcAudioManager(Context context) {
        SystemUtils.log(3, "DrtcAudioManager", "ctor", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 12);
        ThreadUtils.checkIsOnMainThread();
        this.f48441a = (AudioManager) context.getSystemService("audio");
        this.f48442b = AudioManagerState.UNINITIALIZED;
    }

    /* renamed from: a */
    public static DrtcAudioManager m34713a(Context context) {
        return new DrtcAudioManager(context);
    }

    /* renamed from: a */
    public void mo119045a(C15915a aVar) {
        SystemUtils.log(3, "DrtcAudioManager", "start", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 2);
        ThreadUtils.checkIsOnMainThread();
        if (this.f48442b == AudioManagerState.RUNNING) {
            SystemUtils.log(6, "DrtcAudioManager", "AudioManager is already active", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 5);
            return;
        }
        SystemUtils.log(3, "DrtcAudioManager", "AudioManager starts...", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 9);
        this.f48442b = AudioManagerState.RUNNING;
        this.f48443c = this.f48441a.getMode();
        this.f48444d = this.f48441a.isSpeakerphoneOn();
        this.f48445e = this.f48441a.isMicrophoneMute();
        this.f48441a.getStreamVolume(0);
        SystemUtils.log(3, "DrtcAudioManager", "Current Audio Setting: audioMode:[" + this.f48443c + "] Speaker:[" + this.f48444d + " ] Mute:" + this.f48445e, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 19);
        this.f48441a.setMode(3);
    }

    /* renamed from: a */
    public void mo119044a() {
        SystemUtils.log(3, "DrtcAudioManager", "Stop,reset audio status", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 24);
        if (this.f48442b != AudioManagerState.RUNNING) {
            SystemUtils.log(6, "DrtcAudioManager", "Trying to stop AudioManager in incorrect state: " + this.f48442b, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 27);
            return;
        }
        this.f48442b = AudioManagerState.UNINITIALIZED;
        mo119046a(this.f48444d);
        this.f48441a.setMode(this.f48443c);
        SystemUtils.log(3, "DrtcAudioManager", "AudioManager stopped", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 38);
    }

    /* renamed from: a */
    public void mo119046a(boolean z) {
        if (this.f48441a.isSpeakerphoneOn() != z) {
            this.f48441a.setSpeakerphoneOn(z);
        }
    }
}
