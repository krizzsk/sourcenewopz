package com.didi.soda.bill.page;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.router.IInterceptor;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/page/BillTipPageInterceptor;", "Lcom/didi/soda/router/IInterceptor;", "()V", "intercept", "", "request", "Lcom/didi/soda/router/Request;", "p1", "Lcom/didi/soda/router/Response;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTipPageInterceptor.kt */
public final class BillTipPageInterceptor implements IInterceptor {
    public boolean intercept(Request request, Response response) {
        boolean z = false;
        if (!(request == null || request.getExtras() == null || request.getExtras().get("tip_info") != null)) {
            z = true;
        }
        if (z) {
            ToastUtil.showCustomerErrorToast((ScopeContext) null, ResourceHelper.getString(R.string.customer_get_data_failure));
        }
        return z;
    }
}
