package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinarizerEnum;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.MultiFormatReader;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.util.ScanResultObserver;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.PreviewCallback;
import com.didi.zxing.barcodescanner.executor.BalanceExecutor;
import com.didi.zxing.barcodescanner.store.DqrStore;
import com.didi.zxing.barcodescanner.store.DqrStoreConstants;
import com.didi.zxing.barcodescanner.tasker.ZxingRunnable;
import com.didi.zxing.barcodescanner.trace.ScanTrace;
import com.didi.zxing.barcodescanner.trace.ScanTraceId;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MultiDecoderThread implements DecodeThreadInter {

    /* renamed from: a */
    private static final String f45287a = "MultiDecoderThread";

    /* renamed from: b */
    private static final int f45288b = 3;

    /* renamed from: c */
    private CameraInstance f45289c;

    /* renamed from: d */
    private HandlerThread f45290d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f45291e;

    /* renamed from: f */
    private Decoder f45292f;

    /* renamed from: g */
    private Handler f45293g;

    /* renamed from: h */
    private Rect f45294h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f45295i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Object f45296j = new Object();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public BalanceExecutor<ZxingRunnable> f45297k;

    /* renamed from: l */
    private volatile BinarizerEnum f45298l;

    /* renamed from: m */
    private MultiFormatReader f45299m;

    /* renamed from: n */
    private int f45300n = 2000;

    /* renamed from: o */
    private String f45301o;

    /* renamed from: p */
    private volatile long f45302p;

    /* renamed from: q */
    private long f45303q;

    /* renamed from: r */
    private boolean f45304r = true;

    /* renamed from: s */
    private Context f45305s;

    /* renamed from: t */
    private String f45306t;

    /* renamed from: u */
    private volatile boolean f45307u;

    /* renamed from: v */
    private List<ScanResultObserver> f45308v;

    /* renamed from: w */
    private volatile int f45309w;

    /* renamed from: x */
    private final Handler.Callback f45310x = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message != null) {
                try {
                    if (MultiDecoderThread.this.f45295i) {
                        if (message.what == R.id.zxing_decode) {
                            ZxingRunnable zxingRunnable = (ZxingRunnable) MultiDecoderThread.this.f45297k.obtain();
                            if (zxingRunnable == null) {
                                zxingRunnable = new ZxingRunnable((SourceData) message.obj) {
                                    public void execute() {
                                        try {
                                            MultiDecoderThread.this.m32525a(getSource());
                                        } catch (Exception unused) {
                                        }
                                    }
                                };
                            } else {
                                zxingRunnable.setSource((SourceData) message.obj);
                            }
                            MultiDecoderThread.this.f45297k.execute(zxingRunnable);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return true;
        }
    };

    /* renamed from: y */
    private final PreviewCallback f45311y = new PreviewCallback() {
        public boolean oneShot() {
            return false;
        }

        public void onPreview(SourceData sourceData) {
            synchronized (MultiDecoderThread.this.f45296j) {
                if (MultiDecoderThread.this.f45295i) {
                    MultiDecoderThread.this.f45291e.obtainMessage(R.id.zxing_decode, sourceData).sendToTarget();
                }
            }
        }

        public void onPreviewError(Exception exc) {
            synchronized (MultiDecoderThread.this.f45296j) {
                if (MultiDecoderThread.this.f45295i) {
                    MultiDecoderThread.this.f45291e.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                }
            }
        }
    };

    public MultiDecoderThread(Context context, CameraInstance cameraInstance, Decoder decoder, Handler handler) {
        C14921Util.validateMainThread();
        this.f45305s = context.getApplicationContext();
        this.f45289c = cameraInstance;
        this.f45292f = decoder;
        this.f45293g = handler;
        Map<DecodeHintType, ?> a = m32522a(decoder.getDecodeOptions());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f45299m = multiFormatReader;
        multiFormatReader.setHints(a);
        this.f45299m.setDecodeOptions(decoder.getDecodeOptions());
        AnalysisManager.setDecodeId(UUID.randomUUID().toString());
        ServiceLoader<S> load = ServiceLoader.load(ScanResultObserver.class);
        if (load != null) {
            this.f45308v = new ArrayList();
            Iterator<S> it = load.iterator();
            while (it.hasNext()) {
                this.f45308v.add((ScanResultObserver) it.next());
            }
        }
    }

    /* renamed from: a */
    private Map<DecodeHintType, ?> m32522a(DecodeOptions decodeOptions) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        if (decodeOptions.baseHints != null) {
            enumMap.putAll(decodeOptions.baseHints);
        }
        if (decodeOptions.decodeFormats == null || decodeOptions.decodeFormats.isEmpty()) {
            decodeOptions.decodeFormats = EnumSet.of(BarcodeFormat.QR_CODE);
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, decodeOptions.decodeFormats);
        enumMap.put(DecodeHintType.TRY_HARDER, Boolean.FALSE);
        if (decodeOptions.characterSet != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, decodeOptions.characterSet);
        }
        return enumMap;
    }

    public Decoder getDecoder() {
        return this.f45292f;
    }

    public void setDecoder(Decoder decoder) {
        this.f45292f = decoder;
    }

    public Rect getCropRect() {
        return this.f45294h;
    }

    public void setCropRect(Rect rect) {
        String str;
        this.f45294h = rect;
        if (rect == null) {
            str = "null";
        } else {
            str = rect.toString();
        }
        SystemUtils.log(3, f45287a, "setCropRect " + str, (Throwable) null, "com.didi.zxing.barcodescanner.MultiDecoderThread", 170);
    }

    public void start() {
        C14921Util.validateMainThread();
        if (this.f45290d == null) {
            HandlerThread handlerThread = new HandlerThread(f45287a);
            this.f45290d = handlerThread;
            handlerThread.start();
            this.f45291e = new Handler(this.f45290d.getLooper(), this.f45310x);
            DecodeConfig config = DecodeConfigUtil.getConfig();
            int i = DqrStore.getInstance().getInt(this.f45305s, DqrStoreConstants.KEY_INTERVAL, 100);
            if (config == null || !config.threadCountRelatedCpu()) {
                this.f45297k = new BalanceExecutor(this.f45305s, 3, 3, 3, 100);
            } else {
                int availableProcessors = Runtime.getRuntime().availableProcessors();
                int i2 = DqrStore.getInstance().getInt(this.f45305s, DqrStoreConstants.KEY_POOLSIZE, 3);
                this.f45297k = new BalanceExecutor(this.f45305s, 3, Math.max(3, availableProcessors + 2), i2, i);
            }
        }
        this.f45295i = true;
        m32523a();
        this.f45303q = SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        hashMap.put("productId", this.f45306t);
        ScanTrace.trace(ScanTraceId.SCAN_START, hashMap);
    }

    public void stop() {
        C14921Util.validateMainThread();
        this.f45295i = false;
        List<ScanResultObserver> list = this.f45308v;
        if (list != null && list.size() > 0) {
            for (ScanResultObserver onCancel : this.f45308v) {
                onCancel.onCancel();
            }
        }
        synchronized (this.f45296j) {
            this.f45291e.removeCallbacksAndMessages((Object) null);
            this.f45290d.quit();
            this.f45290d = null;
            this.f45297k.destroy();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("productId", this.f45306t);
        ScanTrace.trace(ScanTraceId.SCAN_STOP, hashMap);
    }

    /* renamed from: a */
    private void m32523a() {
        CameraInstance cameraInstance = this.f45289c;
        if (cameraInstance != null && cameraInstance.isOpen()) {
            this.f45289c.requestPreview(this.f45311y);
        }
    }

    /* access modifiers changed from: protected */
    public LuminanceSource createSource(SourceData sourceData) {
        if (this.f45294h == null && sourceData.getCropRect() == null) {
            sourceData.setCropRect(new Rect(0, 0, sourceData.getDataWidth(), sourceData.getDataHeight()));
        }
        return sourceData.createSource();
    }

    public void pause() {
        this.f45295i = false;
        CameraInstance cameraInstance = this.f45289c;
        if (cameraInstance != null && cameraInstance.isOpen()) {
            this.f45289c.removePreviewCallBack();
        }
        DqrStore.getInstance().putAndSave(this.f45305s, DqrStoreConstants.KEY_INTERVAL, this.f45297k.getInitInterval());
        DqrStore.getInstance().putAndSave(this.f45305s, DqrStoreConstants.KEY_POOLSIZE, this.f45297k.getPoolSize());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m32525a(com.didi.zxing.barcodescanner.SourceData r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            long r8 = java.lang.System.currentTimeMillis()
            int r2 = r1.f45309w
            r10 = 1
            int r2 = r2 + r10
            r1.f45309w = r2
            android.graphics.Rect r2 = r1.f45294h
            r0.setCropRect(r2)
            com.didi.dqr.LuminanceSource r2 = r25.createSource(r26)
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            if (r2 == 0) goto L_0x0383
            int r4 = com.didi.dqrutil.DqrConfigHelper.useNativeDecodeRate()
            r5 = 0
            r6 = 0
            if (r4 <= 0) goto L_0x0054
            int r4 = r1.f45309w
            int r7 = com.didi.dqrutil.DqrConfigHelper.useNativeDecodeRate()
            int r4 = r4 % r7
            if (r4 != 0) goto L_0x0054
            com.didi.dqr.NativeDecode r2 = new com.didi.dqr.NativeDecode
            r2.<init>()
            int r4 = r26.getDataWidth()
            int r7 = r26.getDataHeight()
            byte[] r11 = r26.getData()
            java.lang.String r4 = r2.decode(r4, r7, r11)
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x004d
            com.didi.dqr.Result r7 = new com.didi.dqr.Result
            r7.<init>(r4, r6, r6, r6)
            r6 = r7
        L_0x004d:
            r2.destroy()
        L_0x0050:
            r11 = r3
            r12 = r6
            goto L_0x01cb
        L_0x0054:
            int[] r3 = com.didi.zxing.barcodescanner.MultiDecoderThread.C149193.$SwitchMap$com$didi$dqr$BinarizerEnum
            com.didi.zxing.barcodescanner.Decoder r4 = r1.f45292f
            com.didi.dqr.DecodeOptions r4 = r4.getDecodeOptions()
            com.didi.dqr.BinarizerEnum r4 = r4.binarizer
            int r4 = r4.ordinal()
            r3 = r3[r4]
            if (r3 == r10) goto L_0x0117
            r4 = 2
            if (r3 == r4) goto L_0x0106
            r4 = 3
            if (r3 == r4) goto L_0x00a3
            r4 = 4
            if (r3 == r4) goto L_0x00de
            r4 = 5
            if (r3 == r4) goto L_0x0073
            goto L_0x0094
        L_0x0073:
            boolean r3 = com.didi.dqr.OpenCVBinarizer.isLoadLibraryError()
            if (r3 != 0) goto L_0x0094
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.OpenCV
            com.didi.dqr.OpenCVBinarizer r4 = new com.didi.dqr.OpenCVBinarizer
            r4.<init>(r2)
            com.didi.zxing.barcodescanner.DecodeConfig r2 = com.didi.util.DecodeConfigUtil.getConfig()
            if (r2 == 0) goto L_0x008d
            float r2 = r2.cvBlockSizeFact()
            r4.setBlockSizeFact(r2)
        L_0x008d:
            com.didi.dqr.BinaryBitmap r2 = new com.didi.dqr.BinaryBitmap
            r2.<init>(r4)
            goto L_0x0129
        L_0x0094:
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r7 = new com.didi.dqr.common.HybridBinarizer
            r7.<init>(r2)
            r4.<init>(r7)
        L_0x00a0:
            r2 = r4
            goto L_0x0129
        L_0x00a3:
            boolean r3 = com.didi.dqr.OpenCVBinarizer.isLoadLibraryError()
            if (r3 != 0) goto L_0x00de
            com.didi.dqr.BinarizerEnum r3 = r1.f45298l
            com.didi.dqr.BinarizerEnum r4 = com.didi.dqr.BinarizerEnum.OpenCV
            if (r3 != r4) goto L_0x00c0
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r1.f45298l = r3
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r7 = new com.didi.dqr.common.HybridBinarizer
            r7.<init>(r2)
            r4.<init>(r7)
            goto L_0x00a0
        L_0x00c0:
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.OpenCV
            r1.f45298l = r3
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.OpenCV
            com.didi.dqr.OpenCVBinarizer r4 = new com.didi.dqr.OpenCVBinarizer
            r4.<init>(r2)
            com.didi.zxing.barcodescanner.DecodeConfig r2 = com.didi.util.DecodeConfigUtil.getConfig()
            if (r2 == 0) goto L_0x00d8
            float r2 = r2.cvBlockSizeFact()
            r4.setBlockSizeFact(r2)
        L_0x00d8:
            com.didi.dqr.BinaryBitmap r2 = new com.didi.dqr.BinaryBitmap
            r2.<init>(r4)
            goto L_0x0129
        L_0x00de:
            com.didi.dqr.BinarizerEnum r3 = r1.f45298l
            com.didi.dqr.BinarizerEnum r4 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            if (r3 != r4) goto L_0x00f5
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r1.f45298l = r3
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r7 = new com.didi.dqr.common.HybridBinarizer
            r7.<init>(r2)
            r4.<init>(r7)
            goto L_0x00a0
        L_0x00f5:
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            r1.f45298l = r3
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.GlobalHistogramBinarizer r7 = new com.didi.dqr.common.GlobalHistogramBinarizer
            r7.<init>(r2)
            r4.<init>(r7)
            goto L_0x00a0
        L_0x0106:
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            r1.f45298l = r3
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.GlobalHistogramBinarizer r7 = new com.didi.dqr.common.GlobalHistogramBinarizer
            r7.<init>(r2)
            r4.<init>(r7)
            goto L_0x00a0
        L_0x0117:
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r1.f45298l = r3
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r7 = new com.didi.dqr.common.HybridBinarizer
            r7.<init>(r2)
            r4.<init>(r7)
            goto L_0x00a0
        L_0x0129:
            com.didi.dqr.MultiFormatReader r4 = r1.f45299m     // Catch:{ Exception -> 0x0137, all -> 0x0130 }
            com.didi.dqr.Result r6 = r4.decodeWithState(r2)     // Catch:{ Exception -> 0x0137, all -> 0x0130 }
            goto L_0x0137
        L_0x0130:
            r0 = move-exception
            com.didi.dqr.MultiFormatReader r2 = r1.f45299m
            r2.reset()
            throw r0
        L_0x0137:
            com.didi.dqr.MultiFormatReader r2 = r1.f45299m
            r2.reset()
            if (r6 == 0) goto L_0x0050
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Type = "
            r2.append(r4)
            com.didi.dqr.BarcodeFormat r4 = r6.getBarcodeFormat()
            java.lang.String r4 = r4.name()
            r2.append(r4)
            java.lang.String r4 = " rawResult = "
            r2.append(r4)
            java.lang.String r4 = r6.getText()
            r2.append(r4)
            java.lang.String r13 = r2.toString()
            r11 = 3
            r14 = 0
            r16 = 362(0x16a, float:5.07E-43)
            java.lang.String r12 = "rawResult"
            java.lang.String r15 = "com.didi.zxing.barcodescanner.MultiDecoderThread"
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)
            java.lang.String r2 = r6.getText()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0050
            boolean r2 = r1.f45304r
            if (r2 == 0) goto L_0x0050
            com.didi.dqr.ResultPoint[] r2 = r6.getResultPoints()
            if (r2 == 0) goto L_0x0050
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.didi.dqr.ResultPoint[] r4 = r6.getResultPoints()
            int r7 = r4.length
            r11 = 0
        L_0x018d:
            if (r11 >= r7) goto L_0x019d
            r12 = r4[r11]
            boolean r13 = r12 instanceof com.didi.dqr.qrcode.detector.FinderPattern
            if (r13 == 0) goto L_0x019a
            com.didi.dqr.qrcode.detector.FinderPattern r12 = (com.didi.dqr.qrcode.detector.FinderPattern) r12
            r2.add(r12)
        L_0x019a:
            int r11 = r11 + 1
            goto L_0x018d
        L_0x019d:
            com.didi.dqr.qrcode.detector.FinderPattern r2 = com.didi.dqr.qrcode.detector.FindBestPatternUtil.findBestPattern(r2)
            com.didi.zxing.barcodescanner.DecodeConfig r4 = com.didi.util.DecodeConfigUtil.getConfig()
            if (r2 == 0) goto L_0x0050
            if (r4 == 0) goto L_0x0050
            int r7 = r2.getCount()
            int r4 = r4.patternMinValidCount()
            if (r7 <= r4) goto L_0x0050
            r1.f45304r = r5
            android.os.Handler r4 = r1.f45293g
            r7 = 2131435911(0x7f0b2187, float:1.8493678E38)
            android.os.Message r2 = android.os.Message.obtain(r4, r7, r2)
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r2.setData(r4)
            r2.sendToTarget()
            goto L_0x0050
        L_0x01cb:
            boolean r2 = r1.f45295i
            if (r2 != 0) goto L_0x01d0
            return
        L_0x01d0:
            if (r12 == 0) goto L_0x01de
            java.lang.String r2 = r12.getText()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01de
            r13 = 1
            goto L_0x01df
        L_0x01de:
            r13 = 0
        L_0x01df:
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r1.f45303q
            long r14 = r2 - r4
            long r5 = android.os.SystemClock.elapsedRealtime()
            java.util.List<com.didi.util.ScanResultObserver> r2 = r1.f45308v
            if (r2 == 0) goto L_0x0220
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0220
            java.util.List<com.didi.util.ScanResultObserver> r2 = r1.f45308v
            java.util.Iterator r16 = r2.iterator()
        L_0x01fb:
            boolean r2 = r16.hasNext()
            if (r2 == 0) goto L_0x0220
            java.lang.Object r2 = r16.next()
            com.didi.util.ScanResultObserver r2 = (com.didi.util.ScanResultObserver) r2
            if (r13 == 0) goto L_0x0213
            r3 = r5
            r17 = r5
            r5 = r14
            r7 = r26
            r2.onScanSuccess(r3, r5, r7)
            goto L_0x021d
        L_0x0213:
            r17 = r5
            r3 = r17
            r5 = r14
            r7 = r26
            r2.onScanFail(r3, r5, r7)
        L_0x021d:
            r5 = r17
            goto L_0x01fb
        L_0x0220:
            r17 = r5
            if (r13 == 0) goto L_0x0374
            java.lang.String r2 = r1.f45301o
            java.lang.String r3 = r12.getText()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x023f
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r1.f45302p
            long r2 = r2 - r4
            int r4 = r1.f45300n
            long r4 = (long) r4
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x023f
            return
        L_0x023f:
            java.lang.String r2 = r12.getText()
            r1.m32526a((java.lang.String) r2)
            java.lang.String r2 = r12.getText()
            r1.f45301o = r2
            long r2 = android.os.SystemClock.elapsedRealtime()
            r1.f45302p = r2
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Found barcode in "
            r4.append(r5)
            long r2 = r2 - r8
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r21 = r4.toString()
            r19 = 3
            r22 = 0
            r24 = 410(0x19a, float:5.75E-43)
            java.lang.String r20 = "MultiDecoderThread"
            java.lang.String r23 = "com.didi.zxing.barcodescanner.MultiDecoderThread"
            com.didi.sdk.apm.SystemUtils.log(r19, r20, r21, r22, r23, r24)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "opencv "
            r2.append(r3)
            int r3 = com.didi.dqr.OpenCVBinarizer.blockSize
            r2.append(r3)
            java.lang.String r6 = r2.toString()
            r4 = 3
            r7 = 0
            r9 = 411(0x19b, float:5.76E-43)
            java.lang.String r5 = "MultiDecoderThread"
            java.lang.String r8 = "com.didi.zxing.barcodescanner.MultiDecoderThread"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            android.os.Handler r2 = r1.f45293g
            if (r2 == 0) goto L_0x0390
            com.didi.zxing.barcodescanner.BarcodeResult r2 = new com.didi.zxing.barcodescanner.BarcodeResult
            r3 = r17
            r2.<init>(r12, r0, r3)
            android.os.Handler r0 = r1.f45293g
            r3 = 2131435909(0x7f0b2185, float:1.8493673E38)
            android.os.Message r0 = android.os.Message.obtain(r0, r3, r2)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r0.setData(r2)
            r0.sendToTarget()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.didi.dqr.BinarizerEnum r2 = r1.f45298l
            com.didi.dqr.BinarizerEnum r3 = com.didi.dqr.BinarizerEnum.OpenCV
            java.lang.String r4 = "cvBlockSize"
            if (r2 != r3) goto L_0x02cd
            int r2 = com.didi.dqr.OpenCVBinarizer.blockSize
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r4, r2)
        L_0x02cd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "cost"
            r0.put(r5, r2)
            java.lang.String r2 = r11.name()
            java.lang.String r6 = "realBinarizerType"
            r0.put(r6, r2)
            int r2 = r12.contourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r7 = "contourDilateCount"
            r0.put(r7, r2)
            int r2 = r12.realContourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r8 = "realContourDilateCount"
            r0.put(r8, r2)
            boolean r2 = r12.isQRCode
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r9 = "isQRCode"
            r0.put(r9, r2)
            java.lang.String r2 = r1.f45306t
            java.lang.String r11 = "productId"
            r0.put(r11, r2)
            java.lang.String r2 = "dqr_scan_success"
            com.didi.zxing.barcodescanner.trace.ScanTrace.trace(r2, r0)
            boolean r0 = r1.f45307u
            if (r0 == 0) goto L_0x0371
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.didi.dqr.BinarizerEnum r2 = r1.f45298l
            com.didi.dqr.BinarizerEnum r13 = com.didi.dqr.BinarizerEnum.OpenCV
            if (r2 != r13) goto L_0x0331
            int r2 = com.didi.dqr.OpenCVBinarizer.blockSize
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r4, r2)
        L_0x0331:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.put(r5, r2)
            com.didi.dqr.BinarizerEnum r2 = r1.f45298l
            java.lang.String r2 = r2.name()
            r0.put(r6, r2)
            int r2 = r12.contourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r7, r2)
            int r2 = r12.realContourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r8, r2)
            boolean r2 = r12.isQRCode
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.put(r9, r2)
            java.lang.String r2 = r1.f45306t
            r0.put(r11, r2)
            java.lang.String r2 = "dqr_scan_duplicate"
            com.didi.zxing.barcodescanner.trace.ScanTrace.trace(r2, r0)
        L_0x0371:
            r1.f45307u = r10
            goto L_0x0390
        L_0x0374:
            android.os.Handler r0 = r1.f45293g
            if (r0 == 0) goto L_0x0390
            r2 = 2131435908(0x7f0b2184, float:1.8493671E38)
            android.os.Message r0 = android.os.Message.obtain(r0, r2)
            r0.sendToTarget()
            goto L_0x0390
        L_0x0383:
            r2 = 5
            r5 = 0
            r7 = 453(0x1c5, float:6.35E-43)
            java.lang.String r3 = "zxing"
            java.lang.String r4 = "source = null"
            java.lang.String r6 = "com.didi.zxing.barcodescanner.MultiDecoderThread"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x0390:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.barcodescanner.MultiDecoderThread.m32525a(com.didi.zxing.barcodescanner.SourceData):void");
    }

    /* renamed from: com.didi.zxing.barcodescanner.MultiDecoderThread$3 */
    static /* synthetic */ class C149193 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dqr$BinarizerEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.dqr.BinarizerEnum[] r0 = com.didi.dqr.BinarizerEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dqr$BinarizerEnum = r0
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.HybridBinarizer     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.CommixtureWithOpenCV     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.Commixture     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.OpenCV     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.barcodescanner.MultiDecoderThread.C149193.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m32526a(String str) {
        String str2;
        if (str.contains(ScanTraceId.CodeType.NOKELOCK)) {
            str2 = "NOKELOCK";
        } else if (str.contains(ScanTraceId.CodeType.BLUEGOGO)) {
            str2 = "BLUEGOGO";
        } else if (str.contains(ScanTraceId.CodeType.OFO)) {
            str2 = "OFO";
        } else {
            str2 = str.contains(ScanTraceId.CodeType.f45451BH) ? "BH" : "other";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("productId", this.f45306t);
        hashMap.put("type", str2);
        ScanTrace.trace(ScanTraceId.SCAN_CODETYPE, hashMap);
    }

    public void setCheckPattern(boolean z) {
        this.f45304r = z;
    }

    public void setProductId(String str) {
        if (str == null) {
            str = "notSet";
        }
        this.f45306t = str;
    }
}
