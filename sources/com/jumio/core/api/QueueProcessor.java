package com.jumio.core.api;

import com.jumio.commons.log.Log;
import com.jumio.core.model.InvokeOnUiThread;
import com.jumio.core.model.Subscriber;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiCall;
import com.jumio.core.persistence.C20003a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import jumio.core.C21351f;
import jumio.core.C21353g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¨\u0006\u0012"}, mo175978d2 = {"Lcom/jumio/core/api/QueueProcessor;", "Lcom/jumio/core/model/Subscriber;", "", "result", "", "onResult", "", "error", "onError", "Ljava/util/concurrent/ExecutorService;", "sendThread", "Ljumio/core/f;", "apiCallSettings", "Ljumio/core/g;", "apiResult", "<init>", "(Ljava/util/concurrent/ExecutorService;Ljumio/core/f;Ljumio/core/g;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: QueueProcessor.kt */
public final class QueueProcessor implements Subscriber<Object> {

    /* renamed from: a */
    public final C21351f f54641a;

    /* renamed from: b */
    public final C21353g f54642b;

    /* renamed from: c */
    public final ConcurrentLinkedQueue<ApiCallDataModel<?>> f54643c = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    public final Object f54644d = new Object();

    /* renamed from: e */
    public final ExecutorService f54645e;

    /* renamed from: f */
    public Future<ApiCall<?>> f54646f;

    /* renamed from: g */
    public ApiCall<?> f54647g;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo175978d2 = {"Lcom/jumio/core/api/QueueProcessor$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: QueueProcessor.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        new Companion((DefaultConstructorMarker) null);
    }

    public QueueProcessor(ExecutorService executorService, C21351f fVar, C21353g gVar) {
        Intrinsics.checkNotNullParameter(executorService, "sendThread");
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(gVar, "apiResult");
        this.f54641a = fVar;
        this.f54642b = gVar;
        this.f54645e = executorService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.jumio.core.network.ApiCall<?> mo162567a(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f54644d
            monitor-enter(r0)
            com.jumio.core.network.ApiCall<?> r1 = r4.f54647g     // Catch:{ all -> 0x003f }
            r2 = 0
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Future<com.jumio.core.network.ApiCall<?>> r1 = r4.f54646f     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x000d
            goto L_0x003d
        L_0x000d:
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r1 = r4.f54643c     // Catch:{ all -> 0x003f }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x003f }
            com.jumio.core.models.ApiCallDataModel r1 = (com.jumio.core.models.ApiCallDataModel) r1     // Catch:{ all -> 0x003f }
            java.lang.Class r1 = r1.getCall()     // Catch:{ all -> 0x003f }
            com.jumio.core.network.ApiCall<?> r3 = r4.f54647g     // Catch:{ all -> 0x003f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x003f }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x003f }
            if (r1 != r3) goto L_0x0034
            if (r5 == 0) goto L_0x002c
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r5 = r4.f54643c     // Catch:{ all -> 0x003f }
            r5.poll()     // Catch:{ all -> 0x003f }
            goto L_0x0031
        L_0x002c:
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r5 = r4.f54643c     // Catch:{ all -> 0x003f }
            r5.peek()     // Catch:{ all -> 0x003f }
        L_0x0031:
            com.jumio.core.network.ApiCall<?> r5 = r4.f54647g     // Catch:{ all -> 0x003f }
            goto L_0x0035
        L_0x0034:
            r5 = r2
        L_0x0035:
            r4.f54646f = r2     // Catch:{ all -> 0x003f }
            r4.f54647g = r2     // Catch:{ all -> 0x003f }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003f }
            monitor-exit(r0)
            return r5
        L_0x003d:
            monitor-exit(r0)
            return r2
        L_0x003f:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.QueueProcessor.mo162567a(boolean):com.jumio.core.network.ApiCall");
    }

    /* renamed from: b */
    public final void mo162573b() {
        synchronized (this.f54644d) {
            this.f54643c.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo162574c() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f54644d
            monitor-enter(r0)
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r1 = r8.f54643c     // Catch:{ all -> 0x0077 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x0075
            java.util.concurrent.Future<com.jumio.core.network.ApiCall<?>> r1 = r8.f54646f     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0075
        L_0x0010:
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r1 = r8.f54643c     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x0077 }
            com.jumio.core.models.ApiCallDataModel r1 = (com.jumio.core.models.ApiCallDataModel) r1     // Catch:{ all -> 0x0077 }
            java.lang.Class r2 = r1.getCall()     // Catch:{ all -> 0x0077 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0077 }
            java.lang.Class<jumio.core.f> r5 = jumio.core.C21351f.class
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0077 }
            java.lang.Class<com.jumio.core.models.ApiCallDataModel> r5 = com.jumio.core.models.ApiCallDataModel.class
            r7 = 1
            r4[r7] = r5     // Catch:{ all -> 0x0077 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ all -> 0x0077 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0077 }
            jumio.core.f r4 = r8.f54641a     // Catch:{ all -> 0x0077 }
            r3[r6] = r4     // Catch:{ all -> 0x0077 }
            r3[r7] = r1     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r2.newInstance(r3)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x006d
            com.jumio.core.network.ApiCall r1 = (com.jumio.core.network.ApiCall) r1     // Catch:{ all -> 0x0077 }
            r8.f54647g = r1     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "QueueProcessor"
            java.lang.String r3 = "proceed() starting "
            java.lang.Class r4 = r1.getClass()     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = r4.getSimpleName()     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r4)     // Catch:{ all -> 0x0077 }
            com.jumio.commons.log.Log.m39466i((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0077 }
            r1.add(r8)     // Catch:{ all -> 0x0077 }
            java.util.concurrent.ExecutorService r1 = r8.f54645e     // Catch:{ all -> 0x0077 }
            com.jumio.core.network.ApiCall<?> r2 = r8.f54647g     // Catch:{ all -> 0x0077 }
            java.util.concurrent.Future r1 = r1.submit(r2)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x0065
            r8.f54646f = r1     // Catch:{ all -> 0x0077 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0077 }
            monitor-exit(r0)
            return
        L_0x0065:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "null cannot be cast to non-null type java.util.concurrent.Future<com.jumio.core.network.ApiCall<*>>"
            r1.<init>(r2)     // Catch:{ all -> 0x0077 }
            throw r1     // Catch:{ all -> 0x0077 }
        L_0x006d:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "null cannot be cast to non-null type com.jumio.core.network.ApiCall<*>"
            r1.<init>(r2)     // Catch:{ all -> 0x0077 }
            throw r1     // Catch:{ all -> 0x0077 }
        L_0x0075:
            monitor-exit(r0)
            return
        L_0x0077:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.QueueProcessor.mo162574c():void");
    }

    @InvokeOnUiThread(true)
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        ApiCall<?> a = mo162567a(false);
        if (a != null) {
            this.f54642b.onError(a.getApiCallDataModel(), th);
        }
    }

    @InvokeOnUiThread(true)
    public void onResult(Object obj) {
        ApiCall<?> a = mo162567a(true);
        if (a != null) {
            this.f54642b.onResult(a.getApiCallDataModel(), obj);
            mo162574c();
        }
    }

    /* renamed from: a */
    public final void mo162569a(ApiCallDataModel<?> apiCallDataModel) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "c");
        synchronized (this.f54644d) {
            this.f54643c.add(apiCallDataModel);
            Log.m39466i("QueueProcessor", Intrinsics.stringPlus("  item added! ", apiCallDataModel.getCall().getSimpleName()));
            if (this.f54646f == null) {
                mo162574c();
            } else {
                Log.m39466i("QueueProcessor", "  don't proceed, a call is executing");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r4.f54646f = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.f54646f = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0022, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001a */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo162568a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f54644d
            monitor-enter(r0)
            r1 = 0
            com.jumio.core.network.ApiCall<?> r2 = r4.f54647g     // Catch:{ Exception -> 0x001a }
            if (r2 != 0) goto L_0x0009
            goto L_0x000c
        L_0x0009:
            r2.remove(r4)     // Catch:{ Exception -> 0x001a }
        L_0x000c:
            java.util.concurrent.Future<com.jumio.core.network.ApiCall<?>> r2 = r4.f54646f     // Catch:{ Exception -> 0x001a }
            if (r2 != 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            r3 = 1
            r2.cancel(r3)     // Catch:{ Exception -> 0x001a }
        L_0x0015:
            r4.f54646f = r1     // Catch:{ all -> 0x0023 }
            goto L_0x001e
        L_0x0018:
            r2 = move-exception
            goto L_0x0020
        L_0x001a:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0018 }
            r4.f54646f = r1     // Catch:{ all -> 0x0023 }
        L_0x001e:
            monitor-exit(r0)
            return
        L_0x0020:
            r4.f54646f = r1     // Catch:{ all -> 0x0023 }
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.QueueProcessor.mo162568a():void");
    }

    /* renamed from: a */
    public final void mo162572a(Class<? extends ApiCall<?>> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        synchronized (this.f54644d) {
            for (ApiCallDataModel apiCallDataModel : this.f54643c) {
                if (Intrinsics.areEqual((Object) apiCallDataModel.getCall(), (Object) cls)) {
                    this.f54643c.remove(apiCallDataModel);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: a */
    public final void mo162570a(C20003a.C20004a aVar, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "persistor");
        synchronized (this.f54644d) {
            if (z) {
                mo162568a();
            }
            aVar.mo163074a(this.f54643c);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: a */
    public final void mo162571a(C20003a.C20005b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "restorer");
        synchronized (this.f54644d) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) bVar.mo163075a();
            if (concurrentLinkedQueue != null) {
                this.f54643c.addAll(concurrentLinkedQueue);
            }
            mo162574c();
            Unit unit = Unit.INSTANCE;
        }
    }
}
