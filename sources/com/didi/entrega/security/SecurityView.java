package com.didi.entrega.security;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.security.Contract;
import com.didi.entrega.security.binder.CurpBinder;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\"\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001aH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/entrega/security/SecurityView;", "Lcom/didi/entrega/security/Contract$AbsSecurityView;", "()V", "mClose", "Lcom/didi/rfusion/widget/RFIconView;", "getMClose", "()Lcom/didi/rfusion/widget/RFIconView;", "setMClose", "(Lcom/didi/rfusion/widget/RFIconView;)V", "mRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "getMRecyclerView", "()Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "setMRecyclerView", "(Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;)V", "mSecurityCaution", "Landroid/widget/TextView;", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SecurityView.kt */
public final class SecurityView extends Contract.AbsSecurityView {

    /* renamed from: a */
    private TextView f21048a;
    public RFIconView mClose;
    public NovaRecyclerView mRecyclerView;

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public final NovaRecyclerView getMRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.mRecyclerView;
        if (novaRecyclerView != null) {
            return novaRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    public final void setMRecyclerView(NovaRecyclerView novaRecyclerView) {
        Intrinsics.checkNotNullParameter(novaRecyclerView, "<set-?>");
        this.mRecyclerView = novaRecyclerView;
    }

    public final RFIconView getMClose() {
        RFIconView rFIconView = this.mClose;
        if (rFIconView != null) {
            return rFIconView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mClose");
        return null;
    }

    public final void setMClose(RFIconView rFIconView) {
        Intrinsics.checkNotNullParameter(rFIconView, "<set-?>");
        this.mClose = rFIconView;
    }

    public void onCreate() {
        super.onCreate();
        getMClose().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SecurityView.m15434a(SecurityView.this, view);
            }
        });
        TextView textView = this.f21048a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecurityCaution");
            textView = null;
        }
        textView.setText(getResources().getString(R.string.FoodC_up_Your_account_BdkC, new Object[]{ResourceHelper.getString(R.string.entrega_app_name)}));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15434a(SecurityView securityView, View view) {
        Intrinsics.checkNotNullParameter(securityView, "this$0");
        securityView.getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_component_security_container, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_rv_security_method);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_rv_security_method)");
        setMRecyclerView((NovaRecyclerView) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_close)");
        setMClose((RFIconView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_tv_security_method_caution);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…_security_method_caution)");
        this.f21048a = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…method_caution)\n        }");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return getMRecyclerView();
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new CurpBinder(new SecurityView$initItemBinders$1(this)));
    }
}
