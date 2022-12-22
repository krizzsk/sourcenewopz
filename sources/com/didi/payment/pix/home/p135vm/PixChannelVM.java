package com.didi.payment.pix.home.p135vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.net.PixNetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/pix/home/vm/PixChannelVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "hasLoaded", "", "getHasLoaded", "()Z", "setHasLoaded", "(Z)V", "netModel", "Lcom/didi/payment/pix/net/PixNetModel;", "pageRespLd", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/pix/home/PixChannelResp$Data;", "getPageRespLd", "()Landroidx/lifecycle/MutableLiveData;", "setPageRespLd", "(Landroidx/lifecycle/MutableLiveData;)V", "loadData", "", "notifyPageRefresh", "refreshData", "executeRightNow", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.home.vm.PixChannelVM */
/* compiled from: PixChannelVM.kt */
public final class PixChannelVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f31076a;

    /* renamed from: b */
    private MutableLiveData<PixChannelResp.Data> f31077b = new MutableLiveData<>();

    /* renamed from: c */
    private boolean f31078c;

    public final void notifyPageRefresh() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixChannelVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f31076a = new PixNetModel(application2);
    }

    public final MutableLiveData<PixChannelResp.Data> getPageRespLd() {
        return this.f31077b;
    }

    public final void setPageRespLd(MutableLiveData<PixChannelResp.Data> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31077b = mutableLiveData;
    }

    public final void refreshData(boolean z) {
        this.f31078c = false;
        if (z) {
            loadData();
        }
    }

    public final boolean getHasLoaded() {
        return this.f31078c;
    }

    public final void setHasLoaded(boolean z) {
        this.f31078c = z;
    }

    public void loadData() {
        if (!this.f31078c) {
            isLoading().setValue(true);
            this.f31076a.getPixChannel(new PixChannelVM$loadData$1(this));
        }
    }
}
