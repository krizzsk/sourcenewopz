package com.didichuxing.dfbasesdk.video_capture;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.video_capture.MediaEncoder;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaAudioEncoder extends MediaEncoder {
    public static final int FRAMES_PER_BUFFER = 25;
    public static final int SAMPLES_PER_FRAME = 1024;

    /* renamed from: a */
    private static final boolean f46815a = false;

    /* renamed from: b */
    private static final String f46816b = "MediaAudioEncoder";

    /* renamed from: c */
    private static final String f46817c = "audio/mp4a-latm";

    /* renamed from: d */
    private static final int f46818d = 44100;

    /* renamed from: e */
    private static final int f46819e = 64000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int[] f46820f = {1, 0, 5, 7, 6};

    /* renamed from: g */
    private AudioThread f46821g = null;

    public MediaAudioEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener) {
        super(mediaMuxerWrapper, mediaEncoderListener);
    }

    /* renamed from: a */
    private static final MediaCodecInfo m33610a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IOException {
        this.mTrackIndex = -1;
        this.mIsEOS = false;
        this.mMuxerStarted = false;
        if (m33610a(f46817c) == null) {
            SystemUtils.log(6, f46816b, "Unable to find an appropriate codec for audio/mp4a-latm", (Throwable) null, "com.didichuxing.dfbasesdk.video_capture.MediaAudioEncoder", 99);
            return;
        }
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(f46817c, 44100, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(SDKConsts.TAG_KEY_BITRATE, f46819e);
        createAudioFormat.setInteger("channel-count", 1);
        this.mMediaCodec = MediaCodec.createEncoderByType(f46817c);
        this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mMediaCodec.start();
        if (this.mListener != null) {
            try {
                this.mListener.onPrepared(this);
            } catch (Exception e) {
                SystemUtils.log(6, f46816b, "prepare:", e, "com.didichuxing.dfbasesdk.video_capture.MediaAudioEncoder", 133);
                if (this.mListener != null) {
                    MediaEncoder.MediaEncoderListener mediaEncoderListener = this.mListener;
                    mediaEncoderListener.onError("MediaAudioEncoder prepare error, " + Log.getStackTraceString(e));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startRecording() {
        super.startRecording();
        if (this.f46821g == null) {
            AudioThread audioThread = new AudioThread();
            this.f46821g = audioThread;
            audioThread.start();
        }
    }

    /* access modifiers changed from: protected */
    public void release() {
        this.f46821g = null;
        super.release();
    }

    private class AudioThread extends Thread {
        private AudioThread() {
        }

        public void run() {
            SystemUtils.setProcessThreadPriority(-19);
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                int i = 25600;
                if (25600 < minBufferSize) {
                    i = ((minBufferSize / 1024) + 1) * 1024 * 2;
                }
                AudioRecord audioRecord = null;
                for (int audioRecord2 : MediaAudioEncoder.f46820f) {
                    try {
                        AudioRecord audioRecord3 = new AudioRecord(audioRecord2, 44100, 16, 2, i);
                        if (audioRecord3.getState() != 1) {
                            audioRecord3 = null;
                        }
                        audioRecord = audioRecord3;
                    } catch (Exception unused) {
                        audioRecord = null;
                    }
                    if (audioRecord != null) {
                        break;
                    }
                }
                if (audioRecord != null) {
                    try {
                        if (MediaAudioEncoder.this.mIsCapturing) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                            audioRecord.startRecording();
                            while (MediaAudioEncoder.this.mIsCapturing && !MediaAudioEncoder.this.mRequestStop && !MediaAudioEncoder.this.mIsEOS) {
                                allocateDirect.clear();
                                int read = audioRecord.read(allocateDirect, 1024);
                                if (read > 0) {
                                    allocateDirect.position(read);
                                    allocateDirect.flip();
                                    MediaAudioEncoder.this.encode(allocateDirect, read, MediaAudioEncoder.this.getPTSUs());
                                    MediaAudioEncoder.this.frameAvailableSoon();
                                }
                            }
                            MediaAudioEncoder.this.frameAvailableSoon();
                            audioRecord.stop();
                        }
                        audioRecord.release();
                    } catch (Throwable th) {
                        audioRecord.release();
                        throw th;
                    }
                } else {
                    SystemUtils.log(6, MediaAudioEncoder.f46816b, "failed to initialize AudioRecord", (Throwable) null, "com.didichuxing.dfbasesdk.video_capture.MediaAudioEncoder$AudioThread", 247);
                }
            } catch (Exception e) {
                SystemUtils.log(6, MediaAudioEncoder.f46816b, "AudioThread#run", e, "com.didichuxing.dfbasesdk.video_capture.MediaAudioEncoder$AudioThread", 252);
                if (MediaAudioEncoder.this.mListener != null) {
                    MediaAudioEncoder.this.mListener.onError("AudioThread#run error, " + Log.getStackTraceString(e));
                }
            }
        }
    }
}
