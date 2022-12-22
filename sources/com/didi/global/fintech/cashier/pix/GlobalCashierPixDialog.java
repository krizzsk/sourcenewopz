package com.didi.global.fintech.cashier.pix;

import android.animation.LayoutTransition;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierBaseDialogFragment;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixLoadingView;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixPresenter;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixView;
import com.didi.global.fintech.cashier.pix.presenter.GlobalCashierPixPresenter;
import com.didi.global.fintech.cashier.pix.view.GlobalCashierPixCodeView;
import com.didi.global.fintech.cashier.pix.view.GlobalCashierPixLoadingView;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/GlobalCashierPixDialog;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDialogFragment;", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController;", "()V", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "mCurState", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController$State;", "mPixLoadingView", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixLoadingView;", "mPixPresenter", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixPresenter;", "mPixView", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView;", "mRootView", "Landroid/view/ViewGroup;", "pixCode", "", "type", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView$Type;", "getType", "()Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView$Type;", "setType", "(Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView$Type;)V", "uniqueId", "finish", "", "getPixCode", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "updateState", "state", "Companion", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPixDialog.kt */
public final class GlobalCashierPixDialog extends GlobalCashierBaseDialogFragment implements IGlobalCashierPixController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    private static final String f21636j = "type";

    /* renamed from: k */
    private static final String f21637k = "pixCode";

    /* renamed from: l */
    private static final String f21638l = "param";

    /* renamed from: m */
    private static final String f21639m = "uniqueId";

    /* renamed from: a */
    private IGlobalCashierPixView.Type f21640a;

    /* renamed from: b */
    private String f21641b;

    /* renamed from: c */
    private CashierParam f21642c;

    /* renamed from: d */
    private String f21643d;

    /* renamed from: e */
    private ViewGroup f21644e;

    /* renamed from: f */
    private IGlobalCashierPixView f21645f;

    /* renamed from: g */
    private IGlobalCashierPixLoadingView f21646g;

    /* renamed from: h */
    private IGlobalCashierPixPresenter f21647h;

    /* renamed from: i */
    private IGlobalCashierPixController.State f21648i;

    public final IGlobalCashierPixView.Type getType() {
        return this.f21640a;
    }

    public final void setType(IGlobalCashierPixView.Type type) {
        this.f21640a = type;
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/GlobalCashierPixDialog$Companion;", "", "()V", "ARG_CODE", "", "ARG_PARAM", "ARG_TYPE", "ARG_UNIQUE_ID", "newInstance", "Lcom/didi/global/fintech/cashier/pix/GlobalCashierPixDialog;", "type", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView$Type;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "uniqueId", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierPixDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierPixDialog newInstance(IGlobalCashierPixView.Type type, CashierAction cashierAction, CashierParam cashierParam, String str) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(cashierAction, "action");
            Intrinsics.checkNotNullParameter(cashierParam, "param");
            GlobalCashierPixDialog globalCashierPixDialog = new GlobalCashierPixDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("type", type);
            bundle.putString(GlobalCashierPixDialog.f21637k, cashierAction.pixCode());
            bundle.putString(GlobalCashierPixDialog.f21639m, str);
            bundle.putSerializable("param", cashierParam);
            Unit unit = Unit.INSTANCE;
            globalCashierPixDialog.setArguments(bundle);
            return globalCashierPixDialog;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String string;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        IGlobalCashierPixView iGlobalCashierPixView = null;
        IGlobalCashierPixView.Type type = (IGlobalCashierPixView.Type) (arguments == null ? null : arguments.getSerializable("type"));
        if (type == null) {
            type = IGlobalCashierPixView.Type.Normal;
        }
        this.f21640a = type;
        Bundle arguments2 = getArguments();
        this.f21642c = (CashierParam) (arguments2 == null ? null : arguments2.getSerializable("param"));
        Bundle arguments3 = getArguments();
        String str2 = "";
        if (arguments3 == null || (str = arguments3.getString(f21637k)) == null) {
            str = str2;
        }
        this.f21641b = str;
        Bundle arguments4 = getArguments();
        if (!(arguments4 == null || (string = arguments4.getString(f21639m)) == null)) {
            str2 = string;
        }
        this.f21643d = str2;
        View inflate = layoutInflater.inflate(R.layout.dialog_global_cashier_pix, viewGroup, false);
        ViewGroup viewGroup2 = inflate instanceof ViewGroup ? (ViewGroup) inflate : null;
        this.f21644e = viewGroup2;
        if (viewGroup2 != null) {
            viewGroup2.setLayoutTransition(new LayoutTransition());
        }
        IGlobalCashierPixLoadingView globalCashierPixLoadingView = new GlobalCashierPixLoadingView(getContext());
        this.f21646g = globalCashierPixLoadingView;
        ViewGroup viewGroup3 = this.f21644e;
        if (viewGroup3 != null) {
            if (globalCashierPixLoadingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixLoadingView");
                globalCashierPixLoadingView = null;
            }
            viewGroup3.addView(globalCashierPixLoadingView.getView());
        }
        IGlobalCashierPixView globalCashierPixCodeView = new GlobalCashierPixCodeView(getContext());
        this.f21645f = globalCashierPixCodeView;
        ViewGroup viewGroup4 = this.f21644e;
        if (viewGroup4 != null) {
            if (globalCashierPixCodeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixView");
            } else {
                iGlobalCashierPixView = globalCashierPixCodeView;
            }
            viewGroup4.addView(iGlobalCashierPixView.getView());
        }
        return this.f21644e;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View decorView;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setCanceledOnTouchOutside(false);
        onCreateDialog.requestWindowFeature(1);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = onCreateDialog.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
        }
        Window window3 = onCreateDialog.getWindow();
        if (!(window3 == null || (decorView = window3.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        Window window4 = onCreateDialog.getWindow();
        if (window4 != null) {
            window4.setLayout(-1, -2);
        }
        Window window5 = onCreateDialog.getWindow();
        WindowManager.LayoutParams attributes = window5 == null ? null : window5.getAttributes();
        if (attributes != null) {
            attributes.windowAnimations = R.style.pix_dialog_style_animation;
        }
        return onCreateDialog;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        GlobalCashierPixDialog globalCashierPixDialog = this;
        String str = this.f21641b;
        IGlobalCashierPixPresenter iGlobalCashierPixPresenter = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(f21637k);
            str = null;
        }
        if ((str.length() == 0 ? this : null) == null) {
            setCancelable(false);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            IGlobalCashierPixPresenter globalCashierPixPresenter = new GlobalCashierPixPresenter(context, this.f21643d, this);
            this.f21647h = globalCashierPixPresenter;
            if (globalCashierPixPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixPresenter");
                globalCashierPixPresenter = null;
            }
            globalCashierPixPresenter.init(this.f21642c);
            IGlobalCashierPixPresenter iGlobalCashierPixPresenter2 = this.f21647h;
            if (iGlobalCashierPixPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixPresenter");
                iGlobalCashierPixPresenter2 = null;
            }
            IGlobalCashierPixView iGlobalCashierPixView = this.f21645f;
            if (iGlobalCashierPixView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixView");
                iGlobalCashierPixView = null;
            }
            iGlobalCashierPixPresenter2.bindView(iGlobalCashierPixView);
            IGlobalCashierPixPresenter iGlobalCashierPixPresenter3 = this.f21647h;
            if (iGlobalCashierPixPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixPresenter");
            } else {
                iGlobalCashierPixPresenter = iGlobalCashierPixPresenter3;
            }
            iGlobalCashierPixPresenter.onBind();
            updateState(IGlobalCashierPixController.State.Normal);
            return;
        }
        dismissAllowingStateLoss();
    }

    public void updateState(IGlobalCashierPixController.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.f21648i != state) {
            this.f21648i = state;
            IGlobalCashierPixView iGlobalCashierPixView = this.f21645f;
            IGlobalCashierPixLoadingView iGlobalCashierPixLoadingView = null;
            if (iGlobalCashierPixView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixView");
                iGlobalCashierPixView = null;
            }
            iGlobalCashierPixView.updateState(state);
            IGlobalCashierPixLoadingView iGlobalCashierPixLoadingView2 = this.f21646g;
            if (iGlobalCashierPixLoadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPixLoadingView");
            } else {
                iGlobalCashierPixLoadingView = iGlobalCashierPixLoadingView2;
            }
            iGlobalCashierPixLoadingView.updateState(state);
        }
    }

    public String getPixCode() {
        String str = this.f21641b;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(f21637k);
        return null;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
            r3 = this;
            r3.dismissAllowingStateLoss()
            r0 = r3
            com.didi.global.fintech.cashier.pix.GlobalCashierPixDialog r0 = (com.didi.global.fintech.cashier.pix.GlobalCashierPixDialog) r0
            com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r0 = r3.f21648i
            com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r1 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.Success
            if (r0 != r1) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            r1 = 0
            if (r0 == 0) goto L_0x0014
            r0 = r3
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            com.didi.global.fintech.cashier.pix.GlobalCashierPixDialog r0 = (com.didi.global.fintech.cashier.pix.GlobalCashierPixDialog) r0
            if (r0 != 0) goto L_0x001a
            goto L_0x002b
        L_0x001a:
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            boolean r2 = r0 instanceof com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback
            if (r2 == 0) goto L_0x0025
            r1 = r0
            com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback r1 = (com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback) r1
        L_0x0025:
            if (r1 != 0) goto L_0x0028
            goto L_0x002b
        L_0x0028:
            r1.onPixPaid()
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.pix.GlobalCashierPixDialog.finish():void");
    }
}
