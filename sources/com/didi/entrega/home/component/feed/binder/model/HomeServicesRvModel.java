package com.didi.entrega.home.component.feed.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.home.component.feed.entity.ComponentEntity;
import com.didi.entrega.home.component.feed.entity.HomeCouponEntity;
import com.didi.entrega.home.component.feed.entity.HomeServiceItemEntity;
import com.didi.entrega.home.policy.HomePolicyHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeServicesRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "coupon", "Lcom/didi/entrega/home/component/feed/entity/HomeCouponEntity;", "getCoupon", "()Lcom/didi/entrega/home/component/feed/entity/HomeCouponEntity;", "setCoupon", "(Lcom/didi/entrega/home/component/feed/entity/HomeCouponEntity;)V", "lawStyle", "", "getLawStyle", "()I", "setLawStyle", "(I)V", "serviceList", "", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "getServiceList", "()Ljava/util/List;", "setServiceList", "(Ljava/util/List;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeServicesRvModel.kt */
public final class HomeServicesRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private List<HomeServiceItemEntity> f20694a;

    /* renamed from: b */
    private HomeCouponEntity f20695b;

    /* renamed from: c */
    private int f20696c = 1;

    public final List<HomeServiceItemEntity> getServiceList() {
        return this.f20694a;
    }

    public final void setServiceList(List<HomeServiceItemEntity> list) {
        this.f20694a = list;
    }

    public final HomeCouponEntity getCoupon() {
        return this.f20695b;
    }

    public final void setCoupon(HomeCouponEntity homeCouponEntity) {
        this.f20695b = homeCouponEntity;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeServicesRvModel$Companion;", "", "()V", "convertRvModel", "Lcom/didi/entrega/home/component/feed/binder/model/HomeServicesRvModel;", "entity", "", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "list", "Lcom/didi/entrega/home/component/feed/entity/ComponentEntity;", "mHomePolicyHelper", "Lcom/didi/entrega/home/policy/HomePolicyHelper;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeServicesRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeServicesRvModel convertRvModel(List<HomeServiceItemEntity> list, List<ComponentEntity> list2, HomePolicyHelper homePolicyHelper) {
            Intrinsics.checkNotNullParameter(list, "entity");
            Intrinsics.checkNotNullParameter(list2, "list");
            HomeServicesRvModel homeServicesRvModel = new HomeServicesRvModel();
            homeServicesRvModel.setServiceList(list);
            if (homePolicyHelper != null) {
                homeServicesRvModel.setLawStyle(homePolicyHelper.getLawShowStyle());
            }
            for (ComponentEntity mCoupon : list2) {
                HomeCouponEntity mCoupon2 = mCoupon.getMCoupon();
                if (mCoupon2 != null) {
                    homeServicesRvModel.setCoupon(mCoupon2);
                }
            }
            return homeServicesRvModel;
        }
    }

    public final int getLawStyle() {
        return this.f20696c;
    }

    public final void setLawStyle(int i) {
        this.f20696c = i;
    }
}
