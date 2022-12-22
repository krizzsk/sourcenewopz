package com.didi.entrega.order.contact.dialog;

import androidx.appcompat.app.AppCompatDialog;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.entrega.customer.widget.dialog.CustomerNumProtectDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/entrega/order/contact/dialog/NumProtectActivityDialog$showNumProtectDialog$numProtectDialog$1", "Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog$OnNumProtectCallListener;", "confirm", "", "dialog", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "phone", "", "callingCode", "onCancel", "Lcom/didi/entrega/customer/widget/dialog/CustomerNumProtectDialog;", "onChooseCountryList", "countryId", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NumProtectActivityDialog.kt */
public final class NumProtectActivityDialog$showNumProtectDialog$numProtectDialog$1 implements CustomerNumProtectDialog.OnNumProtectCallListener {
    final /* synthetic */ AppCompatDialog $alertDialog;
    final /* synthetic */ String $orderId;
    final /* synthetic */ int $virtualCallRoleType;
    final /* synthetic */ NumProtectActivityDialog this$0;

    NumProtectActivityDialog$showNumProtectDialog$numProtectDialog$1(NumProtectActivityDialog numProtectActivityDialog, String str, int i, AppCompatDialog appCompatDialog) {
        this.this$0 = numProtectActivityDialog;
        this.$orderId = str;
        this.$virtualCallRoleType = i;
        this.$alertDialog = appCompatDialog;
    }

    public void onChooseCountryList(CustomerNumProtectDialog customerNumProtectDialog, int i) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "dialog");
        this.this$0.m15283a(customerNumProtectDialog, i);
    }

    public void confirm(Dialog dialog, String str, String str2) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        NumProtectActivityDialog numProtectActivityDialog = this.this$0;
        numProtectActivityDialog.requestPhoneProtect(numProtectActivityDialog.getContext(), this.$orderId, str, str2, this.$virtualCallRoleType, new C8209xd4638cb9(this.$alertDialog));
    }

    public void onCancel(CustomerNumProtectDialog customerNumProtectDialog) {
        Intrinsics.checkNotNullParameter(customerNumProtectDialog, "dialog");
        this.$alertDialog.dismiss();
    }
}
