package com.cardinalcommerce.p060a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.cardinalcommerce.p060a.setFontFeatureSettings;
import com.cardinalcommerce.shared.models.enums.ButtonType;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setTextLocales */
public class setTextLocales extends AppCompatActivity implements setAutoSizeTextTypeUniformWithConfiguration {

    /* renamed from: D */
    private static int f3021D = 0;

    /* renamed from: E */
    private static int f3022E = 1;

    /* renamed from: A */
    private String f3023A;

    /* renamed from: B */
    private WeakReference<Context> f3024B;

    /* renamed from: C */
    private BroadcastReceiver f3025C = new BroadcastReceiver() {
        private static int configure = 1;
        private static int getInstance;

        public final void onReceive(Context context, Intent intent) {
            int i = configure;
            int i2 = i & 15;
            int i3 = i2 + ((i ^ 15) | i2);
            getInstance = i3 % 128;
            int i4 = i3 % 2;
            if (intent.getAction().equals("finish_activity")) {
                int i5 = configure;
                int i6 = i5 ^ 21;
                int i7 = (i5 & 21) << 1;
                int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
                getInstance = i8 % 128;
                if ((i8 % 2 != 0 ? CharUtils.f5620CR : 24) != 13) {
                    setTextSelectHandle.cca_continue(setTextLocales.this.getApplicationContext()).configure();
                    setTextLocales.this.finish();
                } else {
                    setTextSelectHandle.cca_continue(setTextLocales.this.getApplicationContext()).configure();
                    setTextLocales.this.finish();
                    Object obj = null;
                    super.hashCode();
                }
            }
            int i9 = (getInstance + 92) - 1;
            configure = i9 % 128;
            int i10 = i9 % 2;
        }
    };

    /* renamed from: a */
    private Toolbar f3026a;

    /* renamed from: b */
    private setFallbackLineSpacing f3027b;

    /* renamed from: c */
    private setFallbackLineSpacing f3028c;

    /* renamed from: d */
    private setFallbackLineSpacing f3029d;

    /* renamed from: e */
    private setShowSoftInputOnFocus f3030e;

    /* renamed from: f */
    private setShowSoftInputOnFocus f3031f;

    /* renamed from: g */
    private setShowSoftInputOnFocus f3032g;

    /* renamed from: h */
    private setLetterSpacing f3033h;

    /* renamed from: i */
    private setHyphenationFrequency f3034i;

    /* renamed from: j */
    private setHyphenationFrequency f3035j;

    /* renamed from: k */
    private setShowSoftInputOnFocus f3036k;

    /* renamed from: l */
    private setShowSoftInputOnFocus f3037l;

    /* renamed from: m */
    private setShowSoftInputOnFocus f3038m;

    /* renamed from: n */
    private setShowSoftInputOnFocus f3039n;

    /* renamed from: o */
    private setShowSoftInputOnFocus f3040o;

    /* renamed from: p */
    private setElegantTextHeight f3041p;

    /* renamed from: q */
    private ProgressBar f3042q;

    /* renamed from: r */
    private setTypeface f3043r;

    /* renamed from: s */
    private setBaselineAligned f3044s;

    /* renamed from: t */
    private UiCustomization f3045t;

    /* renamed from: u */
    private String f3046u = "";

    /* renamed from: v */
    private ArrayList<setCompoundDrawablesRelativeWithIntrinsicBounds> f3047v;

    /* renamed from: w */
    private setHighlightColor f3048w;

    /* renamed from: x */
    private setBreakStrategy f3049x;

    /* renamed from: y */
    private List<setElegantTextHeight> f3050y;

    /* renamed from: z */
    private boolean f3051z = false;

    /* renamed from: a */
    static /* synthetic */ setLetterSpacing m2117a(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = ((i | 27) << 1) - (i ^ 27);
        f3022E = i2 % 128;
        int i3 = i2 % 2;
        setLetterSpacing setletterspacing = settextlocales.f3033h;
        int i4 = f3021D;
        int i5 = (i4 & 123) + (i4 | 123);
        f3022E = i5 % 128;
        int i6 = i5 % 2;
        return setletterspacing;
    }

    /* renamed from: a */
    static /* synthetic */ setTypeface m2118a(setTextLocales settextlocales, setTypeface settypeface) {
        int i = ((f3022E + 87) - 1) - 1;
        f3021D = i % 128;
        char c = i % 2 != 0 ? 20 : VersionRange.RIGHT_CLOSED;
        settextlocales.f3043r = settypeface;
        if (c == 20) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return settypeface;
    }

    /* renamed from: a */
    static /* synthetic */ String m2119a(setTextLocales settextlocales, String str) {
        int i = f3022E;
        int i2 = i & 95;
        int i3 = -(-((i ^ 95) | i2));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3021D = i4 % 128;
        int i5 = i4 % 2;
        settextlocales.f3046u = str;
        int i6 = f3021D;
        int i7 = i6 & 9;
        int i8 = (((i6 | 9) & (~i7)) - (~(i7 << 1))) - 1;
        f3022E = i8 % 128;
        int i9 = i8 % 2;
        return str;
    }

    /* renamed from: a */
    static /* synthetic */ void m2122a(setTextLocales settextlocales, setBaselineAligned setbaselinealigned) {
        int i = f3021D;
        int i2 = (i & 33) + (i | 33);
        f3022E = i2 % 128;
        boolean z = i2 % 2 == 0;
        settextlocales.m2120a(setbaselinealigned);
        if (z) {
            Object obj = null;
            super.hashCode();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m2123a(setTextLocales settextlocales, UiCustomization uiCustomization, boolean z) {
        int i = f3022E;
        int i2 = i & 71;
        int i3 = (i | 71) & (~i2);
        int i4 = -(-(i2 << 1));
        int i5 = ((i3 | i4) << 1) - (i3 ^ i4);
        f3021D = i5 % 128;
        int i6 = i5 % 2;
        settextlocales.m2125a(uiCustomization, z);
        int i7 = f3022E;
        int i8 = i7 & 121;
        int i9 = (i8 - (~(-(-((i7 ^ 121) | i8))))) - 1;
        f3021D = i9 % 128;
        int i10 = i9 % 2;
    }

    /* renamed from: b */
    static /* synthetic */ WeakReference m2128b(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = (((i | 106) << 1) - (i ^ 106)) - 1;
        f3021D = i2 % 128;
        int i3 = i2 % 2;
        WeakReference<Context> weakReference = settextlocales.f3024B;
        int i4 = f3021D;
        int i5 = (i4 & 58) + (i4 | 58);
        int i6 = (i5 & -1) + (i5 | -1);
        f3022E = i6 % 128;
        if ((i6 % 2 == 0 ? '6' : '=') != '6') {
            return weakReference;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return weakReference;
    }

    /* renamed from: c */
    static /* synthetic */ String m2132c(setTextLocales settextlocales) {
        int i = f3022E;
        boolean z = true;
        int i2 = ((((i | 18) << 1) - (i ^ 18)) - 0) - 1;
        f3021D = i2 % 128;
        boolean z2 = i2 % 2 != 0;
        String str = settextlocales.f3023A;
        if (z2) {
            int i3 = 3 / 0;
        }
        int i4 = f3021D + 39;
        f3022E = i4 % 128;
        if (i4 % 2 == 0) {
            z = false;
        }
        if (z) {
            return str;
        }
        int i5 = 27 / 0;
        return str;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m2134d(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = i & 73;
        int i3 = -(-((i ^ 73) | i2));
        boolean z = true;
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3021D = i4 % 128;
        if (i4 % 2 == 0) {
            z = false;
        }
        Object obj = null;
        boolean b = settextlocales.m2131b();
        if (z) {
            super.hashCode();
        }
        int i5 = f3021D;
        int i6 = i5 & 21;
        int i7 = i6 + ((i5 ^ 21) | i6);
        f3022E = i7 % 128;
        if ((i7 % 2 == 0 ? 'J' : ' ') == ' ') {
            return b;
        }
        super.hashCode();
        return b;
    }

    /* renamed from: e */
    static /* synthetic */ setHighlightColor m2135e(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = ((i | 88) << 1) - (i ^ 88);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f3022E = i3 % 128;
        boolean z = i3 % 2 == 0;
        setHighlightColor sethighlightcolor = settextlocales.f3048w;
        if (z) {
            int i4 = 68 / 0;
        }
        int i5 = f3022E;
        int i6 = ((i5 | 5) << 1) - (i5 ^ 5);
        f3021D = i6 % 128;
        int i7 = i6 % 2;
        return sethighlightcolor;
    }

    /* renamed from: f */
    static /* synthetic */ UiCustomization m2136f(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = i & 107;
        int i3 = (i | 107) & (~i2);
        int i4 = i2 << 1;
        int i5 = ((i3 | i4) << 1) - (i3 ^ i4);
        f3022E = i5 % 128;
        int i6 = i5 % 2;
        UiCustomization uiCustomization = settextlocales.f3045t;
        int i7 = f3022E;
        int i8 = ((i7 ^ 121) | (i7 & 121)) << 1;
        int i9 = -(((~i7) & 121) | (i7 & -122));
        int i10 = ((i8 | i9) << 1) - (i9 ^ i8);
        f3021D = i10 % 128;
        int i11 = i10 % 2;
        return uiCustomization;
    }

    /* renamed from: g */
    static /* synthetic */ ArrayList m2137g(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = i & 97;
        int i3 = (((i ^ 97) | i2) << 1) - ((i | 97) & (~i2));
        f3021D = i3 % 128;
        boolean z = false;
        boolean z2 = i3 % 2 == 0;
        Object[] objArr = null;
        ArrayList<setCompoundDrawablesRelativeWithIntrinsicBounds> arrayList = settextlocales.f3047v;
        if (!z2) {
            int length = objArr.length;
        }
        int i4 = f3021D;
        int i5 = ((i4 & 92) + (i4 | 92)) - 1;
        f3022E = i5 % 128;
        if (i5 % 2 == 0) {
            z = true;
        }
        if (!z) {
            return arrayList;
        }
        super.hashCode();
        return arrayList;
    }

    /* renamed from: h */
    static /* synthetic */ String m2138h(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = (i & -102) | ((~i) & 101);
        boolean z = true;
        int i3 = (i & 101) << 1;
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3021D = i4 % 128;
        if (i4 % 2 == 0) {
            z = false;
        }
        String str = settextlocales.f3046u;
        if (z) {
            int i5 = 37 / 0;
        }
        return str;
    }

    /* renamed from: i */
    static /* synthetic */ setHyphenationFrequency m2139i(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = i ^ 101;
        int i3 = ((i & 101) | i2) << 1;
        int i4 = -i2;
        int i5 = (i3 & i4) + (i3 | i4);
        f3022E = i5 % 128;
        char c = i5 % 2 == 0 ? 19 : '^';
        setHyphenationFrequency sethyphenationfrequency = settextlocales.f3034i;
        if (c == 19) {
            int i6 = 53 / 0;
        }
        return sethyphenationfrequency;
    }

    /* renamed from: k */
    static /* synthetic */ setBaselineAligned m2141k(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = i & 49;
        int i3 = -(-((i ^ 49) | i2));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f3022E = i4 % 128;
        char c = i4 % 2 == 0 ? 24 : 'T';
        setBaselineAligned setbaselinealigned = settextlocales.f3044s;
        if (c == 24) {
            Object obj = null;
            super.hashCode();
        }
        int i5 = f3021D;
        int i6 = i5 ^ 109;
        int i7 = -(-((i5 & 109) << 1));
        int i8 = (i6 ^ i7) + ((i7 & i6) << 1);
        f3022E = i8 % 128;
        int i9 = i8 % 2;
        return setbaselinealigned;
    }

    /* renamed from: l */
    static /* synthetic */ setElegantTextHeight m2142l(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = i & 123;
        int i3 = -(-((i ^ 123) | i2));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3021D = i4 % 128;
        boolean z = i4 % 2 != 0;
        setElegantTextHeight seteleganttextheight = settextlocales.f3041p;
        if (z) {
            Object obj = null;
            super.hashCode();
        }
        return seteleganttextheight;
    }

    /* renamed from: m */
    static /* synthetic */ setTypeface m2143m(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = ((((i ^ 95) | (i & 95)) << 1) - (~(-(((~i) & 95) | (i & -96))))) - 1;
        f3022E = i2 % 128;
        int i3 = i2 % 2;
        setTypeface settypeface = settextlocales.f3043r;
        int i4 = f3022E;
        int i5 = (i4 & 8) + (i4 | 8);
        int i6 = (i5 ^ -1) + ((i5 & -1) << 1);
        f3021D = i6 % 128;
        int i7 = i6 % 2;
        return settypeface;
    }

    /* renamed from: o */
    static /* synthetic */ setHyphenationFrequency m2145o(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = i & 73;
        int i3 = ((i ^ 73) | i2) << 1;
        int i4 = -((i | 73) & (~i2));
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        f3021D = i5 % 128;
        boolean z = i5 % 2 == 0;
        setHyphenationFrequency sethyphenationfrequency = settextlocales.f3035j;
        if (!z) {
            int i6 = 98 / 0;
        }
        return sethyphenationfrequency;
    }

    /* renamed from: p */
    static /* synthetic */ boolean m2146p(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = ((i | 124) << 1) - (i ^ 124);
        int i3 = (i2 & -1) + (i2 | -1);
        f3022E = i3 % 128;
        int i4 = i3 % 2;
        boolean a = settextlocales.m2127a();
        int i5 = f3021D;
        int i6 = i5 & 41;
        int i7 = (((i5 ^ 41) | i6) << 1) - ((i5 | 41) & (~i6));
        f3022E = i7 % 128;
        if (i7 % 2 != 0) {
            return a;
        }
        Object obj = null;
        super.hashCode();
        return a;
    }

    /* renamed from: q */
    static /* synthetic */ ProgressBar m2147q(setTextLocales settextlocales) {
        int i = f3021D;
        int i2 = i & 63;
        int i3 = (i | 63) & (~i2);
        int i4 = -(-(i2 << 1));
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f3022E = i5 % 128;
        boolean z = i5 % 2 == 0;
        Object[] objArr = null;
        ProgressBar progressBar = settextlocales.f3042q;
        if (z) {
            int length = objArr.length;
        }
        int i6 = (f3021D + 32) - 1;
        f3022E = i6 % 128;
        if ((i6 % 2 == 0 ? '%' : 27) == 27) {
            return progressBar;
        }
        int length2 = objArr.length;
        return progressBar;
    }

    /* renamed from: s */
    static /* synthetic */ setShowSoftInputOnFocus m2149s(setTextLocales settextlocales) {
        boolean z = true;
        int i = (f3021D + 122) - 1;
        f3022E = i % 128;
        int i2 = i % 2;
        setShowSoftInputOnFocus setshowsoftinputonfocus = settextlocales.f3037l;
        int i3 = f3022E;
        int i4 = (i3 ^ 69) + ((i3 & 69) << 1);
        f3021D = i4 % 128;
        if (i4 % 2 != 0) {
            z = false;
        }
        if (z) {
            return setshowsoftinputonfocus;
        }
        int i5 = 67 / 0;
        return setshowsoftinputonfocus;
    }

    /* renamed from: t */
    static /* synthetic */ setShowSoftInputOnFocus m2150t(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = (i & 121) + (i | 121);
        f3021D = i2 % 128;
        boolean z = i2 % 2 == 0;
        setShowSoftInputOnFocus setshowsoftinputonfocus = settextlocales.f3036k;
        if (!z) {
            Object obj = null;
            super.hashCode();
        }
        return setshowsoftinputonfocus;
    }

    /* renamed from: u */
    static /* synthetic */ setShowSoftInputOnFocus m2151u(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = i & 37;
        int i3 = (i | 37) & (~i2);
        boolean z = true;
        int i4 = -(-(i2 << 1));
        int i5 = (i3 & i4) + (i3 | i4);
        f3021D = i5 % 128;
        char c = i5 % 2 != 0 ? '5' : '^';
        setShowSoftInputOnFocus setshowsoftinputonfocus = settextlocales.f3039n;
        if (c != '^') {
            int i6 = 26 / 0;
        }
        int i7 = f3021D;
        int i8 = i7 | 45;
        int i9 = ((i8 << 1) - (~(-((~(i7 & 45)) & i8)))) - 1;
        f3022E = i9 % 128;
        if (i9 % 2 != 0) {
            z = false;
        }
        if (!z) {
            return setshowsoftinputonfocus;
        }
        Object obj = null;
        super.hashCode();
        return setshowsoftinputonfocus;
    }

    /* renamed from: v */
    static /* synthetic */ setShowSoftInputOnFocus m2152v(setTextLocales settextlocales) {
        int i = f3022E;
        int i2 = (i & -2) | ((~i) & 1);
        int i3 = (i & 1) << 1;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f3021D = i4 % 128;
        char c = i4 % 2 != 0 ? Matrix.MATRIX_TYPE_ZERO : 27;
        setShowSoftInputOnFocus setshowsoftinputonfocus = settextlocales.f3038m;
        if (c == 'Z') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return setshowsoftinputonfocus;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object, java.lang.String] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0301, code lost:
        if (r8 != 'N') goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0317, code lost:
        if ((r2 ? '1' : 'c') != '1') goto L_0x0344;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0486  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x04e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x04e1 A[SYNTHETIC, Splitter:B:128:0x04e1] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r17) {
        /*
            r16 = this;
            r1 = r16
            com.didi.sdk.apm.SystemUtils.hookOnlyFullscreenOpaque(r16)
            super.onCreate(r17)
            android.content.BroadcastReceiver r0 = r1.f3025C
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r3 = "finish_activity"
            r2.<init>(r3)
            r1.registerReceiver(r0, r2)     // Catch:{ Exception -> 0x0015 }
            goto L_0x001e
        L_0x0015:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "Context"
            java.lang.String r3 = "registerReceiver"
            android.util.Log.d(r0, r3, r2)
        L_0x001e:
            boolean r0 = com.cardinalcommerce.p060a.setHeight.Cardinal
            android.view.Window r0 = r16.getWindow()
            r2 = 8192(0x2000, float:1.14794E-41)
            r0.setFlags(r2, r2)
            android.content.Intent r0 = r16.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r2 = "StepUpData"
            java.io.Serializable r0 = r0.getSerializable(r2)
            com.cardinalcommerce.a.setBaselineAligned r0 = (com.cardinalcommerce.p060a.setBaselineAligned) r0
            r1.f3044s = r0
            java.lang.String r0 = r0.init
            r1.f3023A = r0
            com.cardinalcommerce.a.setTextMetricsParams r0 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "UIType "
            r2.<init>(r3)
            java.lang.String r3 = r1.f3023A
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Native Challenge Screen"
            r4 = 0
            r0.init(r3, r2, r4)
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            android.content.Context r2 = r16.getApplicationContext()
            r0.<init>(r2)
            r1.f3024B = r0
            java.lang.String r0 = r1.f3023A
            int r2 = r0.hashCode()
            java.lang.String r3 = "04"
            java.lang.String r5 = "01"
            r6 = 26
            r8 = 3
            r9 = -1
            r10 = 0
            r11 = 2
            r12 = 1
            switch(r2) {
                case 1537: goto L_0x0116;
                case 1538: goto L_0x00f2;
                case 1539: goto L_0x00b7;
                case 1540: goto L_0x0080;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0145
        L_0x0080:
            boolean r0 = r0.equals(r3)
            r2 = 25
            if (r0 == 0) goto L_0x008b
            r0 = 35
            goto L_0x008d
        L_0x008b:
            r0 = 25
        L_0x008d:
            if (r0 == r2) goto L_0x0145
            int r0 = f3022E
            r2 = r0 & 9
            int r13 = ~r2
            r0 = r0 | 9
            r0 = r0 & r13
            int r2 = r2 << r12
            int r0 = r0 + r2
            int r2 = r0 % 128
            f3021D = r2
            int r0 = r0 % r11
            int r0 = f3021D
            r2 = r0 | 107(0x6b, float:1.5E-43)
            int r2 = r2 << r12
            r13 = r0 & -108(0xffffffffffffff94, float:NaN)
            int r0 = ~r0
            r0 = r0 & 107(0x6b, float:1.5E-43)
            r0 = r0 | r13
            int r0 = -r0
            r13 = r2 ^ r0
            r0 = r0 & r2
            int r0 = r0 << r12
            int r13 = r13 + r0
            int r0 = r13 % 128
            f3022E = r0
            int r13 = r13 % r11
            r0 = 3
            goto L_0x0146
        L_0x00b7:
            java.lang.String r2 = "03"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00c1
            r0 = 0
            goto L_0x00c2
        L_0x00c1:
            r0 = 1
        L_0x00c2:
            if (r0 == 0) goto L_0x00c6
            goto L_0x0145
        L_0x00c6:
            int r0 = f3022E
            r2 = r0 & 55
            r0 = r0 | 55
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3021D = r0
            int r2 = r2 % r11
            if (r2 == 0) goto L_0x00d6
            r0 = 0
            goto L_0x00d7
        L_0x00d6:
            r0 = 1
        L_0x00d7:
            if (r0 == 0) goto L_0x00db
            r0 = 2
            goto L_0x00dc
        L_0x00db:
            r0 = 5
        L_0x00dc:
            int r2 = f3021D
            r13 = r2 ^ 85
            r14 = r2 & 85
            r13 = r13 | r14
            int r13 = r13 << r12
            int r14 = ~r14
            r2 = r2 | 85
            r2 = r2 & r14
            int r2 = -r2
            int r2 = ~r2
            int r13 = r13 - r2
            int r13 = r13 - r12
            int r2 = r13 % 128
            f3022E = r2
            int r13 = r13 % r11
            goto L_0x0146
        L_0x00f2:
            java.lang.String r2 = "02"
            boolean r0 = r0.equals(r2)
            r2 = 80
            if (r0 == 0) goto L_0x00fe
            r0 = 1
            goto L_0x0100
        L_0x00fe:
            r0 = 80
        L_0x0100:
            if (r0 == r2) goto L_0x0145
            int r0 = f3022E
            r2 = r0 & 111(0x6f, float:1.56E-43)
            r0 = r0 ^ 111(0x6f, float:1.56E-43)
            r0 = r0 | r2
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3021D = r0
            int r2 = r2 % r11
            if (r2 == 0) goto L_0x0113
            r0 = 1
            goto L_0x0114
        L_0x0113:
            r0 = 0
        L_0x0114:
            r0 = 1
            goto L_0x0146
        L_0x0116:
            boolean r0 = r0.equals(r5)
            r2 = 15
            if (r0 == 0) goto L_0x0121
            r0 = 15
            goto L_0x0123
        L_0x0121:
            r0 = 72
        L_0x0123:
            if (r0 == r2) goto L_0x0126
            goto L_0x0145
        L_0x0126:
            int r0 = f3022E
            r2 = r0 ^ 26
            r0 = r0 & r6
            int r0 = r0 << r12
            int r2 = r2 + r0
            r0 = r2 & -1
            r2 = r2 | r9
            int r0 = r0 + r2
            int r2 = r0 % 128
            f3021D = r2
            int r0 = r0 % r11
            int r0 = f3021D
            r2 = r0 | 79
            int r2 = r2 << r12
            r0 = r0 ^ 79
            int r2 = r2 - r0
            int r0 = r2 % 128
            f3022E = r0
            int r2 = r2 % r11
            r0 = 0
            goto L_0x0146
        L_0x0145:
            r0 = -1
        L_0x0146:
            r2 = 73
            r13 = 2131434334(0x7f0b1b5e, float:1.849048E38)
            r14 = 2131433573(0x7f0b1865, float:1.8488936E38)
            r15 = 2131428143(0x7f0b032f, float:1.8477922E38)
            if (r0 == 0) goto L_0x01d9
            r7 = 2131434251(0x7f0b1b0b, float:1.849031E38)
            if (r0 == r12) goto L_0x01af
            if (r0 == r11) goto L_0x0180
            if (r0 == r8) goto L_0x015e
            goto L_0x0207
        L_0x015e:
            r0 = 2131624072(0x7f0e0088, float:1.8875313E38)
            r1.setContentView((int) r0)
            android.view.View r0 = r1.findViewById(r13)
            com.cardinalcommerce.a.setHyphenationFrequency r0 = (com.cardinalcommerce.p060a.setHyphenationFrequency) r0
            r1.f3034i = r0
            int r0 = f3021D
            r7 = r0 | 94
            int r7 = r7 << r12
            r0 = r0 ^ 94
            int r7 = r7 - r0
            r0 = r7 | -1
            int r0 = r0 << r12
            r7 = r7 ^ r9
            int r0 = r0 - r7
            int r7 = r0 % 128
            f3022E = r7
        L_0x017d:
            int r0 = r0 % r11
            goto L_0x0207
        L_0x0180:
            r0 = 2131624063(0x7f0e007f, float:1.8875295E38)
            r1.setContentView((int) r0)
            android.view.View r0 = r1.findViewById(r15)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3032g = r0
            android.view.View r0 = r1.findViewById(r14)
            com.cardinalcommerce.a.setHyphenationFrequency r0 = (com.cardinalcommerce.p060a.setHyphenationFrequency) r0
            r1.f3035j = r0
            android.view.View r0 = r1.findViewById(r7)
            com.cardinalcommerce.a.setHyphenationFrequency r0 = (com.cardinalcommerce.p060a.setHyphenationFrequency) r0
            r1.f3034i = r0
            int r0 = f3022E
            r7 = r0 & 73
            r0 = r0 | r2
            int r0 = -r0
            int r0 = -r0
            r13 = r7 & r0
            r0 = r0 | r7
            int r13 = r13 + r0
            int r0 = r13 % 128
            f3021D = r0
            int r13 = r13 % r11
            goto L_0x0207
        L_0x01af:
            r0 = 2131624095(0x7f0e009f, float:1.887536E38)
            r1.setContentView((int) r0)
            android.view.View r0 = r1.findViewById(r15)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3032g = r0
            android.view.View r0 = r1.findViewById(r14)
            com.cardinalcommerce.a.setHyphenationFrequency r0 = (com.cardinalcommerce.p060a.setHyphenationFrequency) r0
            r1.f3035j = r0
            android.view.View r0 = r1.findViewById(r7)
            com.cardinalcommerce.a.setHyphenationFrequency r0 = (com.cardinalcommerce.p060a.setHyphenationFrequency) r0
            r1.f3034i = r0
            int r0 = f3022E
            int r0 = r0 + 25
            int r0 = r0 - r12
            int r0 = r0 - r10
            int r0 = r0 - r12
        L_0x01d4:
            int r7 = r0 % 128
            f3021D = r7
            goto L_0x017d
        L_0x01d9:
            r0 = 2131624073(0x7f0e0089, float:1.8875315E38)
            r1.setContentView((int) r0)
            android.view.View r0 = r1.findViewById(r15)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3032g = r0
            r0 = 2131428219(0x7f0b037b, float:1.8478076E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setLetterSpacing r0 = (com.cardinalcommerce.p060a.setLetterSpacing) r0
            r1.f3033h = r0
            android.view.View r0 = r1.findViewById(r13)
            com.cardinalcommerce.a.setHyphenationFrequency r0 = (com.cardinalcommerce.p060a.setHyphenationFrequency) r0
            r1.f3034i = r0
            android.view.View r0 = r1.findViewById(r14)
            com.cardinalcommerce.a.setHyphenationFrequency r0 = (com.cardinalcommerce.p060a.setHyphenationFrequency) r0
            r1.f3035j = r0
            int r0 = f3022E
            int r0 = r0 + 123
            goto L_0x01d4
        L_0x0207:
            r0 = 2131428144(0x7f0b0330, float:1.8477924E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3031f = r0
            r0 = 2131434670(0x7f0b1cae, float:1.849116E38)
            android.view.View r0 = r1.findViewById(r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r1.f3026a = r0
            r1.setSupportActionBar(r0)
            androidx.appcompat.app.ActionBar r0 = r16.getSupportActionBar()
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            androidx.appcompat.app.ActionBar r0 = (androidx.appcompat.app.ActionBar) r0
            r0.setDisplayShowTitleEnabled(r10)
            r0 = 2131434671(0x7f0b1caf, float:1.8491163E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3040o = r0
            r0 = 2131433211(0x7f0b16fb, float:1.8488201E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r1.f3042q = r0
            r0 = 2131431688(0x7f0b1108, float:1.8485112E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setFallbackLineSpacing r0 = (com.cardinalcommerce.p060a.setFallbackLineSpacing) r0
            r1.f3027b = r0
            r0 = 2131433471(0x7f0b17ff, float:1.8488729E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setFallbackLineSpacing r0 = (com.cardinalcommerce.p060a.setFallbackLineSpacing) r0
            r1.f3028c = r0
            r0 = 2131435785(0x7f0b2109, float:1.8493422E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setFallbackLineSpacing r0 = (com.cardinalcommerce.p060a.setFallbackLineSpacing) r0
            r1.f3029d = r0
            r0 = 2131428142(0x7f0b032e, float:1.847792E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3030e = r0
            r0 = 2131435831(0x7f0b2137, float:1.8493515E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3036k = r0
            r0 = 2131435830(0x7f0b2136, float:1.8493513E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3037l = r0
            r0 = 2131431243(0x7f0b0f4b, float:1.848421E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3038m = r0
            r0 = 2131431242(0x7f0b0f4a, float:1.8484208E38)
            android.view.View r0 = r1.findViewById(r0)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = (com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r0
            r1.f3039n = r0
            android.content.Intent r0 = r16.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r7 = "UiCustomization"
            java.io.Serializable r0 = r0.getSerializable(r7)
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r0 = (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0
            r1.f3045t = r0
            com.cardinalcommerce.a.setBaselineAligned r0 = r1.f3044s
            r1.m2120a((com.cardinalcommerce.p060a.setBaselineAligned) r0)
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r0 = r1.f3045t
            r7 = 20
            if (r0 == 0) goto L_0x02bb
            r13 = 20
            goto L_0x02bd
        L_0x02bb:
            r13 = 23
        L_0x02bd:
            if (r13 == r7) goto L_0x02c1
            goto L_0x0476
        L_0x02c1:
            int r13 = f3021D
            r14 = r13 & 115(0x73, float:1.61E-43)
            r13 = r13 | 115(0x73, float:1.61E-43)
            int r14 = r14 + r13
            int r13 = r14 % 128
            f3022E = r13
            int r14 = r14 % r11
            java.lang.String r13 = r1.f3023A
            boolean r3 = r13.equals(r3)
            if (r3 != 0) goto L_0x02d7
            r3 = 0
            goto L_0x02d8
        L_0x02d7:
            r3 = 1
        L_0x02d8:
            if (r3 == r12) goto L_0x0391
            int r3 = f3021D
            int r3 = r3 + 85
            int r3 = r3 - r12
            r13 = r3 | -1
            int r13 = r13 << r12
            r3 = r3 ^ r9
            int r13 = r13 - r3
            int r3 = r13 % 128
            f3022E = r3
            int r13 = r13 % r11
            if (r13 != 0) goto L_0x02ed
            r2 = 61
        L_0x02ed:
            r3 = 61
            if (r2 == r3) goto L_0x0304
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3032g
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r2, r0, r1)
            boolean r2 = r16.m2127a()
            if (r2 == 0) goto L_0x02fd
            goto L_0x02ff
        L_0x02fd:
            r8 = 78
        L_0x02ff:
            r2 = 78
            if (r8 == r2) goto L_0x0344
            goto L_0x031a
        L_0x0304:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3032g
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r2, r0, r1)
            boolean r2 = r16.m2127a()
            int r3 = r4.length     // Catch:{ all -> 0x038e }
            if (r2 == 0) goto L_0x0313
            r2 = 49
            goto L_0x0315
        L_0x0313:
            r2 = 99
        L_0x0315:
            r3 = 49
            if (r2 == r3) goto L_0x031a
            goto L_0x0344
        L_0x031a:
            int r2 = f3022E
            r3 = r2 ^ 75
            r2 = r2 & 75
            int r2 = r2 << r12
            int r3 = r3 + r2
            int r2 = r3 % 128
            f3021D = r2
            int r3 = r3 % r11
            r1.m2124a((com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0)
            int r2 = f3021D
            r3 = 91
            r8 = r2 ^ 91
            r13 = r2 & 91
            r8 = r8 | r13
            int r8 = r8 << r12
            r13 = r2 & -92
            int r2 = ~r2
            r2 = r2 & r3
            r2 = r2 | r13
            int r2 = -r2
            r3 = r8 ^ r2
            r2 = r2 & r8
            int r2 = r2 << r12
            int r3 = r3 + r2
            int r2 = r3 % 128
            f3022E = r2
            int r3 = r3 % r11
        L_0x0344:
            java.lang.String r2 = r1.f3023A
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x034e
            r2 = 1
            goto L_0x034f
        L_0x034e:
            r2 = 0
        L_0x034f:
            if (r2 == r12) goto L_0x0352
            goto L_0x0391
        L_0x0352:
            int r2 = f3021D
            r3 = r2 | 67
            int r5 = r3 << 1
            r2 = r2 & 67
            int r2 = ~r2
            r2 = r2 & r3
            int r2 = -r2
            r3 = r5 ^ r2
            r2 = r2 & r5
            int r2 = r2 << r12
            int r3 = r3 + r2
            int r2 = r3 % 128
            f3022E = r2
            int r3 = r3 % r11
            if (r3 != 0) goto L_0x036b
            r2 = 0
            goto L_0x036c
        L_0x036b:
            r2 = 1
        L_0x036c:
            if (r2 == r12) goto L_0x037a
            com.cardinalcommerce.a.setLetterSpacing r2 = r1.f3033h
            com.cardinalcommerce.p060a.setPaintFlags.cca_continue((com.cardinalcommerce.p060a.setLetterSpacing) r2, (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0, (android.app.Activity) r1)
            super.hashCode()     // Catch:{ all -> 0x0377 }
            goto L_0x037f
        L_0x0377:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x037a:
            com.cardinalcommerce.a.setLetterSpacing r2 = r1.f3033h
            com.cardinalcommerce.p060a.setPaintFlags.cca_continue((com.cardinalcommerce.p060a.setLetterSpacing) r2, (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0, (android.app.Activity) r1)
        L_0x037f:
            int r2 = f3021D
            r3 = r2 & 18
            r2 = r2 | 18
            int r3 = r3 + r2
            int r3 = r3 - r10
            int r3 = r3 - r12
            int r2 = r3 % 128
            f3022E = r2
            int r3 = r3 % r11
            goto L_0x0391
        L_0x038e:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0391:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3040o
            com.cardinalcommerce.p060a.setPaintFlags.configure((com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r2, (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0, (android.app.Activity) r1)
            boolean r2 = r16.m2127a()
            r3 = 65
            if (r2 == 0) goto L_0x03a1
            r2 = 65
            goto L_0x03a3
        L_0x03a1:
            r2 = 44
        L_0x03a3:
            if (r2 == r3) goto L_0x03a6
            goto L_0x03c7
        L_0x03a6:
            int r2 = f3021D
            r3 = 119(0x77, float:1.67E-43)
            r5 = r2 & -120(0xffffffffffffff88, float:NaN)
            int r8 = ~r2
            r8 = r8 & r3
            r5 = r5 | r8
            r2 = r2 & r3
            int r2 = r2 << r12
            int r5 = r5 + r2
            int r2 = r5 % 128
            f3022E = r2
            int r5 = r5 % r11
            r1.m2124a((com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0)
            int r2 = f3022E
            r3 = r2 & 31
            r2 = r2 ^ 31
            r2 = r2 | r3
            int r3 = r3 + r2
            int r2 = r3 % 128
            f3021D = r2
            int r3 = r3 % r11
        L_0x03c7:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3030e
            com.cardinalcommerce.p060a.setPaintFlags.init((com.cardinalcommerce.p060a.setShowSoftInputOnFocus) r2, (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0, (android.app.Activity) r1)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3031f
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r2, r0, r1)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3036k
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r2, r0, r1)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3037l
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r2, r0, r1)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3038m
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r2, r0, r1)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3039n
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r2, r0, r1)
            com.cardinalcommerce.shared.models.enums.ButtonType r2 = com.cardinalcommerce.shared.models.enums.ButtonType.VERIFY
            com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r2 = r0.getButtonCustomization((com.cardinalcommerce.shared.models.enums.ButtonType) r2)
            if (r2 != 0) goto L_0x03f0
            r2 = 26
            goto L_0x03f2
        L_0x03f0:
            r2 = 66
        L_0x03f2:
            if (r2 == r6) goto L_0x0413
            com.cardinalcommerce.a.setHyphenationFrequency r2 = r1.f3034i
            com.cardinalcommerce.shared.models.enums.ButtonType r3 = com.cardinalcommerce.shared.models.enums.ButtonType.VERIFY
            com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r3 = r0.getButtonCustomization((com.cardinalcommerce.shared.models.enums.ButtonType) r3)
            com.cardinalcommerce.p060a.setPaintFlags.cca_continue((com.cardinalcommerce.p060a.setHyphenationFrequency) r2, (com.cardinalcommerce.shared.userinterfaces.ButtonCustomization) r3, (android.app.Activity) r1)
            int r2 = f3022E
            r3 = r2 & 53
            r2 = r2 ^ 53
            r2 = r2 | r3
            int r2 = -r2
            int r2 = -r2
            r5 = r3 | r2
            int r5 = r5 << r12
            r2 = r2 ^ r3
            int r5 = r5 - r2
            int r2 = r5 % 128
            f3021D = r2
            int r5 = r5 % r11
            goto L_0x045b
        L_0x0413:
            int r2 = f3022E
            r3 = r2 & 105(0x69, float:1.47E-43)
            r2 = r2 ^ 105(0x69, float:1.47E-43)
            r2 = r2 | r3
            r5 = r3 | r2
            int r5 = r5 << r12
            r2 = r2 ^ r3
            int r5 = r5 - r2
            int r2 = r5 % 128
            f3021D = r2
            int r5 = r5 % r11
            com.cardinalcommerce.a.setHyphenationFrequency r2 = r1.f3034i
            android.content.res.Resources r3 = r16.getResources()
            r5 = 2131099784(0x7f060088, float:1.781193E38)
            int r3 = r3.getColor(r5)
            r2.setBackgroundColor(r3)
            com.cardinalcommerce.a.setHyphenationFrequency r2 = r1.f3034i
            android.content.res.Resources r3 = r16.getResources()
            r5 = 2131099857(0x7f0600d1, float:1.781208E38)
            int r3 = r3.getColor(r5)
            r2.setTextColor(r3)
            int r2 = f3021D
            r3 = r2 ^ 121(0x79, float:1.7E-43)
            r5 = r2 & 121(0x79, float:1.7E-43)
            r3 = r3 | r5
            int r3 = r3 << r12
            r5 = r2 & -122(0xffffffffffffff86, float:NaN)
            int r2 = ~r2
            r2 = r2 & 121(0x79, float:1.7E-43)
            r2 = r2 | r5
            int r2 = -r2
            int r2 = ~r2
            int r3 = r3 - r2
            int r3 = r3 - r12
            int r2 = r3 % 128
            f3022E = r2
            int r3 = r3 % r11
        L_0x045b:
            r1.m2125a((com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0, (boolean) r10)
            androidx.appcompat.widget.Toolbar r2 = r1.f3026a
            com.cardinalcommerce.p060a.setPaintFlags.configure((androidx.appcompat.widget.Toolbar) r2, (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r0, (android.app.Activity) r1)
            int r0 = f3022E
            r2 = r0 & 91
            r0 = r0 ^ 91
            r0 = r0 | r2
            int r0 = -r0
            int r0 = -r0
            r3 = r2 | r0
            int r3 = r3 << r12
            r0 = r0 ^ r2
            int r3 = r3 - r0
            int r0 = r3 % 128
            f3021D = r0
            int r3 = r3 % r11
        L_0x0476:
            com.cardinalcommerce.a.setHyphenationFrequency r0 = r1.f3034i
            com.cardinalcommerce.a.setTextLocales$6 r2 = new com.cardinalcommerce.a.setTextLocales$6
            r2.<init>()
            r0.setCCAOnClickListener(r2)
            boolean r0 = r16.m2127a()
            if (r0 == 0) goto L_0x049d
            com.cardinalcommerce.a.setHyphenationFrequency r0 = r1.f3035j
            com.cardinalcommerce.a.setTextLocales$7 r2 = new com.cardinalcommerce.a.setTextLocales$7
            r2.<init>()
            r0.setCCAOnClickListener(r2)
            int r0 = f3021D
            int r0 = r0 + 124
            r2 = r0 & -1
            r0 = r0 | r9
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3022E = r0
            int r2 = r2 % r11
        L_0x049d:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r1.f3040o
            com.cardinalcommerce.a.setTextLocales$10 r2 = new com.cardinalcommerce.a.setTextLocales$10
            r2.<init>()
            r0.setCCAOnClickListener(r2)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r1.f3036k
            com.cardinalcommerce.a.setTextLocales$3 r2 = new com.cardinalcommerce.a.setTextLocales$3
            r2.<init>()
            r0.setCCAOnClickListener(r2)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r1.f3036k
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r2 = r1.f3045t
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r0, r2, r1)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r1.f3038m
            com.cardinalcommerce.a.setTextLocales$1 r2 = new com.cardinalcommerce.a.setTextLocales$1
            r2.<init>()
            r0.setCCAOnClickListener(r2)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r1.f3038m
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r2 = r1.f3045t
            com.cardinalcommerce.p060a.setPaintFlags.getInstance(r0, r2, r1)
            int r0 = f3021D
            r2 = r0 & 39
            r0 = r0 | 39
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3022E = r0
            int r2 = r2 % r11
            if (r2 != 0) goto L_0x04dc
            r0 = 35
            r7 = 35
            goto L_0x04de
        L_0x04dc:
            r0 = 35
        L_0x04de:
            if (r7 == r0) goto L_0x04e1
            return
        L_0x04e1:
            int r0 = r4.length     // Catch:{ all -> 0x04e3 }
            return
        L_0x04e3:
            r0 = move-exception
            r2 = r0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.onCreate(android.os.Bundle):void");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.String] */
    /* access modifiers changed from: protected */
    public void onPause() {
        int i = f3021D;
        int i2 = i & 33;
        int i3 = (i2 - (~(-(-((i ^ 33) | i2))))) - 1;
        f3022E = i3 % 128;
        boolean z = false;
        ? r6 = 0;
        if ((i3 % 2 == 0 ? Typography.amp : 'K') != 'K') {
            this.f3051z = false;
        } else {
            this.f3051z = true;
        }
        setTextMetricsParams.getSDKVersion().init("Native Challenge Screen", "Challenge screen in background", r6);
        super.onPause();
        int i4 = f3021D;
        int i5 = i4 & 95;
        int i6 = ((i4 ^ 95) | i5) << 1;
        int i7 = -((i4 | 95) & (~i5));
        int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
        f3022E = i8 % 128;
        if (i8 % 2 == 0) {
            z = true;
        }
        if (z) {
            int length = r6.length;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        int i = f3021D;
        int i2 = (((i ^ 33) | (i & 33)) << 1) - (((~i) & 33) | (i & -34));
        f3022E = i2 % 128;
        if (!(i2 % 2 == 0)) {
            try {
                unregisterReceiver(this.f3025C);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            setTextSelectHandle cca_continue = setTextSelectHandle.cca_continue((Context) this);
            setTextSelectHandle.getInstance = null;
            cca_continue.Cardinal = null;
            cca_continue.cca_continue.clear();
            setTextMetricsParams.getSDKVersion().init("Native Challenge Screen", "Activity closed", (String) null);
            super.onDestroy();
        } else {
            try {
                unregisterReceiver(this.f3025C);
            } catch (Exception e2) {
                Log.d("Context", "unregisterReceiver", e2);
            }
            setTextSelectHandle cca_continue2 = setTextSelectHandle.cca_continue((Context) this);
            setTextSelectHandle.getInstance = null;
            cca_continue2.Cardinal = null;
            cca_continue2.cca_continue.clear();
            setTextMetricsParams.getSDKVersion().init("Native Challenge Screen", "Activity closed", (String) null);
            super.onDestroy();
            int i3 = 28 / 0;
        }
        int i4 = f3021D;
        int i5 = i4 & 13;
        int i6 = i5 + ((i4 ^ 13) | i5);
        f3022E = i6 % 128;
        int i7 = i6 % 2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0245, code lost:
        if ((r0.getSDKVersion == null) != false) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x034f, code lost:
        if ((r3) != false) goto L_0x0362;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0360, code lost:
        if ((r1.f3023A.equals("04")) != false) goto L_0x0362;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        if (r5.equals("04") == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        r3 = 'F';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        r3 = 'Y';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        if (r3 == 'Y') goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        r3 = f3021D;
        r12 = r3 & 113;
        r5 = ((((r3 ^ 113) | r12) << 1) - (~(-((r3 | 113) & (~r12))))) - 1;
        f3022E = r5 % 128;
        r5 = r5 % 2;
        r3 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0459, code lost:
        if ((r3 ? kotlin.text.Typography.quote : 11) != '\"') goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (r5.equals("03") == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x046c, code lost:
        if ((r0.CardinalError.equalsIgnoreCase(com.didichuxing.sofa.animation.C16471q.f49113b)) != true) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x047e, code lost:
        r1.f3029d.setCCAImageResource(com.taxis99.R.drawable.warning);
        r1.f3029d.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0091, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0093, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        if (r5 == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        r5 = f3021D;
        r13 = r5 & 71;
        r12 = (((r5 ^ 71) | r13) << 1) - ((71 | r5) & (~r13));
        f3022E = r12 % 128;
        r12 = r12 % 2;
        r3 = f3022E;
        r5 = (((r3 & -64) | ((~r3) & 63)) - (~(-(-((r3 & 63) << 1))))) - 1;
        f3021D = r5 % 128;
        r5 = r5 % 2;
        r3 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0552, code lost:
        if ((!r0.CardinalUiType.isEmpty()) != true) goto L_0x0565;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0563, code lost:
        if ((!r3) != true) goto L_0x0565;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c5, code lost:
        if (r5.equals("02") == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c7, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c9, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ca, code lost:
        if (r3 == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cc, code lost:
        r3 = (f3022E + 126) - 1;
        f3021D = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d6, code lost:
        if ((r3 % 2) == 0) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00db, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e3, code lost:
        if (r5.equals("01") == false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e5, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e7, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e8, code lost:
        if (r3 == false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ec, code lost:
        r3 = f3022E + 12;
        r5 = ((r3 | -1) << 1) - (r3 ^ -1);
        f3021D = r5 % 128;
        r5 = r5 % 2;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0238, code lost:
        if ((r3 != null) != true) goto L_0x0256;
     */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0430  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0529  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0531  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0218  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2120a(com.cardinalcommerce.p060a.setBaselineAligned r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            int r2 = f3022E
            r3 = r2 ^ 61
            r2 = r2 & 61
            r4 = 1
            int r2 = r2 << r4
            int r2 = -r2
            int r2 = -r2
            r5 = r3 & r2
            r2 = r2 | r3
            int r5 = r5 + r2
            int r2 = r5 % 128
            f3021D = r2
            r2 = 2
            int r5 = r5 % r2
            r3 = 71
            if (r5 == 0) goto L_0x001f
            r5 = 75
            goto L_0x0021
        L_0x001f:
            r5 = 71
        L_0x0021:
            r6 = 3
            java.lang.String r7 = "04"
            r8 = 4
            r9 = 0
            r10 = -1
            r11 = 0
            if (r5 == r3) goto L_0x0048
            com.cardinalcommerce.a.setLinkTextColor r5 = r0.CardinalActionCode
            com.cardinalcommerce.a.setFallbackLineSpacing r12 = r1.f3027b
            r1.m2121a((com.cardinalcommerce.p060a.setLinkTextColor) r5, (com.cardinalcommerce.p060a.setFallbackLineSpacing) r12)
            com.cardinalcommerce.a.setLinkTextColor r5 = r0.getString
            com.cardinalcommerce.a.setFallbackLineSpacing r12 = r1.f3028c
            r1.m2121a((com.cardinalcommerce.p060a.setLinkTextColor) r5, (com.cardinalcommerce.p060a.setFallbackLineSpacing) r12)
            java.lang.String r5 = r0.init
            int r12 = r5.hashCode()
            super.hashCode()     // Catch:{ all -> 0x0045 }
            switch(r12) {
                case 1537: goto L_0x00dd;
                case 1538: goto L_0x00bf;
                case 1539: goto L_0x0089;
                case 1540: goto L_0x0062;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x005f
        L_0x0045:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0048:
            com.cardinalcommerce.a.setLinkTextColor r5 = r0.CardinalActionCode
            com.cardinalcommerce.a.setFallbackLineSpacing r12 = r1.f3027b
            r1.m2121a((com.cardinalcommerce.p060a.setLinkTextColor) r5, (com.cardinalcommerce.p060a.setFallbackLineSpacing) r12)
            com.cardinalcommerce.a.setLinkTextColor r5 = r0.getString
            com.cardinalcommerce.a.setFallbackLineSpacing r12 = r1.f3028c
            r1.m2121a((com.cardinalcommerce.p060a.setLinkTextColor) r5, (com.cardinalcommerce.p060a.setFallbackLineSpacing) r12)
            java.lang.String r5 = r0.init
            int r12 = r5.hashCode()
            switch(r12) {
                case 1537: goto L_0x00dd;
                case 1538: goto L_0x00bf;
                case 1539: goto L_0x0089;
                case 1540: goto L_0x0062;
                default: goto L_0x005f;
            }
        L_0x005f:
            r3 = -1
            goto L_0x00fb
        L_0x0062:
            boolean r3 = r5.equals(r7)
            r5 = 89
            if (r3 == 0) goto L_0x006d
            r3 = 70
            goto L_0x006f
        L_0x006d:
            r3 = 89
        L_0x006f:
            if (r3 == r5) goto L_0x005f
            int r3 = f3021D
            r5 = r3 ^ 113(0x71, float:1.58E-43)
            r12 = r3 & 113(0x71, float:1.58E-43)
            r5 = r5 | r12
            int r5 = r5 << r4
            int r12 = ~r12
            r3 = r3 | 113(0x71, float:1.58E-43)
            r3 = r3 & r12
            int r3 = -r3
            int r3 = ~r3
            int r5 = r5 - r3
            int r5 = r5 - r4
            int r3 = r5 % 128
            f3022E = r3
            int r5 = r5 % r2
            r3 = 3
            goto L_0x00fb
        L_0x0089:
            java.lang.String r12 = "03"
            boolean r5 = r5.equals(r12)
            if (r5 == 0) goto L_0x0093
            r5 = 0
            goto L_0x0094
        L_0x0093:
            r5 = 1
        L_0x0094:
            if (r5 == 0) goto L_0x0097
            goto L_0x005f
        L_0x0097:
            int r5 = f3021D
            r12 = r5 ^ 71
            r13 = r5 & 71
            r12 = r12 | r13
            int r12 = r12 << r4
            int r13 = ~r13
            r3 = r3 | r5
            r3 = r3 & r13
            int r12 = r12 - r3
            int r3 = r12 % 128
            f3022E = r3
            int r12 = r12 % r2
            int r3 = f3022E
            r5 = r3 & -64
            int r12 = ~r3
            r12 = r12 & 63
            r5 = r5 | r12
            r3 = r3 & 63
            int r3 = r3 << r4
            int r3 = -r3
            int r3 = -r3
            int r3 = ~r3
            int r5 = r5 - r3
            int r5 = r5 - r4
            int r3 = r5 % 128
            f3021D = r3
            int r5 = r5 % r2
            r3 = 2
            goto L_0x00fb
        L_0x00bf:
            java.lang.String r3 = "02"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x00c9
            r3 = 1
            goto L_0x00ca
        L_0x00c9:
            r3 = 0
        L_0x00ca:
            if (r3 == 0) goto L_0x005f
            int r3 = f3022E
            int r3 = r3 + 126
            int r3 = r3 - r4
            int r5 = r3 % 128
            f3021D = r5
            int r3 = r3 % r2
            if (r3 == 0) goto L_0x00da
            r3 = 3
            goto L_0x00db
        L_0x00da:
            r3 = 4
        L_0x00db:
            r3 = 1
            goto L_0x00fb
        L_0x00dd:
            java.lang.String r3 = "01"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x00e7
            r3 = 0
            goto L_0x00e8
        L_0x00e7:
            r3 = 1
        L_0x00e8:
            if (r3 == 0) goto L_0x00ec
            goto L_0x005f
        L_0x00ec:
            int r3 = f3022E
            int r3 = r3 + 12
            r5 = r3 | -1
            int r5 = r5 << r4
            r3 = r3 ^ r10
            int r5 = r5 - r3
            int r3 = r5 % 128
            f3021D = r3
            int r5 = r5 % r2
            r3 = 0
        L_0x00fb:
            r5 = 99
            if (r3 == 0) goto L_0x0129
            if (r3 == r4) goto L_0x0112
            if (r3 == r2) goto L_0x0104
            goto L_0x0147
        L_0x0104:
            java.util.ArrayList<com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds> r3 = r0.CardinalRenderType
            r1.m2126a((java.util.ArrayList<com.cardinalcommerce.p060a.setCompoundDrawablesRelativeWithIntrinsicBounds>) r3)
            int r3 = f3022E
            int r3 = r3 + r6
            int r6 = r3 % 128
            f3021D = r6
            int r3 = r3 % r2
            goto L_0x0147
        L_0x0112:
            java.util.ArrayList<com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds> r3 = r0.CardinalRenderType
            r1.m2130b((java.util.ArrayList<com.cardinalcommerce.p060a.setCompoundDrawablesRelativeWithIntrinsicBounds>) r3)
            int r3 = f3021D
            r6 = r3 & 101(0x65, float:1.42E-43)
            r3 = r3 ^ 101(0x65, float:1.42E-43)
            r3 = r3 | r6
            r12 = r6 | r3
            int r12 = r12 << r4
            r3 = r3 ^ r6
            int r12 = r12 - r3
            int r3 = r12 % 128
            f3022E = r3
            int r12 = r12 % r2
            goto L_0x0147
        L_0x0129:
            com.cardinalcommerce.a.setLetterSpacing r3 = r1.f3033h
            java.lang.String r6 = ""
            r3.setCCAText(r6)
            com.cardinalcommerce.a.setLetterSpacing r3 = r1.f3033h
            r3.setCCAFocusableInTouchMode(r4)
            com.cardinalcommerce.a.setLetterSpacing r3 = r1.f3033h
            com.cardinalcommerce.a.setTextLocales$4 r6 = new com.cardinalcommerce.a.setTextLocales$4
            r6.<init>()
            r3.setCCAOnFocusChangeListener(r6)
            int r3 = f3022E
            int r3 = r3 + r5
            int r6 = r3 % 128
            f3021D = r6
            int r3 = r3 % r2
        L_0x0147:
            java.lang.String r3 = r0.getUiType
            if (r3 == 0) goto L_0x014d
            r3 = 0
            goto L_0x014e
        L_0x014d:
            r3 = 1
        L_0x014e:
            r6 = 2131435829(0x7f0b2135, float:1.8493511E38)
            r12 = 9
            if (r3 == r4) goto L_0x01e8
            int r3 = f3021D
            r13 = r3 & -120(0xffffffffffffff88, float:NaN)
            int r14 = ~r3
            r15 = 119(0x77, float:1.67E-43)
            r14 = r14 & r15
            r13 = r13 | r14
            r3 = r3 & r15
            int r3 = r3 << r4
            int r13 = r13 + r3
            int r3 = r13 % 128
            f3022E = r3
            int r13 = r13 % r2
            java.lang.String r3 = r0.getUiType
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x01e8
            android.view.View r3 = r1.findViewById(r6)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.removeAllViews()
            com.cardinalcommerce.a.setElegantTextHeight r6 = new com.cardinalcommerce.a.setElegantTextHeight
            r6.<init>(r1)
            r1.f3041p = r6
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r6 = r1.f3045t
            if (r6 == 0) goto L_0x0184
            r6 = 0
            goto L_0x0185
        L_0x0184:
            r6 = 1
        L_0x0185:
            if (r6 == 0) goto L_0x0188
            goto L_0x01c5
        L_0x0188:
            int r6 = f3021D
            r13 = r6 & 125(0x7d, float:1.75E-43)
            int r14 = ~r13
            r6 = r6 | 125(0x7d, float:1.75E-43)
            r6 = r6 & r14
            int r13 = r13 << r4
            int r13 = -r13
            int r13 = -r13
            int r13 = ~r13
            int r6 = r6 - r13
            int r6 = r6 - r4
            int r13 = r6 % 128
            f3022E = r13
            int r6 = r6 % r2
            if (r6 != 0) goto L_0x01a0
            r6 = 21
            goto L_0x01a2
        L_0x01a0:
            r6 = 99
        L_0x01a2:
            if (r6 == r5) goto L_0x01b2
            com.cardinalcommerce.a.setElegantTextHeight r6 = r1.f3041p
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r13 = r1.f3045t
            com.cardinalcommerce.p060a.setPaintFlags.configure((com.cardinalcommerce.p060a.setElegantTextHeight) r6, (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r13, (android.app.Activity) r1)
            r6 = 83
            int r6 = r6 / r11
            goto L_0x01b9
        L_0x01af:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x01b2:
            com.cardinalcommerce.a.setElegantTextHeight r6 = r1.f3041p
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r13 = r1.f3045t
            com.cardinalcommerce.p060a.setPaintFlags.configure((com.cardinalcommerce.p060a.setElegantTextHeight) r6, (com.cardinalcommerce.shared.userinterfaces.UiCustomization) r13, (android.app.Activity) r1)
        L_0x01b9:
            int r6 = f3021D
            r13 = r6 | 9
            int r13 = r13 << r4
            r6 = r6 ^ r12
            int r13 = r13 - r6
            int r6 = r13 % 128
            f3022E = r6
            int r13 = r13 % r2
        L_0x01c5:
            com.cardinalcommerce.a.setElegantTextHeight r6 = r1.f3041p
            java.lang.String r13 = r0.getUiType
            r6.setCCAText(r13)
            com.cardinalcommerce.a.setElegantTextHeight r6 = r1.f3041p
            com.cardinalcommerce.a.setTextLocales$9 r13 = new com.cardinalcommerce.a.setTextLocales$9
            r13.<init>()
            r6.setCCAOnClickListener(r13)
            com.cardinalcommerce.a.setElegantTextHeight r6 = r1.f3041p
            r3.addView(r6)
            int r3 = f3022E
            r6 = r3 ^ 119(0x77, float:1.67E-43)
            r3 = r3 & r15
            int r3 = r3 << r4
            int r6 = r6 + r3
            int r3 = r6 % 128
            f3021D = r3
            int r6 = r6 % r2
            goto L_0x0207
        L_0x01e8:
            android.view.View r3 = r1.findViewById(r6)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.removeAllViews()
            r3.setPadding(r11, r11, r11, r11)
            int r3 = f3022E
            r6 = r3 & 87
            int r13 = ~r6
            r3 = r3 | 87
            r3 = r3 & r13
            int r6 = r6 << r4
            int r6 = -r6
            int r6 = -r6
            int r6 = ~r6
            int r3 = r3 - r6
            int r3 = r3 - r4
            int r6 = r3 % 128
            f3021D = r6
            int r3 = r3 % r2
        L_0x0207:
            java.lang.String r3 = r1.f3023A
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0211
            r3 = 0
            goto L_0x0212
        L_0x0211:
            r3 = 1
        L_0x0212:
            r6 = 93
            r13 = 8
            if (r3 == r4) goto L_0x031d
            int r3 = f3022E
            r14 = r3 & 72
            r3 = r3 | 72
            int r14 = r14 + r3
            r3 = r14 | -1
            int r3 = r3 << r4
            r14 = r14 ^ r10
            int r3 = r3 - r14
            int r14 = r3 % 128
            f3021D = r14
            int r3 = r3 % r2
            if (r3 == 0) goto L_0x022d
            r3 = 1
            goto L_0x022e
        L_0x022d:
            r3 = 0
        L_0x022e:
            if (r3 == 0) goto L_0x023e
            java.lang.String r3 = r0.getSDKVersion
            int r14 = r9.length     // Catch:{ all -> 0x023b }
            if (r3 == 0) goto L_0x0237
            r3 = 1
            goto L_0x0238
        L_0x0237:
            r3 = 0
        L_0x0238:
            if (r3 == r4) goto L_0x0248
            goto L_0x0256
        L_0x023b:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x023e:
            java.lang.String r3 = r0.getSDKVersion
            if (r3 == 0) goto L_0x0244
            r3 = 0
            goto L_0x0245
        L_0x0244:
            r3 = 1
        L_0x0245:
            if (r3 == 0) goto L_0x0248
            goto L_0x0256
        L_0x0248:
            java.lang.String r3 = r0.getSDKVersion
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0252
            r3 = 2
            goto L_0x0254
        L_0x0252:
            r3 = 38
        L_0x0254:
            if (r3 == r2) goto L_0x0267
        L_0x0256:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3032g
            r3.setVisibility(r13)
            int r3 = f3022E
            r14 = r3 & 93
            r3 = r3 | r6
            int r14 = r14 + r3
            int r3 = r14 % 128
            f3021D = r3
            int r14 = r14 % r2
            goto L_0x0296
        L_0x0267:
            int r3 = f3022E
            r14 = r3 & 125(0x7d, float:1.75E-43)
            int r15 = ~r14
            r3 = r3 | 125(0x7d, float:1.75E-43)
            r3 = r3 & r15
            int r14 = r14 << r4
            r15 = r3 | r14
            int r15 = r15 << r4
            r3 = r3 ^ r14
            int r15 = r15 - r3
            int r3 = r15 % 128
            f3021D = r3
            int r15 = r15 % r2
            if (r15 == 0) goto L_0x027e
            r3 = 0
            goto L_0x027f
        L_0x027e:
            r3 = 1
        L_0x027f:
            if (r3 == r4) goto L_0x028f
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3032g
            java.lang.String r14 = r0.getSDKVersion
            r3.setCCAText(r14)
            super.hashCode()     // Catch:{ all -> 0x028c }
            goto L_0x0296
        L_0x028c:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x028f:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3032g
            java.lang.String r14 = r0.getSDKVersion
            r3.setCCAText(r14)
        L_0x0296:
            boolean r3 = r16.m2127a()
            if (r3 == 0) goto L_0x029e
            r3 = 1
            goto L_0x029f
        L_0x029e:
            r3 = 0
        L_0x029f:
            if (r3 == r4) goto L_0x02a2
            goto L_0x02e3
        L_0x02a2:
            int r3 = f3022E
            r14 = r3 ^ 82
            r3 = r3 & 82
            int r3 = r3 << r4
            int r14 = r14 + r3
            r3 = r14 ^ -1
            r14 = r14 & r10
            int r14 = r14 << r4
            int r3 = r3 + r14
            int r14 = r3 % 128
            f3021D = r14
            int r3 = r3 % r2
            if (r3 == 0) goto L_0x02b8
            r3 = 0
            goto L_0x02b9
        L_0x02b8:
            r3 = 1
        L_0x02b9:
            if (r3 == 0) goto L_0x02c1
            com.cardinalcommerce.a.setHyphenationFrequency r3 = r1.f3035j
            r3.setCCAVisibility(r11)
            goto L_0x02c6
        L_0x02c1:
            com.cardinalcommerce.a.setHyphenationFrequency r3 = r1.f3035j
            r3.setCCAVisibility(r4)
        L_0x02c6:
            com.cardinalcommerce.a.setHyphenationFrequency r3 = r1.f3035j
            java.lang.String r14 = r0.getActionCode
            r3.setCCAText(r14)
            int r3 = f3021D
            r14 = 29
            r15 = r3 & -30
            int r6 = ~r3
            r6 = r6 & r14
            r6 = r6 | r15
            r3 = r3 & r14
            int r3 = r3 << r4
            int r3 = -r3
            int r3 = -r3
            r14 = r6 & r3
            r3 = r3 | r6
            int r14 = r14 + r3
            int r3 = r14 % 128
            f3022E = r3
            int r14 = r14 % r2
        L_0x02e3:
            java.lang.String r3 = r0.getProxyAddress
            if (r3 == 0) goto L_0x02e9
            r3 = 0
            goto L_0x02ea
        L_0x02e9:
            r3 = 1
        L_0x02ea:
            if (r3 == 0) goto L_0x02ed
            goto L_0x031d
        L_0x02ed:
            int r3 = f3022E
            r6 = r3 ^ 5
            r14 = r3 & 5
            r6 = r6 | r14
            int r6 = r6 << r4
            int r14 = ~r14
            r3 = r3 | 5
            r3 = r3 & r14
            int r6 = r6 - r3
            int r3 = r6 % 128
            f3021D = r3
            int r6 = r6 % r2
            if (r6 == 0) goto L_0x0304
            r3 = 93
            goto L_0x0306
        L_0x0304:
            r3 = 80
        L_0x0306:
            r6 = 80
            if (r3 == r6) goto L_0x0316
            com.cardinalcommerce.a.setHyphenationFrequency r3 = r1.f3034i
            java.lang.String r6 = r0.getProxyAddress
            r3.setCCAText(r6)
            int r3 = r9.length     // Catch:{ all -> 0x0313 }
            goto L_0x031d
        L_0x0313:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0316:
            com.cardinalcommerce.a.setHyphenationFrequency r3 = r1.f3034i
            java.lang.String r6 = r0.getProxyAddress
            r3.setCCAText(r6)
        L_0x031d:
            java.lang.String r3 = r0.getRequestTimeout
            if (r3 == 0) goto L_0x0323
            r3 = 0
            goto L_0x0324
        L_0x0323:
            r3 = 1
        L_0x0324:
            r6 = 69
            if (r3 == r4) goto L_0x038c
            int r3 = f3021D
            r14 = r3 | 92
            int r14 = r14 << r4
            r3 = r3 ^ 92
            int r14 = r14 - r3
            r3 = r14 | -1
            int r3 = r3 << r4
            r14 = r14 ^ r10
            int r3 = r3 - r14
            int r14 = r3 % 128
            f3022E = r14
            int r3 = r3 % r2
            if (r3 != 0) goto L_0x033e
            r3 = 1
            goto L_0x033f
        L_0x033e:
            r3 = 0
        L_0x033f:
            if (r3 == 0) goto L_0x0355
            java.lang.String r3 = r1.f3023A
            boolean r3 = r3.equals(r7)
            super.hashCode()     // Catch:{ all -> 0x0352 }
            if (r3 == 0) goto L_0x034e
            r3 = 1
            goto L_0x034f
        L_0x034e:
            r3 = 0
        L_0x034f:
            if (r3 == 0) goto L_0x038c
            goto L_0x0362
        L_0x0352:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0355:
            java.lang.String r3 = r1.f3023A
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x035f
            r3 = 1
            goto L_0x0360
        L_0x035f:
            r3 = 0
        L_0x0360:
            if (r3 == 0) goto L_0x038c
        L_0x0362:
            int r3 = f3022E
            r7 = r3 & 69
            r3 = r3 ^ r6
            r3 = r3 | r7
            int r3 = -r3
            int r3 = -r3
            int r3 = ~r3
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r3 = r7 % 128
            f3021D = r3
            int r7 = r7 % r2
            if (r7 == 0) goto L_0x0376
            r3 = 0
            goto L_0x0377
        L_0x0376:
            r3 = 1
        L_0x0377:
            if (r3 == r4) goto L_0x0385
            com.cardinalcommerce.a.setHyphenationFrequency r3 = r1.f3034i
            java.lang.String r7 = r0.getRequestTimeout
            r3.setCCAText(r7)
            int r3 = r9.length     // Catch:{ all -> 0x0382 }
            goto L_0x038c
        L_0x0382:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0385:
            com.cardinalcommerce.a.setHyphenationFrequency r3 = r1.f3034i
            java.lang.String r7 = r0.getRequestTimeout
            r3.setCCAText(r7)
        L_0x038c:
            java.lang.String r3 = r0.values
            r7 = 83
            if (r3 == 0) goto L_0x0395
            r3 = 83
            goto L_0x0397
        L_0x0395:
            r3 = 53
        L_0x0397:
            if (r3 == r7) goto L_0x039f
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3030e
            r3.setVisibility(r13)
            goto L_0x03db
        L_0x039f:
            int r3 = f3022E
            int r3 = r3 + 9
            int r3 = r3 - r4
            int r3 = r3 - r11
            int r3 = r3 - r4
            int r7 = r3 % 128
            f3021D = r7
            int r3 = r3 % r2
            if (r3 == 0) goto L_0x03b0
            r3 = 32
            goto L_0x03b2
        L_0x03b0:
            r3 = 14
        L_0x03b2:
            r7 = 14
            if (r3 == r7) goto L_0x03c2
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3030e
            java.lang.String r7 = r0.values
            r3.setCCAText(r7)
            int r3 = r9.length     // Catch:{ all -> 0x03bf }
            goto L_0x03c9
        L_0x03bf:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x03c2:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3030e
            java.lang.String r7 = r0.values
            r3.setCCAText(r7)
        L_0x03c9:
            int r3 = f3022E
            r7 = r3 ^ 113(0x71, float:1.58E-43)
            r3 = r3 & 113(0x71, float:1.58E-43)
            r3 = r3 | r7
            int r3 = r3 << r4
            int r7 = -r7
            r14 = r3 & r7
            r3 = r3 | r7
            int r14 = r14 + r3
            int r3 = r14 % 128
            f3021D = r3
            int r14 = r14 % r2
        L_0x03db:
            java.lang.String r3 = r0.cleanup
            r7 = 34
            if (r3 == 0) goto L_0x03e4
            r3 = 34
            goto L_0x03e6
        L_0x03e4:
            r3 = 43
        L_0x03e6:
            if (r3 == r7) goto L_0x03fa
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3031f
            r3.setVisibility(r8)
            int r3 = f3021D
            int r3 = r3 + 59
            int r3 = r3 - r4
            int r3 = r3 - r11
            int r3 = r3 - r4
            int r14 = r3 % 128
            f3022E = r14
            int r3 = r3 % r2
            goto L_0x0412
        L_0x03fa:
            int r3 = f3021D
            r14 = r3 & 103(0x67, float:1.44E-43)
            r3 = r3 ^ 103(0x67, float:1.44E-43)
            r3 = r3 | r14
            r15 = r14 ^ r3
            r3 = r3 & r14
            int r3 = r3 << r4
            int r15 = r15 + r3
            int r3 = r15 % 128
            f3022E = r3
            int r15 = r15 % r2
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3031f
            java.lang.String r14 = r0.cleanup
            r3.setCCAText(r14)
        L_0x0412:
            java.lang.String r3 = r0.CardinalError
            if (r3 == 0) goto L_0x0418
            r3 = 1
            goto L_0x0419
        L_0x0418:
            r3 = 0
        L_0x0419:
            if (r3 == r4) goto L_0x0430
            com.cardinalcommerce.a.setFallbackLineSpacing r3 = r1.f3029d
            r3.setVisibility(r13)
            int r3 = f3021D
            r7 = r3 & 99
            r3 = r3 ^ r5
            r3 = r3 | r7
            r14 = r7 & r3
            r3 = r3 | r7
            int r14 = r14 + r3
            int r3 = r14 % 128
            f3022E = r3
            int r14 = r14 % r2
            goto L_0x048b
        L_0x0430:
            int r3 = f3021D
            r14 = r3 & 107(0x6b, float:1.5E-43)
            r3 = r3 ^ 107(0x6b, float:1.5E-43)
            r3 = r3 | r14
            int r3 = -r3
            int r3 = -r3
            r15 = r14 & r3
            r3 = r3 | r14
            int r15 = r15 + r3
            int r3 = r15 % 128
            f3022E = r3
            int r15 = r15 % r2
            if (r15 != 0) goto L_0x0446
            r3 = 0
            goto L_0x0447
        L_0x0446:
            r3 = 1
        L_0x0447:
            if (r3 == r4) goto L_0x045f
            java.lang.String r3 = r0.CardinalError
            java.lang.String r14 = "Y"
            boolean r3 = r3.equalsIgnoreCase(r14)
            int r14 = r9.length     // Catch:{ all -> 0x045c }
            if (r3 == 0) goto L_0x0457
            r3 = 34
            goto L_0x0459
        L_0x0457:
            r3 = 11
        L_0x0459:
            if (r3 == r7) goto L_0x047e
            goto L_0x046e
        L_0x045c:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x045f:
            java.lang.String r3 = r0.CardinalError
            java.lang.String r7 = "Y"
            boolean r3 = r3.equalsIgnoreCase(r7)
            if (r3 == 0) goto L_0x046b
            r3 = 1
            goto L_0x046c
        L_0x046b:
            r3 = 0
        L_0x046c:
            if (r3 == r4) goto L_0x047e
        L_0x046e:
            com.cardinalcommerce.a.setFallbackLineSpacing r3 = r1.f3029d
            r3.setVisibility(r13)
            int r3 = f3021D
            int r3 = r3 + 94
            int r3 = r3 - r4
            int r7 = r3 % 128
            f3022E = r7
            int r3 = r3 % r2
            goto L_0x048b
        L_0x047e:
            com.cardinalcommerce.a.setFallbackLineSpacing r3 = r1.f3029d
            r7 = 2131236258(0x7f0815a2, float:1.8088733E38)
            r3.setCCAImageResource(r7)
            com.cardinalcommerce.a.setFallbackLineSpacing r3 = r1.f3029d
            r3.setVisibility(r11)
        L_0x048b:
            java.lang.String r3 = r0.getChallengeTimeout
            if (r3 == 0) goto L_0x0491
            r3 = 1
            goto L_0x0493
        L_0x0491:
            r3 = 9
        L_0x0493:
            if (r3 == r12) goto L_0x050e
            int r3 = f3022E
            r7 = r3 & 125(0x7d, float:1.75E-43)
            r3 = r3 | 125(0x7d, float:1.75E-43)
            int r3 = -r3
            int r3 = -r3
            int r3 = ~r3
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r3 = r7 % 128
            f3021D = r3
            int r7 = r7 % r2
            java.lang.String r3 = r0.getChallengeTimeout
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x04b0
            r3 = 8
            goto L_0x04b2
        L_0x04b0:
            r3 = 25
        L_0x04b2:
            if (r3 == r13) goto L_0x04b5
            goto L_0x050e
        L_0x04b5:
            int r3 = f3021D
            int r3 = r3 + 67
            int r7 = r3 % 128
            f3022E = r7
            int r3 = r3 % r2
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3036k
            java.lang.String r7 = r0.getChallengeTimeout
            r3.setCCAText(r7)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3036k
            r7 = 2131235062(0x7f0810f6, float:1.8086307E38)
            r3.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r11, r7, r11)
            java.lang.String r3 = r0.setEnvironment
            if (r3 == 0) goto L_0x04d3
            r3 = 2
            goto L_0x04d5
        L_0x04d3:
            r3 = 94
        L_0x04d5:
            if (r3 == r2) goto L_0x04f0
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3037l
            r3.setVisibility(r8)
            int r3 = f3022E
            r7 = 81
            r12 = r3 & -82
            int r13 = ~r3
            r13 = r13 & r7
            r12 = r12 | r13
            r3 = r3 & r7
            int r3 = r3 << r4
            int r3 = ~r3
            int r12 = r12 - r3
            int r12 = r12 - r4
            int r3 = r12 % 128
            f3021D = r3
            int r12 = r12 % r2
            goto L_0x0525
        L_0x04f0:
            int r3 = f3021D
            int r3 = r3 + 13
            int r3 = r3 - r4
            int r3 = r3 - r11
            int r3 = r3 - r4
            int r7 = r3 % 128
            f3022E = r7
            int r3 = r3 % r2
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3037l
            java.lang.String r7 = r0.setEnvironment
            r3.setCCAText(r7)
            int r3 = f3021D
            int r3 = r3 + 58
            int r3 = r3 - r4
            int r7 = r3 % 128
            f3022E = r7
        L_0x050c:
            int r3 = r3 % r2
            goto L_0x0525
        L_0x050e:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3036k
            r3.setVisibility(r8)
            int r3 = f3022E
            r7 = r3 ^ 108(0x6c, float:1.51E-43)
            r3 = r3 & 108(0x6c, float:1.51E-43)
            int r3 = r3 << r4
            int r7 = r7 + r3
            r3 = r7 | -1
            int r3 = r3 << r4
            r7 = r7 ^ r10
            int r3 = r3 - r7
            int r7 = r3 % 128
            f3021D = r7
            goto L_0x050c
        L_0x0525:
            java.lang.String r3 = r0.CardinalUiType
            if (r3 == 0) goto L_0x052c
            r3 = 69
            goto L_0x052e
        L_0x052c:
            r3 = 66
        L_0x052e:
            if (r3 == r6) goto L_0x0531
            goto L_0x0565
        L_0x0531:
            int r3 = f3021D
            int r3 = r3 + 106
            r6 = r3 ^ -1
            r3 = r3 & r10
            int r3 = r3 << r4
            int r6 = r6 + r3
            int r3 = r6 % 128
            f3022E = r3
            int r6 = r6 % r2
            if (r6 != 0) goto L_0x0543
            r5 = 73
        L_0x0543:
            r3 = 73
            if (r5 == r3) goto L_0x0555
            java.lang.String r3 = r0.CardinalUiType
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0551
            r3 = 1
            goto L_0x0552
        L_0x0551:
            r3 = 0
        L_0x0552:
            if (r3 == r4) goto L_0x0582
            goto L_0x0565
        L_0x0555:
            java.lang.String r3 = r0.CardinalUiType
            boolean r3 = r3.isEmpty()
            super.hashCode()     // Catch:{ all -> 0x05ec }
            if (r3 != 0) goto L_0x0562
            r3 = 1
            goto L_0x0563
        L_0x0562:
            r3 = 0
        L_0x0563:
            if (r3 == r4) goto L_0x0582
        L_0x0565:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r1.f3038m
            r0.setVisibility(r8)
            int r0 = f3021D
            r3 = r0 ^ 115(0x73, float:1.61E-43)
            r5 = r0 & 115(0x73, float:1.61E-43)
            r3 = r3 | r5
            int r3 = r3 << r4
            int r5 = ~r5
            r0 = r0 | 115(0x73, float:1.61E-43)
            r0 = r0 & r5
            int r0 = -r0
            r5 = r3 ^ r0
            r0 = r0 & r3
            int r0 = r0 << r4
            int r5 = r5 + r0
            int r0 = r5 % 128
            f3022E = r0
            int r5 = r5 % r2
            return
        L_0x0582:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3038m
            java.lang.String r5 = r0.CardinalUiType
            r3.setCCAText(r5)
            com.cardinalcommerce.a.setShowSoftInputOnFocus r3 = r1.f3038m
            r5 = 2131235062(0x7f0810f6, float:1.8086307E38)
            r3.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r11, r5, r11)
            java.lang.String r3 = r0.setEnvironment
            if (r3 == 0) goto L_0x0597
            r3 = 0
            goto L_0x0598
        L_0x0597:
            r3 = 1
        L_0x0598:
            if (r3 == 0) goto L_0x05bf
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r1.f3039n
            r0.setVisibility(r8)
            int r0 = f3022E
            r3 = r0 | 19
            int r5 = r3 << 1
            r0 = r0 & 19
            int r0 = ~r0
            r0 = r0 & r3
            int r0 = -r0
            r3 = r5 ^ r0
            r0 = r0 & r5
            int r0 = r0 << r4
            int r3 = r3 + r0
            int r0 = r3 % 128
            f3021D = r0
            int r3 = r3 % r2
            if (r3 == 0) goto L_0x05b7
            r4 = 0
        L_0x05b7:
            if (r4 == 0) goto L_0x05ba
            return
        L_0x05ba:
            int r0 = r9.length     // Catch:{ all -> 0x05bc }
            return
        L_0x05bc:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x05bf:
            int r3 = f3021D
            r5 = r3 | 23
            int r4 = r5 << 1
            r3 = r3 ^ 23
            int r4 = r4 - r3
            int r3 = r4 % 128
            f3022E = r3
            int r4 = r4 % r2
            if (r4 != 0) goto L_0x05d2
            r6 = 79
            goto L_0x05d4
        L_0x05d2:
            r6 = 93
        L_0x05d4:
            r2 = 79
            if (r6 == r2) goto L_0x05e0
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3039n
            java.lang.String r0 = r0.valueOf
            r2.setCCAText(r0)
            return
        L_0x05e0:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r2 = r1.f3039n
            java.lang.String r0 = r0.valueOf
            r2.setCCAText(r0)
            int r0 = r9.length     // Catch:{ all -> 0x05e9 }
            return
        L_0x05e9:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x05ec:
            r0 = move-exception
            r2 = r0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.m2120a(com.cardinalcommerce.a.setBaselineAligned):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String] */
    public void onBackPressed() {
        super.onBackPressed();
        ? r3 = 0;
        setTextMetricsParams.getSDKVersion().init("Native Challenge Screen", "Back button pressed", r3);
        setCompoundDrawablesWithIntrinsicBounds setcompounddrawableswithintrinsicbounds = new setCompoundDrawablesWithIntrinsicBounds();
        setcompounddrawableswithintrinsicbounds.getInstance = setHeight.getWarnings;
        setTypeface settypeface = new setTypeface(this.f3044s, setcompounddrawableswithintrinsicbounds);
        this.f3043r = settypeface;
        runOnUiThread(new Runnable() {
            private static int cca_continue = 0;
            private static int configure = 1;

            /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
                if ((com.cardinalcommerce.p060a.setTextLocales.m2146p(r6.getInstance) ? 4 : 'A') != 4) goto L_0x0083;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
                if ((!com.cardinalcommerce.p060a.setTextLocales.m2146p(r6.getInstance)) != true) goto L_0x0060;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    int r0 = cca_continue
                    r1 = r0 & 103(0x67, float:1.44E-43)
                    r0 = r0 | 103(0x67, float:1.44E-43)
                    r2 = r1 | r0
                    r3 = 1
                    int r2 = r2 << r3
                    r0 = r0 ^ r1
                    int r2 = r2 - r0
                    int r0 = r2 % 128
                    configure = r0
                    int r2 = r2 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r1 = 0
                    if (r0 == 0) goto L_0x001d
                    r0 = 1
                    goto L_0x001e
                L_0x001d:
                    r0 = 0
                L_0x001e:
                    if (r0 == r3) goto L_0x0021
                    goto L_0x0083
                L_0x0021:
                    int r0 = configure
                    r2 = r0 & 117(0x75, float:1.64E-43)
                    r0 = r0 ^ 117(0x75, float:1.64E-43)
                    r0 = r0 | r2
                    int r0 = -r0
                    int r0 = -r0
                    int r0 = ~r0
                    int r2 = r2 - r0
                    int r2 = r2 - r3
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                    r0 = 67
                    if (r2 == 0) goto L_0x003a
                    r2 = 39
                    goto L_0x003c
                L_0x003a:
                    r2 = 67
                L_0x003c:
                    if (r2 == r0) goto L_0x0053
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    r2 = 84
                    int r2 = r2 / r1
                    r2 = 4
                    if (r0 == 0) goto L_0x004c
                    r0 = 4
                    goto L_0x004e
                L_0x004c:
                    r0 = 65
                L_0x004e:
                    if (r0 == r2) goto L_0x0060
                    goto L_0x0083
                L_0x0051:
                    r0 = move-exception
                    throw r0
                L_0x0053:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    if (r0 == 0) goto L_0x005d
                    r0 = 0
                    goto L_0x005e
                L_0x005d:
                    r0 = 1
                L_0x005e:
                    if (r0 == r3) goto L_0x0083
                L_0x0060:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r0.setEnabled(r1)
                    int r0 = configure
                    r2 = 125(0x7d, float:1.75E-43)
                    r4 = r0 ^ 125(0x7d, float:1.75E-43)
                    r5 = r0 & 125(0x7d, float:1.75E-43)
                    r4 = r4 | r5
                    int r4 = r4 << r3
                    r5 = r0 & -126(0xffffffffffffff82, float:NaN)
                    int r0 = ~r0
                    r0 = r0 & r2
                    r0 = r0 | r5
                    int r0 = -r0
                    r2 = r4 & r0
                    r0 = r0 | r4
                    int r2 = r2 + r0
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                L_0x0083:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    java.lang.String r0 = com.cardinalcommerce.p060a.setTextLocales.m2132c(r0)
                    java.lang.String r2 = "01"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x0093
                    r0 = 0
                    goto L_0x0094
                L_0x0093:
                    r0 = 1
                L_0x0094:
                    if (r0 == r3) goto L_0x00bd
                    int r0 = configure
                    r2 = r0 ^ 47
                    r0 = r0 & 47
                    int r0 = r0 << r3
                    r4 = r2 | r0
                    int r4 = r4 << r3
                    r0 = r0 ^ r2
                    int r4 = r4 - r0
                    int r0 = r4 % 128
                    cca_continue = r0
                    int r4 = r4 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setLetterSpacing r0 = com.cardinalcommerce.p060a.setTextLocales.m2117a((com.cardinalcommerce.p060a.setTextLocales) r0)
                    r0.setFocusable(r1)
                    int r0 = cca_continue
                    int r0 = r0 + 101
                    int r0 = r0 - r3
                    int r0 = r0 - r3
                    int r2 = r0 % 128
                    configure = r2
                    int r0 = r0 % 2
                L_0x00bd:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2139i(r0)
                    r0.setEnabled(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.widget.ProgressBar r0 = com.cardinalcommerce.p060a.setTextLocales.m2147q(r0)
                    r0.setVisibility(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.view.Window r0 = r0.getWindow()
                    r2 = 16
                    r0.setFlags(r2, r2)
                    int r0 = configure
                    r2 = r0 & 11
                    r0 = r0 ^ 11
                    r0 = r0 | r2
                    int r2 = r2 + r0
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                    if (r2 == 0) goto L_0x00eb
                    r1 = 1
                L_0x00eb:
                    if (r1 == r3) goto L_0x00ee
                    return
                L_0x00ee:
                    r0 = 0
                    int r0 = r0.length     // Catch:{ all -> 0x00f1 }
                    return
                L_0x00f1:
                    r0 = move-exception
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.C209515.run():void");
            }
        });
        setTextSelectHandle.cca_continue(getApplicationContext()).cca_continue(settypeface, this, this.f3023A);
        int i = f3021D;
        int i2 = i ^ 79;
        int i3 = (((i & 79) | i2) << 1) - i2;
        f3022E = i3 % 128;
        if ((i3 % 2 == 0 ? 'X' : 24) == 'X') {
            int length = r3.length;
        }
    }

    /* renamed from: a */
    private void m2126a(ArrayList<setCompoundDrawablesRelativeWithIntrinsicBounds> arrayList) {
        this.f3047v = arrayList;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.multiSelectgroup);
        linearLayout.removeAllViews();
        this.f3050y = new ArrayList();
        int i = f3021D;
        int i2 = i & 85;
        int i3 = (i2 - (~((i ^ 85) | i2))) - 1;
        f3022E = i3 % 128;
        int i4 = i3 % 2;
        int i5 = 0;
        while (true) {
            if (!(i5 <= 0)) {
                break;
            }
            int i6 = f3022E;
            int i7 = ((i6 & 24) + (i6 | 24)) - 1;
            f3021D = i7 % 128;
            int i8 = (i7 % 2 != 0 ? 'E' : 'T') != 'T' ? 1 : 0;
            int i9 = ((f3022E + 32) - 0) - 1;
            f3021D = i9 % 128;
            while (true) {
                int i10 = i9 % 2;
                if (i8 >= arrayList.size()) {
                    break;
                }
                setElegantTextHeight seteleganttextheight = new setElegantTextHeight(this);
                seteleganttextheight.setCCAText(this.f3047v.get(i8).getInstance);
                seteleganttextheight.setCCAId(i8);
                if ((this.f3045t != null ? Typography.amp : 27) == '&') {
                    int i11 = f3021D;
                    int i12 = i11 & 93;
                    int i13 = i12 + ((i11 ^ 93) | i12);
                    f3022E = i13 % 128;
                    int i14 = i13 % 2;
                    setPaintFlags.configure(seteleganttextheight, this.f3045t, (Activity) this);
                    int i15 = f3022E;
                    int i16 = i15 & 93;
                    int i17 = (i16 - (~(-(-((i15 ^ 93) | i16))))) - 1;
                    f3021D = i17 % 128;
                    int i18 = i17 % 2;
                }
                this.f3050y.add(seteleganttextheight);
                seteleganttextheight.setCCAOnClickListener(new setFontFeatureSettings.C2048init() {
                    private static int Cardinal = 0;
                    private static int getInstance = 1;

                    public final void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        int i = getInstance + 95;
                        Cardinal = i % 128;
                        int i2 = i % 2;
                    }
                });
                linearLayout.addView(seteleganttextheight);
                int i19 = (((i8 | -55) << 1) - (i8 ^ -55)) - 1;
                int i20 = i19 & 57;
                int i21 = i19 | 57;
                i8 = (i20 | i21) + (i20 & i21);
                int i22 = f3021D;
                int i23 = i22 & 97;
                i9 = ((i22 | 97) & (~i23)) + (i23 << 1);
                f3022E = i9 % 128;
            }
            int i24 = i5 & 1;
            int i25 = i5 | 1;
            i5 = (i25 | i24) + (i24 & i25);
            int i26 = f3021D;
            int i27 = i26 & 93;
            int i28 = (i26 ^ 93) | i27;
            int i29 = (i27 ^ i28) + ((i28 & i27) << 1);
            f3022E = i29 % 128;
            int i30 = i29 % 2;
        }
        int i31 = f3021D;
        int i32 = (i31 ^ 95) + ((i31 & 95) << 1);
        f3022E = i32 % 128;
        if ((i32 % 2 == 0 ? '?' : 25) != 25) {
            int i33 = 19 / 0;
        }
    }

    /* renamed from: b */
    private void m2130b(ArrayList<setCompoundDrawablesRelativeWithIntrinsicBounds> arrayList) {
        int i = f3021D;
        int i2 = i & 97;
        int i3 = (i ^ 97) | i2;
        int i4 = (i2 & i3) + (i3 | i2);
        f3022E = i4 % 128;
        int i5 = i4 % 2;
        setHighlightColor sethighlightcolor = (setHighlightColor) findViewById(R.id.selectradiogroup);
        this.f3048w = sethighlightcolor;
        sethighlightcolor.removeAllViews();
        this.f3048w.setOrientation(1);
        this.f3047v = arrayList;
        int i6 = f3022E;
        int i7 = i6 ^ 123;
        int i8 = (((i6 & 123) | i7) << 1) - i7;
        f3021D = i8 % 128;
        int i9 = i8 % 2;
        int i10 = 0;
        while (i10 < this.f3047v.size()) {
            setBreakStrategy setbreakstrategy = new setBreakStrategy(this);
            this.f3049x = setbreakstrategy;
            setbreakstrategy.setId(i10);
            this.f3049x.setCCAText(this.f3047v.get(i10).getInstance);
            setPaintFlags.init(this.f3049x, this.f3045t, (Activity) this);
            this.f3049x.setCCAOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                private static int configure = 0;
                private static int getInstance = 1;

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    int i = getInstance + 33;
                    configure = i % 128;
                    int i2 = i % 2;
                    if (!(!z)) {
                        int i3 = getInstance;
                        int i4 = (i3 ^ 80) + ((i3 & 80) << 1);
                        int i5 = ((i4 | -1) << 1) - (i4 ^ -1);
                        configure = i5 % 128;
                        if (!(i5 % 2 != 0)) {
                            setTextLocales settextlocales = setTextLocales.this;
                            setTextLocales.m2123a(settextlocales, setTextLocales.m2136f(settextlocales), z);
                        } else {
                            setTextLocales settextlocales2 = setTextLocales.this;
                            setTextLocales.m2123a(settextlocales2, setTextLocales.m2136f(settextlocales2), z);
                            Object[] objArr = null;
                            int length = objArr.length;
                        }
                    }
                    int i6 = configure;
                    int i7 = (((i6 ^ 28) + ((i6 & 28) << 1)) - 0) - 1;
                    getInstance = i7 % 128;
                    int i8 = i7 % 2;
                }
            });
            this.f3048w.cca_continue(this.f3049x);
            i10++;
            int i11 = f3021D;
            int i12 = i11 ^ 121;
            int i13 = -(-((i11 & 121) << 1));
            int i14 = (i12 & i13) + (i13 | i12);
            f3022E = i14 % 128;
            int i15 = i14 % 2;
        }
        int i16 = f3022E;
        int i17 = (((i16 ^ 102) + ((i16 & 102) << 1)) - 0) - 1;
        f3021D = i17 % 128;
        int i18 = i17 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r1 == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        r7.setVisibility(4);
        r6 = f3021D;
        r7 = (r6 & 1) + (r6 | 1);
        f3022E = r7 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        if ((r7 % 2) != 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0071, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
        if (r2 == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002c, code lost:
        if (r6.equals("") == false) goto L_0x003a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2121a(com.cardinalcommerce.p060a.setLinkTextColor r6, com.cardinalcommerce.p060a.setFallbackLineSpacing r7) throws com.cardinalcommerce.shared.models.exceptions.InvalidInputException {
        /*
            r5 = this;
            int r0 = f3022E
            r1 = r0 ^ 15
            r2 = r0 & 15
            r1 = r1 | r2
            r2 = 1
            int r1 = r1 << r2
            r3 = r0 & -16
            int r0 = ~r0
            r0 = r0 & 15
            r0 = r0 | r3
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f3021D = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 == 0) goto L_0x001e
            r1 = 0
            goto L_0x001f
        L_0x001e:
            r1 = 1
        L_0x001f:
            java.lang.String r3 = ""
            r4 = 0
            if (r1 == 0) goto L_0x002f
            java.lang.String r6 = r6.cca_continue((android.content.Context) r5)
            boolean r1 = r6.equals(r3)
            if (r1 != 0) goto L_0x005e
            goto L_0x003a
        L_0x002f:
            java.lang.String r6 = r6.cca_continue((android.content.Context) r5)
            boolean r1 = r6.equals(r3)
            int r3 = r4.length     // Catch:{ all -> 0x007b }
            if (r1 != 0) goto L_0x005e
        L_0x003a:
            com.cardinalcommerce.a.setTextScaleX r1 = new com.cardinalcommerce.a.setTextScaleX
            r1.<init>(r7, r6)
            java.util.concurrent.ExecutorService r6 = r1.getInstance
            r6.execute(r1)
            int r6 = f3021D
            r7 = r6 & 113(0x71, float:1.58E-43)
            r6 = r6 | 113(0x71, float:1.58E-43)
            int r7 = r7 + r6
            int r6 = r7 % 128
            f3022E = r6
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r0 = 1
        L_0x0055:
            if (r0 == r2) goto L_0x005d
            super.hashCode()     // Catch:{ all -> 0x005b }
            return
        L_0x005b:
            r6 = move-exception
            throw r6
        L_0x005d:
            return
        L_0x005e:
            r6 = 4
            r7.setVisibility(r6)
            int r6 = f3021D
            r7 = r6 & 1
            r6 = r6 | r2
            int r7 = r7 + r6
            int r6 = r7 % 128
            f3022E = r6
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r2 = 0
        L_0x0072:
            if (r2 == 0) goto L_0x007a
            super.hashCode()     // Catch:{ all -> 0x0078 }
            return
        L_0x0078:
            r6 = move-exception
            throw r6
        L_0x007a:
            return
        L_0x007b:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.m2121a(com.cardinalcommerce.a.setLinkTextColor, com.cardinalcommerce.a.setFallbackLineSpacing):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        if ((r5.getButtonCustomization(com.cardinalcommerce.shared.models.enums.ButtonType.RESEND) == null) != true) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        if ((r5.getButtonCustomization(com.cardinalcommerce.shared.models.enums.ButtonType.RESEND) == null) != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        com.cardinalcommerce.p060a.setPaintFlags.cca_continue(r4.f3035j, r5.getButtonCustomization(com.cardinalcommerce.shared.models.enums.ButtonType.RESEND), (android.app.Activity) r4);
        r5 = f3022E;
        r0 = (r5 ^ 69) + ((r5 & 69) << 1);
        f3021D = r0 % 128;
        r0 = r0 % 2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2124a(com.cardinalcommerce.shared.userinterfaces.UiCustomization r5) {
        /*
            r4 = this;
            int r0 = f3022E
            r1 = r0 & 53
            int r2 = ~r1
            r0 = r0 | 53
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r0 = r0 + r1
            int r1 = r0 % 128
            f3021D = r1
            int r0 = r0 % 2
            com.cardinalcommerce.a.setHyphenationFrequency r0 = r4.f3035j
            r1 = 0
            if (r0 == 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            if (r0 == 0) goto L_0x0089
            int r0 = f3021D
            int r0 = r0 + 75
            int r3 = r0 % 128
            f3022E = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x0029:
            r0 = 1
        L_0x002a:
            if (r0 == 0) goto L_0x003a
            com.cardinalcommerce.shared.models.enums.ButtonType r0 = com.cardinalcommerce.shared.models.enums.ButtonType.RESEND
            com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r0 = r5.getButtonCustomization((com.cardinalcommerce.shared.models.enums.ButtonType) r0)
            if (r0 != 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 == r2) goto L_0x004a
            goto L_0x006d
        L_0x003a:
            com.cardinalcommerce.shared.models.enums.ButtonType r0 = com.cardinalcommerce.shared.models.enums.ButtonType.RESEND
            com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r0 = r5.getButtonCustomization((com.cardinalcommerce.shared.models.enums.ButtonType) r0)
            r3 = 63
            int r3 = r3 / r1
            if (r0 != 0) goto L_0x0047
            r0 = 1
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            if (r0 == 0) goto L_0x006d
        L_0x004a:
            com.cardinalcommerce.a.setHyphenationFrequency r5 = r4.f3035j
            android.content.res.Resources r0 = r4.getResources()
            r1 = 2131099784(0x7f060088, float:1.781193E38)
            int r0 = r0.getColor(r1)
            r5.setTextColor(r0)
            int r5 = f3021D
            r0 = r5 | 35
            int r0 = r0 << r2
            r1 = r5 & -36
            int r5 = ~r5
            r5 = r5 & 35
            r5 = r5 | r1
            int r0 = r0 - r5
            int r5 = r0 % 128
            f3022E = r5
            int r0 = r0 % 2
            return
        L_0x006d:
            com.cardinalcommerce.a.setHyphenationFrequency r0 = r4.f3035j
            com.cardinalcommerce.shared.models.enums.ButtonType r3 = com.cardinalcommerce.shared.models.enums.ButtonType.RESEND
            com.cardinalcommerce.shared.userinterfaces.ButtonCustomization r5 = r5.getButtonCustomization((com.cardinalcommerce.shared.models.enums.ButtonType) r3)
            com.cardinalcommerce.p060a.setPaintFlags.cca_continue((com.cardinalcommerce.p060a.setHyphenationFrequency) r0, (com.cardinalcommerce.shared.userinterfaces.ButtonCustomization) r5, (android.app.Activity) r4)
            int r5 = f3022E
            r0 = r5 ^ 69
            r5 = r5 & 69
            int r5 = r5 << r2
            int r0 = r0 + r5
            int r5 = r0 % 128
            f3021D = r5
            int r0 = r0 % 2
            goto L_0x0089
        L_0x0087:
            r5 = move-exception
            throw r5
        L_0x0089:
            int r5 = f3021D
            r0 = r5 | 113(0x71, float:1.58E-43)
            int r0 = r0 << r2
            r5 = r5 ^ 113(0x71, float:1.58E-43)
            int r0 = r0 - r5
            int r5 = r0 % 128
            f3022E = r5
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r2 = 0
        L_0x009b:
            if (r2 == 0) goto L_0x00a2
            r5 = 0
            int r5 = r5.length     // Catch:{ all -> 0x00a0 }
            return
        L_0x00a0:
            r5 = move-exception
            throw r5
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.m2124a(com.cardinalcommerce.shared.userinterfaces.UiCustomization):void");
    }

    /* renamed from: a */
    private void m2125a(UiCustomization uiCustomization, boolean z) {
        int i = f3021D;
        int i2 = i & 113;
        int i3 = (i | 113) & (~i2);
        int i4 = i2 << 1;
        int i5 = (i3 & i4) + (i3 | i4);
        f3022E = i5 % 128;
        int i6 = i5 % 2;
        if ((uiCustomization.getButtonCustomization(ButtonType.VERIFY) == null ? '-' : '4') != '-') {
            setPaintFlags.cca_continue(this.f3034i, uiCustomization.getButtonCustomization(ButtonType.VERIFY), (Activity) this);
            int i7 = f3022E + 25;
            f3021D = i7 % 128;
            int i8 = i7 % 2;
            return;
        }
        int i9 = f3022E + 21;
        f3021D = i9 % 128;
        int i10 = i9 % 2;
        if ((this.f3049x != null ? 'W' : '!') != '!') {
            int i11 = f3021D;
            int i12 = i11 & 19;
            int i13 = -(-(i11 | 19));
            int i14 = (i12 & i13) + (i13 | i12);
            f3022E = i14 % 128;
            int i15 = i14 % 2;
            if ((!z ? VersionRange.LEFT_CLOSED : 'K') == '[') {
                int i16 = f3022E + 26;
                int i17 = ((i16 | -1) << 1) - (i16 ^ -1);
                f3021D = i17 % 128;
                int i18 = i17 % 2;
                if ((m2133c() ? IOUtils.DIR_SEPARATOR_WINDOWS : 4) == '\\') {
                    int i19 = f3021D;
                    int i20 = ((i19 | 69) << 1) - (i19 ^ 69);
                    f3022E = i20 % 128;
                    if (!(i20 % 2 != 0)) {
                        this.f3034i.setBackgroundColor(-7829368);
                        Object obj = null;
                        super.hashCode();
                    } else {
                        this.f3034i.setBackgroundColor(-7829368);
                    }
                    int i21 = f3021D;
                    int i22 = (i21 & 3) + (i21 | 3);
                    f3022E = i22 % 128;
                    int i23 = i22 % 2;
                    this.f3034i.setTextColor(getResources().getColor(R.color.colorWhite));
                    int i24 = f3021D;
                    int i25 = i24 & 45;
                    int i26 = (i24 ^ 45) | i25;
                    int i27 = (i25 & i26) + (i26 | i25);
                    f3022E = i27 % 128;
                    int i28 = i27 % 2;
                }
            }
        }
        this.f3034i.setBackgroundColor(getResources().getColor(R.color.blue));
        int i29 = f3021D;
        int i30 = i29 & 93;
        int i31 = (i30 - (~(-(-((i29 ^ 93) | i30))))) - 1;
        f3022E = i31 % 128;
        int i32 = i31 % 2;
        this.f3034i.setTextColor(getResources().getColor(R.color.colorWhite));
        int i242 = f3021D;
        int i252 = i242 & 45;
        int i262 = (i242 ^ 45) | i252;
        int i272 = (i252 & i262) + (i262 | i252);
        f3022E = i272 % 128;
        int i282 = i272 % 2;
    }

    public final void configure(final setBaselineAligned setbaselinealigned) {
        runOnUiThread(new Runnable() {
            private static int cca_continue = 1;
            private static int configure;

            public final void run() {
                int i = configure;
                int i2 = i & 95;
                int i3 = ((i ^ 95) | i2) << 1;
                int i4 = -((i | 95) & (~i2));
                int i5 = (i3 & i4) + (i4 | i3);
                cca_continue = i5 % 128;
                int i6 = i5 % 2;
                setTextLocales.m2122a(setTextLocales.this, setbaselinealigned);
                setTextLocales.m2148r(setTextLocales.this);
                int i7 = cca_continue;
                int i8 = (i7 & 109) + (i7 | 109);
                configure = i8 % 128;
                int i9 = i8 % 2;
            }
        });
        int i = f3022E;
        int i2 = i ^ 35;
        int i3 = -(-((i & 35) << 1));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f3021D = i4 % 128;
        if (!(i4 % 2 == 0)) {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void Cardinal() {
        setTextMetricsParams sDKVersion = setTextMetricsParams.getSDKVersion();
        StringBuilder sb = new StringBuilder("Activity closed: ");
        sb.append(this.f3023A);
        sDKVersion.init("Native Challenge Screen", sb.toString(), (String) null);
        runOnUiThread(new Runnable() {
            private static int Cardinal = 0;
            private static int cca_continue = 1;

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
                if ((com.cardinalcommerce.p060a.setTextLocales.m2145o(r6.init) != null) != false) goto L_0x0047;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
                if ((com.cardinalcommerce.p060a.setTextLocales.m2145o(r6.init) != null ? 'M' : 'V') != 'V') goto L_0x0047;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    int r0 = cca_continue
                    r1 = r0 & 17
                    int r2 = ~r1
                    r0 = r0 | 17
                    r0 = r0 & r2
                    r2 = 1
                    int r1 = r1 << r2
                    r3 = r0 | r1
                    int r3 = r3 << r2
                    r0 = r0 ^ r1
                    int r3 = r3 - r0
                    int r0 = r3 % 128
                    Cardinal = r0
                    int r3 = r3 % 2
                    r0 = 99
                    if (r3 == 0) goto L_0x001c
                    r1 = 27
                    goto L_0x001e
                L_0x001c:
                    r1 = 99
                L_0x001e:
                    r3 = 77
                    r4 = 0
                    if (r1 == r0) goto L_0x0036
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r1 = 46
                    int r1 = r1 / r4
                    if (r0 == 0) goto L_0x0030
                    r0 = 1
                    goto L_0x0031
                L_0x0030:
                    r0 = 0
                L_0x0031:
                    if (r0 == 0) goto L_0x00af
                    goto L_0x0047
                L_0x0034:
                    r0 = move-exception
                    throw r0
                L_0x0036:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r1 = 86
                    if (r0 == 0) goto L_0x0043
                    r0 = 77
                    goto L_0x0045
                L_0x0043:
                    r0 = 86
                L_0x0045:
                    if (r0 == r1) goto L_0x00af
                L_0x0047:
                    int r0 = cca_continue
                    r1 = r0 ^ 115(0x73, float:1.61E-43)
                    r5 = r0 & 115(0x73, float:1.61E-43)
                    r1 = r1 | r5
                    int r1 = r1 << r2
                    r5 = r0 & -116(0xffffffffffffff8c, float:NaN)
                    int r0 = ~r0
                    r0 = r0 & 115(0x73, float:1.61E-43)
                    r0 = r0 | r5
                    int r0 = -r0
                    int r0 = ~r0
                    int r1 = r1 - r0
                    int r1 = r1 - r2
                    int r0 = r1 % 128
                    Cardinal = r0
                    int r1 = r1 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    r1 = 52
                    if (r0 == 0) goto L_0x006c
                    r0 = 52
                    goto L_0x006e
                L_0x006c:
                    r0 = 91
                L_0x006e:
                    if (r0 == r1) goto L_0x0071
                    goto L_0x00af
                L_0x0071:
                    int r0 = Cardinal
                    r1 = r0 ^ 87
                    r5 = r0 & 87
                    r1 = r1 | r5
                    int r1 = r1 << r2
                    r5 = r0 & -88
                    int r0 = ~r0
                    r0 = r0 & 87
                    r0 = r0 | r5
                    int r1 = r1 - r0
                    int r0 = r1 % 128
                    cca_continue = r0
                    int r1 = r1 % 2
                    r0 = 97
                    if (r1 != 0) goto L_0x008d
                    r1 = 97
                    goto L_0x008f
                L_0x008d:
                    r1 = 74
                L_0x008f:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r0.setEnabled(r2)
                    int r0 = cca_continue
                    r1 = r0 ^ 77
                    r5 = r0 & 77
                    r1 = r1 | r5
                    int r1 = r1 << r2
                    int r5 = ~r5
                    r0 = r0 | r3
                    r0 = r0 & r5
                    int r0 = -r0
                    r3 = r1 ^ r0
                    r0 = r0 & r1
                    int r0 = r0 << r2
                    int r3 = r3 + r0
                    int r0 = r3 % 128
                    Cardinal = r0
                    int r3 = r3 % 2
                L_0x00af:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    java.lang.String r0 = com.cardinalcommerce.p060a.setTextLocales.m2132c(r0)
                    java.lang.String r1 = "01"
                    boolean r0 = r0.equals(r1)
                    r1 = 63
                    if (r0 == 0) goto L_0x00c2
                    r0 = 12
                    goto L_0x00c4
                L_0x00c2:
                    r0 = 63
                L_0x00c4:
                    if (r0 == r1) goto L_0x00f2
                    int r0 = Cardinal
                    r1 = r0 & 67
                    int r3 = ~r1
                    r0 = r0 | 67
                    r0 = r0 & r3
                    int r1 = r1 << r2
                    int r1 = -r1
                    int r1 = -r1
                    r3 = r0 | r1
                    int r3 = r3 << r2
                    r0 = r0 ^ r1
                    int r3 = r3 - r0
                    int r0 = r3 % 128
                    cca_continue = r0
                    int r3 = r3 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setLetterSpacing r0 = com.cardinalcommerce.p060a.setTextLocales.m2117a((com.cardinalcommerce.p060a.setTextLocales) r0)
                    r0.setFocusable(r2)
                    int r0 = Cardinal
                    r1 = r0 & 45
                    r0 = r0 | 45
                    int r1 = r1 + r0
                    int r0 = r1 % 128
                    cca_continue = r0
                    int r1 = r1 % 2
                L_0x00f2:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.widget.ProgressBar r0 = com.cardinalcommerce.p060a.setTextLocales.m2147q(r0)
                    r1 = 8
                    r0.setVisibility(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.view.Window r0 = r0.getWindow()
                    r1 = 16
                    r0.clearFlags(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2139i(r0)
                    r0.setEnabled(r2)
                    int r0 = Cardinal
                    r1 = r0 & 14
                    r0 = r0 | 14
                    int r1 = r1 + r0
                    int r1 = r1 - r4
                    int r1 = r1 - r2
                    int r0 = r1 % 128
                    cca_continue = r0
                    int r1 = r1 % 2
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.C209414.run():void");
            }
        });
        finishAndRemoveTask();
        int i = f3022E;
        int i2 = ((i ^ 91) - (~((i & 91) << 1))) - 1;
        f3021D = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if ((!r0) != true) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if ((r6.f3023A.equals("01")) != true) goto L_0x0096;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2127a() {
        /*
            r6 = this;
            int r0 = f3022E
            r1 = r0 ^ 69
            r2 = r0 & 69
            r1 = r1 | r2
            r3 = 1
            int r1 = r1 << r3
            int r2 = ~r2
            r0 = r0 | 69
            r0 = r0 & r2
            int r0 = -r0
            r2 = r1 ^ r0
            r0 = r0 & r1
            int r0 = r0 << r3
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3021D = r0
            int r2 = r2 % 2
            r0 = 47
            if (r2 == 0) goto L_0x0020
            r1 = 48
            goto L_0x0022
        L_0x0020:
            r1 = 47
        L_0x0022:
            r2 = 0
            java.lang.String r4 = "01"
            r5 = 0
            if (r1 == r0) goto L_0x003b
            java.lang.String r0 = r6.f3023A
            boolean r0 = r0.equals(r4)
            super.hashCode()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0035
            r0 = 0
            goto L_0x0036
        L_0x0035:
            r0 = 1
        L_0x0036:
            if (r0 == r3) goto L_0x0096
            goto L_0x0049
        L_0x0039:
            r0 = move-exception
            throw r0
        L_0x003b:
            java.lang.String r0 = r6.f3023A
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0045
            r0 = 1
            goto L_0x0046
        L_0x0045:
            r0 = 0
        L_0x0046:
            if (r0 == r3) goto L_0x0049
            goto L_0x0096
        L_0x0049:
            com.cardinalcommerce.a.setBaselineAligned r0 = r6.f3044s
            java.lang.String r0 = r0.getActionCode
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0057
            r0 = 1
            goto L_0x0058
        L_0x0057:
            r0 = 0
        L_0x0058:
            if (r0 == 0) goto L_0x0096
            int r0 = f3021D
            r1 = r0 & 15
            r0 = r0 | 15
            int r0 = -r0
            int r0 = -r0
            r2 = r1 | r0
            int r2 = r2 << r3
            r0 = r0 ^ r1
            int r2 = r2 - r0
            int r0 = r2 % 128
            f3022E = r0
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x0071
            r0 = 1
            goto L_0x0072
        L_0x0071:
            r0 = 0
        L_0x0072:
            if (r0 == r3) goto L_0x0076
            r0 = 1
            goto L_0x0077
        L_0x0076:
            r0 = 0
        L_0x0077:
            int r1 = f3022E
            r2 = r1 & 1
            r1 = r1 ^ r3
            r1 = r1 | r2
            r4 = r2 | r1
            int r4 = r4 << r3
            r1 = r1 ^ r2
            int r4 = r4 - r1
            int r1 = r4 % 128
            f3021D = r1
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x008c
            r1 = 1
            goto L_0x008d
        L_0x008c:
            r1 = 0
        L_0x008d:
            if (r1 == r3) goto L_0x0090
            return r0
        L_0x0090:
            r1 = 39
            int r1 = r1 / r5
            return r0
        L_0x0094:
            r0 = move-exception
            throw r0
        L_0x0096:
            int r0 = f3021D
            r1 = r0 & 13
            int r4 = ~r1
            r0 = r0 | 13
            r0 = r0 & r4
            int r1 = r1 << r3
            int r1 = -r1
            int r1 = -r1
            r4 = r0 ^ r1
            r0 = r0 & r1
            int r0 = r0 << r3
            int r4 = r4 + r0
            int r0 = r4 % 128
            f3022E = r0
            int r4 = r4 % 2
            r0 = 77
            if (r4 != 0) goto L_0x00b3
            r1 = 19
            goto L_0x00b5
        L_0x00b3:
            r1 = 77
        L_0x00b5:
            if (r1 == r0) goto L_0x00bd
            super.hashCode()     // Catch:{ all -> 0x00bb }
            return r5
        L_0x00bb:
            r0 = move-exception
            throw r0
        L_0x00bd:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.m2127a():boolean");
    }

    /* renamed from: b */
    private boolean m2131b() {
        boolean z;
        int i = f3021D;
        int i2 = ((i | 94) << 1) - (i ^ 94);
        boolean z2 = false;
        int i3 = (i2 - 0) - 1;
        f3022E = i3 % 128;
        Object obj = null;
        if (!(i3 % 2 != 0)) {
            z = this.f3044s.CardinalConfigurationParameters.equalsIgnoreCase("2.2.0");
            super.hashCode();
        } else {
            z = this.f3044s.CardinalConfigurationParameters.equalsIgnoreCase("2.2.0");
        }
        int i4 = f3022E;
        int i5 = ((i4 & 78) + (i4 | 78)) - 1;
        f3021D = i5 % 128;
        if (i5 % 2 != 0) {
            z2 = true;
        }
        if (!z2) {
            return z;
        }
        super.hashCode();
        return z;
    }

    /* renamed from: c */
    private boolean m2133c() {
        int i = f3022E;
        int i2 = (i & 103) + (i | 103);
        f3021D = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return this.f3044s.CardinalConfigurationParameters.equalsIgnoreCase("2.1.0");
        }
        int i3 = 1 / 0;
        return this.f3044s.CardinalConfigurationParameters.equalsIgnoreCase("2.1.0");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c5, code lost:
        if ((!m2131b() ? 21 : '+') != 21) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d4, code lost:
        if ((!m2131b()) != false) goto L_0x00d6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r9 = this;
            int r0 = f3021D
            r1 = r0 & -60
            int r2 = ~r0
            r3 = 59
            r2 = r2 & r3
            r1 = r1 | r2
            r0 = r0 & r3
            r2 = 1
            int r0 = r0 << r2
            int r0 = -r0
            int r0 = -r0
            r4 = r1 & r0
            r0 = r0 | r1
            int r4 = r4 + r0
            int r0 = r4 % 128
            f3022E = r0
            int r4 = r4 % 2
            com.cardinalcommerce.a.setTextMetricsParams r0 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()
            java.lang.String r1 = "Native Challenge Screen"
            java.lang.String r4 = "Challenge Screen back to foreground"
            r5 = 0
            r0.init(r1, r4, r5)
            boolean r0 = r9.f3051z
            r4 = 83
            r6 = 43
            if (r0 == 0) goto L_0x002f
            r0 = 83
            goto L_0x0031
        L_0x002f:
            r0 = 43
        L_0x0031:
            r7 = 0
            if (r0 == r4) goto L_0x0036
            goto L_0x015d
        L_0x0036:
            int r0 = f3022E
            r4 = r0 & 59
            r0 = r0 ^ r3
            r0 = r0 | r4
            r3 = r4 & r0
            r0 = r0 | r4
            int r3 = r3 + r0
            int r0 = r3 % 128
            f3021D = r0
            int r3 = r3 % 2
            java.lang.String r0 = r9.f3023A
            java.lang.String r3 = "04"
            boolean r0 = r0.equals(r3)
            r3 = 27
            if (r0 == 0) goto L_0x0055
            r0 = 31
            goto L_0x0057
        L_0x0055:
            r0 = 27
        L_0x0057:
            if (r0 == r3) goto L_0x015d
            int r0 = f3021D
            r3 = r0 & 67
            int r4 = ~r3
            r0 = r0 | 67
            r0 = r0 & r4
            int r3 = r3 << r2
            r4 = r0 | r3
            int r4 = r4 << r2
            r0 = r0 ^ r3
            int r4 = r4 - r0
            int r0 = r4 % 128
            f3022E = r0
            int r4 = r4 % 2
            com.cardinalcommerce.a.setBaselineAligned r0 = r9.f3044s
            java.lang.String r0 = r0.getInstance
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0079
            r0 = 1
            goto L_0x007a
        L_0x0079:
            r0 = 0
        L_0x007a:
            if (r0 == r2) goto L_0x007e
            goto L_0x00f1
        L_0x007e:
            int r0 = f3021D
            r3 = r0 & 13
            r0 = r0 ^ 13
            r0 = r0 | r3
            int r3 = r3 + r0
            int r0 = r3 % 128
            f3022E = r0
            int r3 = r3 % 2
            com.cardinalcommerce.a.setBaselineAligned r0 = r9.f3044s
            java.lang.String r0 = r0.getInstance
            if (r0 == 0) goto L_0x0094
            r0 = 1
            goto L_0x0095
        L_0x0094:
            r0 = 0
        L_0x0095:
            if (r0 == 0) goto L_0x00f1
            int r0 = f3022E
            r3 = 37
            r4 = r0 ^ 37
            r8 = r0 & 37
            r4 = r4 | r8
            int r4 = r4 << r2
            r8 = r0 & -38
            int r0 = ~r0
            r0 = r0 & r3
            r0 = r0 | r8
            int r0 = -r0
            r3 = r4 & r0
            r0 = r0 | r4
            int r3 = r3 + r0
            int r0 = r3 % 128
            f3021D = r0
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x00b5
            r0 = 1
            goto L_0x00b6
        L_0x00b5:
            r0 = 0
        L_0x00b6:
            if (r0 == r2) goto L_0x00c8
            boolean r0 = r9.m2131b()
            r3 = 21
            if (r0 != 0) goto L_0x00c3
            r0 = 21
            goto L_0x00c5
        L_0x00c3:
            r0 = 43
        L_0x00c5:
            if (r0 == r3) goto L_0x00d6
            goto L_0x00f1
        L_0x00c8:
            boolean r0 = r9.m2131b()
            r3 = 95
            int r3 = r3 / r7
            if (r0 != 0) goto L_0x00d3
            r0 = 1
            goto L_0x00d4
        L_0x00d3:
            r0 = 0
        L_0x00d4:
            if (r0 == 0) goto L_0x00f1
        L_0x00d6:
            com.cardinalcommerce.a.setShowSoftInputOnFocus r0 = r9.f3031f
            com.cardinalcommerce.a.setBaselineAligned r3 = r9.f3044s
            java.lang.String r3 = r3.getInstance
            r0.setCCAText(r3)
            int r0 = f3022E
            r3 = r0 & 95
            r0 = r0 | 95
            int r0 = ~r0
            int r3 = r3 - r0
            int r3 = r3 - r2
            int r0 = r3 % 128
            f3021D = r0
            int r3 = r3 % 2
            goto L_0x00f1
        L_0x00ef:
            r0 = move-exception
            throw r0
        L_0x00f1:
            com.cardinalcommerce.a.setBaselineAligned r0 = r9.f3044s
            java.lang.String r0 = r0.CardinalError
            if (r0 == 0) goto L_0x00f9
            r0 = 1
            goto L_0x00fa
        L_0x00f9:
            r0 = 0
        L_0x00fa:
            if (r0 == 0) goto L_0x011e
            int r0 = f3021D
            int r0 = r0 + 5
            int r3 = r0 % 128
            f3022E = r3
            int r0 = r0 % 2
            r3 = 62
            if (r0 != 0) goto L_0x010d
            r0 = 57
            goto L_0x010f
        L_0x010d:
            r0 = 62
        L_0x010f:
            if (r0 == r3) goto L_0x0119
            com.cardinalcommerce.a.setFallbackLineSpacing r0 = r9.f3029d
            r3 = 52
        L_0x0115:
            r0.setVisibility(r3)
            goto L_0x011e
        L_0x0119:
            com.cardinalcommerce.a.setFallbackLineSpacing r0 = r9.f3029d
            r3 = 8
            goto L_0x0115
        L_0x011e:
            boolean r0 = r9.m2133c()
            if (r0 != 0) goto L_0x0126
            r0 = 1
            goto L_0x0127
        L_0x0126:
            r0 = 0
        L_0x0127:
            if (r0 == 0) goto L_0x015d
            int r0 = f3022E
            r3 = r0 & 69
            r0 = r0 ^ 69
            r0 = r0 | r3
            r4 = r3 ^ r0
            r0 = r0 & r3
            int r0 = r0 << r2
            int r4 = r4 + r0
            int r0 = r4 % 128
            f3021D = r0
            int r4 = r4 % 2
            com.cardinalcommerce.a.setHyphenationFrequency r0 = r9.f3034i
            r0.performClick()
            com.cardinalcommerce.a.setTextMetricsParams r0 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()
            java.lang.String r3 = "OOB Continue pressed by SDK"
            r0.init(r1, r3, r5)
            int r0 = f3021D
            r1 = r0 & 91
            int r3 = ~r1
            r0 = r0 | 91
            r0 = r0 & r3
            int r1 = r1 << r2
            r3 = r0 ^ r1
            r0 = r0 & r1
            int r0 = r0 << r2
            int r3 = r3 + r0
            int r0 = r3 % 128
            f3022E = r0
            int r3 = r3 % 2
        L_0x015d:
            super.onResume()
            int r0 = f3021D
            r1 = r0 & 43
            r0 = r0 ^ r6
            r0 = r0 | r1
            r3 = r1 | r0
            int r3 = r3 << r2
            r0 = r0 ^ r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f3022E = r0
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0174
            goto L_0x0175
        L_0x0174:
            r2 = 0
        L_0x0175:
            if (r2 == 0) goto L_0x017d
            super.hashCode()     // Catch:{ all -> 0x017b }
            return
        L_0x017b:
            r0 = move-exception
            throw r0
        L_0x017d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.onResume():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        if ((r2.init == 0) != true) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        if ((r2.init != 1) != false) goto L_0x0105;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.String m2140j(com.cardinalcommerce.p060a.setTextLocales r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.List<com.cardinalcommerce.a.setElegantTextHeight> r1 = r8.f3050y
            java.util.Iterator r1 = r1.iterator()
            int r2 = f3022E
            r3 = r2 & -82
            int r4 = ~r2
            r4 = r4 & 81
            r3 = r3 | r4
            r2 = r2 & 81
            r4 = 1
            int r2 = r2 << r4
            r5 = r3 & r2
            r2 = r2 | r3
            int r5 = r5 + r2
            int r2 = r5 % 128
            f3021D = r2
            int r5 = r5 % 2
        L_0x0021:
            boolean r2 = r1.hasNext()
            r3 = 59
            if (r2 == 0) goto L_0x002c
            r2 = 50
            goto L_0x002e
        L_0x002c:
            r2 = 59
        L_0x002e:
            if (r2 == r3) goto L_0x0116
            int r2 = f3021D
            r5 = 15
            r6 = r2 & -16
            int r7 = ~r2
            r7 = r7 & r5
            r6 = r6 | r7
            r2 = r2 & r5
            int r2 = r2 << r4
            int r6 = r6 + r2
            int r2 = r6 % 128
            f3022E = r2
            int r6 = r6 % 2
            r2 = 89
            if (r6 != 0) goto L_0x0049
            r5 = 67
            goto L_0x004b
        L_0x0049:
            r5 = 89
        L_0x004b:
            r6 = 0
            if (r5 == r2) goto L_0x005f
            java.lang.Object r2 = r1.next()
            com.cardinalcommerce.a.setElegantTextHeight r2 = (com.cardinalcommerce.p060a.setElegantTextHeight) r2
            int r5 = r2.init
            if (r5 != 0) goto L_0x005a
            r5 = 1
            goto L_0x005b
        L_0x005a:
            r5 = 0
        L_0x005b:
            if (r5 == r4) goto L_0x0070
            goto L_0x0105
        L_0x005f:
            java.lang.Object r2 = r1.next()
            com.cardinalcommerce.a.setElegantTextHeight r2 = (com.cardinalcommerce.p060a.setElegantTextHeight) r2
            int r5 = r2.init
            if (r5 != r4) goto L_0x006b
            r5 = 0
            goto L_0x006c
        L_0x006b:
            r5 = 1
        L_0x006c:
            if (r5 == 0) goto L_0x0070
            goto L_0x0105
        L_0x0070:
            java.lang.String r5 = r0.toString()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x007c
            r5 = 0
            goto L_0x007d
        L_0x007c:
            r5 = 1
        L_0x007d:
            if (r5 == r4) goto L_0x00e2
            int r3 = f3022E
            r5 = r3 ^ 103(0x67, float:1.44E-43)
            r6 = r3 & 103(0x67, float:1.44E-43)
            r5 = r5 | r6
            int r5 = r5 << r4
            int r6 = ~r6
            r3 = r3 | 103(0x67, float:1.44E-43)
            r3 = r3 & r6
            int r3 = -r3
            r6 = r5 ^ r3
            r3 = r3 & r5
            int r3 = r3 << r4
            int r6 = r6 + r3
            int r3 = r6 % 128
            f3021D = r3
            int r6 = r6 % 2
            r3 = 29
            if (r6 == 0) goto L_0x009e
            r5 = 29
            goto L_0x00a0
        L_0x009e:
            r5 = 68
        L_0x00a0:
            java.lang.String r6 = ","
            r0.append(r6)
            if (r5 == r3) goto L_0x00b9
            java.util.ArrayList<com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds> r3 = r8.f3047v
            int r2 = r2.init()
            java.lang.Object r2 = r3.get(r2)
            com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds r2 = (com.cardinalcommerce.p060a.setCompoundDrawablesRelativeWithIntrinsicBounds) r2
            java.lang.String r2 = r2.Cardinal
            r0.append(r2)
            goto L_0x00ce
        L_0x00b9:
            java.util.ArrayList<com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds> r3 = r8.f3047v
            int r2 = r2.init()
            java.lang.Object r2 = r3.get(r2)
            com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds r2 = (com.cardinalcommerce.p060a.setCompoundDrawablesRelativeWithIntrinsicBounds) r2
            java.lang.String r2 = r2.Cardinal
            r0.append(r2)
            r2 = 0
            super.hashCode()     // Catch:{ all -> 0x00e0 }
        L_0x00ce:
            int r2 = f3021D
            r3 = r2 & 113(0x71, float:1.58E-43)
            r2 = r2 | 113(0x71, float:1.58E-43)
            r5 = r3 & r2
            r2 = r2 | r3
            int r5 = r5 + r2
            int r2 = r5 % 128
            f3022E = r2
        L_0x00dc:
            int r5 = r5 % 2
            goto L_0x0021
        L_0x00e0:
            r8 = move-exception
            throw r8
        L_0x00e2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.util.ArrayList<com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds> r5 = r8.f3047v
            int r2 = r2.init()
            java.lang.Object r2 = r5.get(r2)
            com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds r2 = (com.cardinalcommerce.p060a.setCompoundDrawablesRelativeWithIntrinsicBounds) r2
            java.lang.String r2 = r2.Cardinal
            r0.<init>(r2)
            int r2 = f3022E
            r5 = r2 ^ 16
            r2 = r2 & 16
            int r2 = r2 << r4
            int r5 = r5 + r2
            int r5 = r5 - r6
            int r5 = r5 - r4
            int r2 = r5 % 128
            f3021D = r2
            int r5 = r5 % 2
        L_0x0105:
            int r2 = f3022E
            r5 = r2 ^ 59
            r6 = r2 & 59
            r5 = r5 | r6
            int r5 = r5 << r4
            int r6 = ~r6
            r2 = r2 | r3
            r2 = r2 & r6
            int r5 = r5 - r2
            int r2 = r5 % 128
            f3021D = r2
            goto L_0x00dc
        L_0x0116:
            java.lang.String r8 = r0.toString()
            int r0 = f3021D
            int r0 = r0 + 68
            r1 = r0 ^ -1
            r0 = r0 & -1
            int r0 = r0 << r4
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3022E = r0
            int r1 = r1 % 2
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.m2140j(com.cardinalcommerce.a.setTextLocales):java.lang.String");
    }

    /* renamed from: b */
    static /* synthetic */ void m2129b(setTextLocales settextlocales, setTypeface settypeface) {
        settextlocales.runOnUiThread(new Runnable() {
            private static int cca_continue = 0;
            private static int configure = 1;

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    int r0 = cca_continue
                    r1 = r0 & 103(0x67, float:1.44E-43)
                    r0 = r0 | 103(0x67, float:1.44E-43)
                    r2 = r1 | r0
                    r3 = 1
                    int r2 = r2 << r3
                    r0 = r0 ^ r1
                    int r2 = r2 - r0
                    int r0 = r2 % 128
                    configure = r0
                    int r2 = r2 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r1 = 0
                    if (r0 == 0) goto L_0x001d
                    r0 = 1
                    goto L_0x001e
                L_0x001d:
                    r0 = 0
                L_0x001e:
                    if (r0 == r3) goto L_0x0021
                    goto L_0x0083
                L_0x0021:
                    int r0 = configure
                    r2 = r0 & 117(0x75, float:1.64E-43)
                    r0 = r0 ^ 117(0x75, float:1.64E-43)
                    r0 = r0 | r2
                    int r0 = -r0
                    int r0 = -r0
                    int r0 = ~r0
                    int r2 = r2 - r0
                    int r2 = r2 - r3
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                    r0 = 67
                    if (r2 == 0) goto L_0x003a
                    r2 = 39
                    goto L_0x003c
                L_0x003a:
                    r2 = 67
                L_0x003c:
                    if (r2 == r0) goto L_0x0053
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    r2 = 84
                    int r2 = r2 / r1
                    r2 = 4
                    if (r0 == 0) goto L_0x004c
                    r0 = 4
                    goto L_0x004e
                L_0x004c:
                    r0 = 65
                L_0x004e:
                    if (r0 == r2) goto L_0x0060
                    goto L_0x0083
                L_0x0051:
                    r0 = move-exception
                    throw r0
                L_0x0053:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    if (r0 == 0) goto L_0x005d
                    r0 = 0
                    goto L_0x005e
                L_0x005d:
                    r0 = 1
                L_0x005e:
                    if (r0 == r3) goto L_0x0083
                L_0x0060:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r0.setEnabled(r1)
                    int r0 = configure
                    r2 = 125(0x7d, float:1.75E-43)
                    r4 = r0 ^ 125(0x7d, float:1.75E-43)
                    r5 = r0 & 125(0x7d, float:1.75E-43)
                    r4 = r4 | r5
                    int r4 = r4 << r3
                    r5 = r0 & -126(0xffffffffffffff82, float:NaN)
                    int r0 = ~r0
                    r0 = r0 & r2
                    r0 = r0 | r5
                    int r0 = -r0
                    r2 = r4 & r0
                    r0 = r0 | r4
                    int r2 = r2 + r0
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                L_0x0083:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    java.lang.String r0 = com.cardinalcommerce.p060a.setTextLocales.m2132c(r0)
                    java.lang.String r2 = "01"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x0093
                    r0 = 0
                    goto L_0x0094
                L_0x0093:
                    r0 = 1
                L_0x0094:
                    if (r0 == r3) goto L_0x00bd
                    int r0 = configure
                    r2 = r0 ^ 47
                    r0 = r0 & 47
                    int r0 = r0 << r3
                    r4 = r2 | r0
                    int r4 = r4 << r3
                    r0 = r0 ^ r2
                    int r4 = r4 - r0
                    int r0 = r4 % 128
                    cca_continue = r0
                    int r4 = r4 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setLetterSpacing r0 = com.cardinalcommerce.p060a.setTextLocales.m2117a((com.cardinalcommerce.p060a.setTextLocales) r0)
                    r0.setFocusable(r1)
                    int r0 = cca_continue
                    int r0 = r0 + 101
                    int r0 = r0 - r3
                    int r0 = r0 - r3
                    int r2 = r0 % 128
                    configure = r2
                    int r0 = r0 % 2
                L_0x00bd:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2139i(r0)
                    r0.setEnabled(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.widget.ProgressBar r0 = com.cardinalcommerce.p060a.setTextLocales.m2147q(r0)
                    r0.setVisibility(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.view.Window r0 = r0.getWindow()
                    r2 = 16
                    r0.setFlags(r2, r2)
                    int r0 = configure
                    r2 = r0 & 11
                    r0 = r0 ^ 11
                    r0 = r0 | r2
                    int r2 = r2 + r0
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                    if (r2 == 0) goto L_0x00eb
                    r1 = 1
                L_0x00eb:
                    if (r1 == r3) goto L_0x00ee
                    return
                L_0x00ee:
                    r0 = 0
                    int r0 = r0.length     // Catch:{ all -> 0x00f1 }
                    return
                L_0x00f1:
                    r0 = move-exception
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.C209515.run():void");
            }
        });
        setTextSelectHandle.cca_continue(settextlocales.getApplicationContext()).cca_continue(settypeface, settextlocales, settextlocales.f3023A);
        int i = f3021D;
        int i2 = ((i & 24) + (i | 24)) - 1;
        f3022E = i2 % 128;
        int i3 = i2 % 2;
    }

    /* renamed from: n */
    static /* synthetic */ void m2144n(setTextLocales settextlocales) {
        setCompoundDrawablesWithIntrinsicBounds setcompounddrawableswithintrinsicbounds = new setCompoundDrawablesWithIntrinsicBounds();
        setcompounddrawableswithintrinsicbounds.getInstance = setHeight.getWarnings;
        setTypeface settypeface = new setTypeface(settextlocales.f3044s, setcompounddrawableswithintrinsicbounds);
        settextlocales.f3043r = settypeface;
        settextlocales.runOnUiThread(new Runnable() {
            private static int cca_continue = 0;
            private static int configure = 1;

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    int r0 = cca_continue
                    r1 = r0 & 103(0x67, float:1.44E-43)
                    r0 = r0 | 103(0x67, float:1.44E-43)
                    r2 = r1 | r0
                    r3 = 1
                    int r2 = r2 << r3
                    r0 = r0 ^ r1
                    int r2 = r2 - r0
                    int r0 = r2 % 128
                    configure = r0
                    int r2 = r2 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r1 = 0
                    if (r0 == 0) goto L_0x001d
                    r0 = 1
                    goto L_0x001e
                L_0x001d:
                    r0 = 0
                L_0x001e:
                    if (r0 == r3) goto L_0x0021
                    goto L_0x0083
                L_0x0021:
                    int r0 = configure
                    r2 = r0 & 117(0x75, float:1.64E-43)
                    r0 = r0 ^ 117(0x75, float:1.64E-43)
                    r0 = r0 | r2
                    int r0 = -r0
                    int r0 = -r0
                    int r0 = ~r0
                    int r2 = r2 - r0
                    int r2 = r2 - r3
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                    r0 = 67
                    if (r2 == 0) goto L_0x003a
                    r2 = 39
                    goto L_0x003c
                L_0x003a:
                    r2 = 67
                L_0x003c:
                    if (r2 == r0) goto L_0x0053
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    r2 = 84
                    int r2 = r2 / r1
                    r2 = 4
                    if (r0 == 0) goto L_0x004c
                    r0 = 4
                    goto L_0x004e
                L_0x004c:
                    r0 = 65
                L_0x004e:
                    if (r0 == r2) goto L_0x0060
                    goto L_0x0083
                L_0x0051:
                    r0 = move-exception
                    throw r0
                L_0x0053:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    if (r0 == 0) goto L_0x005d
                    r0 = 0
                    goto L_0x005e
                L_0x005d:
                    r0 = 1
                L_0x005e:
                    if (r0 == r3) goto L_0x0083
                L_0x0060:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r0.setEnabled(r1)
                    int r0 = configure
                    r2 = 125(0x7d, float:1.75E-43)
                    r4 = r0 ^ 125(0x7d, float:1.75E-43)
                    r5 = r0 & 125(0x7d, float:1.75E-43)
                    r4 = r4 | r5
                    int r4 = r4 << r3
                    r5 = r0 & -126(0xffffffffffffff82, float:NaN)
                    int r0 = ~r0
                    r0 = r0 & r2
                    r0 = r0 | r5
                    int r0 = -r0
                    r2 = r4 & r0
                    r0 = r0 | r4
                    int r2 = r2 + r0
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                L_0x0083:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    java.lang.String r0 = com.cardinalcommerce.p060a.setTextLocales.m2132c(r0)
                    java.lang.String r2 = "01"
                    boolean r0 = r0.equals(r2)
                    if (r0 == 0) goto L_0x0093
                    r0 = 0
                    goto L_0x0094
                L_0x0093:
                    r0 = 1
                L_0x0094:
                    if (r0 == r3) goto L_0x00bd
                    int r0 = configure
                    r2 = r0 ^ 47
                    r0 = r0 & 47
                    int r0 = r0 << r3
                    r4 = r2 | r0
                    int r4 = r4 << r3
                    r0 = r0 ^ r2
                    int r4 = r4 - r0
                    int r0 = r4 % 128
                    cca_continue = r0
                    int r4 = r4 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setLetterSpacing r0 = com.cardinalcommerce.p060a.setTextLocales.m2117a((com.cardinalcommerce.p060a.setTextLocales) r0)
                    r0.setFocusable(r1)
                    int r0 = cca_continue
                    int r0 = r0 + 101
                    int r0 = r0 - r3
                    int r0 = r0 - r3
                    int r2 = r0 % 128
                    configure = r2
                    int r0 = r0 % 2
                L_0x00bd:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2139i(r0)
                    r0.setEnabled(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.widget.ProgressBar r0 = com.cardinalcommerce.p060a.setTextLocales.m2147q(r0)
                    r0.setVisibility(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.view.Window r0 = r0.getWindow()
                    r2 = 16
                    r0.setFlags(r2, r2)
                    int r0 = configure
                    r2 = r0 & 11
                    r0 = r0 ^ 11
                    r0 = r0 | r2
                    int r2 = r2 + r0
                    int r0 = r2 % 128
                    cca_continue = r0
                    int r2 = r2 % 2
                    if (r2 == 0) goto L_0x00eb
                    r1 = 1
                L_0x00eb:
                    if (r1 == r3) goto L_0x00ee
                    return
                L_0x00ee:
                    r0 = 0
                    int r0 = r0.length     // Catch:{ all -> 0x00f1 }
                    return
                L_0x00f1:
                    r0 = move-exception
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.C209515.run():void");
            }
        });
        setTextSelectHandle.cca_continue(settextlocales.getApplicationContext()).cca_continue(settypeface, settextlocales, settextlocales.f3023A);
        int i = f3021D;
        int i2 = ((i | 115) << 1) - (i ^ 115);
        f3022E = i2 % 128;
        if ((i2 % 2 == 0 ? ',' : 27) != 27) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* renamed from: r */
    static /* synthetic */ void m2148r(setTextLocales settextlocales) {
        settextlocales.runOnUiThread(new Runnable() {
            private static int Cardinal = 0;
            private static int cca_continue = 1;

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    int r0 = cca_continue
                    r1 = r0 & 17
                    int r2 = ~r1
                    r0 = r0 | 17
                    r0 = r0 & r2
                    r2 = 1
                    int r1 = r1 << r2
                    r3 = r0 | r1
                    int r3 = r3 << r2
                    r0 = r0 ^ r1
                    int r3 = r3 - r0
                    int r0 = r3 % 128
                    Cardinal = r0
                    int r3 = r3 % 2
                    r0 = 99
                    if (r3 == 0) goto L_0x001c
                    r1 = 27
                    goto L_0x001e
                L_0x001c:
                    r1 = 99
                L_0x001e:
                    r3 = 77
                    r4 = 0
                    if (r1 == r0) goto L_0x0036
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r1 = 46
                    int r1 = r1 / r4
                    if (r0 == 0) goto L_0x0030
                    r0 = 1
                    goto L_0x0031
                L_0x0030:
                    r0 = 0
                L_0x0031:
                    if (r0 == 0) goto L_0x00af
                    goto L_0x0047
                L_0x0034:
                    r0 = move-exception
                    throw r0
                L_0x0036:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r1 = 86
                    if (r0 == 0) goto L_0x0043
                    r0 = 77
                    goto L_0x0045
                L_0x0043:
                    r0 = 86
                L_0x0045:
                    if (r0 == r1) goto L_0x00af
                L_0x0047:
                    int r0 = cca_continue
                    r1 = r0 ^ 115(0x73, float:1.61E-43)
                    r5 = r0 & 115(0x73, float:1.61E-43)
                    r1 = r1 | r5
                    int r1 = r1 << r2
                    r5 = r0 & -116(0xffffffffffffff8c, float:NaN)
                    int r0 = ~r0
                    r0 = r0 & 115(0x73, float:1.61E-43)
                    r0 = r0 | r5
                    int r0 = -r0
                    int r0 = ~r0
                    int r1 = r1 - r0
                    int r1 = r1 - r2
                    int r0 = r1 % 128
                    Cardinal = r0
                    int r1 = r1 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    boolean r0 = com.cardinalcommerce.p060a.setTextLocales.m2146p(r0)
                    r1 = 52
                    if (r0 == 0) goto L_0x006c
                    r0 = 52
                    goto L_0x006e
                L_0x006c:
                    r0 = 91
                L_0x006e:
                    if (r0 == r1) goto L_0x0071
                    goto L_0x00af
                L_0x0071:
                    int r0 = Cardinal
                    r1 = r0 ^ 87
                    r5 = r0 & 87
                    r1 = r1 | r5
                    int r1 = r1 << r2
                    r5 = r0 & -88
                    int r0 = ~r0
                    r0 = r0 & 87
                    r0 = r0 | r5
                    int r1 = r1 - r0
                    int r0 = r1 % 128
                    cca_continue = r0
                    int r1 = r1 % 2
                    r0 = 97
                    if (r1 != 0) goto L_0x008d
                    r1 = 97
                    goto L_0x008f
                L_0x008d:
                    r1 = 74
                L_0x008f:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2145o(r0)
                    r0.setEnabled(r2)
                    int r0 = cca_continue
                    r1 = r0 ^ 77
                    r5 = r0 & 77
                    r1 = r1 | r5
                    int r1 = r1 << r2
                    int r5 = ~r5
                    r0 = r0 | r3
                    r0 = r0 & r5
                    int r0 = -r0
                    r3 = r1 ^ r0
                    r0 = r0 & r1
                    int r0 = r0 << r2
                    int r3 = r3 + r0
                    int r0 = r3 % 128
                    Cardinal = r0
                    int r3 = r3 % 2
                L_0x00af:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    java.lang.String r0 = com.cardinalcommerce.p060a.setTextLocales.m2132c(r0)
                    java.lang.String r1 = "01"
                    boolean r0 = r0.equals(r1)
                    r1 = 63
                    if (r0 == 0) goto L_0x00c2
                    r0 = 12
                    goto L_0x00c4
                L_0x00c2:
                    r0 = 63
                L_0x00c4:
                    if (r0 == r1) goto L_0x00f2
                    int r0 = Cardinal
                    r1 = r0 & 67
                    int r3 = ~r1
                    r0 = r0 | 67
                    r0 = r0 & r3
                    int r1 = r1 << r2
                    int r1 = -r1
                    int r1 = -r1
                    r3 = r0 | r1
                    int r3 = r3 << r2
                    r0 = r0 ^ r1
                    int r3 = r3 - r0
                    int r0 = r3 % 128
                    cca_continue = r0
                    int r3 = r3 % 2
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setLetterSpacing r0 = com.cardinalcommerce.p060a.setTextLocales.m2117a((com.cardinalcommerce.p060a.setTextLocales) r0)
                    r0.setFocusable(r2)
                    int r0 = Cardinal
                    r1 = r0 & 45
                    r0 = r0 | 45
                    int r1 = r1 + r0
                    int r0 = r1 % 128
                    cca_continue = r0
                    int r1 = r1 % 2
                L_0x00f2:
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.widget.ProgressBar r0 = com.cardinalcommerce.p060a.setTextLocales.m2147q(r0)
                    r1 = 8
                    r0.setVisibility(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    android.view.Window r0 = r0.getWindow()
                    r1 = 16
                    r0.clearFlags(r1)
                    com.cardinalcommerce.a.setTextLocales r0 = com.cardinalcommerce.p060a.setTextLocales.this
                    com.cardinalcommerce.a.setHyphenationFrequency r0 = com.cardinalcommerce.p060a.setTextLocales.m2139i(r0)
                    r0.setEnabled(r2)
                    int r0 = Cardinal
                    r1 = r0 & 14
                    r0 = r0 | 14
                    int r1 = r1 + r0
                    int r1 = r1 - r4
                    int r1 = r1 - r2
                    int r0 = r1 % 128
                    cca_continue = r0
                    int r1 = r1 % 2
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocales.C209414.run():void");
            }
        });
        int i = f3022E;
        int i2 = i & 29;
        int i3 = -(-(i | 29));
        int i4 = (i2 & i3) + (i3 | i2);
        f3021D = i4 % 128;
        int i5 = i4 % 2;
    }
}
