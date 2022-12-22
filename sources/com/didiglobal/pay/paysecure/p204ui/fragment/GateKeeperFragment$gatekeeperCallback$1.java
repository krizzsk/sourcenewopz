package com.didiglobal.pay.paysecure.p204ui.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/GateKeeperFragment$gatekeeperCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/GateKeeperResponse;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment$gatekeeperCallback$1 */
/* compiled from: GateKeeperFragment.kt */
public final class GateKeeperFragment$gatekeeperCallback$1 implements RpcService.Callback<PaySecureResponse<GateKeeperResponse>> {
    final /* synthetic */ GateKeeperFragment this$0;

    GateKeeperFragment$gatekeeperCallback$1(GateKeeperFragment gateKeeperFragment) {
        this.this$0 = gateKeeperFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r1 = r4.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse<com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse> r4) {
        /*
            r3 = this;
            com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment r0 = r3.this$0
            r0.hideLoading()
            if (r4 == 0) goto L_0x0027
            java.lang.Object r0 = r4.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse r0 = (com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse) r0
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.isSuccess()
            r1 = 1
            if (r0 != r1) goto L_0x0027
            com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment r0 = r3.this$0
            java.lang.Object r4 = r4.getData()
            if (r4 != 0) goto L_0x0021
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0021:
            com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse r4 = (com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse) r4
            r0.m36271a((com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse) r4)
            goto L_0x0087
        L_0x0027:
            r0 = 0
            if (r4 == 0) goto L_0x0037
            java.lang.Object r1 = r4.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse) r1
            if (r1 == 0) goto L_0x0037
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            goto L_0x0038
        L_0x0037:
            r1 = r0
        L_0x0038:
            if (r1 == 0) goto L_0x0054
            com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment r1 = r3.this$0
            java.lang.Object r4 = r4.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse r4 = (com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse) r4
            if (r4 == 0) goto L_0x0049
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r4 = r4.getErrorData()
            goto L_0x004a
        L_0x0049:
            r4 = r0
        L_0x004a:
            com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment r2 = r3.this$0
            com.didiglobal.pay.paysecure.ui.view.ErrorDialogCallback r2 = r2.getErrorDialogCallback()
            r1.showErrorData(r4, r0, r2)
            goto L_0x0087
        L_0x0054:
            com.didiglobal.pay.paysecure.PaySecure r4 = com.didiglobal.pay.paysecure.PaySecure.INSTANCE
            com.didiglobal.pay.paysecure.SetPwdResultListener r4 = r4.getSetPwdResultListener()
            java.lang.String r0 = ""
            java.lang.String r1 = "gatekeeper_failed"
            if (r4 == 0) goto L_0x0063
            r4.onFailure(r1, r0)
        L_0x0063:
            com.didiglobal.pay.paysecure.PaySecure r4 = com.didiglobal.pay.paysecure.PaySecure.INSTANCE
            com.didiglobal.pay.paysecure.PayPwdResultListener r4 = r4.getPwdResultListener()
            if (r4 == 0) goto L_0x006e
            r4.onFailure(r1, r0)
        L_0x006e:
            com.didiglobal.pay.paysecure.util.ToastUtil r4 = com.didiglobal.pay.paysecure.util.ToastUtil.INSTANCE
            com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment r0 = r3.this$0
            android.content.Context r0 = r0.getContext()
            r1 = 2131958100(0x7f131954, float:1.9552803E38)
            r4.showError((android.content.Context) r0, (int) r1)
            com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment r4 = r3.this$0
            androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
            if (r4 == 0) goto L_0x0087
            r4.finish()
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.pay.paysecure.p204ui.fragment.GateKeeperFragment$gatekeeperCallback$1.onSuccess(com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse):void");
    }

    public void onFailure(IOException iOException) {
        ToastUtil.INSTANCE.showError(this.this$0.getContext(), (int) R.string.universal_net_failed);
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            setPwdResultListener.onFailure("gatekeeper_failed", "");
        }
        PayPwdResultListener pwdResultListener = PaySecure.INSTANCE.getPwdResultListener();
        if (pwdResultListener != null) {
            pwdResultListener.onFailure("gatekeeper_failed", "");
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
