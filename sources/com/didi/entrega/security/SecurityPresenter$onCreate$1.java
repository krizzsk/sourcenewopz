package com.didi.entrega.security;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.repo.CustomerActivityResultRepo;
import com.didi.entrega.security.Contract;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/security/SecurityPresenter$onCreate$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/customer/repo/CustomerActivityResultRepo$ActivityResult;", "call", "", "result", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SecurityPresenter.kt */
public final class SecurityPresenter$onCreate$1 implements Action1<CustomerActivityResultRepo.ActivityResult> {
    final /* synthetic */ SecurityPresenter this$0;

    SecurityPresenter$onCreate$1(SecurityPresenter securityPresenter) {
        this.this$0 = securityPresenter;
    }

    public void call(CustomerActivityResultRepo.ActivityResult activityResult) {
        DialogUtil.hideLoadingDialog();
        if (activityResult != null) {
            if (activityResult.requestCode == 1 && activityResult.resultCode == -1) {
                ToastUtil.showCustomerSuccessToast(this.this$0.getScopeContext(), this.this$0.getContext().getResources().getString(R.string.FoodC_up_Verification_was_ANJF));
                this.this$0.getScopeContext().getNavigator().finish();
                return;
            }
            Contract.AbsSecurityView absSecurityView = (Contract.AbsSecurityView) this.this$0.getLogicView();
            if (absSecurityView != null) {
                absSecurityView.onActivityResult(activityResult.requestCode, activityResult.resultCode, activityResult.data);
            }
        }
    }
}
