package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.net.pojo.response.ErrorData;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.SetPwdResponse;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.didiglobal.pay.paysecure.util.UiUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$setPwdCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/SetPwdResponse;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$setPwdCallback$1 */
/* compiled from: CreatePayPwdFragment.kt */
public final class CreatePayPwdFragment$setPwdCallback$1 implements RpcService.Callback<PaySecureResponse<SetPwdResponse>> {
    final /* synthetic */ CreatePayPwdFragment this$0;

    CreatePayPwdFragment$setPwdCallback$1(CreatePayPwdFragment createPayPwdFragment) {
        this.this$0 = createPayPwdFragment;
    }

    public void onSuccess(PaySecureResponse<SetPwdResponse> paySecureResponse) {
        ErrorData errorData;
        this.this$0.hideLoading();
        String str = null;
        SetPwdResponse data = paySecureResponse != null ? paySecureResponse.getData() : null;
        if (data == null) {
            Intrinsics.throwNpe();
        }
        if (data.isSuccess()) {
            this.this$0.m36260a(data);
            if (this.this$0.getMessenger().getSceneType() == 0) {
                ToastUtil.INSTANCE.showSuccess(this.this$0.getContext(), (int) R.string.Finance_latour_Password_settings_puYB);
            } else {
                ToastUtil.INSTANCE.showSuccess(this.this$0.getContext(), (int) R.string.Finance_latour_Payment_password_YIJL);
                new OmegaUtil("ibt_password_change_password_sucess_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(this.this$0.getSourcePageId())).send();
            }
            UiUtils.INSTANCE.hideKeyboard(this.this$0.getContext(), CreatePayPwdFragment.access$getMRootView$p(this.this$0));
            UiThreadHandler.postDelayed(new CreatePayPwdFragment$setPwdCallback$1$onSuccess$1(this), 300);
            return;
        }
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            String status = data.getStatus();
            String failReason = data.getFailReason();
            if (failReason == null) {
                Intrinsics.throwNpe();
            }
            setPwdResultListener.onFailure(status, failReason);
        }
        SetPwdResponse data2 = paySecureResponse.getData();
        if ((data2 != null ? data2.getErrorData() : null) != null) {
            CreatePayPwdFragment createPayPwdFragment = this.this$0;
            SetPwdResponse data3 = paySecureResponse.getData();
            createPayPwdFragment.showErrorData(data3 != null ? data3.getErrorData() : null, CreatePayPwdFragment.access$getMHintView$p(this.this$0), this.this$0.getErrorDialogCallback());
            SetPwdResponse data4 = paySecureResponse.getData();
            String style = (data4 == null || (errorData = data4.getErrorData()) == null) ? null : errorData.getStyle();
            if (style != null) {
                int hashCode = style.hashCode();
                if (hashCode == -1332085432) {
                    boolean equals = style.equals("dialog");
                } else if (hashCode != 3202695) {
                    if (hashCode == 110532135 && style.equals(BlocksConst.ACTION_TYPE_TOAST)) {
                        UiThreadHandler.postDelayed(new CreatePayPwdFragment$setPwdCallback$1$onSuccess$2(this), 500);
                    }
                } else if (style.equals(ViewHierarchyConstants.HINT_KEY)) {
                    CreatePayPwdFragment.access$getMSubTitleView$p(this.this$0).setVisibility(4);
                    CreatePayPwdFragment.access$getMHintView$p(this.this$0).setVisibility(0);
                }
            }
            if (data.getErrorData() != null) {
                ErrorData errorData2 = data.getErrorData();
                if ((errorData2 != null ? errorData2.getEventId() : null) != null) {
                    ErrorData errorData3 = data.getErrorData();
                    if (errorData3 != null) {
                        str = errorData3.getEventId();
                    }
                    new OmegaUtil(str).add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(this.this$0.getSourcePageId())).send();
                    return;
                }
                return;
            }
            return;
        }
        ToastUtil.INSTANCE.showError(this.this$0.getContext(), (int) R.string.universal_net_failed);
    }

    public void onFailure(IOException iOException) {
        this.this$0.hideLoading();
        ToastUtil.INSTANCE.showError(this.this$0.getContext(), (int) R.string.universal_net_failed);
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            setPwdResultListener.onFailure("network", "Network Fail");
        }
    }
}
