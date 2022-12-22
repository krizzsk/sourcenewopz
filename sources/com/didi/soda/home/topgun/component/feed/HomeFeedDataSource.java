package com.didi.soda.home.topgun.component.feed;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeModuleEntity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.dynamic.DynamicDataSource;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.datasource.HomeDataMapFunction;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.didi.soda.home.topgun.manager.HomeFeedRepo;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0002¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/feed/HomeFeedDataSource;", "Lcom/didi/soda/datasource/page/dynamic/DynamicDataSource;", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "payloadProvider", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/datasource/listener/PayloadProvider;Lcom/didi/soda/blocks/scope/IBlockScope;)V", "dispatchNetworkResult", "", "homeEntity", "Lcom/didi/soda/customer/repo/CustomerResource;", "fetchData", "param", "initRepo", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedDataSource.kt */
public final class HomeFeedDataSource extends DynamicDataSource<HomeFeedParam, HomeEntity> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFeedDataSource(ScopeContext scopeContext, PayloadProvider<FeedPayload> payloadProvider, IBlockScope iBlockScope) {
        super(scopeContext, new HomeFeedParam(), new HomeDataMapFunction(payloadProvider, iBlockScope));
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        m30219a();
    }

    /* access modifiers changed from: protected */
    public void fetchData(HomeFeedParam homeFeedParam) {
        Intrinsics.checkNotNullParameter(homeFeedParam, "param");
        ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).fetchFeed(getMScopeContext(), (HomeFeedParam) getPageParams());
    }

    /* renamed from: a */
    private final void m30219a() {
        ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).subscribe(getMScopeContext(), new Action1() {
            public final void call(Object obj) {
                HomeFeedDataSource.m30221a(HomeFeedDataSource.this, (CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30221a(HomeFeedDataSource homeFeedDataSource, CustomerResource customerResource) {
        Intrinsics.checkNotNullParameter(homeFeedDataSource, "this$0");
        Intrinsics.checkNotNull(customerResource);
        Intrinsics.checkNotNullExpressionValue(customerResource, "resource!!");
        homeFeedDataSource.m30220a(customerResource);
        int pageIndex = ((HomeFeedParam) homeFeedDataSource.getPageParams()).getPageIndex();
        List<JsonObject> list = null;
        if (customerResource.status == Resource.Status.SUCCESS && customerResource.data != null) {
            Object obj = customerResource.data;
            Intrinsics.checkNotNullExpressionValue(obj, "resource.data");
            List<JsonObject> feedDistributor = HomeExtKt.getFeedDistributor((HomeEntity) obj);
            Object obj2 = customerResource.data;
            Intrinsics.checkNotNullExpressionValue(obj2, "resource.data");
            JsonObject buildFilterObject = HomeExtKt.buildFilterObject((HomeEntity) obj2, pageIndex);
            HomeModuleEntity mFeedEntity = ((HomeEntity) customerResource.data).getMFeedEntity();
            if (mFeedEntity != null) {
                list = mFeedEntity.getMJsonComponentList();
            }
            Bundle bundle = customerResource.mExtension;
            Intrinsics.checkNotNull(bundle);
            int i = bundle.getInt(ParamConst.PAGE_NUMBER);
            ArrayList arrayList = new ArrayList();
            if (feedDistributor != null) {
                arrayList.addAll(feedDistributor);
            }
            if (buildFilterObject != null) {
                arrayList.add(buildFilterObject);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            pageIndex = i;
            list = arrayList;
        }
        homeFeedDataSource.handleResult(customerResource, list, pageIndex);
    }

    /* renamed from: a */
    private final void m30220a(CustomerResource<HomeEntity> customerResource) {
        if (((HomeFeedParam) getPageParams()).getPageIndex() == 0) {
            HomeBusinessPool.getPool().clearBusiness();
        }
        if (customerResource.status != Resource.Status.SUCCESS || customerResource.data == null) {
            updateParams(HomeFeedDataSource$dispatchNetworkResult$2.INSTANCE);
            return;
        }
        Bundle bundle = customerResource.mExtension;
        Intrinsics.checkNotNull(bundle);
        String string = bundle.getString(ParamConst.TRACE_ID, "");
        updateParams(new HomeFeedDataSource$dispatchNetworkResult$1(customerResource, string));
        getMScopeContext().attach("recId", ((HomeEntity) customerResource.data).getMRecId());
        getMScopeContext().attach("traceId", string);
    }
}
