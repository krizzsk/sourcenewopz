package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.viewholder.FeeHelpInfo;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH&J!\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "onBindCardClick", "", "onGoSignUp", "onGoTopUp", "onHelpIconClick", "helpInfo", "Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "onInstallmentClick", "cardIndex", "", "number", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "onPayBtnClick", "onPayChannelClick", "d", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "onPlansClick", "vo", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IGlobalMainCashierPresenter extends IGlobalBinderCashierPresenter<PayInfoResponse> {
    void onBindCardClick();

    void onGoSignUp();

    void onGoTopUp();

    void onHelpIconClick(FeeHelpInfo feeHelpInfo);

    void onInstallmentClick(String str, Integer num);

    void onPayBtnClick();

    void onPayChannelClick(ChannelItemViewHolderData channelItemViewHolderData);

    void onPlansClick(String str, InstallmentVo installmentVo);
}
