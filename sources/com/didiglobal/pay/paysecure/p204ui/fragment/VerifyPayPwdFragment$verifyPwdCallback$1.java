package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/VerifyPayPwdFragment$verifyPwdCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/VerifyPwdResponse;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment$verifyPwdCallback$1 */
/* compiled from: VerifyPayPwdFragment.kt */
public final class VerifyPayPwdFragment$verifyPwdCallback$1 implements RpcService.Callback<PaySecureResponse<VerifyPwdResponse>> {
    final /* synthetic */ VerifyPayPwdFragment this$0;

    VerifyPayPwdFragment$verifyPwdCallback$1(VerifyPayPwdFragment verifyPayPwdFragment) {
        this.this$0 = verifyPayPwdFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.didiglobal.pay.paysecure.net.pojo.response.ErrorData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
        r3 = r5.getData();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse<com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse> r5) {
        /*
            r4 = this;
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r0 = r4.this$0
            r0.hideLoading()
            r0 = 0
            if (r5 == 0) goto L_0x0053
            java.lang.Object r1 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x0053
            boolean r1 = r1.isSuccess()
            r2 = 1
            if (r1 != r2) goto L_0x0053
            com.didiglobal.pay.paysecure.PaySecure r1 = com.didiglobal.pay.paysecure.PaySecure.INSTANCE
            com.didiglobal.pay.paysecure.PayPwdResultListener r1 = r1.getPwdResultListener()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r5 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r5 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r5
            if (r5 == 0) goto L_0x002b
            java.lang.String r0 = r5.getToken()
        L_0x002b:
            if (r0 != 0) goto L_0x0030
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0030:
            r1.onSuccess(r0)
        L_0x0033:
            com.didiglobal.pay.paysecure.util.UiUtils r5 = com.didiglobal.pay.paysecure.util.UiUtils.INSTANCE
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r0 = r4.this$0
            android.content.Context r0 = r0.getContext()
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r1 = r4.this$0
            android.view.ViewGroup r1 = com.didiglobal.pay.paysecure.p204ui.fragment.VerifyPayPwdFragment.access$getMRootView$p(r1)
            android.view.View r1 = (android.view.View) r1
            r5.hideKeyboard(r0, r1)
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r5 = r4.this$0
            androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
            if (r5 == 0) goto L_0x0132
            r5.finish()
            goto L_0x0132
        L_0x0053:
            com.didiglobal.pay.paysecure.PaySecure r1 = com.didiglobal.pay.paysecure.PaySecure.INSTANCE
            com.didiglobal.pay.paysecure.PayPwdResultListener r1 = r1.getPwdResultListener()
            if (r1 == 0) goto L_0x0081
            if (r5 == 0) goto L_0x006c
            java.lang.Object r2 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r2 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r2
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = r2.getStatus()
            if (r2 == 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            java.lang.String r2 = ""
        L_0x006e:
            if (r5 == 0) goto L_0x007d
            java.lang.Object r3 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r3 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r3
            if (r3 == 0) goto L_0x007d
            java.lang.String r3 = r3.getFailDescription()
            goto L_0x007e
        L_0x007d:
            r3 = r0
        L_0x007e:
            r1.onFailure(r2, r3)
        L_0x0081:
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r1 = r4.this$0
            com.didiglobal.pay.paysecure.ui.view.InputPwdView r1 = com.didiglobal.pay.paysecure.p204ui.fragment.VerifyPayPwdFragment.access$getMInputPwdView$p(r1)
            r1.showErr()
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment$verifyPwdCallback$1$onSuccess$1 r1 = new com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment$verifyPwdCallback$1$onSuccess$1
            r1.<init>(r4)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 500(0x1f4, double:2.47E-321)
            com.didi.sdk.util.UiThreadHandler.postDelayed(r1, r2)
            if (r5 == 0) goto L_0x009f
            java.lang.Object r1 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            goto L_0x00a0
        L_0x009f:
            r1 = r0
        L_0x00a0:
            if (r1 == 0) goto L_0x00f4
            java.lang.Object r1 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x00af
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            goto L_0x00b0
        L_0x00af:
            r1 = r0
        L_0x00b0:
            if (r1 == 0) goto L_0x00f4
            java.lang.Object r1 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x00c5
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            if (r1 == 0) goto L_0x00c5
            java.lang.String r1 = r1.getEventId()
            goto L_0x00c6
        L_0x00c5:
            r1 = r0
        L_0x00c6:
            if (r1 == 0) goto L_0x00f4
            com.didiglobal.pay.paysecure.omega.OmegaUtil r1 = new com.didiglobal.pay.paysecure.omega.OmegaUtil
            java.lang.Object r2 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r2 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r2
            if (r2 == 0) goto L_0x00dd
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r2 = r2.getErrorData()
            if (r2 == 0) goto L_0x00dd
            java.lang.String r2 = r2.getEventId()
            goto L_0x00de
        L_0x00dd:
            r2 = r0
        L_0x00de:
            r1.<init>(r2)
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r2 = r4.this$0
            int r2 = r2.getSourcePageId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "entrance_page_id"
            com.didiglobal.pay.paysecure.omega.OmegaUtil r1 = r1.add(r3, r2)
            r1.send()
        L_0x00f4:
            if (r5 == 0) goto L_0x0103
            java.lang.Object r1 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x0103
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            goto L_0x0104
        L_0x0103:
            r1 = r0
        L_0x0104:
            if (r1 == 0) goto L_0x0124
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r1 = r4.this$0
            java.lang.Object r5 = r5.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r5 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r5
            if (r5 == 0) goto L_0x0114
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r0 = r5.getErrorData()
        L_0x0114:
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r5 = r4.this$0
            android.widget.TextView r5 = com.didiglobal.pay.paysecure.p204ui.fragment.VerifyPayPwdFragment.access$getMHintView$p(r5)
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r2 = r4.this$0
            com.didiglobal.pay.paysecure.ui.view.ErrorDialogCallback r2 = r2.getErrorDialogCallback()
            r1.showErrorData(r0, r5, r2)
            goto L_0x0132
        L_0x0124:
            com.didiglobal.pay.paysecure.util.ToastUtil r5 = com.didiglobal.pay.paysecure.util.ToastUtil.INSTANCE
            com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment r0 = r4.this$0
            android.content.Context r0 = r0.getContext()
            r1 = 2131958100(0x7f131954, float:1.9552803E38)
            r5.showError((android.content.Context) r0, (int) r1)
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.pay.paysecure.p204ui.fragment.VerifyPayPwdFragment$verifyPwdCallback$1.onSuccess(com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse):void");
    }

    public void onFailure(IOException iOException) {
        this.this$0.hideLoading();
        UiThreadHandler.postDelayed(new VerifyPayPwdFragment$verifyPwdCallback$1$onFailure$1(this), 500);
        ToastUtil.INSTANCE.showError(this.this$0.getContext(), (int) R.string.universal_net_failed);
        PayPwdResultListener pwdResultListener = PaySecure.INSTANCE.getPwdResultListener();
        if (pwdResultListener != null) {
            pwdResultListener.onFailure("network_error", "network_error");
        }
    }
}
