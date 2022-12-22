package com.didi.soda.business.manager;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.AnchorInfo;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.CustomerResource;

public class BusinessRepo extends Repo<CustomerResource<BusinessEntity>> {

    /* renamed from: a */
    private static final String f39708a = "business_repo";

    /* renamed from: b */
    private CustomerRpcService f39709b = CustomerRpcManagerProxy.get();

    public static BusinessRepo get(ScopeContext scopeContext) {
        Object object = scopeContext.getObject(f39708a);
        if (object != null) {
            return (BusinessRepo) object;
        }
        BusinessRepo businessRepo = new BusinessRepo();
        scopeContext.attach(f39708a, businessRepo);
        return businessRepo;
    }

    public void requestBusinessData(final ScopeContext scopeContext, final String str, String str2, String str3, AnchorInfo anchorInfo, ActInfoEntity actInfoEntity) {
        setValue(CustomerResource.loading());
        this.f39709b.getBusinessData(str, str2, str3, anchorInfo, actInfoEntity, CustomerApolloUtil.getNewBusinessFeedType(), new CRpcCallBackWithTraceId<BusinessEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_DATA_ERROR).addModuleName("shop");
                ApiErrorUtil.Companion companion = ApiErrorUtil.Companion;
                addModuleName.addErrorType(companion.getErrorType(sFRpcException.getCode() + "")).addErrorMsg(sFRpcException.getOriginalMessage()).addParam("shop_id", str).build().trackError();
                super.onRpcFailure(sFRpcException);
                PageRenderingTrackerNew.Companion.trackExceptionUtil(scopeContext);
                BusinessRepo.this.setValue(CustomerResource.error(sFRpcException.getMessage()));
            }

            public void onRpcSuccess(BusinessEntity businessEntity, long j, String str) {
                if (businessEntity == null) {
                    ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_DATA_ERROR).addModuleName("shop").addErrorType("shop data is null").addParam("shop_id", str).build().trackError();
                    BusinessRepo.this.setValue(CustomerResource.error(""));
                    return;
                }
                AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
                AppConfig data = appConfigStorage.getData();
                boolean z = true;
                if (businessEntity.itemDetailAB != 1) {
                    z = false;
                }
                data.mIsPurchaseNewStyle = z;
                appConfigStorage.setData(data);
                PageRenderingTrackerNew.Companion.trackEndAndReportUtil(scopeContext);
                Bundle bundle = new Bundle();
                bundle.putString(ParamConst.TRACE_ID, str);
                BusinessDyDataAssist.initTemplate(businessEntity.mTemplates);
                BusinessRepo.this.setValue(CustomerResource.success(businessEntity, bundle));
            }
        });
    }
}
