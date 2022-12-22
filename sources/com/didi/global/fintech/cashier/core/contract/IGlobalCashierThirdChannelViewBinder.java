package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierThirdChannelViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierThirdChannelViewBinder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "onMethodClick", "", "d", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "onSpreadClick", "removeAllMethodSelect", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViewBinders.kt */
public interface IGlobalCashierThirdChannelViewBinder extends IGlobalCashierBaseViewBinder<IGlobalCashierThirdChannelViewHolder, PayInfoResponse> {
    void onMethodClick(ChannelItemViewHolderData channelItemViewHolderData);

    void onSpreadClick(ChannelItemViewHolderData channelItemViewHolderData);

    void removeAllMethodSelect();
}
