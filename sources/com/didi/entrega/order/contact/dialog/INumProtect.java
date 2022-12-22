package com.didi.entrega.order.contact.dialog;

import android.content.Context;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.util.CipherUtil;
import com.didi.entrega.customer.widget.dialog.NumProtectModel;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didichuxing.foundation.rpc.Rpc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H&JB\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0017J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000eH&J.\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\nH&¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/dialog/INumProtect;", "", "bindRpcLife", "", "rpc", "Lcom/didichuxing/foundation/rpc/Rpc;", "requestPhoneProtect", "context", "Landroid/content/Context;", "orderId", "", "protectUnm", "callingCode", "role", "", "dialogDismiss", "Lkotlin/Function0;", "showNumProtectDialog", "model", "Lcom/didi/entrega/customer/widget/dialog/NumProtectModel;", "virtualCallRoleType", "showProtectNumDegradeDialog", "msg", "btnText", "listener", "Lcom/didi/rfusion/widget/dialog/RFDialogInterface$OnClickListener;", "showToast", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: INumProtect.kt */
public interface INumProtect {
    void bindRpcLife(Rpc<?, ?> rpc);

    void requestPhoneProtect(Context context, String str, String str2, String str3, int i, Function0<Unit> function0);

    void showNumProtectDialog(NumProtectModel numProtectModel, String str, int i);

    void showProtectNumDegradeDialog(Context context, String str, String str2, RFDialogInterface.OnClickListener onClickListener);

    void showToast(String str);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: INumProtect.kt */
    public static final class DefaultImpls {
        public static void requestPhoneProtect(INumProtect iNumProtect, Context context, String str, String str2, String str3, int i, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(iNumProtect, "this");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "orderId");
            Intrinsics.checkNotNullParameter(function0, "dialogDismiss");
            CharSequence charSequence = str2;
            if (!(charSequence == null || charSequence.length() == 0)) {
                LogUtil.m14763e("OrderContactUtil", Intrinsics.stringPlus("virtualPhone en= ", CipherUtil.encrypt(str2)));
                Rpc protectNum = CustomerRpcManagerProxy.get().getProtectNum(str, CipherUtil.encrypt(str2), str3, i, new INumProtect$requestPhoneProtect$rpc$1(iNumProtect, context, function0));
                Intrinsics.checkNotNullExpressionValue(protectNum, "rpc");
                iNumProtect.bindRpcLife(protectNum);
            }
        }
    }
}
