package com.didi.payment.commonsdk.p129ui;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.WBaseResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H&R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "errObj", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "getErrObj", "()Landroidx/lifecycle/MutableLiveData;", "setErrObj", "(Landroidx/lifecycle/MutableLiveData;)V", "isLoading", "", "setLoading", "isNetError", "setNetError", "loadData", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.WBaseViewModel */
/* compiled from: WBaseViewModel.kt */
public abstract class WBaseViewModel extends AndroidViewModel {

    /* renamed from: a */
    private MutableLiveData<Boolean> f30180a = new MutableLiveData<>();

    /* renamed from: b */
    private MutableLiveData<Boolean> f30181b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<WBaseResp> f30182c = new MutableLiveData<>();

    public abstract void loadData();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WBaseViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<Boolean> isLoading() {
        return this.f30180a;
    }

    public final void setLoading(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30180a = mutableLiveData;
    }

    public final MutableLiveData<Boolean> isNetError() {
        return this.f30181b;
    }

    public final void setNetError(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30181b = mutableLiveData;
    }

    public final MutableLiveData<WBaseResp> getErrObj() {
        return this.f30182c;
    }

    public final void setErrObj(MutableLiveData<WBaseResp> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30182c = mutableLiveData;
    }
}
