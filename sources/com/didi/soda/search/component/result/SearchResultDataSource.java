package com.didi.soda.search.component.result;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.SearchModuleEntity;
import com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.dynamic.DynamicDataSource;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParseType;
import com.didi.soda.search.repo.SearchResultRepo;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002J\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0010H\u0002J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0002J\u000e\u0010)\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u0010J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0002H\u0014J\b\u0010,\u001a\u00020&H\u0002J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u001eH\u0002J\u001e\u00100\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011H\u0002J\u0010\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\u001eR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultDataSource;", "Lcom/didi/soda/datasource/page/dynamic/DynamicDataSource;", "Lcom/didi/soda/search/component/result/SearchResultPageParam;", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchResultEntity;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "payloadProvider", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/datasource/listener/PayloadProvider;Lcom/didi/soda/blocks/scope/IBlockScope;)V", "expandDataMapFunction", "Lcom/didi/soda/search/component/result/SearchResultDataMapFunction;", "expandListMap", "", "", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "moduleCurrentTotalMap", "", "moduleIndex", "", "getPayloadProvider", "()Lcom/didi/soda/datasource/listener/PayloadProvider;", "setPayloadProvider", "(Lcom/didi/soda/datasource/listener/PayloadProvider;)V", "searchResultRepo", "Lcom/didi/soda/search/repo/SearchResultRepo;", "buildMoreTitleObject", "Lcom/google/gson/JsonObject;", "type", "title", "buildMoudleList", "moudleEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchModuleEntity;", "moudleType", "dispatchNetworkResult", "", "searchResultResource", "Lcom/didi/soda/customer/repo/CustomerResource;", "expandSavedData", "fetchData", "param", "initRepo", "isFrequentFeedBackCard", "", "item", "saveExpandData", "list", "updateLastShopId", "component", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultDataSource.kt */
public final class SearchResultDataSource extends DynamicDataSource<SearchResultPageParam, SearchResultEntity> {

    /* renamed from: a */
    private PayloadProvider<FeedPayload> f43724a;

    /* renamed from: b */
    private Map<String, List<RecyclerModel>> f43725b = new LinkedHashMap();

    /* renamed from: c */
    private Map<String, Integer> f43726c = new LinkedHashMap();

    /* renamed from: d */
    private SearchResultRepo f43727d = new SearchResultRepo();

    /* renamed from: e */
    private SearchResultDataMapFunction f43728e;

    /* renamed from: f */
    private int[] f43729f;

    public final PayloadProvider<FeedPayload> getPayloadProvider() {
        return this.f43724a;
    }

    public final void setPayloadProvider(PayloadProvider<FeedPayload> payloadProvider) {
        Intrinsics.checkNotNullParameter(payloadProvider, "<set-?>");
        this.f43724a = payloadProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultDataSource(ScopeContext scopeContext, PayloadProvider<FeedPayload> payloadProvider, IBlockScope iBlockScope) {
        super(scopeContext, new SearchResultPageParam(), new SearchResultDataMapFunction(payloadProvider, iBlockScope));
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        this.f43724a = payloadProvider;
        SearchResultDataMapFunction searchResultDataMapFunction = new SearchResultDataMapFunction(this.f43724a, iBlockScope);
        searchResultDataMapFunction.setIgnoreIndex(true);
        Unit unit = Unit.INSTANCE;
        this.f43728e = searchResultDataMapFunction;
        this.f43729f = new int[]{0};
        m31044a();
    }

    /* access modifiers changed from: protected */
    public void fetchData(SearchResultPageParam searchResultPageParam) {
        Intrinsics.checkNotNullParameter(searchResultPageParam, "param");
        this.f43727d.getSearchResult(getMScopeContext(), (SearchResultPageParam) getPageParams());
    }

    /* renamed from: a */
    private final void m31044a() {
        this.f43727d.subscribe(getMScopeContext(), new Action1() {
            public final void call(Object obj) {
                SearchResultDataSource.m31046a(SearchResultDataSource.this, (CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31046a(SearchResultDataSource searchResultDataSource, CustomerResource customerResource) {
        Intrinsics.checkNotNullParameter(searchResultDataSource, "this$0");
        Intrinsics.checkNotNull(customerResource);
        Intrinsics.checkNotNullExpressionValue(customerResource, "resource!!");
        searchResultDataSource.m31045a((CustomerResource<SearchResultEntity>) customerResource);
        int pageIndex = ((SearchResultPageParam) searchResultDataSource.getPageParams()).getPageIndex();
        List<JsonObject> list = null;
        if (customerResource.status == Resource.Status.SUCCESS && customerResource.data != null) {
            if (pageIndex == 0) {
                searchResultDataSource.f43729f[0] = 0;
                searchResultDataSource.f43726c.clear();
            }
            SearchModuleEntity searchModuleEntity = ((SearchResultEntity) customerResource.data).mNoResultData;
            if (searchModuleEntity != null) {
                list = searchModuleEntity.mJsonComponentList;
            }
            List<JsonObject> a = searchResultDataSource.m31043a(((SearchResultEntity) customerResource.data).mBrandList, "brand");
            List<JsonObject> a2 = searchResultDataSource.m31043a(((SearchResultEntity) customerResource.data).mOutRangeData, "outRange");
            List<JsonObject> a3 = searchResultDataSource.m31043a(((SearchResultEntity) customerResource.data).mSearchResultData, "search");
            List<JsonObject> a4 = searchResultDataSource.m31043a(((SearchResultEntity) customerResource.data).mRecommendRsp, "recommend");
            List<JsonObject> arrayList = new ArrayList<>();
            if (list != null) {
                arrayList.addAll(list);
            }
            if (a != null) {
                arrayList.addAll(a);
            }
            if (a2 != null) {
                arrayList.addAll(a2);
            }
            if (a3 != null) {
                arrayList.addAll(a3);
            }
            if (a4 != null) {
                arrayList.addAll(a4);
            }
            if (arrayList.size() > 0) {
                searchResultDataSource.updateLastShopId((JsonObject) CollectionsKt.last(arrayList));
            }
            list = arrayList;
        }
        searchResultDataSource.handleResult(customerResource, list, pageIndex);
    }

    /* renamed from: a */
    private final void m31045a(CustomerResource<SearchResultEntity> customerResource) {
        if (customerResource.status != Resource.Status.SUCCESS || customerResource.data == null) {
            updateParams(SearchResultDataSource$dispatchNetworkResult$4.INSTANCE);
            return;
        }
        SearchResultEntity searchResultEntity = (SearchResultEntity) customerResource.data;
        Bundle bundle = customerResource.mExtension;
        Intrinsics.checkNotNull(bundle);
        String string = bundle.getString(ParamConst.TRACE_ID, "");
        SearchModuleEntity searchModuleEntity = searchResultEntity.mSearchResultData;
        boolean z = false;
        boolean areEqual = searchModuleEntity == null ? false : Intrinsics.areEqual((Object) searchModuleEntity.mHasMore, (Object) true);
        if (areEqual) {
            updateParams(SearchResultDataSource$dispatchNetworkResult$1.INSTANCE);
        }
        SearchModuleEntity searchModuleEntity2 = searchResultEntity.mRecommendRsp;
        if (searchModuleEntity2 != null) {
            z = Intrinsics.areEqual((Object) searchModuleEntity2.mHasMore, (Object) true);
        }
        if (z) {
            updateParams(SearchResultDataSource$dispatchNetworkResult$2.INSTANCE);
        }
        updateParams(new SearchResultDataSource$dispatchNetworkResult$3(areEqual, z, searchResultEntity, string));
        getMScopeContext().attach("recId", ((SearchResultPageParam) getPageParams()).getRecId());
        getMScopeContext().attach("traceId", string);
        getMScopeContext().attach(BlocksConst.BLOCK_PARAM_SEARCH_INTENT, Integer.valueOf(searchResultEntity.mIntentionType));
    }

    /* renamed from: a */
    private final List<JsonObject> m31043a(SearchModuleEntity searchModuleEntity, String str) {
        List list;
        Collection collection;
        boolean z;
        SearchModuleEntity searchModuleEntity2 = searchModuleEntity;
        String str2 = str;
        if (searchModuleEntity2 == null) {
            return null;
        }
        List<JsonObject> arrayList = new ArrayList<>();
        List<JsonObject> list2 = searchModuleEntity2.mJsonComponentList;
        if (list2 == null) {
            list = null;
        } else {
            Collection arrayList2 = new ArrayList();
            for (Object next : list2) {
                if (!m31048a((JsonObject) next)) {
                    arrayList2.add(next);
                }
            }
            list = (List) arrayList2;
        }
        Collection collection2 = list;
        if (collection2 == null || collection2.isEmpty()) {
            return null;
        }
        if (!TextUtils.isEmpty(searchModuleEntity2.mTitle)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", ParseType.SIMPLE_TITLE);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("title", searchModuleEntity2.mTitle);
            jsonObject2.addProperty("titleSizeDP", "20");
            jsonObject2.addProperty("fontType", "BOLD");
            jsonObject2.addProperty("paddingTopDp", DiFaceLogger.EVENT_ID_ENTER_APPEAL_DIALOG);
            Unit unit = Unit.INSTANCE;
            jsonObject.add("data", jsonObject2);
            arrayList.add(jsonObject);
        }
        if (((SearchResultPageParam) getPageParams()).getPageIndex() == 0) {
            int[] iArr = this.f43729f;
            iArr[0] = iArr[0] + 1;
        }
        if (list != null) {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                Object next2 = it.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                JsonObject jsonObject3 = (JsonObject) next2;
                JsonElement jsonElement = jsonObject3.get("data");
                Iterator it2 = it;
                if (jsonElement == null) {
                    collection = collection2;
                } else {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    collection = collection2;
                    if (asJsonObject != null) {
                        asJsonObject.addProperty(BlocksConst.BLOCK_PARAM_MODULE_ID, str2);
                    }
                }
                if (jsonObject3 != null) {
                    Integer num = this.f43726c.get(str2);
                    jsonObject3.addProperty("position", (Number) Integer.valueOf(i + (num == null ? 0 : num.intValue())));
                }
                i = i2;
                collection2 = collection;
                it = it2;
            }
        }
        Collection collection3 = collection2;
        if (Intrinsics.areEqual((Object) str2, (Object) "brand")) {
            if (list.size() > 0) {
                arrayList.add(list.get(0));
            }
            if (list.size() > 1) {
                updateParams(new SearchResultDataSource$buildMoudleList$3(searchModuleEntity2));
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("type", ParseType.SIMPLE_TITLE);
                JsonObject jsonObject5 = new JsonObject();
                Object[] objArr = new Object[1];
                Integer num2 = searchModuleEntity2.mSize;
                objArr[0] = Integer.valueOf(num2 == null ? 0 : num2.intValue());
                jsonObject5.addProperty("title", ResourceHelper.getString(R.string.FoodC_rebuild_More_branches_OTBy, objArr));
                jsonObject5.addProperty("titleSizeDP", "16");
                jsonObject5.addProperty("fontType", "MEDIUM");
                jsonObject5.addProperty("paddingTopDp", "6");
                Unit unit2 = Unit.INSTANCE;
                jsonObject4.add("data", jsonObject5);
                arrayList.add(jsonObject4);
                if (list.size() > 3) {
                    arrayList.addAll(list.subList(1, 3));
                    String string = ResourceHelper.getString(R.string.FoodC_rebuild_See_more_CwFa);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.FoodC_rebuild_See_more_CwFa)");
                    arrayList.add(m31042a("brand", string));
                    m31047a("brand", (List<JsonObject>) list.subList(3, list.size()));
                } else {
                    arrayList.addAll(list.subList(1, list.size()));
                }
            }
        } else if (!Intrinsics.areEqual((Object) str2, (Object) "outRange")) {
            Collection collection4 = collection3;
            if (searchModuleEntity2 == null) {
                z = false;
            } else {
                z = Intrinsics.areEqual((Object) searchModuleEntity2.mHasMore, (Object) true);
            }
            if (z) {
                Integer num3 = this.f43726c.get(str2);
                this.f43726c.put(str2, Integer.valueOf((num3 == null ? 0 : num3.intValue()) + list.size()));
            }
            arrayList.addAll(collection4);
        } else if (list.size() > 1) {
            arrayList.add(list.get(0));
            arrayList.add(m31042a("outRange", ResourceHelper.getString(R.string.FoodC_rebuild_See_more_CwFa) + 65288 + (list.size() - 1) + 65289));
            m31047a("outRange", (List<JsonObject>) list.subList(1, list.size()));
        } else {
            arrayList.addAll(collection3);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r6.get("type");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m31048a(com.google.gson.JsonObject r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0013
        L_0x0005:
            java.lang.String r1 = "type"
            com.google.gson.JsonElement r1 = r6.get(r1)
            if (r1 != 0) goto L_0x000f
            goto L_0x0003
        L_0x000f:
            java.lang.String r1 = r1.getAsString()
        L_0x0013:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "1000"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            r2 = 0
            if (r1 != 0) goto L_0x0021
            return r2
        L_0x0021:
            if (r6 != 0) goto L_0x0024
            goto L_0x0042
        L_0x0024:
            java.lang.String r1 = "data"
            com.google.gson.JsonElement r6 = r6.get(r1)
            if (r6 != 0) goto L_0x002d
            goto L_0x0042
        L_0x002d:
            com.google.gson.JsonObject r6 = r6.getAsJsonObject()
            if (r6 != 0) goto L_0x0034
            goto L_0x0042
        L_0x0034:
            java.lang.String r1 = "sceneId"
            com.google.gson.JsonElement r6 = r6.get(r1)
            if (r6 != 0) goto L_0x003e
            goto L_0x0042
        L_0x003e:
            java.lang.String r0 = r6.getAsString()
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            java.lang.String r0 = ""
        L_0x0047:
            java.lang.String r6 = "searchPage_"
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r0)
            java.lang.Class<com.didi.soda.customer.foundation.storage.FeedBackStrategyStore> r0 = com.didi.soda.customer.foundation.storage.FeedBackStrategyStore.class
            java.lang.Object r0 = com.didi.soda.customer.foundation.util.SingletonFactory.get(r0)
            com.didi.soda.customer.foundation.storage.FeedBackStrategyStore r0 = (com.didi.soda.customer.foundation.storage.FeedBackStrategyStore) r0
            com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig r6 = r0.getData((java.lang.String) r6)
            if (r6 != 0) goto L_0x005d
            return r2
        L_0x005d:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            java.util.Date r1 = new java.util.Date
            long r3 = r6.getLastRemoveTime()
            r1.<init>(r3)
            r0.setTime(r1)
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            r1 = 6
            int r0 = r0.get(r1)
            int r6 = r6.get(r1)
            int r0 = r0 - r6
            if (r0 != 0) goto L_0x007f
            r6 = 1
            return r6
        L_0x007f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.result.SearchResultDataSource.m31048a(com.google.gson.JsonObject):boolean");
    }

    /* renamed from: a */
    private final JsonObject m31042a(String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", ParseType.MORE_TITLE);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("title", str2);
        jsonObject2.addProperty("type", str);
        Unit unit = Unit.INSTANCE;
        jsonObject.add("data", jsonObject2);
        return jsonObject;
    }

    /* renamed from: a */
    private final void m31047a(String str, List<JsonObject> list) {
        List mapExpandData$default;
        SearchResultDataMapFunction searchResultDataMapFunction = this.f43728e;
        if (searchResultDataMapFunction != null && (mapExpandData$default = SearchResultDataMapFunction.mapExpandData$default(searchResultDataMapFunction, 0, list, 1, (Object) null)) != null) {
            List put = this.f43725b.put(str, mapExpandData$default);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r1 = new com.didi.soda.search.component.result.SearchResultDataSource$expandSavedData$2$diffCallback$1(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void expandSavedData(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Map<java.lang.String, java.util.List<com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel>> r0 = r3.f43725b
            if (r0 != 0) goto L_0x000b
            goto L_0x003d
        L_0x000b:
            java.lang.Object r0 = r0.get(r4)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x0014
            goto L_0x003d
        L_0x0014:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 != 0) goto L_0x001f
            goto L_0x003d
        L_0x001f:
            com.didi.soda.search.component.result.SearchResultDataSource$expandSavedData$2$diffCallback$1 r1 = new com.didi.soda.search.component.result.SearchResultDataSource$expandSavedData$2$diffCallback$1
            r1.<init>(r4)
            com.didi.soda.datasource.page.UpdateUtils$DiffCallback r1 = (com.didi.soda.datasource.page.UpdateUtils.DiffCallback) r1
            int r2 = r3.find(r1)
            if (r2 <= 0) goto L_0x003d
            r3.remove(r1)
            r3.insert((int) r2, (java.util.List<? extends com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel>) r0)
            java.util.Map<java.lang.String, java.util.List<com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel>> r0 = r3.f43725b
            if (r0 != 0) goto L_0x0037
            goto L_0x003d
        L_0x0037:
            java.lang.Object r4 = r0.remove(r4)
            java.util.List r4 = (java.util.List) r4
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.result.SearchResultDataSource.expandSavedData(java.lang.String):void");
    }

    public final void updateLastShopId(JsonObject jsonObject) {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        ArrayList arrayListOf = CollectionsKt.arrayListOf("1", "2", "3", "4");
        if (jsonObject != null && !jsonObject.isJsonNull()) {
            JsonElement jsonElement2 = jsonObject.get("type");
            String asString2 = jsonElement2 == null ? null : jsonElement2.getAsString();
            if (asString2 == null) {
                asString2 = "";
            }
            if (arrayListOf.contains(asString2)) {
                JsonElement jsonElement3 = jsonObject.get("data");
                String str = "0";
                if (!(jsonElement3 == null || (asJsonObject = jsonElement3.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("shopId")) == null || (asString = jsonElement.getAsString()) == null)) {
                    str = asString;
                }
                updateParams(new SearchResultDataSource$updateLastShopId$1(str));
            }
        }
    }
}
