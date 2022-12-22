package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.credit;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.wallet.global.model.WalletPageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "netModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "respData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardResp;", "getRespData", "()Landroidx/lifecycle/MutableLiveData;", "loadData", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.BankCardVM */
/* compiled from: BankCardVM.kt */
public final class BankCardVM extends WBaseViewModel {

    /* renamed from: a */
    private final WalletPageModel f32684a;

    /* renamed from: b */
    private final MutableLiveData<BankCardResp> f32685b = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankCardVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f32684a = new WalletPageModel(application);
    }

    public final MutableLiveData<BankCardResp> getRespData() {
        return this.f32685b;
    }

    public void loadData() {
        isLoading().setValue(true);
        this.f32684a.getBankCardList(new BankCardVM$loadData$1(this));
    }
}
