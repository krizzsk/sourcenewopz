package com.didi.unifylogin.base.view;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.dialog.ProductThemeStyle;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\bJ\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/unifylogin/base/view/ProgressDialogFragment;", "Lcom/didi/unifylogin/base/view/BaseDialogFragment;", "()V", "mIndeterminateDrawableID", "", "mMessage", "", "mOutsideTouchable", "", "dismiss", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setContent", "message", "cancelable", "setIndeterminateDrawable", "resId", "setOutsideTouchable", "touchable", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ProgressDialogFragment.kt */
public final class ProgressDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private String f44716a;

    /* renamed from: b */
    private boolean f44717b;

    /* renamed from: c */
    private int f44718c = R.drawable.login_unify_loading_progress_bar;

    public ProgressDialogFragment() {
        ProductControllerStyleManager instance = ProductControllerStyleManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "ProductControllerStyleManager.getInstance()");
        ProductThemeStyle productThemeStyle = instance.getProductThemeStyle();
        Intrinsics.checkExpressionValueIsNotNull(productThemeStyle, "ProductControllerStyleMa…tance().productThemeStyle");
        if (productThemeStyle.getIndeterminateDrawable() != 0) {
            ProductControllerStyleManager instance2 = ProductControllerStyleManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance2, "ProductControllerStyleManager.getInstance()");
            ProductThemeStyle productThemeStyle2 = instance2.getProductThemeStyle();
            Intrinsics.checkExpressionValueIsNotNull(productThemeStyle2, "ProductControllerStyleMa…tance().productThemeStyle");
            this.f44718c = productThemeStyle2.getIndeterminateDrawable();
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(dialog, "this.dialog!!");
        Window window = dialog.getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.flags |= 2;
        window.setAttributes(attributes);
    }

    public void show(FragmentManager fragmentManager, String str) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "manager");
        if (TextUtils.isEmpty(str)) {
            str = "__didi_ProgressDialogFragment";
        }
        super.show(fragmentManager, str);
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        Intrinsics.checkParameterIsNotNull(fragmentTransaction, SDKConsts.MSG_TAG_TRAN);
        if (isAdded() || isVisible() || isRemoving()) {
            return 0;
        }
        return super.show(fragmentTransaction, str);
    }

    public final void setIndeterminateDrawable(int i) {
        this.f44718c = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (this.f44717b) {
            Window window2 = dialog.getWindow();
            if (window2 == null) {
                Intrinsics.throwNpe();
            }
            window2.clearFlags(16);
            Window window3 = dialog.getWindow();
            if (window3 == null) {
                Intrinsics.throwNpe();
            }
            window3.addFlags(8);
            Window window4 = dialog.getWindow();
            if (window4 == null) {
                Intrinsics.throwNpe();
            }
            window4.addFlags(128);
        }
        View inflate = layoutInflater.inflate(R.layout.login_unify_loading, viewGroup);
        View findViewById = inflate.findViewById(R.id.progress_bar);
        if (findViewById != null) {
            ((ProgressBar) findViewById).setIndeterminateDrawable(ResourcesCompat.getDrawable(getResources(), this.f44718c, (Resources.Theme) null));
            if (!TextUtils.isEmpty(this.f44716a)) {
                View findViewById2 = inflate.findViewById(R.id.tv_msg);
                if (findViewById2 != null) {
                    ((TextView) findViewById2).setText(this.f44716a);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
            }
            return inflate;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ProgressBar");
    }

    public void dismiss() {
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception unused) {
        }
    }

    public final void setContent(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.f44716a = str;
        setCancelable(z);
    }

    public final void setOutsideTouchable(boolean z) {
        this.f44717b = z;
    }
}
