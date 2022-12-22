package com.didiglobal.common.common.router;

import com.didi.drouter.router.IRouterHandler;

public class XECommitRouter implements IRouterHandler {
    public static final String KEY_BLOCK_COMMIT_AUTO_ROUTE = "key_block_commit_auto_route";
    public static final String KEY_BUTTON_TYPE = "KEY_BUTTON_TYPE";
    public static final String KEY_CALLBACK_BODY = "KEY_CALLBACK";
    public static final String KEY_CALLBACK_TYPE = "KEY_CALLBACK_TYPE";
    public static final String KEY_COMMIT_ID = "KEY_COMMIT_ID";
    public static final String KEY_COMMIT_SCENE = "KEY_COMMIT_SCENE";
    public static final String KEY_ERRNO = "KEY_ERRNO";
    public static final String KEY_REQUEST_KEY = "KEY_REQUEST_KEY";

    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2 = new com.google.gson.JsonParser().parse(java.net.URLDecoder.decode(r2, "utf-8")).getAsJsonObject();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00aa, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ab, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handle(com.didi.drouter.router.Request r12, com.didi.drouter.router.Result r13) {
        /*
            r11 = this;
            com.didi.xengine.request.XECommitBizParams r0 = new com.didi.xengine.request.XECommitBizParams
            r0.<init>()
            android.net.Uri r1 = r12.getUri()
            java.lang.String r2 = "query"
            java.lang.String r2 = r1.getQueryParameter(r2)
            java.lang.String r3 = "next_action"
            java.lang.String r1 = r1.getQueryParameter(r3)
            r3 = 1
            java.lang.String r4 = "KEY_BUTTON_TYPE"
            java.lang.String r4 = r12.getString(r4)     // Catch:{ Exception -> 0x0026 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0026 }
            if (r4 != r3) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            r7 = r3
            goto L_0x002b
        L_0x0026:
            r4 = move-exception
            r4.printStackTrace()
            r7 = 1
        L_0x002b:
            java.lang.String r3 = "KEY_COMMIT_SCENE"
            java.lang.String r3 = r12.getString(r3)
            java.lang.String r4 = "key_block_commit_auto_route"
            boolean r9 = r12.getBoolean(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x003f
            java.lang.String r1 = ""
        L_0x003f:
            com.google.gson.JsonParser r4 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x004d }
            r4.<init>()     // Catch:{ Exception -> 0x004d }
            com.google.gson.JsonElement r4 = r4.parse((java.lang.String) r2)     // Catch:{ Exception -> 0x004d }
            com.google.gson.JsonObject r2 = r4.getAsJsonObject()     // Catch:{ Exception -> 0x004d }
            goto L_0x0060
        L_0x004d:
            com.google.gson.JsonParser r4 = new com.google.gson.JsonParser     // Catch:{ UnsupportedEncodingException -> 0x00aa }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00aa }
            java.lang.String r5 = "utf-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r5)     // Catch:{ UnsupportedEncodingException -> 0x00aa }
            com.google.gson.JsonElement r2 = r4.parse((java.lang.String) r2)     // Catch:{ UnsupportedEncodingException -> 0x00aa }
            com.google.gson.JsonObject r2 = r2.getAsJsonObject()     // Catch:{ UnsupportedEncodingException -> 0x00aa }
        L_0x0060:
            r0.commitModel = r2
            r0.scene = r3
            java.lang.String r2 = "KEY_COMMIT_ID"
            java.lang.String r2 = r12.getString(r2)
            com.google.gson.JsonObject r3 = r0.commitModel
            java.lang.String r4 = "id"
            com.google.gson.JsonElement r3 = r3.get(r4)
            if (r3 != 0) goto L_0x007f
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x007f
            com.google.gson.JsonObject r3 = r0.commitModel
            r3.addProperty((java.lang.String) r4, (java.lang.String) r2)
        L_0x007f:
            if (r7 != 0) goto L_0x0095
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0092
            com.didi.drouter.router.Request r1 = com.didi.drouter.api.DRouter.build((java.lang.String) r1)
            android.content.Context r2 = r12.getContext()
            r1.start(r2)
        L_0x0092:
            com.didi.drouter.router.RouterHelper.release((com.didi.drouter.router.Request) r12)
        L_0x0095:
            com.didiglobal.common.common.router.XECommitRouter$1 r1 = new com.didiglobal.common.common.router.XECommitRouter$1
            r5 = r1
            r6 = r11
            r8 = r13
            r10 = r12
            r5.<init>(r7, r8, r9, r10)
            r0.callback = r1
            com.didi.component.never.core.event.BaseEventPublisher r12 = com.didi.component.never.core.event.BaseEventPublisher.getPublisher()
            java.lang.String r13 = "event_xengine_commit"
            r12.publish(r13, r0)
            return
        L_0x00aa:
            r12 = move-exception
            r12.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.common.common.router.XECommitRouter.handle(com.didi.drouter.router.Request, com.didi.drouter.router.Result):void");
    }
}
