package com.didi.soda.home.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.CheckActivityResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.ToastInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.repo.RepoFactory;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/home/manager/ActivityValidateCheckHelper$checkActivityValidate$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/CheckActivityResultEntity;", "onRpcSuccess", "", "resultEntity", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityValidateCheckHelper.kt */
public final class ActivityValidateCheckHelper$checkActivityValidate$1 extends CustomerRpcCallback<CheckActivityResultEntity> {
    final /* synthetic */ ActInfoEntity $actInfo;
    final /* synthetic */ ScopeContext $scopeContext;

    ActivityValidateCheckHelper$checkActivityValidate$1(ActInfoEntity actInfoEntity, ScopeContext scopeContext) {
        this.$actInfo = actInfoEntity;
        this.$scopeContext = scopeContext;
    }

    public void onRpcSuccess(CheckActivityResultEntity checkActivityResultEntity, long j) {
        ToastInfoEntity toast;
        String content;
        boolean z = false;
        if (checkActivityResultEntity != null && checkActivityResultEntity.getHitAct() == 1) {
            z = true;
        }
        if (!z) {
            if (!(checkActivityResultEntity == null || (toast = checkActivityResultEntity.getToast()) == null || (content = toast.getContent()) == null)) {
                ToastUtil.showCustomerToast(this.$scopeContext, content);
            }
            String actId = this.$actInfo.getActId();
            if (actId != null) {
                ((ActInvalidateRepo) RepoFactory.getRepo(ActInvalidateRepo.class)).setValue(actId);
            }
        }
    }
}
