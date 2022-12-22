package com.facebook.appevents.codeless;

import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/facebook/appevents/codeless/ViewIndexer$schedule$indexingTask$1", "Ljava/util/TimerTask;", "run", "", "facebook-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewIndexer.kt */
public final class ViewIndexer$schedule$indexingTask$1 extends TimerTask {
    final /* synthetic */ ViewIndexer this$0;

    ViewIndexer$schedule$indexingTask$1(ViewIndexer viewIndexer) {
        this.this$0 = viewIndexer;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0097 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            com.facebook.appevents.codeless.ViewIndexer r0 = r10.this$0     // Catch:{ Exception -> 0x00b6 }
            java.lang.ref.WeakReference r0 = com.facebook.appevents.codeless.ViewIndexer.access$getActivityReference$p(r0)     // Catch:{ Exception -> 0x00b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x00b6 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x00b6 }
            com.facebook.appevents.internal.AppEventUtility r1 = com.facebook.appevents.internal.AppEventUtility.INSTANCE     // Catch:{ Exception -> 0x00b6 }
            android.view.View r1 = com.facebook.appevents.internal.AppEventUtility.getRootView(r0)     // Catch:{ Exception -> 0x00b6 }
            if (r0 == 0) goto L_0x00b5
            if (r1 != 0) goto L_0x0018
            goto L_0x00b5
        L_0x0018:
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = "activity.javaClass.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x00b6 }
            com.facebook.appevents.codeless.CodelessManager r2 = com.facebook.appevents.codeless.CodelessManager.INSTANCE     // Catch:{ Exception -> 0x00b6 }
            boolean r2 = com.facebook.appevents.codeless.CodelessManager.getIsAppIndexingEnabled$facebook_core_release()     // Catch:{ Exception -> 0x00b6 }
            if (r2 != 0) goto L_0x002e
            return
        L_0x002e:
            com.facebook.internal.InternalSettings r2 = com.facebook.internal.InternalSettings.INSTANCE     // Catch:{ Exception -> 0x00b6 }
            boolean r2 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x00b6 }
            if (r2 == 0) goto L_0x003c
            com.facebook.appevents.codeless.internal.UnityReflection r0 = com.facebook.appevents.codeless.internal.UnityReflection.INSTANCE     // Catch:{ Exception -> 0x00b6 }
            com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x00b6 }
            return
        L_0x003c:
            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x00b6 }
            com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r3 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x00b6 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00b6 }
            java.util.concurrent.Callable r3 = (java.util.concurrent.Callable) r3     // Catch:{ Exception -> 0x00b6 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00b6 }
            com.facebook.appevents.codeless.ViewIndexer r3 = r10.this$0     // Catch:{ Exception -> 0x00b6 }
            android.os.Handler r3 = com.facebook.appevents.codeless.ViewIndexer.access$getUiThreadHandler$p(r3)     // Catch:{ Exception -> 0x00b6 }
            r4 = r2
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch:{ Exception -> 0x00b6 }
            r3.post(r4)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r3 = ""
            r4 = 1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0062 }
            java.lang.Object r2 = r2.get(r4, r6)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0062 }
            r3 = r2
            goto L_0x0074
        L_0x0062:
            r2 = move-exception
            java.lang.String r5 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "Failed to take screenshot."
            r7 = r2
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ Exception -> 0x00b6 }
            r4 = 6
            java.lang.String r8 = "com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1"
            r9 = 96
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00b6 }
        L_0x0074:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b6 }
            r2.<init>()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r4 = "screenname"
            r2.put(r4, r0)     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r0 = "screenshot"
            r2.put(r0, r3)     // Catch:{ JSONException -> 0x0097 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0097 }
            r0.<init>()     // Catch:{ JSONException -> 0x0097 }
            com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ JSONException -> 0x0097 }
            org.json.JSONObject r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r1)     // Catch:{ JSONException -> 0x0097 }
            r0.put(r1)     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = "view"
            r2.put(r1, r0)     // Catch:{ JSONException -> 0x0097 }
            goto L_0x00a6
        L_0x0097:
            java.lang.String r4 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r5 = "Failed to create JSONObject"
            r3 = 6
            r6 = 0
            java.lang.String r7 = "com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1"
            r8 = 107(0x6b, float:1.5E-43)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b6 }
        L_0x00a6:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r1 = "viewTree.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x00b6 }
            com.facebook.appevents.codeless.ViewIndexer r1 = r10.this$0     // Catch:{ Exception -> 0x00b6 }
            com.facebook.appevents.codeless.ViewIndexer.access$sendToServer(r1, r0)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00c8
        L_0x00b5:
            return
        L_0x00b6:
            r0 = move-exception
            java.lang.String r2 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()
            r4 = r0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r1 = 6
            r6 = 112(0x70, float:1.57E-43)
            java.lang.String r3 = "UI Component tree indexing failure!"
            java.lang.String r5 = "com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1.run():void");
    }
}
