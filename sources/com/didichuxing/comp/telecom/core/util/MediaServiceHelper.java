package com.didichuxing.comp.telecom.core.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J.\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0012\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/MediaServiceHelper;", "", "()V", "TAG", "", "mCurTask", "Lcom/didichuxing/comp/telecom/core/util/MediaServiceHelper$RingtonePlayTask;", "mRingRes", "", "callEndRingtone", "callback", "Landroid/media/MediaPlayer$OnCompletionListener;", "callIncomeRingtone", "destroy", "", "getCurIncomeRingtone", "innerNewTask", "resId", "streamType", "needLoop", "", "releasePlayTask", "task", "stopPlayingAudio", "tipRingtone", "waitRingtone", "RingtonePlayTask", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: MediaServiceHelper.kt */
public final class MediaServiceHelper {

    /* renamed from: a */
    private String f46408a = "MediaServiceHelper";

    /* renamed from: b */
    private RingtonePlayTask f46409b;

    /* renamed from: c */
    private final int f46410c = R.raw.call_ringtone;

    public static /* synthetic */ RingtonePlayTask callIncomeRingtone$default(MediaServiceHelper mediaServiceHelper, MediaPlayer.OnCompletionListener onCompletionListener, int i, Object obj) {
        if ((i & 1) != 0) {
            onCompletionListener = null;
        }
        return mediaServiceHelper.callIncomeRingtone(onCompletionListener);
    }

    public final RingtonePlayTask callIncomeRingtone(MediaPlayer.OnCompletionListener onCompletionListener) {
        CallLogUtil.logI(this.f46408a, "callIncomeRingtone");
        return m33288a(this.f46410c, 2, true, onCompletionListener);
    }

    public final RingtonePlayTask getCurIncomeRingtone() {
        RingtonePlayTask ringtonePlayTask = this.f46409b;
        if (ringtonePlayTask == null || ringtonePlayTask.getResId() != this.f46410c) {
            return null;
        }
        return ringtonePlayTask;
    }

    public static /* synthetic */ RingtonePlayTask waitRingtone$default(MediaServiceHelper mediaServiceHelper, MediaPlayer.OnCompletionListener onCompletionListener, int i, Object obj) {
        if ((i & 1) != 0) {
            onCompletionListener = null;
        }
        return mediaServiceHelper.waitRingtone(onCompletionListener);
    }

    public final RingtonePlayTask waitRingtone(MediaPlayer.OnCompletionListener onCompletionListener) {
        CallLogUtil.logI(this.f46408a, "waitRingtone");
        return m33288a(R.raw.call_wait, 0, true, onCompletionListener);
    }

    public static /* synthetic */ RingtonePlayTask tipRingtone$default(MediaServiceHelper mediaServiceHelper, MediaPlayer.OnCompletionListener onCompletionListener, int i, Object obj) {
        if ((i & 1) != 0) {
            onCompletionListener = null;
        }
        return mediaServiceHelper.tipRingtone(onCompletionListener);
    }

    public final RingtonePlayTask tipRingtone(MediaPlayer.OnCompletionListener onCompletionListener) {
        CallLogUtil.logI(this.f46408a, "tipRingtone");
        return m33288a(R.raw.short_ringtone, 0, false, onCompletionListener);
    }

    public static /* synthetic */ RingtonePlayTask callEndRingtone$default(MediaServiceHelper mediaServiceHelper, MediaPlayer.OnCompletionListener onCompletionListener, int i, Object obj) {
        if ((i & 1) != 0) {
            onCompletionListener = null;
        }
        return mediaServiceHelper.callEndRingtone(onCompletionListener);
    }

    public final RingtonePlayTask callEndRingtone(MediaPlayer.OnCompletionListener onCompletionListener) {
        CallLogUtil.logI(this.f46408a, "callEndRingtone");
        return m33288a(R.raw.hangup, 0, false, onCompletionListener);
    }

    /* renamed from: a */
    static /* synthetic */ RingtonePlayTask m33289a(MediaServiceHelper mediaServiceHelper, int i, int i2, boolean z, MediaPlayer.OnCompletionListener onCompletionListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            onCompletionListener = null;
        }
        return mediaServiceHelper.m33288a(i, i2, z, onCompletionListener);
    }

    /* renamed from: a */
    private final RingtonePlayTask m33288a(int i, int i2, boolean z, MediaPlayer.OnCompletionListener onCompletionListener) {
        m33290a(this.f46409b);
        RingtonePlayTask ringtonePlayTask = new RingtonePlayTask(i, i2, z, onCompletionListener);
        this.f46409b = ringtonePlayTask;
        return ringtonePlayTask;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/MediaServiceHelper$RingtonePlayTask;", "", "resId", "", "streamType", "needLoop", "", "callback", "Landroid/media/MediaPlayer$OnCompletionListener;", "(IIZLandroid/media/MediaPlayer$OnCompletionListener;)V", "TAG", "", "mPlayer", "Landroid/media/MediaPlayer;", "getResId", "()I", "pause", "", "release", "start", "stop", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: MediaServiceHelper.kt */
    public static final class RingtonePlayTask {
        /* access modifiers changed from: private */
        public String TAG;
        private MediaPlayer mPlayer;
        private final int resId;

        public RingtonePlayTask(int i, int i2, boolean z, MediaPlayer.OnCompletionListener onCompletionListener) {
            this.resId = i;
            this.TAG = "RingtonePlayTask";
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            Context appContext = instance.getAppContext();
            if (appContext != null) {
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(i2).build());
                    mediaPlayer.setLooping(z);
                    mediaPlayer.setOnPreparedListener(new C15233x695e14af(this, i2, z, onCompletionListener));
                    if (onCompletionListener != null) {
                        mediaPlayer.setOnCompletionListener(onCompletionListener);
                    }
                    AssetFileDescriptor openRawResourceFd = appContext.getResources().openRawResourceFd(this.resId);
                    Intrinsics.checkExpressionValueIsNotNull(openRawResourceFd, "it.resources.openRawResourceFd(resId)");
                    mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                    openRawResourceFd.close();
                    mediaPlayer.prepare();
                    this.mPlayer = mediaPlayer;
                } catch (Throwable unused) {
                }
            }
        }

        public final int getResId() {
            return this.resId;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RingtonePlayTask(int i, int i2, boolean z, MediaPlayer.OnCompletionListener onCompletionListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? null : onCompletionListener);
        }

        public final void start() {
            try {
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
            } catch (Exception unused) {
            }
        }

        public final void pause() {
            try {
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            } catch (Exception unused) {
            }
        }

        public final void stop() {
            try {
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            } catch (Exception unused) {
            }
        }

        public final void release() {
            try {
                MediaPlayer mediaPlayer = this.mPlayer;
                this.mPlayer = null;
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private final void m33290a(RingtonePlayTask ringtonePlayTask) {
        if (ringtonePlayTask != null) {
            ringtonePlayTask.stop();
            ringtonePlayTask.release();
        }
    }

    public final void stopPlayingAudio() {
        m33290a(this.f46409b);
    }

    public final void destroy() {
        m33290a(this.f46409b);
        this.f46409b = null;
    }
}
