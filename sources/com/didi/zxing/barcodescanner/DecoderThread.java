package com.didi.zxing.barcodescanner;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.MultiFormatReader;
import com.didi.dqr.ReaderException;
import com.didi.dqr.Result;
import com.didi.dqr.common.HybridBinarizer;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.PreviewCallback;
import com.didi.zxing.barcodescanner.trace.ScanTrace;
import com.didi.zxing.barcodescanner.trace.ScanTraceId;
import com.taxis99.R;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class DecoderThread implements DecodeThreadInter {

    /* renamed from: a */
    private static final String f45264a = "DecoderThread";

    /* renamed from: b */
    private CameraInstance f45265b;

    /* renamed from: c */
    private HandlerThread f45266c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f45267d;

    /* renamed from: e */
    private Decoder f45268e;

    /* renamed from: f */
    private Handler f45269f;

    /* renamed from: g */
    private Rect f45270g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f45271h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Object f45272i = new Object();

    /* renamed from: j */
    private MultiFormatReader f45273j;

    /* renamed from: k */
    private long f45274k;

    /* renamed from: l */
    private final Handler.Callback f45275l = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == R.id.zxing_decode) {
                DecoderThread.this.m32511a((SourceData) message.obj);
                return true;
            } else if (message.what != R.id.zxing_preview_failed) {
                return true;
            } else {
                DecoderThread.this.m32508a();
                return true;
            }
        }
    };

    /* renamed from: m */
    private final PreviewCallback f45276m = new PreviewCallback() {
        public boolean oneShot() {
            return true;
        }

        public void onPreview(SourceData sourceData) {
            synchronized (DecoderThread.this.f45272i) {
                if (DecoderThread.this.f45271h) {
                    DecoderThread.this.f45267d.obtainMessage(R.id.zxing_decode, sourceData).sendToTarget();
                }
            }
        }

        public void onPreviewError(Exception exc) {
            synchronized (DecoderThread.this.f45272i) {
                if (DecoderThread.this.f45271h) {
                    DecoderThread.this.f45267d.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                }
            }
        }
    };

    public void setCheckPattern(boolean z) {
    }

    public void setProductId(String str) {
    }

    public DecoderThread(CameraInstance cameraInstance, Decoder decoder, Handler handler) {
        C14921Util.validateMainThread();
        this.f45265b = cameraInstance;
        this.f45268e = decoder;
        this.f45269f = handler;
        Map<DecodeHintType, ?> a = m32507a(decoder.getDecodeOptions());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f45273j = multiFormatReader;
        multiFormatReader.setHints(a);
        this.f45273j.setDecodeOptions(decoder.getDecodeOptions());
    }

    /* renamed from: a */
    private Map<DecodeHintType, ?> m32507a(DecodeOptions decodeOptions) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        if (decodeOptions.baseHints != null) {
            enumMap.putAll(decodeOptions.baseHints);
        }
        if (decodeOptions.decodeFormats == null || decodeOptions.decodeFormats.isEmpty()) {
            decodeOptions.decodeFormats = EnumSet.of(BarcodeFormat.QR_CODE);
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, decodeOptions.decodeFormats);
        enumMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        if (decodeOptions.characterSet != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, decodeOptions.characterSet);
        }
        return enumMap;
    }

    public Decoder getDecoder() {
        return this.f45268e;
    }

    public void setDecoder(Decoder decoder) {
        this.f45268e = decoder;
    }

    public Rect getCropRect() {
        return this.f45270g;
    }

    public void setCropRect(Rect rect) {
        this.f45270g = rect;
    }

    public void start() {
        C14921Util.validateMainThread();
        HandlerThread handlerThread = new HandlerThread(f45264a);
        this.f45266c = handlerThread;
        handlerThread.start();
        this.f45267d = new Handler(this.f45266c.getLooper(), this.f45275l);
        this.f45271h = true;
        m32508a();
        this.f45274k = SystemClock.elapsedRealtime();
        ScanTrace.trace(ScanTraceId.SCAN_START);
    }

    public void stop() {
        C14921Util.validateMainThread();
        synchronized (this.f45272i) {
            this.f45271h = false;
            this.f45267d.removeCallbacksAndMessages((Object) null);
            this.f45266c.quit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32508a() {
        if (this.f45265b.isOpen()) {
            this.f45265b.requestPreview(this.f45276m);
        }
    }

    /* access modifiers changed from: protected */
    public LuminanceSource createSource(SourceData sourceData) {
        if (this.f45270g == null) {
            return null;
        }
        return sourceData.createSource();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32511a(SourceData sourceData) {
        Result result;
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        sourceData.setCropRect(this.f45270g);
        LuminanceSource createSource = createSource(sourceData);
        if (createSource != null) {
            try {
                result = this.f45273j.decodeWithState(new BinaryBitmap(new HybridBinarizer(createSource)));
                this.f45273j.reset();
            } catch (ReaderException unused) {
                this.f45273j.reset();
                result = null;
            } catch (Throwable th) {
                this.f45273j.reset();
                throw th;
            }
            if (result != null) {
                SystemUtils.log(6, "rawResult", "rawResult = " + result.getText(), (Throwable) null, "com.didi.zxing.barcodescanner.DecoderThread", 202);
            }
            if (result == null || TextUtils.isEmpty(result.getText())) {
                Handler handler = this.f45269f;
                if (handler != null) {
                    Message.obtain(handler, R.id.zxing_decode_failed).sendToTarget();
                }
            } else if (this.f45271h) {
                long currentTimeMillis2 = System.currentTimeMillis();
                SystemUtils.log(3, f45264a, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms", (Throwable) null, "com.didi.zxing.barcodescanner.DecoderThread", 210);
                if (this.f45269f != null) {
                    Message obtain = Message.obtain(this.f45269f, R.id.zxing_decode_succeeded, new BarcodeResult(result, sourceData, elapsedRealtime));
                    obtain.setData(new Bundle());
                    obtain.sendToTarget();
                    ScanTrace.traceSingle(ScanTraceId.SCAN_SUCCESS, "cost", (SystemClock.elapsedRealtime() - this.f45274k) + "");
                }
            } else {
                return;
            }
        } else {
            SystemUtils.log(5, "zxing", "source = null", (Throwable) null, "com.didi.zxing.barcodescanner.DecoderThread", 228);
        }
        m32508a();
    }

    public void pause() {
        this.f45271h = false;
        stop();
    }
}
