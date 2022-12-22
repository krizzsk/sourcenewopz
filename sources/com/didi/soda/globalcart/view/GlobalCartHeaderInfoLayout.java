package com.didi.soda.globalcart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.bill.model.datamodel.ShopInfoModel;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/GlobalCartHeaderInfoLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "businessTitleTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "descTv", "headerLayout", "bindData", "", "shopInfoModel", "Lcom/didi/soda/bill/model/datamodel/ShopInfoModel;", "initView", "renderClosedHeader", "model", "renderOpenHeader", "renderOutRangeHeader", "renderStopDeliveryHeader", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartHeaderInfoLayout.kt */
public final class GlobalCartHeaderInfoLayout extends ConstraintLayout {

    /* renamed from: a */
    private ConstraintLayout f42345a;

    /* renamed from: b */
    private CustomerAppCompatTextView f42346b;

    /* renamed from: c */
    private CustomerAppCompatTextView f42347c;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalCartHeaderInfoLayout(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalCartHeaderInfoLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCartHeaderInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    public final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_cart_header, this);
        View findViewById = findViewById(R.id.customer_cart_header_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_cart_header_container)");
        this.f42345a = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_business_status_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…tv_business_status_title)");
        this.f42346b = (CustomerAppCompatTextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_business_status_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…_tv_business_status_desc)");
        this.f42347c = (CustomerAppCompatTextView) findViewById3;
    }

    public final void bindData(ShopInfoModel shopInfoModel) {
        if (shopInfoModel == null) {
            ConstraintLayout constraintLayout = this.f42345a;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerLayout");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(8);
        }
        if (shopInfoModel != null) {
            int cShopStatus = shopInfoModel.getCShopStatus();
            if (cShopStatus != 1) {
                if (cShopStatus != 2) {
                    if (cShopStatus == 3) {
                        m29821b(shopInfoModel);
                        return;
                    } else if (cShopStatus == 4) {
                        m29822c(shopInfoModel);
                        return;
                    } else if (cShopStatus != 5) {
                        return;
                    }
                }
                m29823d(shopInfoModel);
                return;
            }
            m29820a(shopInfoModel);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [com.didi.soda.customer.widget.support.CustomerAppCompatTextView] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m29820a(com.didi.soda.bill.model.datamodel.ShopInfoModel r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getCloseSoonDesc()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            if (r0 == 0) goto L_0x0012
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x0013
        L_0x0012:
            r0 = 1
        L_0x0013:
            r2 = 8
            java.lang.String r3 = "headerLayout"
            r4 = 0
            if (r0 == 0) goto L_0x0027
            androidx.constraintlayout.widget.ConstraintLayout r6 = r5.f42345a
            if (r6 != 0) goto L_0x0022
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0023
        L_0x0022:
            r4 = r6
        L_0x0023:
            r4.setVisibility(r2)
            goto L_0x006d
        L_0x0027:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r5.f42345a
            if (r0 != 0) goto L_0x002f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L_0x002f:
            r0.setVisibility(r1)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r5.f42347c
            if (r0 != 0) goto L_0x003c
            java.lang.String r0 = "descTv"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r4
        L_0x003c:
            r0.setVisibility(r2)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r5.f42346b
            java.lang.String r1 = "businessTitleTv"
            if (r0 != 0) goto L_0x0049
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r4
        L_0x0049:
            java.lang.String r6 = r6.getCloseSoonDesc()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r6 = r5.f42346b
            if (r6 != 0) goto L_0x005a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x005b
        L_0x005a:
            r4 = r6
        L_0x005b:
            android.content.Context r6 = r5.getContext()
            android.content.res.Resources r6 = r6.getResources()
            r0 = 2131101608(0x7f0607a8, float:1.781563E38)
            int r6 = r6.getColor(r0)
            r4.setTextColor(r6)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.globalcart.view.GlobalCartHeaderInfoLayout.m29820a(com.didi.soda.bill.model.datamodel.ShopInfoModel):void");
    }

    /* renamed from: b */
    private final void m29821b(ShopInfoModel shopInfoModel) {
        ConstraintLayout constraintLayout = this.f42345a;
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f42347c;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            customerAppCompatTextView2 = null;
        }
        customerAppCompatTextView2.setVisibility(8);
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f42346b;
        if (customerAppCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessTitleTv");
            customerAppCompatTextView3 = null;
        }
        String string = getContext().getResources().getString(R.string.customer_business_status_out_of_delivery_no_folding);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…t_of_delivery_no_folding)");
        String upperCase = string.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        customerAppCompatTextView3.setText(upperCase);
        CustomerAppCompatTextView customerAppCompatTextView4 = this.f42346b;
        if (customerAppCompatTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessTitleTv");
        } else {
            customerAppCompatTextView = customerAppCompatTextView4;
        }
        customerAppCompatTextView.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
    }

    /* renamed from: c */
    private final void m29822c(ShopInfoModel shopInfoModel) {
        ConstraintLayout constraintLayout = this.f42345a;
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f42347c;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            customerAppCompatTextView2 = null;
        }
        customerAppCompatTextView2.setVisibility(8);
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f42346b;
        if (customerAppCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessTitleTv");
            customerAppCompatTextView3 = null;
        }
        String string = getContext().getResources().getString(R.string.customer_business_detail_temporarily_unavailable);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…_temporarily_unavailable)");
        String upperCase = string.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        customerAppCompatTextView3.setText(upperCase);
        CustomerAppCompatTextView customerAppCompatTextView4 = this.f42346b;
        if (customerAppCompatTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessTitleTv");
        } else {
            customerAppCompatTextView = customerAppCompatTextView4;
        }
        customerAppCompatTextView.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
    }

    /* renamed from: d */
    private final void m29823d(ShopInfoModel shopInfoModel) {
        ConstraintLayout constraintLayout = this.f42345a;
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        CharSequence nextBizTimeDesc = shopInfoModel.getNextBizTimeDesc();
        if (!(nextBizTimeDesc == null || nextBizTimeDesc.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f42347c;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descTv");
                customerAppCompatTextView2 = null;
            }
            customerAppCompatTextView2.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView3 = this.f42346b;
            if (customerAppCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessTitleTv");
                customerAppCompatTextView3 = null;
            }
            customerAppCompatTextView3.setText(shopInfoModel.getNextBizTimeDesc());
            CustomerAppCompatTextView customerAppCompatTextView4 = this.f42347c;
            if (customerAppCompatTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descTv");
                customerAppCompatTextView4 = null;
            }
            customerAppCompatTextView4.setText(getContext().getResources().getString(R.string.customer_business_status_closed_no_gap));
        } else {
            CustomerAppCompatTextView customerAppCompatTextView5 = this.f42346b;
            if (customerAppCompatTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessTitleTv");
                customerAppCompatTextView5 = null;
            }
            customerAppCompatTextView5.setText(getContext().getResources().getString(R.string.customer_business_status_closed_no_gap));
            CustomerAppCompatTextView customerAppCompatTextView6 = this.f42347c;
            if (customerAppCompatTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descTv");
                customerAppCompatTextView6 = null;
            }
            customerAppCompatTextView6.setVisibility(8);
        }
        CustomerAppCompatTextView customerAppCompatTextView7 = this.f42346b;
        if (customerAppCompatTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessTitleTv");
        } else {
            customerAppCompatTextView = customerAppCompatTextView7;
        }
        customerAppCompatTextView.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
    }
}
