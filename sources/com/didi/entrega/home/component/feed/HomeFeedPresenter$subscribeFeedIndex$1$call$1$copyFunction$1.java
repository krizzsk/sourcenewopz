package com.didi.entrega.home.component.feed;

import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import com.didi.entrega.home.component.feed.entity.HomeTitleEntity;
import com.didi.entrega.home.component.feed.entity.ServiceRuleEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\n"}, mo175978d2 = {"<anonymous>", "", "serviceRuleEntity", "Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "address", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "orderList", "", "", "backGround", "Lcom/didi/entrega/home/component/feed/entity/HomeBackgroundEntity;", "homeTitle", "Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedPresenter.kt */
final class HomeFeedPresenter$subscribeFeedIndex$1$call$1$copyFunction$1 extends Lambda implements Function5<ServiceRuleEntity, AddressEntity, List<? extends String>, HomeBackgroundEntity, HomeTitleEntity, Unit> {
    final /* synthetic */ CustomerResource<HomeFeedEntity> $resource;
    final /* synthetic */ HomeFeedPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFeedPresenter$subscribeFeedIndex$1$call$1$copyFunction$1(HomeFeedPresenter homeFeedPresenter, CustomerResource<HomeFeedEntity> customerResource) {
        super(5);
        this.this$0 = homeFeedPresenter;
        this.$resource = customerResource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke((ServiceRuleEntity) obj, (AddressEntity) obj2, (List<String>) (List) obj3, (HomeBackgroundEntity) obj4, (HomeTitleEntity) obj5);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        r1 = r4.poi;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.didi.entrega.home.component.feed.entity.ServiceRuleEntity r3, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r4, java.util.List<java.lang.String> r5, com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity r6, com.didi.entrega.home.component.feed.entity.HomeTitleEntity r7) {
        /*
            r2 = this;
            com.didi.entrega.home.component.feed.HomeFeedPresenter r0 = r2.this$0
            r0.f20646c = r3
            com.didi.entrega.home.component.feed.HomeFeedPresenter r3 = r2.this$0
            com.didi.app.nova.skeleton.mvp.IView r3 = r3.getLogicView()
            com.didi.entrega.home.component.feed.Contract$AbsHomeFeedView r3 = (com.didi.entrega.home.component.feed.Contract.AbsHomeFeedView) r3
            r0 = 0
            if (r4 != 0) goto L_0x0012
        L_0x0010:
            r1 = r0
            goto L_0x0019
        L_0x0012:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r4.poi
            if (r1 != 0) goto L_0x0017
            goto L_0x0010
        L_0x0017:
            java.lang.String r1 = r1.city
        L_0x0019:
            r3.updateHomePage(r1, r6, r7)
            com.didi.entrega.home.component.feed.HomeFeedPresenter r3 = r2.this$0
            r3.m15102a((com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity) r4)
            com.didi.entrega.customer.repo.CustomerResource<com.didi.entrega.home.component.feed.entity.HomeFeedEntity> r3 = r2.$resource
            android.os.Bundle r3 = r3.mExtension
            if (r3 != 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            java.lang.String r4 = "from"
            java.lang.Object r0 = r3.get(r4)
        L_0x002e:
            com.didi.entrega.home.component.feed.HomeFeedPresenter r3 = r2.this$0
            java.lang.String r3 = r3.f20652i
            java.lang.String r4 = "subscribeFeedIndex from = "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r0)
            com.didi.entrega.customer.foundation.log.util.LogUtil.m14765i((java.lang.String) r3, (java.lang.String) r4)
            r3 = 3
            boolean r4 = r0 instanceof java.lang.Integer
            if (r4 != 0) goto L_0x0044
            goto L_0x004d
        L_0x0044:
            r4 = r0
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r3 == r4) goto L_0x00ae
        L_0x004d:
            if (r5 != 0) goto L_0x0050
            goto L_0x00ae
        L_0x0050:
            com.didi.entrega.home.component.feed.HomeFeedPresenter r3 = r2.this$0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.Iterator r5 = r5.iterator()
        L_0x005e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0081
            java.lang.Object r7 = r5.next()
            int r1 = r6 + 1
            if (r6 >= 0) goto L_0x006f
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x006f:
            java.lang.String r7 = (java.lang.String) r7
            if (r6 != 0) goto L_0x0077
            r4.append(r7)
            goto L_0x007f
        L_0x0077:
            java.lang.String r6 = ","
            r4.append(r6)
            r4.append(r7)
        L_0x007f:
            r6 = r1
            goto L_0x005e
        L_0x0081:
            java.lang.String r5 = r3.f20652i
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "subscribeFeedIndex requestOrderInfoById from = "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r7 = " orderIds = "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            com.didi.entrega.customer.foundation.log.util.LogUtil.m14765i((java.lang.String) r5, (java.lang.String) r6)
            com.didi.entrega.manager.base.ICustomerOrderManager r3 = r3.f20651h
            java.lang.String r4 = r4.toString()
            r5 = 2
            r3.requestOrderInfoById(r4, r5)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.home.component.feed.HomeFeedPresenter$subscribeFeedIndex$1$call$1$copyFunction$1.invoke(com.didi.entrega.home.component.feed.entity.ServiceRuleEntity, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity, java.util.List, com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity, com.didi.entrega.home.component.feed.entity.HomeTitleEntity):void");
    }
}
