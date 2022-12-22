package com.didi.dimina.container.util;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.didi.dimina.container.util.MediaPlayerManager;
import java.io.IOException;

public class MediaPlayerManager {
    public static final int MEDIA_STATUS_PAUSE = 1;
    public static final int MEDIA_STATUS_PLAY = 0;
    public static final int MEDIA_STATUS_STOP = 2;

    /* renamed from: a */
    private static final String f17946a = "MediaPlayerManager";

    /* renamed from: c */
    private static final int f17947c = 1000;
    public int MEDIA_STATUS = 2;

    /* renamed from: b */
    private MediaPlayer f17948b = new MediaPlayer();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnMusicProgressListener f17949d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f17950e = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1000 || MediaPlayerManager.this.f17949d == null) {
                return false;
            }
            int currentPosition = MediaPlayerManager.this.getCurrentPosition();
            MediaPlayerManager.this.f17949d.OnProgress(currentPosition, (int) ((((float) currentPosition) / ((float) MediaPlayerManager.this.getDuration())) * 100.0f));
            MediaPlayerManager.this.f17950e.sendEmptyMessageDelayed(1000, 1000);
            return false;
        }
    });

    public interface OnMusicProgressListener {
        void OnProgress(int i, int i2);
    }

    public interface OnMusicStartPlayListener {
        void onStartPlay();
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            return mediaPlayer.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.eRelease(f17946a, "isPlaying()发生异常 + " + e.toString());
            return false;
        }
    }

    public void startPlay(AssetFileDescriptor assetFileDescriptor) {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer == null) {
            LogUtil.iRelease(f17946a, "can't startPlay, mMediaPlayer is null");
            return;
        }
        try {
            mediaPlayer.reset();
            this.f17948b.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            this.f17948b.prepareAsync();
            this.f17948b.setOnPreparedListener($$Lambda$jX_tASEdjv03obJy5rjdfXVUzvw.INSTANCE);
            this.MEDIA_STATUS = 0;
            this.f17950e.sendEmptyMessage(1000);
        } catch (IOException e) {
            LogUtil.eRelease(f17946a, "startPlay error: " + e.toString());
            e.printStackTrace();
        }
    }

    public void startPlay(String str, OnMusicStartPlayListener onMusicStartPlayListener) {
        if (this.f17948b == null) {
            LogUtil.iRelease(f17946a, "can't startPlay, mMediaPlayer is null, path: " + str);
            return;
        }
        try {
            LogUtil.iRelease(f17946a, "startPlay " + str);
            this.f17948b.reset();
            this.f17948b.setDataSource(str);
            this.f17948b.prepareAsync();
            this.f17948b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    MediaPlayerManager.m13417a(MediaPlayerManager.OnMusicStartPlayListener.this, mediaPlayer);
                }
            });
            this.MEDIA_STATUS = 0;
            this.f17950e.sendEmptyMessage(1000);
        } catch (IOException e) {
            LogUtil.eRelease(f17946a, "startPlay error: " + e.toString());
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m13417a(OnMusicStartPlayListener onMusicStartPlayListener, MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        onMusicStartPlayListener.onStartPlay();
    }

    public void pausePlay() {
        if (isPlaying()) {
            this.f17948b.pause();
            this.MEDIA_STATUS = 1;
            removeHandler();
        }
    }

    public void continuePlay() {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.MEDIA_STATUS = 0;
            this.f17950e.sendEmptyMessage(1000);
        }
    }

    public void stopPlay() {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f17948b.stop();
            this.MEDIA_STATUS = 2;
            removeHandler();
        }
    }

    public void setVolume(float f, float f2) {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public void release() {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f17948b = null;
        }
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
        }
    }

    public void removeHandler() {
        this.f17950e.removeMessages(1000);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer = this.f17948b;
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnProgressListener(OnMusicProgressListener onMusicProgressListener) {
        this.f17949d = onMusicProgressListener;
    }
}
