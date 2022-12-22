package com.didichuxing.diface.biz.bioassay.video_capture;

import android.media.MediaCodec;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class MediaEncoder implements Runnable {
    protected static final int MSG_FRAME_AVAILABLE = 1;
    protected static final int MSG_STOP_RECORDING = 9;
    protected static final int TIMEOUT_USEC = 10000;

    /* renamed from: a */
    private static final boolean f47420a = false;

    /* renamed from: b */
    private static final String f47421b = "MediaEncoder";

    /* renamed from: c */
    private int f47422c;

    /* renamed from: d */
    private MediaCodec.BufferInfo f47423d;

    /* renamed from: e */
    private long f47424e = 0;
    protected volatile boolean mIsCapturing;
    protected boolean mIsEOS;
    protected final MediaEncoderListener mListener;
    protected MediaCodec mMediaCodec;
    protected boolean mMuxerStarted;
    protected volatile boolean mRequestStop;
    protected final Object mSync = new Object();
    protected int mTrackIndex;
    protected final WeakReference<MediaMuxerWrapper> mWeakMuxer;

    public interface MediaEncoderListener {
        void onPrepared(MediaEncoder mediaEncoder);

        void onStopped(MediaEncoder mediaEncoder);
    }

    /* access modifiers changed from: package-private */
    public abstract void prepare() throws IOException;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaEncoder(com.didichuxing.diface.biz.bioassay.video_capture.MediaMuxerWrapper r3, com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder.MediaEncoderListener r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.mSync = r0
            r0 = 0
            r2.f47424e = r0
            if (r4 == 0) goto L_0x004a
            if (r3 == 0) goto L_0x0042
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.mWeakMuxer = r0
            r3.mo116421a((com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder) r2)
            r2.mListener = r4
            java.lang.Object r3 = r2.mSync
            monitor-enter(r3)
            android.media.MediaCodec$BufferInfo r4 = new android.media.MediaCodec$BufferInfo     // Catch:{ all -> 0x003f }
            r4.<init>()     // Catch:{ all -> 0x003f }
            r2.f47423d = r4     // Catch:{ all -> 0x003f }
            java.lang.Thread r4 = new java.lang.Thread     // Catch:{ all -> 0x003f }
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x003f }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x003f }
            r4.start()     // Catch:{ all -> 0x003f }
            java.lang.Object r4 = r2.mSync     // Catch:{ InterruptedException -> 0x003d }
            r4.wait()     // Catch:{ InterruptedException -> 0x003d }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            throw r4
        L_0x0042:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaMuxerWrapper is null"
            r3.<init>(r4)
            throw r3
        L_0x004a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaEncoderListener is null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder.<init>(com.didichuxing.diface.biz.bioassay.video_capture.MediaMuxerWrapper, com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder$MediaEncoderListener):void");
    }

    public String getOutputPath() {
        MediaMuxerWrapper mediaMuxerWrapper = (MediaMuxerWrapper) this.mWeakMuxer.get();
        if (mediaMuxerWrapper != null) {
            return mediaMuxerWrapper.getOutputPath();
        }
        return null;
    }

    public boolean frameAvailableSoon() {
        synchronized (this.mSync) {
            if (this.mIsCapturing) {
                if (!this.mRequestStop) {
                    this.f47422c++;
                    this.mSync.notifyAll();
                    return true;
                }
            }
            return false;
        }
    }

    public void run() {
        boolean z;
        boolean z2;
        synchronized (this.mSync) {
            this.mRequestStop = false;
            this.f47422c = 0;
            this.mSync.notify();
        }
        while (true) {
            synchronized (this.mSync) {
                z = this.mRequestStop;
                z2 = this.f47422c > 0;
                if (z2) {
                    this.f47422c--;
                }
            }
            if (z) {
                drain();
                signalEndOfInputStream();
                drain();
                release();
                break;
            } else if (z2) {
                drain();
            } else {
                synchronized (this.mSync) {
                    try {
                        this.mSync.wait();
                        try {
                        } finally {
                            while (true) {
                            }
                        }
                    } catch (InterruptedException unused) {
                        synchronized (this.mSync) {
                            this.mRequestStop = true;
                            this.mIsCapturing = false;
                        }
                        return;
                    }
                }
            }
        }
        while (true) {
        }
    }

    /* access modifiers changed from: package-private */
    public void startRecording() {
        synchronized (this.mSync) {
            this.mIsCapturing = true;
            this.mRequestStop = false;
            this.mSync.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo116411b() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mSync
            monitor-enter(r0)
            boolean r1 = r2.mIsCapturing     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0016
            boolean r1 = r2.mRequestStop     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0016
        L_0x000c:
            r1 = 1
            r2.mRequestStop = r1     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r2.mSync     // Catch:{ all -> 0x0018 }
            r1.notifyAll()     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder.mo116411b():void");
    }

    /* access modifiers changed from: protected */
    public void release() {
        try {
            this.mListener.onStopped(this);
        } catch (Exception e) {
            SystemUtils.log(6, f47421b, "failed onStopped", e, "com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder", 199);
        }
        this.mIsCapturing = false;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            } catch (Exception e2) {
                SystemUtils.log(6, f47421b, "failed releasing MediaCodec", e2, "com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder", 208);
            }
        }
        if (this.mMuxerStarted) {
            WeakReference<MediaMuxerWrapper> weakReference = this.mWeakMuxer;
            MediaMuxerWrapper mediaMuxerWrapper = weakReference != null ? (MediaMuxerWrapper) weakReference.get() : null;
            if (mediaMuxerWrapper != null) {
                try {
                    mediaMuxerWrapper.mo116423b();
                } catch (Exception e3) {
                    SystemUtils.log(6, f47421b, "failed stopping muxer", e3, "com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder", 217);
                }
            }
        }
        this.f47423d = null;
    }

    /* access modifiers changed from: protected */
    public void signalEndOfInputStream() {
        encode((ByteBuffer) null, 0, getPTSUs());
    }

    /* access modifiers changed from: protected */
    public void encode(ByteBuffer byteBuffer, int i, long j) {
        if (this.mIsCapturing) {
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            while (this.mIsCapturing) {
                int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    byteBuffer2.clear();
                    if (byteBuffer != null) {
                        byteBuffer2.put(byteBuffer);
                    }
                    if (i <= 0) {
                        this.mIsEOS = true;
                        this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                        return;
                    }
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0072 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r8 = this;
            android.media.MediaCodec r0 = r8.mMediaCodec
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            java.lang.ref.WeakReference<com.didichuxing.diface.biz.bioassay.video_capture.MediaMuxerWrapper> r1 = r8.mWeakMuxer
            java.lang.Object r1 = r1.get()
            com.didichuxing.diface.biz.bioassay.video_capture.MediaMuxerWrapper r1 = (com.didichuxing.diface.biz.bioassay.video_capture.MediaMuxerWrapper) r1
            if (r1 != 0) goto L_0x0021
            java.lang.String r3 = "MediaEncoder"
            java.lang.String r4 = "muxer is unexpectedly null"
            r2 = 5
            r5 = 0
            java.lang.String r6 = "com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder"
            r7 = 281(0x119, float:3.94E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            return
        L_0x0021:
            r2 = 0
            r3 = 0
        L_0x0023:
            boolean r4 = r8.mIsCapturing
            if (r4 == 0) goto L_0x00ea
            android.media.MediaCodec r4 = r8.mMediaCodec
            android.media.MediaCodec$BufferInfo r5 = r8.f47423d
            r6 = 10000(0x2710, double:4.9407E-320)
            int r4 = r4.dequeueOutputBuffer(r5, r6)
            r5 = -1
            if (r4 != r5) goto L_0x003f
            boolean r4 = r8.mIsEOS
            if (r4 != 0) goto L_0x0023
            int r3 = r3 + 1
            r4 = 5
            if (r3 <= r4) goto L_0x0023
            goto L_0x00ea
        L_0x003f:
            r5 = -3
            if (r4 != r5) goto L_0x0049
            android.media.MediaCodec r0 = r8.mMediaCodec
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            goto L_0x0023
        L_0x0049:
            r5 = -2
            if (r4 != r5) goto L_0x0082
            boolean r4 = r8.mMuxerStarted
            if (r4 != 0) goto L_0x007a
            android.media.MediaCodec r4 = r8.mMediaCodec
            android.media.MediaFormat r4 = r4.getOutputFormat()
            int r4 = r1.mo116419a((android.media.MediaFormat) r4)
            r8.mTrackIndex = r4
            r4 = 1
            r8.mMuxerStarted = r4
            boolean r4 = r1.mo116422a()
            if (r4 != 0) goto L_0x0023
            monitor-enter(r1)
        L_0x0066:
            boolean r4 = r1.isStarted()     // Catch:{ all -> 0x0077 }
            if (r4 != 0) goto L_0x0075
            r4 = 100
            r1.wait(r4)     // Catch:{ InterruptedException -> 0x0072 }
            goto L_0x0066
        L_0x0072:
            monitor-exit(r1)     // Catch:{ all -> 0x0077 }
            goto L_0x00ea
        L_0x0075:
            monitor-exit(r1)     // Catch:{ all -> 0x0077 }
            goto L_0x0023
        L_0x0077:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0077 }
            throw r0
        L_0x007a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "format changed twice"
            r0.<init>(r1)
            throw r0
        L_0x0082:
            if (r4 >= 0) goto L_0x0085
            goto L_0x0023
        L_0x0085:
            r5 = r0[r4]
            if (r5 == 0) goto L_0x00ce
            android.media.MediaCodec$BufferInfo r6 = r8.f47423d
            int r6 = r6.flags
            r6 = r6 & 2
            if (r6 == 0) goto L_0x0095
            android.media.MediaCodec$BufferInfo r6 = r8.f47423d
            r6.size = r2
        L_0x0095:
            android.media.MediaCodec$BufferInfo r6 = r8.f47423d
            int r6 = r6.size
            if (r6 == 0) goto L_0x00be
            boolean r3 = r8.mMuxerStarted
            if (r3 == 0) goto L_0x00b6
            android.media.MediaCodec$BufferInfo r3 = r8.f47423d
            long r6 = r8.getPTSUs()
            r3.presentationTimeUs = r6
            int r3 = r8.mTrackIndex
            android.media.MediaCodec$BufferInfo r6 = r8.f47423d
            r1.mo116420a(r3, r5, r6)
            android.media.MediaCodec$BufferInfo r3 = r8.f47423d
            long r5 = r3.presentationTimeUs
            r8.f47424e = r5
            r3 = 0
            goto L_0x00be
        L_0x00b6:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "drain:muxer hasn't started"
            r0.<init>(r1)
            throw r0
        L_0x00be:
            android.media.MediaCodec r5 = r8.mMediaCodec
            r5.releaseOutputBuffer(r4, r2)
            android.media.MediaCodec$BufferInfo r4 = r8.f47423d
            int r4 = r4.flags
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0023
            r8.mIsCapturing = r2
            goto L_0x00ea
        L_0x00ce:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " was null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder.drain():void");
    }

    /* access modifiers changed from: protected */
    public long getPTSUs() {
        long nanoTime = System.nanoTime() / 1000;
        long j = this.f47424e;
        return nanoTime < j ? nanoTime + (j - nanoTime) : nanoTime;
    }
}
