package p055case;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.iproov.sdk.logging.IPLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import p055case.C1269do;
import p093switch.C3108catch;
import p232do.C20817break;

/* renamed from: case.do */
/* compiled from: Encoder */
public class C1269do {

    /* renamed from: a */
    private static final String f457a = ("🎞 " + C1269do.class.getSimpleName());

    /* renamed from: b */
    private MediaCodec f458b;

    /* renamed from: c */
    private long f459c = 0;

    /* renamed from: d */
    private boolean f460d;

    /* renamed from: e */
    private boolean f461e;

    /* renamed from: f */
    private final C1271if f462f;

    /* renamed from: g */
    private C1270do f463g;

    /* renamed from: case.do$do */
    /* compiled from: Encoder */
    enum C1270do {
        HARDWARE,
        SOFTWARE
    }

    /* renamed from: case.do$if */
    /* compiled from: Encoder */
    public interface C1271if {
        /* renamed from: do */
        void mo14143do();

        /* renamed from: do */
        void mo14144do(C1277try tryR);

        /* renamed from: do */
        void mo14145do(Exception exc);
    }

    public C1269do(C20817break breakR, C1271if ifVar, C1275new newR) {
        this.f462f = ifVar;
        m975a("AUTO-DETECTED ENCODER SETTINGS", newR.f471if.getName(), newR.f61670new);
        MediaFormat mediaFormat = C1273goto.m989do(breakR, newR);
        try {
            this.f458b = m966a(newR.f471if, mediaFormat);
            this.f463g = C1270do.HARDWARE;
        } catch (Exception unused) {
            m975a("AUTO-FALLING BACK TO SOFTWARE ENCODER", newR.f61669for.getName(), newR.f61670new);
            mediaFormat.setInteger("color-format", newR.f61670new);
            try {
                this.f458b = m966a(newR.f61669for, mediaFormat);
                this.f463g = C1270do.SOFTWARE;
            } catch (Exception e) {
                m974a(e, ifVar, new Handler());
            }
        }
    }

    /* renamed from: a */
    private long m965a() {
        long j = this.f459c;
        this.f459c = 33333 + j;
        return j;
    }

    /* renamed from: b */
    private void m978b() {
        this.f460d = false;
        MediaCodec mediaCodec = this.f458b;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f458b.release();
                this.f458b = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: case  reason: not valid java name */
    public void m46121case() {
        HandlerThread handlerThread = new HandlerThread("EncoderCallback");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        try {
            this.f458b.start();
            C3108catch.m4014do("EncoderPoll", C3108catch.C3110for.LOW, (Runnable) new Runnable(handler, handlerThread) {
                public final /* synthetic */ Handler f$1;
                public final /* synthetic */ HandlerThread f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    C1269do.this.m970a(this.f$1, this.f$2);
                }
            }).start();
        } catch (Exception e) {
            m974a(e, this.f462f, handler);
        }
    }

    /* renamed from: do */
    public void mo14140do(byte[] bArr) throws C1274if {
        MediaCodec mediaCodec = this.f458b;
        if (mediaCodec != null) {
            try {
                m969a(mediaCodec.dequeueInputBuffer(-1), bArr);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                throw new C1274if(e.getMessage());
            }
        } else {
            throw new C1274if("Encoder is null. Cannot encode frame!");
        }
    }

    /* renamed from: if */
    public C1270do mo14141if() {
        return this.f463g;
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m46122new() {
        return this.f460d;
    }

    /* renamed from: a */
    private ByteBuffer m967a(int i) {
        return this.f458b.getOutputBuffer(i);
    }

    /* renamed from: do */
    public void mo14139do() {
        MediaCodec mediaCodec;
        if (!this.f461e && (mediaCodec = this.f458b) != null) {
            this.f461e = true;
            try {
                this.f458b.queueInputBuffer(mediaCodec.dequeueInputBuffer(-1), 0, 0, m965a(), 4);
            } catch (IllegalStateException e) {
                this.f462f.mo14145do((Exception) e);
            }
        }
    }

    /* renamed from: a */
    private void m974a(Exception exc, C1271if ifVar, Handler handler) {
        String str = f457a;
        IPLog.m39301e(str, "Encoder error: " + exc.getLocalizedMessage());
        exc.printStackTrace();
        m978b();
        handler.post(new Runnable(exc) {
            public final /* synthetic */ Exception f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                C1269do.C1271if.this.mo14145do(this.f$1);
            }
        });
    }

    /* renamed from: a */
    private static MediaCodec m966a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException, MediaCodec.CodecException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        return createByCodecName;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m970a(Handler handler, HandlerThread handlerThread) {
        try {
            this.f460d = true;
            while (this.f460d) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.f458b.dequeueOutputBuffer(bufferInfo, -1);
                if (dequeueOutputBuffer >= 0) {
                    m968a(dequeueOutputBuffer, m967a(dequeueOutputBuffer), bufferInfo, this.f462f, handler);
                }
                if ((bufferInfo.flags & 4) != 0) {
                    this.f460d = false;
                }
            }
            m978b();
            handler.post(new Runnable(handlerThread) {
                public final /* synthetic */ HandlerThread f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C1269do.this.m971a(this.f$1);
                }
            });
        } catch (Exception e) {
            m974a(e, this.f462f, handler);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m971a(HandlerThread handlerThread) {
        this.f462f.mo14143do();
        handlerThread.quit();
    }

    /* renamed from: a */
    private void m968a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, C1271if ifVar, Handler handler) {
        if (i >= 0) {
            byte[] a = m976a(byteBuffer, bufferInfo);
            StringBuilder sb = new StringBuilder();
            sb.append("Encoded frame (output = ");
            sb.append(a.length);
            sb.append(") ");
            sb.append(bufferInfo.flags);
            if (a.length > 0) {
                handler.post(new Runnable(a, bufferInfo) {
                    public final /* synthetic */ byte[] f$1;
                    public final /* synthetic */ MediaCodec.BufferInfo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        C1269do.C1271if.this.mo14144do(new C1277try(this.f$1, this.f$2.flags));
                    }
                });
            }
            this.f458b.releaseOutputBuffer(i, false);
        }
    }

    /* renamed from: a */
    private static byte[] m976a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byte[] bArr = new byte[bufferInfo.size];
        byteBuffer.get(bArr);
        byteBuffer.position(bufferInfo.offset);
        return bArr;
    }

    /* renamed from: a */
    private void m969a(int i, byte[] bArr) {
        if (i >= 0) {
            ByteBuffer b = m977b(i);
            if (b != null) {
                b.clear();
                b.put(bArr);
            }
            this.f458b.queueInputBuffer(i, 0, bArr.length, m965a(), 0);
        }
    }

    /* renamed from: b */
    private ByteBuffer m977b(int i) {
        return this.f458b.getInputBuffer(i);
    }

    /* renamed from: a */
    private static void m975a(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Encoder: ");
        sb.append(str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Color format: 0x");
        sb2.append(Integer.toHexString(i));
    }
}
