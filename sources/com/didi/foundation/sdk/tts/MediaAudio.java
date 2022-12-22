package com.didi.foundation.sdk.tts;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;

public class MediaAudio extends AbstractAudio {

    /* renamed from: a */
    private IPlayListener f21367a;

    /* renamed from: b */
    private Context f21368b;

    /* renamed from: c */
    private Logger f21369c = LogService.getLogger(MediaAudio.class.getSimpleName());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MediaPlayer f21370d;

    /* renamed from: e */
    private boolean f21371e = false;

    /* renamed from: f */
    private MediaPlayer.OnCompletionListener f21372f = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (!(MediaAudio.this.f21370d == null || mediaPlayer == null || MediaAudio.this.f21370d != mediaPlayer)) {
                try {
                    MediaAudio.this.f21370d.stop();
                    MediaAudio.this.f21370d.release();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    MediaPlayer unused = MediaAudio.this.f21370d = null;
                    throw th;
                }
                MediaPlayer unused2 = MediaAudio.this.f21370d = null;
            }
            MediaAudio.this.onCompleted();
        }
    };

    MediaAudio() {
    }

    public void init(IPlayListener iPlayListener, Context context) {
        this.f21367a = iPlayListener;
        this.f21368b = context;
    }

    public void play(PlayData playData) {
        Logger logger = this.f21369c;
        logger.debug("MediaPlay: play resourceId is" + playData.getRawId(), new Object[0]);
        if (playData.getRawId() > 0 && this.f21370d == null) {
            try {
                this.f21370d = new MediaPlayer();
                AssetFileDescriptor openRawResourceFd = this.f21368b.getResources().openRawResourceFd(playData.getRawId());
                this.f21370d.setAudioStreamType(3);
                this.f21370d.setOnCompletionListener(this.f21372f);
                this.f21370d.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                this.f21370d.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            MediaAudio.this.f21370d.start();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                this.f21370d.prepare();
            } catch (Throwable th) {
                th.printStackTrace();
                this.f21369c.debug("MediaPlay: play fail", new Object[0]);
                onCompleted();
            }
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.f21370d;
        if (mediaPlayer != null) {
            synchronized (mediaPlayer) {
                try {
                    this.f21370d.stop();
                    this.f21370d.release();
                } catch (IllegalStateException e) {
                    try {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        this.f21370d = null;
                        throw th;
                    }
                }
                this.f21370d = null;
            }
        }
    }

    public void release() {
        MediaPlayer mediaPlayer = this.f21370d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f21370d = null;
        }
    }

    public void pause() {
        MediaPlayer mediaPlayer = this.f21370d;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f21370d.pause();
            this.f21371e = true;
        }
    }

    public void resumeSpeaking() {
        MediaPlayer mediaPlayer = this.f21370d;
        if (mediaPlayer != null && this.f21371e) {
            mediaPlayer.start();
            this.f21371e = false;
        }
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.f21370d;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void onCompleted() {
        IPlayListener iPlayListener = this.f21367a;
        if (iPlayListener != null) {
            iPlayListener.onCompleted();
        }
    }
}
