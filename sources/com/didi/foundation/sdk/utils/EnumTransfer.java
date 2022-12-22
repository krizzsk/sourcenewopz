package com.didi.foundation.sdk.utils;

import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.TimeStyle;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/foundation/sdk/utils/EnumTransfer;", "", "()V", "getDateEnumByValue", "Lcom/global/didi/elvish/DateStyle;", "value", "", "getDistanceStyleEnumByValue", "Lcom/global/didi/elvish/DistanceStyle;", "getTimeEnumByValue", "Lcom/global/didi/elvish/TimeStyle;", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: EnumTransfer.kt */
public final class EnumTransfer {
    public static final EnumTransfer INSTANCE = new EnumTransfer();

    private EnumTransfer() {
    }

    public final DateStyle getDateEnumByValue(int i) {
        for (DateStyle dateStyle : DateStyle.values()) {
            if (dateStyle.getStyle() == i) {
                return dateStyle;
            }
        }
        return DateStyle.NONE;
    }

    public final TimeStyle getTimeEnumByValue(int i) {
        for (TimeStyle timeStyle : TimeStyle.values()) {
            if (timeStyle.getStyle() == i) {
                return timeStyle;
            }
        }
        return TimeStyle.NONE;
    }

    public final DistanceStyle getDistanceStyleEnumByValue(int i) {
        for (DistanceStyle distanceStyle : DistanceStyle.values()) {
            if (distanceStyle.getStyle() == i) {
                return distanceStyle;
            }
        }
        return DistanceStyle.AUTO;
    }
}
