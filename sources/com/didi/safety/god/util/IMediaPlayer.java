package com.didi.safety.god.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.didichuxing.dfbasesdk.AppContextHolder;

public class IMediaPlayer {

    /* renamed from: c */
    private static IMediaPlayer f34841c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MediaPlayer f34842a = new MediaPlayer();

    /* renamed from: b */
    private int f34843b;

    public static IMediaPlayer getInstance() {
        if (f34841c == null) {
            f34841c = new IMediaPlayer();
        }
        return f34841c;
    }

    private IMediaPlayer() {
    }

    public void release() {
        MediaPlayer mediaPlayer = this.f34842a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f34842a.release();
            this.f34842a = null;
        }
        f34841c = null;
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.f34842a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    public void doPlay(int i) {
        Context appContext;
        if (this.f34842a != null && (appContext = AppContextHolder.getAppContext()) != null && i != 0) {
            if (this.f34843b == i) {
                LogUtils.m24578d("ignore the same sound!!!");
                return;
            }
            this.f34843b = i;
            this.f34842a.reset();
            try {
                AssetFileDescriptor openRawResourceFd = appContext.getResources().openRawResourceFd(i);
                this.f34842a.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f34842a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            IMediaPlayer.this.f34842a.start();
                        } catch (IllegalStateException e) {
                            LogUtils.logStackTrace(e);
                        }
                    }
                });
                this.f34842a.prepareAsync();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }
}
