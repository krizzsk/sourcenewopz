package com.didiglobal.p205sa.biz.component.bizcard;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.didiglobal.p205sa.biz.component.bizcard.model.BizCardItemModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel;", "Lcom/didiglobal/enginecore/template/temp/IXEViewModel;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "normal", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateNormal;", "getNormal", "()Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateNormal;", "setNormal", "(Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateNormal;)V", "BizCardTemplateData", "BizCardTemplateNormal", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardTempModel */
/* compiled from: BizCardTempModel.kt */
public final class BizCardTempModel extends IXEViewModel implements BffGsonStruct {
    @SerializedName("normal")
    private BizCardTemplateNormal normal;

    public Object clone() {
        return super.clone();
    }

    public final BizCardTemplateNormal getNormal() {
        return this.normal;
    }

    public final void setNormal(BizCardTemplateNormal bizCardTemplateNormal) {
        this.normal = bizCardTemplateNormal;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateNormal;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "data", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateData;", "getData", "()Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateData;", "setData", "(Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateData;)V", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardTempModel$BizCardTemplateNormal */
    /* compiled from: BizCardTempModel.kt */
    public static final class BizCardTemplateNormal implements BffGsonStruct {
        @SerializedName("data")
        private BizCardTemplateData data;

        public Object clone() {
            return super.clone();
        }

        public final BizCardTemplateData getData() {
            return this.data;
        }

        public final void setData(BizCardTemplateData bizCardTemplateData) {
            this.data = bizCardTemplateData;
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardTempModel$BizCardTemplateData;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "cardInfos", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/component/bizcard/model/BizCardItemModel;", "Lkotlin/collections/ArrayList;", "getCardInfos", "()Ljava/util/ArrayList;", "setCardInfos", "(Ljava/util/ArrayList;)V", "cardTitle", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getCardTitle", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setCardTitle", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardTempModel$BizCardTemplateData */
    /* compiled from: BizCardTempModel.kt */
    public static final class BizCardTemplateData implements BffGsonStruct {
        @SerializedName("cardInfos")
        private ArrayList<BizCardItemModel> cardInfos;
        @SerializedName("title")
        private LEGORichInfo cardTitle;

        public Object clone() {
            return super.clone();
        }

        public final ArrayList<BizCardItemModel> getCardInfos() {
            return this.cardInfos;
        }

        public final void setCardInfos(ArrayList<BizCardItemModel> arrayList) {
            this.cardInfos = arrayList;
        }

        public final LEGORichInfo getCardTitle() {
            return this.cardTitle;
        }

        public final void setCardTitle(LEGORichInfo lEGORichInfo) {
            this.cardTitle = lEGORichInfo;
        }
    }
}
