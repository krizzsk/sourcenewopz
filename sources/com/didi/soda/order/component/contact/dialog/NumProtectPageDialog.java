package com.didi.soda.order.component.contact.dialog;

import android.content.Context;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.nova.assembly.country.CountryListDialog;
import com.didi.nova.assembly.country.OnCountrySelectListener;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.customer.widget.dialog.CustomerNumProtectDialog;
import com.didi.soda.customer.widget.dialog.NumProtectModel;
import com.didi.soda.order.component.contact.dialog.INumProtect;
import com.didichuxing.foundation.rpc.Rpc;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J.\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/order/component/contact/dialog/NumProtectPageDialog;", "Lcom/didi/soda/order/component/contact/dialog/INumProtect;", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Landroid/content/Context;Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getContext", "()Landroid/content/Context;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "bindRpcLife", "", "rpc", "Lcom/didichuxing/foundation/rpc/Rpc;", "showCountryPageList", "dialog", "Lcom/didi/soda/customer/widget/dialog/CustomerNumProtectDialog;", "countryId", "", "showNumProtectDialog", "model", "Lcom/didi/soda/customer/widget/dialog/NumProtectModel;", "orderId", "", "virtualCallRoleType", "showProtectNumDegradeDialog", "msg", "btnText", "listener", "Landroid/view/View$OnClickListener;", "showToast", "message", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NumProtectPageDialog.kt */
public final class NumProtectPageDialog implements INumProtect {

    /* renamed from: a */
    private final Context f43376a;

    /* renamed from: b */
    private final ScopeContext f43377b;

    public NumProtectPageDialog(Context context, ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        this.f43376a = context;
        this.f43377b = scopeContext;
    }

    public final Context getContext() {
        return this.f43376a;
    }

    public final ScopeContext getScopeContext() {
        return this.f43377b;
    }

    public void requestPhoneProtect(Context context, String str, String str2, String str3, int i, Function0<Unit> function0) {
        INumProtect.DefaultImpls.requestPhoneProtect(this, context, str, str2, str3, i, function0);
    }

    public void showNumProtectDialog(NumProtectModel numProtectModel, String str, int i) {
        Intrinsics.checkNotNullParameter(numProtectModel, "model");
        Intrinsics.checkNotNullParameter(str, "orderId");
        DialogUtil.showNumProtectDialog(new CustomerNumProtectDialog(this.f43376a, numProtectModel, new NumProtectPageDialog$showNumProtectDialog$numProtectDialog$1(this, str, i)), this.f43377b.getNavigator());
    }

    public void showProtectNumDegradeDialog(Context context, String str, String str2, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        DialogUtil.showProtectNumDegradeDialog(context, this.f43377b.getNavigator(), str, onClickListener == null, onClickListener);
    }

    public void showToast(String str) {
        ToastUtil.showCustomerToast(this.f43377b, str);
    }

    public void bindRpcLife(Rpc<?, ?> rpc) {
        Intrinsics.checkNotNullParameter(rpc, "rpc");
        this.f43377b.getLiveHandler().bind(new Cancelable() {
            public final void cancel() {
                NumProtectPageDialog.m30672a(Rpc.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30672a(Rpc rpc) {
        Intrinsics.checkNotNullParameter(rpc, "$rpc");
        rpc.cancel();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30670a(CustomerNumProtectDialog customerNumProtectDialog, int i) {
        CountryListDialog.show(this.f43377b, (OnCountrySelectListener) new OnCountrySelectListener() {
            public final void onSelect(String str, int i) {
                NumProtectPageDialog.m30671a(CustomerNumProtectDialog.this, str, i);
            }
        }, i, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), CustomerSystemUtil.getImmersiveStatusBarHeight(this.f43376a), GlobalContext.isBrazil() ? R.style.NovaAssemblyCountryStyleYellow : R.style.NovaAssemblyCountryStyleOrange);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30671a(CustomerNumProtectDialog customerNumProtectDialog, String str, int i) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "$dialog");
        customerNumProtectDialog.setCallingCode(str, i);
    }
}
