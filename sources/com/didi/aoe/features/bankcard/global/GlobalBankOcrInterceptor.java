package com.didi.aoe.features.bankcard.global;

import android.content.Context;
import com.didi.aoe.extensions.support.image.AoeSupport;
import com.didi.aoe.features.bankcard.global.domain.BankcardInputData;
import com.didi.aoe.features.bankcard.global.domain.DetectCardInfo;
import com.didi.aoe.features.bankcard.global.domain.DetectInfo;
import com.didi.aoe.features.bankcard.global.domain.RecognizeInfo;
import com.didi.aoe.features.bankcard.global.domain.Shape;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import com.didi.aoe.runtime.ifx.Interpreter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J(\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u001eH\u0002J(\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0002J(\u0010+\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010,\u001a\u00020 H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u00032\u0006\u0010.\u001a\u00020\u0002H\u0016J\f\u0010/\u001a\u000200*\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, mo175978d2 = {"Lcom/didi/aoe/features/bankcard/global/GlobalBankOcrInterceptor;", "Lcom/didi/aoe/library/api/AoeProcessor$InterpreterComponent;", "Lcom/didi/aoe/features/bankcard/global/domain/BankcardInputData;", "Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "()V", "buffer", "Ljava/nio/ByteBuffer;", "interpreters", "Ljava/util/ArrayList;", "Lcom/didi/aoe/runtime/ifx/Interpreter;", "Lkotlin/collections/ArrayList;", "mLogger", "Lcom/didi/aoe/library/logging/Logger;", "meanVals", "", "normVals", "detectCard", "", "argb8888Data", "", "width", "", "height", "result", "detectText", "getScore", "", "probs", "shape", "Lcom/didi/aoe/features/bankcard/global/domain/Shape;", "", "init", "", "context", "Landroid/content/Context;", "modelOptions", "", "Lcom/didi/aoe/library/api/AoeModelOption;", "listener", "Lcom/didi/aoe/library/api/interpreter/OnInterpreterInitListener;", "isReady", "posit", "i", "recognizeContent", "release", "run", "input", "predict", "Lcom/didi/aoe/features/bankcard/global/domain/RecognizeInfo;", "global-ocr_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GlobalBankOcrInterceptor.kt */
public final class GlobalBankOcrInterceptor implements AoeProcessor.InterpreterComponent<BankcardInputData, DetectCardInfo> {

    /* renamed from: a */
    private final Logger f8145a;

    /* renamed from: b */
    private final ArrayList<Interpreter> f8146b = new ArrayList<>(3);

    /* renamed from: c */
    private final float[] f8147c = {127.5f, 127.5f, 127.5f};

    /* renamed from: d */
    private final float[] f8148d = {0.007843f, 0.007843f, 0.007843f};

    /* renamed from: e */
    private final ByteBuffer f8149e;

    public GlobalBankOcrInterceptor() {
        Logger logger = LoggerFactory.getLogger("GlobalBankOcrInterceptor");
        Intrinsics.checkExpressionValueIsNotNull(logger, "LoggerFactory.getLogger(…lobalBankOcrInterceptor\")");
        this.f8145a = logger;
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        Intrinsics.checkExpressionValueIsNotNull(allocate, "ByteBuffer.allocate(2048)");
        this.f8149e = allocate;
    }

    public DetectCardInfo run(BankcardInputData bankcardInputData) {
        byte[] bArr;
        Intrinsics.checkParameterIsNotNull(bankcardInputData, "input");
        DetectCardInfo result = bankcardInputData.getResult();
        int imageWidth = bankcardInputData.getImageWidth();
        int imageHeight = bankcardInputData.getImageHeight();
        Logger logger = this.f8145a;
        logger.debug("[0] " + bankcardInputData, new Object[0]);
        if (bankcardInputData.getImageType() == 1) {
            bArr = AoeSupport.Companion.convertNV21ToARGB8888(bankcardInputData.getImageData(), imageWidth, imageHeight);
        } else {
            bArr = bankcardInputData.getImageData();
        }
        if (bankcardInputData.getDegree() != 0) {
            bArr = AoeSupport.Companion.rotateARGB(bArr, imageWidth, imageHeight, bankcardInputData.getDegree());
            if (bankcardInputData.getDegree() == 90 || bankcardInputData.getDegree() == 270) {
                imageWidth = bankcardInputData.getImageHeight();
                imageHeight = bankcardInputData.getImageWidth();
            }
        }
        Logger logger2 = this.f8145a;
        logger2.debug("[1] detect card : size " + imageWidth + " * " + imageHeight, new Object[0]);
        if (!m5294a(bArr, imageWidth, imageHeight, result)) {
            return result;
        }
        this.f8145a.debug("[2] detect text", new Object[0]);
        if (!m5295b(bArr, imageWidth, imageHeight, result)) {
            return result;
        }
        this.f8145a.debug("[3] content recognition", new Object[0]);
        m5296c(bArr, imageWidth, imageHeight, result);
        Logger logger3 = this.f8145a;
        logger3.debug("[4] content result: " + DomainExtKt.contentToString(result), new Object[0]);
        return result;
    }

    public boolean isReady() {
        return this.f8146b.size() == 3;
    }

    public void release() {
        for (Interpreter close : this.f8146b) {
            close.close();
        }
        this.f8146b.clear();
    }

    public void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "modelOptions");
        if (list.size() == 3) {
            release();
            Iterator<AoeModelOption> it = list.iterator();
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AoeModelOption next = it.next();
                Interpreter interpreter = new Interpreter(context.getAssets(), next.getModelDir(), next.getModelName(), 0, (Interpreter.Options) null);
                boolean isLoadModelSuccess = interpreter.isLoadModelSuccess();
                Logger logger = this.f8145a;
                logger.debug("init result: " + isLoadModelSuccess + ", " + next, new Object[0]);
                if (!isLoadModelSuccess) {
                    z = isLoadModelSuccess;
                    break;
                } else {
                    this.f8146b.add(interpreter);
                    z = isLoadModelSuccess;
                }
            }
            if (z) {
                if (onInterpreterInitListener != null) {
                    onInterpreterInitListener.onInitResult(InterpreterInitResult.create(0));
                }
            } else if (onInterpreterInitListener != null) {
                onInterpreterInitListener.onInitResult(InterpreterInitResult.create(4));
            }
        } else if (onInterpreterInitListener != null) {
            onInterpreterInitListener.onInitResult(InterpreterInitResult.create(1, "model options size error!"));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m5294a(byte[] r23, int r24, int r25, com.didi.aoe.features.bankcard.global.domain.DetectCardInfo r26) {
        /*
            r22 = this;
            r0 = r22
            r10 = r24
            r11 = r25
            java.util.ArrayList<com.didi.aoe.runtime.ifx.Interpreter> r1 = r0.f8146b
            r12 = 0
            java.lang.Object r1 = r1.get(r12)
            java.lang.String r2 = "interpreters[0]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r13 = r1
            com.didi.aoe.runtime.ifx.Interpreter r13 = (com.didi.aoe.runtime.ifx.Interpreter) r13
            float[] r7 = r0.f8147c
            float[] r8 = r0.f8148d
            r5 = 320(0x140, float:4.48E-43)
            r6 = 320(0x140, float:4.48E-43)
            r9 = 0
            r1 = r13
            r2 = r23
            r3 = r24
            r4 = r25
            r1.preTreatment(r2, r3, r4, r5, r6, r7, r8, r9)
            java.nio.ByteBuffer r1 = r0.f8149e
            r2 = 2
            r3 = 0
            com.didi.aoe.features.bankcard.global.domain.Shape r1 = com.didi.aoe.features.bankcard.global.DomainExtKt.runWithBufferFlip$default(r13, r1, r12, r2, r3)
            int r1 = r1.getH()
            r2 = 1
            if (r1 <= 0) goto L_0x0179
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r1)
            r5 = 0
        L_0x003d:
            if (r5 >= r1) goto L_0x00a9
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r6 = new com.didi.aoe.features.bankcard.global.domain.DetectInfo
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 63
            r21 = 0
            r13 = r6
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            java.nio.ByteBuffer r7 = r0.f8149e
            float r7 = r7.getFloat()
            r6.setLabel(r7)
            java.nio.ByteBuffer r7 = r0.f8149e
            float r7 = r7.getFloat()
            r6.setConf(r7)
            java.nio.ByteBuffer r7 = r0.f8149e
            float r7 = r7.getFloat()
            float r7 = r0.m5291a((float) r7)
            float r8 = (float) r10
            float r7 = r7 * r8
            r6.setXmin(r7)
            java.nio.ByteBuffer r7 = r0.f8149e
            float r7 = r7.getFloat()
            float r7 = r0.m5291a((float) r7)
            float r9 = (float) r11
            float r7 = r7 * r9
            r6.setYmin(r7)
            java.nio.ByteBuffer r7 = r0.f8149e
            float r7 = r7.getFloat()
            float r7 = r0.m5291a((float) r7)
            float r7 = r7 * r8
            r6.setXmax(r7)
            java.nio.ByteBuffer r7 = r0.f8149e
            float r7 = r7.getFloat()
            float r7 = r0.m5291a((float) r7)
            float r7 = r7 * r9
            r6.setYmax(r7)
            r4.add(r6)
            int r5 = r5 + 1
            goto L_0x003d
        L_0x00a9:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x00b6:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x011a
            java.lang.Object r6 = r4.next()
            r7 = r6
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r7 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r7
            float r8 = r7.getConf()
            r9 = 1050253722(0x3e99999a, float:0.3)
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 <= 0) goto L_0x0113
            float r8 = r7.getXmin()
            float r9 = (float) r12
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 < 0) goto L_0x0113
            float r8 = r7.getXmin()
            float r13 = (float) r10
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x0113
            float r8 = r7.getXmax()
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 < 0) goto L_0x0113
            float r8 = r7.getXmax()
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x0113
            float r8 = r7.getYmin()
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 < 0) goto L_0x0113
            float r8 = r7.getYmin()
            float r13 = (float) r11
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x0113
            float r8 = r7.getYmax()
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 < 0) goto L_0x0113
            float r7 = r7.getYmax()
            int r7 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r7 > 0) goto L_0x0113
            r7 = 1
            goto L_0x0114
        L_0x0113:
            r7 = 0
        L_0x0114:
            if (r7 == 0) goto L_0x00b6
            r5.add(r6)
            goto L_0x00b6
        L_0x011a:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r4 = r5.iterator()
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L_0x0129
            goto L_0x0154
        L_0x0129:
            java.lang.Object r3 = r4.next()
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L_0x0134
            goto L_0x0154
        L_0x0134:
            r5 = r3
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r5 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r5
            float r5 = r5.getConf()
        L_0x013b:
            java.lang.Object r6 = r4.next()
            r7 = r6
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r7 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r7
            float r7 = r7.getConf()
            int r8 = java.lang.Float.compare(r5, r7)
            if (r8 >= 0) goto L_0x014e
            r3 = r6
            r5 = r7
        L_0x014e:
            boolean r6 = r4.hasNext()
            if (r6 != 0) goto L_0x0176
        L_0x0154:
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r3 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r3
            com.didi.aoe.library.logging.Logger r4 = r0.f8145a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "detectCard: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r12]
            r4.debug(r5, r6)
            if (r3 == 0) goto L_0x0179
            r6 = r26
            com.didi.aoe.features.bankcard.global.DomainExtKt.fillCardRect(r6, r3)
            goto L_0x0179
        L_0x0176:
            r6 = r26
            goto L_0x013b
        L_0x0179:
            if (r1 <= 0) goto L_0x017c
            r12 = 1
        L_0x017c:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.features.bankcard.global.GlobalBankOcrInterceptor.m5294a(byte[], int, int, com.didi.aoe.features.bankcard.global.domain.DetectCardInfo):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012f A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m5295b(byte[] r26, int r27, int r28, com.didi.aoe.features.bankcard.global.domain.DetectCardInfo r29) {
        /*
            r25 = this;
            r0 = r25
            r3 = r27
            r4 = r28
            r9 = r29
            java.util.ArrayList<com.didi.aoe.runtime.ifx.Interpreter> r1 = r0.f8146b
            r10 = 1
            java.lang.Object r1 = r1.get(r10)
            java.lang.String r2 = "interpreters[1]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r15 = r1
            com.didi.aoe.runtime.ifx.Interpreter r15 = (com.didi.aoe.runtime.ifx.Interpreter) r15
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r1 = new com.didi.aoe.features.bankcard.global.domain.DetectInfo
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 63
            r24 = 0
            r16 = r1
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            float[] r2 = r9.cardRect
            java.lang.String r5 = "result.cardRect"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            com.didi.aoe.features.bankcard.global.DomainExtKt.fill(r1, r2)
            float r2 = r1.getXmin()
            int r2 = (int) r2
            float r5 = r1.getXmax()
            int r5 = (int) r5
            float r6 = r1.getYmin()
            int r6 = (int) r6
            float r1 = r1.getYmax()
            int r1 = (int) r1
            int r7 = r1 - r6
            r14 = 0
            if (r7 <= 0) goto L_0x0218
            if (r7 > 0) goto L_0x0055
            goto L_0x0218
        L_0x0055:
            if (r2 >= 0) goto L_0x0059
            r13 = 0
            goto L_0x005a
        L_0x0059:
            r13 = r2
        L_0x005a:
            if (r5 < r3) goto L_0x005e
            int r5 = r3 + -1
        L_0x005e:
            if (r6 >= 0) goto L_0x0062
            r12 = 0
            goto L_0x0063
        L_0x0062:
            r12 = r6
        L_0x0063:
            if (r1 < r4) goto L_0x0067
            int r1 = r4 + -1
        L_0x0067:
            int r5 = r5 - r13
            int r11 = r5 + 1
            int r1 = r1 - r12
            int r8 = r1 + 1
            r16 = 320(0x140, float:4.48E-43)
            r17 = 320(0x140, float:4.48E-43)
            com.didi.aoe.extensions.support.image.AoeSupport$Companion r1 = com.didi.aoe.extensions.support.image.AoeSupport.Companion
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r13
            r6 = r12
            r7 = r11
            r26 = r8
            byte[] r1 = r1.cropABGR(r2, r3, r4, r5, r6, r7, r8)
            float[] r2 = r0.f8147c
            float[] r3 = r0.f8148d
            r19 = 0
            r5 = r11
            r11 = r15
            r12 = r1
            r1 = r13
            r13 = r5
            r4 = 0
            r14 = r26
            r7 = r15
            r15 = r16
            r16 = r17
            r17 = r2
            r18 = r3
            r11.preTreatment(r12, r13, r14, r15, r16, r17, r18, r19)
            java.nio.ByteBuffer r2 = r0.f8149e
            r3 = 2
            r8 = 0
            com.didi.aoe.features.bankcard.global.domain.Shape r2 = com.didi.aoe.features.bankcard.global.DomainExtKt.runWithBufferFlip$default(r7, r2, r4, r3, r8)
            int r2 = r2.getH()
            if (r2 <= 0) goto L_0x0217
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r14 = 0
        L_0x00b0:
            if (r14 >= r2) goto L_0x0120
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r7 = new com.didi.aoe.features.bankcard.global.domain.DetectInfo
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 63
            r23 = 0
            r15 = r7
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23)
            java.nio.ByteBuffer r11 = r0.f8149e
            float r11 = r11.getFloat()
            r7.setLabel(r11)
            java.nio.ByteBuffer r11 = r0.f8149e
            float r11 = r11.getFloat()
            r7.setConf(r11)
            java.nio.ByteBuffer r11 = r0.f8149e
            float r11 = r11.getFloat()
            float r11 = r0.m5291a((float) r11)
            float r12 = (float) r5
            float r11 = r11 * r12
            r7.setXmin(r11)
            java.nio.ByteBuffer r11 = r0.f8149e
            float r11 = r11.getFloat()
            float r11 = r0.m5291a((float) r11)
            r13 = r26
            float r15 = (float) r13
            float r11 = r11 * r15
            r7.setYmin(r11)
            java.nio.ByteBuffer r11 = r0.f8149e
            float r11 = r11.getFloat()
            float r11 = r0.m5291a((float) r11)
            float r11 = r11 * r12
            r7.setXmax(r11)
            java.nio.ByteBuffer r11 = r0.f8149e
            float r11 = r11.getFloat()
            float r11 = r0.m5291a((float) r11)
            float r11 = r11 * r15
            r7.setYmax(r11)
            r3.add(r7)
            int r14 = r14 + 1
            goto L_0x00b0
        L_0x0120:
            r13 = r26
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r3.iterator()
        L_0x012f:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0197
            java.lang.Object r7 = r3.next()
            r11 = r7
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r11 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r11
            float r12 = r11.getConf()
            r14 = 1053609165(0x3ecccccd, float:0.4)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x0190
            float r12 = r11.getXmin()
            float r14 = (float) r4
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 < 0) goto L_0x0190
            float r12 = r11.getXmin()
            int r15 = r5 + r1
            float r15 = (float) r15
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 > 0) goto L_0x0190
            float r12 = r11.getXmax()
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 < 0) goto L_0x0190
            float r12 = r11.getXmax()
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 > 0) goto L_0x0190
            float r12 = r11.getYmin()
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 < 0) goto L_0x0190
            float r12 = r11.getYmin()
            int r15 = r13 + r6
            float r15 = (float) r15
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 > 0) goto L_0x0190
            float r12 = r11.getYmax()
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 < 0) goto L_0x0190
            float r11 = r11.getYmax()
            int r11 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r11 > 0) goto L_0x0190
            r14 = 1
            goto L_0x0191
        L_0x0190:
            r14 = 0
        L_0x0191:
            if (r14 == 0) goto L_0x012f
            r2.add(r7)
            goto L_0x012f
        L_0x0197:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L_0x01a7
            r3 = r8
            goto L_0x01d2
        L_0x01a7:
            java.lang.Object r3 = r2.next()
            boolean r5 = r2.hasNext()
            if (r5 != 0) goto L_0x01b2
            goto L_0x01d2
        L_0x01b2:
            r5 = r3
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r5 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r5
            float r5 = r5.getConf()
        L_0x01b9:
            java.lang.Object r7 = r2.next()
            r11 = r7
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r11 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r11
            float r11 = r11.getConf()
            int r12 = java.lang.Float.compare(r5, r11)
            if (r12 >= 0) goto L_0x01cc
            r3 = r7
            r5 = r11
        L_0x01cc:
            boolean r7 = r2.hasNext()
            if (r7 != 0) goto L_0x01b9
        L_0x01d2:
            com.didi.aoe.features.bankcard.global.domain.DetectInfo r3 = (com.didi.aoe.features.bankcard.global.domain.DetectInfo) r3
            if (r3 == 0) goto L_0x01f9
            float r2 = r3.getXmin()
            float r1 = (float) r1
            float r2 = r2 + r1
            r3.setXmin(r2)
            float r2 = r3.getYmin()
            float r5 = (float) r6
            float r2 = r2 + r5
            r3.setYmin(r2)
            float r2 = r3.getXmax()
            float r2 = r2 + r1
            r3.setXmax(r2)
            float r1 = r3.getYmax()
            float r1 = r1 + r5
            r3.setYmax(r1)
            r8 = r3
        L_0x01f9:
            com.didi.aoe.library.logging.Logger r1 = r0.f8145a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "detectCardNum: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r1.debug(r2, r3)
            if (r8 == 0) goto L_0x0217
            com.didi.aoe.features.bankcard.global.DomainExtKt.fillCardNumRect(r9, r8)
            return r10
        L_0x0217:
            return r4
        L_0x0218:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.features.bankcard.global.GlobalBankOcrInterceptor.m5295b(byte[], int, int, com.didi.aoe.features.bankcard.global.domain.DetectCardInfo):boolean");
    }

    /* renamed from: c */
    private final void m5296c(byte[] bArr, int i, int i2, DetectCardInfo detectCardInfo) {
        RecognizeInfo recognizeInfo;
        int i3 = i;
        int i4 = i2;
        DetectCardInfo detectCardInfo2 = detectCardInfo;
        Interpreter interpreter = this.f8146b.get(2);
        Intrinsics.checkExpressionValueIsNotNull(interpreter, "interpreters[2]");
        Interpreter interpreter2 = interpreter;
        DetectInfo detectInfo = new DetectInfo(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 63, (DefaultConstructorMarker) null);
        float[] fArr = detectCardInfo2.cardNumRect;
        Intrinsics.checkExpressionValueIsNotNull(fArr, "result.cardNumRect");
        DomainExtKt.fill(detectInfo, fArr);
        int xmin = (int) detectInfo.getXmin();
        int xmax = (int) detectInfo.getXmax();
        int ymin = (int) detectInfo.getYmin();
        int ymax = (int) detectInfo.getYmax();
        int i5 = ymax - ymin;
        if (i5 > 0 && i5 > 0) {
            if (xmin < 0) {
                xmin = 0;
            }
            if (xmax >= i3) {
                xmax = i3 - 1;
            }
            if (ymin < 0) {
                ymin = 0;
            }
            if (ymax >= i4) {
                ymax = i4 - 1;
            }
            int i6 = (xmax - xmin) + 1;
            int i7 = (ymax - ymin) + 1;
            float f = (float) i6;
            int i8 = (int) ((f * 0.02f) + 0.5f);
            float f2 = (float) i7;
            int i9 = (int) ((f2 * 0.1f) + 0.5f);
            if (i6 < i7) {
                i8 = (int) ((f * 0.1f) + 0.5f);
                i9 = (int) ((f2 * 0.02f) + 0.5f);
            }
            int i10 = xmin - i8;
            int i11 = xmax + i8;
            int i12 = ymin - i9;
            int i13 = ymax + i9;
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= i3) {
                i11 = i3 - 1;
            }
            if (i12 < 0) {
                i12 = 0;
            }
            if (i13 >= i4) {
                i13 = i4 - 1;
            }
            int i14 = (i11 - i10) + 1;
            int i15 = (i13 - i12) + 1;
            detectCardInfo2.cardNumRect[2] = (float) i10;
            detectCardInfo2.cardNumRect[3] = (float) i12;
            detectCardInfo2.cardNumRect[4] = (float) i11;
            detectCardInfo2.cardNumRect[5] = (float) i13;
            byte[] cropABGR = AoeSupport.Companion.cropABGR(bArr, i, i2, i10, i12, i14, i15);
            if (i14 >= i15) {
                interpreter2.preTreatment(cropABGR, i14, i15, 256, 32, this.f8147c, this.f8148d, 0);
                recognizeInfo = m5293a(interpreter2);
                this.f8145a.debug("normal -> " + recognizeInfo, new Object[0]);
            } else {
                Interpreter interpreter3 = interpreter2;
                Interpreter interpreter4 = interpreter3;
                int i16 = i15;
                int i17 = i14;
                interpreter4.preTreatment(AoeSupport.Companion.rotateARGB(cropABGR, i14, i15, 90), i15, i14, 256, 32, this.f8147c, this.f8148d, 0);
                RecognizeInfo a = m5293a(interpreter3);
                interpreter4.preTreatment(AoeSupport.Companion.rotateARGB(cropABGR, i17, i16, 270), i16, i17, 256, 32, this.f8147c, this.f8148d, 0);
                recognizeInfo = m5293a(interpreter3);
                this.f8145a.debug("90 -> " + a, new Object[0]);
                this.f8145a.debug("270 -> " + recognizeInfo, new Object[0]);
                if (a.getProb() >= recognizeInfo.getProb()) {
                    recognizeInfo = a;
                }
            }
            if (recognizeInfo.getCount() > 0) {
                detectCardInfo2.count = recognizeInfo.getCount();
                if (!(recognizeInfo.getPrediction().length == 0)) {
                    int[] prediction = recognizeInfo.getPrediction();
                    int[] iArr = detectCardInfo2.prediction;
                    Intrinsics.checkExpressionValueIsNotNull(iArr, "result.prediction");
                    ArraysKt.copyInto$default(prediction, iArr, 0, 0, 0, 14, (Object) null);
                }
                detectCardInfo2.prob = recognizeInfo.getProb();
            }
        }
    }

    /* renamed from: a */
    private final RecognizeInfo m5293a(Interpreter interpreter) {
        Shape runWithBufferFlip = DomainExtKt.runWithBufferFlip(interpreter, this.f8149e, 1);
        float f = this.f8149e.getFloat(0);
        int[] iArr = new int[32];
        int i = 0;
        int i2 = 0;
        loop0:
        while (true) {
            int i3 = 0;
            while (i < runWithBufferFlip.getFlatSize()) {
                float f2 = this.f8149e.getFloat();
                if (i % runWithBufferFlip.getW() == 0) {
                    f = f2;
                }
                if (f2 > f) {
                    i3 = i % runWithBufferFlip.getW();
                    f = f2;
                }
                i++;
                if (i % runWithBufferFlip.getW() == 0) {
                    iArr[i2] = i3;
                    this.f8149e.getFloat();
                    i2++;
                }
            }
            break loop0;
        }
        int[] iArr2 = new int[100];
        int c = runWithBufferFlip.getC();
        int i4 = 0;
        for (int i5 = 0; i5 < c; i5++) {
            if (iArr[i5] != 0 && (i5 <= 0 || iArr[i5 - 1] != iArr[i5])) {
                iArr2[i4] = iArr[i5] - 1;
                i4++;
            }
        }
        RecognizeInfo recognizeInfo = new RecognizeInfo((int[]) null, 0.0f, 0, 7, (DefaultConstructorMarker) null);
        if (i4 > 0) {
            int[] intArray = CollectionsKt.toIntArray(ArraysKt.take(iArr2, Math.min(30, i4)));
            recognizeInfo.setCount(i4);
            recognizeInfo.setPrediction(intArray);
            recognizeInfo.setProb(m5292a(this.f8149e, runWithBufferFlip, intArray));
        }
        return recognizeInfo;
    }

    /* renamed from: a */
    private final float m5292a(ByteBuffer byteBuffer, Shape shape, int[] iArr) {
        List arrayList = new ArrayList();
        if (r1 < 1) {
            return 0.0f;
        }
        arrayList.add(0);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i + 1));
            arrayList.add(0);
        }
        int c = shape.getC();
        shape.getW();
        int size = arrayList.size();
        float[][] fArr = new float[c][];
        for (int i2 = 0; i2 < c; i2++) {
            fArr[i2] = new float[size];
        }
        float[][] fArr2 = fArr;
        byteBuffer.rewind();
        fArr2[0][0] = byteBuffer.getFloat(((Number) arrayList.get(0)).intValue() << 2);
        fArr2[0][1] = byteBuffer.getFloat(((Number) arrayList.get(1)).intValue() << 2);
        for (int i3 = 1; i3 < c; i3++) {
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = ((Number) arrayList.get(i4)).intValue();
                int i5 = i3 - 1;
                float f = fArr2[i5][i4];
                int i6 = i4 - 1;
                if (i6 >= 0) {
                    f += fArr2[i5][i6];
                }
                int i7 = i4 - 2;
                if (!(i7 < 0 || intValue == 0 || intValue == ((Number) arrayList.get(i7)).intValue())) {
                    f += fArr2[i5][i7];
                }
                fArr2[i3][i4] = f * byteBuffer.getFloat(((shape.getCSetp() * i3) + intValue) << 2);
            }
        }
        int i8 = c - 1;
        return fArr2[i8][size - 1] + fArr2[i8][size - 2];
    }

    /* renamed from: a */
    private final float m5291a(float f) {
        return Math.max(Math.min(f, 1.0f), 0.0f);
    }
}
