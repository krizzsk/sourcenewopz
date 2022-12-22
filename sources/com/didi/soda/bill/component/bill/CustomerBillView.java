package com.didi.soda.bill.component.bill;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.bill.binder.CustomerBillBinder;
import com.didi.soda.bill.binder.CustomerDisclaimerBinder;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.BillFocusHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.BillAddressItemView;
import com.didi.soda.bill.view.item.logic.CartCouponAnimHelper;
import com.didi.soda.bill.view.item.logic.DefaultItemViewCommonLogic;
import com.didi.soda.bill.widgets.CustomerBillRecommendTipsView;
import com.didi.soda.bill.widgets.notify.DefaultNotifyView;
import com.didi.soda.bill.widgets.notify.NotifyLayout;
import com.didi.soda.customer.component.feed.decorator.CustomerSimpleDecorator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 V2\u00020\u0001:\u0002VWB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0016\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010)\u001a\u00020\nH\u0002J\u0016\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010+\u001a\u00020\nH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010+\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\nH\u0002J\u0012\u0010/\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u00100\u001a\u000201H\u0014J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001fH\u0016J\u0018\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020-H\u0014J\b\u0010=\u001a\u00020\u001fH\u0002J\b\u0010>\u001a\u00020\u001fH\u0014J\b\u0010?\u001a\u00020\u001fH\u0002J\u0018\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020\u001fH\u0016J\b\u0010D\u001a\u00020\u001fH\u0014J\b\u0010E\u001a\u00020\u001fH\u0002J\u0012\u0010F\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010G\u001a\u00020\u001f2\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020KH\u0016J\u001a\u0010L\u001a\u00020\u001f2\b\u0010M\u001a\u0004\u0018\u00010\u00102\b\u0010N\u001a\u0004\u0018\u00010\u0010J\u0012\u0010O\u001a\u00020\u001f2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020SH\u0016J\b\u0010T\u001a\u00020\u001fH\u0016J\b\u0010U\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006X"}, mo175978d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillView;", "Lcom/didi/soda/bill/component/Contract$AbsBillView;", "()V", "abnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "addressIcon", "Landroid/view/View;", "addressName", "Landroid/widget/TextView;", "addressViewIndex", "", "backView", "confirmBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "confirmBtnLayout", "lastReminderContent", "", "noticeLayout", "Lcom/didi/soda/bill/widgets/notify/NotifyLayout;", "notifyView", "Lcom/didi/soda/bill/widgets/notify/DefaultNotifyView;", "recycleView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "rightBottomText", "rightTopText", "tipsMeasureRunnable", "Ljava/lang/Runnable;", "tipsView", "Lcom/didi/soda/bill/widgets/CustomerBillRecommendTipsView;", "titleView", "anchorBeforePosition", "", "content", "autoClickItem", "model", "Lcom/didi/soda/bill/model/ComponentModel;", "type", "bundle", "Landroid/os/Bundle;", "findAddressView", "Lcom/didi/soda/bill/view/BillItemView;", "addressIndex", "findFirstItemView", "sectionIndex", "findSectionItemView", "Landroid/view/ViewGroup;", "focusBillItemView", "focusItem", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getItemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "context", "Landroid/content/Context;", "getPayButtonCallback", "Lcom/didi/soda/bill/component/bill/CustomerBillView$PayButtonCallback;", "hideAbnormalView", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "initConfirmBtn", "initItemBinders", "initView", "loadNotify", "shopId", "cartId", "onCreate", "onDestroy", "resetAddressTitle", "setAddressData", "setAddressName", "name", "setPayPrice", "billEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "setRightText", "top", "bottom", "setTipsContent", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "showAbnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalViewModel;", "showNotice", "updateCouponIcon", "Companion", "PayButtonCallback", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillView.kt */
public final class CustomerBillView extends Contract.AbsBillView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CustomerBillView";

    /* renamed from: a */
    private TopGunAbnormalView f38886a;

    /* renamed from: b */
    private NovaRecyclerView f38887b;

    /* renamed from: c */
    private View f38888c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f38889d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f38890e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f38891f;

    /* renamed from: g */
    private NotifyLayout f38892g;

    /* renamed from: h */
    private DefaultNotifyView f38893h;

    /* renamed from: i */
    private View f38894i;

    /* renamed from: j */
    private RFMainButton f38895j;

    /* renamed from: k */
    private TextView f38896k;

    /* renamed from: l */
    private TextView f38897l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public CustomerBillRecommendTipsView f38898m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f38899n = -1;

    /* renamed from: o */
    private String f38900o;

    /* renamed from: p */
    private Runnable f38901p;

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillView$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerBillView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f38887b;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_bill_view, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_bill_abnormal_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.c…tomer_bill_abnormal_view)");
        this.f38886a = (TopGunAbnormalView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_custom_bill_rv_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.c…omer_custom_bill_rv_view)");
        this.f38887b = (NovaRecyclerView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_iv_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.customer_iv_page_back)");
        this.f38888c = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_tv_title_label);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.customer_tv_title_label)");
        this.f38889d = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_iv_page_opt_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.customer_iv_page_opt_icon)");
        this.f38891f = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_tv_page_opt_label);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.customer_tv_page_opt_label)");
        this.f38890e = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_custom_mini_cart_pay_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.c…_mini_cart_pay_container)");
        this.f38894i = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_custom_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.customer_custom_confirm)");
        this.f38895j = (RFMainButton) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_tv_bottom_button_right_top_text);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.c…om_button_right_top_text)");
        this.f38896k = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.c…button_right_bottom_text)");
        this.f38897l = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.noticeLayout);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.noticeLayout)");
        this.f38892g = (NotifyLayout) findViewById11;
        this.f38893h = new DefaultNotifyView();
        NotifyLayout notifyLayout = this.f38892g;
        DefaultNotifyView defaultNotifyView = null;
        if (notifyLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noticeLayout");
            notifyLayout = null;
        }
        DefaultNotifyView defaultNotifyView2 = this.f38893h;
        if (defaultNotifyView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifyView");
        } else {
            defaultNotifyView = defaultNotifyView2;
        }
        notifyLayout.setNotifyHolder(defaultNotifyView);
        View findViewById12 = inflate.findViewById(R.id.customer_bill_address_tips_view);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.c…r_bill_address_tips_view)");
        this.f38898m = (CustomerBillRecommendTipsView) findViewById12;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return inflate;
    }

    public void loadNotify(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        LogUtil.m29104i("CustomerBillView", "loadNotify shopId = " + str + " ,cartId = " + str2);
        DefaultNotifyView defaultNotifyView = this.f38893h;
        if (defaultNotifyView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifyView");
            defaultNotifyView = null;
        }
        defaultNotifyView.requestAlertInfo(str, str2);
    }

    public void showNotice() {
        LogUtil.m29104i("CustomerBillView", "showNotice");
        NotifyLayout notifyLayout = this.f38892g;
        if (notifyLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noticeLayout");
            notifyLayout = null;
        }
        notifyLayout.post(new Runnable() {
            public final void run() {
                CustomerBillView.m27603a(CustomerBillView.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27603a(CustomerBillView customerBillView) {
        Intrinsics.checkNotNullParameter(customerBillView, "this$0");
        NotifyLayout notifyLayout = customerBillView.f38892g;
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
            r2.f38899n = r3
            if (r1 != 0) goto L_0x001e
            r3 = r0
            goto L_0x0027
        L_0x001e:
            java.lang.String r3 = r1.getAddressDisplayName()
            r2.m27607a((java.lang.String) r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0027:
            if (r3 != 0) goto L_0x002c
            r2.m27607a((java.lang.String) r0)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillView.setAddressData(com.didi.soda.bill.model.ComponentModel):void");
    }

    public void setPayPrice(BillInfoEntity billInfoEntity) {
        Intrinsics.checkNotNullParameter(billInfoEntity, "billEntity");
        View view = null;
        ((Contract.AbsBillPresenter) getPresenter()).startTotalPriceAnim(billInfoEntity.getRealPayPriceDisplay(), new CustomerBillView$setPayPrice$1(this, billInfoEntity.getPriceSumOri() <= billInfoEntity.getRealPayPrice() ? null : billInfoEntity.getPriceSumOriDisplay()));
        View view2 = this.f38894i;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtnLayout");
        } else {
            view = view2;
        }
        view.setVisibility(0);
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
            java.lang.String r1 = r5.f38900o
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
            java.lang.String r4 = r5.f38900o
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r4 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r2 = 0
        L_0x004f:
            r4 = 0
            if (r2 == 0) goto L_0x0062
            com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView r0 = r5.f38887b
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
            r5.f38900o = r6
            return
        L_0x0093:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillView.anchorBeforePosition(java.lang.String):void");
    }

    /* renamed from: a */
    private final void m27607a(String str) {
        TextView textView = this.f38890e;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
            textView = null;
        }
        textView.setText(str);
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        registerBinder(new CustomerBillBinder(scopeContext, m27601a(context)));
        registerBinder(new CustomerDisclaimerBinder(R.layout.customer_binder_disclaimer_container));
    }

    /* renamed from: a */
    private final ItemDecorator m27601a(Context context) {
        return new CustomerSimpleDecorator(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7), DisplayUtils.dip2px(context, 10.0f));
    }

    public void onCreate() {
        super.onCreate();
        LogUtil.m29104i("CustomerBillView", NachoLifecycleManager.LIFECYCLE_ON_CREATE);
        m27602a();
    }

    /* renamed from: a */
    private final void m27602a() {
        m27609b();
        NovaRecyclerView novaRecyclerView = this.f38887b;
        NovaRecyclerView novaRecyclerView2 = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.setItemDecorationEnable(true);
        View view = this.f38888c;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerBillView.m27604a(CustomerBillView.this, view);
            }
        });
        BillFocusHelper.Companion.resetFocusStatus();
        float dip2px = (float) DisplayUtils.dip2px(getContext(), 9.0f);
        NovaRecyclerView novaRecyclerView3 = this.f38887b;
        if (novaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView2 = novaRecyclerView3;
        }
        novaRecyclerView2.addOnScrollListener(new CustomerBillView$initView$2(this, dip2px));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27604a(CustomerBillView customerBillView, View view) {
        Intrinsics.checkNotNullParameter(customerBillView, "this$0");
        ((Contract.AbsBillPresenter) customerBillView.getPresenter()).onClickBack();
    }

    /* renamed from: b */
    private final void m27609b() {
        TextView textView = null;
        if (BillWsgTouchHelper.Companion.getInstance().getCreateOrderTouch() != null) {
            RFMainButton rFMainButton = this.f38895j;
            if (rFMainButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
                rFMainButton = null;
            }
            rFMainButton.setOnTouchListener(BillWsgTouchHelper.Companion.getInstance().getCreateOrderTouch());
        }
        RFMainButton rFMainButton2 = this.f38895j;
        if (rFMainButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton2 = null;
        }
        rFMainButton2.setText(getString(R.string.customer_pay));
        RFMainButton rFMainButton3 = this.f38895j;
        if (rFMainButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton3 = null;
        }
        rFMainButton3.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerBillView.m27610b(CustomerBillView.this, view);
            }
        });
        TextView textView2 = this.f38896k;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightTopText");
            textView2 = null;
        }
        textView2.setTextColor(SkinUtil.getMainButtonSideTextColor());
        TextView textView3 = this.f38897l;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBottomText");
        } else {
            textView = textView3;
        }
        textView.setTextColor(SkinUtil.getMainButtonSideTextColor());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27610b(CustomerBillView customerBillView, View view) {
        Intrinsics.checkNotNullParameter(customerBillView, "this$0");
        ((Contract.AbsBillPresenter) customerBillView.getPresenter()).onCreateOrder(customerBillView.getPayButtonCallback());
    }

    public PayButtonCallback getPayButtonCallback() {
        RFMainButton rFMainButton = this.f38895j;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton = null;
        }
        return new PayButtonCallback(rFMainButton, getContext());
    }

    public void focusItem(ComponentModel componentModel) {
        int sectionIndex = componentModel == null ? -1 : componentModel.getSectionIndex();
        if (sectionIndex >= 0) {
            NovaRecyclerView novaRecyclerView = this.f38887b;
            if (novaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                novaRecyclerView = null;
            }
            novaRecyclerView.smoothScrollToPosition(sectionIndex);
            m27615d(sectionIndex);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m27612c() {
        String string = getScopeContext().getBundle().getString("cart_id", "");
        NovaRecyclerView novaRecyclerView = this.f38887b;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        CartCouponAnimHelper.showCouponIconAnim(novaRecyclerView, string);
    }

    /* renamed from: d */
    private final void m27614d() {
        View view = this.f38891f;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
            view = null;
        }
        view.setAlpha(0.0f);
        TextView textView2 = this.f38890e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
            textView2 = null;
        }
        textView2.setAlpha(0.0f);
        TextView textView3 = this.f38889d;
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
    private final android.view.ViewGroup m27600a(int r6) {
        /*
            r5 = this;
            com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView r0 = r5.f38887b
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.component.bill.CustomerBillView.m27600a(int):android.view.ViewGroup");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final BillItemView<?> m27608b(int i) {
        ViewGroup a;
        int childCount;
        TextView textView = this.f38890e;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressName");
            textView = null;
        }
        CharSequence text = textView.getText();
        int i2 = 0;
        if (!(text == null || text.length() == 0) && (a = m27600a(i)) != null && (childCount = a.getChildCount()) >= 0) {
            while (true) {
                int i3 = i2 + 1;
                View childAt = a.getChildAt(i2);
                if (childAt instanceof BillAddressItemView) {
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
    private final BillItemView<?> m27611c(int i) {
        if (i < 0) {
            return null;
        }
        BillFocusHelper.Companion.setNeedFocusIndex(i);
        ViewGroup a = m27600a(i);
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
    private final void m27615d(int i) {
        BillItemView<?> c = m27611c(i);
        if (c != null) {
            c.needFocusContent();
        }
    }

    public void autoClickItem(ComponentModel componentModel, int i, Bundle bundle) {
        BillItemView<?> c = m27611c(componentModel == null ? -1 : componentModel.getSectionIndex());
        if (c != null) {
            c.performAutoClick(i, bundle);
        } else if (componentModel != null) {
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            new DefaultItemViewCommonLogic(scopeContext).onItemClick(componentModel, Integer.valueOf(i), bundle, (Function1<? super ScopeContext, Unit>) null);
        }
    }

    public void setTipsContent(AddressEntity addressEntity) {
        this.f38901p = new Runnable(this) {
            public final /* synthetic */ CustomerBillView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CustomerBillView.m27606a(AddressEntity.this, this.f$1);
            }
        };
        getView().post(this.f38901p);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27606a(AddressEntity addressEntity, CustomerBillView customerBillView) {
        Intrinsics.checkNotNullParameter(customerBillView, "this$0");
        CustomerBillRecommendTipsView customerBillRecommendTipsView = null;
        if (addressEntity == null) {
            CustomerBillRecommendTipsView customerBillRecommendTipsView2 = customerBillView.f38898m;
            if (customerBillRecommendTipsView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            } else {
                customerBillRecommendTipsView = customerBillRecommendTipsView2;
            }
            customerBillRecommendTipsView.setVisibility(8);
            return;
        }
        CustomerBillRecommendTipsView customerBillRecommendTipsView3 = customerBillView.f38898m;
        if (customerBillRecommendTipsView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            customerBillRecommendTipsView3 = null;
        }
        customerBillRecommendTipsView3.setVisibility(0);
        BillItemView<?> b = customerBillView.m27608b(customerBillView.f38899n);
        if (b != null) {
            if (b instanceof BillAddressItemView) {
                ((BillAddressItemView) b).setGotoEditListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CustomerBillView.m27613c(CustomerBillView.this, view);
                    }
                });
            }
            Rect rect = new Rect();
            if (b.getGlobalVisibleRect(rect)) {
                CustomerBillRecommendTipsView customerBillRecommendTipsView4 = customerBillView.f38898m;
                if (customerBillRecommendTipsView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                    customerBillRecommendTipsView4 = null;
                }
                customerBillRecommendTipsView4.setHomeTipContent(rect.top, addressEntity, new CustomerBillView$setTipsContent$1$1$2(customerBillView));
                CustomerBillRecommendTipsView customerBillRecommendTipsView5 = customerBillView.f38898m;
                if (customerBillRecommendTipsView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                } else {
                    customerBillRecommendTipsView = customerBillRecommendTipsView5;
                }
                customerBillRecommendTipsView.setOnClickListener(new View.OnClickListener(addressEntity) {
                    public final /* synthetic */ AddressEntity f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        CustomerBillView.m27605a(CustomerBillView.this, this.f$1, view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m27613c(CustomerBillView customerBillView, View view) {
        Intrinsics.checkNotNullParameter(customerBillView, "this$0");
        customerBillView.getView().removeCallbacks(customerBillView.f38901p);
        CustomerBillRecommendTipsView customerBillRecommendTipsView = customerBillView.f38898m;
        if (customerBillRecommendTipsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            customerBillRecommendTipsView = null;
        }
        customerBillRecommendTipsView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27605a(CustomerBillView customerBillView, AddressEntity addressEntity, View view) {
        Intrinsics.checkNotNullParameter(customerBillView, "this$0");
        ((Contract.AbsBillPresenter) customerBillView.getPresenter()).onSetRecAddress(addressEntity, 2);
        CustomerBillRecommendTipsView customerBillRecommendTipsView = customerBillView.f38898m;
        if (customerBillRecommendTipsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            customerBillRecommendTipsView = null;
        }
        customerBillRecommendTipsView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getView().removeCallbacks(this.f38901p);
        super.onDestroy();
    }

    public void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        Intrinsics.checkNotNullParameter(topGunAbnormalViewModel, "model");
        TopGunAbnormalView topGunAbnormalView = this.f38886a;
        NovaRecyclerView novaRecyclerView = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(0);
        TopGunAbnormalView topGunAbnormalView2 = this.f38886a;
        if (topGunAbnormalView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView2 = null;
        }
        topGunAbnormalView2.show(topGunAbnormalViewModel);
        View view = this.f38894i;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtnLayout");
            view = null;
        }
        view.setVisibility(8);
        NovaRecyclerView novaRecyclerView2 = this.f38887b;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        novaRecyclerView.setVisibility(8);
        m27614d();
    }

    public void hideAbnormalView() {
        LogUtil.m29100d("CustomerBillView", "hideAbnormalView");
        TopGunAbnormalView topGunAbnormalView = this.f38886a;
        NovaRecyclerView novaRecyclerView = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(8);
        NovaRecyclerView novaRecyclerView2 = this.f38887b;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        novaRecyclerView.setVisibility(0);
    }

    @Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillView$PayButtonCallback;", "Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "payBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "context", "Landroid/content/Context;", "(Lcom/didi/rfusion/widget/button/RFMainButton;Landroid/content/Context;)V", "mContext", "Ljava/lang/ref/WeakReference;", "mPayBtn", "fail", "", "businessId", "", "hideLoading", "isLoading", "", "loading", "setRightTextVisibility", "visibility", "", "success", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerBillView.kt */
    public static final class PayButtonCallback implements ICustomerPayManager.CartPayButtonCallback {
        private final WeakReference<Context> mContext;
        private final WeakReference<RFMainButton> mPayBtn;

        public PayButtonCallback(RFMainButton rFMainButton, Context context) {
            this.mPayBtn = new WeakReference<>(rFMainButton);
            this.mContext = new WeakReference<>(context);
        }

        public void fail(String str) {
            LogUtil.m29104i("CustomerBillView", Intrinsics.stringPlus("PayButtonCallback fail businessId = ", str));
            hideLoading();
        }

        public void loading() {
            LogUtil.m29104i("CustomerBillView", "PayButtonCallback loading");
            if (this.mPayBtn.get() != null) {
                Object obj = this.mPayBtn.get();
                Intrinsics.checkNotNull(obj);
                ((RFMainButton) obj).setLoading(true);
                setRightTextVisibility(4);
            }
        }

        public boolean isLoading() {
            LogUtil.m29104i("CustomerBillView", "PayButtonCallback isLoading");
            RFMainButton rFMainButton = (RFMainButton) this.mPayBtn.get();
            if (rFMainButton == null) {
                return false;
            }
            return rFMainButton.isLoading();
        }

        public void hideLoading() {
            RFMainButton rFMainButton;
            LogUtil.m29104i("CustomerBillView", "PayButtonCallback hideLoading");
            DialogUtil.hideBlockDialog();
            if (this.mPayBtn.get() != null && (rFMainButton = (RFMainButton) this.mPayBtn.get()) != null) {
                rFMainButton.setLoading(false);
                setRightTextVisibility(0);
                rFMainButton.setVisibility(0);
                if (this.mContext.get() != null) {
                    Object obj = this.mContext.get();
                    Intrinsics.checkNotNull(obj);
                    rFMainButton.setText(((Context) obj).getResources().getString(R.string.customer_pay));
                }
            }
        }

        public void success(String str) {
            RFMainButton rFMainButton;
            LogUtil.m29104i("CustomerBillView", Intrinsics.stringPlus("PayButtonCallback success ", str));
            DialogUtil.hideBlockDialog();
            if (this.mPayBtn.get() != null && (rFMainButton = (RFMainButton) this.mPayBtn.get()) != null) {
                rFMainButton.setLoading(false);
                rFMainButton.setVisibility(0);
                if (this.mContext.get() != null) {
                    Object obj = this.mContext.get();
                    Intrinsics.checkNotNull(obj);
                    rFMainButton.setText(((Context) obj).getResources().getString(R.string.customer_name_pay_success));
                }
            }
        }

        public final void setRightTextVisibility(int i) {
            CharSequence charSequence;
            RFMainButton rFMainButton = (RFMainButton) this.mPayBtn.get();
            CharSequence charSequence2 = null;
            TextView textView = rFMainButton == null ? null : (TextView) rFMainButton.findViewById(R.id.customer_tv_bottom_button_right_top_text);
            RFMainButton rFMainButton2 = (RFMainButton) this.mPayBtn.get();
            TextView textView2 = rFMainButton2 == null ? null : (TextView) rFMainButton2.findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
            if (textView == null) {
                charSequence = null;
            } else {
                charSequence = textView.getText();
            }
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setVisibility(i);
            }
            if (textView2 != null) {
                charSequence2 = textView2.getText();
            }
            if (!TextUtils.isEmpty(charSequence2) && textView2 != null) {
                textView2.setVisibility(i);
            }
        }
    }

    public final void setRightText(String str, String str2) {
        CharSequence charSequence = str;
        TextView textView = null;
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView2 = this.f38896k;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightTopText");
                textView2 = null;
            }
            textView2.setVisibility(8);
        } else {
            TextView textView3 = this.f38896k;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightTopText");
                textView3 = null;
            }
            textView3.setText(charSequence);
            TextView textView4 = this.f38896k;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightTopText");
                textView4 = null;
            }
            textView4.setVisibility(0);
        }
        CharSequence charSequence2 = str2;
        if (TextUtils.isEmpty(charSequence2)) {
            TextView textView5 = this.f38897l;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightBottomText");
            } else {
                textView = textView5;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView6 = this.f38897l;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBottomText");
            textView6 = null;
        }
        textView6.setAlpha(0.5f);
        TextView textView7 = this.f38897l;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBottomText");
            textView7 = null;
        }
        textView7.setText(charSequence2);
        TextView textView8 = this.f38897l;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBottomText");
            textView8 = null;
        }
        TextView textView9 = this.f38897l;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBottomText");
            textView9 = null;
        }
        textView8.setPaintFlags(textView9.getPaintFlags() | 16);
        TextView textView10 = this.f38897l;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBottomText");
        } else {
            textView = textView10;
        }
        textView.setVisibility(0);
    }
}
