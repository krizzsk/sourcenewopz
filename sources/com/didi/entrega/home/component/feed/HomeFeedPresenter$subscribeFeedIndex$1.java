package com.didi.entrega.home.component.feed;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.ApiErrorUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.customer.widget.SingleChildDataListManager;
import com.didi.entrega.home.component.feed.Contract;
import com.didi.entrega.home.component.feed.entity.ComponentEntity;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import com.didi.entrega.home.manager.HomeFeedParser;
import com.didi.entrega.home.manager.HomeNoServiceRepo;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import com.didi.entrega.home.manager.RpcLazyLoader;
import com.didi.entrega.home.policy.HomePolicyHelper;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/entrega/home/component/feed/HomeFeedPresenter$subscribeFeedIndex$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/customer/repo/CustomerResource;", "Lcom/didi/entrega/home/component/feed/entity/HomeFeedEntity;", "call", "", "resource", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedPresenter.kt */
public final class HomeFeedPresenter$subscribeFeedIndex$1 implements Action1<CustomerResource<HomeFeedEntity>> {
    final /* synthetic */ HomeFeedPresenter this$0;

    HomeFeedPresenter$subscribeFeedIndex$1(HomeFeedPresenter homeFeedPresenter) {
        this.this$0 = homeFeedPresenter;
    }

    public void call(CustomerResource<HomeFeedEntity> customerResource) {
        Contract.AbsHomeFeedView absHomeFeedView;
        boolean z = false;
        this.this$0.f20649f = false;
        SingleChildDataListManager singleChildDataListManager = null;
        LogUtil.m14765i(this.this$0.f20652i, Intrinsics.stringPlus("subscribeFeedIndex:$ resource mIsLoading :", customerResource == null ? null : Integer.valueOf(customerResource.code)));
        Contract.AbsHomeFeedView absHomeFeedView2 = (Contract.AbsHomeFeedView) this.this$0.getLogicView();
        if (absHomeFeedView2 != null) {
            absHomeFeedView2.dismissShimmer();
        }
        Contract.AbsHomeFeedView absHomeFeedView3 = (Contract.AbsHomeFeedView) this.this$0.getLogicView();
        if (absHomeFeedView3 != null) {
            absHomeFeedView3.dismissAbnormal();
        }
        if (customerResource == null) {
            Contract.AbsHomeFeedView absHomeFeedView4 = (Contract.AbsHomeFeedView) this.this$0.getLogicView();
            if (absHomeFeedView4 != null) {
                absHomeFeedView4.showAbnormal(ResourceHelper.getString(R.string.FoodC_orderlist3_No_service_laow));
            }
        } else if (customerResource.status == Resource.Status.SUCCESS) {
            if (customerResource.data == null) {
                Contract.AbsHomeFeedView absHomeFeedView5 = (Contract.AbsHomeFeedView) this.this$0.getLogicView();
                if (absHomeFeedView5 != null) {
                    absHomeFeedView5.showAbnormal(customerResource.message);
                    return;
                }
                return;
            }
            Collection mComponentList = ((HomeFeedEntity) customerResource.data).getMComponentList();
            if (mComponentList == null || mComponentList.isEmpty()) {
                z = true;
            }
            if (z) {
                Contract.AbsHomeFeedView absHomeFeedView6 = (Contract.AbsHomeFeedView) this.this$0.getLogicView();
                if (absHomeFeedView6 != null) {
                    absHomeFeedView6.showAbnormal(ResourceHelper.getString(R.string.FoodC_orderlist3_No_service_laow));
                    return;
                }
                return;
            }
            List<ComponentEntity> mComponentList2 = ((HomeFeedEntity) customerResource.data).getMComponentList();
            if (mComponentList2 != null) {
                HomeFeedPresenter homeFeedPresenter = this.this$0;
                Function5 homeFeedPresenter$subscribeFeedIndex$1$call$1$copyFunction$1 = new HomeFeedPresenter$subscribeFeedIndex$1$call$1$copyFunction$1(homeFeedPresenter, customerResource);
                HomeFeedParser homeFeedParser = HomeFeedParser.INSTANCE;
                HomePolicyHelper access$getMHomePolicyHelper$p = homeFeedPresenter.f20647d;
                if (access$getMHomePolicyHelper$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomePolicyHelper");
                    access$getMHomePolicyHelper$p = null;
                }
                List<RecyclerModel> parseFeedIndex = homeFeedParser.parseFeedIndex(mComponentList2, access$getMHomePolicyHelper$p, homeFeedPresenter$subscribeFeedIndex$1$call$1$copyFunction$1);
                if (parseFeedIndex != null) {
                    SingleChildDataListManager access$getMFeedListManager$p = homeFeedPresenter.f20644a;
                    if (access$getMFeedListManager$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFeedListManager");
                    } else {
                        singleChildDataListManager = access$getMFeedListManager$p;
                    }
                    singleChildDataListManager.reset(parseFeedIndex);
                }
            }
            HomeOmegaHelper.Companion.trackHomeFeedShow();
        } else if (customerResource.status == Resource.Status.ERROR) {
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HOME_FEED_LOAD_ERROR).addModuleName("home").addErrorType(ApiErrorUtil.Companion.getErrorType(customerResource.code + "")).addErrorMsg(Intrinsics.stringPlus(customerResource.message, "")).build().trackError();
            if (!HomeNoServiceRepo.Companion.setNoServiceStatus(customerResource)) {
                if (!(customerResource.code == 40109 || (absHomeFeedView = (Contract.AbsHomeFeedView) this.this$0.getLogicView()) == null)) {
                    absHomeFeedView.showAbnormal(customerResource.message);
                }
            } else {
                return;
            }
        }
        RpcLazyLoader.getLoader().lazyRpc();
    }
}
