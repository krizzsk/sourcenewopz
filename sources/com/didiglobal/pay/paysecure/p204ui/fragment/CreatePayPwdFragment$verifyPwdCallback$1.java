package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$verifyPwdCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/VerifyPwdResponse;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$verifyPwdCallback$1 */
/* compiled from: CreatePayPwdFragment.kt */
public final class CreatePayPwdFragment$verifyPwdCallback$1 implements RpcService.Callback<PaySecureResponse<VerifyPwdResponse>> {
    final /* synthetic */ CreatePayPwdFragment this$0;

    CreatePayPwdFragment$verifyPwdCallback$1(CreatePayPwdFragment createPayPwdFragment) {
        this.this$0 = createPayPwdFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r6.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse<com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse> r6) {
        /*
            r5 = this;
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r0 = r5.this$0
            r0.hideLoading()
            r0 = 0
            if (r6 == 0) goto L_0x0019
            java.lang.Object r1 = r6.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x0019
            boolean r1 = r1.isSuccess()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x001a
        L_0x0019:
            r1 = r0
        L_0x001a:
            if (r1 != 0) goto L_0x001f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x001f:
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x002c
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r6 = r5.this$0
            r6.m36262b()
            goto L_0x010f
        L_0x002c:
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r1 = r5.this$0
            com.didiglobal.pay.paysecure.ui.view.InputPwdView r1 = com.didiglobal.pay.paysecure.p204ui.fragment.CreatePayPwdFragment.access$getMInputPwdView$p(r1)
            r1.showErr()
            java.lang.Object r1 = r6.getData()
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r6.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x0048
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            goto L_0x0049
        L_0x0048:
            r1 = r0
        L_0x0049:
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r6.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x005e
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            if (r1 == 0) goto L_0x005e
            java.lang.String r1 = r1.getEventId()
            goto L_0x005f
        L_0x005e:
            r1 = r0
        L_0x005f:
            if (r1 == 0) goto L_0x008d
            com.didiglobal.pay.paysecure.omega.OmegaUtil r1 = new com.didiglobal.pay.paysecure.omega.OmegaUtil
            java.lang.Object r2 = r6.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r2 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r2
            if (r2 == 0) goto L_0x0076
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r2 = r2.getErrorData()
            if (r2 == 0) goto L_0x0076
            java.lang.String r2 = r2.getEventId()
            goto L_0x0077
        L_0x0076:
            r2 = r0
        L_0x0077:
            r1.<init>(r2)
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r2 = r5.this$0
            int r2 = r2.getSourcePageId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "entrance_page_id"
            com.didiglobal.pay.paysecure.omega.OmegaUtil r1 = r1.add(r3, r2)
            r1.send()
        L_0x008d:
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$verifyPwdCallback$1$onSuccess$1 r1 = new com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$verifyPwdCallback$1$onSuccess$1
            r1.<init>(r5)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 500(0x1f4, double:2.47E-321)
            com.didi.sdk.util.UiThreadHandler.postDelayed(r1, r2)
            java.lang.Object r1 = r6.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x00ac
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            if (r1 == 0) goto L_0x00ac
            java.lang.String r1 = r1.getStyle()
            goto L_0x00ad
        L_0x00ac:
            r1 = r0
        L_0x00ad:
            java.lang.String r4 = "hint"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x00d3
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r1 = r5.this$0
            android.widget.TextView r1 = com.didiglobal.pay.paysecure.p204ui.fragment.CreatePayPwdFragment.access$getMSubTitleView$p(r1)
            r4 = 4
            r1.setVisibility(r4)
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r1 = r5.this$0
            android.widget.TextView r1 = com.didiglobal.pay.paysecure.p204ui.fragment.CreatePayPwdFragment.access$getMHintView$p(r1)
            r4 = 0
            r1.setVisibility(r4)
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$verifyPwdCallback$1$onSuccess$2 r1 = new com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$verifyPwdCallback$1$onSuccess$2
            r1.<init>(r5)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            com.didi.sdk.util.UiThreadHandler.postDelayed(r1, r2)
        L_0x00d3:
            java.lang.Object r1 = r6.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r1 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r1
            if (r1 == 0) goto L_0x00e0
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r1 = r1.getErrorData()
            goto L_0x00e1
        L_0x00e0:
            r1 = r0
        L_0x00e1:
            if (r1 == 0) goto L_0x0101
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r1 = r5.this$0
            java.lang.Object r6 = r6.getData()
            com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse r6 = (com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse) r6
            if (r6 == 0) goto L_0x00f1
            com.didiglobal.pay.paysecure.net.pojo.response.ErrorData r0 = r6.getErrorData()
        L_0x00f1:
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r6 = r5.this$0
            android.widget.TextView r6 = com.didiglobal.pay.paysecure.p204ui.fragment.CreatePayPwdFragment.access$getMHintView$p(r6)
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r2 = r5.this$0
            com.didiglobal.pay.paysecure.ui.view.ErrorDialogCallback r2 = r2.getErrorDialogCallback()
            r1.showErrorData(r0, r6, r2)
            goto L_0x010f
        L_0x0101:
            com.didiglobal.pay.paysecure.util.ToastUtil r6 = com.didiglobal.pay.paysecure.util.ToastUtil.INSTANCE
            com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment r0 = r5.this$0
            android.content.Context r0 = r0.getContext()
            r1 = 2131958100(0x7f131954, float:1.9552803E38)
            r6.showError((android.content.Context) r0, (int) r1)
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.pay.paysecure.p204ui.fragment.CreatePayPwdFragment$verifyPwdCallback$1.onSuccess(com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse):void");
    }

    public void onFailure(IOException iOException) {
        this.this$0.hideLoading();
        UiThreadHandler.postDelayed(new CreatePayPwdFragment$verifyPwdCallback$1$onFailure$1(this), 500);
        ToastUtil.INSTANCE.showError(this.this$0.getContext(), (int) R.string.universal_net_failed);
    }
}
