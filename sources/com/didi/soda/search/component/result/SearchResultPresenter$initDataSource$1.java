package com.didi.soda.search.component.result;

import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.datasource.page.DataSource;
import com.didi.soda.search.component.result.Contract;
import com.didi.soda.search.helper.SearchLogHelper;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/soda/search/component/result/SearchResultPresenter$initDataSource$1", "Lcom/didi/soda/datasource/page/DataSource$SimpleDataSourceListener;", "Lcom/google/gson/JsonObject;", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchResultEntity;", "onAfterPageResult", "", "homeFeedEntityResource", "Lcom/didi/soda/customer/repo/CustomerResource;", "pageResult", "Lcom/didi/soda/datasource/page/PageResult;", "onEndRequest", "searchResultResource", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultPresenter.kt */
public final class SearchResultPresenter$initDataSource$1 extends DataSource.SimpleDataSourceListener<JsonObject, SearchResultEntity> {
    final /* synthetic */ SearchResultPresenter this$0;

    SearchResultPresenter$initDataSource$1(SearchResultPresenter searchResultPresenter) {
        this.this$0 = searchResultPresenter;
    }

    public void onEndRequest(CustomerResource<SearchResultEntity> customerResource) {
        Intrinsics.checkNotNullParameter(customerResource, "searchResultResource");
        ((Contract.AbsSearchResultView) this.this$0.getLogicView()).showFooterEmptyView();
        ((Contract.AbsSearchResultView) this.this$0.getLogicView()).hideAbnormalView();
        ((Contract.AbsSearchResultView) this.this$0.getLogicView()).hideLoading();
        if (customerResource.status != Resource.Status.SUCCESS || customerResource.data == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("searchResultResource status = ");
            sb.append(customerResource.status);
            sb.append(", data = ");
            sb.append(customerResource.data != null ? ((SearchResultEntity) customerResource.data).toString() : "");
            SearchLogHelper.info(SearchResultPresenter.TAG, sb.toString());
            if (((SearchResultPageParam) this.this$0.getDataSource().getPageParams()).getPageIndex() == 0) {
                ChildDataListManager access$getMSearchListManager$p = this.this$0.f43743a;
                if (access$getMSearchListManager$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchListManager");
                    access$getMSearchListManager$p = null;
                }
                access$getMSearchListManager$p.clear();
                boolean isNetworkConnected = NetWorkUtils.isNetworkConnected(this.this$0.getContext());
                if (isNetworkConnected) {
                    ((Contract.AbsSearchResultView) this.this$0.getLogicView()).showNoResultView();
                } else {
                    ((Contract.AbsSearchResultView) this.this$0.getLogicView()).showNetErrorView();
                }
                SearchLogHelper.info(SearchResultPresenter.TAG, Intrinsics.stringPlus("SearchResultRepo error. isNetworkConnected = ", Boolean.valueOf(isNetworkConnected)));
            }
            if (customerResource.status == Resource.Status.ERROR) {
                ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SEARCH_ABNORMAL_RESULTS).addModuleName("search");
                ApiErrorUtil.Companion companion = ApiErrorUtil.Companion;
                addModuleName.addErrorType(companion.getErrorType(customerResource.code + "")).build().trackError();
                return;
            }
            return;
        }
        Object obj = customerResource.data;
        Intrinsics.checkNotNullExpressionValue(obj, "searchResultResource.data");
        SearchLogHelper.info(SearchResultPresenter.TAG, Intrinsics.stringPlus("SearchResultRepo success, data = ", obj));
        SearchResultPresenter searchResultPresenter = this.this$0;
        searchResultPresenter.m31052a(((SearchResultPageParam) searchResultPresenter.getDataSource().getPageParams()).getPageIndex(), ((SearchResultEntity) customerResource.data).mFilterList);
        SearchResultPresenter searchResultPresenter2 = this.this$0;
        Object obj2 = customerResource.data;
        Intrinsics.checkNotNullExpressionValue(obj2, "searchResultResource.data");
        searchResultPresenter2.m31053a((SearchResultEntity) obj2);
        SearchResultPresenter searchResultPresenter3 = this.this$0;
        Object obj3 = customerResource.data;
        Intrinsics.checkNotNullExpressionValue(obj3, "searchResultResource.data");
        searchResultPresenter3.m31061b((SearchResultEntity) obj3);
        SearchLogHelper.info(SearchResultPresenter.TAG, "search result show");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007a, code lost:
        if (((r5 == null || (r5 = r5.getValueList()) == null || r5.size() != 1) ? false : true) != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        r4 = (com.didi.soda.search.component.result.SearchResultPageParam) r4.getPageParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAfterPageResult(com.didi.soda.customer.repo.CustomerResource<com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity> r4, com.didi.soda.datasource.page.PageResult<com.google.gson.JsonObject> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "homeFeedEntityResource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            super.onAfterPageResult(r4, r5)
            com.didi.soda.search.component.result.SearchResultPresenter r4 = r3.this$0
            com.didi.soda.datasource.page.dynamic.DynamicDataSource r4 = r4.getDataSource()
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x0014
        L_0x0012:
            r4 = 0
            goto L_0x0024
        L_0x0014:
            com.didi.soda.datasource.page.PageParams r4 = r4.getPageParams()
            com.didi.soda.search.component.result.SearchResultPageParam r4 = (com.didi.soda.search.component.result.SearchResultPageParam) r4
            if (r4 != 0) goto L_0x001d
            goto L_0x0012
        L_0x001d:
            int r4 = r4.getPageIndex()
            if (r4 != 0) goto L_0x0012
            r4 = 1
        L_0x0024:
            if (r4 == 0) goto L_0x004e
            com.didi.soda.search.component.result.SearchResultPresenter r4 = r3.this$0
            com.didi.app.nova.skeleton.mvp.IView r4 = r4.getLogicView()
            com.didi.soda.search.component.result.Contract$AbsSearchResultView r4 = (com.didi.soda.search.component.result.Contract.AbsSearchResultView) r4
            r4.scrollToTop()
            com.didi.soda.search.component.result.SearchResultPresenter r4 = r3.this$0
            com.didi.soda.datasource.page.dynamic.DynamicDataSource r4 = r4.getDataSource()
            java.util.List r4 = r4.getTargetList()
            if (r4 != 0) goto L_0x003f
        L_0x003d:
            r4 = 0
            goto L_0x0046
        L_0x003f:
            int r4 = r4.size()
            if (r4 != 0) goto L_0x003d
            r4 = 1
        L_0x0046:
            if (r4 == 0) goto L_0x004e
            com.didi.soda.search.component.result.SearchResultPresenter r4 = r3.this$0
            r4.m31067d()
            return
        L_0x004e:
            com.didi.soda.search.component.result.SearchResultPresenter r4 = r3.this$0
            com.didi.soda.datasource.page.dynamic.DynamicDataSource r2 = r4.getDataSource()
            com.didi.soda.datasource.page.PageParams r2 = r2.getPageParams()
            com.didi.soda.search.component.result.SearchResultPageParam r2 = (com.didi.soda.search.component.result.SearchResultPageParam) r2
            int r2 = r2.getPageIndex()
            if (r2 != 0) goto L_0x007d
            com.didi.soda.search.component.result.SearchResultPresenter r2 = r3.this$0
            boolean r2 = r2.m31064b()
            if (r2 == 0) goto L_0x007d
            if (r5 != 0) goto L_0x006c
        L_0x006a:
            r5 = 0
            goto L_0x007a
        L_0x006c:
            java.util.List r5 = r5.getValueList()
            if (r5 != 0) goto L_0x0073
            goto L_0x006a
        L_0x0073:
            int r5 = r5.size()
            if (r5 != r0) goto L_0x006a
            r5 = 1
        L_0x007a:
            if (r5 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r0 = 0
        L_0x007e:
            r4.m31058a((boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.result.SearchResultPresenter$initDataSource$1.onAfterPageResult(com.didi.soda.customer.repo.CustomerResource, com.didi.soda.datasource.page.PageResult):void");
    }
}
