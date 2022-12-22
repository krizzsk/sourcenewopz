package com.didi.flutter.nacho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.HashMap;

public class Page {
    public static final int LAUNCH_MODE_SINGLE_CONTAINER_CLEAR_OTHER = 1;
    public static final int LAUNCH_MODE_STANDARD = 0;
    public static final String TAG_LAUNCH_MODE = "_nacho_launch_mode";
    public static final String TAG_ROUTER_NAME = "_nacho_routerName";
    private String engineId = Nacho.getInstance().cachedEngineId();
    private int launchMode = 0;
    private String[] names;

    public Page(String[] strArr) {
        this.names = strArr;
    }

    public Page(String str) {
        this.names = new String[]{str};
    }

    public Page(String str, int i) {
        this.names = new String[]{str};
        this.launchMode = i;
    }

    public Page(String str, String str2) {
        this.names = new String[]{str};
        this.engineId = str2;
    }

    public final String[] getNames() {
        return this.names;
    }

    public void doOpen(Context context, String str, String str2, HashMap hashMap) {
        openFlutterActivity(context, str, str2, hashMap);
    }

    /* access modifiers changed from: protected */
    public void openFlutterActivity(Context context, String str, String str2, HashMap hashMap) {
        Intent build = NachoFlutterActivity.withCachedEngine(NachoFlutterActivity.class).engineId(this.engineId).params(hashMap).initialRoute(str2).build(context);
        if (!(context instanceof Activity)) {
            build.addFlags(268435456);
        }
        build.putExtra(TAG_ROUTER_NAME, str);
        build.putExtra(TAG_LAUNCH_MODE, this.launchMode);
        context.startActivity(build);
        Nacho.getInstance().paddingOpenContainer();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openFlutterBottomSheetDialog(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.util.HashMap r7) {
        /*
            r3 = this;
            r5 = 0
            if (r7 == 0) goto L_0x0014
            java.lang.String r0 = "_nacho_height"
            java.lang.Object r0 = r7.get(r0)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0010 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x0010 }
            goto L_0x0015
        L_0x0010:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0014:
            r0 = 0
        L_0x0015:
            com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder r1 = com.didi.flutter.nacho.p114ui.FlutterBottomSheetDialogFragment.Builder()
            com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder r6 = r1.initialRoute(r6)
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0028
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 > 0) goto L_0x0028
            r5 = r0
        L_0x0028:
            com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder r5 = r6.heightRatio(r5)
            r6 = 0
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0033
            int r0 = (int) r0
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder r5 = r5.height(r0)
            com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder r5 = r5.blur(r6)
            com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder r5 = r5.params(r7)
            com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment r5 = r5.build()
            r5.show(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.flutter.nacho.Page.openFlutterBottomSheetDialog(android.content.Context, java.lang.String, java.lang.String, java.util.HashMap):void");
    }
}
