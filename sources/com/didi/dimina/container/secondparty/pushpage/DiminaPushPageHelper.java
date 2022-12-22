package com.didi.dimina.container.secondparty.pushpage;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMLaunchLifecycleManager;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/pushpage/DiminaPushPageHelper;", "Lcom/didi/dimina/container/mina/DMLaunchLifecycleManager$LaunchLifecycleCallback;", "()V", "PERFORMANCE_EVENT_NAME", "", "currentDMMina", "Lcom/didi/dimina/container/DMMina;", "homePageName", "isHomePageDomReady", "", "pushPageActionQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lkotlin/Function0;", "", "handleDomReady", "dmMina", "onFirstPageDomReady", "page", "Lcom/didi/dimina/container/page/DMPage;", "onPageDomReady", "pushPage", "diminaUrlPath", "pushPageAfterDomReady", "sendFirstDomPerformanceData", "sendPageDomPerformanceData", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DiminaPushPageHelper.kt */
public final class DiminaPushPageHelper extends DMLaunchLifecycleManager.LaunchLifecycleCallback {
    public static final DiminaPushPageHelper INSTANCE = new DiminaPushPageHelper();

    /* renamed from: a */
    private static String f17436a = "homepage";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static DMMina f17437b = null;

    /* renamed from: c */
    private static boolean f17438c = false;

    /* renamed from: d */
    private static final LinkedBlockingQueue<Function0<Unit>> f17439d = new LinkedBlockingQueue<>();

    /* renamed from: e */
    private static final String f17440e = "performanceEntries";

    private DiminaPushPageHelper() {
    }

    public final void pushPageAfterDomReady(String str) {
        Intrinsics.checkParameterIsNotNull(str, "diminaUrlPath");
        if (str.length() == 0) {
            LogUtil.m13409e("diminaUrlPath can't be null");
        } else if (!StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
            LogUtil.m13409e("diminaUrlPath must startsWith /");
        } else if (f17438c) {
            m12968a(str);
        } else {
            f17439d.add(new DiminaPushPageHelper$pushPageAfterDomReady$1(str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12968a(String str) {
        UIHandlerUtil.post(new DiminaPushPageHelper$pushPage$1(str));
    }

    public void onPageDomReady(DMMina dMMina, DMPage dMPage) {
        Intrinsics.checkParameterIsNotNull(dMMina, "dmMina");
        Intrinsics.checkParameterIsNotNull(dMPage, "page");
        m12967a(dMMina);
        m12970c(dMMina);
    }

    public void onFirstPageDomReady(DMMina dMMina, DMPage dMPage) {
        Intrinsics.checkParameterIsNotNull(dMMina, "dmMina");
        Intrinsics.checkParameterIsNotNull(dMPage, "page");
        m12967a(dMMina);
        m12969b(dMMina);
    }

    /* renamed from: a */
    private final void m12967a(DMMina dMMina) {
        IPageHost currentPage;
        DMPage page;
        String url;
        if (!StringsKt.isBlank(f17436a)) {
            f17437b = dMMina;
            DMMinaNavigatorDelegate curNavigator = dMMina.getCurNavigator();
            if (curNavigator != null && (currentPage = curNavigator.getCurrentPage()) != null && (page = currentPage.getPage()) != null && (url = page.getUrl()) != null && StringsKt.contains$default((CharSequence) url, (CharSequence) f17436a, false, 2, (Object) null)) {
                f17438c = true;
                while (!f17439d.isEmpty()) {
                    Function0 poll = f17439d.poll();
                    if (poll != null) {
                        Unit unit = (Unit) poll.invoke();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        r4 = r13.getPerformance();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12969b(com.didi.dimina.container.DMMina r13) {
        /*
            r12 = this;
            boolean r0 = r13.isEnablePerformanceData()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "entryType"
            java.lang.String r2 = "script"
            r0.put(r1, r2)
            java.lang.String r2 = "name"
            java.lang.String r3 = "evaluateScript"
            r0.put(r2, r3)
            r3 = 0
            if (r13 == 0) goto L_0x002c
            com.didi.dimina.container.mina.DMMinaPerformance r4 = r13.getPerformance()
            if (r4 == 0) goto L_0x002c
            long r4 = r4.getMarkJSEnginePreloadTime()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            goto L_0x002d
        L_0x002c:
            r4 = r3
        L_0x002d:
            java.lang.String r5 = "startTime"
            r0.put(r5, r4)
            if (r13 == 0) goto L_0x0052
            com.didi.dimina.container.mina.DMMinaPerformance r4 = r13.getPerformance()
            if (r4 == 0) goto L_0x0052
            long r6 = r4.getMarkJSEngineReadyTime()
            com.didi.dimina.container.mina.DMMinaPerformance r4 = r13.getPerformance()
            java.lang.String r8 = "dmMina?.performance"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r8)
            long r8 = r4.getMarkJSEnginePreloadTime()
            long r6 = r6 - r8
            java.lang.Long r4 = java.lang.Long.valueOf(r6)
            goto L_0x0053
        L_0x0052:
            r4 = r3
        L_0x0053:
            java.lang.String r6 = "duration"
            r0.put(r6, r4)
            if (r13 == 0) goto L_0x0075
            com.didi.dimina.container.mina.DMMinaNavigatorDelegate r4 = r13.getCurNavigator()
            if (r4 == 0) goto L_0x0075
            com.didi.dimina.container.page.IPageHost r4 = r4.getCurrentPage()
            if (r4 == 0) goto L_0x0075
            com.didi.dimina.container.page.DMPage r4 = r4.getPage()
            if (r4 == 0) goto L_0x0075
            com.didi.dimina.container.bean.NavigateConfig r4 = r4.getNavigateConfig()
            if (r4 == 0) goto L_0x0075
            java.lang.String r4 = r4.url
            goto L_0x0076
        L_0x0075:
            r4 = r3
        L_0x0076:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r8 = "render"
            r7.put(r1, r8)
            java.lang.String r8 = "firstRender"
            r7.put(r2, r8)
            com.didi.dimina.container.mina.DMMinaPerformance r8 = r13.getPerformance()
            if (r8 == 0) goto L_0x0094
            long r8 = r8.getMarkJSDefinedDmStart()
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            goto L_0x0095
        L_0x0094:
            r8 = r3
        L_0x0095:
            r7.put(r5, r8)
            if (r13 == 0) goto L_0x00b7
            com.didi.dimina.container.mina.DMMinaPerformance r8 = r13.getPerformance()
            if (r8 == 0) goto L_0x00b7
            long r8 = r8.getMarkJSDefinedDmEnd()
            com.didi.dimina.container.mina.DMMinaPerformance r10 = r13.getPerformance()
            java.lang.String r11 = "dmMina.performance"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r11)
            long r10 = r10.getMarkJSDefinedDmStart()
            long r8 = r8 - r10
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            goto L_0x00b8
        L_0x00b7:
            r8 = r3
        L_0x00b8:
            r7.put(r6, r8)
            java.lang.String r8 = "path"
            r7.put(r8, r4)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r10 = "navigation"
            r9.put(r1, r10)
            java.lang.String r1 = "appLaunch"
            r9.put(r2, r1)
            if (r13 == 0) goto L_0x00e0
            com.didi.dimina.container.mina.DMMinaPerformance r1 = r13.getPerformance()
            if (r1 == 0) goto L_0x00e0
            long r1 = r1.getMarkAppLaunchTime()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            goto L_0x00e1
        L_0x00e0:
            r1 = r3
        L_0x00e1:
            r9.put(r5, r1)
            if (r13 == 0) goto L_0x00f4
            com.didi.dimina.container.mina.DMMinaPerformance r1 = r13.getPerformance()
            if (r1 == 0) goto L_0x00f4
            long r1 = r1.getLaunchDuration()
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
        L_0x00f4:
            r9.put(r6, r3)
            r9.put(r8, r4)
            java.lang.String r1 = "performanceEntries"
            if (r13 == 0) goto L_0x0107
            com.didi.dimina.container.messager.DMMessageTransfer r2 = r13.getMessageTransfer()
            if (r2 == 0) goto L_0x0107
            r2.sendMessageToServiceFromNative(r1, r0)
        L_0x0107:
            if (r13 == 0) goto L_0x0112
            com.didi.dimina.container.messager.DMMessageTransfer r0 = r13.getMessageTransfer()
            if (r0 == 0) goto L_0x0112
            r0.sendMessageToServiceFromNative(r1, r7)
        L_0x0112:
            if (r13 == 0) goto L_0x011d
            com.didi.dimina.container.messager.DMMessageTransfer r13 = r13.getMessageTransfer()
            if (r13 == 0) goto L_0x011d
            r13.sendMessageToServiceFromNative(r1, r9)
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.pushpage.DiminaPushPageHelper.m12969b(com.didi.dimina.container.DMMina):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r1 = (r1 = (r1 = (r1 = r14.getCurNavigator()).getCurrentPage()).getPage()).getNavigateConfig();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12970c(com.didi.dimina.container.DMMina r14) {
        /*
            r13 = this;
            boolean r0 = r14.isEnablePerformanceData()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            if (r14 == 0) goto L_0x0025
            com.didi.dimina.container.mina.DMMinaNavigatorDelegate r1 = r14.getCurNavigator()
            if (r1 == 0) goto L_0x0025
            com.didi.dimina.container.page.IPageHost r1 = r1.getCurrentPage()
            if (r1 == 0) goto L_0x0025
            com.didi.dimina.container.page.DMPage r1 = r1.getPage()
            if (r1 == 0) goto L_0x0025
            com.didi.dimina.container.bean.NavigateConfig r1 = r1.getNavigateConfig()
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.url
            goto L_0x0026
        L_0x0025:
            r1 = r0
        L_0x0026:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "entryType"
            java.lang.String r4 = "render"
            r2.put(r3, r4)
            java.lang.String r4 = "name"
            java.lang.String r5 = "firstRender"
            r2.put(r4, r5)
            if (r14 == 0) goto L_0x0040
            com.didi.dimina.container.mina.DMMinaPerformance r5 = r14.getPerformance()
            goto L_0x0041
        L_0x0040:
            r5 = r0
        L_0x0041:
            java.lang.String r6 = "dmMina?.performance"
            java.lang.String r7 = "duration"
            java.lang.String r8 = "startTime"
            if (r5 == 0) goto L_0x0088
            if (r14 == 0) goto L_0x0067
            com.didi.dimina.container.mina.DMMinaNavigatorDelegate r5 = r14.getCurNavigator()
            if (r5 == 0) goto L_0x0067
            com.didi.dimina.container.page.IPageHost r5 = r5.getCurrentPage()
            if (r5 == 0) goto L_0x0067
            com.didi.dimina.container.page.DMPage r5 = r5.getPage()
            if (r5 == 0) goto L_0x0067
            long r9 = r5.getRenderStartTime()
            java.lang.Long r5 = java.lang.Long.valueOf(r9)
            goto L_0x0068
        L_0x0067:
            r5 = r0
        L_0x0068:
            r2.put(r8, r5)
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r9 = java.lang.System.nanoTime()
            long r9 = r5.toMillis(r9)
            if (r14 == 0) goto L_0x007c
            com.didi.dimina.container.mina.DMMinaPerformance r5 = r14.getPerformance()
            goto L_0x007d
        L_0x007c:
            r5 = r0
        L_0x007d:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            long r11 = r5.getCurPageChangeTime()
            long r9 = r9 - r11
            r2.put(r7, r9)
        L_0x0088:
            java.lang.String r5 = "path"
            r2.put(r5, r1)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r10 = "navigation"
            r9.put(r3, r10)
            java.lang.String r3 = "route"
            r9.put(r4, r3)
            if (r14 == 0) goto L_0x00a3
            com.didi.dimina.container.mina.DMMinaPerformance r3 = r14.getPerformance()
            goto L_0x00a4
        L_0x00a3:
            r3 = r0
        L_0x00a4:
            if (r3 == 0) goto L_0x00d6
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r10 = java.lang.System.nanoTime()
            long r3 = r3.toMillis(r10)
            if (r14 == 0) goto L_0x00b7
            com.didi.dimina.container.mina.DMMinaPerformance r10 = r14.getPerformance()
            goto L_0x00b8
        L_0x00b7:
            r10 = r0
        L_0x00b8:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r6)
            long r10 = r10.getCurPageChangeTime()
            long r3 = r3 - r10
            r9.put(r8, r3)
            if (r14 == 0) goto L_0x00d3
            com.didi.dimina.container.mina.DMMinaPerformance r3 = r14.getPerformance()
            if (r3 == 0) goto L_0x00d3
            long r3 = r3.getCurPageChangeTime()
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
        L_0x00d3:
            r9.put(r7, r0)
        L_0x00d6:
            r9.put(r5, r1)
            java.lang.String r0 = "performanceEntries"
            if (r14 == 0) goto L_0x00e6
            com.didi.dimina.container.messager.DMMessageTransfer r1 = r14.getMessageTransfer()
            if (r1 == 0) goto L_0x00e6
            r1.sendMessageToServiceFromNative(r0, r2)
        L_0x00e6:
            if (r14 == 0) goto L_0x00f1
            com.didi.dimina.container.messager.DMMessageTransfer r14 = r14.getMessageTransfer()
            if (r14 == 0) goto L_0x00f1
            r14.sendMessageToServiceFromNative(r0, r9)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.pushpage.DiminaPushPageHelper.m12970c(com.didi.dimina.container.DMMina):void");
    }
}
