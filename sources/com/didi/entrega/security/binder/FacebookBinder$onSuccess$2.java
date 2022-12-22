package com.didi.entrega.security.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.security.binder.FacebookBinder;
import com.didi.entrega.security.model.FacebookRiskModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/entrega/security/binder/FacebookBinder$onSuccess$2", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "", "onFailure", "", "e", "Ljava/io/IOException;", "onSuccess", "s", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FacebookBinder.kt */
public final class FacebookBinder$onSuccess$2 implements RpcService.Callback<String> {
    final /* synthetic */ FacebookBinder this$0;

    FacebookBinder$onSuccess$2(FacebookBinder facebookBinder) {
        this.this$0 = facebookBinder;
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "e");
        iOException.printStackTrace();
        LogUtil.m14765i("FacebookBinder", Intrinsics.stringPlus("验证失败:", iOException));
        this.this$0.m15441b();
        DialogUtil.hideBlockDialog();
        DialogUtil.hideLoadingDialog();
    }

    public void onSuccess(String str) {
        try {
            Object fromJson = GsonUtil.fromJson(str, FacebookRiskModel.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(s, FacebookRiskModel::class.java)");
            FacebookRiskModel facebookRiskModel = (FacebookRiskModel) fromJson;
            LogUtil.m14765i("FacebookBinder", facebookRiskModel.toString());
            if (facebookRiskModel.errno != 0) {
                this.this$0.m15441b();
            } else {
                int i = facebookRiskModel.status;
                if (i == 1) {
                    ScopeContext scopeContext = (ScopeContext) this.this$0.f21057c.get();
                    if (scopeContext != null) {
                        scopeContext.getNavigator().finish();
                    }
                    FacebookBinder.ViewHolder access$getMViewHolder$p = this.this$0.f21060f;
                    Intrinsics.checkNotNull(access$getMViewHolder$p);
                    ToastUtil.showCustomerSuccessToast((ScopeContext) this.this$0.f21057c.get(), access$getMViewHolder$p.itemView.getResources().getString(R.string.FoodC_up_Verification_was_ANJF));
                } else if (i == 2) {
                    this.this$0.m15441b();
                } else if (i == 3) {
                    this.this$0.m15438a();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.this$0.m15441b();
        } catch (Throwable th) {
            DialogUtil.hideBlockDialog();
            DialogUtil.hideLoadingDialog();
            throw th;
        }
        DialogUtil.hideBlockDialog();
        DialogUtil.hideLoadingDialog();
    }
}
