package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.didichuxing.dfbasesdk.AppContextHolder;

public class IMediaPlayer {

    /* renamed from: c */
    private static IMediaPlayer f46740c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MediaPlayer f46741a = new MediaPlayer();

    /* renamed from: b */
    private int f46742b;

    public static IMediaPlayer getInstance() {
        if (f46740c == null) {
            synchronized (IMediaPlayer.class) {
                if (f46740c == null) {
                    f46740c = new IMediaPlayer();
                }
            }
        }
        return f46740c;
    }

    private IMediaPlayer() {
    }

    public void release() {
        synchronized (IMediaPlayer.class) {
            if (this.f46741a != null) {
                this.f46741a.reset();
                this.f46741a.release();
                this.f46741a = null;
            }
            f46740c = null;
        }
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.f46741a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    public void doPlay(int i) {
        Context appContext;
        if (this.f46741a != null && (appContext = AppContextHolder.getAppContext()) != null && i != 0) {
            if (this.f46742b == i) {
                LogUtils.m33563d("ignore the same sound!!!");
                return;
            }
            this.f46742b = i;
            this.f46741a.reset();
            try {
                AssetFileDescriptor openRawResourceFd = appContext.getResources().openRawResourceFd(i);
                this.f46741a.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f46741a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            IMediaPlayer.this.f46741a.start();
                        } catch (IllegalStateException e) {
                            LogUtils.logStackTrace(e);
                        }
                    }
                });
                this.f46741a.prepareAsync();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }
}
