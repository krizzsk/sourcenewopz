package com.didiglobal.p205sa.biz.component.xengine.commit;

import android.content.Context;
import android.text.TextUtils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.xengine.XEngine;
import com.didi.xengine.request.XECommitBizParams;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/commit/SAXECommitRouter;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "createCommonParams", "", "", "", "scene", "engineCommit", "", "context", "Landroid/content/Context;", "commitParams", "Lcom/didi/xengine/request/XECommitBizParams;", "handle", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "Companion", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.commit.SAXECommitRouter */
/* compiled from: SAXECommitRouter.kt */
public final class SAXECommitRouter implements IRouterHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_BLOCK_COMMIT_AUTO_ROUTE = "key_block_commit_auto_route";
    public static final String KEY_BUTTON_TYPE = "KEY_BUTTON_TYPE";
    public static final String KEY_CALLBACK_BODY = "KEY_CALLBACK";
    public static final String KEY_CALLBACK_TYPE = "KEY_CALLBACK_TYPE";
    public static final String KEY_COMMIT_ID = "KEY_COMMIT_ID";
    public static final String KEY_COMMIT_SCENE = "KEY_COMMIT_SCENE";
    public static final String KEY_ERRNO = "KEY_ERRNO";
    public static final String KEY_REQUEST_KEY = "KEY_REQUEST_KEY";

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handle(com.didi.drouter.router.Request r9, com.didi.drouter.router.Result r10) {
        /*
            r8 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.didi.xengine.request.XECommitBizParams r0 = new com.didi.xengine.request.XECommitBizParams
            r0.<init>()
            android.net.Uri r1 = r9.getUri()
            java.lang.String r2 = "request.uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "query"
            java.lang.String r2 = r1.getQueryParameter(r2)
            java.lang.String r3 = "next_action"
            java.lang.String r1 = r1.getQueryParameter(r3)
            r3 = 1
            java.lang.String r4 = "KEY_BUTTON_TYPE"
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r5 = "request.getString(KEY_BUTTON_TYPE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x0039 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0039 }
            if (r4 != r3) goto L_0x0037
            goto L_0x003d
        L_0x0037:
            r3 = 0
            goto L_0x003d
        L_0x0039:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003d:
            java.lang.String r4 = "KEY_COMMIT_SCENE"
            java.lang.String r4 = r9.getString(r4)
            java.lang.String r5 = "key_block_commit_auto_route"
            boolean r5 = r9.getBoolean(r5)
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0055
            java.lang.String r1 = ""
            goto L_0x0058
        L_0x0055:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
        L_0x0058:
            com.google.gson.JsonParser r6 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x006b }
            r6.<init>()     // Catch:{ Exception -> 0x006b }
            com.google.gson.JsonElement r6 = r6.parse((java.lang.String) r2)     // Catch:{ Exception -> 0x006b }
            com.google.gson.JsonObject r6 = r6.getAsJsonObject()     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = "{\n            JsonParser…y).asJsonObject\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x006b }
            goto L_0x0083
        L_0x006b:
            com.google.gson.JsonParser r6 = new com.google.gson.JsonParser     // Catch:{ UnsupportedEncodingException -> 0x00fb }
            r6.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00fb }
            java.lang.String r7 = "utf-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r7)     // Catch:{ UnsupportedEncodingException -> 0x00fb }
            com.google.gson.JsonElement r2 = r6.parse((java.lang.String) r2)     // Catch:{ UnsupportedEncodingException -> 0x00fb }
            com.google.gson.JsonObject r6 = r2.getAsJsonObject()     // Catch:{ UnsupportedEncodingException -> 0x00fb }
            java.lang.String r2 = "{\n            try {\n    …n\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
        L_0x0083:
            r0.commitModel = r6
            r0.scene = r4
            java.lang.String r2 = "KEY_COMMIT_ID"
            java.lang.String r2 = r9.getString(r2)
            com.google.gson.JsonObject r4 = r0.commitModel
            java.lang.String r6 = "id"
            com.google.gson.JsonElement r4 = r4.get(r6)
            if (r4 != 0) goto L_0x00a5
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00a5
            com.google.gson.JsonObject r4 = r0.commitModel
            r4.addProperty((java.lang.String) r6, (java.lang.String) r2)
        L_0x00a5:
            if (r3 != 0) goto L_0x00be
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00bb
            com.didi.drouter.router.Request r1 = com.didi.drouter.api.DRouter.build((java.lang.String) r1)
            android.content.Context r2 = r9.getContext()
            r1.start(r2)
        L_0x00bb:
            com.didi.drouter.router.RouterHelper.release((com.didi.drouter.router.Request) r9)
        L_0x00be:
            com.didiglobal.sa.biz.component.xengine.commit.SAXECommitRouter$handle$1 r1 = new com.didiglobal.sa.biz.component.xengine.commit.SAXECommitRouter$handle$1
            r1.<init>(r3, r10, r5, r9)
            com.didiglobal.enginecore.XEngineCommitCallback r1 = (com.didiglobal.enginecore.XEngineCommitCallback) r1
            r0.callback = r1
            com.didiglobal.sa.biz.component.xengine.lifecycle.SAXEngineLifeCycle r10 = com.didiglobal.p205sa.biz.component.xengine.lifecycle.SAXEngineLifeCycle.INSTANCE
            boolean r10 = r10.isServiceEngineActive()
            if (r10 == 0) goto L_0x00e6
            com.didi.component.never.core.event.BaseEventPublisher r9 = com.didi.component.never.core.event.BaseEventPublisher.getPublisher()
            java.lang.String r10 = "SA_EVENT_XENGINE_COMMIT"
            r9.publish(r10, r0)
            r1 = 6
            r4 = 0
            r6 = 106(0x6a, float:1.49E-43)
            java.lang.String r2 = "tagtagtag"
            java.lang.String r3 = "commit as event "
            java.lang.String r5 = "com.didiglobal.sa.biz.component.xengine.commit.SAXECommitRouter"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            goto L_0x00fa
        L_0x00e6:
            android.content.Context r9 = r9.getContext()
            r8.m36673a(r9, r0)
            r1 = 6
            r4 = 0
            r6 = 109(0x6d, float:1.53E-43)
            java.lang.String r2 = "tagtagtag"
            java.lang.String r3 = "commit as independent request "
            java.lang.String r5 = "com.didiglobal.sa.biz.component.xengine.commit.SAXECommitRouter"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x00fa:
            return
        L_0x00fb:
            r9 = move-exception
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.xengine.commit.SAXECommitRouter.handle(com.didi.drouter.router.Request, com.didi.drouter.router.Result):void");
    }

    /* renamed from: a */
    private final void m36673a(Context context, XECommitBizParams xECommitBizParams) {
        if (xECommitBizParams != null) {
            new XEngine(SAXEngineConstants.SA_XENGINE_TYPE).commitRequest(context, xECommitBizParams, m36672a("sa_home"));
        }
    }

    /* renamed from: a */
    private final Map<String, Object> m36672a(String str) {
        Map<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("scene", str);
        }
        return hashMap;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/commit/SAXECommitRouter$Companion;", "", "()V", "KEY_BLOCK_COMMIT_AUTO_ROUTE", "", "KEY_BUTTON_TYPE", "KEY_CALLBACK_BODY", "KEY_CALLBACK_TYPE", "KEY_COMMIT_ID", "KEY_COMMIT_SCENE", "KEY_ERRNO", "KEY_REQUEST_KEY", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.component.xengine.commit.SAXECommitRouter$Companion */
    /* compiled from: SAXECommitRouter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
