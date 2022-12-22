package com.jumio.core.api;

import com.jumio.core.model.Subscriber;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiCall;
import com.jumio.core.persistence.C20003a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import jumio.core.C21351f;
import jumio.core.C21353g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/jumio/core/api/SingleProcessor;", "Lcom/jumio/core/model/Subscriber;", "", "result", "", "onResult", "", "error", "onError", "Ljava/util/concurrent/ExecutorService;", "executorService", "Ljumio/core/f;", "apiCallSettings", "Ljumio/core/g;", "apiResult", "<init>", "(Ljava/util/concurrent/ExecutorService;Ljumio/core/f;Ljumio/core/g;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: SingleProcessor.kt */
public final class SingleProcessor implements Subscriber<Object> {

    /* renamed from: a */
    public final ExecutorService f54648a;

    /* renamed from: b */
    public final C21351f f54649b;

    /* renamed from: c */
    public final C21353g f54650c;

    /* renamed from: d */
    public ApiCall<?> f54651d;

    /* renamed from: e */
    public Future<ApiCall<?>> f54652e;

    public SingleProcessor(ExecutorService executorService, C21351f fVar, C21353g gVar) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(gVar, "apiResult");
        this.f54648a = executorService;
        this.f54649b = fVar;
        this.f54650c = gVar;
    }

    /* renamed from: a */
    public final void mo162578a(ApiCallDataModel<?> apiCallDataModel) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        if (this.f54652e == null) {
            Object newInstance = apiCallDataModel.getCall().getDeclaredConstructor(new Class[]{C21351f.class, ApiCallDataModel.class}).newInstance(new Object[]{this.f54649b, apiCallDataModel});
            if (newInstance != null) {
                ApiCall<?> apiCall = (ApiCall) newInstance;
                this.f54651d = apiCall;
                apiCall.add(this);
                Future<ApiCall<?>> submit = this.f54648a.submit(this.f54651d);
                if (submit != null) {
                    this.f54652e = submit;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.Future<com.jumio.core.network.ApiCall<*>>");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.network.ApiCall<*>");
        }
        throw new IllegalArgumentException("Another call is being executed".toString());
    }

    public void onError(Throwable th) {
        ApiCall<?> apiCall = this.f54651d;
        if (apiCall != null) {
            this.f54650c.onError(apiCall.getApiCallDataModel(), th);
        }
        this.f54652e = null;
    }

    public void onResult(Object obj) {
        ApiCall<?> apiCall = this.f54651d;
        if (apiCall != null) {
            this.f54650c.onResult(apiCall.getApiCallDataModel(), obj);
        }
        this.f54652e = null;
    }

    /* renamed from: a */
    public final ApiCallDataModel<?> mo162577a() {
        try {
            ApiCall<?> apiCall = this.f54651d;
            if (apiCall != null) {
                apiCall.removeAllSubscriber();
            }
            Future<ApiCall<?>> future = this.f54652e;
            if (future != null) {
                future.cancel(true);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f54652e = null;
            throw th;
        }
        this.f54652e = null;
        ApiCall<?> apiCall2 = this.f54651d;
        if (apiCall2 == null) {
            return null;
        }
        return apiCall2.getApiCallDataModel();
    }

    /* renamed from: a */
    public final void mo162579a(C20003a.C20004a aVar, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "persistor");
        aVar.mo163074a(z ? mo162577a() : null);
    }

    /* renamed from: a */
    public final void mo162580a(C20003a.C20005b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "restorer");
        ApiCallDataModel apiCallDataModel = (ApiCallDataModel) bVar.mo163075a();
        if (apiCallDataModel != null) {
            mo162578a((ApiCallDataModel<?>) apiCallDataModel);
        }
    }
}
