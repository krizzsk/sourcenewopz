package com.didi.soda.bill.view.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.FollowModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.CartCouponAnimHelper;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillFollowItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buyCouponClickArea", "Landroid/view/View;", "buyCouponDes", "Landroid/widget/TextView;", "buyCouponIcon", "Landroid/widget/ImageView;", "buyCouponOriginValue", "buyCouponSelect", "buyCouponSelectMask", "buyCouponTitle", "buyCouponValue", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "setOnceAnim", "cartId", "", "showOrHide", "isShow", "", "showSelectedAnim", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillFollowItemView.kt */
public final class BillFollowItemView extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private View f39203a;

    /* renamed from: b */
    private ImageView f39204b;

    /* renamed from: c */
    private TextView f39205c;

    /* renamed from: d */
    private TextView f39206d;

    /* renamed from: e */
    private TextView f39207e;

    /* renamed from: f */
    private TextView f39208f;

    /* renamed from: g */
    private ImageView f39209g;

    /* renamed from: h */
    private View f39210h;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillFollowItemView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_item_bill_follow, this);
        View findViewById = findViewById(R.id.customer_iv_buy_coupon_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_iv_buy_coupon_icon)");
        this.f39204b = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.customer_cl_buy_coupon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_cl_buy_coupon)");
        this.f39203a = findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_buy_coupon_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_buy_coupon_title)");
        this.f39205c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_buy_coupon_des);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_buy_coupon_des)");
        this.f39206d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_buy_coupon_value);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_tv_buy_coupon_value)");
        this.f39207e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_tv_buy_coupon_save_value);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…tv_buy_coupon_save_value)");
        TextView textView = (TextView) findViewById6;
        this.f39208f = textView;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponOriginValue");
            textView = null;
        }
        textView.getPaint().setFlags(16);
        View findViewById7 = findViewById(R.id.customer_iv_buy_coupon_select);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_iv_buy_coupon_select)");
        this.f39209g = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.customer_iv_buy_coupon_select_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.custom…v_buy_coupon_select_mask)");
        this.f39210h = findViewById8;
        if (findViewById8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponSelectMask");
        } else {
            view = findViewById8;
        }
        view.setAlpha(0.0f);
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.didi.soda.bill.model.ComponentDataModel r0 = r8.getData()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            r0 = r1
            goto L_0x0012
        L_0x000e:
            com.didi.soda.bill.model.datamodel.FollowModel r0 = r0.getFollowModel()
        L_0x0012:
            r2 = 0
            if (r0 != 0) goto L_0x0017
            goto L_0x00cb
        L_0x0017:
            r3 = 1
            r7.m27769a(r3)
            java.lang.String r4 = r8.getCartId()
            r7.setOnceAnim(r4)
            android.widget.TextView r4 = r7.f39205c
            java.lang.String r5 = "buyCouponTitle"
            if (r4 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r4 = r1
        L_0x002c:
            java.lang.CharSequence r6 = r0.getTitle()
            r4.setText(r6)
            android.widget.TextView r4 = r7.f39206d
            if (r4 != 0) goto L_0x003d
            java.lang.String r4 = "buyCouponDes"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r1
        L_0x003d:
            java.lang.String r6 = r0.getBenefitDesc()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            android.widget.TextView r4 = r7.f39207e
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = "buyCouponValue"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r1
        L_0x0050:
            java.lang.String r6 = r0.getPriceDisplay()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            android.widget.TextView r4 = r7.f39208f
            if (r4 != 0) goto L_0x0063
            java.lang.String r4 = "buyCouponOriginValue"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r1
        L_0x0063:
            java.lang.String r6 = r0.getOriPriceDisplay()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            java.lang.String r4 = r0.getUrl()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0088
            android.widget.TextView r4 = r7.f39205c
            if (r4 != 0) goto L_0x0080
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r4 = r1
        L_0x0080:
            com.didi.soda.bill.view.item.-$$Lambda$BillFollowItemView$XKk0GpWoeo2_LR2wkAd-fLzbvcw r5 = new com.didi.soda.bill.view.item.-$$Lambda$BillFollowItemView$XKk0GpWoeo2_LR2wkAd-fLzbvcw
            r5.<init>()
            r4.setOnClickListener(r5)
        L_0x0088:
            boolean r4 = com.didi.soda.bill.view.item.logic.CartCouponAnimHelper.sLastFollowSelect
            if (r4 != 0) goto L_0x0096
            int r4 = r0.isSelected()
            if (r4 != r3) goto L_0x0096
            r7.m27766a()
            goto L_0x00ac
        L_0x0096:
            android.widget.ImageView r4 = r7.f39209g
            if (r4 != 0) goto L_0x00a0
            java.lang.String r4 = "buyCouponSelect"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r1
        L_0x00a0:
            int r5 = r0.isSelected()
            if (r5 != r3) goto L_0x00a8
            r5 = 1
            goto L_0x00a9
        L_0x00a8:
            r5 = 0
        L_0x00a9:
            r4.setSelected(r5)
        L_0x00ac:
            int r4 = r0.isSelected()
            if (r4 != r3) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r3 = 0
        L_0x00b4:
            com.didi.soda.bill.view.item.logic.CartCouponAnimHelper.sLastFollowSelect = r3
            android.view.View r3 = r7.f39203a
            if (r3 != 0) goto L_0x00c0
            java.lang.String r3 = "buyCouponClickArea"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x00c1
        L_0x00c0:
            r1 = r3
        L_0x00c1:
            com.didi.soda.bill.view.item.-$$Lambda$BillFollowItemView$qR1-198AN4OqNN7_9kIARFQZHtA r3 = new com.didi.soda.bill.view.item.-$$Lambda$BillFollowItemView$qR1-198AN4OqNN7_9kIARFQZHtA
            r3.<init>(r0, r8)
            r1.setOnClickListener(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x00cb:
            if (r1 != 0) goto L_0x00d0
            r7.m27769a(r2)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillFollowItemView.setData(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27767a(FollowModel followModel, View view) {
        Intrinsics.checkNotNullParameter(followModel, "$it");
        SchemeHelper.dispatchMsg(followModel.getUrl());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27768a(FollowModel followModel, FollowModel followModel2, ComponentModel componentModel, View view) {
        Intrinsics.checkNotNullParameter(followModel, "$it");
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        if (!ClickUtils.isFastClick()) {
            int i = 1;
            if (followModel.isSelected() == 1) {
                i = 0;
            }
            FollowingInfoEntity entity = followModel2.getEntity();
            if (entity != null) {
                BillOmegaHelper.Companion.trackCouponPackageCK(entity.productId, Integer.valueOf(entity.couponPrice), Integer.valueOf(entity.couponNum), Integer.valueOf(entity.isSelected), componentModel.getCartId(), componentModel.getShopId());
                entity.isSelected = i;
                ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(entity);
            }
        }
    }

    /* renamed from: a */
    private final void m27766a() {
        View view = this.f39210h;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponSelectMask");
            view = null;
        }
        ImageView imageView2 = this.f39209g;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponSelect");
        } else {
            imageView = imageView2;
        }
        CartCouponAnimHelper.showCouponSelectAnim(view, imageView);
    }

    private final void setOnceAnim(String str) {
        ImageView imageView = null;
        if (CartCouponAnimHelper.isCouponIconAnimShow(str)) {
            ImageView imageView2 = this.f39204b;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyCouponIcon");
                imageView2 = null;
            }
            imageView2.setImageResource(R.drawable.customer_skin_ic_buy_coupon_15);
            ImageView imageView3 = this.f39204b;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyCouponIcon");
                imageView3 = null;
            }
            imageView3.setTag((Object) null);
            return;
        }
        ImageView imageView4 = this.f39204b;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponIcon");
            imageView4 = null;
        }
        imageView4.setBackgroundResource(R.drawable.customer_frame_anim_ic_buy_coupon);
        ImageView imageView5 = this.f39204b;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponIcon");
        } else {
            imageView = imageView5;
        }
        imageView.setTag(CartCouponAnimHelper.FOLLOW_TAG);
    }

    /* renamed from: a */
    private final void m27769a(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
