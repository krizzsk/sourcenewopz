package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/DisposalSection;", "Ljava/io/Serializable;", "()V", "blockId", "", "getBlockId", "()Ljava/lang/String;", "setBlockId", "(Ljava/lang/String;)V", "cancelBtn", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BtnItem;", "getCancelBtn", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BtnItem;", "setCancelBtn", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BtnItem;)V", "confirmBtn", "getConfirmBtn", "setConfirmBtn", "desc", "getDesc", "setDesc", "hasPreBlock", "", "getHasPreBlock", "()Z", "setHasPreBlock", "(Z)V", "icon", "getIcon", "setIcon", "title", "getTitle", "setTitle", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.DisposalSection */
/* compiled from: WalletHomeModel.kt */
public final class DisposalSection implements Serializable {
    private String blockId;
    private BtnItem cancelBtn;
    private BtnItem confirmBtn;
    private String desc;
    private boolean hasPreBlock;
    private String icon;
    private String title;

    public final boolean getHasPreBlock() {
        return this.hasPreBlock;
    }

    public final void setHasPreBlock(boolean z) {
        this.hasPreBlock = z;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final void setBlockId(String str) {
        this.blockId = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final BtnItem getConfirmBtn() {
        return this.confirmBtn;
    }

    public final void setConfirmBtn(BtnItem btnItem) {
        this.confirmBtn = btnItem;
    }

    public final BtnItem getCancelBtn() {
        return this.cancelBtn;
    }

    public final void setCancelBtn(BtnItem btnItem) {
        this.cancelBtn = btnItem;
    }
}
