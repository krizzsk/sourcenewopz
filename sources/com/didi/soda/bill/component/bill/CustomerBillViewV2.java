package com.didi.soda.bill.component.bill;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.soda.bill.binder.CustomerBillBinderV2;
import com.didi.soda.bill.binder.CustomerDisclaimerBinderV2;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.BillFocusHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.BillAddressItemViewV2;
import com.didi.soda.bill.view.item.logic.CartCouponAnimHelper;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2;
import com.didi.soda.bill.widgets.btn.BillPayLayout;
import com.didi.soda.bill.widgets.notify.DefaultNotifyView;
import com.didi.soda.bill.widgets.notify.NotifyLayout;
import com.didi.soda.customer.component.feed.decorator.CustomerSimpleDecorator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.goodsV2.binder.EmptyHeightBinder;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001MB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0016\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\u0006\u0010\"\u001a\u00020\nH\u0002J\u0016\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\u0006\u0010$\u001a\u00020\nH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\nH\u0002J\u0012\u0010(\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010)\u001a\u00020*H\u0014J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\u0018\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020&H\u0014J\b\u00106\u001a\u00020\u0018H\u0002J\b\u00107\u001a\u00020\u0018H\u0014J\b\u00108\u001a\u00020\u0018H\u0002J\u0018\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\rH\u0016J\b\u0010<\u001a\u00020\u0018H\u0016J\b\u0010=\u001a\u00020\u0018H\u0002J\u0012\u0010>\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010?\u001a\u00020\u00182\b\u0010@\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020CH\u0016J\u0012\u0010D\u001a\u00020\u00182\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010I\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020\u0018H\u0016J\b\u0010L\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006N"}, mo175978d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillViewV2;", "Lcom/didi/soda/bill/component/Contract$AbsBillView;", "()V", "abnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "addressIcon", "Landroid/view/View;", "addressName", "Landroid/widget/TextView;", "addressViewIndex", "", "backView", "lastReminderContent", "", "noticeLayout", "Lcom/didi/soda/bill/widgets/notify/NotifyLayout;", "notifyView", "Lcom/didi/soda/bill/widgets/notify/DefaultNotifyView;", "payLayout", "Lcom/didi/soda/bill/widgets/btn/BillPayLayout;", "recycleView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "titleView", "anchorBeforePosition", "", "content", "autoClickItem", "model", "Lcom/didi/soda/bill/model/ComponentModel;", "type", "bundle", "Landroid/os/Bundle;", "findAddressView", "Lcom/didi/soda/bill/view/BillItemView;", "addressIndex", "findFirstItemView", "sectionIndex", "findSectionItemView", "Landroid/view/ViewGroup;", "focusBillItemView", "focusItem", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getItemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "context", "Landroid/content/Context;", "getPayButtonCallback", "Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "hideAbnormalView", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "initConfirmBtn", "initItemBinders", "initView", "loadNotify", "shopId", "cartId", "onCreate", "resetAddressTitle", "setAddressData", "setAddressName", "name", "setPayPrice", "billEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "setTipsContent", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "setupNovaRecyclerView", "novaRecyclerView", "showAbnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalViewModel;", "showNotice", "updateCouponIcon", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillViewV2.kt */
public final class CustomerBillViewV2 extends Contract.AbsBillView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CustomerBillView";

    /* renamed from: a */
    private TopGunAbnormalView f38902a;

    /* renamed from: b */
    private NovaRecyclerView f38903b;

    /* renamed from: c */
    private View f38904c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f38905d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f38906e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f38907f;

    /* renamed from: g */
    private NotifyLayout f38908g;

    /* renamed from: h */
    private DefaultNotifyView f38909h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BillPayLayout f38910i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f38911j = -1;

    /* renamed from: k */
    private String f38912k;

    public void setTipsContent(AddressEntity addressEntity) {
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillViewV2$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerBillViewV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f38903b;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        NovaRecyclerView novaRecyclerView = this.f38903b;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.setItemViewCacheSize(8);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_bill_view_v2, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_bill_abnormal_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.c…tomer_bill_abnormal_view)");
        this.f38902a = (TopGunAbnormalView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_custom_bill_rv_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.c…omer_custom_bill_rv_view)");
        this.f38903b = (NovaRecyclerView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_iv_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.customer_iv_page_back)");
        this.f38904c = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_tv_title_label);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.customer_tv_title_label)");
        this.f38905d = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_iv_page_opt_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.customer_iv_page_opt_icon)");
        this.f38907f = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_tv_page_opt_label);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.customer_tv_page_opt_label)");
        this.f38906e = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.noticeLayout);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.noticeLayout)");
        this.f38908g = (NotifyLayout) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_custom_mini_cart_pay_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.c…_mini_cart_pay_container)");
        this.f38910i = (BillPayLayout) findViewById8;
        this.f38909h = new DefaultNotifyView();
        NotifyLayout notifyLayout = this.f38908g;
        DefaultNotifyView defaultNotifyView = null;
        if (notifyLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noticeLayout");
            notifyLayout = null;
        }
        DefaultNotifyView defaultNotifyView2 = this.f38909h;
        if (defaultNotifyView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifyView");
        } else {
            defaultNotifyView = defaultNotifyView2;
        }
        notifyLayout.setNotifyHolder(defaultNotifyView);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return inflate;
    }

    public void loadNotify(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        LogUtil.m29104i("CustomerBillView", "loadNotify shopId = " + str + " ,cartId = " + str2);
        DefaultNotifyView defaultNotifyView = this.f38909h;
        if (defaultNotifyView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifyView");
            defaultNotifyView = null;
        }
        defaultNotifyView.requestAlertInfo(str, str2);
    }

    public void showNotice() {
        LogUtil.m29104i("CustomerBillView", "showNotice");
        NotifyLayout notifyLayout = this.f38908g;
        if (notifyLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noticeLayout");
            notifyLayout = null;
        }
        notifyLayout.post(new Runnable() {
            public final void run() {
                CustomerBillViewV2.m27619a(CustomerBillViewV2.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27619a(CustomerBillViewV2 customerBillViewV2) {
        Intrinsics.checkNotNullParameter(customerBillViewV2, "this$0");
        NotifyLayout notifyLayout = customerBillViewV2.f38908g;
        if (notifyLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noticeLayout");
            notifyLayout = null;
        }
        notifyLayout.notice();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r3.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAddressData(com.didi.soda.bill.model.ComponentModel r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0010
        L_0x0005:
            com.didi.soda.bill.model.ComponentDataModel r1 = r3.getData()
            if (r1 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            com.didi.soda.bill.model.datamodel.AddressModel r1 = r1.getAddressModel()
        L_0x0010:
            if (r3 != 0) goto L_0x0014
            r3 = -1
            goto L_0x0018
        L_0x0014:
            int r3 = r3.getSectionIndex()
        L_0x0018:
            r2.f38911j = r3
            if (r1 != 0) goto L_0x001e
            r3 = r0
            goto L_0x0027
        L_0x001e:
            java.lang.String r3 = r1.getAddressDisplayName()
            r2.m27621a((java.lang.String) r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0027:
            if (r3 != 0) goto L_0x002c
            r2.m27621a((java.lang.String) r0)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillViewV2.setAddressData(com.didi.soda.bill.model.ComponentModel):void");
    }

    public void setPayPrice(BillInfoEntity billInfoEntity) {
        Intrinsics.checkNotNullParameter(billInfoEntity, "billEntity");
        ((Contract.AbsBillPresenter) getPresenter()).startTotalPriceAnim(billInfoEntity.getRealPayPriceDisplay(), new CustomerBillViewV2$setPayPrice$1(this, billInfoEntity.getSaveMoneyHint()));
        BillPayLayout billPayLayout = this.f38910i;
        if (billPayLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payLayout");
            billPayLayout = null;
        }
        billPayLayout.setVisibility(0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v6, types: [com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView] */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void anchorBeforePosition(java.lang.String r6) {
        /*
            r5 = this;
            com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView r0 = r5.getNovaRecyclerView()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == 0) goto L_0x0093
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            java.lang.String r1 = r5.f38912k
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r1 = 0
            goto L_0x001e
        L_0x001d:
            r1 = 1
        L_0x001e:
            if (r1 != 0) goto L_0x0033
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x002e
            int r1 = r1.length()
            if (r1 != 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r1 = 0
            goto L_0x002f
        L_0x002e:
            r1 = 1
        L_0x002f:
            if (r1 == 0) goto L_0x0033
            r1 = 1
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            r4 = r6
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0042
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r4 = 0
            goto L_0x0043
        L_0x0042:
            r4 = 1
        L_0x0043:
            if (r4 != 0) goto L_0x004e
            java.lang.String r4 = r5.f38912k
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r4 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r2 = 0
        L_0x004f:
            r4 = 0
            if (r2 == 0) goto L_0x0062
            com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView r0 = r5.f38903b
            if (r0 != 0) goto L_0x005d
            java.lang.String r0 = "recycleView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x005e
        L_0x005d:
            r4 = r0
        L_0x005e:
            r4.smoothScrollToPosition(r3)
            goto L_0x0090
        L_0x0062:
            android.view.View r2 = r0.getChildAt(r3)
            if (r2 != 0) goto L_0x006a
            r3 = r4
            goto L_0x0072
        L_0x006a:
            int r3 = r2.getTop()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0072:
            if (r2 != 0) goto L_0x0075
            goto L_0x0081
        L_0x0075:
            int r2 = r0.getPosition(r2)
            if (r1 == 0) goto L_0x007d
            int r2 = r2 + -1
        L_0x007d:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
        L_0x0081:
            if (r4 == 0) goto L_0x0090
            if (r3 == 0) goto L_0x0090
            int r1 = r4.intValue()
            int r2 = r3.intValue()
            r0.scrollToPositionWithOffset(r1, r2)
        L_0x0090:
            r5.f38912k = r6
            return
        L_0x0093:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillViewV2.anchorBeforePosition(java.lang.String):void");
    }

    /* renamed from: a */
    private final void m27621a(String str) {
        TextView textView = this.f38906e;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
            textView = null;
        }
        textView.setText(str);
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new EmptyHeightBinder());
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        registerBinder(new CustomerBillBinderV2(scopeContext, m27617a(context)));
        registerBinder(new CustomerDisclaimerBinderV2());
    }

    /* renamed from: a */
    private final ItemDecorator m27617a(Context context) {
        return new CustomerSimpleDecorator(ResourceHelper.getColor(R.color.transparent), DisplayUtils.dip2px(context, 0.0f));
    }

    public void onCreate() {
        super.onCreate();
        LogUtil.m29104i("CustomerBillView", NachoLifecycleManager.LIFECYCLE_ON_CREATE);
        m27618a();
    }

    /* renamed from: a */
    private final void m27618a() {
        m27623b();
        NovaRecyclerView novaRecyclerView = this.f38903b;
        NovaRecyclerView novaRecyclerView2 = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.setItemDecorationEnable(true);
        View view = this.f38904c;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerBillViewV2.m27620a(CustomerBillViewV2.this, view);
            }
        });
        BillFocusHelper.Companion.resetFocusStatus();
        float dip2px = (float) DisplayUtils.dip2px(getContext(), 9.0f);
        NovaRecyclerView novaRecyclerView3 = this.f38903b;
        if (novaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView2 = novaRecyclerView3;
        }
        novaRecyclerView2.addOnScrollListener(new CustomerBillViewV2$initView$2(this, dip2px));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27620a(CustomerBillViewV2 customerBillViewV2, View view) {
        Intrinsics.checkNotNullParameter(customerBillViewV2, "this$0");
        ((Contract.AbsBillPresenter) customerBillViewV2.getPresenter()).onClickBack();
    }

    /* renamed from: b */
    private final void m27623b() {
        BillPayLayout billPayLayout = null;
        if (BillWsgTouchHelper.Companion.getInstance().getCreateOrderTouch() != null) {
            BillPayLayout billPayLayout2 = this.f38910i;
            if (billPayLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payLayout");
                billPayLayout2 = null;
            }
            billPayLayout2.getConfirmLayout().setOnTouchListener(BillWsgTouchHelper.Companion.getInstance().getCreateOrderTouch());
        }
        BillPayLayout billPayLayout3 = this.f38910i;
        if (billPayLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payLayout");
        } else {
            billPayLayout = billPayLayout3;
        }
        billPayLayout.getConfirmLayout().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerBillViewV2.m27624b(CustomerBillViewV2.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27624b(CustomerBillViewV2 customerBillViewV2, View view) {
        Intrinsics.checkNotNullParameter(customerBillViewV2, "this$0");
        ((Contract.AbsBillPresenter) customerBillViewV2.getPresenter()).onCreateOrder(customerBillViewV2.getPayButtonCallback());
    }

    public ICustomerPayManager.CartPayButtonCallback getPayButtonCallback() {
        BillPayLayout billPayLayout = this.f38910i;
        if (billPayLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payLayout");
            billPayLayout = null;
        }
        return billPayLayout.getPayButtonCallback();
    }

    public void focusItem(ComponentModel componentModel) {
        int sectionIndex = componentModel == null ? -1 : componentModel.getSectionIndex();
        if (sectionIndex >= 0) {
            NovaRecyclerView novaRecyclerView = this.f38903b;
            if (novaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                novaRecyclerView = null;
            }
            novaRecyclerView.smoothScrollToPosition(sectionIndex);
            m27628d(sectionIndex);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m27626c() {
        String string = getScopeContext().getBundle().getString("cart_id", "");
        NovaRecyclerView novaRecyclerView = this.f38903b;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        CartCouponAnimHelper.showCouponIconAnim(novaRecyclerView, string);
    }

    /* renamed from: d */
    private final void m27627d() {
        View view = this.f38907f;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
            view = null;
        }
        view.setAlpha(0.0f);
        TextView textView2 = this.f38906e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
            textView2 = null;
        }
        textView2.setAlpha(0.0f);
        TextView textView3 = this.f38905d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        } else {
            textView = textView3;
        }
        textView.setTranslationY(0.0f);
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.ViewGroup m27616a(int r6) {
        /*
            r5 = this;
            com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView r0 = r5.f38903b
            r1 = 0
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = "recycleView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x000c:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == 0) goto L_0x003d
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r2 = r0.findFirstVisibleItemPosition()
            int r3 = r0.findLastVisibleItemPosition()
            r4 = 0
            if (r2 > r6) goto L_0x0022
            if (r6 > r3) goto L_0x0022
            r4 = 1
        L_0x0022:
            if (r4 == 0) goto L_0x003c
            android.view.View r6 = r0.findViewByPosition(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            if (r6 != 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r0 = 2131429244(0x7f0b077c, float:1.8480155E38)
            android.view.View r0 = r6.findViewById(r0)
            r1 = r0
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L_0x0037:
            if (r1 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r6 = r1
        L_0x003b:
            return r6
        L_0x003c:
            return r1
        L_0x003d:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillViewV2.m27616a(int):android.view.ViewGroup");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final BillItemView<?> m27622b(int i) {
        ViewGroup a;
        int childCount;
        TextView textView = this.f38906e;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
            textView = null;
        }
        CharSequence text = textView.getText();
        int i2 = 0;
        if (!(text == null || text.length() == 0) && (a = m27616a(i)) != null && (childCount = a.getChildCount()) >= 0) {
            while (true) {
                int i3 = i2 + 1;
                View childAt = a.getChildAt(i2);
                if (childAt instanceof BillAddressItemViewV2) {
                    return (BillItemView) childAt;
                }
                if (i2 == childCount) {
                    break;
                }
                i2 = i3;
            }
        }
        return null;
    }

    /* renamed from: c */
    private final BillItemView<?> m27625c(int i) {
        if (i < 0) {
            return null;
        }
        BillFocusHelper.Companion.setNeedFocusIndex(i);
        ViewGroup a = m27616a(i);
        if (a != null) {
            int i2 = 0;
            int childCount = a.getChildCount();
            if (childCount >= 0) {
                while (true) {
                    int i3 = i2 + 1;
                    View childAt = a.getChildAt(i2);
                    if (childAt instanceof BillItemView) {
                        return (BillItemView) childAt;
                    }
                    if (i2 == childCount) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    private final void m27628d(int i) {
        BillItemView<?> c = m27625c(i);
        if (c != null) {
            c.needFocusContent();
        }
    }

    public void autoClickItem(ComponentModel componentModel, int i, Bundle bundle) {
        BillItemView<?> c = m27625c(componentModel == null ? -1 : componentModel.getSectionIndex());
        if (c != null) {
            c.performAutoClick(i, bundle);
        } else if (componentModel != null) {
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            new ItemViewCommonLogicV2(scopeContext).onItemClick(componentModel, Integer.valueOf(i), bundle, (Function1<? super ScopeContext, Unit>) null);
        }
    }

    public void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        Intrinsics.checkNotNullParameter(topGunAbnormalViewModel, "model");
        TopGunAbnormalView topGunAbnormalView = this.f38902a;
        NovaRecyclerView novaRecyclerView = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(0);
        TopGunAbnormalView topGunAbnormalView2 = this.f38902a;
        if (topGunAbnormalView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView2 = null;
        }
        topGunAbnormalView2.show(topGunAbnormalViewModel);
        BillPayLayout billPayLayout = this.f38910i;
        if (billPayLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payLayout");
            billPayLayout = null;
        }
        billPayLayout.setVisibility(8);
        NovaRecyclerView novaRecyclerView2 = this.f38903b;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        novaRecyclerView.setVisibility(8);
        m27627d();
    }

    public void hideAbnormalView() {
        LogUtil.m29100d("CustomerBillView", "hideAbnormalView");
        TopGunAbnormalView topGunAbnormalView = this.f38902a;
        NovaRecyclerView novaRecyclerView = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(8);
        NovaRecyclerView novaRecyclerView2 = this.f38903b;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        novaRecyclerView.setVisibility(0);
    }
}
