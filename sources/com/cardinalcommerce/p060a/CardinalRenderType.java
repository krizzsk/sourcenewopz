package com.cardinalcommerce.p060a;

import kotlin.text.Typography;

/* renamed from: com.cardinalcommerce.a.CardinalRenderType */
public class CardinalRenderType extends setTextMetricsParams {

    /* renamed from: a */
    private static volatile CardinalRenderType f2344a = null;

    /* renamed from: b */
    private static int f2345b = 0;

    /* renamed from: c */
    private static int f2346c = 1;

    public static CardinalRenderType cca_continue() {
        if (f2344a == null) {
            synchronized (CardinalRenderType.class) {
                if (f2344a == null) {
                    f2344a = new CardinalRenderType();
                }
            }
        }
        return f2344a;
    }

    private CardinalRenderType() {
        if (f2344a == null) {
            setTextMetricsParams.cca_continue(true);
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance.");
    }

    public final setJustificationMode configure() {
        setJustificationMode setjustificationmode;
        int i = f2345b;
        int i2 = ((i | 17) << 1) - (i ^ 17);
        f2346c = i2 % 128;
        if (!(i2 % 2 != 0)) {
            setjustificationmode = super.configure();
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            setjustificationmode = super.configure();
        }
        int i3 = f2346c;
        int i4 = i3 & 17;
        int i5 = (((i3 | 17) & (~i4)) - (~(i4 << 1))) - 1;
        f2345b = i5 % 128;
        int i6 = i5 % 2;
        return setjustificationmode;
    }

    public final void init(String str, String str2, String str3) {
        boolean z = true;
        int i = (f2345b + 50) - 1;
        f2346c = i % 128;
        int i2 = i % 2;
        if ((getInstance ? (char) 2 : 1) != 1) {
            int i3 = f2345b;
            int i4 = i3 & 75;
            int i5 = ((((i3 ^ 75) | i4) << 1) - (~(-((i3 | 75) & (~i4))))) - 1;
            f2346c = i5 % 128;
            int i6 = i5 % 2;
            C2014init.init();
            Cardinal = C2014init.configure(setShadowLayer.cca_continue);
            configure = "CardinalLoggerV1";
            super.init(str, str2, str3);
            int i7 = f2346c;
            int i8 = (((i7 | 59) << 1) - (~(-(((~i7) & 59) | (i7 & -60))))) - 1;
            f2345b = i8 % 128;
            int i9 = i8 % 2;
        }
        int i10 = f2346c;
        int i11 = i10 & 75;
        int i12 = (((i10 ^ 75) | i11) << 1) - ((i10 | 75) & (~i11));
        f2345b = i12 % 128;
        if (i12 % 2 == 0) {
            z = false;
        }
        if (z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void configure(String str, String str2, String str3) {
        int i = f2345b + 62;
        int i2 = (i & -1) + (i | -1);
        f2346c = i2 % 128;
        int i3 = i2 % 2;
        if ((getInstance ? 18 : '5') == 18) {
            int i4 = (f2345b + 16) - 1;
            f2346c = i4 % 128;
            int i5 = i4 % 2;
            C2014init.init();
            Cardinal = C2014init.configure(setShadowLayer.cca_continue);
            configure = "CardinalLoggerV1";
            super.configure(str, str2, str3);
            int i6 = f2346c + 107;
            f2345b = i6 % 128;
            int i7 = i6 % 2;
        }
        int i8 = f2346c;
        int i9 = i8 & 9;
        int i10 = -(-((i8 ^ 9) | i9));
        int i11 = (i9 ^ i10) + ((i10 & i9) << 1);
        f2345b = i11 % 128;
        if (i11 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void configure(String str) {
        int i = f2346c;
        int i2 = (i ^ 87) + ((i & 87) << 1);
        f2345b = i2 % 128;
        char c = i2 % 2 != 0 ? 'D' : Typography.less;
        super.configure(str);
        if (c != '<') {
            int i3 = 92 / 0;
        }
        int i4 = f2346c;
        int i5 = i4 & 11;
        int i6 = (((i4 | 11) & (~i5)) - (~(i5 << 1))) - 1;
        f2345b = i6 % 128;
        if (!(i6 % 2 == 0)) {
            int i7 = 82 / 0;
        }
    }

    public final void Cardinal() {
        int i = f2345b;
        int i2 = (i ^ 123) + ((i & 123) << 1);
        f2346c = i2 % 128;
        boolean z = i2 % 2 == 0;
        super.Cardinal();
        if (z) {
            int i3 = 48 / 0;
        }
        int i4 = (f2345b + 88) - 1;
        f2346c = i4 % 128;
        if ((i4 % 2 == 0 ? 'F' : 'N') != 'N') {
            int i5 = 48 / 0;
        }
    }

    public final void init(String str, String str2) {
        int i = f2346c;
        int i2 = (i & -54) | ((~i) & 53);
        int i3 = -(-((i & 53) << 1));
        int i4 = (i2 & i3) + (i3 | i2);
        f2345b = i4 % 128;
        int i5 = i4 % 2;
        if ((getInstance ? '3' : 'K') == '3') {
            int i6 = (f2346c + 57) - 1;
            int i7 = (i6 & -1) + (i6 | -1);
            f2345b = i7 % 128;
            if (i7 % 2 != 0) {
                C2014init.init();
                Cardinal = C2014init.configure(setShadowLayer.cca_continue);
                configure = "CardinalLoggerV1";
                super.init(str, str2, (String) null);
                int i8 = 60 / 0;
            } else {
                C2014init.init();
                Cardinal = C2014init.configure(setShadowLayer.cca_continue);
                configure = "CardinalLoggerV1";
                super.init(str, str2, (String) null);
            }
        }
        int i9 = f2345b;
        int i10 = (i9 & -48) | ((~i9) & 47);
        int i11 = -(-((i9 & 47) << 1));
        int i12 = ((i10 | i11) << 1) - (i11 ^ i10);
        f2346c = i12 % 128;
        if ((i12 % 2 == 0 ? 'c' : 'I') != 'I') {
            int i13 = 38 / 0;
        }
    }
}
