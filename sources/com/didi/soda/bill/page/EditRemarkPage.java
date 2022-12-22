package com.didi.soda.bill.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.bill.CustomerCartChangeHandler;
import com.didi.soda.bill.component.editremark.EditRemarkComponent;
import com.didi.soda.bill.component.editremark2.EditRemarkComponent2;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/bill/page/EditRemarkPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "cartContainer", "Landroid/widget/FrameLayout;", "rootView", "Landroid/view/View;", "getPopHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getPushHandler", "initContentView", "", "onCreate", "view", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"remarkEditPage"})
/* compiled from: EditRemarkPage.kt */
public final class EditRemarkPage extends FloatingCustomerPage {

    /* renamed from: a */
    private FrameLayout f39160a;

    /* renamed from: b */
    private View f39161b;

    public ControllerChangeHandler getPopHandler() {
        if (!Const.ABConfigName.BILL_PAGE.isSwitchOn()) {
            return new CustomerCartChangeHandler(R.id.customer_custom_common_confirm, false);
        }
        return super.getPopHandler();
    }

    public ControllerChangeHandler getPushHandler() {
        if (!Const.ABConfigName.BILL_PAGE.isSwitchOn()) {
            return new CustomerCartChangeHandler(R.id.customer_custom_common_confirm, false);
        }
        return super.getPushHandler();
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f39161b;
        FrameLayout frameLayout = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view2 = null;
        }
        setContentView(view2);
        if (!Const.ABConfigName.BILL_PAGE.isSwitchOn()) {
            setType(2);
            FrameLayout frameLayout2 = this.f39160a;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartContainer");
            } else {
                frameLayout = frameLayout2;
            }
            addComponent(new EditRemarkComponent(frameLayout));
            return;
        }
        setType(1);
        FrameLayout frameLayout3 = this.f39160a;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartContainer");
        } else {
            frameLayout = frameLayout3;
        }
        addComponent(new EditRemarkComponent2(frameLayout));
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        if (!Const.ABConfigName.BILL_PAGE.isSwitchOn()) {
            View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_rff_edit_remark, (ViewGroup) getView(), false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
            this.f39161b = inflate;
        } else {
            View inflate2 = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_rff_edit_remark2, (ViewGroup) getView(), false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(baseContext).inflat…view as ViewGroup, false)");
            this.f39161b = inflate2;
        }
        View view = this.f39161b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…stomer_fl_cart_container)");
        this.f39160a = (FrameLayout) findViewById;
    }
}
