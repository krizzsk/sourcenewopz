package com.didiglobal.ibg_rpc_service.internal;

import android.content.Context;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didiglobal.ibg_rpc_service.HttpRpcClientConfig;
import com.didiglobal.ibg_rpc_service.internal.ResponseWrapper;
import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001/B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0(J\u0015\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0006H\u0000¢\u0006\u0002\b,Jd\u0010-\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0(R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR#\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/HttpClient;", "", "()V", "TAG", "", "<set-?>", "Landroid/content/Context;", "applicationContext", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "applicationContext$delegate", "Lkotlin/properties/ReadWriteProperty;", "client", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcClient;", "kotlin.jvm.PlatformType", "getClient", "()Lcom/didichuxing/foundation/net/rpc/http/HttpRpcClient;", "client$delegate", "Lkotlin/Lazy;", "config", "Lcom/didiglobal/ibg_rpc_service/HttpRpcClientConfig;", "getConfig", "()Lcom/didiglobal/ibg_rpc_service/HttpRpcClientConfig;", "config$delegate", "executed", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "get", "", "url", "query", "", "headers", "callback", "Lkotlin/Function1;", "Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper;", "init", "context", "init$ibg_rpc_service_release", "post", "body", "HttpRpcCallbackWrapper", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HttpClient.kt */
public final class HttpClient {
    public static final HttpClient INSTANCE = new HttpClient();

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f50245a = {C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(HttpClient.class, "applicationContext", "getApplicationContext()Landroid/content/Context;", 0))};

    /* renamed from: b */
    private static final String f50246b = "HttpClient";

    /* renamed from: c */
    private static final ReadWriteProperty f50247c = Delegates.INSTANCE.notNull();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f50248d;

    /* renamed from: e */
    private static final Lazy f50249e = LazyKt.lazy(HttpClient$config$2.INSTANCE);

    /* renamed from: f */
    private static final Lazy f50250f = LazyKt.lazy(HttpClient$client$2.INSTANCE);

    /* renamed from: g */
    private static final Lazy f50251g = LazyKt.lazy(HttpClient$gson$2.INSTANCE);

    private HttpClient() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Context m36204a() {
        return (Context) f50247c.getValue(this, f50245a[0]);
    }

    /* renamed from: a */
    private final void m36205a(Context context) {
        f50247c.setValue(this, f50245a[0], context);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final HttpRpcClientConfig m36206b() {
        return (HttpRpcClientConfig) f50249e.getValue();
    }

    /* renamed from: c */
    private final HttpRpcClient m36207c() {
        return (HttpRpcClient) f50250f.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final Gson m36208d() {
        return (Gson) f50251g.getValue();
    }

    public final void init$ibg_rpc_service_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        m36205a(applicationContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056 A[Catch:{ all -> 0x00aa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void get(java.lang.String r4, java.util.Map<java.lang.String, ? extends java.lang.Object> r5, java.util.Map<java.lang.String, ? extends java.lang.Object> r6, kotlin.jvm.functions.Function1<? super com.didiglobal.ibg_rpc_service.internal.ResponseWrapper, kotlin.Unit> r7) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x00aa }
            android.net.Uri$Builder r4 = r4.buildUpon()     // Catch:{ all -> 0x00aa }
            if (r5 != 0) goto L_0x0015
            goto L_0x003b
        L_0x0015:
            java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x00aa }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00aa }
        L_0x001d:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x003b
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00aa }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00aa }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x00aa }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00aa }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00aa }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00aa }
            r4.appendQueryParameter(r1, r0)     // Catch:{ all -> 0x00aa }
            goto L_0x001d
        L_0x003b:
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r5 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder     // Catch:{ all -> 0x00aa }
            r5.<init>()     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00aa }
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r4 = r5.get(r4)     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x0053
            boolean r5 = r6.isEmpty()     // Catch:{ all -> 0x00aa }
            if (r5 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r5 = 0
            goto L_0x0054
        L_0x0053:
            r5 = 1
        L_0x0054:
            if (r5 != 0) goto L_0x0093
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00aa }
            int r0 = r6.size()     // Catch:{ all -> 0x00aa }
            r5.<init>(r0)     // Catch:{ all -> 0x00aa }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00aa }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x00aa }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00aa }
        L_0x0069:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x008c
            java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x00aa }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00aa }
            com.didichuxing.foundation.net.http.SimpleHttpHeader r1 = new com.didichuxing.foundation.net.http.SimpleHttpHeader     // Catch:{ all -> 0x00aa }
            java.lang.Object r2 = r0.getKey()     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00aa }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00aa }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00aa }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x00aa }
            r5.add(r1)     // Catch:{ all -> 0x00aa }
            goto L_0x0069
        L_0x008c:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x00aa }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x00aa }
            r4.addHeaders((java.lang.Iterable) r5)     // Catch:{ all -> 0x00aa }
        L_0x0093:
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r4 = r4.build()     // Catch:{ all -> 0x00aa }
            com.didichuxing.foundation.net.rpc.http.HttpRpcClient r5 = r3.m36207c()     // Catch:{ all -> 0x00aa }
            com.didichuxing.foundation.net.rpc.http.HttpRpc r4 = r5.newRpc((com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r4)     // Catch:{ all -> 0x00aa }
            com.didiglobal.ibg_rpc_service.internal.HttpClient$HttpRpcCallbackWrapper r5 = new com.didiglobal.ibg_rpc_service.internal.HttpClient$HttpRpcCallbackWrapper     // Catch:{ all -> 0x00aa }
            r5.<init>(r7)     // Catch:{ all -> 0x00aa }
            com.didichuxing.foundation.net.rpc.http.HttpRpc$Callback r5 = (com.didichuxing.foundation.net.rpc.http.HttpRpc.Callback) r5     // Catch:{ all -> 0x00aa }
            r4.enqueue(r5)     // Catch:{ all -> 0x00aa }
            goto L_0x00c3
        L_0x00aa:
            r4 = move-exception
            java.lang.String r5 = "HttpClient"
            java.lang.String r6 = "catch exception:"
            com.didiglobal.ibg_rpc_service.internal.Logger.m36209e(r5, r6, r4)
            com.didiglobal.ibg_rpc_service.internal.ResponseWrapper$Companion r5 = com.didiglobal.ibg_rpc_service.internal.ResponseWrapper.Companion
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x00bc
            java.lang.String r4 = ""
        L_0x00bc:
            com.didiglobal.ibg_rpc_service.internal.ResponseWrapper r4 = r5.failed(r4)
            r7.invoke(r4)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ibg_rpc_service.internal.HttpClient.get(java.lang.String, java.util.Map, java.util.Map, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A[Catch:{ all -> 0x00ba }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void post(java.lang.String r3, java.util.Map<java.lang.String, ? extends java.lang.Object> r4, java.util.Map<java.lang.String, ? extends java.lang.Object> r5, java.util.Map<java.lang.String, ? extends java.lang.Object> r6, kotlin.jvm.functions.Function1<? super com.didiglobal.ibg_rpc_service.internal.ResponseWrapper, kotlin.Unit> r7) {
        /*
            r2 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ all -> 0x00ba }
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch:{ all -> 0x00ba }
            if (r4 != 0) goto L_0x0015
            goto L_0x003b
        L_0x0015:
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x00ba }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00ba }
        L_0x001d:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x003b
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x00ba }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00ba }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00ba }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ba }
            r3.appendQueryParameter(r1, r0)     // Catch:{ all -> 0x00ba }
            goto L_0x001d
        L_0x003b:
            java.lang.String r4 = "application/json"
            com.google.gson.Gson r0 = r2.m36208d()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r0.toJson((java.lang.Object) r5)     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.http.HttpBody r4 = com.didichuxing.foundation.net.http.HttpBody.newInstance((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r5 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder     // Catch:{ all -> 0x00ba }
            r5.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.http.HttpEntity r4 = (com.didichuxing.foundation.net.http.HttpEntity) r4     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r3 = r5.post(r3, r4)     // Catch:{ all -> 0x00ba }
            if (r6 == 0) goto L_0x0063
            boolean r4 = r6.isEmpty()     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r4 = 0
            goto L_0x0064
        L_0x0063:
            r4 = 1
        L_0x0064:
            if (r4 != 0) goto L_0x00a3
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00ba }
            int r5 = r6.size()     // Catch:{ all -> 0x00ba }
            r4.<init>(r5)     // Catch:{ all -> 0x00ba }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x00ba }
            java.util.Set r5 = r6.entrySet()     // Catch:{ all -> 0x00ba }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00ba }
        L_0x0079:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00ba }
            if (r6 == 0) goto L_0x009c
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00ba }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.http.SimpleHttpHeader r0 = new com.didichuxing.foundation.net.http.SimpleHttpHeader     // Catch:{ all -> 0x00ba }
            java.lang.Object r1 = r6.getKey()     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00ba }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ba }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x00ba }
            r4.add(r0)     // Catch:{ all -> 0x00ba }
            goto L_0x0079
        L_0x009c:
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x00ba }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x00ba }
            r3.addHeaders((java.lang.Iterable) r4)     // Catch:{ all -> 0x00ba }
        L_0x00a3:
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r3 = r3.build()     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.rpc.http.HttpRpcClient r4 = r2.m36207c()     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.rpc.http.HttpRpc r3 = r4.newRpc((com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r3)     // Catch:{ all -> 0x00ba }
            com.didiglobal.ibg_rpc_service.internal.HttpClient$HttpRpcCallbackWrapper r4 = new com.didiglobal.ibg_rpc_service.internal.HttpClient$HttpRpcCallbackWrapper     // Catch:{ all -> 0x00ba }
            r4.<init>(r7)     // Catch:{ all -> 0x00ba }
            com.didichuxing.foundation.net.rpc.http.HttpRpc$Callback r4 = (com.didichuxing.foundation.net.rpc.http.HttpRpc.Callback) r4     // Catch:{ all -> 0x00ba }
            r3.enqueue(r4)     // Catch:{ all -> 0x00ba }
            goto L_0x00d3
        L_0x00ba:
            r3 = move-exception
            java.lang.String r4 = "HttpClient"
            java.lang.String r5 = "catch exception:"
            com.didiglobal.ibg_rpc_service.internal.Logger.m36209e(r4, r5, r3)
            com.didiglobal.ibg_rpc_service.internal.ResponseWrapper$Companion r4 = com.didiglobal.ibg_rpc_service.internal.ResponseWrapper.Companion
            java.lang.String r3 = r3.getMessage()
            if (r3 != 0) goto L_0x00cc
            java.lang.String r3 = ""
        L_0x00cc:
            com.didiglobal.ibg_rpc_service.internal.ResponseWrapper r3 = r4.failed(r3)
            r7.invoke(r3)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ibg_rpc_service.internal.HttpClient.post(java.lang.String, java.util.Map, java.util.Map, java.util.Map, kotlin.jvm.functions.Function1):void");
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/HttpClient$HttpRpcCallbackWrapper;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpc$Callback;", "callback", "Lkotlin/Function1;", "Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper;", "", "(Lkotlin/jvm/functions/Function1;)V", "onFailure", "request", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "e", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HttpClient.kt */
    private static final class HttpRpcCallbackWrapper implements HttpRpc.Callback {
        private final Function1<ResponseWrapper, Unit> callback;

        public HttpRpcCallbackWrapper(Function1<? super ResponseWrapper, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "callback");
            this.callback = function1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.Map} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r6) {
            /*
                r5 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "rpc Response:{isSuccessful="
                r0.append(r1)
                r1 = 0
                if (r6 != 0) goto L_0x000f
                r2 = r1
                goto L_0x0017
            L_0x000f:
                boolean r2 = r6.isSuccessful()
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            L_0x0017:
                r0.append(r2)
                java.lang.String r2 = ",reason:"
                r0.append(r2)
                if (r6 != 0) goto L_0x0023
                r2 = r1
                goto L_0x0027
            L_0x0023:
                java.lang.String r2 = r6.getReason()
            L_0x0027:
                r0.append(r2)
                r2 = 125(0x7d, float:1.75E-43)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "HttpClient"
                com.didiglobal.ibg_rpc_service.internal.Logger.m36210v(r2, r0)
                r0 = 0
                r3 = 1
                if (r6 != 0) goto L_0x003d
                goto L_0x0044
            L_0x003d:
                boolean r4 = r6.isSuccessful()
                if (r4 != r3) goto L_0x0044
                r0 = 1
            L_0x0044:
                if (r0 == 0) goto L_0x00c4
                com.didichuxing.foundation.net.http.HttpEntity r6 = r6.getEntity()
                com.didiglobal.ibg_rpc_service.internal.HttpClient r0 = com.didiglobal.ibg_rpc_service.internal.HttpClient.INSTANCE
                com.google.gson.Gson r0 = r0.m36208d()
                java.io.InputStream r3 = r6.getContent()
                java.lang.String r4 = "entity.content"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                byte[] r3 = kotlin.p245io.ByteStreamsKt.readBytes(r3)
                java.nio.charset.Charset r6 = r6.getCharset()
                java.lang.String r4 = "entity.charset"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
                java.lang.String r4 = new java.lang.String
                r4.<init>(r3, r6)
                com.didiglobal.ibg_rpc_service.internal.HttpClient$HttpRpcCallbackWrapper$onSuccess$json$1 r6 = new com.didiglobal.ibg_rpc_service.internal.HttpClient$HttpRpcCallbackWrapper$onSuccess$json$1
                r6.<init>()
                java.lang.reflect.Type r6 = r6.getType()
                java.lang.Object r6 = r0.fromJson((java.lang.String) r4, (java.lang.reflect.Type) r6)
                java.util.Map r6 = (java.util.Map) r6
                java.lang.String r0 = "json response:"
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r6)
                com.didiglobal.ibg_rpc_service.internal.Logger.m36210v(r2, r0)
                java.lang.String r0 = "errorCode"
                java.lang.Object r0 = r6.get(r0)
                boolean r2 = r0 instanceof java.lang.Number
                if (r2 == 0) goto L_0x0090
                java.lang.Number r0 = (java.lang.Number) r0
                goto L_0x0091
            L_0x0090:
                r0 = r1
            L_0x0091:
                if (r0 != 0) goto L_0x0095
                r0 = r1
                goto L_0x009d
            L_0x0095:
                int r0 = r0.intValue()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            L_0x009d:
                java.lang.String r2 = "errorMsg"
                java.lang.Object r2 = r6.get(r2)
                boolean r3 = r2 instanceof java.lang.String
                if (r3 == 0) goto L_0x00aa
                java.lang.String r2 = (java.lang.String) r2
                goto L_0x00ab
            L_0x00aa:
                r2 = r1
            L_0x00ab:
                java.lang.String r3 = "data"
                java.lang.Object r6 = r6.get(r3)
                boolean r3 = r6 instanceof java.util.Map
                if (r3 == 0) goto L_0x00b8
                r1 = r6
                java.util.Map r1 = (java.util.Map) r1
            L_0x00b8:
                kotlin.jvm.functions.Function1<com.didiglobal.ibg_rpc_service.internal.ResponseWrapper, kotlin.Unit> r6 = r5.callback
                com.didiglobal.ibg_rpc_service.internal.ResponseWrapper$Companion r3 = com.didiglobal.ibg_rpc_service.internal.ResponseWrapper.Companion
                com.didiglobal.ibg_rpc_service.internal.ResponseWrapper r0 = r3.success(r0, r2, r1)
                r6.invoke(r0)
                goto L_0x00dc
            L_0x00c4:
                kotlin.jvm.functions.Function1<com.didiglobal.ibg_rpc_service.internal.ResponseWrapper, kotlin.Unit> r0 = r5.callback
                com.didiglobal.ibg_rpc_service.internal.ResponseWrapper$Companion r1 = com.didiglobal.ibg_rpc_service.internal.ResponseWrapper.Companion
                java.lang.String r2 = ""
                if (r6 != 0) goto L_0x00cd
                goto L_0x00d5
            L_0x00cd:
                java.lang.String r6 = r6.getReason()
                if (r6 != 0) goto L_0x00d4
                goto L_0x00d5
            L_0x00d4:
                r2 = r6
            L_0x00d5:
                com.didiglobal.ibg_rpc_service.internal.ResponseWrapper r6 = r1.failed(r2)
                r0.invoke(r6)
            L_0x00dc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ibg_rpc_service.internal.HttpClient.HttpRpcCallbackWrapper.onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse):void");
        }

        public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
            String message;
            Logger.m36209e(HttpClient.f50246b, Intrinsics.stringPlus("onFailure: request=", httpRpcRequest), iOException);
            Function1<ResponseWrapper, Unit> function1 = this.callback;
            ResponseWrapper.Companion companion = ResponseWrapper.Companion;
            String str = "";
            if (!(iOException == null || (message = iOException.getMessage()) == null)) {
                str = message;
            }
            function1.invoke(companion.failed(str));
        }
    }
}
