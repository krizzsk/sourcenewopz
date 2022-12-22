package com.didi.aoe.features.bankcard.global;

import com.didi.aoe.features.bankcard.global.domain.DetectCardInfo;
import com.didi.aoe.features.bankcard.global.domain.DetectInfo;
import com.didi.aoe.features.bankcard.global.domain.Shape;
import com.didi.aoe.runtime.ifx.Interpreter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, mo175978d2 = {"contentToString", "", "Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "fill", "", "Lcom/didi/aoe/features/bankcard/global/domain/DetectInfo;", "array", "", "fillCardNumRect", "detectInfo", "fillCardRect", "runWithBufferFlip", "Lcom/didi/aoe/features/bankcard/global/domain/Shape;", "Lcom/didi/aoe/runtime/ifx/Interpreter;", "buffer", "Ljava/nio/ByteBuffer;", "outputIndex", "", "global-ocr_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: DomainExt.kt */
public final class DomainExtKt {
    public static final void fillCardRect(DetectCardInfo detectCardInfo, DetectInfo detectInfo) {
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "$this$fillCardRect");
        Intrinsics.checkParameterIsNotNull(detectInfo, "detectInfo");
        detectCardInfo.cardRect[0] = detectInfo.getLabel();
        detectCardInfo.cardRect[1] = detectInfo.getConf() * ((float) 100);
        detectCardInfo.cardRect[2] = detectInfo.getXmin();
        detectCardInfo.cardRect[3] = detectInfo.getYmin();
        detectCardInfo.cardRect[4] = detectInfo.getXmax();
        detectCardInfo.cardRect[5] = detectInfo.getYmax();
    }

    public static final void fillCardNumRect(DetectCardInfo detectCardInfo, DetectInfo detectInfo) {
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "$this$fillCardNumRect");
        Intrinsics.checkParameterIsNotNull(detectInfo, "detectInfo");
        detectCardInfo.cardNumRect[0] = detectInfo.getLabel();
        detectCardInfo.cardNumRect[1] = detectInfo.getConf() * ((float) 100);
        detectCardInfo.cardNumRect[2] = detectInfo.getXmin();
        detectCardInfo.cardNumRect[3] = detectInfo.getYmin();
        detectCardInfo.cardNumRect[4] = detectInfo.getXmax();
        detectCardInfo.cardNumRect[5] = detectInfo.getYmax();
    }

    public static final void fill(DetectInfo detectInfo, float[] fArr) {
        Intrinsics.checkParameterIsNotNull(detectInfo, "$this$fill");
        Intrinsics.checkParameterIsNotNull(fArr, "array");
        detectInfo.setLabel(fArr[0]);
        detectInfo.setConf(fArr[1] * 0.01f);
        detectInfo.setXmin(fArr[2]);
        detectInfo.setYmin(fArr[3]);
        detectInfo.setXmax(fArr[4]);
        detectInfo.setYmax(fArr[5]);
    }

    public static final String contentToString(DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "$this$contentToString");
        StringBuilder sb = new StringBuilder();
        sb.append(detectCardInfo.count);
        sb.append(", ");
        int[] iArr = detectCardInfo.prediction;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "prediction");
        sb.append(ArraysKt.joinToString$default(iArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return sb.toString();
    }

    public static /* synthetic */ Shape runWithBufferFlip$default(Interpreter interpreter, ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return runWithBufferFlip(interpreter, byteBuffer, i);
    }

    public static final Shape runWithBufferFlip(Interpreter interpreter, ByteBuffer byteBuffer, int i) {
        Interpreter interpreter2 = interpreter;
        ByteBuffer byteBuffer2 = byteBuffer;
        Intrinsics.checkParameterIsNotNull(interpreter2, "$this$runWithBufferFlip");
        Intrinsics.checkParameterIsNotNull(byteBuffer2, "buffer");
        try {
            byteBuffer.clear();
            interpreter2.runForMultipleInputsOutputs((Object[]) null, MapsKt.mapOf(new Pair(Integer.valueOf(i), byteBuffer2)));
            byteBuffer2.order(ByteOrder.nativeOrder());
            byteBuffer.flip();
            int[] shape = interpreter2.getOutputTensor(i).shape();
            Intrinsics.checkExpressionValueIsNotNull(shape, "getOutputTensor(outputIndex).shape()");
            return new Shape(shape[0], shape[1], shape[2], shape[3], shape[4], shape[5]);
        } catch (Exception unused) {
            return new Shape(0, 0, 0, 0, 0, 0, 63, (DefaultConstructorMarker) null);
        }
    }
}
