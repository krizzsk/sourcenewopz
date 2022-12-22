package com.cardinalcommerce.p060a;

import com.didi.sdk.push.fcm.Constact;
import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setTypeface */
public final class setTypeface implements Runnable {

    /* renamed from: i */
    private static int f3074i = 0;

    /* renamed from: j */
    private static int f3075j = 1;
    public setBaselineAligned Cardinal;
    public char[] CardinalError;
    public char[] CardinalRenderType;

    /* renamed from: a */
    private char[] f3076a;

    /* renamed from: b */
    private char[] f3077b;

    /* renamed from: c */
    private char[] f3078c;
    public char[] cca_continue;
    public boolean cleanup;
    public char[] configure;

    /* renamed from: d */
    private char[] f3079d;

    /* renamed from: e */
    private char[] f3080e;

    /* renamed from: f */
    private char[] f3081f;

    /* renamed from: g */
    private char[] f3082g;
    public setTransformationMethod getInstance;
    public char[] getSDKVersion;
    public char[] getWarnings;

    /* renamed from: h */
    private char[] f3083h;
    public char[] init;
    public char[] values;

    /* renamed from: a */
    static /* synthetic */ char[] m2157a(setTypeface settypeface) {
        int i = f3075j;
        int i2 = i & 113;
        int i3 = i2 - (~(-(-((i ^ 113) | i2))));
        boolean z = true;
        int i4 = i3 - 1;
        f3074i = i4 % 128;
        int i5 = i4 % 2;
        char[] cArr = settypeface.f3082g;
        int i6 = f3075j;
        int i7 = (((i6 ^ 47) | (i6 & 47)) << 1) - (((~i6) & 47) | (i6 & -48));
        f3074i = i7 % 128;
        if (i7 % 2 == 0) {
            z = false;
        }
        if (!z) {
            return cArr;
        }
        int i8 = 39 / 0;
        return cArr;
    }

    /* renamed from: b */
    static /* synthetic */ char[] m2158b(setTypeface settypeface) {
        int i = f3075j;
        int i2 = i & 93;
        int i3 = (((i | 93) & (~i2)) - (~(i2 << 1))) - 1;
        f3074i = i3 % 128;
        boolean z = i3 % 2 != 0;
        char[] cArr = settypeface.f3083h;
        if (z) {
            int i4 = 61 / 0;
        }
        return cArr;
    }

    /* renamed from: c */
    static /* synthetic */ char[] m2159c(setTypeface settypeface) {
        int i = f3075j;
        int i2 = (i & 28) + (i | 28);
        boolean z = true;
        int i3 = ((i2 | -1) << 1) - (i2 ^ -1);
        f3074i = i3 % 128;
        if (i3 % 2 == 0) {
            z = false;
        }
        char[] cArr = settypeface.configure;
        if (z) {
            int i4 = 65 / 0;
        }
        return cArr;
    }

    /* renamed from: d */
    static /* synthetic */ char[] m2160d(setTypeface settypeface) {
        int i = f3074i;
        int i2 = ((i ^ 43) | (i & 43)) << 1;
        int i3 = -(((~i) & 43) | (i & -44));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3075j = i4 % 128;
        boolean z = i4 % 2 == 0;
        char[] cArr = settypeface.cca_continue;
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i5 = f3074i;
        int i6 = i5 ^ 121;
        int i7 = ((i5 & 121) | i6) << 1;
        int i8 = -i6;
        int i9 = ((i7 | i8) << 1) - (i7 ^ i8);
        f3075j = i9 % 128;
        int i10 = i9 % 2;
        return cArr;
    }

    /* renamed from: e */
    static /* synthetic */ char[] m2161e(setTypeface settypeface) {
        int i = f3075j;
        int i2 = (i ^ 6) + ((i & 6) << 1);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f3074i = i3 % 128;
        int i4 = i3 % 2;
        char[] cArr = settypeface.f3076a;
        int i5 = f3075j;
        int i6 = i5 & 103;
        int i7 = (i5 ^ 103) | i6;
        int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
        f3074i = i8 % 128;
        int i9 = i8 % 2;
        return cArr;
    }

    /* renamed from: f */
    static /* synthetic */ char[] m2162f(setTypeface settypeface) {
        int i = f3075j;
        int i2 = i & 13;
        int i3 = ((i ^ 13) | i2) << 1;
        int i4 = -((i | 13) & (~i2));
        int i5 = ((i3 | i4) << 1) - (i4 ^ i3);
        f3074i = i5 % 128;
        int i6 = i5 % 2;
        char[] cArr = settypeface.getSDKVersion;
        int i7 = f3074i;
        int i8 = i7 & 101;
        int i9 = i7 | 101;
        int i10 = (i8 ^ i9) + ((i9 & i8) << 1);
        f3075j = i10 % 128;
        int i11 = i10 % 2;
        return cArr;
    }

    /* renamed from: g */
    static /* synthetic */ char[] m2163g(setTypeface settypeface) {
        int i = f3074i;
        int i2 = (i & 13) + (i | 13);
        f3075j = i2 % 128;
        boolean z = i2 % 2 != 0;
        char[] cArr = settypeface.f3077b;
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return cArr;
    }

    /* renamed from: h */
    static /* synthetic */ char[] m2164h(setTypeface settypeface) {
        int i = f3074i;
        int i2 = i & 19;
        int i3 = i | 19;
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3075j = i4 % 128;
        int i5 = i4 % 2;
        char[] cArr = settypeface.f3080e;
        int i6 = f3075j;
        int i7 = (i6 | 41) << 1;
        int i8 = -(((~i6) & 41) | (i6 & -42));
        int i9 = (i7 ^ i8) + ((i8 & i7) << 1);
        f3074i = i9 % 128;
        if ((i9 % 2 != 0 ? IOUtils.DIR_SEPARATOR_WINDOWS : 4) == 4) {
            return cArr;
        }
        int i10 = 56 / 0;
        return cArr;
    }

    /* renamed from: i */
    static /* synthetic */ char[] m2165i(setTypeface settypeface) {
        int i = f3075j;
        int i2 = ((i | 105) << 1) - (i ^ 105);
        f3074i = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = settypeface.f3078c;
        int i4 = f3075j;
        int i5 = ((i4 | 111) << 1) - (i4 ^ 111);
        f3074i = i5 % 128;
        if ((i5 % 2 != 0 ? 'G' : Typography.quote) != 'G') {
            return cArr;
        }
        int i6 = 8 / 0;
        return cArr;
    }

    /* renamed from: j */
    static /* synthetic */ char[] m2166j(setTypeface settypeface) {
        int i = f3075j;
        int i2 = (i & -48) | ((~i) & 47);
        int i3 = -(-((i & 47) << 1));
        int i4 = (i2 & i3) + (i3 | i2);
        f3074i = i4 % 128;
        int i5 = i4 % 2;
        char[] cArr = settypeface.f3079d;
        int i6 = f3075j;
        int i7 = (((i6 | 12) << 1) - (i6 ^ 12)) - 1;
        f3074i = i7 % 128;
        int i8 = i7 % 2;
        return cArr;
    }

    /* renamed from: k */
    private static /* synthetic */ char[] m2167k(setTypeface settypeface) {
        int i = f3075j;
        int i2 = (i & 119) + (i | 119);
        f3074i = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = settypeface.init;
        int i4 = f3074i;
        int i5 = (((i4 ^ 113) | (i4 & 113)) << 1) - (((~i4) & 113) | (i4 & -114));
        f3075j = i5 % 128;
        int i6 = i5 % 2;
        return cArr;
    }

    /* renamed from: l */
    private static /* synthetic */ char[] m2168l(setTypeface settypeface) {
        int i = f3075j + 35;
        f3074i = i % 128;
        int i2 = i % 2;
        char[] cArr = settypeface.CardinalError;
        int i3 = f3074i;
        int i4 = ((i3 ^ 77) | (i3 & 77)) << 1;
        int i5 = -(((~i3) & 77) | (i3 & -78));
        int i6 = (i4 & i5) + (i5 | i4);
        f3075j = i6 % 128;
        int i7 = i6 % 2;
        return cArr;
    }

    /* renamed from: m */
    private static /* synthetic */ char[] m2169m(setTypeface settypeface) {
        int i = f3074i;
        int i2 = i & 43;
        int i3 = (i | 43) & (~i2);
        int i4 = i2 << 1;
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f3075j = i5 % 128;
        int i6 = i5 % 2;
        char[] cArr = settypeface.f3081f;
        int i7 = f3075j;
        int i8 = i7 & 11;
        int i9 = i7 | 11;
        int i10 = ((i8 | i9) << 1) - (i9 ^ i8);
        f3074i = i10 % 128;
        int i11 = i10 % 2;
        return cArr;
    }

    /* renamed from: n */
    private static /* synthetic */ char[] m2170n(setTypeface settypeface) {
        int i = f3074i;
        int i2 = (((i & 76) + (i | 76)) - 0) - 1;
        f3075j = i2 % 128;
        boolean z = i2 % 2 == 0;
        char[] cArr = settypeface.values;
        if (z) {
            int i3 = 20 / 0;
        }
        return cArr;
    }

    /* renamed from: o */
    private static /* synthetic */ char[] m2171o(setTypeface settypeface) {
        int i = f3074i;
        int i2 = i & 119;
        int i3 = (((i ^ 119) | i2) << 1) - ((i | 119) & (~i2));
        f3075j = i3 % 128;
        boolean z = i3 % 2 != 0;
        Object obj = null;
        char[] cArr = settypeface.getWarnings;
        if (!z) {
            super.hashCode();
        }
        int i4 = f3074i;
        int i5 = (i4 ^ 24) + ((i4 & 24) << 1);
        int i6 = (i5 ^ -1) + ((i5 & -1) << 1);
        f3075j = i6 % 128;
        if ((i6 % 2 == 0 ? 'C' : 'S') == 'S') {
            return cArr;
        }
        super.hashCode();
        return cArr;
    }

    /* renamed from: p */
    private static /* synthetic */ char[] m2172p(setTypeface settypeface) {
        int i = f3074i;
        int i2 = ((i ^ 85) | (i & 85)) << 1;
        int i3 = -(((~i) & 85) | (i & -86));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3075j = i4 % 128;
        boolean z = i4 % 2 == 0;
        char[] cArr = settypeface.CardinalRenderType;
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i5 = ((f3075j + 112) - 0) - 1;
        f3074i = i5 % 128;
        int i6 = i5 % 2;
        return cArr;
    }

    public setTypeface(setBaselineAligned setbaselinealigned, setCompoundDrawablesWithIntrinsicBounds setcompounddrawableswithintrinsicbounds) {
        this.Cardinal = setbaselinealigned;
        this.getInstance = new setTransformationMethod();
        this.f3076a = setHorizontallyScrolling.getInstance(setbaselinealigned.configure);
        this.f3077b = setHorizontallyScrolling.getInstance(setbaselinealigned.cca_continue);
        this.f3080e = setHorizontallyScrolling.getInstance(setbaselinealigned.setRequestTimeout);
        this.f3078c = setHorizontallyScrolling.getInstance("CReq");
        this.f3079d = setHorizontallyScrolling.getInstance(setbaselinealigned.CardinalConfigurationParameters);
        if (!setHorizontallyScrolling.init(setcompounddrawableswithintrinsicbounds.getInstance)) {
            this.cca_continue = setcompounddrawableswithintrinsicbounds.getInstance;
        } else if (!setHorizontallyScrolling.init(setcompounddrawableswithintrinsicbounds.init)) {
            char[] cArr = setcompounddrawableswithintrinsicbounds.init;
            if (cArr.length <= 45) {
                this.configure = cArr;
            } else {
                setTransformationMethod settransformationmethod = this.getInstance;
                settransformationmethod.Cardinal = false;
                settransformationmethod.getInstance("challengeDataEntry");
            }
        } else if (!setHorizontallyScrolling.init(setcompounddrawableswithintrinsicbounds.configure)) {
            char[] cArr2 = setcompounddrawableswithintrinsicbounds.configure;
            if (cArr2.length <= 256) {
                this.init = cArr2;
            } else {
                setTransformationMethod settransformationmethod2 = this.getInstance;
                settransformationmethod2.Cardinal = false;
                settransformationmethod2.getInstance("challengeHTMLDataEntry");
            }
        } else if (!setHorizontallyScrolling.init(setcompounddrawableswithintrinsicbounds.Cardinal)) {
            this.CardinalError = setcompounddrawableswithintrinsicbounds.Cardinal;
        } else if (setbaselinealigned.CardinalConfigurationParameters.equalsIgnoreCase("2.2.0") && CardinalActionCode()) {
            this.f3083h = setHeight.configure;
        }
        if (setcompounddrawableswithintrinsicbounds.configure() != null && !setHorizontallyScrolling.init(setcompounddrawableswithintrinsicbounds.configure())) {
            this.f3082g = setcompounddrawableswithintrinsicbounds.configure();
        }
        if (setcompounddrawableswithintrinsicbounds.cca_continue) {
            this.cleanup = true;
        }
    }

    public setTypeface(char[] cArr, char[] cArr2, int i, char[] cArr3, char[] cArr4, char[] cArr5) {
        this.f3076a = cArr;
        this.f3077b = cArr2;
        this.getInstance = new setTransformationMethod();
        this.f3078c = setHorizontallyScrolling.getInstance("CReq");
        this.f3079d = cArr4;
        this.f3080e = cArr3;
        cca_continue(i);
        if (!setHorizontallyScrolling.init(cArr5)) {
            this.getSDKVersion = cArr5;
        }
    }

    public final char[] cca_continue() {
        int i = f3074i + 65;
        f3075j = i % 128;
        int i2 = i % 2;
        char[] cArr = this.f3076a;
        int i3 = f3075j;
        int i4 = i3 & 65;
        int i5 = -(-((i3 ^ 65) | i4));
        int i6 = (i4 & i5) + (i5 | i4);
        f3074i = i6 % 128;
        if ((i6 % 2 != 0 ? 'K' : 'X') != 'K') {
            return cArr;
        }
        int i7 = 81 / 0;
        return cArr;
    }

    public final char[] Cardinal() {
        char[] cArr;
        int i = f3075j;
        int i2 = (i & -6) | ((~i) & 5);
        int i3 = -(-((i & 5) << 1));
        int i4 = (i2 & i3) + (i3 | i2);
        f3074i = i4 % 128;
        if ((i4 % 2 != 0 ? 14 : '6') != '6') {
            cArr = this.f3077b;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            cArr = this.f3077b;
        }
        int i5 = f3074i;
        int i6 = ((i5 ^ 115) - (~(-(-((i5 & 115) << 1))))) - 1;
        f3075j = i6 % 128;
        int i7 = i6 % 2;
        return cArr;
    }

    public final char[] init() {
        char[] cArr;
        int i = f3075j;
        int i2 = (i & 24) + (i | 24);
        int i3 = ((i2 | -1) << 1) - (i2 ^ -1);
        f3074i = i3 % 128;
        if (i3 % 2 != 0) {
            cArr = this.cca_continue;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            cArr = this.cca_continue;
        }
        int i4 = f3075j;
        int i5 = i4 ^ 25;
        int i6 = ((i4 & 25) | i5) << 1;
        int i7 = -i5;
        int i8 = ((i6 | i7) << 1) - (i6 ^ i7);
        f3074i = i8 % 128;
        int i9 = i8 % 2;
        return cArr;
    }

    public final char[] getInstance() {
        int i = (((f3075j + 3) - 1) + 0) - 1;
        f3074i = i % 128;
        int i2 = i % 2;
        char[] cArr = this.configure;
        int i3 = f3075j;
        int i4 = ((i3 & -74) | ((~i3) & 73)) + ((i3 & 73) << 1);
        f3074i = i4 % 128;
        int i5 = i4 % 2;
        return cArr;
    }

    public final char[] configure() {
        int i = f3075j;
        int i2 = i & 47;
        int i3 = (((i ^ 47) | i2) << 1) - ((i | 47) & (~i2));
        f3074i = i3 % 128;
        int i4 = i3 % 2;
        char[] cArr = this.init;
        int i5 = f3074i;
        int i6 = (i5 & 11) + (i5 | 11);
        f3075j = i6 % 128;
        int i7 = i6 % 2;
        return cArr;
    }

    public final boolean values() {
        int i = (f3074i + 64) - 1;
        f3075j = i % 128;
        int i2 = i % 2;
        boolean z = this.cleanup;
        int i3 = f3074i;
        int i4 = i3 & 19;
        int i5 = (i4 - (~(-(-((i3 ^ 19) | i4))))) - 1;
        f3075j = i5 % 128;
        if ((i5 % 2 == 0 ? 'b' : 31) != 'b') {
            return z;
        }
        int i6 = 15 / 0;
        return z;
    }

    public final char[] getSDKVersion() {
        int i = f3074i + 124;
        int i2 = (i & -1) + (i | -1);
        f3075j = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = this.CardinalError;
        int i4 = f3075j;
        int i5 = (i4 & -4) | ((~i4) & 3);
        int i6 = (i4 & 3) << 1;
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f3074i = i7 % 128;
        if (i7 % 2 == 0) {
            return cArr;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return cArr;
    }

    public final char[] CardinalError() {
        char[] cArr;
        int i = f3075j;
        int i2 = (((i | 40) << 1) - (i ^ 40)) - 1;
        f3074i = i2 % 128;
        if (!(i2 % 2 == 0)) {
            cArr = this.f3080e;
            int i3 = 89 / 0;
        } else {
            cArr = this.f3080e;
        }
        int i4 = f3074i;
        int i5 = i4 & 49;
        int i6 = (i4 | 49) & (~i5);
        int i7 = -(-(i5 << 1));
        int i8 = (i6 ^ i7) + ((i6 & i7) << 1);
        f3075j = i8 % 128;
        int i9 = i8 % 2;
        return cArr;
    }

    public final void cca_continue(int i) {
        int i2 = f3075j;
        int i3 = (i2 & 30) + (i2 | 30);
        boolean z = true;
        int i4 = (i3 ^ -1) + ((i3 & -1) << 1);
        f3074i = i4 % 128;
        if ((i4 % 2 != 0 ? 'c' : '$') != 'c') {
            String concat = "00".concat(String.valueOf(i));
            int length = concat.length();
            this.f3081f = setHorizontallyScrolling.getInstance(concat.substring((length ^ -3) + ((length & -3) << 1)));
        } else {
            String concat2 = "00".concat(String.valueOf(i));
            this.f3081f = setHorizontallyScrolling.getInstance(concat2.substring(concat2.length() << 3));
        }
        int i5 = f3075j;
        int i6 = i5 & 57;
        int i7 = i6 + ((i5 ^ 57) | i6);
        f3074i = i7 % 128;
        if (i7 % 2 != 0) {
            z = false;
        }
        if (!z) {
            Object[] objArr = null;
            int length2 = objArr.length;
        }
    }

    public final char[] cleanup() {
        int i = f3075j;
        int i2 = ((i | 45) << 1) - (i ^ 45);
        f3074i = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = this.f3082g;
        int i4 = (f3074i + 76) - 1;
        f3075j = i4 % 128;
        if ((i4 % 2 == 0 ? (char) 30 : 10) != 30) {
            return cArr;
        }
        Object obj = null;
        super.hashCode();
        return cArr;
    }

    public final char[] getWarnings() {
        int i = f3075j;
        int i2 = (i ^ 107) + ((i & 107) << 1);
        f3074i = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return this.getSDKVersion;
        }
        char[] cArr = this.getSDKVersion;
        Object[] objArr = null;
        int length = objArr.length;
        return cArr;
    }

    public final char[] valueOf() {
        int i = f3075j;
        int i2 = i | 19;
        int i3 = i2 << 1;
        int i4 = -((~(i & 19)) & i2);
        int i5 = ((i3 | i4) << 1) - (i4 ^ i3);
        f3074i = i5 % 128;
        int i6 = i5 % 2;
        char[] cArr = this.f3083h;
        int i7 = f3075j + 119;
        f3074i = i7 % 128;
        int i8 = i7 % 2;
        return cArr;
    }

    public final char[] CardinalUiType() {
        char[] cArr;
        int i = f3075j;
        int i2 = i & 119;
        int i3 = (i ^ 119) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f3074i = i4 % 128;
        if (!(i4 % 2 != 0)) {
            cArr = this.getWarnings;
        } else {
            int i5 = 44 / 0;
            cArr = this.getWarnings;
        }
        int i6 = (f3074i + 124) - 1;
        f3075j = i6 % 128;
        if ((i6 % 2 == 0 ? '8' : 18) != '8') {
            return cArr;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return cArr;
    }

    public final char[] CardinalRenderType() {
        char[] cArr;
        int i = f3074i;
        int i2 = i ^ 73;
        int i3 = (i & 73) << 1;
        int i4 = (i2 & i3) + (i3 | i2);
        f3075j = i4 % 128;
        if ((i4 % 2 == 0 ? '7' : VersionRange.RIGHT_CLOSED) != ']') {
            cArr = this.CardinalRenderType;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            cArr = this.CardinalRenderType;
        }
        int i5 = f3074i;
        int i6 = ((((i5 | 100) << 1) - (i5 ^ 100)) + 0) - 1;
        f3075j = i6 % 128;
        int i7 = i6 % 2;
        return cArr;
    }

    public final char[] CardinalEnvironment() {
        int i = f3075j;
        int i2 = (i & 47) + (i | 47);
        f3074i = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = this.values;
        int i4 = f3074i;
        int i5 = ((i4 & 78) + (i4 | 78)) - 1;
        f3075j = i5 % 128;
        if ((i5 % 2 == 0 ? 'c' : 24) == 24) {
            return cArr;
        }
        int i6 = 17 / 0;
        return cArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        if ((!r6.Cardinal.init.equals("05")) != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if ((!r6.Cardinal.init.equals("05") ? org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_ZERO : 'C') != 'Z') goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean CardinalActionCode() {
        /*
            r6 = this;
            int r0 = f3074i
            r1 = r0 ^ 3
            r2 = r0 & 3
            r1 = r1 | r2
            r2 = 1
            int r1 = r1 << r2
            r3 = r0 & -4
            int r0 = ~r0
            r0 = r0 & 3
            r0 = r0 | r3
            int r0 = -r0
            r3 = r1 & r0
            r0 = r0 | r1
            int r3 = r3 + r0
            int r0 = r3 % 128
            f3075j = r0
            int r3 = r3 % 2
            r0 = 0
            if (r3 != 0) goto L_0x001f
            r1 = 0
            goto L_0x0020
        L_0x001f:
            r1 = 1
        L_0x0020:
            java.lang.String r3 = "05"
            if (r1 == 0) goto L_0x0034
            com.cardinalcommerce.a.setBaselineAligned r1 = r6.Cardinal
            java.lang.String r1 = r1.init
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0030
            r1 = 1
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            if (r1 == 0) goto L_0x006f
            goto L_0x004b
        L_0x0034:
            com.cardinalcommerce.a.setBaselineAligned r1 = r6.Cardinal
            java.lang.String r1 = r1.init
            boolean r1 = r1.equals(r3)
            r3 = 73
            int r3 = r3 / r0
            r3 = 90
            if (r1 != 0) goto L_0x0046
            r1 = 90
            goto L_0x0048
        L_0x0046:
            r1 = 67
        L_0x0048:
            if (r1 == r3) goto L_0x004b
            goto L_0x006f
        L_0x004b:
            int r1 = f3075j
            r3 = r1 ^ 32
            r1 = r1 & 32
            int r1 = r1 << r2
            int r3 = r3 + r1
            r1 = r3 & -1
            r3 = r3 | -1
            int r1 = r1 + r3
            int r3 = r1 % 128
            f3074i = r3
            int r1 = r1 % 2
            com.cardinalcommerce.a.setBaselineAligned r1 = r6.Cardinal
            java.lang.String r1 = r1.init
            java.lang.String r3 = "04"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x006c
            r1 = 1
            goto L_0x006d
        L_0x006c:
            r1 = 0
        L_0x006d:
            if (r1 == r2) goto L_0x0092
        L_0x006f:
            int r1 = f3074i
            r3 = 123(0x7b, float:1.72E-43)
            r4 = r1 & -124(0xffffffffffffff84, float:NaN)
            int r5 = ~r1
            r5 = r5 & r3
            r4 = r4 | r5
            r1 = r1 & r3
            int r1 = r1 << r2
            r3 = r4 | r1
            int r3 = r3 << r2
            r1 = r1 ^ r4
            int r3 = r3 - r1
            int r1 = r3 % 128
            f3075j = r1
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0088
            r2 = 0
        L_0x0088:
            if (r2 == 0) goto L_0x008b
            return r0
        L_0x008b:
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x0090 }
            return r0
        L_0x0090:
            r0 = move-exception
            throw r0
        L_0x0092:
            int r0 = f3074i
            r1 = 17
            r3 = r0 ^ 17
            r4 = r0 & 17
            r3 = r3 | r4
            int r3 = r3 << r2
            r4 = r0 & -18
            int r0 = ~r0
            r0 = r0 & r1
            r0 = r0 | r4
            int r3 = r3 - r0
            int r0 = r3 % 128
            f3075j = r0
            int r3 = r3 % 2
            int r0 = f3074i
            int r0 = r0 + 10
            int r0 = r0 - r2
            int r1 = r0 % 128
            f3075j = r1
            int r0 = r0 % 2
            return r2
        L_0x00b4:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTypeface.CardinalActionCode():boolean");
    }

    public final JSONObject CardinalConfigurationParameters() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("threeDSServerTransID", new String(this.f3076a));
        jSONObject.put("acsTransID", setHorizontallyScrolling.configure(this.f3077b));
        jSONObject.put("messageExtension", (Object) null);
        jSONObject.put(Constact.KEY_LINK_MESSAGETYPE, setHorizontallyScrolling.configure(this.f3078c));
        jSONObject.put("messageVersion", setHorizontallyScrolling.configure(this.f3079d));
        jSONObject.put("sdkTransID", setHorizontallyScrolling.configure(this.f3080e));
        jSONObject.put("sdkCounterStoA", setHorizontallyScrolling.configure(this.f3081f));
        if ((getWarnings() != null ? 7 : ';') == 7) {
            int i = f3075j;
            int i2 = (i ^ 99) + ((i & 99) << 1);
            f3074i = i2 % 128;
            int i3 = i2 % 2;
            jSONObject.put("threeDSRequestorAppURL", setHorizontallyScrolling.configure(getWarnings()));
            int i4 = f3074i;
            int i5 = i4 & 5;
            int i6 = -(-((i4 ^ 5) | i5));
            int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
            f3075j = i7 % 128;
            int i8 = i7 % 2;
        }
        int i9 = f3074i;
        int i10 = (i9 & -56) | ((~i9) & 55);
        int i11 = -(-((i9 & 55) << 1));
        int i12 = (i10 & i11) + (i11 | i10);
        f3075j = i12 % 128;
        int i13 = i12 % 2;
        return jSONObject;
    }

    public final void run() {
        int i = f3075j;
        int i2 = ((i | 124) << 1) - (i ^ 124);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f3074i = i3 % 128;
        int i4 = i3 % 2;
        setHorizontallyScrolling.getInstance(m2167k(this));
        setHorizontallyScrolling.getInstance((char[]) null);
        setHorizontallyScrolling.getInstance(m2168l(this));
        setHorizontallyScrolling.getInstance(m2169m(this));
        setHorizontallyScrolling.getInstance(m2170n(this));
        setHorizontallyScrolling.getInstance(m2171o(this));
        setHorizontallyScrolling.getInstance(m2172p(this));
        int i5 = f3074i;
        int i6 = i5 & 103;
        int i7 = i6 + ((i5 ^ 103) | i6);
        f3075j = i7 % 128;
        if (!(i7 % 2 != 0)) {
            int i8 = 31 / 0;
        }
    }
}
