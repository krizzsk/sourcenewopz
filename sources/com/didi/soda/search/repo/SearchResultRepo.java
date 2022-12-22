package com.didi.soda.search.repo;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.search.component.result.SearchResultPageParam;
import com.didi.soda.search.helper.SearchLogHelper;

public class SearchResultRepo extends Repo<CustomerResource<SearchResultEntity>> {

    /* renamed from: b */
    private static final String f43791b = "SearchResultRepo";

    /* renamed from: a */
    CustomerRpcService f43792a = CustomerRpcManagerProxy.get();

    public void getSearchResult(ScopeContext scopeContext, SearchResultPageParam searchResultPageParam) {
        final ScopeContext scopeContext2 = scopeContext;
        SearchLogHelper.info(f43791b, "get search result");
        autoRelease(scopeContext2, this.f43792a.getSearchResult(searchResultPageParam.getSearchTag(), searchResultPageParam.getFilterParams(), searchResultPageParam.getPageIndex(), searchResultPageParam.getPageType(), searchResultPageParam.getSearchFrom(), searchResultPageParam.getRecId(), ((SearchTagRepo) RepoFactory.getRepo(SearchTagRepo.class)).getRecId(), searchResultPageParam.getLastBusinessId(), searchResultPageParam.getSugId(), searchResultPageParam.getSugCkJson(), searchResultPageParam.getQueryCkJson(), searchResultPageParam.getLastQuery(), new CRpcCallBackWithTraceId<SearchResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                PageRenderingTrackerNew.Companion.trackExceptionUtil(scopeContext2);
                SearchLogHelper.info(SearchResultRepo.f43791b, "get search result error");
                SearchResultRepo.this.setValue((CustomerResource<SearchResultEntity>) CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            }

            public void onRpcSuccess(SearchResultEntity searchResultEntity, long j, String str) {
                PageRenderingTrackerNew.Companion.trackEndAndReportUtil(scopeContext2);
                StringBuilder sb = new StringBuilder();
                sb.append("get search result success, data = ");
                sb.append(searchResultEntity != null ? searchResultEntity.toString() : "");
                SearchLogHelper.info(SearchResultRepo.f43791b, sb.toString());
                if (searchResultEntity == null) {
                    searchResultEntity = new SearchResultEntity();
                }
                Bundle bundle = new Bundle();
                bundle.putString(ParamConst.TRACE_ID, str);
                SearchResultRepo.this.setValue((CustomerResource<SearchResultEntity>) CustomerResource.success(searchResultEntity, bundle));
            }
        }));
    }

    public void setValue(CustomerResource<SearchResultEntity> customerResource) {
        super.setValue(customerResource);
        SearchLogHelper.info(f43791b, "SearchResultRepo setValue");
    }
}
