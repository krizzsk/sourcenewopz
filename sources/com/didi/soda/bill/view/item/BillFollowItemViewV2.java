package com.didi.soda.bill.view.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewCompat;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.FollowModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.CustomerRoundDrawable;
import com.didi.soda.customer.widget.business.BillCouponPackTagView;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillFollowItemViewV2;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "billCouponPackCouponIcon", "Landroid/view/View;", "billCouponPackTag", "Lcom/didi/soda/customer/widget/business/BillCouponPackTagView;", "billCouponPackTipsIcon", "billCouponPackTitle", "Landroid/widget/TextView;", "billCouponPriceLayout", "Landroid/widget/LinearLayout;", "billFollowInfoRoot", "buyCouponClickArea", "buyCouponDes", "buyCouponOriginValue", "buyCouponSelect", "Lcom/didi/rfusion/widget/RFIconView;", "buyCouponTitle", "buyCouponValue", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "showOrHide", "isShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillFollowItemViewV2.kt */
public final class BillFollowItemViewV2 extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private View f39211a;

    /* renamed from: b */
    private TextView f39212b;

    /* renamed from: c */
    private TextView f39213c;

    /* renamed from: d */
    private TextView f39214d;

    /* renamed from: e */
    private TextView f39215e;

    /* renamed from: f */
    private RFIconView f39216f;

    /* renamed from: g */
    private View f39217g;

    /* renamed from: h */
    private BillCouponPackTagView f39218h;

    /* renamed from: i */
    private TextView f39219i;

    /* renamed from: j */
    private View f39220j;

    /* renamed from: k */
    private View f39221k;

    /* renamed from: l */
    private LinearLayout f39222l;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillFollowItemViewV2(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_item_bill_follow_v2, this);
        View findViewById = findViewById(R.id.customer_cl_buy_coupon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_cl_buy_coupon)");
        this.f39211a = findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_buy_coupon_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_buy_coupon_title)");
        this.f39212b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_buy_coupon_des);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_buy_coupon_des)");
        this.f39213c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_buy_coupon_value);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_buy_coupon_value)");
        this.f39214d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_buy_coupon_save_value);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…tv_buy_coupon_save_value)");
        TextView textView = (TextView) findViewById5;
        this.f39215e = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponOriginValue");
            textView = null;
        }
        textView.getPaint().setFlags(16);
        View findViewById6 = findViewById(R.id.customer_iv_buy_coupon_select);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_iv_buy_coupon_select)");
        this.f39216f = (RFIconView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_bill_follow_info_root_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…llow_info_root_container)");
        this.f39217g = findViewById7;
        View findViewById8 = findViewById(R.id.customer_bct_bill_follow_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_bct_bill_follow_tag)");
        this.f39218h = (BillCouponPackTagView) findViewById8;
        View findViewById9 = findViewById(R.id.customer_bill_follow_coupon_title);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.custom…bill_follow_coupon_title)");
        this.f39219i = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.customer_bill_follow_info_tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.custom…ill_follow_info_tip_icon)");
        this.f39220j = findViewById10;
        View findViewById11 = findViewById(R.id.customer_bill_follow_coupon_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.custom…_bill_follow_coupon_icon)");
        this.f39221k = findViewById11;
        View findViewById12 = findViewById(R.id.customer_ll_value_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.customer_ll_value_parent)");
        this.f39222l = (LinearLayout) findViewById12;
        View view = this.f39217g;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billFollowInfoRoot");
            view = null;
        }
        Context context = view.getContext();
        CustomerRoundDrawable.Corner corner = new CustomerRoundDrawable.Corner();
        corner.setCorners((float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_28));
        Unit unit = Unit.INSTANCE;
        CustomerRoundDrawable customerRoundDrawable = new CustomerRoundDrawable(context, R.drawable.customer_bill_follow_item_bg, corner);
        View view2 = this.f39217g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billFollowInfoRoot");
            view2 = null;
        }
        view2.setBackground(customerRoundDrawable);
        TextView textView3 = this.f39214d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponValue");
            textView3 = null;
        }
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView3, 10, 14, 1, 1);
        TextView textView4 = this.f39215e;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyCouponOriginValue");
        } else {
            textView2 = textView4;
        }
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView2, 10, 11, 1, 1);
    }

    public void setData(ComponentModel componentModel) {
        CharSequence charSequence;
        ScopeContext scopeContext;
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        ComponentDataModel data = componentModel.getData();
        Object obj = null;
        FollowModel followModel = data == null ? null : data.getFollowModel();
        if (followModel != null) {
            m27772a(true);
            TextView textView = this.f39212b;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyCouponTitle");
                textView = null;
            }
            textView.setText(followModel.getTitle());
            TextView textView2 = this.f39213c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyCouponDes");
                textView2 = null;
            }
            textView2.setText(followModel.getBenefitDesc());
            TextView textView3 = this.f39214d;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyCouponValue");
                textView3 = null;
            }
            textView3.setText(followModel.getPackPriceDisplay());
            if (!TextUtils.isEmpty(followModel.getOriPackPriceDisplay())) {
                LinearLayout linearLayout = this.f39222l;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPriceLayout");
                    linearLayout = null;
                }
                linearLayout.setGravity(GravityCompat.END);
                TextView textView4 = this.f39215e;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buyCouponOriginValue");
                    textView4 = null;
                }
                textView4.setVisibility(0);
                TextView textView5 = this.f39215e;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buyCouponOriginValue");
                    textView5 = null;
                }
                textView5.setText(followModel.getOriPackPriceDisplay());
            } else {
                LinearLayout linearLayout2 = this.f39222l;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPriceLayout");
                    linearLayout2 = null;
                }
                linearLayout2.setGravity(8388629);
                TextView textView6 = this.f39215e;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buyCouponOriginValue");
                    textView6 = null;
                }
                textView6.setVisibility(8);
            }
            TextView textView7 = this.f39219i;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTitle");
                textView7 = null;
            }
            textView7.setText(followModel.getLeftTitle());
            if (!TextUtils.isEmpty(followModel.getUrl())) {
                View view = this.f39220j;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTipsIcon");
                    view = null;
                }
                view.setVisibility(0);
                View view2 = this.f39221k;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackCouponIcon");
                    view2 = null;
                }
                view2.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        BillFollowItemViewV2.m27770a(FollowModel.this, view);
                    }
                });
                TextView textView8 = this.f39219i;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTitle");
                    textView8 = null;
                }
                textView8.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        BillFollowItemViewV2.m27773b(FollowModel.this, view);
                    }
                });
                View view3 = this.f39220j;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTipsIcon");
                    view3 = null;
                }
                view3.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        BillFollowItemViewV2.m27774c(FollowModel.this, view);
                    }
                });
            } else {
                View view4 = this.f39220j;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTipsIcon");
                    view4 = null;
                }
                view4.setVisibility(8);
            }
            if (TextUtils.isEmpty(followModel.getRightTitle())) {
                BillCouponPackTagView billCouponPackTagView = this.f39218h;
                if (billCouponPackTagView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTag");
                    billCouponPackTagView = null;
                }
                billCouponPackTagView.setVisibility(8);
            } else {
                BillCouponPackTagView billCouponPackTagView2 = this.f39218h;
                if (billCouponPackTagView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTag");
                    billCouponPackTagView2 = null;
                }
                billCouponPackTagView2.setVisibility(0);
                BillCouponPackTagView billCouponPackTagView3 = this.f39218h;
                if (billCouponPackTagView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billCouponPackTag");
                    billCouponPackTagView3 = null;
                }
                billCouponPackTagView3.setData(followModel.getRightTitle());
            }
            RFIconView rFIconView = this.f39216f;
            if (rFIconView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyCouponSelect");
                rFIconView = null;
            }
            if (followModel.isSelected() == 1) {
                charSequence = ResourceHelper.getString(R.string.rf_icon_v3_filled_checkbox);
            } else {
                charSequence = ResourceHelper.getString(R.string.rf_icon_v3_outlined_checkbox);
            }
            rFIconView.setText(charSequence);
            View view5 = this.f39211a;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyCouponClickArea");
                view5 = null;
            }
            view5.setOnClickListener(new View.OnClickListener(followModel, componentModel) {
                public final /* synthetic */ FollowModel f$1;
                public final /* synthetic */ ComponentModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    BillFollowItemViewV2.m27771a(FollowModel.this, this.f$1, this.f$2, view);
                }
            });
            BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
            Integer valueOf = Integer.valueOf(followModel.getActivityId());
            Integer valueOf2 = Integer.valueOf(followModel.getBenefitId());
            String cartId = componentModel.getCartId();
            ItemViewCommonLogic itemViewCommonLogic = (ItemViewCommonLogic) getLogic();
            if (!(itemViewCommonLogic == null || (scopeContext = itemViewCommonLogic.getScopeContext()) == null)) {
                obj = scopeContext.getObject(Const.BundleKey.BILL_PAYMENT_METHOD_PAYMENT_TYPE);
            }
            companion.trackCouponPackageSW(valueOf, valueOf2, cartId, (Integer) obj);
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            m27772a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27770a(FollowModel followModel, View view) {
        Intrinsics.checkNotNullParameter(followModel, "$it");
        SchemeHelper.dispatchMsg(followModel.getUrl());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27773b(FollowModel followModel, View view) {
        Intrinsics.checkNotNullParameter(followModel, "$it");
        SchemeHelper.dispatchMsg(followModel.getUrl());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m27774c(FollowModel followModel, View view) {
        Intrinsics.checkNotNullParameter(followModel, "$it");
        SchemeHelper.dispatchMsg(followModel.getUrl());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27771a(FollowModel followModel, FollowModel followModel2, ComponentModel componentModel, View view) {
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
    private final void m27772a(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
