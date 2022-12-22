package com.didi.soda.customer.coordshop;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.repo.CustomerResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/RequestCoordShop;", "", "saver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "(Lcom/didi/soda/customer/coordshop/ShopSaver;)V", "checkIsCoord", "", "page", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "doRequestCoordShop", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "enterShopId", "", "listenShopIndex", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "triggerEnterBusinessEvent", "needListenClosure", "Lkotlin/Function0;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RequestCoordShop.kt */
public final class RequestCoordShop {

    /* renamed from: a */
    private final ShopSaver f40848a;

    public RequestCoordShop(ShopSaver shopSaver) {
        Intrinsics.checkNotNullParameter(shopSaver, "saver");
        this.f40848a = shopSaver;
    }

    /* renamed from: a */
    private final boolean m29022a(CustomerPage customerPage) {
        Bundle bundle;
        ScopeContext scopeContext = customerPage.getScopeContext();
        if (scopeContext == null || (bundle = scopeContext.getBundle()) == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) bundle.getString(Const.PageParams.IS_SYNERGY_SHOP, ""), (Object) "true");
    }

    public final void triggerEnterBusinessEvent(CustomerPage customerPage, Function0<Unit> function0) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(customerPage, "page");
        Intrinsics.checkNotNullParameter(function0, "needListenClosure");
        this.f40848a.resetVisibleDishWhenExitShop();
        boolean a = m29022a(customerPage);
        LogUtil.m29104i("Coord", ">>>>>>>>> needCoordShop = " + a + " <<<<<<<<<<<");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (a) {
            objectRef.element = m29018a(customerPage.getScopeContext());
            function0.invoke();
            customerPage.addLifecycleCallback(new RequestCoordShop$triggerEnterBusinessEvent$1(objectRef));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("enter shop but don't request coord shop!!，p1=");
        ScopeContext scopeContext = customerPage.getScopeContext();
        String str = null;
        if (!(scopeContext == null || (bundle = scopeContext.getBundle()) == null)) {
            str = bundle.getString(Const.PageParams.IS_SYNERGY_SHOP);
        }
        sb.append(str);
        sb.append("p2=");
        sb.append(this.f40848a.isOriginalFilter());
        LogUtil.m29104i("Coord", sb.toString());
    }

    /* renamed from: a */
    private final Subscription m29018a(ScopeContext scopeContext) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (scopeContext != null) {
            objectRef.element = BusinessRepo.get(scopeContext).subscribe(scopeContext, new Action1(scopeContext, objectRef) {
                public final /* synthetic */ ScopeContext f$1;
                public final /* synthetic */ Ref.ObjectRef f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void call(Object obj) {
                    RequestCoordShop.m29020a(RequestCoordShop.this, this.f$1, this.f$2, (CustomerResource) obj);
                }
            });
        }
        return (Subscription) objectRef.element;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29020a(RequestCoordShop requestCoordShop, ScopeContext scopeContext, Ref.ObjectRef objectRef, CustomerResource customerResource) {
        Resource.Status status;
        Intrinsics.checkNotNullParameter(requestCoordShop, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$subscription");
        Resource.Status status2 = null;
        if (customerResource == null) {
            status = null;
        } else {
            try {
                status = customerResource.status;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (status != Resource.Status.SUCCESS) {
            if (customerResource != null) {
                status2 = customerResource.status;
            }
            if (status2 != Resource.Status.CHANGE) {
                return;
            }
        }
        if (customerResource.data != null) {
            BusinessInfoEntity businessInfoEntity = ((BusinessEntity) customerResource.data).shopInfo;
            String str = "";
            if (businessInfoEntity != null) {
                String str2 = businessInfoEntity.shopId;
                if (str2 != null) {
                    str = str2;
                }
            }
            if (str.length() > 0) {
                requestCoordShop.m29019a(scopeContext, str);
            } else {
                LogUtil.m29104i("Coord", Intrinsics.stringPlus("request shop/index: shopId=", str));
            }
            Subscription subscription = (Subscription) objectRef.element;
            if (subscription != null) {
                subscription.unsubscribe();
            }
        }
    }

    /* renamed from: a */
    private final void m29019a(ScopeContext scopeContext, String str) {
        RequestInfo requestInfo = this.f40848a.getRequestInfo(str);
        LogUtil.m29104i("Coord", "visible = " + requestInfo.getVisibleShopList().size() + " nearBy = " + requestInfo.getNearByShopList().size() + "enter = " + CustomerExtentionKt.toJsonString(requestInfo.getCurEnterShop()) + "indexInRv = " + requestInfo.getIndexInRv());
        LiveData liveData = new LiveData();
        liveData.subscribe(scopeContext, new Action1() {
            public final void call(Object obj) {
                RequestCoordShop.m29021a(RequestCoordShop.this, (CoordShopInfo) obj);
            }
        });
        CustomerRpcManagerProxy.get().getCollaRec(requestInfo.getCurEnterShop(), requestInfo.getVisibleShopList(), requestInfo.getNearByShopList(), new RequestCoordShop$doRequestCoordShop$callback$1(liveData, requestInfo));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29021a(RequestCoordShop requestCoordShop, CoordShopInfo coordShopInfo) {
        Intrinsics.checkNotNullParameter(requestCoordShop, "this$0");
        requestCoordShop.f40848a.saveCoordShopInfo(coordShopInfo);
    }
}
