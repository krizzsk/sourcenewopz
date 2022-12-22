package com.didichuxing.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.foundation.net.UnsupportedSchemeException;
import java.lang.reflect.Proxy;

public class RpcServiceFactory {
    public static final String DISABLE_CERTIFICATE_VERIFICATION = "disable";
    public static final String PROPERTY_CERTIFICATE_VERIFICATION = "rpc.certificate.verification";

    /* renamed from: a */
    final C15584b f47619a;

    /* renamed from: b */
    private final Context f47620b;

    public RpcServiceFactory(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f47620b = applicationContext;
        this.f47619a = new C15584b(applicationContext);
    }

    public Context getContext() {
        return this.f47620b;
    }

    public <T extends RpcClient<? extends RpcRequest, ? extends RpcResponse>> T getRpcClient(String str) throws UnsupportedSchemeException {
        return this.f47619a.mo117359a(Uri.parse(str + HWMapConstant.HTTP.SEPARATOR));
    }

    public <T extends RpcService> T newRpcService(Class<T> cls, String str) {
        return mo117330a(cls, Uri.parse(str), (Object) null);
    }

    public <T extends RpcService> T newRpcService(Class<T> cls, Uri uri) {
        return mo117330a(cls, uri, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T extends RpcService> T mo117330a(Class<T> cls, Uri uri, Object obj) {
        return (RpcService) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C15585c(this, cls, uri, obj));
    }
}
