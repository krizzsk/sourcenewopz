package com.didi.soda.home.topgun.component.topic.data;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.AccountErrorConsumer;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.listener.PageEventListener;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.PageController;
import com.didi.soda.datasource.page.PageStore;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import java.util.ArrayList;
import java.util.List;

public class HomeTopicDataSource implements DataSourceListener<ComponentEntity, RecyclerModel>, PageEventListener, PayloadProvider<FeedPayload> {

    /* renamed from: a */
    private static final String f42886a = "HomeTopicDataSource";

    /* renamed from: b */
    private ScopeContext f42887b;

    /* renamed from: c */
    private String f42888c;

    /* renamed from: d */
    private PageStore<ComponentEntity, RecyclerModel> f42889d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PageController<HomeFeedParam, ComponentEntity> f42890e;

    /* renamed from: f */
    private List<Action1> f42891f = new ArrayList();

    /* renamed from: g */
    private List<Action1> f42892g = new ArrayList();

    /* renamed from: h */
    private List<Action1> f42893h = new ArrayList();

    /* renamed from: i */
    private int f42894i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f42895j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f42896k;

    /* renamed from: l */
    private CustomerRpcService f42897l;

    /* renamed from: m */
    private AccountErrorConsumer f42898m;

    public HomeTopicDataSource(ScopeContext scopeContext, String str) {
        this.f42887b = scopeContext;
        this.f42888c = str;
        this.f42889d = new PageStore<>(new HomeTopicDataMapFunction(this), this);
        PageController<HomeFeedParam, ComponentEntity> pageController = new PageController<>();
        this.f42890e = pageController;
        pageController.initialize(0, this, this.f42889d);
        this.f42897l = CustomerRpcManagerProxy.get();
    }

    public void loadInit() {
        this.f42890e.loadInit();
    }

    public void loadNextPage() {
        this.f42890e.loadNextPage();
    }

    public void subscribePageResult(Action1<CustomerResource<HomeFeedEntity>> action1) {
        this.f42891f.add(action1);
    }

    public void subscribeListChanged(Action1<List<RecyclerModel>> action1) {
        this.f42892g.add(action1);
    }

    public void subscribeListUpdate(Action1<List<RecyclerModel>> action1) {
        this.f42893h.add(action1);
    }

    public void update(UpdateUtils.DiffCallback diffCallback, UpdateUtils.UpdateCallback updateCallback) {
        this.f42889d.update(diffCallback, updateCallback);
    }

    public void remove(UpdateUtils.DiffCallback diffCallback) {
        this.f42889d.remove(diffCallback);
    }

    public void insert(int i, RecyclerModel recyclerModel) {
        this.f42889d.insert(i, recyclerModel);
    }

    public int getPageIndex() {
        return this.f42894i;
    }

    public void onPageLoad(int i, Object obj) {
        this.f42894i = i;
        m30352a(this.f42887b, i, this.f42888c);
    }

    public void onPageResult(CustomerResource<HomeFeedEntity> customerResource) {
        for (Action1 call : this.f42891f) {
            call.call(customerResource);
        }
    }

    public void onDataSourceChanged(PageStore<ComponentEntity, RecyclerModel> pageStore, List<RecyclerModel> list) {
        for (Action1 call : this.f42892g) {
            call.call(list);
        }
    }

    public void onDataSourceUpdate(List<RecyclerModel> list) {
        for (Action1 call : this.f42893h) {
            call.call(list);
        }
    }

    public boolean contains(UpdateUtils.DiffCallback diffCallback) {
        return this.f42889d.contains(diffCallback);
    }

    public List getTargetList() {
        return this.f42889d.getTargetList();
    }

    public boolean hasMore() {
        return this.f42895j;
    }

    public FeedPayload providePayload() {
        FeedPayload feedPayload = new FeedPayload();
        feedPayload.mPageId = "showAll";
        feedPayload.mPageIndex = this.f42894i;
        feedPayload.mRecId = this.f42896k;
        return feedPayload;
    }

    /* renamed from: a */
    private void m30352a(ScopeContext scopeContext, final int i, String str) {
        if (this.f42898m == null) {
            this.f42898m = new AccountErrorConsumer(scopeContext);
        }
        this.f42897l.getHomeTopicFeedV2(i, str, new CustomerRpcCallback<HomeFeedEntity>() {
            public void onRpcSuccess(HomeFeedEntity homeFeedEntity, long j) {
                boolean unused = HomeTopicDataSource.this.f42895j = homeFeedEntity.mHasMore && LoginUtil.isLogin();
                String unused2 = HomeTopicDataSource.this.f42896k = homeFeedEntity.mRecId;
                HomeTopicDataSource.this.f42890e.receiveResult(homeFeedEntity.mComponentList, i);
                HomeTopicDataSource.this.onPageResult(CustomerResource.success(homeFeedEntity));
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                HomeTopicDataSource.this.onPageResult(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            }
        });
    }
}
