package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierFeeViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierHeaderViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierThirdChannelViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "cardChannelView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "feeView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierFeeViewHolder;", "headerView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "payBtnView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "scrollTo", "", "index", "", "setupView", "payInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "showLogoView", "thirdChannelView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViews.kt */
public interface IGlobalCashierView extends IGlobalCashierPayView {
    IGlobalCashierCardChannelViewHolder cardChannelView();

    IGlobalCashierFeeViewHolder feeView();

    IGlobalCashierHeaderViewHolder headerView();

    IGlobalCashierPayBtnViewHolder payBtnView();

    void scrollTo(int i);

    void setupView(PayInfoResponse payInfoResponse);

    void showLogoView();

    IGlobalCashierThirdChannelViewHolder thirdChannelView();
}
