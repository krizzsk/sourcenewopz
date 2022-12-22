package com.didi.soda.search.component.result;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.DataSource;
import com.didi.soda.datasource.page.dynamic.DynamicDataSource;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.page.FilterPageKt;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.FilterHelper;
import com.didi.soda.home.topgun.model.FilterItemParam;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.search.component.result.Contract;
import com.didi.soda.search.component.result.binder.SearchResultComponentLogicUnit;
import com.didi.soda.search.helper.SearchLogHelper;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.didi.soda.search.repo.SearchWordModel;
import com.didi.soda.search.repo.SearchWordRepo;
import com.didi.soda.search.storage.SearchHistoryStorage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0002J \u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002J\b\u0010'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\fH\u0002J\u0012\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u0011H\u0014J\b\u00100\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u00020\u0011H\u0002J\b\u00105\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u0011H\u0014J\b\u00107\u001a\u00020\u0011H\u0014J\n\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<H\u0014JH\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010;\u001a\u00020<2&\u0010A\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020C\u0018\u00010Bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020C\u0018\u0001`D2\u0006\u0010E\u001a\u00020FH\u0002J\u0006\u0010G\u001a\u00020\u0011J\u0010\u0010H\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J \u0010I\u001a\u00020\u00112\b\u0010J\u001a\u0004\u0018\u00010+2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020+0$H\u0002J\u0010\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\fH\u0002JH\u0010N\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010;\u001a\u00020<2&\u0010A\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020C\u0018\u00010Bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020C\u0018\u0001`D2\u0006\u0010E\u001a\u00020FH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX.¢\u0006\u0002\n\u0000¨\u0006P"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultPresenter;", "Lcom/didi/soda/search/component/result/Contract$AbsSearchResultPresenter;", "()V", "mFilterDataManager", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "mFilterHelper", "Lcom/didi/soda/home/topgun/component/filter/FilterHelper;", "mFrom", "", "mHeaderComponentLoginUnit", "Lcom/didi/soda/search/component/result/binder/SearchResultComponentLogicUnit;", "mIsFirstVisible", "", "mSearchListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "attachSearchWordToBlock", "", "model", "Lcom/didi/soda/search/repo/SearchWordModel;", "confirm", "createDataSource", "Lcom/didi/soda/search/component/result/SearchResultDataSource;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "handleAbnormalView", "handleSearchAction", "handleSearchHistory", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchResultEntity;", "initDataManagers", "initDataSource", "initFilterData", "page", "", "filterList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/FilterEntity;", "initFilterEvent", "initSearchWordRepo", "isFilterNone", "notifyFilterItemClick", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "onAdjustableTitleExpend", "type", "onCreate", "onDestroy", "onLoadMore", "onPageResult", "data", "Landroid/os/Bundle;", "onResultLayoutGone", "onResultLayoutVisible", "onRetryClick", "onStart", "provideComponentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "registerScopeActions", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "removeFeedBackCard", "Lcom/didi/soda/blocks/action/ActionResult;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "resetFilter", "trackSw", "updateFilterModels", "mainFilter", "filterModelList", "updateFootView", "isNoFilter", "updateSceneTag", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultPresenter.kt */
public final class SearchResultPresenter extends Contract.AbsSearchResultPresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "SearchResultPresenter";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ChildDataListManager<RecyclerModel> f43743a;

    /* renamed from: b */
    private final FilterHelper f43744b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final FilterDataManager f43745c;

    /* renamed from: d */
    private boolean f43746d = true;

    /* renamed from: e */
    private String f43747e;

    /* renamed from: f */
    private SearchResultComponentLogicUnit f43748f = new SearchResultComponentLogicUnit(this);

    public SearchResultPresenter() {
        FilterHelper filterHelper = new FilterHelper(3);
        this.f43744b = filterHelper;
        this.f43745c = filterHelper.getFilterManager();
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultPresenter$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SearchResultPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCreate() {
        Bundle bundle;
        super.onCreate();
        SearchNewOmegaHelper.getInstance().attach(getScopeContext());
        ScopeContext scopeContext = getScopeContext();
        String str = null;
        if (!(scopeContext == null || (bundle = scopeContext.getBundle()) == null)) {
            str = bundle.getString("fromPage");
        }
        if (str == null) {
            str = "";
        }
        this.f43747e = str;
        m31066c();
        m31051a();
        m31068e();
        getScope().attach(BlocksConst.BLOCK_PARAM_ROUTE_PATH, RoutePath.SEARCH_HOME);
        getScope().attach("fromPage", Integer.valueOf(SearchNewOmegaHelper.getFromPageValueForTrack(this.f43747e)));
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f43743a == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            Intrinsics.checkNotNullExpressionValue(createChildDataListManager, "createChildDataListManager<RecyclerModel>()");
            this.f43743a = createChildDataListManager;
            if (createChildDataListManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchListManager");
                createChildDataListManager = null;
            }
            addDataManager(createChildDataListManager);
        }
    }

    public SearchResultDataSource createDataSource(ScopeContext scopeContext) {
        ScopeContext scopeContext2 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext2, "getScopeContext()");
        $$Lambda$SearchResultPresenter$KXB2CKuiIOyy3qm8sivmSnK1aM8 r1 = new PayloadProvider() {
            public final Object providePayload() {
                return SearchResultPresenter.m31050a(SearchResultPresenter.this);
            }
        };
        IBlockScope scope = getScope();
        Intrinsics.checkNotNullExpressionValue(scope, "scope");
        return new SearchResultDataSource(scopeContext2, r1, scope);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final FeedPayload m31050a(SearchResultPresenter searchResultPresenter) {
        SearchResultPageParam searchResultPageParam;
        Intrinsics.checkNotNullParameter(searchResultPresenter, "this$0");
        FeedPayload feedPayload = new FeedPayload();
        DynamicDataSource dataSource = searchResultPresenter.getDataSource();
        if (!(dataSource == null || (searchResultPageParam = (SearchResultPageParam) dataSource.getPageParams()) == null)) {
            feedPayload.mPageId = RoutePath.SEARCH_HOME;
            feedPayload.mPageFilter = searchResultPageParam.getFilterParams();
            feedPayload.mRecId = searchResultPageParam.getRecId();
            feedPayload.mTraceId = searchResultPageParam.getTraceId();
            feedPayload.mIntentionType = searchResultPageParam.getIntentionType();
            feedPayload.mFromPage = searchResultPresenter.f43747e;
            feedPayload.mSearchWord = searchResultPageParam.getSearchTag();
            feedPayload.mSource = 2;
        }
        return feedPayload;
    }

    /* access modifiers changed from: protected */
    public void registerScopeActions(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        super.registerScopeActions(iBlockScope);
        iBlockScope.registerAction("removeFeedBack", new SearchResultPresenter$registerScopeActions$1(this));
        iBlockScope.registerAction("updateSceneTag", new SearchResultPresenter$registerScopeActions$2(this));
    }

    /* renamed from: a */
    private final void m31051a() {
        getDataSource().setOnDataSourceListener(new SearchResultPresenter$initDataSource$1(this));
        getDataSource().subscribeListChanged(new Action1() {
            public final void call(Object obj) {
                SearchResultPresenter.m31056a(SearchResultPresenter.this, (List) obj);
            }
        });
        getDataSource().subscribeListUpdate(new Action1() {
            public final void call(Object obj) {
                SearchResultPresenter.m31062b(SearchResultPresenter.this, (List) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31056a(SearchResultPresenter searchResultPresenter, List list) {
        Intrinsics.checkNotNullParameter(searchResultPresenter, "this$0");
        ChildDataListManager<RecyclerModel> childDataListManager = searchResultPresenter.f43743a;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchListManager");
            childDataListManager = null;
        }
        childDataListManager.set(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31062b(SearchResultPresenter searchResultPresenter, List list) {
        Intrinsics.checkNotNullParameter(searchResultPresenter, "this$0");
        Intrinsics.checkNotNull(list);
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                RecyclerModel recyclerModel = (RecyclerModel) list.get(i);
                ChildDataListManager<RecyclerModel> childDataListManager = searchResultPresenter.f43743a;
                ChildDataListManager<RecyclerModel> childDataListManager2 = null;
                if (childDataListManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchListManager");
                    childDataListManager = null;
                }
                int indexOf = childDataListManager.indexOf(recyclerModel);
                if (indexOf >= 0) {
                    ChildDataListManager<RecyclerModel> childDataListManager3 = searchResultPresenter.f43743a;
                    if (childDataListManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSearchListManager");
                    } else {
                        childDataListManager2 = childDataListManager3;
                    }
                    childDataListManager2.set(indexOf, recyclerModel);
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m31059a(int i, RecyclerModel recyclerModel) {
        JsonElement jsonElement;
        if (recyclerModel instanceof ComponentModel) {
            Object dataModel = ((ComponentModel) recyclerModel).getDataModel();
            String str = null;
            JsonObject jsonObject = dataModel instanceof JsonObject ? (JsonObject) dataModel : null;
            if (!(jsonObject == null || (jsonElement = jsonObject.get("type")) == null)) {
                str = jsonElement.getAsString();
            }
            if (TextUtils.equals(str, "1000")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ActionResult m31049a(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        getDataSource().remove($$Lambda$SearchResultPresenter$QDG_GdDyhDCZtD4Uh495Nr2TdhQ.INSTANCE);
        return ActionResult.Companion.resolve$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r4 = r5.get(com.didi.soda.customer.blocks.BlocksConst.ACTION_PARAMS_SCENE_ID);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.blocks.action.ActionResult m31060b(android.content.Context r3, com.didi.soda.blocks.scope.IBlockScope r4, java.util.HashMap<java.lang.String, java.lang.Object> r5, com.didi.soda.blocks.widget.Buildable r6) {
        /*
            r2 = this;
            r3 = 0
            if (r5 != 0) goto L_0x0005
        L_0x0003:
            r4 = r3
            goto L_0x0013
        L_0x0005:
            java.lang.String r4 = "sceneId"
            java.lang.Object r4 = r5.get(r4)
            if (r4 != 0) goto L_0x000f
            goto L_0x0003
        L_0x000f:
            java.lang.String r4 = r4.toString()
        L_0x0013:
            if (r4 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            java.lang.String r4 = ""
        L_0x0018:
            java.lang.String r5 = "searchPage_"
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r4)
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.Class<com.didi.soda.customer.foundation.storage.FeedBackStrategyStore> r0 = com.didi.soda.customer.foundation.storage.FeedBackStrategyStore.class
            java.lang.Object r0 = com.didi.soda.customer.foundation.util.SingletonFactory.get(r0)
            com.didi.soda.customer.foundation.storage.FeedBackStrategyStore r0 = (com.didi.soda.customer.foundation.storage.FeedBackStrategyStore) r0
            com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig r1 = r0.getData((java.lang.String) r4)
            if (r1 != 0) goto L_0x0036
            com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig r1 = new com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig
            r1.<init>()
        L_0x0036:
            r1.setSceneId(r4)
            r1.setLastRemoveTime(r5)
            r0.setData((com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig) r1)
            com.didi.soda.blocks.action.ActionResult$Companion r4 = com.didi.soda.blocks.action.ActionResult.Companion
            r5 = 1
            com.didi.soda.blocks.action.ActionResult r3 = com.didi.soda.blocks.action.ActionResult.Companion.resolve$default(r4, r3, r5, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.result.SearchResultPresenter.m31060b(android.content.Context, com.didi.soda.blocks.scope.IBlockScope, java.util.HashMap, com.didi.soda.blocks.widget.Buildable):com.didi.soda.blocks.action.ActionResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final boolean m31064b() {
        return getDataSource().find($$Lambda$SearchResultPresenter$MH6mRjODfUE1z5JOLsXbgm_BU_s.INSTANCE) >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final boolean m31065b(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof HomeNoResultRvModel;
    }

    /* renamed from: c */
    private final void m31066c() {
        this.f43745c.setFilterDataChangedListener(new SearchResultPresenter$initFilterEvent$1(this));
        this.f43744b.setOnFilterEvent(new SearchResultPresenter$initFilterEvent$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31052a(int i, List<? extends FilterEntity> list) {
        if (i != 0) {
            return;
        }
        if (list != null) {
            ((Contract.AbsSearchResultView) getLogicView()).showFilter();
            FilterDataManager filterDataManager = this.f43745c;
            if (filterDataManager != null) {
                filterDataManager.parseFilterEntity(list);
                return;
            }
            return;
        }
        ((Contract.AbsSearchResultView) getLogicView()).hideFilter();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31054a(FilterModel filterModel, List<? extends FilterModel> list) {
        ((Contract.AbsSearchResultView) getLogicView()).setFilterData(filterModel, list);
    }

    /* access modifiers changed from: protected */
    public void notifyFilterItemClick(FilterModel filterModel) {
        if (filterModel != null) {
            FilterHelper filterHelper = this.f43744b;
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            filterHelper.clickItem(filterModel, scopeContext);
        }
    }

    public final void onPageResult(Bundle bundle) {
        if (bundle != null && bundle.getBoolean(FilterPageKt.KEY_FILTER_CONFIRM)) {
            confirm();
        }
    }

    public final void resetFilter() {
        this.f43745c.resetAllFilter();
        confirm();
    }

    public final void confirm() {
        FilterModel mainFilterModel = this.f43745c.getMainFilterModel();
        List<FilterModel> filterModelListWithoutMain = this.f43745c.getFilterModelListWithoutMain(true);
        ArrayList<FilterItemParam> generateOutParams = this.f43745c.generateOutParams();
        m31054a(mainFilterModel, (List<? extends FilterModel>) filterModelListWithoutMain);
        SearchNewOmegaHelper.getInstance().reset();
        ((Contract.AbsSearchResultView) getLogicView()).showLoading(true);
        getDataSource().loadInit(new SearchResultPresenter$confirm$1(generateOutParams));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31053a(SearchResultEntity searchResultEntity) {
        SearchLogHelper.info(TAG, Intrinsics.stringPlus("handleSearchHistory, mIsDirtyWords = ", Boolean.valueOf(searchResultEntity.mIsDirtyWords)));
        if (!searchResultEntity.mIsDirtyWords) {
            new SearchHistoryStorage().addTag(((SearchResultPageParam) getDataSource().getPageParams()).getSearchTag());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31058a(boolean z) {
        if (((SearchResultPageParam) getDataSource().getPageParams()).getHasMore() || z) {
            ((Contract.AbsSearchResultView) getLogicView()).showFooterEmptyView();
        } else {
            ((Contract.AbsSearchResultView) getLogicView()).showFooterNoMoreView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m31067d() {
        ((Contract.AbsSearchResultView) getLogicView()).showNoResultView();
    }

    /* renamed from: a */
    private final void m31057a(SearchWordModel searchWordModel) {
        if (searchWordModel != null) {
            getScope().attach(BlocksConst.BLOCK_PARAM_SEARCH_SOTRT_TYPE, Integer.valueOf(searchWordModel.mSortType.getValue()));
        }
    }

    /* renamed from: e */
    private final void m31068e() {
        ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                SearchResultPresenter.m31055a(SearchResultPresenter.this, (SearchWordModel) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31055a(SearchResultPresenter searchResultPresenter, SearchWordModel searchWordModel) {
        String str;
        Intrinsics.checkNotNullParameter(searchResultPresenter, "this$0");
        searchResultPresenter.m31057a(searchWordModel);
        String str2 = null;
        if (searchWordModel == null) {
            str = null;
        } else {
            str = searchWordModel.mSearchTag;
        }
        if (str == null) {
            str = "";
        }
        SearchLogHelper.info(TAG, Intrinsics.stringPlus("SearchWordRepo,  ", str));
        if (searchWordModel != null) {
            str2 = searchWordModel.mSearchTag;
        }
        if (StringUtils.isEmpty(str2)) {
            ((Contract.AbsSearchResultView) searchResultPresenter.getLogicView()).setSearchResultLayoutVisibility(8);
            searchResultPresenter.m31070g();
            return;
        }
        ((Contract.AbsSearchResultView) searchResultPresenter.getLogicView()).setSearchResultLayoutVisibility(0);
        searchResultPresenter.m31069f();
        Intrinsics.checkNotNull(searchWordModel);
        Intrinsics.checkNotNullExpressionValue(searchWordModel, "model!!");
        searchResultPresenter.m31063b(searchWordModel);
    }

    /* renamed from: b */
    private final void m31063b(SearchWordModel searchWordModel) {
        PageRenderingTrackerNew.Companion.trackStartUtil(getScopeContext());
        SearchNewOmegaHelper.getInstance().reset();
        ((Contract.AbsSearchResultView) getLogicView()).hideAbnormalView();
        getDataSource().loadInit(new SearchResultPresenter$handleSearchAction$1(searchWordModel));
    }

    /* access modifiers changed from: protected */
    public void onRetryClick() {
        DynamicDataSource dataSource = getDataSource();
        Intrinsics.checkNotNullExpressionValue(dataSource, "dataSource");
        DataSource.loadInit$default(dataSource, (Function1) null, 1, (Object) null);
    }

    public void onLoadMore() {
        if (((SearchResultPageParam) getDataSource().getPageParams()).getHasMore() && !((Contract.AbsSearchResultView) getLogicView()).isFooterViewLoading()) {
            ((Contract.AbsSearchResultView) getLogicView()).showFooterLoadingView();
            SearchLogHelper.info(TAG, Intrinsics.stringPlus("onLoadMore, pageNo = ", Integer.valueOf(((SearchResultPageParam) getDataSource().getPageParams()).getPageIndex())));
            DynamicDataSource dataSource = getDataSource();
            Intrinsics.checkNotNullExpressionValue(dataSource, "dataSource");
            DataSource.loadNextPage$default(dataSource, (Function1) null, 1, (Object) null);
        }
    }

    /* renamed from: f */
    private final void m31069f() {
        if (this.f43746d) {
            ((Contract.AbsSearchResultView) getLogicView()).showLoading(false);
            this.f43746d = false;
        } else {
            ((Contract.AbsSearchResultView) getLogicView()).showLoading(true);
        }
        ((Contract.AbsSearchResultView) getLogicView()).showFooterEmptyView();
    }

    /* renamed from: g */
    private final void m31070g() {
        this.f43746d = true;
    }

    public void onAdjustableTitleExpend(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        DynamicDataSource dataSource = getDataSource();
        if (dataSource != null) {
            SearchResultDataSource searchResultDataSource = (SearchResultDataSource) dataSource;
            searchResultDataSource.expandSavedData(str);
            SearchNewOmegaHelper.getInstance().brandSearchSeeMoreCk(((SearchResultPageParam) searchResultDataSource.getPageParams()).getSearchTag(), ((SearchResultPageParam) searchResultDataSource.getPageParams()).getIntentionType());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.search.component.result.SearchResultDataSource");
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        return this.f43748f;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        OmegaCommonParamHelper.refreshLv1GuideParam();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        SearchNewOmegaHelper.getInstance().detach(getScopeContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m31061b(SearchResultEntity searchResultEntity) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Search.RESULT_SW, getScopeContext());
        String searchTag = ((SearchResultPageParam) getDataSource().getPageParams()).getSearchTag();
        String str = "";
        if (searchTag == null) {
            searchTag = str;
        }
        OmegaTracker.Builder addEventParam = create.addEventParam("search_word", searchTag).addEventParam("search_word_source", Integer.valueOf(((SearchResultPageParam) getDataSource().getPageParams()).getSearchFrom())).addEventParam("result_num", Integer.valueOf(searchResultEntity.getSearchResultNum())).addEventParam(ParamConst.OPERATE_NUM, Integer.valueOf(searchResultEntity.getOperateNum())).addEventParam(ParamConst.OUT_RANGE_NUM, Integer.valueOf(searchResultEntity.getOutRangeNum()));
        String recId = ((SearchResultPageParam) getDataSource().getPageParams()).getRecId();
        if (recId == null) {
            recId = str;
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("rec_id", recId);
        String sugId = ((SearchResultPageParam) getDataSource().getPageParams()).getSugId();
        if (sugId == null) {
            sugId = str;
        }
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.SUG_REG_ID, sugId);
        String sugCkJson = ((SearchResultPageParam) getDataSource().getPageParams()).getSugCkJson();
        if (sugCkJson != null) {
            str = sugCkJson;
        }
        addEventParam3.addEventParam(ParamConst.SUG_CK_JSON, str).addEventParam(ParamConst.PARAM_PAGE_ID, Integer.valueOf(((SearchResultPageParam) getDataSource().getPageParams()).getPageIndex())).addEventParam("search_word_type", Integer.valueOf(((SearchResultPageParam) getDataSource().getPageParams()).getIntentionType())).addEventParam(ParamConst.SEARCH_HIGE_RATING_RECALL_NUM, Integer.valueOf(((SearchResultPageParam) getDataSource().getPageParams()).getHighRatingRecallNumm())).addEventParam("from", Integer.valueOf(SearchNewOmegaHelper.getFromPageValueForTrack(this.f43747e))).enableGuideParam().build().track();
    }
}
