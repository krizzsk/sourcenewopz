package com.didi.soda.customer.foundation.rpc.interceptor;

import com.didi.foundation.sdk.net.interceptor.RpcBlockInterface;
import com.didi.soda.customer.downgrade.LimitVisitEntity;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import java.util.ArrayList;

@ServiceProvider({RpcBlockInterface.class})
public class CustomerBlockInterceptor implements RpcBlockInterface {
    public boolean toggle() {
        return m29126a().isOpen;
    }

    public int getLimitTime() {
        return m29126a().limitTime;
    }

    public int getLimitRandomTime() {
        return m29126a().limitRandomTime;
    }

    public ArrayList<String> getBlackList() {
        return m29126a().blackList;
    }

    public String getErrorMsg() {
        return ResourceHelper.getString(R.string.FoodC_downgrade_limit_visit);
    }

    public void trackerBlock(String str) {
        ErrorTracker.create(ErrorConst.ErrorName.SALING_C_API_NET_LIMIT_ERROR).addErrorType("api").addErrorMsg(getErrorMsg()).addModuleName("api").addParam("url", str).build().trackError();
    }

    public void tracker596Error(String str) {
        ErrorTracker.create(ErrorConst.ErrorName.SALING_C_API_NET_596_ERROR).addErrorType("api").addErrorMsg(getErrorMsg()).addModuleName("api").addParam("url", str).build().trackError();
    }

    /* renamed from: a */
    private LimitVisitEntity m29126a() {
        return CustomerApolloUtil.getLimitVisitConfig();
    }
}
