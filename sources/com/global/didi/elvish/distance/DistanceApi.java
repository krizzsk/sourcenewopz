package com.global.didi.elvish.distance;

import android.content.Context;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.LocationInfo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0004\n\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/global/didi/elvish/distance/DistanceApi;", "", "context", "Landroid/content/Context;", "locationInfo", "Lcom/global/didi/elvish/LocationInfo;", "(Landroid/content/Context;Lcom/global/didi/elvish/LocationInfo;)V", "conf", "Lcom/global/didi/elvish/distance/DistanceConf;", "conf$1", "formatDistance", "", "meter", "", "distanceStyle", "Lcom/global/didi/elvish/DistanceStyle;", "precision", "", "isHighlight", "", "splitDistance", "", "Companion", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: DistanceApi.kt */
public final class DistanceApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile DistanceConf f52576c;

    /* renamed from: a */
    private DistanceConf f52577a;

    /* renamed from: b */
    private final LocationInfo f52578b;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DistanceStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DistanceStyle.AUTO.ordinal()] = 1;
            $EnumSwitchMapping$0[DistanceStyle.M.ordinal()] = 2;
            $EnumSwitchMapping$0[DistanceStyle.KM.ordinal()] = 3;
            $EnumSwitchMapping$0[DistanceStyle.Mi.ordinal()] = 4;
            $EnumSwitchMapping$0[DistanceStyle.YARD.ordinal()] = 5;
        }
    }

    public DistanceApi(Context context, LocationInfo locationInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locationInfo, "locationInfo");
        this.f52578b = locationInfo;
        this.f52577a = Companion.getConf(context);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/global/didi/elvish/distance/DistanceApi$Companion;", "", "()V", "conf", "Lcom/global/didi/elvish/distance/DistanceConf;", "getConf", "context", "Landroid/content/Context;", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: DistanceApi.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final DistanceConf getConf(Context context) {
            DistanceConf access$getConf$cp = DistanceApi.f52576c;
            if (access$getConf$cp == null) {
                synchronized (this) {
                    access$getConf$cp = DistanceApi.f52576c;
                    if (access$getConf$cp == null) {
                        access$getConf$cp = new DistanceConf(context);
                        DistanceApi.f52576c = access$getConf$cp;
                    }
                }
            }
            return access$getConf$cp;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String formatDistance(double r10, com.global.didi.elvish.DistanceStyle r12, int r13, boolean r14) {
        /*
            r9 = this;
            java.lang.String r0 = "distanceStyle"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            r0 = 0
            double r1 = (double) r0
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x0157
            if (r13 < 0) goto L_0x0157
            com.global.didi.elvish.distance.DistanceConf r1 = r9.f52577a
            com.global.didi.elvish.LocationInfo r2 = r9.f52578b
            java.lang.String r2 = r2.getInitLocal()
            boolean r1 = r1.isImperial(r2)
            if (r1 == 0) goto L_0x0038
            com.global.didi.elvish.DistanceStyle r1 = com.global.didi.elvish.DistanceStyle.Mi
            if (r12 != r1) goto L_0x0022
            com.global.didi.elvish.DistanceStyle r12 = com.global.didi.elvish.DistanceStyle.Mi
            goto L_0x0042
        L_0x0022:
            com.global.didi.elvish.DistanceStyle r1 = com.global.didi.elvish.DistanceStyle.YARD
            if (r12 != r1) goto L_0x0029
            com.global.didi.elvish.DistanceStyle r12 = com.global.didi.elvish.DistanceStyle.YARD
            goto L_0x0042
        L_0x0029:
            r1 = 4654792780812671517(0x4099255f3b645a1d, double:1609.343)
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 <= 0) goto L_0x0035
            com.global.didi.elvish.DistanceStyle r12 = com.global.didi.elvish.DistanceStyle.Mi
            goto L_0x0042
        L_0x0035:
            com.global.didi.elvish.DistanceStyle r12 = com.global.didi.elvish.DistanceStyle.YARD
            goto L_0x0042
        L_0x0038:
            com.global.didi.elvish.DistanceStyle r1 = com.global.didi.elvish.DistanceStyle.Mi
            if (r12 == r1) goto L_0x0040
            com.global.didi.elvish.DistanceStyle r1 = com.global.didi.elvish.DistanceStyle.YARD
            if (r12 != r1) goto L_0x0042
        L_0x0040:
            com.global.didi.elvish.DistanceStyle r12 = com.global.didi.elvish.DistanceStyle.AUTO
        L_0x0042:
            int[] r1 = com.global.didi.elvish.distance.DistanceApi.WhenMappings.$EnumSwitchMapping$0
            int r2 = r12.ordinal()
            r1 = r1[r2]
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r4 = 1
            if (r1 == r4) goto L_0x0075
            r5 = 2
            if (r1 == r5) goto L_0x0081
            r5 = 3
            if (r1 == r5) goto L_0x0073
            r2 = 4
            if (r1 == r2) goto L_0x006b
            r2 = 5
            if (r1 != r2) goto L_0x0065
            r1 = 4606411402543811579(0x3fed42c3c9eecbfb, double:0.9144)
            double r10 = r10 / r1
            goto L_0x0081
        L_0x0065:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x006b:
            r1 = 4558870626655273014(0x3f445cae56c00036, double:6.214E-4)
            double r10 = r10 * r1
            goto L_0x0081
        L_0x0073:
            double r10 = r10 / r2
            goto L_0x0081
        L_0x0075:
            r12 = 999(0x3e7, float:1.4E-42)
            double r5 = (double) r12
            int r12 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x007f
            com.global.didi.elvish.DistanceStyle r12 = com.global.didi.elvish.DistanceStyle.KM
            goto L_0x0073
        L_0x007f:
            com.global.didi.elvish.DistanceStyle r12 = com.global.didi.elvish.DistanceStyle.M
        L_0x0081:
            com.global.didi.elvish.distance.DistanceConf r1 = r9.f52577a
            com.global.didi.elvish.LocationInfo r2 = r9.f52578b
            java.lang.String r2 = r2.getLocaleString()
            java.lang.String r12 = r1.getFormatterRule(r2, r12, r14)
            com.global.didi.elvish.distance.DistanceConf r14 = r9.f52577a
            com.global.didi.elvish.LocationInfo r1 = r9.f52578b
            java.util.Locale r1 = r1.getLocale()
            java.text.DecimalFormatSymbols r1 = java.text.DecimalFormatSymbols.getInstance(r1)
            com.global.didi.elvish.LocationInfo r2 = r9.f52578b
            java.lang.String r2 = r2.getLocaleString()
            java.lang.String r2 = r14.getDecimalSymbol(r2)
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x00ae
            r3 = 1
            goto L_0x00af
        L_0x00ae:
            r3 = 0
        L_0x00af:
            r5 = 0
            if (r3 == 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r2 = r5
        L_0x00b4:
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r6 = "(this as java.lang.String).toCharArray()"
            java.lang.String r7 = "decimalFormatSymbol"
            if (r2 == 0) goto L_0x00ec
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
            if (r2 == 0) goto L_0x00e6
            char[] r8 = r2.toCharArray()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r6)
            char r8 = kotlin.collections.ArraysKt.first((char[]) r8)
            r1.setDecimalSeparator(r8)
            if (r2 == 0) goto L_0x00e0
            char[] r2 = r2.toCharArray()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)
            char r2 = kotlin.collections.ArraysKt.first((char[]) r2)
            r1.setMonetaryDecimalSeparator(r2)
            goto L_0x00ec
        L_0x00e0:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r3)
            throw r10
        L_0x00e6:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r3)
            throw r10
        L_0x00ec:
            com.global.didi.elvish.LocationInfo r2 = r9.f52578b
            java.lang.String r2 = r2.getLocaleString()
            java.lang.String r14 = r14.getGroupSymbol(r2)
            r2 = r14
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0100
            r0 = 1
        L_0x0100:
            if (r0 == 0) goto L_0x0103
            r5 = r14
        L_0x0103:
            if (r5 == 0) goto L_0x011f
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
            if (r5 == 0) goto L_0x0119
            char[] r14 = r5.toCharArray()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r6)
            char r14 = kotlin.collections.ArraysKt.first((char[]) r14)
            r1.setGroupingSeparator(r14)
            goto L_0x011f
        L_0x0119:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r3)
            throw r10
        L_0x011f:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
            r14 = 48
            r1.setZeroDigit(r14)
            java.text.DecimalFormat r14 = new java.text.DecimalFormat
            r14.<init>(r12, r1)
            java.text.NumberFormat r14 = (java.text.NumberFormat) r14
            r12 = r14
            java.text.DecimalFormat r12 = (java.text.DecimalFormat) r12
            r12.setMaximumFractionDigits(r13)
            java.lang.String r10 = r14.format(r10)     // Catch:{ Exception -> 0x0154 }
            com.global.didi.elvish.util.LogUtils r11 = com.global.didi.elvish.util.LogUtils.INSTANCE     // Catch:{ Exception -> 0x0154 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            r12.<init>()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r13 = "formatDistance : "
            r12.append(r13)     // Catch:{ Exception -> 0x0154 }
            r12.append(r10)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0154 }
            r11.mo132614d(r12)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r11 = "result"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r11)     // Catch:{ Exception -> 0x0154 }
            return r10
        L_0x0154:
            java.lang.String r10 = ""
            return r10
        L_0x0157:
            java.lang.NumberFormatException r10 = new java.lang.NumberFormatException
            java.lang.String r11 = "meter and precision must > 0!"
            r10.<init>(r11)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.global.didi.elvish.distance.DistanceApi.formatDistance(double, com.global.didi.elvish.DistanceStyle, int, boolean):java.lang.String");
    }

    public final List<String> splitDistance(double d, DistanceStyle distanceStyle, int i) {
        String str;
        Intrinsics.checkParameterIsNotNull(distanceStyle, "distanceStyle");
        String formatDistance = formatDistance(d, distanceStyle, i, true);
        Pattern compile = Pattern.compile("\\{.*\\}");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(regex)");
        Matcher matcher = compile.matcher(formatDistance);
        Intrinsics.checkExpressionValueIsNotNull(matcher, "compile.matcher(ret)");
        if (matcher.find()) {
            str = matcher.group();
            Intrinsics.checkExpressionValueIsNotNull(str, "matcher.group()");
        } else {
            str = "";
        }
        String str2 = str;
        int length = str2.length() - 1;
        if (str2 != null) {
            String substring = str2.substring(1, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(formatDistance, str2, "", false, 4, (Object) null);
            if (replace$default != null) {
                return CollectionsKt.listOf(substring, StringsKt.trim(replace$default).toString());
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
