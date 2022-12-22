package com.didi.entrega.security;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.pay.IPayMethodCallback;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/security/SecurityPage;", "Lcom/didi/entrega/customer/base/pages/CustomerPage;", "Lcom/didi/entrega/pay/IPayMethodCallback;", "()V", "mContainer", "Landroid/widget/FrameLayout;", "getMContainer", "()Landroid/widget/FrameLayout;", "setMContainer", "(Landroid/widget/FrameLayout;)V", "onCreate", "", "view", "Landroid/view/View;", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPageResult", "data", "Landroid/os/Bundle;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"securityPage"})
/* compiled from: SecurityPage.kt */
public final class SecurityPage extends CustomerPage implements IPayMethodCallback {
    public FrameLayout mContainer;

    public final FrameLayout getMContainer() {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public final void setMContainer(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mContainer = frameLayout;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        addComponent(new SecurityComponent(getMContainer()));
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_page_security_container, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.customer_fl_security_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_fl_security_container)");
        setMContainer((FrameLayout) findViewById);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…rity_container)\n        }");
        return inflate;
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        if (bundle != null) {
            try {
                if (new JSONObject(bundle.getString("risk_auth_result")).optInt("status") == 0) {
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
