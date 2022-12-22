package com.cardinalcommerce.p060a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.cardinalcommerce.p060a.setFontFeatureSettings;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setTextLocale */
public class setTextLocale extends AppCompatActivity implements setAutoSizeTextTypeUniformWithConfiguration {

    /* renamed from: f */
    private static int f3014f = 0;

    /* renamed from: g */
    private static int f3015g = 1;

    /* renamed from: a */
    setBaselineAligned f3016a;

    /* renamed from: b */
    private WebView f3017b;

    /* renamed from: c */
    private boolean f3018c = false;

    /* renamed from: d */
    private ProgressBar f3019d;

    /* renamed from: e */
    private BroadcastReceiver f3020e = new BroadcastReceiver() {
        private static int cca_continue = 1;
        private static int init;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
            if ((r5.getAction().equals("finish_activity")) != false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
            if ((r5.getAction().equals("finish_activity")) != true) goto L_0x0067;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                int r4 = init
                r0 = r4 ^ 119(0x77, float:1.67E-43)
                r4 = r4 & 119(0x77, float:1.67E-43)
                r1 = 1
                int r4 = r4 << r1
                int r4 = -r4
                int r4 = -r4
                int r4 = ~r4
                int r0 = r0 - r4
                int r0 = r0 - r1
                int r4 = r0 % 128
                cca_continue = r4
                int r0 = r0 % 2
                r4 = 0
                if (r0 != 0) goto L_0x0018
                r0 = 1
                goto L_0x0019
            L_0x0018:
                r0 = 0
            L_0x0019:
                java.lang.String r2 = "finish_activity"
                if (r0 == 0) goto L_0x0032
                java.lang.String r5 = r5.getAction()
                boolean r5 = r5.equals(r2)
                r0 = 76
                int r0 = r0 / r4
                if (r5 == 0) goto L_0x002c
                r5 = 1
                goto L_0x002d
            L_0x002c:
                r5 = 0
            L_0x002d:
                if (r5 == 0) goto L_0x0067
                goto L_0x0042
            L_0x0030:
                r4 = move-exception
                throw r4
            L_0x0032:
                java.lang.String r5 = r5.getAction()
                boolean r5 = r5.equals(r2)
                if (r5 == 0) goto L_0x003e
                r5 = 1
                goto L_0x003f
            L_0x003e:
                r5 = 0
            L_0x003f:
                if (r5 == r1) goto L_0x0042
                goto L_0x0067
            L_0x0042:
                com.cardinalcommerce.a.setTextLocale r5 = com.cardinalcommerce.p060a.setTextLocale.this
                android.content.Context r5 = r5.getApplicationContext()
                com.cardinalcommerce.a.setTextSelectHandle r5 = com.cardinalcommerce.p060a.setTextSelectHandle.cca_continue((android.content.Context) r5)
                r5.configure()
                com.cardinalcommerce.a.setTextLocale r5 = com.cardinalcommerce.p060a.setTextLocale.this
                r5.finish()
                int r5 = init
                r0 = r5 & 99
                r5 = r5 ^ 99
                r5 = r5 | r0
                int r5 = -r5
                int r5 = -r5
                r2 = r0 & r5
                r5 = r5 | r0
                int r2 = r2 + r5
                int r5 = r2 % 128
                cca_continue = r5
                int r2 = r2 % 2
            L_0x0067:
                int r5 = cca_continue
                r0 = r5 & 67
                r5 = r5 | 67
                r2 = r0 ^ r5
                r5 = r5 & r0
                int r5 = r5 << r1
                int r2 = r2 + r5
                int r5 = r2 % 128
                init = r5
                int r2 = r2 % 2
                if (r2 == 0) goto L_0x007b
                goto L_0x007c
            L_0x007b:
                r4 = 1
            L_0x007c:
                if (r4 == r1) goto L_0x0085
                r4 = 0
                super.hashCode()     // Catch:{ all -> 0x0083 }
                return
            L_0x0083:
                r4 = move-exception
                throw r4
            L_0x0085:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocale.C20894.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* renamed from: a */
    static /* synthetic */ void m2109a(setTextLocale settextlocale) {
        int i = f3015g;
        int i2 = (i | 77) << 1;
        int i3 = -(((~i) & 77) | (i & -78));
        int i4 = (i2 & i3) + (i3 | i2);
        f3014f = i4 % 128;
        int i5 = i4 % 2;
        settextlocale.m2112b();
        int i6 = f3014f;
        int i7 = ((i6 ^ 79) - (~(-(-((i6 & 79) << 1))))) - 1;
        f3015g = i7 % 128;
        if ((i7 % 2 == 0 ? 'P' : '8') == 'P') {
            int i8 = 31 / 0;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m2110a(setTextLocale settextlocale, setBaselineAligned setbaselinealigned) {
        int i = f3014f;
        boolean z = true;
        int i2 = (i | 71) << 1;
        int i3 = -(i ^ 71);
        int i4 = (i2 & i3) + (i3 | i2);
        f3015g = i4 % 128;
        int i5 = i4 % 2;
        settextlocale.m2108a(setbaselinealigned);
        int i6 = f3014f;
        int i7 = ((i6 | 57) << 1) - (i6 ^ 57);
        f3015g = i7 % 128;
        if (i7 % 2 == 0) {
            z = false;
        }
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* renamed from: b */
    static /* synthetic */ WebView m2111b(setTextLocale settextlocale) {
        int i = (f3015g + 124) - 1;
        f3014f = i % 128;
        char c = i % 2 != 0 ? '$' : CharUtils.f5620CR;
        WebView webView = settextlocale.f3017b;
        if (c == '$') {
            int i2 = 72 / 0;
        }
        return webView;
    }

    /* renamed from: c */
    static /* synthetic */ ProgressBar m2113c(setTextLocale settextlocale) {
        int i = f3015g;
        int i2 = i & 29;
        int i3 = (((i ^ 29) | i2) << 1) - ((i | 29) & (~i2));
        f3014f = i3 % 128;
        int i4 = i3 % 2;
        ProgressBar progressBar = settextlocale.f3019d;
        int i5 = (f3015g + 44) - 1;
        f3014f = i5 % 128;
        if ((i5 % 2 != 0 ? 'D' : 9) == 9) {
            return progressBar;
        }
        int i6 = 99 / 0;
        return progressBar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        try {
            registerReceiver(this.f3020e, new IntentFilter("finish_activity"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        boolean z = setHeight.Cardinal;
        getWindow().setFlags(8192, 8192);
        this.f3016a = (setBaselineAligned) ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getSerializable("StepUpData");
        UiCustomization uiCustomization = (UiCustomization) getIntent().getExtras().getSerializable("UiCustomization");
        setContentView((int) R.layout.activity_html_ui_view);
        setShowSoftInputOnFocus setshowsoftinputonfocus = (setShowSoftInputOnFocus) findViewById(R.id.toolbarButton);
        setshowsoftinputonfocus.setCCAOnClickListener(new setFontFeatureSettings.C2048init() {
            private static int Cardinal = 1;
            private static int init;

            public final void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                int i = init;
                int i2 = i & 67;
                int i3 = (i | 67) & (~i2);
                int i4 = i2 << 1;
                int i5 = ((i3 | i4) << 1) - (i3 ^ i4);
                Cardinal = i5 % 128;
                String str = null;
                if ((i5 % 2 == 0 ? (char) 7 : 24) != 24) {
                    setTextMetricsParams.getSDKVersion().init("HTML Challenge Screen", "Cancel pressed", str);
                    setTextLocale.m2109a(setTextLocale.this);
                    super.hashCode();
                    return;
                }
                setTextMetricsParams.getSDKVersion().init("HTML Challenge Screen", "Cancel pressed", str);
                setTextLocale.m2109a(setTextLocale.this);
            }
        });
        this.f3019d = (ProgressBar) findViewById(R.id.pbHeaderProgress);
        WebView webView = (WebView) findViewById(R.id.webviewUi);
        this.f3017b = webView;
        webView.getSettings().setJavaScriptEnabled(false);
        this.f3017b.setWebViewClient(new WebViewClient() {
            private static int configure = 1;
            private static int getInstance;

            /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0083, code lost:
                if (r10.toString().contains("data:text/html") == false) goto L_0x0093;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
                if (r10.toString().contains("data:text/html") == false) goto L_0x0093;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x013d, code lost:
                if ((!r4.toString().isEmpty() ? '.' : '#') != '#') goto L_0x013f;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean shouldOverrideUrlLoading(android.webkit.WebView r10, java.lang.String r11) {
                /*
                    r9 = this;
                    int r10 = configure
                    r0 = r10 & 83
                    r10 = r10 | 83
                    int r0 = r0 + r10
                    int r10 = r0 % 128
                    getInstance = r10
                    int r0 = r0 % 2
                    boolean r10 = r11.isEmpty()
                    r0 = 0
                    r1 = 1
                    if (r10 != 0) goto L_0x01ad
                    android.net.Uri r10 = android.net.Uri.parse(r11)
                    com.cardinalcommerce.a.setTextLocale r11 = com.cardinalcommerce.p060a.setTextLocale.this
                    android.os.Handler r2 = new android.os.Handler
                    android.os.Looper r3 = r11.getMainLooper()
                    r2.<init>(r3)
                    com.cardinalcommerce.a.setTextLocale$2 r3 = new com.cardinalcommerce.a.setTextLocale$2
                    r3.<init>()
                    r2.post(r3)
                    boolean r2 = r10.isHierarchical()
                    if (r2 == 0) goto L_0x0034
                    r2 = 1
                    goto L_0x0035
                L_0x0034:
                    r2 = 0
                L_0x0035:
                    r3 = 0
                    if (r2 == r1) goto L_0x005c
                    com.cardinalcommerce.a.setTextMetricsParams r10 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()
                    java.lang.String r2 = "10616"
                    java.lang.String r4 = " URI is not hierarchical"
                    r10.configure(r2, r4, r3)
                    r11.mo18750a()
                    int r10 = getInstance
                    r11 = r10 & 75
                    r10 = r10 ^ 75
                    r10 = r10 | r11
                    int r10 = -r10
                    int r10 = -r10
                    r2 = r11 ^ r10
                    r10 = r10 & r11
                    int r10 = r10 << r1
                    int r2 = r2 + r10
                    int r10 = r2 % 128
                    configure = r10
                    int r2 = r2 % 2
                    goto L_0x01ad
                L_0x005c:
                    int r2 = configure
                    r4 = r2 ^ 113(0x71, float:1.58E-43)
                    r5 = r2 & 113(0x71, float:1.58E-43)
                    r4 = r4 | r5
                    int r4 = r4 << r1
                    int r5 = ~r5
                    r2 = r2 | 113(0x71, float:1.58E-43)
                    r2 = r2 & r5
                    int r2 = -r2
                    int r2 = ~r2
                    int r4 = r4 - r2
                    int r4 = r4 - r1
                    int r2 = r4 % 128
                    getInstance = r2
                    int r4 = r4 % 2
                    if (r4 == 0) goto L_0x0076
                    r2 = 1
                    goto L_0x0077
                L_0x0076:
                    r2 = 0
                L_0x0077:
                    java.lang.String r4 = "data:text/html"
                    if (r2 == r1) goto L_0x0086
                    java.lang.String r2 = r10.toString()
                    boolean r2 = r2.contains(r4)
                    if (r2 != 0) goto L_0x01a0
                    goto L_0x0093
                L_0x0086:
                    java.lang.String r2 = r10.toString()
                    boolean r2 = r2.contains(r4)
                    r4 = 70
                    int r4 = r4 / r0
                    if (r2 != 0) goto L_0x01a0
                L_0x0093:
                    java.util.Set r2 = r10.getQueryParameterNames()
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.util.Iterator r2 = r2.iterator()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    int r5 = configure
                    r6 = r5 | 43
                    int r6 = r6 << r1
                    r7 = r5 & -44
                    int r5 = ~r5
                    r5 = r5 & 43
                    r5 = r5 | r7
                    int r5 = -r5
                    r7 = r6 | r5
                    int r7 = r7 << r1
                    r5 = r5 ^ r6
                    int r7 = r7 - r5
                    int r5 = r7 % 128
                    getInstance = r5
                    int r7 = r7 % 2
                L_0x00b7:
                    boolean r5 = r2.hasNext()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r6 = 73
                    if (r5 == 0) goto L_0x00c2
                    r5 = 73
                    goto L_0x00c4
                L_0x00c2:
                    r5 = 18
                L_0x00c4:
                    if (r5 == r6) goto L_0x00ef
                    java.lang.String r10 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    char[] r10 = com.cardinalcommerce.p060a.setHorizontallyScrolling.getInstance((java.lang.String) r10)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    com.cardinalcommerce.a.setCompoundDrawablesWithIntrinsicBounds r2 = new com.cardinalcommerce.a.setCompoundDrawablesWithIntrinsicBounds     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r2.<init>()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r2.configure = r10     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    com.cardinalcommerce.a.setTypeface r10 = new com.cardinalcommerce.a.setTypeface     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    com.cardinalcommerce.a.setBaselineAligned r3 = r11.f3016a     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r10.<init>(r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r11.mo18751a((com.cardinalcommerce.p060a.setTypeface) r10)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    int r10 = configure
                    r11 = r10 | 99
                    int r11 = r11 << r1
                    r10 = r10 ^ 99
                    int r11 = r11 - r10
                L_0x00e7:
                    int r10 = r11 % 128
                    getInstance = r10
                    int r11 = r11 % 2
                    goto L_0x01ad
                L_0x00ef:
                    int r5 = configure
                    r6 = r5 | 35
                    int r7 = r6 << 1
                    r8 = 35
                    r5 = r5 & r8
                    int r5 = ~r5
                    r5 = r5 & r6
                    int r5 = -r5
                    r6 = r7 ^ r5
                    r5 = r5 & r7
                    int r5 = r5 << r1
                    int r6 = r6 + r5
                    int r5 = r6 % 128
                    getInstance = r5
                    int r6 = r6 % 2
                    if (r6 == 0) goto L_0x010b
                    r5 = 35
                    goto L_0x010d
                L_0x010b:
                    r5 = 60
                L_0x010d:
                    if (r5 == r8) goto L_0x0125
                    java.lang.Object r5 = r2.next()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r5 = (java.lang.String) r5     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r6 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    boolean r6 = r6.isEmpty()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    if (r6 != 0) goto L_0x0121
                    r6 = 1
                    goto L_0x0122
                L_0x0121:
                    r6 = 0
                L_0x0122:
                    if (r6 == r1) goto L_0x013f
                    goto L_0x0164
                L_0x0125:
                    java.lang.Object r5 = r2.next()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r5 = (java.lang.String) r5     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r6 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    boolean r6 = r6.isEmpty()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r7 = 38
                    int r7 = r7 / r0
                    if (r6 != 0) goto L_0x013b
                    r6 = 46
                    goto L_0x013d
                L_0x013b:
                    r6 = 35
                L_0x013d:
                    if (r6 == r8) goto L_0x0164
                L_0x013f:
                    int r6 = getInstance
                    r7 = r6 | 9
                    int r7 = r7 << r1
                    r6 = r6 ^ 9
                    int r7 = r7 - r6
                    int r6 = r7 % 128
                    configure = r6
                    int r7 = r7 % 2
                    r6 = 98
                    if (r7 != 0) goto L_0x0154
                    r7 = 62
                    goto L_0x0156
                L_0x0154:
                    r7 = 98
                L_0x0156:
                    java.lang.String r8 = "&"
                    if (r7 == r6) goto L_0x0161
                    r4.append(r8)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    int r6 = r3.length     // Catch:{ all -> 0x015f }
                    goto L_0x0164
                L_0x015f:
                    r10 = move-exception
                    throw r10
                L_0x0161:
                    r4.append(r8)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                L_0x0164:
                    java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r6 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r6 = java.net.URLEncoder.encode(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r4.append(r6)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r6 = "="
                    r4.append(r6)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r5 = r10.getQueryParameter(r5)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r6 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    java.lang.String r5 = java.net.URLEncoder.encode(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    r4.append(r5)     // Catch:{ UnsupportedEncodingException -> 0x019d }
                    int r5 = configure
                    r6 = 55
                    r7 = r5 & -56
                    int r8 = ~r5
                    r8 = r8 & r6
                    r7 = r7 | r8
                    r5 = r5 & r6
                    int r5 = r5 << r1
                    int r7 = r7 + r5
                    int r5 = r7 % 128
                    getInstance = r5
                    int r7 = r7 % 2
                    goto L_0x00b7
                L_0x019b:
                    r10 = move-exception
                    throw r10
                L_0x019d:
                    r11.mo18750a()
                L_0x01a0:
                    int r10 = configure
                    int r10 = r10 + 28
                    r11 = r10 & -1
                    r10 = r10 | -1
                    int r11 = r11 + r10
                    goto L_0x00e7
                L_0x01ab:
                    r10 = move-exception
                    throw r10
                L_0x01ad:
                    int r10 = getInstance
                    r11 = r10 | 32
                    int r11 = r11 << r1
                    r10 = r10 ^ 32
                    int r11 = r11 - r10
                    r10 = r11 & -1
                    r11 = r11 | -1
                    int r10 = r10 + r11
                    int r11 = r10 % 128
                    configure = r11
                    int r10 = r10 % 2
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocale.C20851.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
            }
        });
        m2108a(this.f3016a);
        setPaintFlags.configure(setshowsoftinputonfocus, uiCustomization, (Activity) this);
        setPaintFlags.configure((Toolbar) findViewById(R.id.toolbar), uiCustomization, (Activity) this);
        int i = f3014f;
        int i2 = (i ^ 47) + ((i & 47) << 1);
        f3015g = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 15 : 3) != 3) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.String] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if ((!r12.f3018c) != false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if ((!r12.f3018c) != true) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r12 = this;
            int r0 = f3015g
            int r0 = r0 + 52
            r1 = r0 ^ -1
            r0 = r0 & -1
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3014f = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 == 0) goto L_0x0016
            r1 = 0
            goto L_0x0017
        L_0x0016:
            r1 = 1
        L_0x0017:
            java.lang.String r3 = "Challenge Screen back to foreground"
            java.lang.String r4 = "HTML Challenge Screen"
            r5 = 0
            if (r1 == 0) goto L_0x0030
            com.cardinalcommerce.a.setTextMetricsParams r1 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()
            r1.init(r4, r3, r5)
            boolean r1 = r12.f3018c
            if (r1 == 0) goto L_0x002b
            r1 = 0
            goto L_0x002c
        L_0x002b:
            r1 = 1
        L_0x002c:
            if (r1 == 0) goto L_0x0043
            goto L_0x00af
        L_0x0030:
            com.cardinalcommerce.a.setTextMetricsParams r1 = com.cardinalcommerce.p060a.setTextMetricsParams.getSDKVersion()
            r1.init(r4, r3, r5)
            boolean r1 = r12.f3018c
            r3 = 89
            int r3 = r3 / r0
            if (r1 == 0) goto L_0x0040
            r1 = 0
            goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            if (r1 == r2) goto L_0x00af
        L_0x0043:
            int r1 = f3014f
            r3 = r1 & 61
            r1 = r1 ^ 61
            r1 = r1 | r3
            int r3 = r3 + r1
            int r1 = r3 % 128
            f3015g = r1
            int r3 = r3 % 2
            com.cardinalcommerce.a.setBaselineAligned r1 = r12.f3016a
            java.lang.String r1 = r1.setUiType
            java.lang.String r3 = ""
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00af
            r3 = 8
            byte[] r1 = android.util.Base64.decode(r1, r3)
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            r8.<init>(r1, r3)
            boolean r1 = r8.isEmpty()
            r3 = 76
            if (r1 != 0) goto L_0x0075
            r1 = 76
            goto L_0x0077
        L_0x0075:
            r1 = 30
        L_0x0077:
            if (r1 == r3) goto L_0x007a
            goto L_0x00af
        L_0x007a:
            int r1 = f3014f
            int r1 = r1 + 103
            int r3 = r1 % 128
            f3015g = r3
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x0088
            r1 = 0
            goto L_0x0089
        L_0x0088:
            r1 = 1
        L_0x0089:
            android.webkit.WebView r6 = r12.f3017b
            r11 = 0
            java.lang.String r7 = "HTTPS://EMV3DS/challenge/refresh"
            java.lang.String r9 = "text/html"
            java.lang.String r10 = "UTF-8"
            r6.loadDataWithBaseURL(r7, r8, r9, r10, r11)
            if (r1 == r2) goto L_0x009b
            int r1 = r5.length     // Catch:{ all -> 0x0099 }
            goto L_0x009b
        L_0x0099:
            r0 = move-exception
            throw r0
        L_0x009b:
            int r1 = f3015g
            r3 = 99
            r4 = r1 & -100
            int r5 = ~r1
            r5 = r5 & r3
            r4 = r4 | r5
            r1 = r1 & r3
            int r1 = r1 << r2
            int r1 = ~r1
            int r4 = r4 - r1
            int r4 = r4 - r2
            int r1 = r4 % 128
            f3014f = r1
            int r4 = r4 % 2
        L_0x00af:
            super.onResume()
            int r1 = f3015g
            r3 = r1 & 33
            r1 = r1 ^ 33
            r1 = r1 | r3
            int r1 = -r1
            int r1 = -r1
            r4 = r3 ^ r1
            r1 = r1 & r3
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f3014f = r1
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r2 = 0
        L_0x00ca:
            if (r2 == 0) goto L_0x00d2
            r1 = 36
            int r1 = r1 / r0
            return
        L_0x00d0:
            r0 = move-exception
            throw r0
        L_0x00d2:
            return
        L_0x00d3:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextLocale.onResume():void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        int i = f3015g;
        int i2 = i & 11;
        int i3 = (i | 11) & (~i2);
        int i4 = i2 << 1;
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f3014f = i5 % 128;
        int i6 = i5 % 2;
        setTextMetricsParams.getSDKVersion().init("HTML Challenge Screen", "Activity closed", (String) null);
        try {
            unregisterReceiver(this.f3020e);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        setTextSelectHandle cca_continue = setTextSelectHandle.cca_continue((Context) this);
        setTextSelectHandle.getInstance = null;
        cca_continue.Cardinal = null;
        cca_continue.cca_continue.clear();
        super.onDestroy();
        int i7 = f3015g + 67;
        f3014f = i7 % 128;
        if ((i7 % 2 != 0 ? '*' : '3') != '3') {
            int i8 = 22 / 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        int i = f3015g + 21;
        f3014f = i % 128;
        if (i % 2 != 0) {
        }
        this.f3018c = true;
        super.onPause();
        int i2 = f3015g;
        int i3 = i2 & 63;
        int i4 = ((i2 ^ 63) | i3) << 1;
        int i5 = -((i2 | 63) & (~i3));
        int i6 = (i4 & i5) + (i5 | i4);
        f3014f = i6 % 128;
        if ((i6 % 2 != 0 ? 'X' : '-') == 'X') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* renamed from: b */
    private void m2112b() {
        setCompoundDrawablesWithIntrinsicBounds setcompounddrawableswithintrinsicbounds = new setCompoundDrawablesWithIntrinsicBounds();
        setcompounddrawableswithintrinsicbounds.getInstance = setHeight.getWarnings;
        mo18751a(new setTypeface(this.f3016a, setcompounddrawableswithintrinsicbounds));
        int i = f3015g;
        int i2 = i & 63;
        int i3 = ((i ^ 63) | i2) << 1;
        int i4 = -((i | 63) & (~i2));
        int i5 = (i3 & i4) + (i4 | i3);
        f3014f = i5 % 128;
        int i6 = i5 % 2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18750a() {
        setCompoundDrawablesWithIntrinsicBounds setcompounddrawableswithintrinsicbounds = new setCompoundDrawablesWithIntrinsicBounds();
        setcompounddrawableswithintrinsicbounds.getInstance = setHeight.cleanup;
        mo18751a(new setTypeface(this.f3016a, setcompounddrawableswithintrinsicbounds));
        int i = f3014f;
        int i2 = (i ^ 91) + ((i & 91) << 1);
        f3015g = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void configure(final setBaselineAligned setbaselinealigned) {
        runOnUiThread(new Runnable() {
            private static int cca_continue = 1;
            private static int getInstance;

            public final void run() {
                int i = ((getInstance + 126) + 0) - 1;
                cca_continue = i % 128;
                if ((i % 2 == 0 ? 'E' : 'a') != 'E') {
                    setTextLocale.m2110a(setTextLocale.this, setbaselinealigned);
                    setTextLocale.m2114d(setTextLocale.this);
                    return;
                }
                setTextLocale.m2110a(setTextLocale.this, setbaselinealigned);
                setTextLocale.m2114d(setTextLocale.this);
                Object[] objArr = null;
                int length = objArr.length;
            }
        });
        int i = f3014f;
        int i2 = i & 15;
        int i3 = (i | 15) & (~i2);
        int i4 = -(-(i2 << 1));
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f3015g = i5 % 128;
        int i6 = i5 % 2;
    }

    public final void Cardinal() {
        String str = null;
        setTextMetricsParams.getSDKVersion().init("HTML Challenge Screen", "Activity closed", str);
        runOnUiThread(new Runnable() {
            private static int configure = 0;
            private static int init = 1;

            public final void run() {
                int i;
                Window window;
                int i2 = init;
                int i3 = (i2 & 62) + (i2 | 62);
                int i4 = ((i3 | -1) << 1) - (i3 ^ -1);
                configure = i4 % 128;
                if ((i4 % 2 != 0 ? VersionRange.LEFT_OPEN : Typography.less) != '(') {
                    setTextLocale.m2113c(setTextLocale.this).setVisibility(8);
                    window = setTextLocale.this.getWindow();
                    i = 16;
                } else {
                    setTextLocale.m2113c(setTextLocale.this).setVisibility(80);
                    window = setTextLocale.this.getWindow();
                    i = 76;
                }
                window.clearFlags(i);
            }
        });
        finishAndRemoveTask();
        int i = f3014f + 97;
        f3015g = i % 128;
        if (!(i % 2 != 0)) {
            super.hashCode();
        }
    }

    public void onBackPressed() {
        setTextMetricsParams.getSDKVersion().init("HTML Challenge Screen", "Back button pressed", (String) null);
        runOnUiThread(new Runnable() {
            private static int configure = 0;
            private static int init = 1;

            public final void run() {
                int i;
                Window window;
                int i2 = init;
                int i3 = (i2 & 62) + (i2 | 62);
                int i4 = ((i3 | -1) << 1) - (i3 ^ -1);
                configure = i4 % 128;
                if ((i4 % 2 != 0 ? VersionRange.LEFT_OPEN : Typography.less) != '(') {
                    setTextLocale.m2113c(setTextLocale.this).setVisibility(8);
                    window = setTextLocale.this.getWindow();
                    i = 16;
                } else {
                    setTextLocale.m2113c(setTextLocale.this).setVisibility(80);
                    window = setTextLocale.this.getWindow();
                    i = 76;
                }
                window.clearFlags(i);
            }
        });
        m2112b();
        int i = f3014f;
        int i2 = i & 7;
        int i3 = ((i | 7) & (~i2)) + (i2 << 1);
        f3015g = i3 % 128;
        if ((i3 % 2 == 0 ? '5' : Matrix.MATRIX_TYPE_RANDOM_UT) != 'U') {
            int i4 = 96 / 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18751a(setTypeface settypeface) {
        runOnUiThread(new Runnable() {
            private static int cca_continue = 0;
            private static int init = 1;

            public final void run() {
                int i = init;
                int i2 = i & 23;
                int i3 = ((i | 23) & (~i2)) + (i2 << 1);
                cca_continue = i3 % 128;
                int i4 = i3 % 2;
                setTextLocale.m2113c(setTextLocale.this).setVisibility(0);
                setTextLocale.this.getWindow().setFlags(16, 16);
                int i5 = ((cca_continue + 23) - 1) - 1;
                init = i5 % 128;
                int i6 = i5 % 2;
            }
        });
        setTextSelectHandle.cca_continue(getApplicationContext()).cca_continue(settypeface, this, "05");
        int i = f3014f;
        int i2 = i ^ 7;
        int i3 = ((i & 7) | i2) << 1;
        int i4 = -i2;
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f3015g = i5 % 128;
        if (i5 % 2 == 0) {
            Object obj = null;
            super.hashCode();
        }
    }

    /* renamed from: a */
    private void m2108a(setBaselineAligned setbaselinealigned) {
        String replaceAll = new String(Base64.decode(setbaselinealigned.Cardinal, 8), StandardCharsets.UTF_8).replaceAll("\"POST\"", "\"GET\"").replaceAll("\"post\"", "\"get\"").replaceAll("<input type=\"submit\"", "<input type=\"submit\" name=\"submit\"");
        if ((!replaceAll.isEmpty() ? Typography.less : 'B') != 'B') {
            int i = f3014f + 61;
            f3015g = i % 128;
            int i2 = i % 2;
            this.f3017b.loadDataWithBaseURL("HTTPS://EMV3DS/challenge", replaceAll, "text/html", "UTF-8", (String) null);
            int i3 = f3014f;
            int i4 = (i3 & 81) + (i3 | 81);
            f3015g = i4 % 128;
            int i5 = i4 % 2;
        }
        int i6 = f3014f;
        int i7 = ((((i6 | 106) << 1) - (i6 ^ 106)) + 0) - 1;
        f3015g = i7 % 128;
        int i8 = i7 % 2;
    }

    /* renamed from: d */
    static /* synthetic */ void m2114d(setTextLocale settextlocale) {
        settextlocale.runOnUiThread(new Runnable() {
            private static int configure = 0;
            private static int init = 1;

            public final void run() {
                int i;
                Window window;
                int i2 = init;
                int i3 = (i2 & 62) + (i2 | 62);
                int i4 = ((i3 | -1) << 1) - (i3 ^ -1);
                configure = i4 % 128;
                if ((i4 % 2 != 0 ? VersionRange.LEFT_OPEN : Typography.less) != '(') {
                    setTextLocale.m2113c(setTextLocale.this).setVisibility(8);
                    window = setTextLocale.this.getWindow();
                    i = 16;
                } else {
                    setTextLocale.m2113c(setTextLocale.this).setVisibility(80);
                    window = setTextLocale.this.getWindow();
                    i = 76;
                }
                window.clearFlags(i);
            }
        });
        int i = f3014f;
        int i2 = i & 25;
        boolean z = true;
        int i3 = ((((i ^ 25) | i2) << 1) - (~(-((i | 25) & (~i2))))) - 1;
        f3015g = i3 % 128;
        if (i3 % 2 == 0) {
            z = false;
        }
        if (!z) {
            Object obj = null;
            super.hashCode();
        }
    }
}
