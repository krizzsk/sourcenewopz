package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00061"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SugBusinessEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "bizTimeDesc", "", "getBizTimeDesc", "()Ljava/lang/String;", "setBizTimeDesc", "(Ljava/lang/String;)V", "businessType", "", "getBusinessType", "()I", "setBusinessType", "(I)V", "cShopStatus", "getCShopStatus", "setCShopStatus", "dicisionInfo", "", "Lcom/didi/soda/customer/foundation/rpc/entity/PromptEntity;", "getDicisionInfo", "()Ljava/util/List;", "setDicisionInfo", "(Ljava/util/List;)V", "logo", "getLogo", "setLogo", "shopId", "getShopId", "setShopId", "shopName", "getShopName", "setShopName", "shopTag", "getShopTag", "()Lcom/didi/soda/customer/foundation/rpc/entity/PromptEntity;", "setShopTag", "(Lcom/didi/soda/customer/foundation/rpc/entity/PromptEntity;)V", "statusDesc", "getStatusDesc", "setStatusDesc", "tags", "getTags", "setTags", "url", "getUrl", "setUrl", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SugBusinessEntity.kt */
public final class SugBusinessEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = -3755450266087567781L;
    private String bizTimeDesc;
    private int businessType = 1;
    private int cShopStatus;
    private List<? extends PromptEntity> dicisionInfo;
    private String logo;
    private String shopId;
    private String shopName;
    private PromptEntity shopTag;
    private String statusDesc;
    private List<? extends PromptEntity> tags;
    private String url;

    public final String getLogo() {
        return this.logo;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final void setShopName(String str) {
        this.shopName = str;
    }

    public final PromptEntity getShopTag() {
        return this.shopTag;
    }

    public final void setShopTag(PromptEntity promptEntity) {
        this.shopTag = promptEntity;
    }

    public final List<PromptEntity> getDicisionInfo() {
        return this.dicisionInfo;
    }

    public final void setDicisionInfo(List<? extends PromptEntity> list) {
        this.dicisionInfo = list;
    }

    public final List<PromptEntity> getTags() {
        return this.tags;
    }

    public final void setTags(List<? extends PromptEntity> list) {
        this.tags = list;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public final String getBizTimeDesc() {
        return this.bizTimeDesc;
    }

    public final void setBizTimeDesc(String str) {
        this.bizTimeDesc = str;
    }

    public final int getCShopStatus() {
        return this.cShopStatus;
    }

    public final void setCShopStatus(int i) {
        this.cShopStatus = i;
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

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SugBusinessEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SugBusinessEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
