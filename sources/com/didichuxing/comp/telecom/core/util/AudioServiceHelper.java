package com.didichuxing.comp.telecom.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010!\u001a\u00020\u001aH\u0002J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rJ\u000e\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/AudioServiceHelper;", "", "()V", "TAG", "", "value", "Lcom/didichuxing/comp/telecom/core/util/AudioServiceListener;", "changeListener", "getChangeListener", "()Lcom/didichuxing/comp/telecom/core/util/AudioServiceListener;", "setChangeListener", "(Lcom/didichuxing/comp/telecom/core/util/AudioServiceListener;)V", "isBluetoothLinked", "", "isHeadsetLinked", "isMicOn", "isSpeakerOn", "mAudioManager", "Landroid/media/AudioManager;", "mHandler", "Landroid/os/Handler;", "mReceiver", "Landroid/content/BroadcastReceiver;", "mStopCallRunnable", "Ljava/lang/Runnable;", "cancelStopCallAction", "", "checkAndConfigOutput", "destroy", "emitStopCallAction", "getSelectOutput", "", "isMickOn", "registerAudioFocusListener", "setMicOn", "newState", "setSpeakerOn", "Companion", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: AudioServiceHelper.kt */
public final class AudioServiceHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATE_BLUETOOTH = 1;
    public static final int STATE_HEADSET = 2;
    public static final int STATE_NORMAL = 4;
    public static final int STATE_SPEAKER = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f46398a = "AudioServiceHelper";

    /* renamed from: b */
    private AudioServiceListener f46399b;

    /* renamed from: c */
    private Handler f46400c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private AudioManager f46401d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f46402e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f46403f;

    /* renamed from: g */
    private boolean f46404g;

    /* renamed from: h */
    private BroadcastReceiver f46405h = new AudioServiceHelper$mReceiver$1(this);

    /* renamed from: i */
    private boolean f46406i;

    /* renamed from: j */
    private Runnable f46407j;

    public AudioServiceHelper() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        Object obj = null;
        Object systemService = appContext != null ? appContext.getSystemService("audio") : null;
        AudioManager audioManager = (AudioManager) (systemService instanceof AudioManager ? systemService : obj);
        this.f46401d = audioManager;
        if (audioManager != null) {
            audioManager.setMode(3);
            boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
            this.f46404g = isSpeakerphoneOn;
            if (isSpeakerphoneOn) {
                this.f46404g = false;
                audioManager.setSpeakerphoneOn(false);
            }
            this.f46402e = audioManager.isBluetoothScoOn();
            this.f46403f = audioManager.isWiredHeadsetOn();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            BroadcastReceiver broadcastReceiver = this.f46405h;
            if (broadcastReceiver != null) {
                try {
                    appContext.registerReceiver(broadcastReceiver, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            }
            String str = this.f46398a;
            CallLogUtil.logI(str, "AudioServiceHelper init - speakOn:" + this.f46404g + " bluetooth:" + this.f46402e + " headSet:" + this.f46403f + " normal:");
        }
        m33284a();
        m33285b();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/AudioServiceHelper$Companion;", "", "()V", "STATE_BLUETOOTH", "", "STATE_HEADSET", "STATE_NORMAL", "STATE_SPEAKER", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: AudioServiceHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final AudioServiceListener getChangeListener() {
        return this.f46399b;
    }

    public final void setChangeListener(AudioServiceListener audioServiceListener) {
        if (audioServiceListener != null) {
            audioServiceListener.onAudioDeviceChange(getSelectOutput());
        }
        this.f46399b = audioServiceListener;
    }

    public final int getSelectOutput() {
        if (this.f46402e) {
            return 1;
        }
        if (this.f46403f) {
            return 2;
        }
        return this.f46404g ? 3 : 4;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33284a() {
        AudioManager audioManager = this.f46401d;
        if (audioManager != null) {
            if (this.f46402e) {
                this.f46403f = false;
                this.f46404g = false;
                audioManager.setMode(3);
                audioManager.setSpeakerphoneOn(false);
                audioManager.setWiredHeadsetOn(false);
                audioManager.startBluetoothSco();
                audioManager.setBluetoothScoOn(true);
            } else if (this.f46403f) {
                this.f46402e = false;
                this.f46404g = false;
                audioManager.setMode(3);
                audioManager.setSpeakerphoneOn(false);
                audioManager.setWiredHeadsetOn(true);
                audioManager.setBluetoothScoOn(false);
            } else if (this.f46404g) {
                audioManager.setMode(3);
                audioManager.setWiredHeadsetOn(false);
                audioManager.stopBluetoothSco();
                audioManager.setBluetoothScoOn(false);
                audioManager.setSpeakerphoneOn(true);
            } else {
                audioManager.setMode(0);
                audioManager.setWiredHeadsetOn(false);
                audioManager.setBluetoothScoOn(false);
                audioManager.setSpeakerphoneOn(false);
            }
            String str = this.f46398a;
            CallLogUtil.logI(str, "checkOutputState - speakOn:" + this.f46404g + " bluetooth:" + this.f46402e + " headSet:" + this.f46403f + " normal:");
            AudioServiceListener audioServiceListener = this.f46399b;
            if (audioServiceListener != null) {
                audioServiceListener.onAudioDeviceChange(getSelectOutput());
            }
        }
    }

    public final boolean setSpeakerOn(boolean z) {
        if (this.f46402e || this.f46403f) {
            return false;
        }
        String str = this.f46398a;
        CallLogUtil.logI(str, "setSpeakerOn - newState:" + z);
        this.f46404g = z;
        m33284a();
        return true;
    }

    public final boolean isSpeakerOn() {
        return this.f46404g;
    }

    public final boolean isMickOn() {
        return this.f46406i;
    }

    public final boolean setMicOn(boolean z) {
        String str = this.f46398a;
        CallLogUtil.logI(str, "setMicOn - newState:" + z);
        this.f46406i = z;
        return z;
    }

    public final void destroy() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            try {
                appContext.unregisterReceiver(this.f46405h);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        }
        m33287d();
        this.f46400c = null;
        this.f46405h = null;
        this.f46401d = null;
    }

    /* renamed from: b */
    private final void m33285b() {
        AudioManager audioManager = this.f46401d;
        if (audioManager != null) {
            boolean z = false;
            int requestAudioFocus = audioManager.requestAudioFocus(new C15232x9978aa0a(this), 0, 1);
            String str = this.f46398a;
            StringBuilder sb = new StringBuilder();
            sb.append("registerAudioFocusListener - requestAudioFocus:");
            if (requestAudioFocus == 1) {
                z = true;
            }
            sb.append(z);
            CallLogUtil.logI(str, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m33286c() {
        m33287d();
        Runnable audioServiceHelper$emitStopCallAction$runnable$1 = new AudioServiceHelper$emitStopCallAction$runnable$1(this);
        Handler handler = this.f46400c;
        if (handler != null) {
            handler.postDelayed(audioServiceHelper$emitStopCallAction$runnable$1, 500);
        }
        this.f46407j = audioServiceHelper$emitStopCallAction$runnable$1;
    }

    /* renamed from: d */
    private final void m33287d() {
        Runnable runnable = this.f46407j;
        if (runnable != null) {
            this.f46407j = null;
            Handler handler = this.f46400c;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }
}
