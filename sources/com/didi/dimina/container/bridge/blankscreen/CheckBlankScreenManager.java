package com.didi.dimina.container.bridge.blankscreen;

import android.text.TextUtils;
import android.view.View;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.messager.DMMessageTransfer;
import com.didi.dimina.container.mina.DMMinaHelper;
import com.didi.dimina.container.mina.DMSingleTaskExecutor;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J(\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\"\u0010#\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010&\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010'\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0005H\u0002J*\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001c2\b\b\u0001\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\"H\u0002J\"\u0010.\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010/\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%J\u0006\u00100\u001a\u00020\u001aJ\u0012\u00101\u001a\u00020\u00152\b\b\u0001\u00102\u001a\u00020\u001cH\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u000e\u00104\u001a\u00020\f*\u0004\u0018\u00010\bH\u0002R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/blankscreen/CheckBlankScreenManager;", "", "()V", "callBackMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "config", "Lcom/didi/dimina/container/DMConfig$BlankScreenConfig;", "dmMina", "Lcom/didi/dimina/container/DMMina;", "<set-?>", "", "isCheckingBlank", "()Z", "isQuit", "setQuit", "(Z)V", "mDmPage", "Lcom/didi/dimina/container/page/DMPage;", "mStartTime", "", "openUrl", "strategy", "Ljava/util/ArrayList;", "callback", "", "checkCount", "", "checkIsSkeletonShow", "webview", "Lcom/didi/dimina/container/webengine/WebViewEngine;", "currentTimes", "rate", "", "checkRunTimes", "view", "Landroid/view/View;", "isContainsSkeleton", "isOpenUrlInWhiteList", "log", "message", "reportAndCallBack", "strategyConfig", "blank", "colorRate", "runPolicy", "start", "stop", "timeGapOfCheckTimes", "times", "timesShowToUser", "isValiable", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CheckBlankScreenManager.kt */
public final class CheckBlankScreenManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CheckBlankScreenManager";

    /* renamed from: j */
    private static final String f16683j = ",";

    /* renamed from: a */
    private DMConfig.BlankScreenConfig f16684a;

    /* renamed from: b */
    private ArrayList<Long> f16685b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DMMina f16686c;

    /* renamed from: d */
    private DMPage f16687d;

    /* renamed from: e */
    private HashMap<String, String> f16688e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f16689f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f16690g;

    /* renamed from: h */
    private volatile boolean f16691h;

    /* renamed from: i */
    private String f16692i;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final int m12315b(int i) {
        return i + 1;
    }

    @JvmStatic
    public static final List<String> convertStrWithCommaToList(String str) {
        return Companion.convertStrWithCommaToList(str);
    }

    @JvmStatic
    public static final ArrayList<Long> covertStrStrategyToList(String str) {
        return Companion.covertStrStrategyToList(str);
    }

    public final boolean isCheckingBlank() {
        return this.f16690g;
    }

    public final CheckBlankScreenManager config(DMConfig.BlankScreenConfig blankScreenConfig, DMMina dMMina) {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        if (!config.isBlackScreenAllow()) {
            m12311a("白屏检测功能被禁止, 不允许生效");
            return this;
        } else if (!m12313a(blankScreenConfig)) {
            m12311a("config 必备参数未配置, 所以配置未生效");
            return this;
        } else {
            this.f16684a = blankScreenConfig;
            this.f16685b = blankScreenConfig != null ? blankScreenConfig.getStrategy() : null;
            this.f16686c = dMMina;
            m12311a("check config is:" + blankScreenConfig);
            return this;
        }
    }

    /* renamed from: a */
    private final boolean m12313a(DMConfig.BlankScreenConfig blankScreenConfig) {
        if (blankScreenConfig == null) {
            return false;
        }
        Collection strategy = blankScreenConfig.getStrategy();
        if (strategy == null || strategy.isEmpty()) {
            return false;
        }
        if (blankScreenConfig.getVCount() > 0 || blankScreenConfig.getHorizontalRate() > ((double) 0)) {
            return blankScreenConfig.getHCount() > 0 || blankScreenConfig.getHorizontalRate() > ((double) 0);
        }
        return false;
    }

    public final void start(View view) {
        DMConfig.BlankScreenConfig blankScreenConfig = this.f16684a;
        if (blankScreenConfig != null) {
            m12309a(view, blankScreenConfig, 0);
            if (blankScreenConfig != null) {
                return;
            }
        }
        LogUtil.eRelease(TAG, "exception||config is null");
        Unit unit = Unit.INSTANCE;
    }

    public final boolean isQuit() {
        return this.f16691h;
    }

    public final void setQuit(boolean z) {
        this.f16691h = z;
    }

    public final void stop() {
        this.f16691h = true;
    }

    /* renamed from: a */
    private final int m12306a() {
        ArrayList<Long> arrayList = this.f16685b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: a */
    private final long m12307a(int i) {
        Long l;
        ArrayList<Long> arrayList = this.f16685b;
        if (arrayList == null || (l = arrayList.get(i)) == null) {
            return 2;
        }
        return l.longValue();
    }

    /* renamed from: a */
    private final void m12309a(View view, DMConfig.BlankScreenConfig blankScreenConfig, int i) {
        if (m12312a(view, blankScreenConfig)) {
            m12311a("白名单中不检测");
            return;
        }
        m12311a("runPolicy config||" + blankScreenConfig + " 开始第 " + m12315b(i) + " 次检测");
        DMSingleTaskExecutor.INSTANCE.schedule(new CheckBlankScreenManager$runPolicy$1(this, i, blankScreenConfig, view), m12307a(i), TimeUnit.SECONDS);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m12312a(android.view.View r4, com.didi.dimina.container.DMConfig.BlankScreenConfig r5) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.didi.dimina.container.webengine.WebViewEngine
            java.lang.String r1 = "webviewId||"
            r2 = 0
            if (r0 == 0) goto L_0x0034
            com.didi.dimina.container.webengine.WebViewEngine r4 = (com.didi.dimina.container.webengine.WebViewEngine) r4
            com.didi.dimina.container.page.DMPage r4 = r4.getDmPage()
            r3.f16687d = r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            if (r4 == 0) goto L_0x0022
            int r1 = r4.getWebViewId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.m12311a((java.lang.String) r0)
            if (r4 == 0) goto L_0x006d
            java.lang.String r4 = r4.getUrl()
            goto L_0x006e
        L_0x0034:
            boolean r0 = r4 instanceof com.didi.dimina.container.p106ui.webview.DMWebViewContainer
            if (r0 == 0) goto L_0x006d
            com.didi.dimina.container.ui.webview.DMWebViewContainer r4 = (com.didi.dimina.container.p106ui.webview.DMWebViewContainer) r4
            com.didi.dimina.container.webengine.WebViewEngine r4 = r4.getWebView()
            if (r4 == 0) goto L_0x0045
            com.didi.dimina.container.page.DMPage r4 = r4.getDmPage()
            goto L_0x0046
        L_0x0045:
            r4 = r2
        L_0x0046:
            r3.f16687d = r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            if (r4 == 0) goto L_0x005b
            int r1 = r4.getWebViewId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x005c
        L_0x005b:
            r1 = r2
        L_0x005c:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.m12311a((java.lang.String) r0)
            if (r4 == 0) goto L_0x006d
            java.lang.String r4 = r4.getUrl()
            goto L_0x006e
        L_0x006d:
            r4 = r2
        L_0x006e:
            r3.f16692i = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "openUrl : "
            r4.append(r0)
            java.lang.String r0 = r3.f16692i
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.m12311a((java.lang.String) r4)
            java.lang.String r4 = r3.f16692i
            r0 = 0
            if (r4 == 0) goto L_0x00a2
            com.didi.dimina.container.DMConfig$BlankScreenConfig$OnCheckBlankInWhiteListener r1 = r5.getIsInWhiteListListener()
            if (r1 == 0) goto L_0x009a
            boolean r4 = r1.checkBlankInWhiteCallback(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x009b
        L_0x009a:
            r4 = r2
        L_0x009b:
            if (r4 == 0) goto L_0x00a2
            boolean r4 = r4.booleanValue()
            goto L_0x00a6
        L_0x00a2:
            r4 = r3
            com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager r4 = (com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager) r4
            r4 = 0
        L_0x00a6:
            if (r4 == 0) goto L_0x00a9
            return r4
        L_0x00a9:
            if (r5 == 0) goto L_0x00b0
            java.util.List r4 = r5.getIgnorePath()
            goto L_0x00b1
        L_0x00b0:
            r4 = r2
        L_0x00b1:
            java.util.Collection r4 = (java.util.Collection) r4
            r1 = 1
            if (r4 == 0) goto L_0x00bf
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r4 = 0
            goto L_0x00c0
        L_0x00bf:
            r4 = 1
        L_0x00c0:
            if (r4 != 0) goto L_0x00ea
            if (r5 == 0) goto L_0x00c8
            java.util.List r2 = r5.getIgnorePath()
        L_0x00c8:
            java.util.Iterator r4 = r2.iterator()
        L_0x00cc:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00ea
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r2 = r3.f16692i
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r5 = android.text.TextUtils.equals(r5, r2)
            if (r5 == 0) goto L_0x00cc
            java.lang.String r4 = "ignorePath 中配置了该页面为白名单"
            r3.m12311a((java.lang.String) r4)
            return r1
        L_0x00ea:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager.m12312a(android.view.View, com.didi.dimina.container.DMConfig$BlankScreenConfig):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r8 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) (r8 = r8.getUrl()), new java.lang.String[]{"?"}, false, 0, 6, (java.lang.Object) null);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m12314a(com.didi.dimina.container.webengine.WebViewEngine r8, com.didi.dimina.container.DMConfig.BlankScreenConfig r9) {
        /*
            r7 = this;
            java.lang.String r0 = "checkWebViewSkeleton start 检测骨架屏"
            r7.m12311a((java.lang.String) r0)
            r0 = 0
            if (r8 == 0) goto L_0x0085
            java.lang.String r1 = r9.getSkeletonCommonId()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x001a
            java.lang.String r8 = "checkWebViewSkeleton 没有配置骨架屏id 不检测骨架屏"
            r7.m12311a((java.lang.String) r8)
            return r0
        L_0x001a:
            java.util.List r9 = r9.getSkeletonPathConfig()
            if (r9 == 0) goto L_0x007f
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x0027
            goto L_0x007f
        L_0x0027:
            com.didi.dimina.container.page.DMPage r8 = r8.getDmPage()
            if (r8 == 0) goto L_0x004d
            java.lang.String r8 = r8.getUrl()
            if (r8 == 0) goto L_0x004d
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r8 = "?"
            java.lang.String[] r2 = new java.lang.String[]{r8}
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r8 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r1, (java.lang.String[]) r2, (boolean) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            if (r8 == 0) goto L_0x004d
            java.lang.Object r8 = r8.get(r0)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x004e
        L_0x004d:
            r8 = 0
        L_0x004e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "curpath is "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r7.m12311a((java.lang.String) r1)
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0071
            java.lang.String r8 = "curpath is null"
            r7.m12311a((java.lang.String) r8)
            return r0
        L_0x0071:
            boolean r8 = r9.contains(r8)
            if (r8 != 0) goto L_0x007d
            java.lang.String r8 = "curpath not in the skeletonPathConfig"
            r7.m12311a((java.lang.String) r8)
            return r0
        L_0x007d:
            r8 = 1
            return r8
        L_0x007f:
            java.lang.String r8 = "checkWebViewSkeleton 没有配置骨架屏的对应页面 不检测骨架屏"
            r7.m12311a((java.lang.String) r8)
            return r0
        L_0x0085:
            java.lang.String r8 = "checkWebViewSkeleton webview==null 不检测骨架屏"
            r7.m12311a((java.lang.String) r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager.m12314a(com.didi.dimina.container.webengine.WebViewEngine, com.didi.dimina.container.DMConfig$BlankScreenConfig):boolean");
    }

    public final void checkIsSkeletonShow(WebViewEngine webViewEngine, DMConfig.BlankScreenConfig blankScreenConfig, int i, float f) {
        DMMina dmMina;
        DMMessageTransfer messageTransfer;
        Intrinsics.checkParameterIsNotNull(blankScreenConfig, "config");
        if (webViewEngine != null && (dmMina = webViewEngine.getDmMina()) != null && (messageTransfer = dmMina.getMessageTransfer()) != null) {
            messageTransfer.evaluateJavascriptWebView(webViewEngine, Companion.skeletonCheckJs(blankScreenConfig.getSkeletonCommonId()), new CheckBlankScreenManager$checkIsSkeletonShow$1(this, blankScreenConfig, i, f, webViewEngine));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12308a(int i, View view, DMConfig.BlankScreenConfig blankScreenConfig) {
        if (m12306a() - 1 > i) {
            m12311a("继续检测 已检测 " + m12315b(i) + " 次");
            m12309a(view, blankScreenConfig, i + 1);
            return;
        }
        m12311a("检测次数达到上限 >检测完毕");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12310a(DMConfig.BlankScreenConfig blankScreenConfig, int i, @BlankType int i2, float f) {
        int i3 = i;
        int i4 = i2;
        int i5 = -1;
        if (i4 == -1) {
            m12311a("第 " + m12315b(i3) + " 次 检测到非白屏 检测完毕");
        } else if (i4 == 1) {
            m12311a("第 " + m12315b(i3) + " 次 检测到了白屏 ");
        } else if (i4 == 2) {
            m12311a("第 " + m12315b(i3) + " 次 检测到了骨架屏 ");
        }
        ArrayList<Long> strategy = blankScreenConfig.getStrategy();
        Double d = null;
        String joinToString$default = strategy != null ? CollectionsKt.joinToString$default(strategy, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null;
        DMMina dMMina = this.f16686c;
        if (dMMina != null) {
            i5 = dMMina.getMinaIndex();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(blankScreenConfig.getHCount());
        sb.append(',');
        sb.append(blankScreenConfig.getVCount());
        sb.append(',');
        sb.append(blankScreenConfig.getRate());
        String sb2 = sb.toString();
        String valueOf = String.valueOf(System.currentTimeMillis() - this.f16689f);
        String str = valueOf;
        TraceUtil.techSagaScreenBlankMonitor(i5, joinToString$default, m12315b(i3), i2, sb2, f, DMMinaHelper.getCurPath(this.f16686c), HttpUtil.splitPath(this.f16692i), valueOf);
        HashMap<String, String> hashMap = this.f16688e;
        if (hashMap != null) {
            hashMap.put("check_policy", joinToString$default);
            hashMap.put("check_count", "" + m12315b(i3));
            hashMap.put("is_blank", "" + i4);
            hashMap.put("sample_policy", sb2);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.CHINA;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.CHINA");
            String format = String.format(locale, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) 100) * f)}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            hashMap.put("color_rate", format);
            hashMap.put(CashierAction.ACTION_OPEN_URL, DMMinaHelper.getCurPath(this.f16686c));
            hashMap.put("web_url", HttpUtil.splitPath(this.f16692i));
            hashMap.put("cost_interval", str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            DMConfig.BlankScreenConfig blankScreenConfig2 = this.f16684a;
            sb3.append(blankScreenConfig2 != null ? Double.valueOf(blankScreenConfig2.getHorizontalRate()) : null);
            hashMap.put("horizontal_rate", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("");
            DMConfig.BlankScreenConfig blankScreenConfig3 = this.f16684a;
            if (blankScreenConfig3 != null) {
                d = Double.valueOf(blankScreenConfig3.getVerticalRate());
            }
            sb4.append(d);
            String put = hashMap.put("vertical_rate", sb4.toString());
        }
        m12316b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12311a(String str) {
        LogUtil.iRelease(TAG, str);
    }

    /* renamed from: b */
    private final void m12316b() {
        DMConfig.BlankScreenConfig.OnCheckBlankListener blankListener;
        DMConfig.BlankScreenConfig blankScreenConfig = this.f16684a;
        if (blankScreenConfig != null && (blankListener = blankScreenConfig.getBlankListener()) != null) {
            blankListener.checkBlankListener(this.f16686c, this.f16687d, this.f16688e);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/blankscreen/CheckBlankScreenManager$Companion;", "", "()V", "COMMA", "", "TAG", "convertStrWithCommaToList", "", "string", "covertStrStrategyToList", "Ljava/util/ArrayList;", "", "strategyStr", "skeletonCheckJs", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: CheckBlankScreenManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String skeletonCheckJs(String str) {
            return "window.skeletonDetect('" + str + "')";
        }

        @JvmStatic
        public final ArrayList<Long> covertStrStrategyToList(String str) {
            CharSequence charSequence = str;
            List<String> list = null;
            if (TextUtils.isEmpty(charSequence)) {
                return null;
            }
            if (str != null) {
                list = StringsKt.split$default(charSequence, new String[]{","}, false, 0, 6, (Object) null);
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            if (list != null) {
                for (String floatOrNull : list) {
                    Float floatOrNull2 = StringsKt.toFloatOrNull(floatOrNull);
                    if (floatOrNull2 instanceof Float) {
                        float floatValue = floatOrNull2.floatValue() * ((float) 1000);
                        if (floatValue > ((float) 0)) {
                            arrayList.add(Long.valueOf((long) floatValue));
                        }
                    }
                }
            }
            LogUtil.iRelease(CheckBlankScreenManager.TAG, "check strategy is:" + arrayList);
            return arrayList;
        }

        @JvmStatic
        public final List<String> convertStrWithCommaToList(String str) {
            CharSequence charSequence = str;
            List<String> list = null;
            if (TextUtils.isEmpty(charSequence)) {
                return null;
            }
            if (str != null) {
                list = StringsKt.split$default(charSequence, new String[]{","}, false, 0, 6, (Object) null);
            }
            LogUtil.iRelease(CheckBlankScreenManager.TAG, "array is:" + list);
            return list;
        }
    }
}
