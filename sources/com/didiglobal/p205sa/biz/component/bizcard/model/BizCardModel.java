package com.didiglobal.p205sa.biz.component.bizcard.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/model/BizCardModel;", "Ljava/io/Serializable;", "()V", "cardInfos", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/component/bizcard/model/BizCardItemModel;", "Lkotlin/collections/ArrayList;", "getCardInfos", "()Ljava/util/ArrayList;", "setCardInfos", "(Ljava/util/ArrayList;)V", "title", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getTitle", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setTitle", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.model.BizCardModel */
/* compiled from: BizCardModel.kt */
public final class BizCardModel implements Serializable {
    @SerializedName("cardInfos")
    private ArrayList<BizCardItemModel> cardInfos;
    @SerializedName("title")
    private LEGORichInfo title;

    public final LEGORichInfo getTitle() {
        return this.title;
    }

    public final void setTitle(LEGORichInfo lEGORichInfo) {
        this.title = lEGORichInfo;
    }

    public final ArrayList<BizCardItemModel> getCardInfos() {
        return this.cardInfos;
    }

    public final void setCardInfos(ArrayList<BizCardItemModel> arrayList) {
        this.cardInfos = arrayList;
    }
}
