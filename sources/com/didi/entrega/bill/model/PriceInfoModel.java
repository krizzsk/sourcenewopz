package com.didi.entrega.bill.model;

import android.view.View;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.rpc.entity.PriceInfo;
import com.didi.entrega.customer.foundation.rpc.entity.RuleDesc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR7\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006'"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/PriceInfoModel;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "highLight", "", "getHighLight", "()I", "setHighLight", "(I)V", "onTipIconClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnTipIconClick", "()Lkotlin/jvm/functions/Function1;", "setOnTipIconClick", "(Lkotlin/jvm/functions/Function1;)V", "oriPriceDisplay", "", "getOriPriceDisplay", "()Ljava/lang/String;", "setOriPriceDisplay", "(Ljava/lang/String;)V", "payPriceDisplay", "getPayPriceDisplay", "setPayPriceDisplay", "ruleDesc", "Lcom/didi/entrega/customer/foundation/rpc/entity/RuleDesc;", "getRuleDesc", "()Lcom/didi/entrega/customer/foundation/rpc/entity/RuleDesc;", "setRuleDesc", "(Lcom/didi/entrega/customer/foundation/rpc/entity/RuleDesc;)V", "underContentText", "getUnderContentText", "setUnderContentText", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PriceInfoModel.kt */
public final class PriceInfoModel implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int highLight;
    private Function1<? super View, Unit> onTipIconClick;
    private String oriPriceDisplay;
    private String payPriceDisplay;
    private RuleDesc ruleDesc;
    private String underContentText;

    public final String getOriPriceDisplay() {
        return this.oriPriceDisplay;
    }

    public final void setOriPriceDisplay(String str) {
        this.oriPriceDisplay = str;
    }

    public final String getPayPriceDisplay() {
        return this.payPriceDisplay;
    }

    public final void setPayPriceDisplay(String str) {
        this.payPriceDisplay = str;
    }

    public final int getHighLight() {
        return this.highLight;
    }

    public final void setHighLight(int i) {
        this.highLight = i;
    }

    public final RuleDesc getRuleDesc() {
        return this.ruleDesc;
    }

    public final void setRuleDesc(RuleDesc ruleDesc2) {
        this.ruleDesc = ruleDesc2;
    }

    public final String getUnderContentText() {
        return this.underContentText;
    }

    public final void setUnderContentText(String str) {
        this.underContentText = str;
    }

    public final Function1<View, Unit> getOnTipIconClick() {
        return this.onTipIconClick;
    }

    public final void setOnTipIconClick(Function1<? super View, Unit> function1) {
        this.onTipIconClick = function1;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/PriceInfoModel$Companion;", "", "()V", "convertModel", "Lcom/didi/entrega/bill/model/PriceInfoModel;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/PriceInfo;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PriceInfoModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PriceInfoModel convertModel(PriceInfo priceInfo) {
            if (priceInfo == null) {
                return null;
            }
            PriceInfoModel priceInfoModel = new PriceInfoModel();
            priceInfoModel.setOriPriceDisplay(priceInfo.getOriPriceDisplay());
            priceInfoModel.setPayPriceDisplay(priceInfo.getPayPriceDisplay());
            priceInfoModel.setHighLight(priceInfo.getHighLight());
            priceInfoModel.setRuleDesc(priceInfo.getRuleDesc());
            priceInfoModel.setUnderContentText(priceInfo.getPayPrice() < priceInfo.getOriPrice() ? priceInfo.getOriPriceDisplay() : "");
            priceInfoModel.setOnTipIconClick(new PriceInfoModel$Companion$convertModel$1$1$1(priceInfoModel));
            return priceInfoModel;
        }
    }
}
