package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\u0005H&J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCardChannelViewBinder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "onMethodClick", "", "d", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "onSpreadClick", "removeAllMethodSelect", "topMethod", "payment", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViewBinders.kt */
public interface IGlobalCashierCardChannelViewBinder extends IGlobalCashierBaseViewBinder<IGlobalCashierCardChannelViewHolder, PayInfoResponse> {
    void onMethodClick(ChannelItemViewHolderData channelItemViewHolderData);

    void onSpreadClick(ChannelItemViewHolderData channelItemViewHolderData);

    void removeAllMethodSelect();

    void topMethod(List<? extends BasicPayment> list);
}
