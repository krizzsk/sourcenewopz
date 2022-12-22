package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001c\u0010*\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001a\u00103\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001c\u00106\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\u001c\u00109\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010\u0017R\u001c\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006P"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "addressRecStrategy", "", "getAddressRecStrategy", "()I", "setAddressRecStrategy", "(I)V", "afterFavPrice", "getAfterFavPrice", "setAfterFavPrice", "alert", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "getAlert", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "setAlert", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;)V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "currency", "getCurrency", "setCurrency", "interactions", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity;", "getInteractions", "()Ljava/util/List;", "setInteractions", "(Ljava/util/List;)V", "isValidation", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/IsValidationEntity;", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/IsValidationEntity;", "setValidation", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/IsValidationEntity;)V", "orderDisclaimer", "getOrderDisclaimer", "setOrderDisclaimer", "payCheckAlert", "getPayCheckAlert", "setPayCheckAlert", "priceSumOri", "getPriceSumOri", "setPriceSumOri", "priceSumOriDisplay", "getPriceSumOriDisplay", "setPriceSumOriDisplay", "realPayPrice", "getRealPayPrice", "setRealPayPrice", "realPayPriceDisplay", "getRealPayPriceDisplay", "setRealPayPriceDisplay", "saveMoneyHint", "getSaveMoneyHint", "setSaveMoneyHint", "sections", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillSection;", "getSections", "setSections", "shopInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;", "getShopInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;", "setShopInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;)V", "sn", "getSn", "setSn", "toast", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ToastEntity;", "getToast", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/ToastEntity;", "setToast", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/ToastEntity;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillInfoEntity.kt */
public final class BillInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -199325202245770905L;
    private int addressRecStrategy;
    private int afterFavPrice;
    private AlertEntity alert;
    private String cartId;
    private String currency;
    private List<ComposeActionEntity> interactions;
    private IsValidationEntity isValidation;
    private String orderDisclaimer;
    private AlertEntity payCheckAlert;
    private int priceSumOri;
    private String priceSumOriDisplay;
    private int realPayPrice;
    private String realPayPriceDisplay;
    private String saveMoneyHint;
    private List<BillSection> sections;
    private ShopInfo shopInfo;

    /* renamed from: sn */
    private String f41047sn;
    private ToastEntity toast;

    public final String getCartId() {
        return this.cartId;
    }

    public final void setCartId(String str) {
        this.cartId = str;
    }

    public final List<BillSection> getSections() {
        return this.sections;
    }

    public final void setSections(List<BillSection> list) {
        this.sections = list;
    }

    public final String getSn() {
        return this.f41047sn;
    }

    public final void setSn(String str) {
        this.f41047sn = str;
    }

    public final AlertEntity getAlert() {
        return this.alert;
    }

    public final void setAlert(AlertEntity alertEntity) {
        this.alert = alertEntity;
    }

    public final AlertEntity getPayCheckAlert() {
        return this.payCheckAlert;
    }

    public final void setPayCheckAlert(AlertEntity alertEntity) {
        this.payCheckAlert = alertEntity;
    }

    public final ToastEntity getToast() {
        return this.toast;
    }

    public final void setToast(ToastEntity toastEntity) {
        this.toast = toastEntity;
    }

    public final ShopInfo getShopInfo() {
        return this.shopInfo;
    }

    public final void setShopInfo(ShopInfo shopInfo2) {
        this.shopInfo = shopInfo2;
    }

    public final int getRealPayPrice() {
        return this.realPayPrice;
    }

    public final void setRealPayPrice(int i) {
        this.realPayPrice = i;
    }

    public final String getRealPayPriceDisplay() {
        return this.realPayPriceDisplay;
    }

    public final void setRealPayPriceDisplay(String str) {
        this.realPayPriceDisplay = str;
    }

    public final int getPriceSumOri() {
        return this.priceSumOri;
    }

    public final void setPriceSumOri(int i) {
        this.priceSumOri = i;
    }

    public final String getPriceSumOriDisplay() {
        return this.priceSumOriDisplay;
    }

    public final void setPriceSumOriDisplay(String str) {
        this.priceSumOriDisplay = str;
    }

    public final String getOrderDisclaimer() {
        return this.orderDisclaimer;
    }

    public final void setOrderDisclaimer(String str) {
        this.orderDisclaimer = str;
    }

    public final int getAfterFavPrice() {
        return this.afterFavPrice;
    }

    public final void setAfterFavPrice(int i) {
        this.afterFavPrice = i;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final List<ComposeActionEntity> getInteractions() {
        return this.interactions;
    }

    public final void setInteractions(List<ComposeActionEntity> list) {
        this.interactions = list;
    }

    public final IsValidationEntity isValidation() {
        return this.isValidation;
    }

    public final void setValidation(IsValidationEntity isValidationEntity) {
        this.isValidation = isValidationEntity;
    }

    public final int getAddressRecStrategy() {
        return this.addressRecStrategy;
    }

    public final void setAddressRecStrategy(int i) {
        this.addressRecStrategy = i;
    }

    public final String getSaveMoneyHint() {
        return this.saveMoneyHint;
    }

    public final void setSaveMoneyHint(String str) {
        this.saveMoneyHint = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
