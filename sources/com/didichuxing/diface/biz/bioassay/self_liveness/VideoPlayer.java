package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class VideoPlayer {

    /* renamed from: a */
    private Context f47363a;
    public MediaPlayer mMediaPlayer = new MediaPlayer();

    public VideoPlayer(Context context) {
        this.f47363a = context;
    }

    public void close() {
        this.f47363a = null;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
        }
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoPlayer.this.mMediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                MediaPlayer.OnCompletionListener onCompletionListener = onCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(mediaPlayer);
                }
            }
        });
    }

    public void videoPlayer(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            try {
                AssetFileDescriptor openRawResourceFd = this.f47363a.getResources().openRawResourceFd(i);
                this.mMediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            VideoPlayer.this.mMediaPlayer.start();
                        } catch (IllegalStateException e) {
                            LogUtils.logStackTrace(e);
                        }
                    }
                });
                this.mMediaPlayer.prepareAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
