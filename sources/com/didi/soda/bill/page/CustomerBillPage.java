package com.didi.soda.bill.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.bill.component.bill.BillWsgTouchHelper;
import com.didi.soda.bill.component.bill.CustomerBillComponent;
import com.didi.soda.bill.component.cpf.CPFCheckComponent;
import com.didi.soda.bill.component.cpf.CPFCheckVisibleListener;
import com.didi.soda.bill.repo.BillAlertRepo;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.changehandler.CustomerHorizontalChangeHandler;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didi/soda/bill/page/CustomerBillPage;", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "Lcom/didi/soda/bill/component/cpf/CPFCheckVisibleListener;", "()V", "billComponent", "Lcom/didi/soda/bill/component/bill/CustomerBillComponent;", "getBillComponent", "()Lcom/didi/soda/bill/component/bill/CustomerBillComponent;", "setBillComponent", "(Lcom/didi/soda/bill/component/bill/CustomerBillComponent;)V", "cpfCheckComponent", "Lcom/didi/soda/bill/component/cpf/CPFCheckComponent;", "mBillContainer", "Landroid/widget/FrameLayout;", "mCPFContainer", "getPushHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getStatusBarHeight", "", "hideCPFCheckView", "", "onCreate", "view", "Landroid/view/View;", "onDestroy", "onHandleBack", "", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPageResult", "data", "Landroid/os/Bundle;", "showCPFCheckView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"billPage"})
/* compiled from: CustomerBillPage.kt */
public final class CustomerBillPage extends CustomerPage implements CPFCheckVisibleListener {

    /* renamed from: a */
    private FrameLayout f39147a;

    /* renamed from: b */
    private FrameLayout f39148b;

    /* renamed from: c */
    private CPFCheckComponent f39149c;

    /* renamed from: d */
    private CustomerBillComponent f39150d;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public final CustomerBillComponent getBillComponent() {
        return this.f39150d;
    }

    public final void setBillComponent(CustomerBillComponent customerBillComponent) {
        this.f39150d = customerBillComponent;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_bill_container, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.customer_fl_bill_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.customer_fl_bill_container)");
        this.f39147a = (FrameLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_fl_cpf_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.customer_fl_cpf_container)");
        this.f39148b = (FrameLayout) findViewById2;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return inflate;
    }

    public ControllerChangeHandler getPushHandler() {
        Bundle bundle;
        ScopeContext scopeContext = getScopeContext();
        String str = null;
        if (!(scopeContext == null || (bundle = scopeContext.getBundle()) == null)) {
            str = bundle.getString("from_page", "");
        }
        if (Intrinsics.areEqual((Object) str, (Object) "discountDetail")) {
            return new CustomerHorizontalChangeHandler(200, false);
        }
        return super.getPushHandler();
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        BillWsgTouchHelper.Companion.getInstance().attach(getScopeContext());
        FrameLayout frameLayout = this.f39147a;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBillContainer");
            frameLayout = null;
        }
        CustomerBillComponent customerBillComponent = new CustomerBillComponent(frameLayout);
        addComponent(customerBillComponent);
        Unit unit = Unit.INSTANCE;
        this.f39150d = customerBillComponent;
        if (customerBillComponent != null) {
            customerBillComponent.setCPFVisibleListener(this);
        }
        if (GlobalContext.isEmbed()) {
            GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
        }
    }

    public boolean onHandleBack() {
        CustomerBillComponent customerBillComponent = this.f39150d;
        if (customerBillComponent == null ? false : customerBillComponent.onHandleBack()) {
            return true;
        }
        return super.onHandleBack();
    }

    public void onPageResult(Bundle bundle) {
        CustomerBillComponent billComponent;
        if (bundle != null && (billComponent = getBillComponent()) != null) {
            billComponent.onPageResult(bundle);
        }
    }

    public void showCPFCheckView() {
        FrameLayout frameLayout = this.f39148b;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFContainer");
            frameLayout = null;
        }
        CPFCheckComponent cPFCheckComponent = new CPFCheckComponent(frameLayout);
        addComponent(cPFCheckComponent);
        Unit unit = Unit.INSTANCE;
        this.f39149c = cPFCheckComponent;
        if (cPFCheckComponent != null) {
            cPFCheckComponent.setCPFCheckComponentListener(this);
        }
    }

    public void hideCPFCheckView() {
        CPFCheckComponent cPFCheckComponent = this.f39149c;
        if (cPFCheckComponent != null) {
            removeComponent(cPFCheckComponent);
            this.f39149c = null;
        }
        BillAlertRepo.Companion.notifyDataChange(true);
    }

    public void onDestroy() {
        super.onDestroy();
        BillWsgTouchHelper.Companion.getInstance().detach();
    }
}
