package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierFeeViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PriceAmount;
import com.didi.global.fintech.cashier.model.net.response.PriceInfo;
import com.didi.global.fintech.cashier.model.net.response.ShowInfo;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierFeeViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.NumberKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.FeeHelpInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierFeeViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierFeeViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierFeeViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;)V", "setupView", "", "data", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierFeeViewBinder.kt */
public final class GlobalCashierFeeViewBinder extends GlobalCashierBaseViewBinder<IGlobalCashierFeeViewHolder, IGlobalMainCashierPresenter, PayInfoResponse> implements IGlobalCashierFeeViewBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierFeeViewBinder(IGlobalMainCashierPresenter iGlobalMainCashierPresenter) {
        super(iGlobalMainCashierPresenter);
        Intrinsics.checkNotNullParameter(iGlobalMainCashierPresenter, "presenter");
    }

    public void setupView(PayInfoResponse payInfoResponse) {
        PriceInfo priceInfo;
        IGlobalCashierFeeViewHolder iGlobalCashierFeeViewHolder;
        Unit unit;
        FeeHelpInfo feeHelpInfo;
        List<String> split;
        PriceAmount originalAmount;
        super.setupView(payInfoResponse);
        if (payInfoResponse != null && (priceInfo = payInfoResponse.getPriceInfo()) != null && (iGlobalCashierFeeViewHolder = (IGlobalCashierFeeViewHolder) getViewHolder()) != null) {
            ShowInfo showInfo = payInfoResponse.getShowInfo();
            iGlobalCashierFeeViewHolder.updateMerchantName(showInfo == null ? null : showInfo.getTitle());
            PriceAmount originalAmount2 = priceInfo.getOriginalAmount();
            int orZero = NumberKtxKt.orZero(originalAmount2 == null ? null : originalAmount2.getFee());
            PriceAmount actualAmount = priceInfo.getActualAmount();
            int orZero2 = NumberKtxKt.orZero(actualAmount == null ? null : actualAmount.getFee());
            iGlobalCashierFeeViewHolder.updateShouldPayFee((orZero == orZero2 || (originalAmount = priceInfo.getOriginalAmount()) == null) ? null : originalAmount.getDisplay(), orZero > orZero2);
            PriceAmount actualAmount2 = priceInfo.getActualAmount();
            if (actualAmount2 != null && (split = actualAmount2.getSplit()) != null && (!split.isEmpty()) && split.size() > 2) {
                iGlobalCashierFeeViewHolder.updateTotalFee(split.get(1), split.get(0));
            }
            List<PriceInfo.AdditionalInfo> additionalInfo = priceInfo.getAdditionalInfo();
            if (additionalInfo == null) {
                unit = null;
            } else {
                if (!additionalInfo.isEmpty()) {
                    PriceInfo.AdditionalInfo.HelpInfo helpInfo = additionalInfo.get(0).getHelpInfo();
                    if (helpInfo == null) {
                        feeHelpInfo = null;
                    } else {
                        feeHelpInfo = (FeeHelpInfo) ViewBinderDataParser.Companion.parseData(helpInfo, new GlobalCashierFeeViewBinder$setupView$1$1$2$helpInfo$1$1(ViewBinderDataParser.Companion));
                    }
                    iGlobalCashierFeeViewHolder.updateAdditionalInfo(additionalInfo.get(0).getMessage(), feeHelpInfo, new GlobalCashierFeeViewBinder$setupView$1$1$2$1(this, feeHelpInfo));
                } else {
                    iGlobalCashierFeeViewHolder.updateAdditionalInfo((String) null, (FeeHelpInfo) null, GlobalCashierFeeViewBinder$setupView$1$1$2$2.INSTANCE);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                iGlobalCashierFeeViewHolder.updateAdditionalInfo((String) null, (FeeHelpInfo) null, GlobalCashierFeeViewBinder$setupView$1$1$3.INSTANCE);
            }
        }
    }
}
