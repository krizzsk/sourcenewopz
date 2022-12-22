package com.didi.soda.globalcart.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ILive;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.BillCartItemModel;
import com.didi.soda.bill.model.datamodel.BillItemsInfoModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.business.GroceryHelper;
import com.didi.soda.cart.listener.OnCartItemOperateListener;
import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.globalcart.binder.GlobalCartItemBinder;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J(\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001aH\u0016J\u0012\u0010)\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020.J(\u0010/\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020&2\u0006\u0010'\u001a\u000202H\u0002R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000¨\u00064"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/BillItemsInfoItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "isNewVersion", "", "(Landroid/content/Context;Z)V", "arrowIcon", "Lcom/didi/soda/customer/widget/text/IconTextView;", "businessArea", "Landroid/view/View;", "businessTv", "Landroid/widget/TextView;", "collapsedContainer", "Lcom/didi/soda/globalcart/view/VerticalCollapseView;", "deleteBtn", "dishContainer", "Landroid/widget/LinearLayout;", "expandView", "Lcom/didi/soda/globalcart/view/GlobalCartExpandView;", "listener", "Lcom/didi/soda/cart/listener/OnCartItemOperateListener;", "style", "Lcom/didi/soda/globalcart/view/Style;", "bindData", "", "itemView", "Lcom/didi/soda/globalcart/view/CartDishItemView;", "item", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel;", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "goToSKUPage", "shopId", "", "cartId", "source", "", "model", "initView", "onDestroy", "live", "Lcom/didi/app/nova/skeleton/ILive;", "setData", "setOnCartItemOperateListener", "Lcom/didi/soda/globalcart/binder/GlobalCartItemBinder;", "showExpandView", "firstHideIndex", "dishAmount", "Lcom/didi/soda/bill/model/datamodel/BillItemsInfoModel;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemsInfoItemView.kt */
public final class BillItemsInfoItemView extends BillItemView<ItemViewCommonLogic> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float ITEM_MARGIN = 9.0f;
    public static final float MARGIN_BEFORE_ARROW_ICON = 4.0f;
    public static final float MIN_MARGIN_BEFORE_DELETE = 12.0f;
    public static final int TYPE_DISH = 1;
    public static final int TYPE_GIFT = 2;

    /* renamed from: a */
    private TextView f42305a;

    /* renamed from: b */
    private IconTextView f42306b;

    /* renamed from: c */
    private IconTextView f42307c;

    /* renamed from: d */
    private LinearLayout f42308d;

    /* renamed from: e */
    private GlobalCartExpandView f42309e;

    /* renamed from: f */
    private View f42310f;

    /* renamed from: g */
    private VerticalCollapseView f42311g;

    /* renamed from: h */
    private OnCartItemOperateListener f42312h;

    /* renamed from: i */
    private Style f42313i;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillItemsInfoItemView(Context context, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillItemsInfoItemView(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }

    public void initView() {
        Style style;
        if (isNewVersion()) {
            style = new C13892a();
        } else {
            style = new C13893b();
        }
        this.f42313i = style;
        Context context = getContext();
        Style style2 = this.f42313i;
        Style style3 = null;
        if (style2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("style");
            style2 = null;
        }
        View inflate = View.inflate(context, style2.mo106450b(), this);
        View findViewById = inflate.findViewById(R.id.customer_tv_cart_business_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_cart_business_name)");
        this.f42305a = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_iv_cart_business_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_cart_business_arrow)");
        this.f42306b = (IconTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_iv_cart_business_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…_iv_cart_business_delete)");
        this.f42307c = (IconTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_ll_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_ll_cart_container)");
        this.f42308d = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_custom_cart_expand_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…_custom_cart_expand_view)");
        this.f42309e = (GlobalCartExpandView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.business_area);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.business_area)");
        this.f42310f = findViewById6;
        this.f42311g = (VerticalCollapseView) inflate.findViewById(R.id.customer_scroll_container);
        Style style4 = this.f42313i;
        if (style4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("style");
        } else {
            style3 = style4;
        }
        style3.mo106449a(this);
    }

    public final void setOnCartItemOperateListener(GlobalCartItemBinder globalCartItemBinder) {
        Intrinsics.checkNotNullParameter(globalCartItemBinder, "listener");
        this.f42312h = globalCartItemBinder;
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r25) {
        /*
            r24 = this;
            r6 = r24
            r7 = r25
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.didi.soda.bill.model.ComponentDataModel r0 = r25.getData()
            if (r0 != 0) goto L_0x0011
            r9 = 0
            goto L_0x0016
        L_0x0011:
            com.didi.soda.bill.model.datamodel.BillItemsInfoModel r0 = r0.getItemsInfoModel()
            r9 = r0
        L_0x0016:
            android.widget.TextView r0 = r6.f42305a
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = "businessTv"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L_0x0020:
            if (r9 != 0) goto L_0x0024
            r1 = 0
            goto L_0x0028
        L_0x0024:
            java.lang.String r1 = r9.getShopName()
        L_0x0028:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = r25.getSourcePage()
            java.lang.String r1 = "arrowIcon"
            java.lang.String r10 = "deleteBtn"
            r11 = 8
            r12 = 2
            r13 = 0
            r14 = 1
            if (r0 != r14) goto L_0x0053
            com.didi.soda.customer.widget.text.IconTextView r0 = r6.f42306b
            if (r0 != 0) goto L_0x0044
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = 0
        L_0x0044:
            r0.setVisibility(r13)
            com.didi.soda.customer.widget.text.IconTextView r0 = r6.f42307c
            if (r0 != 0) goto L_0x004f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r0 = 0
        L_0x004f:
            r0.setVisibility(r13)
            goto L_0x006f
        L_0x0053:
            int r0 = r25.getSourcePage()
            if (r0 != r12) goto L_0x006f
            com.didi.soda.customer.widget.text.IconTextView r0 = r6.f42306b
            if (r0 != 0) goto L_0x0061
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = 0
        L_0x0061:
            r0.setVisibility(r11)
            com.didi.soda.customer.widget.text.IconTextView r0 = r6.f42307c
            if (r0 != 0) goto L_0x006c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r0 = 0
        L_0x006c:
            r0.setVisibility(r11)
        L_0x006f:
            if (r9 != 0) goto L_0x0073
            r15 = 0
            goto L_0x0078
        L_0x0073:
            java.lang.String r0 = r9.getShopId()
            r15 = r0
        L_0x0078:
            if (r9 != 0) goto L_0x007c
            r5 = 0
            goto L_0x0081
        L_0x007c:
            java.util.ArrayList r0 = r9.getItems()
            r5 = r0
        L_0x0081:
            if (r9 != 0) goto L_0x0085
            r4 = 0
            goto L_0x008e
        L_0x0085:
            int r0 = r9.getBusinessType()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4 = r0
        L_0x008e:
            if (r9 != 0) goto L_0x0093
            r16 = 0
            goto L_0x0099
        L_0x0093:
            java.lang.String r0 = r9.getUrl()
            r16 = r0
        L_0x0099:
            java.lang.String r3 = r25.getCartId()
            r17 = r15
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            if (r17 == 0) goto L_0x00ac
            int r0 = r17.length()
            if (r0 != 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r0 = 0
            goto L_0x00ad
        L_0x00ac:
            r0 = 1
        L_0x00ad:
            if (r0 != 0) goto L_0x00d7
            int r0 = r25.getSourcePage()
            if (r0 != r14) goto L_0x00d7
            android.view.View r0 = r6.f42310f
            if (r0 != 0) goto L_0x00c0
            java.lang.String r0 = "businessArea"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r2 = 0
            goto L_0x00c1
        L_0x00c0:
            r2 = r0
        L_0x00c1:
            com.didi.soda.globalcart.view.-$$Lambda$BillItemsInfoItemView$eVRas4rCbqxYkg4Yf0RzY3TFA8M r1 = new com.didi.soda.globalcart.view.-$$Lambda$BillItemsInfoItemView$eVRas4rCbqxYkg4Yf0RzY3TFA8M
            r0 = r1
            r8 = r1
            r1 = r24
            r13 = r2
            r2 = r15
            r18 = r3
            r12 = r5
            r5 = r16
            r0.<init>(r2, r3, r4, r5)
            r13.setOnClickListener(r8)
            r8 = r18
            goto L_0x00d9
        L_0x00d7:
            r12 = r5
            r8 = r3
        L_0x00d9:
            r13 = r8
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r13 == 0) goto L_0x00e7
            int r0 = r13.length()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r0 = 0
            goto L_0x00e8
        L_0x00e7:
            r0 = 1
        L_0x00e8:
            if (r0 != 0) goto L_0x00fa
            com.didi.soda.customer.widget.text.IconTextView r0 = r6.f42307c
            if (r0 != 0) goto L_0x00f2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r0 = 0
        L_0x00f2:
            com.didi.soda.globalcart.view.-$$Lambda$BillItemsInfoItemView$M-kdGXHHU525hxelJr4XOtORCCk r1 = new com.didi.soda.globalcart.view.-$$Lambda$BillItemsInfoItemView$M-kdGXHHU525hxelJr4XOtORCCk
            r1.<init>(r8)
            r0.setOnClickListener(r1)
        L_0x00fa:
            com.didi.soda.globalcart.view.GlobalCartExpandView r0 = r6.f42309e
            if (r0 != 0) goto L_0x0104
            java.lang.String r0 = "expandView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L_0x0104:
            r0.setVisibility(r11)
            r0 = -1
            java.lang.String r10 = "dishContainer"
            java.lang.String r11 = "style"
            if (r12 != 0) goto L_0x0110
            goto L_0x0119
        L_0x0110:
            r5 = r12
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.ranges.IntRange r1 = kotlin.collections.CollectionsKt.getIndices(r5)
            if (r1 != 0) goto L_0x011c
        L_0x0119:
            r13 = 0
            goto L_0x0213
        L_0x011c:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r16 = r1.iterator()
            r1 = 0
            r18 = 0
        L_0x0125:
            boolean r2 = r16.hasNext()
            if (r2 == 0) goto L_0x0211
            r2 = r16
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            java.lang.Object r3 = r12.get(r2)
            java.lang.String r4 = "dishItems[index]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r5 = r3
            com.didi.soda.bill.model.datamodel.BillCartItemModel r5 = (com.didi.soda.bill.model.datamodel.BillCartItemModel) r5
            int r3 = r5.getMduType()
            java.lang.String r4 = "context"
            if (r3 == r14) goto L_0x0163
            r14 = 2
            if (r3 == r14) goto L_0x014c
        L_0x014a:
            r14 = 1
            goto L_0x0125
        L_0x014c:
            com.didi.soda.globalcart.view.CartGiftDishItemView r2 = new com.didi.soda.globalcart.view.CartGiftDishItemView
            android.content.Context r3 = r24.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r24.isNewVersion()
            r2.<init>(r3, r4)
            com.didi.soda.globalcart.view.CartDishItemView r2 = (com.didi.soda.globalcart.view.CartDishItemView) r2
            r14 = r0
            r20 = r1
            r4 = r2
            goto L_0x018e
        L_0x0163:
            com.didi.soda.globalcart.view.CartDishItemView r3 = new com.didi.soda.globalcart.view.CartDishItemView
            android.content.Context r14 = r24.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r4)
            boolean r4 = r24.isNewVersion()
            r3.<init>(r14, r4)
            r4 = 2131231973(0x7f0804e5, float:1.8080042E38)
            r3.setBackgroundResource(r4)
            int r4 = r1 + 1
            com.didi.soda.globalcart.view.Style r14 = r6.f42313i
            if (r14 != 0) goto L_0x0183
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r14 = 0
        L_0x0183:
            int r14 = r14.mo106447a()
            if (r1 != r14) goto L_0x018a
            r0 = r2
        L_0x018a:
            r14 = r0
            r20 = r4
            r4 = r3
        L_0x018e:
            r6.m29814a((com.didi.soda.globalcart.view.CartDishItemView) r4, (com.didi.soda.bill.model.datamodel.BillCartItemModel) r5, (com.didi.soda.bill.model.ComponentModel) r7)
            android.widget.LinearLayout r0 = r6.f42308d
            if (r0 != 0) goto L_0x0199
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r0 = 0
        L_0x0199:
            r1 = r4
            android.view.View r1 = (android.view.View) r1
            r0.addView(r1)
            int r0 = r25.getSourcePage()
            r3 = 2
            if (r0 != r3) goto L_0x01e3
            if (r17 == 0) goto L_0x01b1
            int r0 = r17.length()
            if (r0 != 0) goto L_0x01af
            goto L_0x01b1
        L_0x01af:
            r0 = 0
            goto L_0x01b2
        L_0x01b1:
            r0 = 1
        L_0x01b2:
            if (r0 != 0) goto L_0x01e3
            if (r13 == 0) goto L_0x01bf
            int r0 = r13.length()
            if (r0 != 0) goto L_0x01bd
            goto L_0x01bf
        L_0x01bd:
            r0 = 0
            goto L_0x01c0
        L_0x01bf:
            r0 = 1
        L_0x01c0:
            if (r0 != 0) goto L_0x01e3
            int r0 = r5.getMduType()
            r1 = 1
            if (r0 != r1) goto L_0x01e3
            com.didi.soda.globalcart.view.-$$Lambda$BillItemsInfoItemView$kB9LRKGJRCGTsSWVyMcHYtMPSWU r2 = new com.didi.soda.globalcart.view.-$$Lambda$BillItemsInfoItemView$kB9LRKGJRCGTsSWVyMcHYtMPSWU
            r0 = r2
            r1 = r24
            r19 = r12
            r12 = r2
            r2 = r15
            r21 = 2
            r3 = r8
            r22 = r13
            r13 = r4
            r4 = r25
            r23 = r5
            r0.<init>(r2, r3, r4, r5)
            r13.setOnClickListener(r12)
            goto L_0x01ec
        L_0x01e3:
            r23 = r5
            r19 = r12
            r22 = r13
            r21 = 2
            r13 = r4
        L_0x01ec:
            int r0 = r23.getMduType()
            r1 = 1
            if (r0 != r1) goto L_0x0200
            com.didi.soda.globalcart.view.BillItemsInfoItemView$setData$3$2 r0 = new com.didi.soda.globalcart.view.BillItemsInfoItemView$setData$3$2
            r3 = r23
            r0.<init>(r7, r8, r15, r3)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r13.setRuleClickCallBack(r0)
            goto L_0x0202
        L_0x0200:
            r3 = r23
        L_0x0202:
            int r0 = r3.getAmount()
            int r18 = r18 + r0
            r0 = r14
            r12 = r19
            r1 = r20
            r13 = r22
            goto L_0x014a
        L_0x0211:
            r13 = r18
        L_0x0213:
            if (r0 < 0) goto L_0x0222
            if (r9 == 0) goto L_0x0222
            android.widget.LinearLayout r1 = r6.f42308d
            if (r1 != 0) goto L_0x021f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r1 = 0
        L_0x021f:
            r6.m29807a((android.widget.LinearLayout) r1, (int) r0, (int) r13, (com.didi.soda.bill.model.datamodel.BillItemsInfoModel) r9)
        L_0x0222:
            com.didi.soda.globalcart.view.Style r0 = r6.f42313i
            if (r0 != 0) goto L_0x022a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r0 = 0
        L_0x022a:
            com.didi.soda.bill.view.item.logic.ItemViewAbsLogic r1 = r24.getLogic()
            com.didi.soda.bill.view.item.logic.ItemViewCommonLogic r1 = (com.didi.soda.bill.view.item.logic.ItemViewCommonLogic) r1
            if (r1 != 0) goto L_0x0234
            r8 = 0
            goto L_0x0238
        L_0x0234:
            com.didi.app.nova.skeleton.ScopeContext r8 = r1.getScopeContext()
        L_0x0238:
            r0.mo106448a(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.globalcart.view.BillItemsInfoItemView.setData(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29813a(BillItemsInfoItemView billItemsInfoItemView, String str, String str2, Integer num, String str3, View view) {
        Intrinsics.checkNotNullParameter(billItemsInfoItemView, "this$0");
        OnCartItemOperateListener onCartItemOperateListener = billItemsInfoItemView.f42312h;
        if (onCartItemOperateListener != null) {
            if (str2 == null) {
                str2 = "";
            }
            onCartItemOperateListener.onCartItemShopClick(str, str2, num, str3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29811a(BillItemsInfoItemView billItemsInfoItemView, String str, View view) {
        Intrinsics.checkNotNullParameter(billItemsInfoItemView, "this$0");
        OnCartItemOperateListener onCartItemOperateListener = billItemsInfoItemView.f42312h;
        if (onCartItemOperateListener != null) {
            onCartItemOperateListener.onCartItemRemoveClick(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29812a(BillItemsInfoItemView billItemsInfoItemView, String str, String str2, ComponentModel componentModel, BillCartItemModel billCartItemModel, View view) {
        Intrinsics.checkNotNullParameter(billItemsInfoItemView, "this$0");
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Intrinsics.checkNotNullParameter(billCartItemModel, "$item");
        billItemsInfoItemView.m29815a(str, str2, componentModel.getSource(), billCartItemModel);
    }

    /* renamed from: a */
    private final void m29807a(LinearLayout linearLayout, int i, int i2, BillItemsInfoModel billItemsInfoModel) {
        GlobalCartExpandView globalCartExpandView = this.f42309e;
        ViewGroup.LayoutParams layoutParams = null;
        if (globalCartExpandView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandView");
            globalCartExpandView = null;
        }
        globalCartExpandView.setNum(i2, isNewVersion());
        GlobalCartExpandView globalCartExpandView2 = this.f42309e;
        if (globalCartExpandView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandView");
            globalCartExpandView2 = null;
        }
        globalCartExpandView2.setVisibility(0);
        GlobalCartExpandView globalCartExpandView3 = this.f42309e;
        if (globalCartExpandView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandView");
            globalCartExpandView3 = null;
        }
        globalCartExpandView3.setOnClickListener(new View.OnClickListener(this, linearLayout, i) {
            public final /* synthetic */ BillItemsInfoItemView f$1;
            public final /* synthetic */ LinearLayout f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(View view) {
                BillItemsInfoItemView.m29809a(BillItemsInfoModel.this, this.f$1, this.f$2, this.f$3, view);
            }
        });
        VerticalCollapseView verticalCollapseView = this.f42311g;
        if (verticalCollapseView != null) {
            verticalCollapseView.setStatusListener(new BillItemsInfoItemView$showExpandView$2(i, linearLayout, billItemsInfoModel));
        }
        if (billItemsInfoModel.isExpand()) {
            GlobalCartExpandView globalCartExpandView4 = this.f42309e;
            if (globalCartExpandView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandView");
                globalCartExpandView4 = null;
            }
            globalCartExpandView4.showAll();
            int childCount = linearLayout.getChildCount();
            if (i < childCount) {
                while (true) {
                    int i3 = i + 1;
                    View childAt = linearLayout.getChildAt(i);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                    }
                    if (i3 >= childCount) {
                        break;
                    }
                    i = i3;
                }
            }
        } else {
            GlobalCartExpandView globalCartExpandView5 = this.f42309e;
            if (globalCartExpandView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandView");
                globalCartExpandView5 = null;
            }
            globalCartExpandView5.putAway();
            int childCount2 = linearLayout.getChildCount();
            if (i < childCount2) {
                while (true) {
                    int i4 = i + 1;
                    View childAt2 = linearLayout.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setVisibility(8);
                    }
                    if (i4 >= childCount2) {
                        break;
                    }
                    i = i4;
                }
            }
        }
        VerticalCollapseView verticalCollapseView2 = this.f42311g;
        if (verticalCollapseView2 != null) {
            layoutParams = verticalCollapseView2.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        linearLayout.getLayoutParams().height = -2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29809a(BillItemsInfoModel billItemsInfoModel, BillItemsInfoItemView billItemsInfoItemView, LinearLayout linearLayout, int i, View view) {
        int childCount;
        Intrinsics.checkNotNullParameter(billItemsInfoModel, "$model");
        Intrinsics.checkNotNullParameter(billItemsInfoItemView, "this$0");
        Intrinsics.checkNotNullParameter(linearLayout, "$dishContainer");
        if (!ClickUtils.isFastClick()) {
            ViewGroup.LayoutParams layoutParams = null;
            if (billItemsInfoModel.isExpand()) {
                GlobalCartExpandView globalCartExpandView = billItemsInfoItemView.f42309e;
                if (globalCartExpandView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandView");
                    globalCartExpandView = null;
                }
                globalCartExpandView.putAway();
            } else {
                GlobalCartExpandView globalCartExpandView2 = billItemsInfoItemView.f42309e;
                if (globalCartExpandView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandView");
                    globalCartExpandView2 = null;
                }
                globalCartExpandView2.showAll();
            }
            VerticalCollapseView verticalCollapseView = billItemsInfoItemView.f42311g;
            if (verticalCollapseView != null) {
                layoutParams = verticalCollapseView.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.height = linearLayout.getMeasuredHeight();
            }
            if (billItemsInfoModel.getExpandHeight() != 0) {
                billItemsInfoModel.setExpand(!billItemsInfoModel.isExpand());
                if (billItemsInfoModel.isExpand() && i < (childCount = linearLayout.getChildCount())) {
                    while (true) {
                        int i2 = i + 1;
                        View childAt = linearLayout.getChildAt(i);
                        if (childAt != null) {
                            childAt.setVisibility(0);
                        }
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                billItemsInfoItemView.post(new Runnable(billItemsInfoModel) {
                    public final /* synthetic */ BillItemsInfoModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        BillItemsInfoItemView.m29810a(BillItemsInfoItemView.this, this.f$1);
                    }
                });
            } else if (!billItemsInfoModel.isExpand()) {
                billItemsInfoModel.setExpand(!billItemsInfoModel.isExpand());
                billItemsInfoModel.setCollapsedHeight(linearLayout.getMeasuredHeight());
                int childCount2 = linearLayout.getChildCount();
                if (i < childCount2) {
                    while (true) {
                        int i3 = i + 1;
                        View childAt2 = linearLayout.getChildAt(i);
                        if (childAt2 != null) {
                            childAt2.setVisibility(0);
                        }
                        if (i3 >= childCount2) {
                            break;
                        }
                        i = i3;
                    }
                }
                billItemsInfoItemView.post(new Runnable(linearLayout, billItemsInfoItemView) {
                    public final /* synthetic */ LinearLayout f$1;
                    public final /* synthetic */ BillItemsInfoItemView f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        BillItemsInfoItemView.m29808a(BillItemsInfoModel.this, this.f$1, this.f$2);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29808a(BillItemsInfoModel billItemsInfoModel, LinearLayout linearLayout, BillItemsInfoItemView billItemsInfoItemView) {
        Intrinsics.checkNotNullParameter(billItemsInfoModel, "$model");
        Intrinsics.checkNotNullParameter(linearLayout, "$dishContainer");
        Intrinsics.checkNotNullParameter(billItemsInfoItemView, "this$0");
        billItemsInfoModel.setExpandHeight(linearLayout.getMeasuredHeight());
        VerticalCollapseView verticalCollapseView = billItemsInfoItemView.f42311g;
        if (verticalCollapseView != null) {
            verticalCollapseView.smoothChangeStatus(billItemsInfoModel.isExpand(), billItemsInfoModel.getExpandHeight(), billItemsInfoModel.getCollapsedHeight());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29810a(BillItemsInfoItemView billItemsInfoItemView, BillItemsInfoModel billItemsInfoModel) {
        Intrinsics.checkNotNullParameter(billItemsInfoItemView, "this$0");
        Intrinsics.checkNotNullParameter(billItemsInfoModel, "$model");
        VerticalCollapseView verticalCollapseView = billItemsInfoItemView.f42311g;
        if (verticalCollapseView != null) {
            verticalCollapseView.smoothChangeStatus(billItemsInfoModel.isExpand(), billItemsInfoModel.getExpandHeight(), billItemsInfoModel.getCollapsedHeight());
        }
    }

    /* renamed from: a */
    private final void m29814a(CartDishItemView cartDishItemView, BillCartItemModel billCartItemModel, ComponentModel componentModel) {
        String str;
        String str2;
        String str3 = componentModel.getSourcePage() == 1 ? "2" : "";
        if (componentModel.getSourcePage() == 2) {
            str3 = "3";
        }
        String str4 = str3;
        FloatingCartOmegaHelper.Companion companion = FloatingCartOmegaHelper.Companion;
        String cartId = componentModel.getCartId();
        if (cartId == null) {
            str = "";
        } else {
            str = cartId;
        }
        String shopId = componentModel.getShopId();
        if (shopId == null) {
            str2 = "";
        } else {
            str2 = shopId;
        }
        companion.trackItemRealShow(str4, str, str2, String.valueOf(billCartItemModel.getItemId()), String.valueOf(billCartItemModel.getPrice()), String.valueOf(billCartItemModel.getSpecialPrice()), String.valueOf(billCartItemModel.getActivityType()));
        if (componentModel.getSourcePage() == 1) {
            cartDishItemView.bindData(billCartItemModel, componentModel.isBusinessOpen());
        } else {
            cartDishItemView.bindData(billCartItemModel, true);
        }
    }

    /* renamed from: a */
    private final void m29815a(String str, String str2, int i, BillCartItemModel billCartItemModel) {
        String str3 = "";
        if (GroceryHelper.Companion.isGrocery(Integer.valueOf(billCartItemModel.getBusinessType()))) {
            GroceryHelper.Companion.openGrocery(billCartItemModel.getUrl());
        } else {
            DiRouter.request().path(((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsPurchaseNewStyle ? RoutePath.GOODS_PURCHASE_V2 : RoutePath.GOODS_PURCHASE).putString(Const.PageParams.SHOP_ID, str).putString("cart_id", str2).putString(Const.PageParams.ITEM_ID, billCartItemModel.getItemId()).putString(Const.PageParams.ITEM_UNIQ_KEY, billCartItemModel.getItemUniKey()).putInt("from", 4).putSerializable(Const.PageParams.CART_ITEM_ENTITY, BillCartItemModel.Companion.convertEntity(billCartItemModel)).putString(Const.PageParams.BIDATA, str3).putInt("source", i).open();
        }
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String itemId = billCartItemModel.getItemId();
        if (itemId != null) {
            str3 = itemId;
        }
        companion.trackGlobalCartItemCk(str, str2, str3);
    }

    public void onDestroy(ILive iLive) {
        super.onDestroy(iLive);
        VerticalCollapseView verticalCollapseView = this.f42311g;
        if (verticalCollapseView != null) {
            verticalCollapseView.removeAnim();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/BillItemsInfoItemView$Companion;", "", "()V", "ITEM_MARGIN", "", "MARGIN_BEFORE_ARROW_ICON", "MIN_MARGIN_BEFORE_DELETE", "TYPE_DISH", "", "TYPE_GIFT", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillItemsInfoItemView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
