package com.didi.soda.home.component.category.landing;

import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.StringConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.datasource.page.DataSource;
import com.didi.soda.home.component.category.landing.Contract;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.didi.soda.home.topgun.manager.ShopCateLandingOmegaHelper;
import com.google.gson.JsonObject;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter$initShopCateDataSource$dataSourceListener$1", "Lcom/didi/soda/datasource/page/DataSource$SimpleDataSourceListener;", "Lcom/google/gson/JsonObject;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "onAfterPageResult", "", "resource", "Lcom/didi/soda/customer/repo/CustomerResource;", "pageResult", "Lcom/didi/soda/datasource/page/PageResult;", "onEndRequest", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter$initShopCateDataSource$dataSourceListener$1 */
/* compiled from: ShopCategoryLandingPresenter.kt */
public final class C13963x22c39891 extends DataSource.SimpleDataSourceListener<JsonObject, HomeEntity> {
    final /* synthetic */ ShopCategoryLandingPresenter this$0;

    C13963x22c39891(ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        this.this$0 = shopCategoryLandingPresenter;
    }

    public void onEndRequest(CustomerResource<HomeEntity> customerResource) {
        Intrinsics.checkNotNullParameter(customerResource, "resource");
        super.onEndRequest(customerResource);
        ((Contract.AbsShopCategoryLandingView) this.this$0.getLogicView()).dismissLoading();
        ((Contract.AbsShopCategoryLandingView) this.this$0.getLogicView()).dismissPullToRefresh();
        ((Contract.AbsShopCategoryLandingView) this.this$0.getLogicView()).hideShimmerView();
        if (customerResource.status == Resource.Status.SUCCESS) {
            if (customerResource.data == null) {
                ShopCategoryLandingPresenter shopCategoryLandingPresenter = this.this$0;
                String string = shopCategoryLandingPresenter.getContext().getResources().getString(R.string.customer_service_not_connected);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…er_service_not_connected)");
                shopCategoryLandingPresenter.m30004a(-1, string);
                LogUtil.m29104i(this.this$0.f42561a, " data action call -> data is null");
                return;
            }
            LogUtil.m29104i(this.this$0.f42561a, "data action call -> data is normal");
            if (((HomeFeedParam) this.this$0.getDataSource().getPageParams()).getPageIndex() == 0) {
                ShopCateLandingOmegaHelper.getInstance().trackShopCateLandingSW(((HomeFeedParam) this.this$0.getDataSource().getPageParams()).getTraceId(), ((HomeFeedParam) this.this$0.getDataSource().getPageParams()).getCateId());
                ShopCateLandingOmegaHelper.getInstance().categoryNotifySw(((HomeEntity) customerResource.data).getMNotifyEntity());
            }
        } else if (customerResource.status == Resource.Status.ERROR) {
            if (ApiErrorConst.isAccountAbnormal(customerResource.code)) {
                ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(GlobalContext.getContext(), ApiErrorConst.LogoutReasons.getSignReasonByErrorCode(customerResource.code));
                LoginUtil.trackLogOut(customerResource.code);
                ConversionOmegaHelper.track(EventConst.Conversion.GOTO_LOGIN);
                LoginUtil.loginActivityAndTrack(this.this$0.getContext(), 12);
            } else {
                String string2 = ResourceHelper.getString(R.string.customer_service_not_connected);
                String str = customerResource.message;
                if (str != null && !StringsKt.contains$default((CharSequence) str, (CharSequence) StringConst.JAVA, false, 2, (Object) null)) {
                    string2 = customerResource.message;
                }
                ShopCategoryLandingPresenter shopCategoryLandingPresenter2 = this.this$0;
                int i = customerResource.code;
                Intrinsics.checkNotNullExpressionValue(string2, "errorMsg");
                shopCategoryLandingPresenter2.m30004a(i, string2);
            }
            ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HOME_CATE_NOTLOAD).addModuleName("home");
            ApiErrorUtil.Companion companion = ApiErrorUtil.Companion;
            addModuleName.addErrorType(companion.getErrorType(customerResource.code + "")).build().trackError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r4 = (com.didi.soda.home.topgun.manager.HomeFeedParam) r4.getPageParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAfterPageResult(com.didi.soda.customer.repo.CustomerResource<com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity> r3, com.didi.soda.datasource.page.PageResult<com.google.gson.JsonObject> r4) {
        /*
            r2 = this;
            java.lang.String r4 = "resource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.Object r4 = r3.data
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity r4 = (com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity) r4
            if (r4 != 0) goto L_0x000d
            goto L_0x0021
        L_0x000d:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$NaviStructBean r4 = r4.getMNavi()
            if (r4 != 0) goto L_0x0014
            goto L_0x0021
        L_0x0014:
            com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter r0 = r2.this$0
            com.didi.app.nova.skeleton.mvp.IView r0 = r0.getLogicView()
            com.didi.soda.home.component.category.landing.Contract$AbsShopCategoryLandingView r0 = (com.didi.soda.home.component.category.landing.Contract.AbsShopCategoryLandingView) r0
            java.lang.String r4 = r4.title
            r0.setTitle(r4)
        L_0x0021:
            com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter r4 = r2.this$0
            com.didi.soda.datasource.page.dynamic.DynamicDataSource r4 = r4.getDataSource()
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x002d
        L_0x002b:
            r4 = 0
            goto L_0x003d
        L_0x002d:
            com.didi.soda.datasource.page.PageParams r4 = r4.getPageParams()
            com.didi.soda.home.topgun.manager.HomeFeedParam r4 = (com.didi.soda.home.topgun.manager.HomeFeedParam) r4
            if (r4 != 0) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            int r4 = r4.getPageIndex()
            if (r4 != 0) goto L_0x002b
            r4 = 1
        L_0x003d:
            if (r4 == 0) goto L_0x004a
            com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter r4 = r2.this$0
            com.didi.app.nova.skeleton.mvp.IView r4 = r4.getLogicView()
            com.didi.soda.home.component.category.landing.Contract$AbsShopCategoryLandingView r4 = (com.didi.soda.home.component.category.landing.Contract.AbsShopCategoryLandingView) r4
            r4.scrollToTop()
        L_0x004a:
            com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter r4 = r2.this$0
            com.didi.soda.datasource.page.dynamic.DynamicDataSource r4 = r4.getDataSource()
            java.util.List r4 = r4.getTargetList()
            if (r4 != 0) goto L_0x0058
        L_0x0056:
            r0 = 0
            goto L_0x005e
        L_0x0058:
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0056
        L_0x005e:
            if (r0 == 0) goto L_0x0065
            com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter r4 = r2.this$0
            r4.m30025k()
        L_0x0065:
            com.didi.app.nova.skeleton.repo.Resource$Status r4 = r3.status
            com.didi.app.nova.skeleton.repo.Resource$Status r0 = com.didi.app.nova.skeleton.repo.Resource.Status.SUCCESS
            if (r4 != r0) goto L_0x0074
            java.lang.Object r3 = r3.data
            if (r3 == 0) goto L_0x0074
            com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter r3 = r2.this$0
            r3.m30009a((boolean) r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.component.category.landing.C13963x22c39891.onAfterPageResult(com.didi.soda.customer.repo.CustomerResource, com.didi.soda.datasource.page.PageResult):void");
    }
}
