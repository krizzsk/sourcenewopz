package com.didi.soda.home.component.category.landing;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.didi.soda.datasource.parser.ParseType;
import com.didi.soda.home.datasource.ShopCateLandingDataMapFunction;
import com.didi.soda.home.manager.ShopCategoryLandingRepo;
import com.didi.soda.home.topgun.component.feed.HomeExtKt;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0002H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0002¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingDataSource;", "Lcom/didi/soda/datasource/page/dynamic/DynamicDataSource;", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "payloadProvider", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/datasource/listener/PayloadProvider;Lcom/didi/soda/blocks/scope/IBlockScope;)V", "buildCategoryNotify", "Lcom/google/gson/JsonObject;", "notifyObject", "Lcom/google/gson/JsonElement;", "pageIndex", "", "buildLandingFilterObject", "data", "dispatchNetworkResult", "", "homeEntity", "Lcom/didi/soda/customer/repo/CustomerResource;", "fetchData", "param", "initRepo", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingDataSource.kt */
public final class ShopCategoryLandingDataSource extends DynamicDataSource<HomeFeedParam, HomeEntity> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopCategoryLandingDataSource(ScopeContext scopeContext, PayloadProvider<FeedPayload> payloadProvider, IBlockScope iBlockScope) {
        super(scopeContext, new HomeFeedParam(), new ShopCateLandingDataMapFunction(payloadProvider, iBlockScope));
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        m29999a();
    }

    /* access modifiers changed from: protected */
    public void fetchData(HomeFeedParam homeFeedParam) {
        Intrinsics.checkNotNullParameter(homeFeedParam, "param");
        ((ShopCategoryLandingRepo) RepoFactory.getRepo(ShopCategoryLandingRepo.class)).fetchFeed(getMScopeContext(), (HomeFeedParam) getPageParams());
    }

    public final JsonObject buildLandingFilterObject(HomeEntity homeEntity, int i) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(homeEntity, "data");
        if (i > 0) {
            return null;
        }
        HomeModuleEntity mFeedEntity = homeEntity.getMFeedEntity();
        if (mFeedEntity == null || (jsonElement = mFeedEntity.getMFilterList()) == null || jsonElement.isJsonNull()) {
            jsonElement = null;
        }
        JsonArray jsonArray = jsonElement instanceof JsonArray ? (JsonArray) jsonElement : null;
        if (jsonArray == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(HomeExtKt.KEY_FILTER, jsonArray);
        jsonObject.addProperty("type", ParseType.TYPE_LANDING_FILTER);
        Unit unit = Unit.INSTANCE;
        return jsonObject;
    }

    /* renamed from: a */
    private final JsonObject m29998a(JsonElement jsonElement, int i) {
        String str;
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        JsonObject asJsonObject3;
        JsonElement jsonElement2;
        JsonObject asJsonObject4;
        JsonElement jsonElement3;
        JsonObject jsonObject = null;
        if (i <= 0) {
            boolean z = true;
            if (jsonElement != null && jsonElement.isJsonObject()) {
                if (jsonElement == null || (asJsonObject4 = jsonElement.getAsJsonObject()) == null || (jsonElement3 = asJsonObject4.get("tip")) == null || !jsonElement3.isJsonObject()) {
                    z = false;
                }
                if (z) {
                    if (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null || (asJsonObject3 = asJsonObject2.getAsJsonObject("tip")) == null || (jsonElement2 = asJsonObject3.get("content")) == null) {
                        str = null;
                    } else {
                        str = jsonElement2.getAsString();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (!(jsonElement == null || (asJsonObject = jsonElement.getAsJsonObject()) == null)) {
                            jsonObject = asJsonObject.getAsJsonObject("tip");
                        }
                        if (jsonObject != null) {
                            jsonObject.addProperty("type", ParseType.TYPE_CATEGORY_NOTIFY);
                        }
                    }
                }
            }
        }
        return jsonObject;
    }

    /* renamed from: a */
    private final void m29999a() {
        ((ShopCategoryLandingRepo) RepoFactory.getRepo(ShopCategoryLandingRepo.class)).subscribe(getMScopeContext(), new Action1() {
            public final void call(Object obj) {
                ShopCategoryLandingDataSource.m30001a(ShopCategoryLandingDataSource.this, (CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30001a(ShopCategoryLandingDataSource shopCategoryLandingDataSource, CustomerResource customerResource) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingDataSource, "this$0");
        Intrinsics.checkNotNull(customerResource);
        Intrinsics.checkNotNullExpressionValue(customerResource, "resource!!");
        shopCategoryLandingDataSource.m30000a(customerResource);
        int pageIndex = ((HomeFeedParam) shopCategoryLandingDataSource.getPageParams()).getPageIndex();
        List<JsonObject> list = null;
        if (customerResource.status == Resource.Status.SUCCESS && customerResource.data != null) {
            Object obj = customerResource.data;
            Intrinsics.checkNotNullExpressionValue(obj, "resource.data");
            List<JsonObject> feedDistributor = HomeExtKt.getFeedDistributor((HomeEntity) obj);
            Object obj2 = customerResource.data;
            Intrinsics.checkNotNullExpressionValue(obj2, "resource.data");
            JsonObject buildLandingFilterObject = shopCategoryLandingDataSource.buildLandingFilterObject((HomeEntity) obj2, pageIndex);
            HomeModuleEntity mFeedEntity = ((HomeEntity) customerResource.data).getMFeedEntity();
            if (mFeedEntity != null) {
                list = mFeedEntity.getMJsonComponentList();
            }
            JsonObject a = shopCategoryLandingDataSource.m29998a(((HomeEntity) customerResource.data).getMNotifyEntity(), pageIndex);
            Bundle bundle = customerResource.mExtension;
            Intrinsics.checkNotNull(bundle);
            int i = bundle.getInt(ParamConst.PAGE_NUMBER);
            ArrayList arrayList = new ArrayList();
            if (a != null) {
                arrayList.add(a);
            }
            if (feedDistributor != null) {
                arrayList.addAll(feedDistributor);
            }
            if (buildLandingFilterObject != null) {
                arrayList.add(buildLandingFilterObject);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            pageIndex = i;
            list = arrayList;
        }
        shopCategoryLandingDataSource.handleResult(customerResource, list, pageIndex);
    }

    /* renamed from: a */
    private final void m30000a(CustomerResource<HomeEntity> customerResource) {
        if (((HomeFeedParam) getPageParams()).getPageIndex() == 0) {
            HomeBusinessPool.getPool().clearBusiness();
        }
        if (customerResource.status != Resource.Status.SUCCESS || customerResource.data == null) {
            updateParams(ShopCategoryLandingDataSource$dispatchNetworkResult$2.INSTANCE);
            return;
        }
        Bundle bundle = customerResource.mExtension;
        Intrinsics.checkNotNull(bundle);
        String string = bundle.getString(ParamConst.TRACE_ID, "");
        updateParams(new ShopCategoryLandingDataSource$dispatchNetworkResult$1(customerResource, string));
        getMScopeContext().attach("recId", ((HomeEntity) customerResource.data).getMRecId());
        getMScopeContext().attach("traceId", string);
    }
}
