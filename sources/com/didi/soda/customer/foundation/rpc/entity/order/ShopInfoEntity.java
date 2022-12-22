package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010%\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001a\u0010(\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001c\u0010+\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018¨\u0006/"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "actTips", "", "Lcom/didi/soda/customer/foundation/rpc/entity/PromptEntity;", "getActTips", "()Ljava/util/List;", "setActTips", "(Ljava/util/List;)V", "businessType", "", "getBusinessType", "()I", "setBusinessType", "(I)V", "cShopStatus", "getCShopStatus", "setCShopStatus", "cShopStatusDesc", "", "getCShopStatusDesc", "()Ljava/lang/String;", "setCShopStatusDesc", "(Ljava/lang/String;)V", "logoImg", "getLogoImg", "setLogoImg", "nextBizTimeDesc", "getNextBizTimeDesc", "setNextBizTimeDesc", "shopId", "getShopId", "setShopId", "shopName", "getShopName", "setShopName", "url", "getUrl", "setUrl", "wineConfirm", "getWineConfirm", "setWineConfirm", "wineConfirmDesc", "getWineConfirmDesc", "setWineConfirmDesc", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderHistoryEntity.kt */
public final class ShopInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 3362395559032563820L;
    private List<? extends PromptEntity> actTips;
    private int businessType = 1;
    private int cShopStatus;
    private String cShopStatusDesc;
    private String logoImg;
    private String nextBizTimeDesc;
    private String shopId;
    private String shopName;
    private String url;
    private int wineConfirm;
    private String wineConfirmDesc;

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }

    public final String getLogoImg() {
        return this.logoImg;
    }

    public final void setLogoImg(String str) {
        this.logoImg = str;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final void setShopName(String str) {
        this.shopName = str;
    }

    public final String getCShopStatusDesc() {
        return this.cShopStatusDesc;
    }

    public final void setCShopStatusDesc(String str) {
        this.cShopStatusDesc = str;
    }

    public final int getCShopStatus() {
        return this.cShopStatus;
    }

    public final void setCShopStatus(int i) {
        this.cShopStatus = i;
    }

    public final String getNextBizTimeDesc() {
        return this.nextBizTimeDesc;
    }

    public final void setNextBizTimeDesc(String str) {
        this.nextBizTimeDesc = str;
    }

    public final List<PromptEntity> getActTips() {
        return this.actTips;
    }

    public final void setActTips(List<? extends PromptEntity> list) {
        this.actTips = list;
    }

    public final int getWineConfirm() {
        return this.wineConfirm;
    }

    public final void setWineConfirm(int i) {
        this.wineConfirm = i;
    }

    public final String getWineConfirmDesc() {
        return this.wineConfirmDesc;
    }

    public final void setWineConfirmDesc(String str) {
        this.wineConfirmDesc = str;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    public final void setBusinessType(int i) {
        this.businessType = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderHistoryEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
