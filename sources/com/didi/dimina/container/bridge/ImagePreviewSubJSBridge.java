package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.p106ui.dialog.ImagePreviewDialog;
import com.didi.dimina.container.util.LogUtil;

public class ImagePreviewSubJSBridge {

    /* renamed from: a */
    private final Activity f16571a;

    /* renamed from: b */
    private ImagePreviewDialog f16572b;

    /* renamed from: c */
    private final DMMina f16573c;

    /* renamed from: d */
    private final DMSandboxHelper f16574d;

    public ImagePreviewSubJSBridge(DMMina dMMina, Activity activity) {
        this.f16571a = activity;
        this.f16573c = dMMina;
        this.f16574d = new DMSandboxHelper(dMMina.getConfig());
        LogUtil.m13411i("ImagePreviewSubJSBridge init");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startImagePreviewActivity(org.json.JSONObject r8, com.didi.dimina.container.bridge.base.CallbackFunction r9) {
        /*
            r7 = this;
            java.lang.String r0 = "urls"
            org.json.JSONArray r0 = r8.optJSONArray(r0)
            java.lang.String r1 = "current"
            java.lang.String r1 = r8.optString(r1)
            java.lang.String r2 = "showmenu"
            r3 = 1
            boolean r8 = r8.optBoolean(r2, r3)
            if (r0 == 0) goto L_0x0094
            int r2 = r0.length()
            if (r2 != 0) goto L_0x001d
            goto L_0x0094
        L_0x001d:
            java.lang.String r1 = r7.m12189a(r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            r4 = 0
        L_0x0028:
            int r5 = r0.length()
            if (r4 >= r5) goto L_0x005a
            java.lang.String r5 = r0.optString(r4)
            java.lang.String r5 = r7.m12189a(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0057
            java.lang.String r6 = "difile://"
            boolean r6 = r5.startsWith(r6)
            if (r6 == 0) goto L_0x0054
            com.didi.dimina.container.mina.DMSandboxHelper r6 = r7.f16574d
            java.lang.String r5 = r6.url2filepath(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0057
            r2.add(r5)
            goto L_0x0057
        L_0x0054:
            r2.add(r5)
        L_0x0057:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x005a:
            boolean r0 = com.didi.dimina.container.util.TextUtil.isEmpty(r1)
            if (r0 == 0) goto L_0x006d
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x006d
            java.lang.Object r0 = r2.get(r3)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x006d:
            com.didi.dimina.container.ui.dialog.ImagePreviewDialog r0 = r7.f16572b
            if (r0 != 0) goto L_0x007c
            com.didi.dimina.container.ui.dialog.ImagePreviewDialog r0 = new com.didi.dimina.container.ui.dialog.ImagePreviewDialog
            com.didi.dimina.container.DMMina r3 = r7.f16573c
            android.app.Activity r4 = r7.f16571a
            r0.<init>(r3, r4)
            r7.f16572b = r0
        L_0x007c:
            android.app.Activity r0 = r7.f16571a
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x0090
            com.didi.dimina.container.ui.dialog.ImagePreviewDialog r0 = r7.f16572b
            if (r0 == 0) goto L_0x0090
            com.didi.sdk.apm.SystemUtils.showDialog(r0)
            com.didi.dimina.container.ui.dialog.ImagePreviewDialog r0 = r7.f16572b
            r0.initView(r2, r1, r8)
        L_0x0090:
            com.didi.dimina.container.util.CallBackUtil.onSuccess(r9)
            return
        L_0x0094:
            java.lang.String r8 = "current或者urls为空"
            com.didi.dimina.container.util.CallBackUtil.onFail(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.ImagePreviewSubJSBridge.startImagePreviewActivity(org.json.JSONObject, com.didi.dimina.container.bridge.base.CallbackFunction):void");
    }

    /* renamed from: a */
    private String m12189a(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(DMSandboxHelper.VIRTUAL_DOMAIN_URL)) {
            String url2filepath = this.f16574d.url2filepath(str);
            if (!TextUtils.isEmpty(url2filepath)) {
                return url2filepath;
            }
        }
        return str;
    }
}
