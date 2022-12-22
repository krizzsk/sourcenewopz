package com.didi.beatles.p099im.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.security.wireless.ISecurityConf;

/* renamed from: com.didi.beatles.im.common.IMBtsAudioPlayer */
public class IMBtsAudioPlayer {

    /* renamed from: a */
    private static final String f9133a = IMBtsAudioPlayer.class.getSimpleName();

    /* renamed from: b */
    private static MediaPlayer f9134b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static OnAudioPlayingListener f9135c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static AudioManager f9136d;

    /* renamed from: e */
    private static SensorManager f9137e;

    /* renamed from: f */
    private static Sensor f9138f;

    /* renamed from: g */
    private static SensorEventListener f9139g;

    /* renamed from: h */
    private static String f9140h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static int f9141i = -1;

    /* renamed from: j */
    private static boolean f9142j;

    /* renamed from: com.didi.beatles.im.common.IMBtsAudioPlayer$OnAudioPlayingListener */
    public interface OnAudioPlayingListener {
        void onCompletion();

        void onError(String str);

        void onStarted();

        void onStop();
    }

    /* renamed from: com.didi.beatles.im.common.IMBtsAudioPlayer$onVoiceChannelChangeListener */
    public interface onVoiceChannelChangeListener {
        void onVoiceChannelChanged(int i);
    }

    public static boolean isPlaying() {
        MediaPlayer mediaPlayer = f9134b;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public static void initSensor(final onVoiceChannelChangeListener onvoicechannelchangelistener) {
        if (IMCommonContextInfoHelper.getContext() != null) {
            f9136d = (AudioManager) IMCommonContextInfoHelper.getContext().getSystemService("audio");
            if (IMCommonContextInfoHelper.getAudioConfig().useSensor()) {
                SensorManager sensorManager = (SensorManager) IMCommonContextInfoHelper.getContext().getSystemService(ISecurityConf.KEY_SENSOR);
                f9137e = sensorManager;
                if (sensorManager != null) {
                    f9138f = sensorManager.getDefaultSensor(8);
                    f9139g = new SensorEventListener() {
                        public void onAccuracyChanged(Sensor sensor, int i) {
                        }

                        public void onSensorChanged(SensorEvent sensorEvent) {
                            if (IMBtsAudioPlayer.f9136d != null) {
                                if (sensorEvent.values[0] > 0.0f) {
                                    IMBtsAudioPlayer.f9136d.setSpeakerphoneOn(true);
                                    IMBtsAudioPlayer.f9136d.setMode(0);
                                    if (IMBtsAudioPlayer.f9141i != 0) {
                                        int unused = IMBtsAudioPlayer.f9141i = 0;
                                        onVoiceChannelChangeListener onvoicechannelchangelistener = onvoicechannelchangelistener;
                                        if (onvoicechannelchangelistener != null) {
                                            onvoicechannelchangelistener.onVoiceChannelChanged(IMBtsAudioPlayer.f9141i);
                                        }
                                    }
                                } else {
                                    IMBtsAudioPlayer.f9136d.setSpeakerphoneOn(false);
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        IMBtsAudioPlayer.f9136d.setMode(3);
                                    } else {
                                        IMBtsAudioPlayer.f9136d.setMode(2);
                                    }
                                    if (IMBtsAudioPlayer.f9141i != 1) {
                                        int unused2 = IMBtsAudioPlayer.f9141i = 1;
                                        onVoiceChannelChangeListener onvoicechannelchangelistener2 = onvoicechannelchangelistener;
                                        if (onvoicechannelchangelistener2 != null) {
                                            onvoicechannelchangelistener2.onVoiceChannelChanged(IMBtsAudioPlayer.f9141i);
                                        }
                                    }
                                }
                                try {
                                    IMBtsAudioPlayer.m6200b(IMBtsAudioPlayer.f9135c, IMCommonContextInfoHelper.getAudioConfig().getStreamType());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                }
            }
        }
    }

    public static void releaseSensor() {
        if (f9136d != null) {
            f9136d = null;
        }
        if (f9139g != null) {
            f9139g = null;
        }
        if (f9137e != null) {
            f9137e = null;
        }
        if (f9138f != null) {
            f9138f = null;
        }
    }

    public static void play(String str, OnAudioPlayingListener onAudioPlayingListener, boolean z) throws Exception {
        AudioManager audioManager = f9136d;
        if (audioManager == null) {
            IMLog.m6632e(f9133a, C4234I.m6591t(" [play] with null audio manager"));
            return;
        }
        f9140h = str;
        f9135c = onAudioPlayingListener;
        int i = f9141i;
        if (i == 0) {
            audioManager.setSpeakerphoneOn(true);
            f9136d.setMode(0);
        } else if (i == 1) {
            audioManager.setSpeakerphoneOn(false);
            if (Build.VERSION.SDK_INT >= 11) {
                f9136d.setMode(3);
            } else {
                f9136d.setMode(2);
            }
        } else {
            audioManager.setSpeakerphoneOn(true);
            f9136d.setMode(0);
        }
        if (z || f9138f == null || f9137e == null || !IMCommonContextInfoHelper.getAudioConfig().useSensor()) {
            m6200b(f9135c, IMCommonContextInfoHelper.getAudioConfig().getStreamType());
            return;
        }
        f9137e.registerListener(f9139g, f9138f, 3);
        f9142j = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m6200b(OnAudioPlayingListener onAudioPlayingListener, int i) throws Exception {
        MediaPlayer mediaPlayer = f9134b;
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            f9134b = mediaPlayer;
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            onAudioPlayingListener.onStop();
            mediaPlayer.reset();
        }
        AudioManager audioManager = f9136d;
        if (audioManager != null) {
            audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, i, 2);
        }
        mediaPlayer.setDataSource(f9140h);
        mediaPlayer.setAudioStreamType(i);
        m6197a(mediaPlayer, onAudioPlayingListener);
        mediaPlayer.prepareAsync();
    }

    /* renamed from: a */
    private static void m6197a(MediaPlayer mediaPlayer, final OnAudioPlayingListener onAudioPlayingListener) {
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                OnAudioPlayingListener onAudioPlayingListener = onAudioPlayingListener;
                if (onAudioPlayingListener != null) {
                    onAudioPlayingListener.onStarted();
                }
                mediaPlayer.start();
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                IMBtsAudioPlayer.release();
                OnAudioPlayingListener onAudioPlayingListener = onAudioPlayingListener;
                if (onAudioPlayingListener != null) {
                    onAudioPlayingListener.onCompletion();
                    if (IMBtsAudioPlayer.f9136d != null) {
                        IMBtsAudioPlayer.f9136d.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
                    }
                }
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                OnAudioPlayingListener onAudioPlayingListener = onAudioPlayingListener;
                onAudioPlayingListener.onError("[player#onError] errorType=" + i + " |errorCode=" + i2);
                return false;
            }
        });
    }

    public static void release() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = f9137e;
        if (!(sensorManager == null || (sensorEventListener = f9139g) == null || !f9142j)) {
            sensorManager.unregisterListener(sensorEventListener);
            f9142j = false;
        }
        MediaPlayer mediaPlayer = f9134b;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                f9134b.stop();
            }
            OnAudioPlayingListener onAudioPlayingListener = f9135c;
            if (onAudioPlayingListener != null) {
                onAudioPlayingListener.onStop();
            }
            f9134b.release();
            f9134b = null;
            AudioManager audioManager = f9136d;
            if (audioManager != null) {
                audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
            f9135c = null;
        }
    }
}
