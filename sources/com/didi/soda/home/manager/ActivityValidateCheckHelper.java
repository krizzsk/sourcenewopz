package com.didi.soda.home.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/manager/ActivityValidateCheckHelper;", "", "()V", "checkActivityValidate", "", "actInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityValidateCheckHelper.kt */
public final class ActivityValidateCheckHelper {
    public static final ActivityValidateCheckHelper INSTANCE = new ActivityValidateCheckHelper();

    private ActivityValidateCheckHelper() {
    }

    @JvmStatic
    public static final void checkActivityValidate(ActInfoEntity actInfoEntity, ScopeContext scopeContext) {
        if (actInfoEntity != null) {
            CustomerRpcManagerProxy.get().checkActivityValidate(actInfoEntity, new ActivityValidateCheckHelper$checkActivityValidate$1(actInfoEntity, scopeContext));
        }
    }
}
