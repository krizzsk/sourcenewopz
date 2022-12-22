package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract class AFEvent {

    /* renamed from: ı */
    WeakReference<Context> f1734;

    /* renamed from: Ɩ */
    public String f1735;

    /* renamed from: ǃ */
    public Intent f1736;

    /* renamed from: ȷ */
    boolean f1737;

    /* renamed from: ɨ */
    public int f1738;

    /* renamed from: ɩ */
    AppsFlyerTrackingRequestListener f1739;

    /* renamed from: ɪ */
    private Map<String, Object> f1740;

    /* renamed from: ɹ */
    String f1741;

    /* renamed from: ɾ */
    private final boolean f1742;

    /* renamed from: ɿ */
    private byte[] f1743;

    /* renamed from: Ι */
    Map<String, Object> f1744;

    /* renamed from: ι */
    Context f1745;

    /* renamed from: І */
    String f1746;

    /* renamed from: і */
    String f1747;

    /* renamed from: Ӏ */
    String f1748;

    /* renamed from: ӏ */
    private String f1749;

    public AFEvent() {
        this((String) null, (Boolean) null, (Context) null);
    }

    public AFEvent(String str, Boolean bool, Context context) {
        this.f1748 = str;
        this.f1742 = bool != null ? bool.booleanValue() : true;
        this.f1745 = context;
    }

    /* access modifiers changed from: protected */
    public AFEvent context(Context context) {
        this.f1745 = context;
        return this;
    }

    public Context context() {
        Context context = this.f1745;
        if (context != null) {
            return context;
        }
        WeakReference<Context> weakReference = this.f1734;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ǃ */
    public final AFEvent mo15926() {
        if (context() != null) {
            this.f1745 = context().getApplicationContext();
        }
        return this;
    }

    public AFEvent weakContext() {
        this.f1734 = new WeakReference<>(this.f1745);
        this.f1745 = null;
        return this;
    }

    public AFEvent urlString(String str) {
        this.f1747 = str;
        return this;
    }

    public String urlString() {
        return this.f1747;
    }

    public Intent intent() {
        return this.f1736;
    }

    public AFEvent key(String str) {
        this.f1749 = str;
        return this;
    }

    public String key() {
        return this.f1749;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Ι */
    public final boolean mo15927() {
        return this.f1737;
    }

    public AFEvent params(Map<String, ?> map) {
        this.f1740 = map;
        return this;
    }

    public Map<String, Object> params() {
        return this.f1740;
    }

    public AFEvent post(byte[] bArr) {
        this.f1743 = bArr;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ι */
    public final byte[] mo15928() {
        return this.f1743;
    }

    public boolean isEncrypt() {
        return this.f1742;
    }

    /* access modifiers changed from: protected */
    public String addChannel(String str) {
        String configuredChannel = AppsFlyerLibCore.getInstance().getConfiguredChannel(context());
        return configuredChannel != null ? Uri.parse(str).buildUpon().appendQueryParameter("channel", configuredChannel).build().toString() : str;
    }
}
