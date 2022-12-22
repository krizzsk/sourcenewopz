package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didichuxing.dfbasesdk.webview.DFWebviewAct;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class WebviewActUtils {
    private WebviewActUtils() {
    }

    public static void toWebviewAct(Context context, String str) {
        toWebviewAct(context, str, "");
    }

    public static void toWebviewAct(Context context, String str, String str2) {
        Intent createWebviewActIntent = createWebviewActIntent(str);
        createWebviewActIntent.putExtra("sceneType", str2);
        toWebviewAct(context, createWebviewActIntent);
    }

    public static Intent createWebviewActIntent(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse("diface://viewwebpage").buildUpon().appendQueryParameter("url", str).build());
    }

    public static void toWebviewAct(Context context, Intent intent) {
        intent.setPackage(WsgSecInfo.packageName(context));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void toWebViewExplicit(Context context, String str) {
        Intent intent = new Intent(context, DFWebviewAct.class);
        intent.putExtra("webUrl", str);
        toWebviewAct(context, intent);
    }
}
