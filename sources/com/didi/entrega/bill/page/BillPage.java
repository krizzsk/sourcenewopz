package com.didi.entrega.bill.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.component.bill.BillComponent;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.bill.datastore.BillRepoExtKt;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.customer.foundation.rpc.entity.CouponInfo;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.rpc.entity.TipFeeInfo;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/entrega/bill/page/BillPage;", "Lcom/didi/entrega/customer/base/pages/CustomerPage;", "()V", "billComponent", "Lcom/didi/entrega/bill/component/bill/BillComponent;", "mapRootView", "Landroid/view/ViewGroup;", "rootView", "doUpdate", "", "data", "Landroid/os/Bundle;", "scope", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getStatusBarHeight", "", "getTouchIntercept", "", "onCreate", "view", "Landroid/view/View;", "onHandleBack", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onPageResult", "setupComponents", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"flutterBillPage"})
/* compiled from: BillPage.kt */
public final class BillPage extends CustomerPage {

    /* renamed from: a */
    private ViewGroup f19570a;

    /* renamed from: b */
    private ViewGroup f19571b;

    /* renamed from: c */
    private BillComponent f19572c;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public boolean getTouchIntercept() {
        return false;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_page_bill, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.entrega_bill_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.entrega_bill_root_view)");
        this.f19570a = (ViewGroup) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_custom_address_map_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.e…om_address_map_container)");
        this.f19571b = (ViewGroup) findViewById2;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return inflate;
    }

    public boolean onHandleBack() {
        BillComponent billComponent = this.f19572c;
        if (billComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billComponent");
            billComponent = null;
        }
        if (billComponent.onHandleBack()) {
            return true;
        }
        return super.onHandleBack();
    }

    /* renamed from: a */
    private final void m14612a(Bundle bundle, ScopeContext scopeContext) {
        try {
            Object obj = bundle.get("payMethodPage");
            if (obj != null) {
                BillRepoExtKt.updatePayChannel(BillRepo.Companion.get(scopeContext), (PayChannel) obj);
            }
            Object obj2 = bundle.get(Const.BundleKey.INFO_PAGE_BILL_SEND);
            if (obj2 != null) {
                BillRepoExtKt.updateSenderAddress(BillRepo.Companion.get(scopeContext), (AddressEntity) obj2);
            }
            Object obj3 = bundle.get(Const.BundleKey.INFO_PAGE_BILL_RECEIVE);
            if (obj3 != null) {
                BillRepoExtKt.updateReceiverAddress(BillRepo.Companion.get(scopeContext), (AddressEntity) obj3);
            }
            Object obj4 = bundle.get(Const.BundleKey.INFO_PAGE_BILL_STUFF);
            if (obj4 != null) {
                BillRepoExtKt.updatePackageInfo(BillRepo.Companion.get(scopeContext), (ContactStufEntity) obj4);
            }
            Object obj5 = bundle.get(Const.BundleKey.SELECT_TIP_FEE);
            if (obj5 != null) {
                BillRepoExtKt.updateTip(BillRepo.Companion.get(scopeContext), (TipFeeInfo) obj5);
            }
            Object obj6 = bundle.get(Const.BundleKey.SELECT_COUPON);
            if (obj6 != null) {
                BillRepoExtKt.updateCoupon(BillRepo.Companion.get(scopeContext), (CouponInfo) obj6);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        ScopeContext scopeContext = getScopeContext();
        if (bundle != null && scopeContext != null) {
            m14612a(bundle, scopeContext);
        }
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BillRepo.Companion.initBillRepo(this);
        super.onCreate(view);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        ViewGroup viewGroup = this.f19571b;
        BillComponent billComponent = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapRootView");
            viewGroup = null;
        }
        addComponent(new BillAddressMapComponent(viewGroup));
        ViewGroup viewGroup2 = this.f19570a;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup2 = null;
        }
        BillComponent billComponent2 = new BillComponent(viewGroup2);
        this.f19572c = billComponent2;
        if (billComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billComponent");
        } else {
            billComponent = billComponent2;
        }
        addComponent(billComponent);
    }
}
