package com.didi.global.fintech.cashier.fastpay.viewbinder.setting;

import com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingBtnViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingPresenter;
import com.didi.global.fintech.cashier.fastpay.viewbinder.FastPayBaseVB;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo;
import com.didi.global.fintech.cashier.p117ui.IFastPayMainBtnViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/viewbinder/setting/FastPaySettingBtnVB;", "Lcom/didi/global/fintech/cashier/fastpay/viewbinder/FastPayBaseVB;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;", "Lcom/didi/global/fintech/cashier/ui/IFastPayMainBtnViewHolder;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingBtnViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;)V", "curFastPayStatus", "Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "changeStatus", "", "content", "", "status", "onStatusBtnClick", "setupView", "data", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySettingBtnVB.kt */
public final class FastPaySettingBtnVB extends FastPayBaseVB<FastPayInfoResponse, IFastPaySettingPresenter, IFastPayMainBtnViewHolder> implements IFastPaySettingBtnViewBinder<FastPayInfoResponse> {

    /* renamed from: a */
    private FastPayStatus f21610a = FastPayStatus.UNKNOWN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPaySettingBtnVB(IFastPaySettingPresenter iFastPaySettingPresenter) {
        super(iFastPaySettingPresenter);
        Intrinsics.checkNotNullParameter(iFastPaySettingPresenter, "presenter");
    }

    public void onStatusBtnClick() {
        ((IFastPaySettingPresenter) getPresenter()).onStatusBtnClick();
    }

    public void changeStatus(String str, FastPayStatus fastPayStatus) {
        Intrinsics.checkNotNullParameter(fastPayStatus, "status");
        FastPaySettingBtnVB fastPaySettingBtnVB = this;
        if ((this.f21610a == fastPayStatus ? this : null) == null) {
            this.f21610a = fastPayStatus;
            IFastPayMainBtnViewHolder iFastPayMainBtnViewHolder = (IFastPayMainBtnViewHolder) getViewHolder();
            if (iFastPayMainBtnViewHolder != null) {
                IFastPayMainBtnViewHolder.DefaultImpls.updateBtn$default(iFastPayMainBtnViewHolder, true, this.f21610a == FastPayStatus.ON, str, (Function0) null, 8, (Object) null);
            }
        }
    }

    public void setupView(FastPayInfoResponse fastPayInfoResponse) {
        Intrinsics.checkNotNullParameter(fastPayInfoResponse, "data");
        super.setupView(fastPayInfoResponse);
        this.f21610a = FastPayStatus.Companion.value(fastPayInfoResponse.getSwitchStatus());
        IFastPayMainBtnViewHolder iFastPayMainBtnViewHolder = (IFastPayMainBtnViewHolder) getViewHolder();
        if (iFastPayMainBtnViewHolder != null) {
            boolean z = this.f21610a == FastPayStatus.ON;
            FastPayShowInfo showInfo = fastPayInfoResponse.getShowInfo();
            iFastPayMainBtnViewHolder.updateBtn(true, z, showInfo == null ? null : showInfo.getButton(), new FastPaySettingBtnVB$setupView$1(this));
        }
    }
}
