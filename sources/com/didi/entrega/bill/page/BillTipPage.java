package com.didi.entrega.bill.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.bill.CustomerCartChangeHandler;
import com.didi.entrega.bill.component.tip.BillTipComponent;
import com.didi.entrega.customer.base.pages.FloatingCustomerPage;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/bill/page/BillTipPage;", "Lcom/didi/entrega/customer/base/pages/FloatingCustomerPage;", "()V", "mCartContainer", "Landroid/widget/FrameLayout;", "mContentView", "Landroid/view/View;", "getPopHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getPushHandler", "initContentView", "", "onCreate", "view", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route(interceptors = {BillTipPageInterceptor.class}, value = {"billTipPage"})
/* compiled from: BillTipPage.kt */
public final class BillTipPage extends FloatingCustomerPage {

    /* renamed from: a */
    private FrameLayout f19573a;

    /* renamed from: b */
    private View f19574b;

    public ControllerChangeHandler getPopHandler() {
        return new CustomerCartChangeHandler(R.id.entrega_custom_confirm_button, false);
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerCartChangeHandler(R.id.entrega_custom_confirm_button, false);
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f19574b;
        FrameLayout frameLayout = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        setContentView(view2);
        setType(2);
        FrameLayout frameLayout2 = this.f19573a;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCartContainer");
        } else {
            frameLayout = frameLayout2;
        }
        addComponent(new BillTipComponent(frameLayout));
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.entrega_page_bill_tip, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f19574b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…stomer_fl_cart_container)");
        this.f19573a = (FrameLayout) findViewById;
    }
}
