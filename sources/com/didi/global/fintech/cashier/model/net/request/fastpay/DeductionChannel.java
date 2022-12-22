package com.didi.global.fintech.cashier.model.net.request.fastpay;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/fastpay/DeductionChannel;", "", "channel_id", "", "card_index", "card_uni_id", "weight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCard_index", "()Ljava/lang/String;", "setCard_index", "(Ljava/lang/String;)V", "getCard_uni_id", "setCard_uni_id", "getChannel_id", "setChannel_id", "getWeight", "setWeight", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChangePayOrderRequest.kt */
public class DeductionChannel {
    @SerializedName("card_index")
    private String card_index;
    @SerializedName("card_uni_id")
    private String card_uni_id;
    @SerializedName("channel_id")
    private String channel_id;
    @SerializedName("weight")
    private String weight;

    public DeductionChannel() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public DeductionChannel(String str, String str2, String str3, String str4) {
        this.channel_id = str;
        this.card_index = str2;
        this.card_uni_id = str3;
        this.weight = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeductionChannel(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getChannel_id() {
        return this.channel_id;
    }

    public final void setChannel_id(String str) {
        this.channel_id = str;
    }

    public final String getCard_index() {
        return this.card_index;
    }

    public final void setCard_index(String str) {
        this.card_index = str;
    }

    public final String getCard_uni_id() {
        return this.card_uni_id;
    }

    public final void setCard_uni_id(String str) {
        this.card_uni_id = str;
    }

    public final String getWeight() {
        return this.weight;
    }

    public final void setWeight(String str) {
        this.weight = str;
    }
}
