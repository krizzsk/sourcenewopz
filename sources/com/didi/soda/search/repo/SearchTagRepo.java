package com.didi.soda.search.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.SearchRecommendTagEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.search.helper.SearchLogHelper;

public class SearchTagRepo extends Repo<CustomerResource<SearchRecommendTagEntity>> {

    /* renamed from: a */
    private static final String f43793a = "SearchTagRepo";

    public String getRecId() {
        CustomerResource customerResource = (CustomerResource) getValue();
        if (customerResource == null || customerResource.data == null) {
            return null;
        }
        return ((SearchRecommendTagEntity) customerResource.data).mRecId;
    }

    public void getSearchTag() {
        SearchLogHelper.info(f43793a, "get search recommend words");
        CustomerRpcManagerProxy.get().getSearchRecommendTag(new CustomerRpcCallback<SearchRecommendTagEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                SearchLogHelper.info(SearchTagRepo.f43793a, "get search recommend words error");
                SearchTagRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            }

            public void onRpcSuccess(SearchRecommendTagEntity searchRecommendTagEntity, long j) {
                SearchLogHelper.info(SearchTagRepo.f43793a, "get search recommend words success");
                SearchTagRepo.this.setValue(CustomerResource.success(searchRecommendTagEntity));
            }
        });
    }
}
