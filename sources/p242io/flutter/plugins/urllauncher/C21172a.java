package p242io.flutter.plugins.urllauncher;

import android.os.Bundle;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import java.util.Map;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugins.urllauncher.UrlLauncher;

/* renamed from: io.flutter.plugins.urllauncher.a */
/* compiled from: MethodCallHandlerImpl */
final class C21172a implements MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private static final String f57922a = "MethodCallHandlerImpl";

    /* renamed from: b */
    private final UrlLauncher f57923b;

    /* renamed from: c */
    private MethodChannel f57924c;

    C21172a(UrlLauncher urlLauncher) {
        this.f57923b = urlLauncher;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r7, p242io.flutter.plugin.common.MethodChannel.Result r8) {
        /*
            r6 = this;
            java.lang.String r0 = "url"
            java.lang.Object r0 = r7.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = r7.method
            int r2 = r1.hashCode()
            r3 = -1109843021(0xffffffffbdd923b3, float:-0.10602512)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x0034
            r3 = -185306205(0xfffffffff4f473a3, float:-1.5493968E32)
            if (r2 == r3) goto L_0x002a
            r3 = -121617663(0xfffffffff8c04301, float:-3.119625E34)
            if (r2 == r3) goto L_0x0020
            goto L_0x003e
        L_0x0020:
            java.lang.String r2 = "closeWebView"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003e
            r1 = 2
            goto L_0x003f
        L_0x002a:
            java.lang.String r2 = "canLaunch"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003e
            r1 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r2 = "launch"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = -1
        L_0x003f:
            if (r1 == 0) goto L_0x0051
            if (r1 == r5) goto L_0x004d
            if (r1 == r4) goto L_0x0049
            r8.notImplemented()
            goto L_0x0054
        L_0x0049:
            r6.m41700a((p242io.flutter.plugin.common.MethodChannel.Result) r8)
            goto L_0x0054
        L_0x004d:
            r6.m41699a(r7, r8, r0)
            goto L_0x0054
        L_0x0051:
            r6.m41701a(r8, r0)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.plugins.urllauncher.C21172a.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172927a(BinaryMessenger binaryMessenger) {
        if (this.f57924c != null) {
            Log.wtf(f57922a, "Setting a method call handler before the last was disposed.");
            mo172926a();
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/url_launcher");
        this.f57924c = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172926a() {
        MethodChannel methodChannel = this.f57924c;
        if (methodChannel == null) {
            SystemUtils.log(3, f57922a, "Tried to stop listening when no MethodChannel had been initialized.", (Throwable) null, "io.flutter.plugins.urllauncher.MethodCallHandlerImpl", 71);
            return;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f57924c = null;
    }

    /* renamed from: a */
    private void m41701a(MethodChannel.Result result, String str) {
        result.success(Boolean.valueOf(this.f57923b.mo172916a(str)));
    }

    /* renamed from: a */
    private void m41699a(MethodCall methodCall, MethodChannel.Result result, String str) {
        boolean booleanValue = ((Boolean) methodCall.argument("useWebView")).booleanValue();
        boolean booleanValue2 = ((Boolean) methodCall.argument("enableJavaScript")).booleanValue();
        boolean booleanValue3 = ((Boolean) methodCall.argument("enableDomStorage")).booleanValue();
        UrlLauncher.LaunchStatus a = this.f57923b.mo172913a(str, m41698a((Map<String, String>) (Map) methodCall.argument(ErrorConst.ErrorParam.HEADERS)), booleanValue, booleanValue2, booleanValue3);
        if (a == UrlLauncher.LaunchStatus.NO_ACTIVITY) {
            result.error("NO_ACTIVITY", "Launching a URL requires a foreground activity.", (Object) null);
        } else if (a == UrlLauncher.LaunchStatus.ACTIVITY_NOT_FOUND) {
            result.error("ACTIVITY_NOT_FOUND", String.format("No Activity found to handle intent { %s }", new Object[]{str}), (Object) null);
        } else {
            result.success(true);
        }
    }

    /* renamed from: a */
    private void m41700a(MethodChannel.Result result) {
        this.f57923b.mo172914a();
        result.success((Object) null);
    }

    /* renamed from: a */
    private static Bundle m41698a(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        return bundle;
    }
}
