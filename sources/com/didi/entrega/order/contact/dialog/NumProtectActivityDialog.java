package com.didi.entrega.order.contact.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatDialog;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.NativeDialogUtil;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.entrega.customer.widget.dialog.CustomerNumProtectDialog;
import com.didi.entrega.customer.widget.dialog.DialogBuilder;
import com.didi.entrega.customer.widget.dialog.NumProtectModel;
import com.didi.entrega.order.contact.dialog.INumProtect;
import com.didi.nova.assembly.country.CountryListDialog;
import com.didi.nova.assembly.country.OnCountrySelectListener;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.Rpc;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J.\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/dialog/NumProtectActivityDialog;", "Lcom/didi/entrega/order/contact/dialog/INumProtect;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "bindRpcLife", "", "rpc", "Lcom/didichuxing/foundation/rpc/Rpc;", "showCountryDialogList", "dialog", "Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog;", "countryId", "", "showNumProtectDialog", "model", "Lcom/didi/entrega/customer/widget/dialog/NumProtectModel;", "orderId", "", "virtualCallRoleType", "showProtectNumDegradeDialog", "msg", "btnText", "listener", "Lcom/didi/rfusion/widget/dialog/RFDialogInterface$OnClickListener;", "showToast", "message", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NumProtectActivityDialog.kt */
public final class NumProtectActivityDialog implements INumProtect {

    /* renamed from: a */
    private final Context f20871a;

    public void bindRpcLife(Rpc<?, ?> rpc) {
        Intrinsics.checkNotNullParameter(rpc, "rpc");
    }

    public NumProtectActivityDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f20871a = context;
    }

    public final Context getContext() {
        return this.f20871a;
    }

    public void requestPhoneProtect(Context context, String str, String str2, String str3, int i, Function0<Unit> function0) {
        INumProtect.DefaultImpls.requestPhoneProtect(this, context, str, str2, str3, i, function0);
    }

    public void showNumProtectDialog(NumProtectModel numProtectModel, String str, int i) {
        Intrinsics.checkNotNullParameter(numProtectModel, "model");
        Intrinsics.checkNotNullParameter(str, "orderId");
        AppCompatDialog appCompatDialog = new AppCompatDialog(this.f20871a);
        CustomerNumProtectDialog customerNumProtectDialog = new CustomerNumProtectDialog(this.f20871a, numProtectModel, new NumProtectActivityDialog$showNumProtectDialog$numProtectDialog$1(this, str, i, appCompatDialog));
        LayoutInflater from = LayoutInflater.from(this.f20871a);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        appCompatDialog.setContentView(customerNumProtectDialog.initRootView(from));
        appCompatDialog.setCancelable(false);
        appCompatDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                NumProtectActivityDialog.m15284a(CustomerNumProtectDialog.this, dialogInterface);
            }
        });
        appCompatDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                NumProtectActivityDialog.m15286b(CustomerNumProtectDialog.this, dialogInterface);
            }
        });
        NativeDialogUtil.setDialogWidth(this.f20871a, appCompatDialog);
        SystemUtils.showDialog(appCompatDialog);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15284a(CustomerNumProtectDialog customerNumProtectDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "$numProtectDialog");
        customerNumProtectDialog.onDismiss();
        customerNumProtectDialog.onDestroy();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15286b(CustomerNumProtectDialog customerNumProtectDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "$numProtectDialog");
        customerNumProtectDialog.onShow();
    }

    public void showProtectNumDegradeDialog(Context context, String str, String str2, RFDialogInterface.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        NativeDialogUtil.showCustomerDialog(context, new DialogBuilder().setIconImage(R.drawable.entrega_common_icon_exclamation).setContent(str), str2, onClickListener);
    }

    public void showToast(String str) {
        ToastUtil.showCustomerToast((ScopeContext) null, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15283a(CustomerNumProtectDialog customerNumProtectDialog, int i) {
        CountryListDialog.show(this.f20871a, (OnCountrySelectListener) new OnCountrySelectListener() {
            public final void onSelect(String str, int i) {
                NumProtectActivityDialog.m15285a(CustomerNumProtectDialog.this, str, i);
            }
        }, i, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), 0, GlobalContext.isBrazil() ? R.style.NovaAssemblyCountryStyleYellow : R.style.NovaAssemblyCountryStyleOrange);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15285a(CustomerNumProtectDialog customerNumProtectDialog, String str, int i) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "$dialog");
        customerNumProtectDialog.setCallingCode(str, i);
    }
}
