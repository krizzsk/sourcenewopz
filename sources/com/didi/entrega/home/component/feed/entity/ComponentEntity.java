package com.didi.entrega.home.component.feed.entity;

import com.didi.entrega.customer.foundation.rpc.entity.BannerEntity;
import com.didi.entrega.customer.foundation.rpc.entity.ComponentV2;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R \u0010,\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/entity/ComponentEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "mAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getMAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setMAddress", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "mBackGround", "Lcom/didi/entrega/home/component/feed/entity/HomeBackgroundEntity;", "getMBackGround", "()Lcom/didi/entrega/home/component/feed/entity/HomeBackgroundEntity;", "setMBackGround", "(Lcom/didi/entrega/home/component/feed/entity/HomeBackgroundEntity;)V", "mBannerList", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/BannerEntity;", "getMBannerList", "()Ljava/util/List;", "setMBannerList", "(Ljava/util/List;)V", "mComponentV2", "Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;", "getMComponentV2", "()Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;", "setMComponentV2", "(Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;)V", "mCoupon", "Lcom/didi/entrega/home/component/feed/entity/HomeCouponEntity;", "getMCoupon", "()Lcom/didi/entrega/home/component/feed/entity/HomeCouponEntity;", "setMCoupon", "(Lcom/didi/entrega/home/component/feed/entity/HomeCouponEntity;)V", "mOrder", "Lcom/didi/entrega/home/component/feed/entity/HomeOrderEntity;", "getMOrder", "()Lcom/didi/entrega/home/component/feed/entity/HomeOrderEntity;", "setMOrder", "(Lcom/didi/entrega/home/component/feed/entity/HomeOrderEntity;)V", "mServiceList", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "getMServiceList", "setMServiceList", "mServiceRule", "Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "getMServiceRule", "()Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "setMServiceRule", "(Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;)V", "mTitle", "Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;", "getMTitle", "()Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;", "setMTitle", "(Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentEntity.kt */
public final class ComponentEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -3927417050332100252L;
    @SerializedName("address")
    private AddressEntity mAddress;
    @SerializedName("background")
    private HomeBackgroundEntity mBackGround;
    @SerializedName("banner")
    private List<? extends BannerEntity> mBannerList;
    @SerializedName("componentV2")
    private ComponentV2 mComponentV2;
    @SerializedName("coupon")
    private HomeCouponEntity mCoupon;
    @SerializedName("order")
    private HomeOrderEntity mOrder;
    @SerializedName("serviceList")
    private List<HomeServiceItemEntity> mServiceList;
    @SerializedName("serviceRule")
    private ServiceRuleEntity mServiceRule;
    @SerializedName("title")
    private HomeTitleEntity mTitle;

    public final ComponentV2 getMComponentV2() {
        return this.mComponentV2;
    }

    public final void setMComponentV2(ComponentV2 componentV2) {
        this.mComponentV2 = componentV2;
    }

    public final AddressEntity getMAddress() {
        return this.mAddress;
    }

    public final void setMAddress(AddressEntity addressEntity) {
        this.mAddress = addressEntity;
    }

    public final HomeTitleEntity getMTitle() {
        return this.mTitle;
    }

    public final void setMTitle(HomeTitleEntity homeTitleEntity) {
        this.mTitle = homeTitleEntity;
    }

    public final List<HomeServiceItemEntity> getMServiceList() {
        return this.mServiceList;
    }

    public final void setMServiceList(List<HomeServiceItemEntity> list) {
        this.mServiceList = list;
    }

    public final HomeCouponEntity getMCoupon() {
        return this.mCoupon;
    }

    public final void setMCoupon(HomeCouponEntity homeCouponEntity) {
        this.mCoupon = homeCouponEntity;
    }

    public final HomeOrderEntity getMOrder() {
        return this.mOrder;
    }

    public final void setMOrder(HomeOrderEntity homeOrderEntity) {
        this.mOrder = homeOrderEntity;
    }

    public final ServiceRuleEntity getMServiceRule() {
        return this.mServiceRule;
    }

    public final void setMServiceRule(ServiceRuleEntity serviceRuleEntity) {
        this.mServiceRule = serviceRuleEntity;
    }

    public final HomeBackgroundEntity getMBackGround() {
        return this.mBackGround;
    }

    public final void setMBackGround(HomeBackgroundEntity homeBackgroundEntity) {
        this.mBackGround = homeBackgroundEntity;
    }

    public final List<BannerEntity> getMBannerList() {
        return this.mBannerList;
    }

    public final void setMBannerList(List<? extends BannerEntity> list) {
        this.mBannerList = list;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/entity/ComponentEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComponentEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
