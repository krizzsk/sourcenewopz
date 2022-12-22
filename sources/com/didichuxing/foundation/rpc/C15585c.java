package com.didichuxing.foundation.rpc;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.net.DnsResolver;
import com.didichuxing.foundation.net.Transporter;
import com.didichuxing.foundation.net.X509CertificateTransporter;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.DnsResolution;
import com.didichuxing.foundation.rpc.annotation.InnerRetry;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Retry;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.didichuxing.foundation.rpc.annotation.Transportation;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.didichuxing.foundation.rpc.c */
/* compiled from: RpcServiceProxy */
class C15585c implements InvocationHandler {

    /* renamed from: h */
    private static final String f47630h = "RpcServiceProxy";

    /* renamed from: i */
    private static final Set<Method> f47631i = Collections.unmodifiableSet(new HashSet(Arrays.asList(Object.class.getMethods())));

    /* renamed from: j */
    private static final Map<String, Transporter> f47632j = new HashMap();

    /* renamed from: a */
    final RpcServiceFactory f47633a;

    /* renamed from: b */
    final Class<? extends RpcService> f47634b;

    /* renamed from: c */
    final Uri f47635c;

    /* renamed from: d */
    final Set<Method> f47636d = Collections.unmodifiableSet(new HashSet(Arrays.asList(this.f47634b.getMethods())));

    /* renamed from: e */
    final Object f47637e;

    /* renamed from: f */
    final Transporter f47638f;

    /* renamed from: g */
    final Handler f47639g;

    C15585c(RpcServiceFactory rpcServiceFactory, Class<? extends RpcService> cls, Uri uri, Object obj) {
        this.f47633a = rpcServiceFactory;
        this.f47634b = cls;
        this.f47635c = uri;
        this.f47637e = obj;
        this.f47638f = m34090a(cls);
        this.f47639g = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    private Transporter m34090a(Class<? extends RpcService> cls) {
        if (!cls.isAnnotationPresent(Transportation.class)) {
            return null;
        }
        try {
            Transportation transportation = (Transportation) cls.getAnnotation(Transportation.class);
            return m34091a(transportation.cert(), (Class<? extends Transporter>[]) transportation.value());
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (this.f47636d.contains(method)) {
            Class[] exceptionTypes = method.getExceptionTypes();
            try {
                return m34095a(obj, method, objArr);
            } catch (RuntimeException e) {
                throw e;
            } catch (Throwable th) {
                int length = exceptionTypes.length;
                int i = 0;
                while (i < length) {
                    if (!exceptionTypes[i].isAssignableFrom(th.getClass())) {
                        i++;
                    } else {
                        throw th;
                    }
                }
                throw new RuntimeException(th);
            }
        } else if (f47631i.contains(method)) {
            return method.invoke(this, objArr);
        } else {
            throw new NoSuchMethodException(method.toGenericString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15585c)) {
            return false;
        }
        C15585c cVar = (C15585c) obj;
        if (!this.f47634b.equals(cVar.f47634b) || !this.f47635c.equals(cVar.f47635c) || !this.f47636d.equals(cVar.f47636d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((16337 + this.f47634b.hashCode()) * 31) + this.f47635c.hashCode()) * 31) + this.f47636d.hashCode();
    }

    public String toString() {
        return "Proxy for " + this.f47634b.getName();
    }

    /* renamed from: a */
    private Object m34095a(Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2;
        Class<?> returnType = method.getReturnType();
        RpcClient.Builder newBuilder = this.f47633a.getRpcClient(this.f47635c.getScheme()).newBuilder();
        m34101d(method, newBuilder);
        m34100c(method, newBuilder);
        m34099b(method, newBuilder);
        m34098a(method, newBuilder);
        RpcClient build = newBuilder.build();
        Rpc newRpc = build.newRpc(build.newRequestBuilder().setUrl(this.f47635c.toString()).setRpcClient(build).setRpcService(this.f47634b, method, objArr).build());
        if (objArr != null && objArr.length > 0 && ((objArr[objArr.length - 1] instanceof RpcService.Callback) || (objArr[objArr.length - 1] instanceof RpcService.CallbackV2))) {
            RpcService.Callback callback = objArr[objArr.length - 1];
            ThreadType a = m34092a(method, objArr);
            if (callback instanceof RpcService.Callback) {
                obj2 = m34093a((Rpc<RpcRequest, RpcResponse>) newRpc, a, (RpcService.Callback<Object>) callback);
            } else {
                obj2 = m34094a((Rpc<RpcRequest, RpcResponse>) newRpc, a, (RpcService.CallbackV2<Object>) (RpcService.CallbackV2) callback);
            }
            if (Rpc.class.isAssignableFrom(returnType)) {
                return newRpc;
            }
        } else {
            obj2 = newRpc.execute().getContent();
        }
        if (Void.TYPE.equals(returnType) || Void.class.equals(returnType)) {
            return null;
        }
        return obj2;
    }

    /* renamed from: a */
    private Object m34093a(Rpc<RpcRequest, RpcResponse> rpc, ThreadType threadType, RpcService.Callback<Object> callback) {
        return rpc.enqueue(new RpcServiceProxy$1(this, threadType, callback));
    }

    /* renamed from: a */
    private Object m34094a(Rpc<RpcRequest, RpcResponse> rpc, ThreadType threadType, RpcService.CallbackV2<Object> callbackV2) {
        return rpc.enqueue(new RpcServiceProxy$2(this, threadType, callbackV2));
    }

    /* renamed from: a */
    private void m34098a(Method method, RpcClient.Builder builder) throws Throwable {
        Transportation transportation = (Transportation) method.getAnnotation(Transportation.class);
        Transporter a = transportation != null ? m34091a(transportation.cert().trim(), (Class<? extends Transporter>[]) transportation.value()) : this.f47638f;
        if (a != null) {
            SocketFactory socketFactory = a.getSocketFactory();
            if (socketFactory != null) {
                builder.setSocketFactory(socketFactory);
            }
            SSLSocketFactory sslSocketFactory = a.getSslSocketFactory();
            TrustManager trustManager = a.getTrustManager();
            if (!(sslSocketFactory == null || trustManager == null)) {
                builder.setSSLSocketFactory(sslSocketFactory, trustManager);
            }
            HostnameVerifier hostnameVerifier = a.getHostnameVerifier();
            if (hostnameVerifier != null) {
                builder.setHostnameVerifier(hostnameVerifier);
            }
        }
    }

    /* renamed from: a */
    private Transporter m34091a(String str, Class<? extends Transporter>[] clsArr) throws KeyManagementException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if ("file".equals(scheme) || "content".equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
                InputStream openInputStream = this.f47633a.getContext().getContentResolver().openInputStream(parse);
                try {
                    return new X509CertificateTransporter(openInputStream);
                } finally {
                    Streams.closeQuietly(openInputStream);
                }
            } else if (!str.startsWith("asset://")) {
                return new X509CertificateTransporter(str.getBytes());
            } else {
                InputStream open = this.f47633a.getContext().getResources().getAssets().open(str.substring(8));
                try {
                    return new X509CertificateTransporter(open);
                } finally {
                    Streams.closeQuietly(open);
                }
            }
        } else if (clsArr != null && clsArr.length > 0) {
            return (Transporter) clsArr[0].newInstance();
        } else {
            throw new IllegalArgumentException("cert and value cannot be empty at the same time");
        }
    }

    /* renamed from: b */
    private void m34099b(Method method, RpcClient.Builder builder) throws Throwable {
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = ServiceLoader.load(DnsResolver.class).iterator();
        while (it.hasNext()) {
            arrayList.add((DnsResolver) it.next());
        }
        if (method.isAnnotationPresent(DnsResolution.class)) {
            arrayList.add(((DnsResolution) method.getAnnotation(DnsResolution.class)).value().newInstance());
        }
        if (this.f47634b.isAnnotationPresent(DnsResolution.class)) {
            arrayList.add(((DnsResolution) this.f47634b.getAnnotation(DnsResolution.class)).value().newInstance());
        }
        int size = arrayList.size();
        if (size == 1) {
            builder.setDnsResolver((DnsResolver) arrayList.get(0));
        } else if (size > 1) {
            builder.setDnsResolver(new RpcServiceProxy$3(this, arrayList));
        }
    }

    /* renamed from: c */
    private void m34100c(Method method, RpcClient.Builder builder) {
        Retry retry;
        InnerRetry innerRetry;
        Timeout timeout;
        if (method.isAnnotationPresent(Retry.class)) {
            retry = (Retry) method.getAnnotation(Retry.class);
        } else {
            retry = (Retry) this.f47634b.getAnnotation(Retry.class);
        }
        if (retry != null && retry.value() > 0) {
            builder.addInterceptor(new RpcServiceProxy$4(this, Math.min(retry.value(), 10)));
        }
        if (method.isAnnotationPresent(InnerRetry.class)) {
            innerRetry = (InnerRetry) method.getAnnotation(InnerRetry.class);
        } else {
            innerRetry = (InnerRetry) this.f47634b.getAnnotation(InnerRetry.class);
        }
        if (innerRetry != null) {
            builder.setInnerRetryOnConnectionFailure(innerRetry.value());
        }
        if (method.isAnnotationPresent(Timeout.class)) {
            timeout = (Timeout) method.getAnnotation(Timeout.class);
        } else {
            timeout = (Timeout) this.f47634b.getAnnotation(Timeout.class);
        }
        if (timeout != null) {
            builder.setConnectTimeout(timeout.connectTimeout());
            builder.setReadTimeout(timeout.readTimeout());
            builder.setWriteTimeout(timeout.writeTimeout());
        }
    }

    /* renamed from: d */
    private void m34101d(Method method, RpcClient.Builder builder) throws InstantiationException, IllegalAccessException {
        Class[] value;
        Class[] value2;
        if (this.f47634b.isAnnotationPresent(Interception.class) && (value2 = ((Interception) this.f47634b.getAnnotation(Interception.class)).value()) != null) {
            for (Class newInstance : value2) {
                builder.addInterceptor((RpcInterceptor) newInstance.newInstance());
            }
        }
        if (method.isAnnotationPresent(Interception.class) && (value = ((Interception) method.getAnnotation(Interception.class)).value()) != null) {
            for (Class newInstance2 : value) {
                builder.addInterceptor((RpcInterceptor) newInstance2.newInstance());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34096a(RpcRequest rpcRequest, RpcService.Callback<Object> callback, IOException iOException) {
        if (C15583a.f47621a) {
            SystemUtils.log(6, f47630h, rpcRequest.getUrl(), iOException, "com.didichuxing.foundation.rpc.RpcServiceProxy", 481);
        }
        callback.onFailure(iOException);
    }

    /* renamed from: a */
    private ThreadType m34092a(Method method, Object... objArr) {
        for (Annotation annotation : method.getParameterAnnotations()[objArr.length - 1]) {
            if (TargetThread.class.equals(annotation.annotationType())) {
                return ((TargetThread) annotation).value();
            }
        }
        return ThreadType.MAIN;
    }
}
