package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadSection;", "Ljava/io/Serializable;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "()V", "entryList", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Entry;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadSection */
/* compiled from: WalletHomeModel.kt */
public final class HeadSection implements IData, Serializable {
    private List<Entry> entryList;

    public final List<Entry> getEntryList() {
        return this.entryList;
    }

    public final void setEntryList(List<Entry> list) {
        this.entryList = list;
    }
}
