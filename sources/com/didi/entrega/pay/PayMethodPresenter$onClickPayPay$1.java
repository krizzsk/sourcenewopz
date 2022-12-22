package com.didi.entrega.pay;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.didi.payment.paymethod.open.callback.SignCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/entrega/pay/PayMethodPresenter$onClickPayPay$1", "Lcom/didi/payment/paymethod/open/callback/SignCallback;", "onPullStart", "", "onResult", "code", "", "errMsg", "", "result", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodPresenter.kt */
public final class PayMethodPresenter$onClickPayPay$1 implements SignCallback {
    final /* synthetic */ PayMethodInfoModel $payInfo;
    final /* synthetic */ PayMethodPresenter this$0;

    public void onPullStart() {
    }

    PayMethodPresenter$onClickPayPay$1(PayMethodInfoModel payMethodInfoModel, PayMethodPresenter payMethodPresenter) {
        this.$payInfo = payMethodInfoModel;
        this.this$0 = payMethodPresenter;
    }

    public void onResult(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, DMWebSocketListener.KEY_ERR_MSG);
        if (i != 0 && i != 1) {
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.showCustomerErrorToast(this.this$0.getScopeContext(), str);
            }
            PayOmegaHelper.bindPayPayFail(i, str);
        }
    }
}
