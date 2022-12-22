package com.didi.payment.pix.transfer.p141vm.model;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixBankOptionResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/pix/transfer/vm/model/PixBankOptionsVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bankOptionsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/pix/net/response/PixBankOptionResp$DataEntry;", "getBankOptionsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setBankOptionsLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "pixNetModel", "Lcom/didi/payment/pix/net/PixNetModel;", "getPixNetModel", "()Lcom/didi/payment/pix/net/PixNetModel;", "setPixNetModel", "(Lcom/didi/payment/pix/net/PixNetModel;)V", "loadData", "", "source", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.PixBankOptionsVM */
/* compiled from: PixBankOptionsVM.kt */
public final class PixBankOptionsVM extends WBaseViewModel {

    /* renamed from: a */
    private PixNetModel f31272a;

    /* renamed from: b */
    private MutableLiveData<PixBankOptionResp.DataEntry> f31273b = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixBankOptionsVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f31272a = new PixNetModel(application);
    }

    public final PixNetModel getPixNetModel() {
        return this.f31272a;
    }

    public final void setPixNetModel(PixNetModel pixNetModel) {
        Intrinsics.checkNotNullParameter(pixNetModel, "<set-?>");
        this.f31272a = pixNetModel;
    }

    public final MutableLiveData<PixBankOptionResp.DataEntry> getBankOptionsLiveData() {
        return this.f31273b;
    }

    public final void setBankOptionsLiveData(MutableLiveData<PixBankOptionResp.DataEntry> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31273b = mutableLiveData;
    }

    public final void loadData(int i) {
        isLoading().setValue(true);
        this.f31272a.getBankOptionData(i, new PixBankOptionsVM$loadData$1(this));
    }
}
