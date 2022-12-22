package com.didi.soda.business.manager;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007JB\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0007JF\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessDialogHelper;", "", "()V", "list", "Ljava/util/ArrayList;", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "Lkotlin/collections/ArrayList;", "dismissAllDialog", "", "showBusinessClosedsDialog", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "context", "Landroid/content/Context;", "openTime", "", "exploreMoreListener", "Lkotlin/Function0;", "dismissListener", "showBusinessOutSideDialog", "navigator", "Lcom/didi/app/nova/skeleton/INavigator;", "currentAddress", "changeAddressListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDialogHelper.kt */
public final class BusinessDialogHelper {
    public static final BusinessDialogHelper INSTANCE = new BusinessDialogHelper();

    /* renamed from: a */
    private static ArrayList<Dialog> f39674a = new ArrayList<>();

    private BusinessDialogHelper() {
    }

    @JvmStatic
    public static final void showBusinessOutSideDialog(INavigator iNavigator, String str, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(function0, "changeAddressListener");
        Intrinsics.checkNotNullParameter(function02, "exploreMoreListener");
        Intrinsics.checkNotNullParameter(function03, "dismissListener");
        if (iNavigator != null) {
            dismissAllDialog();
            RFCommonDialog.Builder builder = (RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_business_dialog_out_of_delivery));
            StringBuilder sb = new StringBuilder();
            sb.append(ResourceHelper.getString(R.string.customer_business_dialog_current_address));
            sb.append(": ");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            RFCommonDialog rFCommonDialog = (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) builder.setMessage(sb.toString()).setMainAction(ResourceHelper.getString(R.string.customer_business_dialog_change_my_address), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    BusinessDialogHelper.m28269a(Function0.this, rFDialog);
                }
            })).setSubAction1(ResourceHelper.getString(R.string.customer_business_dialog_look_more_shops), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    BusinessDialogHelper.m28270b(Function0.this, rFDialog);
                }
            })).setSubAction2(ResourceHelper.getString(R.string.customer_dialog_cancel), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    BusinessDialogHelper.m28271c(Function0.this, rFDialog);
                }
            })).create();
            f39674a.add(rFCommonDialog);
            SodaWindowFactory.showDialog(iNavigator, (Dialog) rFCommonDialog);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28269a(Function0 function0, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(function0, "$changeAddressListener");
        rFDialog.dismiss();
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m28270b(Function0 function0, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(function0, "$exploreMoreListener");
        rFDialog.dismiss();
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m28271c(Function0 function0, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(function0, "$dismissListener");
        rFDialog.dismiss();
        function0.invoke();
    }

    @JvmStatic
    public static final void showBusinessClosedsDialog(ScopeContext scopeContext, Context context, String str, Function0<Unit> function0, Function0<Unit> function02) {
        String str2;
        Intrinsics.checkNotNullParameter(function0, "exploreMoreListener");
        Intrinsics.checkNotNullParameter(function02, "dismissListener");
        if (scopeContext != null && scopeContext.getLiveHandler().isActive() && context != null) {
            dismissAllDialog();
            if (TextUtils.isEmpty(str)) {
                str2 = ResourceHelper.getString(R.string.FoodC_16version_The_store_kegu);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = ResourceHelper.getString(R.string.FoodC_16version_The_store_iQkV);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.FoodC_16version_The_store_iQkV)");
                str2 = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
            }
            RFCommonDialog rFCommonDialog = (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_16version_Attention_gsaT))).setMessage(str2).setMainAction(ResourceHelper.getString(R.string.FoodC_demand_Determination_wKQX), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    BusinessDialogHelper.m28272d(Function0.this, rFDialog);
                }
            })).setSubAction2(ResourceHelper.getString(R.string.customer_dialog_cancel), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    BusinessDialogHelper.m28273e(Function0.this, rFDialog);
                }
            })).setAutoDismiss(true)).create();
            f39674a.add(rFCommonDialog);
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) rFCommonDialog);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m28272d(Function0 function0, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(function0, "$exploreMoreListener");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m28273e(Function0 function0, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(function0, "$dismissListener");
        function0.invoke();
    }

    @JvmStatic
    public static final void dismissAllDialog() {
        for (Dialog dismiss : f39674a) {
            dismiss.dismiss();
        }
    }
}
