package com.didi.soda.customer.biz.popdialog;

import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.biz.popdialog.OrganicManager;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/OrganicManager;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrganicManager.kt */
public final class OrganicManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/OrganicManager$Companion;", "", "()V", "doDispatch", "", "getPoiCityUrl", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrganicManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void doDispatch() {
            Function1 function1 = OrganicManager$Companion$doDispatch$dispatchAction$1.INSTANCE;
            if (LocationUtil.hasValidPoi()) {
                function1.invoke(getPoiCityUrl());
            } else {
                ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressOnce(new Action2() {
                    public final void call(Object obj, Subscription subscription) {
                        OrganicManager.Companion.m46871doDispatch$lambda0(Function1.this, (AddressEntity) obj, subscription);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: doDispatch$lambda-0  reason: not valid java name */
        public static final void m46871doDispatch$lambda0(Function1 function1, AddressEntity addressEntity, Subscription subscription) {
            Intrinsics.checkNotNullParameter(function1, "$dispatchAction");
            function1.invoke(OrganicManager.Companion.getPoiCityUrl());
        }

        private final String getPoiCityUrl() {
            Object obj;
            Map<String, Object> organicCityMap = CustomerApolloUtil.getOrganicCityMap();
            String valueOf = String.valueOf(LocationUtil.getPoiCityId());
            if (organicCityMap == null) {
                obj = null;
            } else {
                obj = organicCityMap.get(valueOf);
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
    }
}
