package com.didi.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinarizerEnum;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.MultiFormatReader;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didi.zxing.barcodescanner.Decoder;
import com.didi.zxing.barcodescanner.SourceData;
import com.didi.zxing.barcodescanner.executor.BalanceExecutor;
import com.didi.zxing.barcodescanner.executor.BalanceRunnable;
import com.didi.zxing.barcodescanner.store.DqrStore;
import com.didi.zxing.barcodescanner.store.DqrStoreConstants;
import com.didi.zxing.barcodescanner.tasker.ZxingRunnable;
import com.didi.zxing.barcodescanner.trace.ScanTrace;
import com.didi.zxing.barcodescanner.trace.ScanTraceId;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

class ImageDecoderExecutor {

    /* renamed from: a */
    private static final String f45145a = "ImageDecoderExecutor";

    /* renamed from: b */
    private static final int f45146b = 3;

    /* renamed from: c */
    private Decoder f45147c;

    /* renamed from: d */
    private Rect f45148d;

    /* renamed from: e */
    private volatile boolean f45149e = false;

    /* renamed from: f */
    private final Object f45150f = new Object();

    /* renamed from: g */
    private BalanceExecutor<ZxingRunnable> f45151g;

    /* renamed from: h */
    private BinarizerEnum f45152h;

    /* renamed from: i */
    private MultiFormatReader f45153i;

    /* renamed from: j */
    private int f45154j = Integer.MAX_VALUE;

    /* renamed from: k */
    private String f45155k;

    /* renamed from: l */
    private volatile long f45156l;

    /* renamed from: m */
    private long f45157m;

    /* renamed from: n */
    private Context f45158n;

    /* renamed from: o */
    private String f45159o;

    /* renamed from: p */
    private volatile boolean f45160p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public DecodeCallBack f45161q;

    /* renamed from: r */
    private HandlerThread f45162r;

    /* renamed from: s */
    private Handler f45163s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public SourceData f45164t;

    public interface DecodeCallBack {
        void onResult(String str);

        void onTimeout();
    }

    public ImageDecoderExecutor(Context context, Decoder decoder, DecodeCallBack decodeCallBack) {
        this.f45158n = context.getApplicationContext();
        this.f45147c = decoder;
        this.f45161q = decodeCallBack;
        Map<DecodeHintType, ?> a = m32428a(decoder.getDecodeOptions());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f45153i = multiFormatReader;
        multiFormatReader.setHints(a);
    }

    /* renamed from: a */
    private Map<DecodeHintType, ?> m32428a(DecodeOptions decodeOptions) {
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

    /* renamed from: a */
    public Rect mo113340a() {
        return this.f45148d;
    }

    /* renamed from: a */
    public void mo113342a(Rect rect) {
        String str;
        this.f45148d = rect;
        if (rect == null) {
            str = "null";
        } else {
            str = rect.toString();
        }
        SystemUtils.log(3, f45145a, "setCropRect " + str, (Throwable) null, "com.didi.util.ImageDecoderExecutor", 107);
    }

    /* renamed from: a */
    public void mo113343a(SourceData sourceData, long j) {
        this.f45164t = sourceData;
        this.f45149e = true;
        if (this.f45162r == null) {
            HandlerThread handlerThread = new HandlerThread(f45145a);
            this.f45162r = handlerThread;
            handlerThread.start();
            this.f45163s = new Handler(this.f45162r.getLooper());
            DecodeConfig config = DecodeConfigUtil.getConfig();
            int i = DqrStore.getInstance().getInt(this.f45158n, DqrStoreConstants.KEY_INTERVAL, 100);
            int i2 = 3;
            if (config == null || !config.threadCountRelatedCpu()) {
                this.f45151g = new BalanceExecutor(this.f45158n, 3, 3, 3, 100) {
                    public void onFinish(BalanceRunnable balanceRunnable, long j) {
                        super.onFinish(balanceRunnable, j);
                        ImageDecoderExecutor.this.m32436d();
                        ImageDecoderExecutor.this.m32436d();
                    }
                };
            } else {
                int availableProcessors = Runtime.getRuntime().availableProcessors();
                int i3 = DqrStore.getInstance().getInt(this.f45158n, DqrStoreConstants.KEY_POOLSIZE, 3);
                i2 = Math.max(3, availableProcessors + 2);
                this.f45151g = new BalanceExecutor(this.f45158n, 3, i2, i3, i) {
                    public void onFinish(BalanceRunnable balanceRunnable, long j) {
                        super.onFinish(balanceRunnable, j);
                        ImageDecoderExecutor.this.m32436d();
                        ImageDecoderExecutor.this.m32436d();
                    }
                };
            }
            for (int i4 = 0; i4 < i2; i4++) {
                m32433b(sourceData);
            }
        }
        this.f45157m = SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        hashMap.put("productId", this.f45159o);
        ScanTrace.trace(ScanTraceId.SCAN_START, hashMap);
        this.f45163s.postDelayed(new Runnable() {
            public void run() {
                if (ImageDecoderExecutor.this.f45161q != null) {
                    ImageDecoderExecutor.this.f45161q.onTimeout();
                }
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m32436d() {
        if (this.f45149e) {
            this.f45163s.post(new Runnable() {
                public void run() {
                    ImageDecoderExecutor imageDecoderExecutor = ImageDecoderExecutor.this;
                    imageDecoderExecutor.m32433b(imageDecoderExecutor.f45164t);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32433b(SourceData sourceData) {
        ZxingRunnable obtain = this.f45151g.obtain();
        if (obtain == null) {
            obtain = new ZxingRunnable(sourceData) {
                public void execute() {
                    try {
                        ImageDecoderExecutor.this.m32435c(getSource());
                    } catch (Exception e) {
                        e.printStackTrace();
                        SystemUtils.log(3, ImageDecoderExecutor.f45145a, "error = " + e.toString(), (Throwable) null, "com.didi.util.ImageDecoderExecutor$5", 189);
                    }
                }
            };
        } else {
            obtain.setSource(sourceData);
        }
        this.f45151g.execute(obtain);
    }

    /* renamed from: b */
    public void mo113345b() {
        this.f45149e = false;
        synchronized (this.f45150f) {
            if (this.f45162r != null) {
                this.f45163s.removeCallbacksAndMessages((Object) null);
                this.f45162r.quit();
                this.f45162r = null;
                this.f45151g.destroy();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("productId", this.f45159o);
        ScanTrace.trace(ScanTraceId.SCAN_STOP, hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LuminanceSource mo113341a(SourceData sourceData) {
        if (this.f45148d == null && sourceData.getCropRect() == null) {
            sourceData.setCropRect(new Rect(0, 0, sourceData.getDataWidth(), sourceData.getDataHeight()));
        }
        return sourceData.createSource();
    }

    /* renamed from: c */
    public void mo113346c() {
        this.f45149e = false;
        DqrStore.getInstance().putAndSave(this.f45158n, DqrStoreConstants.KEY_INTERVAL, this.f45151g.getInitInterval());
        DqrStore.getInstance().putAndSave(this.f45158n, DqrStoreConstants.KEY_POOLSIZE, this.f45151g.getPoolSize());
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010f  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m32435c(com.didi.zxing.barcodescanner.SourceData r15) {
        /*
            r14 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.graphics.Rect r2 = r14.f45148d
            r15.setCropRect(r2)
            com.didi.dqr.LuminanceSource r15 = r14.mo113341a((com.didi.zxing.barcodescanner.SourceData) r15)
            if (r15 == 0) goto L_0x028c
            int[] r2 = com.didi.util.ImageDecoderExecutor.C148476.$SwitchMap$com$didi$dqr$BinarizerEnum
            com.didi.zxing.barcodescanner.Decoder r3 = r14.f45147c
            com.didi.dqr.DecodeOptions r3 = r3.getDecodeOptions()
            com.didi.dqr.BinarizerEnum r3 = r3.binarizer
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto L_0x00d3
            r4 = 2
            if (r2 == r4) goto L_0x00c2
            r4 = 3
            if (r2 == r4) goto L_0x005f
            r4 = 4
            if (r2 == r4) goto L_0x009a
            r4 = 5
            if (r2 == r4) goto L_0x002f
            goto L_0x0050
        L_0x002f:
            boolean r2 = com.didi.dqr.OpenCVBinarizer.isLoadLibraryError()
            if (r2 != 0) goto L_0x0050
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.OpenCV
            com.didi.dqr.OpenCVBinarizer r4 = new com.didi.dqr.OpenCVBinarizer
            r4.<init>(r15)
            com.didi.zxing.barcodescanner.DecodeConfig r15 = com.didi.util.DecodeConfigUtil.getConfig()
            if (r15 == 0) goto L_0x0049
            float r15 = r15.cvBlockSizeFact()
            r4.setBlockSizeFact(r15)
        L_0x0049:
            com.didi.dqr.BinaryBitmap r15 = new com.didi.dqr.BinaryBitmap
            r15.<init>(r4)
            goto L_0x00e5
        L_0x0050:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
        L_0x005c:
            r15 = r4
            goto L_0x00e5
        L_0x005f:
            boolean r2 = com.didi.dqr.OpenCVBinarizer.isLoadLibraryError()
            if (r2 != 0) goto L_0x009a
            com.didi.dqr.BinarizerEnum r2 = r14.f45152h
            com.didi.dqr.BinarizerEnum r4 = com.didi.dqr.BinarizerEnum.OpenCV
            if (r2 != r4) goto L_0x007c
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r14.f45152h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x007c:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.OpenCV
            r14.f45152h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.OpenCV
            com.didi.dqr.OpenCVBinarizer r4 = new com.didi.dqr.OpenCVBinarizer
            r4.<init>(r15)
            com.didi.zxing.barcodescanner.DecodeConfig r15 = com.didi.util.DecodeConfigUtil.getConfig()
            if (r15 == 0) goto L_0x0094
            float r15 = r15.cvBlockSizeFact()
            r4.setBlockSizeFact(r15)
        L_0x0094:
            com.didi.dqr.BinaryBitmap r15 = new com.didi.dqr.BinaryBitmap
            r15.<init>(r4)
            goto L_0x00e5
        L_0x009a:
            com.didi.dqr.BinarizerEnum r2 = r14.f45152h
            com.didi.dqr.BinarizerEnum r4 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            if (r2 != r4) goto L_0x00b1
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r14.f45152h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00b1:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            r14.f45152h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.GlobalHistogramBinarizer r5 = new com.didi.dqr.common.GlobalHistogramBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00c2:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            r14.f45152h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.GlobalHistogramBinarizer r5 = new com.didi.dqr.common.GlobalHistogramBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00d3:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r14.f45152h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00e5:
            com.didi.dqr.MultiFormatReader r4 = r14.f45153i     // Catch:{ ReaderException -> 0x00f8, all -> 0x00f1 }
            com.didi.dqr.Result r15 = r4.decodeWithState(r15)     // Catch:{ ReaderException -> 0x00f8, all -> 0x00f1 }
            com.didi.dqr.MultiFormatReader r4 = r14.f45153i
            r4.reset()
            goto L_0x00fe
        L_0x00f1:
            r15 = move-exception
            com.didi.dqr.MultiFormatReader r0 = r14.f45153i
            r0.reset()
            throw r15
        L_0x00f8:
            com.didi.dqr.MultiFormatReader r15 = r14.f45153i
            r15.reset()
            r15 = 0
        L_0x00fe:
            if (r15 == 0) goto L_0x0299
            java.lang.String r4 = r15.getText()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0299
            boolean r4 = r14.f45149e
            if (r4 != 0) goto L_0x010f
            return
        L_0x010f:
            java.lang.String r4 = r14.f45155k
            java.lang.String r5 = r15.getText()
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x012a
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r14.f45156l
            long r4 = r4 - r6
            int r6 = r14.f45154j
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x012a
            return
        L_0x012a:
            java.lang.String r4 = r15.getText()
            r14.f45155k = r4
            long r4 = android.os.SystemClock.elapsedRealtime()
            r14.f45156l = r4
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Found barcode in "
            r6.append(r7)
            long r4 = r4 - r0
            r6.append(r4)
            java.lang.String r0 = " ms"
            r6.append(r0)
            java.lang.String r9 = r6.toString()
            r7 = 3
            r10 = 0
            r12 = 315(0x13b, float:4.41E-43)
            java.lang.String r8 = "ImageDecoderExecutor"
            java.lang.String r11 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "opencv "
            r0.append(r1)
            int r1 = com.didi.dqr.OpenCVBinarizer.blockSize
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r4 = 3
            r7 = 0
            r9 = 316(0x13c, float:4.43E-43)
            java.lang.String r5 = "ImageDecoderExecutor"
            java.lang.String r8 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "type "
            r0.append(r1)
            java.lang.String r1 = r2.name()
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r9 = 317(0x13d, float:4.44E-43)
            java.lang.String r5 = "ImageDecoderExecutor"
            java.lang.String r8 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ret "
            r0.append(r1)
            java.lang.String r1 = r15.getText()
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r9 = 318(0x13e, float:4.46E-43)
            java.lang.String r5 = "ImageDecoderExecutor"
            java.lang.String r8 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            com.didi.util.ImageDecoderExecutor$DecodeCallBack r0 = r14.f45161q
            if (r0 == 0) goto L_0x0288
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r4 = r14.f45157m
            long r0 = r0 - r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.didi.dqr.BinarizerEnum r5 = r14.f45152h
            com.didi.dqr.BinarizerEnum r6 = com.didi.dqr.BinarizerEnum.OpenCV
            java.lang.String r7 = "cvBlockSize"
            if (r5 != r6) goto L_0x01d7
            int r5 = com.didi.dqr.OpenCVBinarizer.blockSize
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r7, r5)
        L_0x01d7:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r6 = ""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r8 = "cost"
            r4.put(r8, r5)
            java.lang.String r2 = r2.name()
            java.lang.String r5 = "realBinarizerType"
            r4.put(r5, r2)
            int r2 = r15.contourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r9 = "contourDilateCount"
            r4.put(r9, r2)
            int r2 = r15.realContourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r10 = "realContourDilateCount"
            r4.put(r10, r2)
            boolean r2 = r15.isQRCode
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r11 = "isQRCode"
            r4.put(r11, r2)
            java.lang.String r2 = r14.f45159o
            java.lang.String r12 = "productId"
            r4.put(r12, r2)
            java.lang.String r2 = "dqr_scan_success"
            com.didi.zxing.barcodescanner.trace.ScanTrace.trace(r2, r4)
            boolean r2 = r14.f45160p
            if (r2 == 0) goto L_0x027b
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.didi.dqr.BinarizerEnum r4 = r14.f45152h
            com.didi.dqr.BinarizerEnum r13 = com.didi.dqr.BinarizerEnum.OpenCV
            if (r4 != r13) goto L_0x023b
            int r4 = com.didi.dqr.OpenCVBinarizer.blockSize
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.put(r7, r4)
        L_0x023b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r6)
            java.lang.String r0 = r4.toString()
            r2.put(r8, r0)
            com.didi.dqr.BinarizerEnum r0 = r14.f45152h
            java.lang.String r0 = r0.name()
            r2.put(r5, r0)
            int r0 = r15.contourDilateCount
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r9, r0)
            int r0 = r15.realContourDilateCount
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r10, r0)
            boolean r0 = r15.isQRCode
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2.put(r11, r0)
            java.lang.String r0 = r14.f45159o
            r2.put(r12, r0)
            java.lang.String r0 = "dqr_scan_duplicate"
            com.didi.zxing.barcodescanner.trace.ScanTrace.trace(r0, r2)
        L_0x027b:
            r14.f45160p = r3
            com.didi.util.ImageDecoderExecutor$DecodeCallBack r0 = r14.f45161q
            if (r0 == 0) goto L_0x0288
            java.lang.String r15 = r15.getText()
            r0.onResult(r15)
        L_0x0288:
            r14.mo113345b()
            goto L_0x0299
        L_0x028c:
            r1 = 5
            r4 = 0
            r6 = 354(0x162, float:4.96E-43)
            java.lang.String r2 = "ImageDecoderExecutor"
            java.lang.String r3 = "source = null"
            java.lang.String r5 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.util.ImageDecoderExecutor.m32435c(com.didi.zxing.barcodescanner.SourceData):void");
    }

    /* renamed from: com.didi.util.ImageDecoderExecutor$6 */
    static /* synthetic */ class C148476 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.util.ImageDecoderExecutor.C148476.<clinit>():void");
        }
    }

    /* renamed from: a */
    public void mo113344a(String str) {
        if (str == null) {
            str = "notSet";
        }
        this.f45159o = str;
    }
}
