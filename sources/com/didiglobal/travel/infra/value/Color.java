package com.didiglobal.travel.infra.value;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.mozilla.javascript.typedarrays.Conversions;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b@\u0018\u0000 52\u00020\u0001:\u00015B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\tJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J]\u0010\u001e\u001a\u00020\u001f2K\u0010 \u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001f0!H\b¢\u0006\u0004\b'\u0010(Jr\u0010\u001e\u001a\u00020\u001f2`\u0010 \u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u001f0)H\b¢\u0006\u0004\b'\u0010*J\u0017\u0010+\u001a\u00020,2\b\b\u0001\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020,H\u0007¢\u0006\u0004\b1\u00102J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u00066"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/value/Color;", "", "rawValue", "", "constructor-impl", "(J)J", "alpha", "", "getAlpha-impl", "(J)I", "blue", "getBlue-impl", "colorInt", "getColorInt-impl", "green", "getGreen-impl", "red", "getRed-impl", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "equals", "", "other", "hashCode", "toComponents", "", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "r", "g", "b", "toComponents-impl", "(JLkotlin/jvm/functions/Function3;)V", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)V", "toHSV", "", "hsv", "toHSV-impl", "(J[F)[F", "toHSVArray", "toHSVArray-impl", "(J)[F", "toString", "", "Companion", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Color.kt */
public final class Color {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final long f51451b = m47231constructorimpl(Conversions.THIRTYTWO_BIT);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Regex f51452c = new Regex("^#([0-1a-fA-F]{6}|[0-1a-fA-F]{8})$");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String[] f51453d = {"black", "darkgray", "gray", "lightgray", "white", "red", "green", "blue", "yellow", "cyan", "magenta", "aqua", "fuchsia", "darkgrey", "grey", "lightgrey", "lime", "maroon", "navy", "olive", "purple", "silver", "teal"};

    /* renamed from: a */
    private final long f51454a;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Color m47226boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47231constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47232equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m47245unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47233equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getColorInt-impl  reason: not valid java name */
    public static final int m47236getColorIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47239hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47244toStringimpl(long j) {
        return "Color(rawValue=" + j + ")";
    }

    public boolean equals(Object obj) {
        return m47232equalsimpl(this.f51454a, obj);
    }

    public int hashCode() {
        return m47239hashCodeimpl(this.f51454a);
    }

    public String toString() {
        return m47244toStringimpl(this.f51454a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m47245unboximpl() {
        return this.f51454a;
    }

    private /* synthetic */ Color(long j) {
        this.f51454a = j;
    }

    /* renamed from: getAlpha-impl  reason: not valid java name */
    public static final int m47234getAlphaimpl(long j) {
        return android.graphics.Color.alpha(m47236getColorIntimpl(j));
    }

    /* renamed from: getRed-impl  reason: not valid java name */
    public static final int m47238getRedimpl(long j) {
        return android.graphics.Color.red(m47236getColorIntimpl(j));
    }

    /* renamed from: getGreen-impl  reason: not valid java name */
    public static final int m47237getGreenimpl(long j) {
        return android.graphics.Color.green(m47236getColorIntimpl(j));
    }

    /* renamed from: getBlue-impl  reason: not valid java name */
    public static final int m47235getBlueimpl(long j) {
        return android.graphics.Color.blue(m47236getColorIntimpl(j));
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m47227component1impl(long j) {
        return m47238getRedimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m47228component2impl(long j) {
        return m47237getGreenimpl(j);
    }

    /* renamed from: component3-impl  reason: not valid java name */
    public static final int m47229component3impl(long j) {
        return m47235getBlueimpl(j);
    }

    /* renamed from: component4-impl  reason: not valid java name */
    public static final int m47230component4impl(long j) {
        return m47234getAlphaimpl(j);
    }

    /* renamed from: toHSV-impl  reason: not valid java name */
    public static final float[] m47242toHSVimpl(long j, float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "hsv");
        android.graphics.Color.colorToHSV(m47236getColorIntimpl(j), fArr);
        return fArr;
    }

    /* renamed from: toHSVArray-impl  reason: not valid java name */
    public static final float[] m47243toHSVArrayimpl(long j) {
        float[] fArr = new float[3];
        android.graphics.Color.colorToHSV(m47236getColorIntimpl(j), fArr);
        return fArr;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final void m47240toComponentsimpl(long j, Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "action");
        function3.invoke(Integer.valueOf(m47227component1impl(j)), Integer.valueOf(m47228component2impl(j)), Integer.valueOf(m47229component3impl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final void m47241toComponentsimpl(long j, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "action");
        function4.invoke(Integer.valueOf(m47227component1impl(j)), Integer.valueOf(m47228component2impl(j)), Integer.valueOf(m47229component3impl(j)), Integer.valueOf(m47230component4impl(j)));
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u00102\b\b\u0003\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\"\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0003\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0018\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0019\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ,\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u001b\u001a\u00020\u00142\b\b\u0001\u0010\u001c\u001a\u00020\u00142\b\b\u0001\u0010\u001d\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ6\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u001b\u001a\u00020\u00142\b\b\u0001\u0010\u001c\u001a\u00020\u00142\b\b\u0001\u0010\u001d\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010!R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, mo175978d2 = {"Lcom/didiglobal/travel/infra/value/Color$Companion;", "", "()V", "COLOR_NAME_ARRAY", "", "", "[Ljava/lang/String;", "COLOR_WEB_PATTERN", "Lkotlin/text/Regex;", "UNKNOWN", "Lcom/didiglobal/travel/infra/value/Color;", "getUNKNOWN", "()J", "J", "of", "h", "", "s", "v", "alpha", "", "(FFFI)J", "hsv", "", "([FI)J", "color", "(I)J", "red", "green", "blue", "(III)J", "(IIII)J", "colorString", "(Ljava/lang/String;)J", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Color.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getUNKNOWN() {
            return Color.f51451b;
        }

        /* renamed from: of */
        public final long mo124948of(String str) {
            boolean z;
            Intrinsics.checkParameterIsNotNull(str, "colorString");
            if (str.charAt(0) == '#') {
                z = Color.f51452c.matches(str);
            } else {
                String[] access$getCOLOR_NAME_ARRAY$cp = Color.f51453d;
                Locale locale = Locale.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                z = ArraysKt.contains((T[]) access$getCOLOR_NAME_ARRAY$cp, lowerCase);
            }
            if (!z) {
                return getUNKNOWN();
            }
            try {
                return Color.m47231constructorimpl((long) android.graphics.Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                return getUNKNOWN();
            }
        }

        /* renamed from: of */
        public final long mo124945of(int i) {
            return Color.m47231constructorimpl((long) i);
        }

        /* renamed from: of */
        public final long mo124946of(int i, int i2, int i3) {
            return Color.m47231constructorimpl((long) android.graphics.Color.rgb(i, i2, i3));
        }

        /* renamed from: of */
        public final long mo124947of(int i, int i2, int i3, int i4) {
            return Color.m47231constructorimpl((long) android.graphics.Color.argb(i, i2, i3, i4));
        }

        public static /* synthetic */ long of$default(Companion companion, float[] fArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 255;
            }
            return companion.mo124949of(fArr, i);
        }

        /* renamed from: of */
        public final long mo124949of(float[] fArr, int i) {
            Intrinsics.checkParameterIsNotNull(fArr, "hsv");
            if (fArr.length >= 3) {
                return Color.m47231constructorimpl((long) android.graphics.Color.HSVToColor(i, fArr));
            }
            throw new IllegalArgumentException("3 components required for hsv");
        }

        public static /* synthetic */ long of$default(Companion companion, float f, float f2, float f3, int i, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                i = 255;
            }
            return companion.mo124944of(f, f2, f3, i);
        }

        /* renamed from: of */
        public final long mo124944of(float f, float f2, float f3, int i) {
            return Color.m47231constructorimpl((long) android.graphics.Color.HSVToColor(i, new float[]{f, f2, f3}));
        }
    }
}
