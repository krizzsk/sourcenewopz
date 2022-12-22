package com.didi.soda.home.topgun.component.topic;

import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.app.constant.StringConst;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.home.topgun.component.topic.Contract;
import com.didi.soda.home.topgun.component.topic.data.HomeTopicDataSource;
import com.didi.soda.home.topgun.component.topic.data.HomeTopicOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.taxis99.R;
import java.util.List;

public class HomeTopicFeedPresenter extends Contract.AbsHomeTopicFeedPresenter {

    /* renamed from: a */
    private static final String f42879a = "HomeTopicFeedPresenter";

    /* renamed from: b */
    private Contract.AbsHomeTopicFeedView f42880b;

    /* renamed from: c */
    private HomeTopicDataSource f42881c;

    /* renamed from: d */
    private ChildDataListManager<RecyclerModel> f42882d;

    public void initDataManagers() {
        super.initDataManagers();
        m30344d();
    }

    public void onCreate() {
        super.onCreate();
        this.f42880b = (Contract.AbsHomeTopicFeedView) getLogicView();
        m30336a();
        HomeTopicOmegaHelper.getInstance().attach(getScopeContext());
        m30335a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
    }

    public void onDestroy() {
        super.onDestroy();
        HomeTopicOmegaHelper.getInstance().detach(getScopeContext());
        m30335a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
    }

    public void onFooterErrorClicked() {
        this.f42881c.loadNextPage();
    }

    public void onFooterSignInClicked() {
        if (!LoginUtil.isLogin()) {
            LoginUtil.loginActivityAndTrack(getContext(), 1);
        }
    }

    public void onLoadMore() {
        if (this.f42881c.hasMore() && !((Contract.AbsHomeTopicFeedView) getLogicView()).needBlockFooterLoading()) {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterLoadingView();
            this.f42881c.loadNextPage();
            m30335a("onLoadMore", "c-act|").build().info();
        }
    }

    public void onStart() {
        super.onStart();
        OmegaCommonParamHelper.refreshLv1GuideParam();
        m30335a("onStart", "c-state|").build().info();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        m30335a("onStop", "c-state|").build().info();
    }

    /* access modifiers changed from: package-private */
    public void onClickBack() {
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName")).build().track();
    }

    /* renamed from: a */
    private void m30336a() {
        this.f42880b.updateTitle(getScopeContext().getBundle().getString(Const.PageParams.HOME_COMPONENT_TITLE, ""));
        m30341b();
    }

    /* renamed from: b */
    private void m30341b() {
        HomeTopicDataSource homeTopicDataSource = new HomeTopicDataSource(getScopeContext(), getScopeContext().getBundle().getString(Const.PageParams.HOME_COMPONENT_ID));
        this.f42881c = homeTopicDataSource;
        homeTopicDataSource.subscribeListChanged(new Action1() {
            public final void call(Object obj) {
                HomeTopicFeedPresenter.this.m30340a((List) obj);
            }
        });
        this.f42881c.subscribePageResult(new Action1() {
            public final void call(Object obj) {
                HomeTopicFeedPresenter.this.m30338a((CustomerResource) obj);
            }
        });
        m30343c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30340a(List list) {
        if (CollectionsUtil.isEmpty(list)) {
            m30339a(getContext().getResources().getString(R.string.customer_service_not_connected));
            return;
        }
        this.f42882d.set(list);
        m30346f();
        if (this.f42881c.getPageIndex() == 0) {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).scrollToTop();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30338a(CustomerResource customerResource) {
        this.f42880b.dismissLoadingDialog();
        this.f42880b.dismissPullToRefresh();
        if (customerResource == null || customerResource.status == Resource.Status.ERROR || customerResource.data == null) {
            HomeTopicOmegaHelper.getInstance().trackHomeTopicFeedShow((HomeFeedEntity) null, ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress(), "");
            String string = getContext().getResources().getString(R.string.customer_service_not_connected);
            if (customerResource != null && !TextUtils.isEmpty(customerResource.message) && !customerResource.message.contains(StringConst.JAVA)) {
                string = customerResource.message;
            }
            m30339a(string);
            return;
        }
        HomeTopicOmegaHelper.getInstance().trackHomeTopicFeedShow((HomeFeedEntity) customerResource.data, ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress(), ((HomeFeedEntity) customerResource.data).mRecId);
    }

    /* renamed from: a */
    private void m30339a(String str) {
        ((Contract.AbsHomeTopicFeedView) getLogicView()).dismissLoadingDialog();
        this.f42880b.showFooterEmptyView();
        if (this.f42881c.getPageIndex() > 0) {
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterErrorView();
            } else {
                ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterNoNetView();
            }
            m30335a("updateErrorState -> Footer Error", "c-data|").build().error();
        } else if (NetWorkUtils.isNetworkConnected(getContext())) {
            m30345e();
            TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel.mHeight = ((Contract.AbsHomeTopicFeedView) getLogicView()).calculateAbnormalHeight();
            topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeTopicFeedPresenter.this.m30342b(view);
                }
            }));
            this.f42882d.add(topGunAbnormalRvModel);
            m30335a("updateErrorState -> Network", "c-data|").build().error();
        } else if (CollectionsUtil.isEmpty(this.f42881c.getTargetList())) {
            m30345e();
            TopGunAbnormalRvModel topGunAbnormalRvModel2 = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel2.mHeight = ((Contract.AbsHomeTopicFeedView) getLogicView()).calculateAbnormalHeight();
            topGunAbnormalRvModel2.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeTopicFeedPresenter.this.m30337a(view);
                }
            }));
            this.f42882d.add(topGunAbnormalRvModel2);
            m30335a("updateErrorState -> Service No Cache", "c-data|").build().error();
        } else {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showNetErrorToast();
            m30335a("updateErrorState -> Service Use Cache", "c-data|").build().error();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30342b(View view) {
        m30343c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30337a(View view) {
        m30343c();
    }

    /* renamed from: c */
    private void m30343c() {
        ((Contract.AbsHomeTopicFeedView) getLogicView()).showLoadingView();
        this.f42881c.loadInit();
    }

    /* renamed from: d */
    private void m30344d() {
        if (this.f42882d == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f42882d = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    /* renamed from: e */
    private void m30345e() {
        this.f42882d.clear();
    }

    /* renamed from: f */
    private void m30346f() {
        if (this.f42881c.hasMore()) {
            this.f42880b.showFooterEmptyView();
        } else if (!LoginUtil.isLogin()) {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooteSignInView();
        } else {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterNoMoreView();
        }
        m30335a("updatePageMoreState", "c-data|").setOtherParam("hasMore", this.f42881c.hasMore() ? "1" : "0").build().info();
    }

    /* renamed from: a */
    private RecordTracker.Builder m30335a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f42879a).setLogModule("m-home|").setMessage(str).setLogCategory(str2);
    }
}
