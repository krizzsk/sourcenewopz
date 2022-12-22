package com.didi.soda.datasource.page;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.datasource.listener.DataMapFunction;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.listener.PageEventListener;
import com.didi.soda.datasource.page.PageParams;
import com.didi.soda.datasource.page.UpdateUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00070\u0006:\u0002RSB+\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0002\u0010\rJ\u0016\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#J\u0015\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0000H$¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020)2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#J\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011J.\u0010-\u001a\u00020%2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00020/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00112\u0006\u00101\u001a\u00020)H\u0014J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u00010\u0007J\u001e\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020)2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011J%\u00106\u001a\u00020%2\u001b\b\u0002\u00107\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%\u0018\u000108¢\u0006\u0002\b9H\u0007J%\u0010:\u001a\u00020)2\u001b\b\u0002\u00107\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%\u0018\u000108¢\u0006\u0002\b9H\u0007J&\u0010;\u001a\u00020%2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00020/2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010=H\u0002J\b\u0010>\u001a\u00020%H\u0002J\u0016\u0010?\u001a\u00020%2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00020/H\u0002J*\u0010@\u001a\u00020%2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u001a2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0016J\u0016\u0010C\u001a\u00020%2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0016J\u001f\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010GJ\u0016\u0010H\u001a\u00020%2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#J\u001a\u0010I\u001a\u00020%2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0014J\u001a\u0010K\u001a\u00020%2\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010J\u001a\u0010M\u001a\u00020%2\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010J\"\u0010N\u001a\u00020%2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070PJ\u001f\u0010Q\u001a\u00020%2\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%08¢\u0006\u0002\b9R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00140\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u001aX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006T"}, mo175978d2 = {"Lcom/didi/soda/datasource/page/DataSource;", "Params", "Lcom/didi/soda/datasource/page/PageParams;", "Value", "Result", "Lcom/didi/soda/datasource/listener/PageEventListener;", "Lcom/didi/soda/datasource/listener/DataSourceListener;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "params", "dataMapFunction", "Lcom/didi/soda/datasource/listener/DataMapFunction;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/datasource/page/PageParams;Lcom/didi/soda/datasource/listener/DataMapFunction;)V", "mListChangeActions", "", "Lcom/didi/app/nova/skeleton/repo/Action1;", "", "mListUpdateActions", "mOnDataSourceListenrs", "Lcom/didi/soda/datasource/page/DataSource$OnDataSourceListener;", "mPageController", "Lcom/didi/soda/datasource/page/PageController;", "mPageParams", "Lcom/didi/soda/datasource/page/PageParams;", "mPageStore", "Lcom/didi/soda/datasource/page/PageStore;", "mScopeContext", "getMScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setMScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "contains", "", "diffCallback", "Lcom/didi/soda/datasource/page/UpdateUtils$DiffCallback;", "fetchData", "", "param", "(Lcom/didi/soda/datasource/page/PageParams;)V", "find", "", "getPageParams", "()Lcom/didi/soda/datasource/page/PageParams;", "getTargetList", "handleResult", "resource", "Lcom/didi/soda/customer/repo/CustomerResource;", "valueList", "pageIndex", "insert", "pos", "item", "list", "loadInit", "paramsblock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "loadNextPage", "notifyAfterPageResult", "pageResult", "Lcom/didi/soda/datasource/page/PageResult;", "notifyBeginRequest", "notifyEndRequest", "onDataSourceChanged", "pageStorage", "modelList", "onDataSourceUpdate", "updatedList", "onPageLoad", "key", "(ILcom/didi/soda/datasource/page/PageParams;)V", "remove", "setOnDataSourceListener", "listener", "subscribeListChanged", "action", "subscribeListUpdate", "update", "updateCallback", "Lcom/didi/soda/datasource/page/UpdateUtils$UpdateCallback;", "updateParams", "OnDataSourceListener", "SimpleDataSourceListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataSource.kt */
public abstract class DataSource<Params extends PageParams, Value, Result> implements DataSourceListener<Value, RecyclerModel>, PageEventListener<Params> {

    /* renamed from: a */
    private Params f42256a;

    /* renamed from: b */
    private PageStore<Value, RecyclerModel> f42257b;

    /* renamed from: c */
    private PageController<Params, Value> f42258c;

    /* renamed from: d */
    private List<OnDataSourceListener<Value, Result>> f42259d = new ArrayList();

    /* renamed from: e */
    private List<Action1<List<RecyclerModel>>> f42260e = new ArrayList();

    /* renamed from: f */
    private List<Action1<List<RecyclerModel>>> f42261f = new ArrayList();
    public ScopeContext mScopeContext;

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u00022\u00020\u0003J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00040\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0005H&J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00040\u0007H&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/datasource/page/DataSource$OnDataSourceListener;", "Value", "Result", "", "onAfterPageResult", "", "resource", "Lcom/didi/soda/customer/repo/CustomerResource;", "pageResult", "Lcom/didi/soda/datasource/page/PageResult;", "onBeginRequest", "onEndRequest", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DataSource.kt */
    public interface OnDataSourceListener<Value, Result> {
        void onAfterPageResult(CustomerResource<Result> customerResource, PageResult<Value> pageResult);

        void onBeginRequest();

        void onEndRequest(CustomerResource<Result> customerResource);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00040\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00040\bH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/datasource/page/DataSource$SimpleDataSourceListener;", "Value", "Result", "Lcom/didi/soda/datasource/page/DataSource$OnDataSourceListener;", "()V", "onAfterPageResult", "", "homeFeedEntityResource", "Lcom/didi/soda/customer/repo/CustomerResource;", "pageResult", "Lcom/didi/soda/datasource/page/PageResult;", "onBeginRequest", "onEndRequest", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DataSource.kt */
    public static class SimpleDataSourceListener<Value, Result> implements OnDataSourceListener<Value, Result> {
        public void onAfterPageResult(CustomerResource<Result> customerResource, PageResult<Value> pageResult) {
            Intrinsics.checkNotNullParameter(customerResource, "homeFeedEntityResource");
        }

        public void onBeginRequest() {
        }

        public void onEndRequest(CustomerResource<Result> customerResource) {
            Intrinsics.checkNotNullParameter(customerResource, "homeFeedEntityResource");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void fetchData(Params params);

    public final void loadInit() {
        loadInit$default(this, (Function1) null, 1, (Object) null);
    }

    public final int loadNextPage() {
        return loadNextPage$default(this, (Function1) null, 1, (Object) null);
    }

    public final ScopeContext getMScopeContext() {
        ScopeContext scopeContext = this.mScopeContext;
        if (scopeContext != null) {
            return scopeContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mScopeContext");
        return null;
    }

    public final void setMScopeContext(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "<set-?>");
        this.mScopeContext = scopeContext;
    }

    public DataSource(ScopeContext scopeContext, Params params, DataMapFunction<Value, RecyclerModel> dataMapFunction) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(dataMapFunction, "dataMapFunction");
        setMScopeContext(scopeContext);
        params.reset();
        Unit unit = Unit.INSTANCE;
        this.f42256a = params;
        this.f42257b = new PageStore<>(dataMapFunction, this);
        PageController<Params, Value> pageController = new PageController<>();
        this.f42258c = pageController;
        PageStore<Value, RecyclerModel> pageStore = null;
        if (pageController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageController");
            pageController = null;
        }
        PageEventListener pageEventListener = this;
        PageStore<Value, RecyclerModel> pageStore2 = this.f42257b;
        if (pageStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
        } else {
            pageStore = pageStore2;
        }
        pageController.initialize(0, pageEventListener, pageStore);
    }

    public final Params getPageParams() {
        Params params = this.f42256a;
        if (params != null) {
            return params;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPageParams");
        return null;
    }

    public final void updateParams(Function1<? super Params, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "paramsblock");
        Params params = this.f42256a;
        if (params == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageParams");
            params = null;
        }
        function1.invoke(params);
    }

    public static /* synthetic */ void loadInit$default(DataSource dataSource, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            dataSource.loadInit(function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadInit");
    }

    public final void loadInit(Function1<? super Params, Unit> function1) {
        if (function1 != null) {
            updateParams(function1);
        }
        PageController<Params, Value> pageController = this.f42258c;
        if (pageController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageController");
            pageController = null;
        }
        pageController.loadInit();
    }

    public static /* synthetic */ int loadNextPage$default(DataSource dataSource, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            return dataSource.loadNextPage(function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadNextPage");
    }

    public final int loadNextPage(Function1<? super Params, Unit> function1) {
        if (function1 != null) {
            updateParams(new DataSource$loadNextPage$1$1(function1));
        }
        PageController<Params, Value> pageController = this.f42258c;
        if (pageController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageController");
            pageController = null;
        }
        return pageController.loadNextPage();
    }

    public final void insert(int i, RecyclerModel recyclerModel) {
        PageStore<Value, RecyclerModel> pageStore = this.f42257b;
        if (pageStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
            pageStore = null;
        }
        pageStore.insert(i, recyclerModel);
    }

    public final void insert(int i, List<? extends RecyclerModel> list) {
        PageStore<Value, RecyclerModel> pageStore = this.f42257b;
        if (pageStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
            pageStore = null;
        }
        pageStore.insert(i, (List<RecyclerModel>) list);
    }

    public final void remove(UpdateUtils.DiffCallback<RecyclerModel> diffCallback) {
        PageStore<Value, RecyclerModel> pageStore = this.f42257b;
        if (pageStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
            pageStore = null;
        }
        pageStore.remove(diffCallback);
    }

    public final void update(UpdateUtils.DiffCallback<RecyclerModel> diffCallback, UpdateUtils.UpdateCallback<RecyclerModel> updateCallback) {
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        PageStore<Value, RecyclerModel> pageStore = this.f42257b;
        if (pageStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
            pageStore = null;
        }
        pageStore.update(diffCallback, updateCallback);
    }

    public final int find(UpdateUtils.DiffCallback<RecyclerModel> diffCallback) {
        PageStore<Value, RecyclerModel> pageStore = this.f42257b;
        if (pageStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
            pageStore = null;
        }
        return pageStore.find(diffCallback);
    }

    public final boolean contains(UpdateUtils.DiffCallback<RecyclerModel> diffCallback) {
        PageStore<Value, RecyclerModel> pageStore = this.f42257b;
        if (pageStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
            pageStore = null;
        }
        return pageStore.contains(diffCallback);
    }

    public final List<RecyclerModel> getTargetList() {
        PageStore<Value, RecyclerModel> pageStore = this.f42257b;
        if (pageStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageStore");
            pageStore = null;
        }
        return pageStore.getTargetList();
    }

    public void onPageLoad(int i, Params params) {
        Params params2 = this.f42256a;
        Params params3 = null;
        if (params2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageParams");
            params2 = null;
        }
        params2.setPageIndex(i);
        m29783a();
        Params params4 = this.f42256a;
        if (params4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageParams");
        } else {
            params3 = params4;
        }
        fetchData(params3);
    }

    /* access modifiers changed from: protected */
    public void handleResult(CustomerResource<Result> customerResource, List<? extends Value> list, int i) {
        Intrinsics.checkNotNullParameter(customerResource, "resource");
        m29784a(customerResource);
        if (customerResource.status == Resource.Status.SUCCESS && customerResource.data != null) {
            PageController<Params, Value> pageController = this.f42258c;
            if (pageController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPageController");
                pageController = null;
            }
            m29785a(customerResource, pageController.receiveResult(list, i));
        }
    }

    public final void subscribeListChanged(Action1<List<RecyclerModel>> action1) {
        Intrinsics.checkNotNullParameter(action1, "action");
        this.f42260e.add(action1);
    }

    public final void subscribeListUpdate(Action1<List<RecyclerModel>> action1) {
        Intrinsics.checkNotNullParameter(action1, "action");
        this.f42261f.add(action1);
    }

    public void onDataSourceChanged(PageStore<Value, RecyclerModel> pageStore, List<? extends RecyclerModel> list) {
        Intrinsics.checkNotNullParameter(pageStore, "pageStorage");
        Intrinsics.checkNotNullParameter(list, "modelList");
        for (Action1 call : this.f42260e) {
            call.call(list);
        }
    }

    public void onDataSourceUpdate(List<? extends RecyclerModel> list) {
        Intrinsics.checkNotNullParameter(list, "updatedList");
        for (Action1 call : this.f42261f) {
            call.call(list);
        }
    }

    public final void setOnDataSourceListener(OnDataSourceListener<Value, Result> onDataSourceListener) {
        Intrinsics.checkNotNullParameter(onDataSourceListener, "listener");
        this.f42259d.add(onDataSourceListener);
    }

    /* renamed from: a */
    private final void m29783a() {
        for (OnDataSourceListener onBeginRequest : this.f42259d) {
            onBeginRequest.onBeginRequest();
        }
    }

    /* renamed from: a */
    private final void m29784a(CustomerResource<Result> customerResource) {
        for (OnDataSourceListener onEndRequest : this.f42259d) {
            onEndRequest.onEndRequest(customerResource);
        }
    }

    /* renamed from: a */
    private final void m29785a(CustomerResource<Result> customerResource, PageResult<Value> pageResult) {
        for (OnDataSourceListener onAfterPageResult : this.f42259d) {
            onAfterPageResult.onAfterPageResult(customerResource, pageResult);
        }
    }
}
