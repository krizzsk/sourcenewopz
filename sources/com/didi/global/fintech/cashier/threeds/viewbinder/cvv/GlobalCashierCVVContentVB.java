package com.didi.global.fintech.cashier.threeds.viewbinder.cvv;

import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.model.net.response.CVVDrawerData;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVViewHolder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCCVContentViewBinder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/viewbinder/cvv/GlobalCashierCVVContentVB;", "Lcom/didi/global/fintech/cashier/threeds/viewbinder/cvv/GlobalCashierCCVBaseVB;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVViewHolder;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCCVContentViewBinder;", "presenter", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "(Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;)V", "getCvvContent", "", "onDrawerClick", "", "registerTextChangeListener", "listener", "Lkotlin/Function1;", "", "setupView", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVContentVB.kt */
public final class GlobalCashierCVVContentVB extends GlobalCashierCCVBaseVB<IGlobalCashierCVVViewHolder> implements IGlobalCashierCCVContentViewBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCVVContentVB(IGlobalCashierCVVPresenter iGlobalCashierCVVPresenter) {
        super(iGlobalCashierCVVPresenter);
        Intrinsics.checkNotNullParameter(iGlobalCashierCVVPresenter, "presenter");
    }

    public void setupView(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "data");
        super.setupView(cVVInfoResponse);
        IGlobalCashierCVVViewHolder iGlobalCashierCVVViewHolder = (IGlobalCashierCVVViewHolder) getViewHolder();
        if (iGlobalCashierCVVViewHolder != null) {
            iGlobalCashierCVVViewHolder.updateTile(cVVInfoResponse.getTitle());
        }
        IGlobalCashierCVVViewHolder iGlobalCashierCVVViewHolder2 = (IGlobalCashierCVVViewHolder) getViewHolder();
        if (iGlobalCashierCVVViewHolder2 != null) {
            iGlobalCashierCVVViewHolder2.updateSubTile(cVVInfoResponse.getSubTitle());
        }
        IGlobalCashierCVVViewHolder iGlobalCashierCVVViewHolder3 = (IGlobalCashierCVVViewHolder) getViewHolder();
        String str = null;
        if (iGlobalCashierCVVViewHolder3 != null) {
            CVVCardInfo cardInfo = cVVInfoResponse.getCardInfo();
            String card_prefix = cardInfo == null ? null : cardInfo.getCard_prefix();
            CVVCardInfo cardInfo2 = cVVInfoResponse.getCardInfo();
            String card_suffix = cardInfo2 == null ? null : cardInfo2.getCard_suffix();
            CVVCardInfo cardInfo3 = cVVInfoResponse.getCardInfo();
            iGlobalCashierCVVViewHolder3.updateCardInfo(card_prefix, card_suffix, cardInfo3 == null ? null : cardInfo3.getCard_icon());
        }
        IGlobalCashierCVVViewHolder iGlobalCashierCVVViewHolder4 = (IGlobalCashierCVVViewHolder) getViewHolder();
        if (iGlobalCashierCVVViewHolder4 != null) {
            CVVDrawerData drawerData = cVVInfoResponse.getDrawerData();
            if (drawerData != null) {
                str = drawerData.getGuideTitle();
            }
            iGlobalCashierCVVViewHolder4.updateDrawerEntrance(str, new GlobalCashierCVVContentVB$setupView$1(this));
        }
    }

    public void registerTextChangeListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        IGlobalCashierCVVViewHolder iGlobalCashierCVVViewHolder = (IGlobalCashierCVVViewHolder) getViewHolder();
        if (iGlobalCashierCVVViewHolder != null) {
            iGlobalCashierCVVViewHolder.registerTextChangeListener(function1);
        }
    }

    public String getCvvContent() {
        IGlobalCashierCVVViewHolder iGlobalCashierCVVViewHolder = (IGlobalCashierCVVViewHolder) getViewHolder();
        if (iGlobalCashierCVVViewHolder == null) {
            return null;
        }
        return iGlobalCashierCVVViewHolder.getCvvContent();
    }

    public void onDrawerClick() {
        IGlobalCashierCVVPresenter presenter = getPresenter();
        CVVInfoResponse data = getData();
        presenter.onCVVDrawerClick(data == null ? null : data.getDrawerData());
    }
}
