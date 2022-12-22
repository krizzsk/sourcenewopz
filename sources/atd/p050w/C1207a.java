package atd.p050w;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import atd.p025i.C1051c;
import atd.p025i.C1053d;
import atd.p046s0.C1172a;
import java.util.Collections;
import java.util.List;

/* renamed from: atd.w.a */
abstract class C1207a extends C1053d {
    C1207a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<String> mo13784b() {
        return Collections.singletonList(C1172a.m764a(-36722423712430L));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public WifiInfo mo13965d(Context context) throws C1051c {
        WifiInfo connectionInfo = mo13966e(context).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo;
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public WifiManager mo13966e(Context context) throws C1051c {
        WifiManager wifiManager = (WifiManager) context.getSystemService(C1172a.m764a(-36881337502382L));
        if (wifiManager != null) {
            return wifiManager;
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
