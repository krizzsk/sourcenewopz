package com.didi.aoe.features.bankcard.global.stat;

import com.didi.aoe.features.bankcard.global.DomainExtKt;
import com.didi.aoe.features.bankcard.global.domain.DetectCardInfo;
import com.didi.aoe.features.bankcard.global.domain.DetectInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"KEY_CARD_CONFIDENCE", "", "KEY_CARD_NUM", "KEY_CARD_NUM_CONFIDENCE", "KEY_CARD_NUM_HASH", "KEY_CARD_NUM_PROB", "KEY_CARD_NUM_X_MAX", "KEY_CARD_NUM_X_MIN", "KEY_CARD_NUM_Y_MAX", "KEY_CARD_NUM_Y_MIN", "KEY_CARD_X_MAX", "KEY_CARD_X_MIN", "KEY_CARD_Y_MAX", "KEY_CARD_Y_MIN", "STAT_EVENT_INIT", "STAT_EVENT_PROCESS", "STAT_EVENT_RELEASE", "generalStatInfo", "", "", "Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "global-ocr_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: StatExt.kt */
public final class StatExtKt {
    public static final String KEY_CARD_CONFIDENCE = "card_conf";
    public static final String KEY_CARD_NUM = "card_num";
    public static final String KEY_CARD_NUM_CONFIDENCE = "card_num_conf";
    public static final String KEY_CARD_NUM_HASH = "card_num_hash";
    public static final String KEY_CARD_NUM_PROB = "card_num_prob";
    public static final String KEY_CARD_NUM_X_MAX = "card_num_x_max";
    public static final String KEY_CARD_NUM_X_MIN = "card_num_x_min";
    public static final String KEY_CARD_NUM_Y_MAX = "card_num_y_max";
    public static final String KEY_CARD_NUM_Y_MIN = "card_num_y_min";
    public static final String KEY_CARD_X_MAX = "card_x_max";
    public static final String KEY_CARD_X_MIN = "card_x_min";
    public static final String KEY_CARD_Y_MAX = "card_y_max";
    public static final String KEY_CARD_Y_MIN = "card_y_min";
    public static final String STAT_EVENT_INIT = "aoe_event_init";
    public static final String STAT_EVENT_PROCESS = "aoe_event_process_bankcard_ocr";
    public static final String STAT_EVENT_RELEASE = "aoe_event_release";

    public static final Map<String, Object> generalStatInfo(DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "$this$generalStatInfo");
        Map<String, Object> hashMap = new HashMap<>();
        int[] iArr = detectCardInfo.prediction;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "this.prediction");
        hashMap.put(KEY_CARD_NUM_HASH, Integer.valueOf(ArraysKt.joinToString$default(iArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null).hashCode()));
        hashMap.put(KEY_CARD_NUM_PROB, Float.valueOf(detectCardInfo.prob));
        DetectInfo detectInfo = new DetectInfo(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 63, (DefaultConstructorMarker) null);
        float[] fArr = detectCardInfo.cardRect;
        Intrinsics.checkExpressionValueIsNotNull(fArr, "this.cardRect");
        DomainExtKt.fill(detectInfo, fArr);
        hashMap.put(KEY_CARD_CONFIDENCE, Float.valueOf(detectInfo.getConf()));
        hashMap.put(KEY_CARD_X_MIN, Float.valueOf(detectInfo.getXmin()));
        hashMap.put(KEY_CARD_Y_MIN, Float.valueOf(detectInfo.getYmin()));
        hashMap.put(KEY_CARD_X_MAX, Float.valueOf(detectInfo.getXmax()));
        hashMap.put(KEY_CARD_Y_MAX, Float.valueOf(detectInfo.getYmax()));
        DetectInfo detectInfo2 = new DetectInfo(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 63, (DefaultConstructorMarker) null);
        float[] fArr2 = detectCardInfo.cardNumRect;
        Intrinsics.checkExpressionValueIsNotNull(fArr2, "this.cardNumRect");
        DomainExtKt.fill(detectInfo2, fArr2);
        hashMap.put(KEY_CARD_NUM_CONFIDENCE, Float.valueOf(detectInfo2.getConf()));
        hashMap.put(KEY_CARD_NUM_X_MIN, Float.valueOf(detectInfo2.getXmin()));
        hashMap.put(KEY_CARD_NUM_Y_MIN, Float.valueOf(detectInfo2.getYmin()));
        hashMap.put(KEY_CARD_NUM_X_MAX, Float.valueOf(detectInfo2.getXmax()));
        hashMap.put(KEY_CARD_NUM_Y_MAX, Float.valueOf(detectInfo2.getYmax()));
        return hashMap;
    }
}
