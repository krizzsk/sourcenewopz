package com.didi.safety.god.mediacodec;

import android.media.MediaCodec;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class MediaEncoder implements Runnable {
    protected static final int MSG_FRAME_AVAILABLE = 1;
    protected static final int MSG_STOP_RECORDING = 9;
    protected static final int TIMEOUT_USEC = 10000;

    /* renamed from: a */
    private static final boolean f34647a = false;

    /* renamed from: b */
    private static final String f34648b = "MediaEncoder";

    /* renamed from: c */
    private int f34649c;

    /* renamed from: d */
    private MediaCodec.BufferInfo f34650d;

    /* renamed from: e */
    private long f34651e = 0;
    protected volatile boolean mIsCapturing;
    protected boolean mIsEOS;
    protected final MediaEncoderListener mListener;
    protected MediaCodec mMediaCodec;
    protected MediaMuxerWrapper mMuxer;
    protected boolean mMuxerStarted;
    protected volatile boolean mRequestStop;
    protected final Object mSync = new Object();
    protected int mTrackIndex;

    public interface MediaEncoderListener {
        void onException(MediaEncoder mediaEncoder, Exception exc);

        void onPrepared(MediaEncoder mediaEncoder);

        void onStopped(MediaEncoder mediaEncoder);

        void onVideoReady(MediaEncoder mediaEncoder);
    }

    /* access modifiers changed from: package-private */
    public abstract void prepare() throws IOException;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaEncoder(com.didi.safety.god.mediacodec.MediaMuxerWrapper r3, com.didi.safety.god.mediacodec.MediaEncoder.MediaEncoderListener r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.mSync = r0
            r0 = 0
            r2.f34651e = r0
            if (r4 == 0) goto L_0x0045
            if (r3 == 0) goto L_0x003d
            r2.mMuxer = r3
            r3.mo89880a((com.didi.safety.god.mediacodec.MediaEncoder) r2)
            r2.mListener = r4
            java.lang.Object r3 = r2.mSync
            monitor-enter(r3)
            android.media.MediaCodec$BufferInfo r4 = new android.media.MediaCodec$BufferInfo     // Catch:{ all -> 0x003a }
            r4.<init>()     // Catch:{ all -> 0x003a }
            r2.f34650d = r4     // Catch:{ all -> 0x003a }
            java.lang.Thread r4 = new java.lang.Thread     // Catch:{ all -> 0x003a }
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x003a }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x003a }
            r4.start()     // Catch:{ all -> 0x003a }
            java.lang.Object r4 = r2.mSync     // Catch:{ InterruptedException -> 0x0038 }
            r4.wait()     // Catch:{ InterruptedException -> 0x0038 }
        L_0x0038:
            monitor-exit(r3)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003a }
            throw r4
        L_0x003d:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaMuxerWrapper is null"
            r3.<init>(r4)
            throw r3
        L_0x0045:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaEncoderListener is null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.mediacodec.MediaEncoder.<init>(com.didi.safety.god.mediacodec.MediaMuxerWrapper, com.didi.safety.god.mediacodec.MediaEncoder$MediaEncoderListener):void");
    }

    public String getOutputPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.mMuxer;
        if (mediaMuxerWrapper != null) {
            return mediaMuxerWrapper.getOutputPath();
        }
        return null;
    }

    public boolean frameAvailableSoon() {
        synchronized (this.mSync) {
            if (this.mIsCapturing) {
                if (!this.mRequestStop) {
                    this.f34649c++;
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
            this.f34649c = 0;
            this.mSync.notify();
        }
        Exception e = null;
        while (true) {
            synchronized (this.mSync) {
                z = this.mRequestStop;
                z2 = this.f34649c > 0;
                if (z2) {
                    this.f34649c--;
                }
            }
            if (z) {
                try {
                    drain();
                    signalEndOfInputStream();
                    drain();
                    release();
                    this.mListener.onVideoReady(this);
                    break;
                } catch (Exception e2) {
                    e = e2;
                }
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
                        if (e != null) {
                            this.mListener.onException(this, e);
                            return;
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
    public void mo89855b() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.mediacodec.MediaEncoder.mo89855b():void");
    }

    /* access modifiers changed from: protected */
    public void release() {
        MediaMuxerWrapper mediaMuxerWrapper;
        try {
            this.mListener.onStopped(this);
        } catch (Exception e) {
            SystemUtils.log(6, f34648b, "failed onStopped", e, "com.didi.safety.god.mediacodec.MediaEncoder", 208);
        }
        this.mIsCapturing = false;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            } catch (Exception e2) {
                SystemUtils.log(6, f34648b, "failed releasing MediaCodec", e2, "com.didi.safety.god.mediacodec.MediaEncoder", 217);
            }
        }
        if (this.mMuxerStarted && (mediaMuxerWrapper = this.mMuxer) != null) {
            try {
                mediaMuxerWrapper.mo89882b();
            } catch (Exception e3) {
                SystemUtils.log(6, f34648b, "failed stopping muxer", e3, "com.didi.safety.god.mediacodec.MediaEncoder", 225);
            }
        }
        this.f34650d = null;
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
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x007c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r8 = this;
            android.media.MediaCodec r0 = r8.mMediaCodec
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            com.didi.safety.god.mediacodec.MediaMuxerWrapper r1 = r8.mMuxer
            if (r1 != 0) goto L_0x001b
            java.lang.String r3 = "MediaEncoder"
            java.lang.String r4 = "muxer is unexpectedly null"
            r2 = 5
            r5 = 0
            java.lang.String r6 = "com.didi.safety.god.mediacodec.MediaEncoder"
            r7 = 288(0x120, float:4.04E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            return
        L_0x001b:
            r1 = 0
            r2 = 0
        L_0x001d:
            boolean r3 = r8.mIsCapturing
            if (r3 == 0) goto L_0x00f6
            android.media.MediaCodec r3 = r8.mMediaCodec
            android.media.MediaCodec$BufferInfo r4 = r8.f34650d
            r5 = 10000(0x2710, double:4.9407E-320)
            int r3 = r3.dequeueOutputBuffer(r4, r5)
            r4 = -1
            if (r3 != r4) goto L_0x0039
            boolean r3 = r8.mIsEOS
            if (r3 != 0) goto L_0x001d
            int r2 = r2 + 1
            r3 = 5
            if (r2 <= r3) goto L_0x001d
            goto L_0x00f6
        L_0x0039:
            r4 = -3
            if (r3 != r4) goto L_0x0043
            android.media.MediaCodec r0 = r8.mMediaCodec
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            goto L_0x001d
        L_0x0043:
            r4 = -2
            if (r3 != r4) goto L_0x008c
            boolean r3 = r8.mMuxerStarted
            if (r3 != 0) goto L_0x0084
            android.media.MediaCodec r3 = r8.mMediaCodec
            android.media.MediaFormat r3 = r3.getOutputFormat()
            com.didi.safety.god.mediacodec.MediaMuxerWrapper r4 = r8.mMuxer
            if (r4 == 0) goto L_0x0059
            int r3 = r4.mo89878a((android.media.MediaFormat) r3)
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            r8.mTrackIndex = r3
            r3 = 1
            r8.mMuxerStarted = r3
            com.didi.safety.god.mediacodec.MediaMuxerWrapper r3 = r8.mMuxer
            if (r3 == 0) goto L_0x001d
            boolean r3 = r3.mo89881a()
            if (r3 != 0) goto L_0x001d
            com.didi.safety.god.mediacodec.MediaMuxerWrapper r3 = r8.mMuxer
            monitor-enter(r3)
        L_0x006c:
            com.didi.safety.god.mediacodec.MediaMuxerWrapper r4 = r8.mMuxer     // Catch:{ all -> 0x0081 }
            boolean r4 = r4.isStarted()     // Catch:{ all -> 0x0081 }
            if (r4 != 0) goto L_0x007f
            com.didi.safety.god.mediacodec.MediaMuxerWrapper r4 = r8.mMuxer     // Catch:{ InterruptedException -> 0x007c }
            r5 = 100
            r4.wait(r5)     // Catch:{ InterruptedException -> 0x007c }
            goto L_0x006c
        L_0x007c:
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            goto L_0x00f6
        L_0x007f:
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            goto L_0x001d
        L_0x0081:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            throw r0
        L_0x0084:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "format changed twice"
            r0.<init>(r1)
            throw r0
        L_0x008c:
            if (r3 >= 0) goto L_0x008f
            goto L_0x001d
        L_0x008f:
            r4 = r0[r3]
            if (r4 == 0) goto L_0x00da
            android.media.MediaCodec$BufferInfo r5 = r8.f34650d
            int r5 = r5.flags
            r5 = r5 & 2
            if (r5 == 0) goto L_0x009f
            android.media.MediaCodec$BufferInfo r5 = r8.f34650d
            r5.size = r1
        L_0x009f:
            android.media.MediaCodec$BufferInfo r5 = r8.f34650d
            int r5 = r5.size
            if (r5 == 0) goto L_0x00ca
            boolean r2 = r8.mMuxerStarted
            if (r2 == 0) goto L_0x00c2
            android.media.MediaCodec$BufferInfo r2 = r8.f34650d
            long r5 = r8.getPTSUs()
            r2.presentationTimeUs = r5
            com.didi.safety.god.mediacodec.MediaMuxerWrapper r2 = r8.mMuxer
            int r5 = r8.mTrackIndex
            android.media.MediaCodec$BufferInfo r6 = r8.f34650d
            r2.mo89879a(r5, r4, r6)
            android.media.MediaCodec$BufferInfo r2 = r8.f34650d
            long r4 = r2.presentationTimeUs
            r8.f34651e = r4
            r2 = 0
            goto L_0x00ca
        L_0x00c2:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "drain:muxer hasn't started"
            r0.<init>(r1)
            throw r0
        L_0x00ca:
            android.media.MediaCodec r4 = r8.mMediaCodec
            r4.releaseOutputBuffer(r3, r1)
            android.media.MediaCodec$BufferInfo r3 = r8.f34650d
            int r3 = r3.flags
            r3 = r3 & 4
            if (r3 == 0) goto L_0x001d
            r8.mIsCapturing = r1
            goto L_0x00f6
        L_0x00da:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " was null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.mediacodec.MediaEncoder.drain():void");
    }

    /* access modifiers changed from: protected */
    public long getPTSUs() {
        long nanoTime = System.nanoTime() / 1000;
        long j = this.f34651e;
        return nanoTime < j ? nanoTime + (j - nanoTime) : nanoTime;
    }
}
