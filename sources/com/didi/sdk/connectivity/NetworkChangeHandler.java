package com.didi.sdk.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.List;

class NetworkChangeHandler {

    /* renamed from: a */
    private static final String f35749a = "connectivity";

    /* renamed from: b */
    private static String f35750b = "0-None";

    /* renamed from: c */
    private static volatile NetworkChangeHandler f35751c;

    /* renamed from: d */
    private final List<NetworkChangedCallback> f35752d = new ArrayList();

    interface NetworkChangedCallback {
        void onAvailable(Context context);

        void onLost(Context context);
    }

    NetworkChangeHandler() {
    }

    /* renamed from: a */
    static NetworkChangeHandler m25306a() {
        if (f35751c == null) {
            synchronized (NetworkChangeHandler.class) {
                if (f35751c == null) {
                    f35751c = new NetworkChangeHandler();
                }
            }
        }
        return f35751c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91468a(Context context) {
        f35750b = m25308d(context);
        m25309e(context);
    }

    /* renamed from: e */
    private void m25309e(final Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (Build.VERSION.SDK_INT >= 24 && (connectivityManager = (ConnectivityManager) context.getSystemService(f35749a)) != null) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(13);
                connectivityManager.registerNetworkCallback(builder.build(), new ConnectivityManager.NetworkCallback() {
                    public void onAvailable(Network network) {
                        super.onAvailable(network);
                        NetworkChangeHandler.this.mo91470b(context);
                    }

                    public void onLost(Network network) {
                        super.onLost(network);
                        NetworkChangeHandler.this.mo91472c(context);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo91470b(Context context) {
        try {
            String d = m25308d(context);
            if (!TextUtils.isEmpty(d) && !d.equals(f35750b)) {
                f35750b = d;
                m25310f(context);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: f */
    private void m25310f(Context context) {
        ArrayList<NetworkChangedCallback> arrayList = new ArrayList<>();
        synchronized (this.f35752d) {
            arrayList.addAll(this.f35752d);
        }
        for (NetworkChangedCallback onAvailable : arrayList) {
            onAvailable.onAvailable(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo91472c(Context context) {
        if (!"0-None".equals(f35750b)) {
            f35750b = "0-None";
            m25311g(context);
        }
    }

    /* renamed from: g */
    private void m25311g(Context context) {
        ArrayList<NetworkChangedCallback> arrayList = new ArrayList<>();
        synchronized (this.f35752d) {
            arrayList.addAll(this.f35752d);
        }
        for (NetworkChangedCallback onLost : arrayList) {
            onLost.onLost(context);
        }
    }

    /* renamed from: d */
    static String m25308d(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            int a = C12170f.m25335a(context);
            if (a == 0) {
                sb.append("0-None");
            } else if (a == 1) {
                sb.append("1-");
                sb.append(m25307a(C12170f.m25338c(context)));
            } else {
                sb.append("2-");
                sb.append(C12170f.m25337b(context));
                sb.append("-");
                if (a == 2) {
                    sb.append("2G");
                } else if (a == 3) {
                    sb.append("3G");
                } else if (a == 4) {
                    sb.append("4G");
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m25307a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.startsWith(Const.jsQuote)) {
            sb.deleteCharAt(0);
        }
        if (str.endsWith(Const.jsQuote)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91469a(NetworkChangedCallback networkChangedCallback) {
        synchronized (this.f35752d) {
            this.f35752d.add(networkChangedCallback);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo91471b(NetworkChangedCallback networkChangedCallback) {
        synchronized (this.f35752d) {
            this.f35752d.remove(networkChangedCallback);
        }
    }
}
