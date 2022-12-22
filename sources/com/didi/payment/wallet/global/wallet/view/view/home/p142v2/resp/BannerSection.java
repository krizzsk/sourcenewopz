package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BannerSection;", "Ljava/io/Serializable;", "()V", "entryList", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BannerEntry;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BannerSection */
/* compiled from: WalletHomeModel.kt */
public final class BannerSection implements Serializable {
    private List<BannerEntry> entryList;
    private String title;

    public final List<BannerEntry> getEntryList() {
        return this.entryList;
    }

    public final void setEntryList(List<BannerEntry> list) {
        this.entryList = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
