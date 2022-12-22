package com.didichuxing.diface.biz.bioassay.fpp.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.megvii.livenessdetection.Detector;
import com.taxis99.R;

public class IMediaPlayer {

    /* renamed from: a */
    private Context f47238a;
    public MediaPlayer mMediaPlayer = new MediaPlayer();

    public IMediaPlayer(Context context) {
        this.f47238a = context;
    }

    public void close() {
        this.f47238a = null;
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

    public void setOnCompletionListener(final Detector.DetectionType detectionType) {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
        }
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                IMediaPlayer iMediaPlayer = IMediaPlayer.this;
                iMediaPlayer.doPlay(iMediaPlayer.getSoundRes(detectionType));
                IMediaPlayer.this.mMediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
            }
        });
    }

    public void doPlay(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            try {
                AssetFileDescriptor openRawResourceFd = this.f47238a.getResources().openRawResourceFd(i);
                this.mMediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        IMediaPlayer.this.mMediaPlayer.start();
                    }
                });
                this.mMediaPlayer.prepareAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.didichuxing.diface.biz.bioassay.fpp.util.IMediaPlayer$3 */
    static /* synthetic */ class C154473 {
        static final /* synthetic */ int[] $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.megvii.livenessdetection.Detector$DetectionType[] r0 = com.megvii.livenessdetection.Detector.DetectionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType = r0
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_PITCH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW_LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW_RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.MOUTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.BLINK     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.fpp.util.IMediaPlayer.C154473.<clinit>():void");
        }
    }

    public int getSoundRes(Detector.DetectionType detectionType) {
        switch (C154473.$SwitchMap$com$megvii$livenessdetection$Detector$DetectionType[detectionType.ordinal()]) {
            case 1:
                return R.raw.nod;
            case 2:
            case 3:
            case 4:
                return R.raw.shake_head;
            case 5:
                return R.raw.open_mouth;
            case 6:
                return R.raw.blink;
            default:
                return -1;
        }
    }
}
