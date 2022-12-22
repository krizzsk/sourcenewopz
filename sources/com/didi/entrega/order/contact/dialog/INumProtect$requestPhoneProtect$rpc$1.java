package com.didi.entrega.order.contact.dialog;

import android.content.Context;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.util.CipherUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.foundation.rpc.entity.NumProtectPreCallEntity;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/order/contact/dialog/INumProtect$requestPhoneProtect$rpc$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/foundation/rpc/entity/NumProtectPreCallEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: INumProtect.kt */
public final class INumProtect$requestPhoneProtect$rpc$1 extends CustomerRpcCallback<NumProtectPreCallEntity> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $dialogDismiss;
    final /* synthetic */ INumProtect this$0;

    INumProtect$requestPhoneProtect$rpc$1(INumProtect iNumProtect, Context context, Function0<Unit> function0) {
        this.this$0 = iNumProtect;
        this.$context = context;
        this.$dialogDismiss = function0;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        if (sFRpcException.getCode() == 46588) {
            this.this$0.showProtectNumDegradeDialog(this.$context, sFRpcException.getMessage(), this.$context.getString(R.string.FoodC_up_Confirmation_hKaf), (RFDialogInterface.OnClickListener) null);
        } else {
            this.this$0.showToast(sFRpcException.getMessage());
        }
        this.$dialogDismiss.invoke();
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_PHONE_PROTECT_ERROR).addEventParam("error_code", Integer.valueOf(sFRpcException.getCode()));
        String message = sFRpcException.getMessage();
        if (message == null) {
            message = "";
        }
        addEventParam.addEventParam("error_msg", message).build().track();
    }

    public void onRpcSuccess(NumProtectPreCallEntity numProtectPreCallEntity, long j) {
        if (numProtectPreCallEntity != null) {
            String decrypt = CipherUtil.decrypt(numProtectPreCallEntity.virtualPhone);
            LogUtil.m14763e("OrderContactUtil", Intrinsics.stringPlus("virtualPhone de= ", decrypt));
            if (numProtectPreCallEntity.status == 1) {
                CustomerSystemUtil.doCall(this.$context, decrypt);
            } else {
                INumProtect iNumProtect = this.this$0;
                Context context = this.$context;
                iNumProtect.showProtectNumDegradeDialog(context, context.getString(R.string.FoodC_phonesafe_The_number_AxNl), this.$context.getString(R.string.FoodC_phonesafe_Call_ivWZ), new RFDialogInterface.OnClickListener(this.$context, decrypt) {
                    public final /* synthetic */ Context f$0;
                    public final /* synthetic */ String f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onClick(RFDialog rFDialog) {
                        INumProtect$requestPhoneProtect$rpc$1.m46397onRpcSuccess$lambda0(this.f$0, this.f$1, rFDialog);
                    }
                });
            }
        }
        this.$dialogDismiss.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: onRpcSuccess$lambda-0  reason: not valid java name */
    public static final void m46397onRpcSuccess$lambda0(Context context, String str, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(context, "$context");
        CustomerSystemUtil.doCall(context, str);
    }
}
