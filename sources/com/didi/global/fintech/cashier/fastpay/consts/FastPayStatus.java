package com.didi.global.fintech.cashier.fastpay.consts;

import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "", "(Ljava/lang/String;I)V", "opposite", "", "ON", "OFF", "UNKNOWN", "Companion", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayConstants.kt */
public enum FastPayStatus {
    ON,
    OFF,
    UNKNOWN;
    
    public static final Companion Companion = null;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayConstants.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[FastPayStatus.values().length];
            iArr[FastPayStatus.OFF.ordinal()] = 1;
            iArr[FastPayStatus.ON.ordinal()] = 2;
            iArr[FastPayStatus.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus$Companion;", "", "()V", "value", "Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayConstants.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPayStatus value(String str) {
            FastPayStatus fastPayStatus = null;
            if (str != null) {
                Pattern compile = Pattern.compile("_");
                Intrinsics.checkNotNullExpressionValue(compile, "compile(\"_\")");
                List split$default = StringsKt.split$default(str, compile, 0, 2, (Object) null);
                try {
                    String str2 = (String) split$default.get(CollectionsKt.getLastIndex(split$default));
                    if (str2 != null) {
                        String upperCase = str2.toUpperCase();
                        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                        fastPayStatus = FastPayStatus.valueOf(upperCase);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } catch (Exception unused) {
                    return FastPayStatus.UNKNOWN;
                }
            }
            return fastPayStatus == null ? FastPayStatus.UNKNOWN : fastPayStatus;
        }
    }

    public final String opposite() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "TURN_ON";
        }
        if (i == 2 || i == 3) {
            return "TURN_OFF";
        }
        throw new NoWhenBranchMatchedException();
    }
}
