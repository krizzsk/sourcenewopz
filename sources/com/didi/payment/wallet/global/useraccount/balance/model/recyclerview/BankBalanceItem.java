package com.didi.payment.wallet.global.useraccount.balance.model.recyclerview;

import com.didi.payment.wallet.global.useraccount.balance.model.BalanceResp;
import com.google.gson.annotations.SerializedName;

public class BankBalanceItem {
    @SerializedName("amount")
    private BalanceResp.AmountRichInfo mAmount;
    @SerializedName("date")
    private String mDate;
    @SerializedName("id")
    private String mId;
    @SerializedName("title")
    private String mTitle;

    public BankBalanceItem(String str, BalanceResp.AmountRichInfo amountRichInfo, String str2, String str3) {
        this.mTitle = str;
        this.mAmount = amountRichInfo;
        this.mDate = str2;
        this.mId = str3;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public BalanceResp.AmountRichInfo getAmount() {
        return this.mAmount;
    }

    public void setAmount(BalanceResp.AmountRichInfo amountRichInfo) {
        this.mAmount = amountRichInfo;
    }

    public String getDate() {
        return this.mDate;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }
}
