package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.soda.customer.foundation.rpc.entity.AbnormalItemInfoEntity;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/order/view/RefundAbnormalItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "abnormalRemark", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "amount", "itemName", "subItemDesc", "bindData", "", "model", "Lcom/didi/soda/customer/foundation/rpc/entity/AbnormalItemInfoEntity;", "initView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RefundAbnormalItemView.kt */
public class RefundAbnormalItemView extends FrameLayout {

    /* renamed from: a */
    private CustomerAppCompatTextView f43619a;

    /* renamed from: b */
    private CustomerAppCompatTextView f43620b;

    /* renamed from: c */
    private CustomerAppCompatTextView f43621c;

    /* renamed from: d */
    private CustomerAppCompatTextView f43622d;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RefundAbnormalItemView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RefundAbnormalItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefundAbnormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    public void initView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.customer_item_abnormal_dish_info, this);
        View findViewById = findViewById(R.id.customer_tv_item_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_item_name)");
        this.f43619a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_subitem_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_subitem_desc)");
        this.f43620b = (CustomerAppCompatTextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_abnormal_remark);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_abnormal_remark)");
        this.f43621c = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_item_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_item_amount)");
        this.f43622d = (CustomerAppCompatTextView) findViewById4;
    }

    public void bindData(AbnormalItemInfoEntity abnormalItemInfoEntity) {
        Intrinsics.checkNotNullParameter(abnormalItemInfoEntity, "model");
        CharSequence itemName = abnormalItemInfoEntity.getItemName();
        boolean z = true;
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (!(itemName == null || itemName.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f43619a;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemName");
                customerAppCompatTextView2 = null;
            }
            customerAppCompatTextView2.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView3 = this.f43619a;
            if (customerAppCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemName");
                customerAppCompatTextView3 = null;
            }
            customerAppCompatTextView3.setText(abnormalItemInfoEntity.getItemName());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView4 = this.f43619a;
            if (customerAppCompatTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemName");
                customerAppCompatTextView4 = null;
            }
            customerAppCompatTextView4.setVisibility(8);
        }
        CharSequence subItemDesc = abnormalItemInfoEntity.getSubItemDesc();
        if (!(subItemDesc == null || subItemDesc.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView5 = this.f43620b;
            if (customerAppCompatTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subItemDesc");
                customerAppCompatTextView5 = null;
            }
            customerAppCompatTextView5.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView6 = this.f43620b;
            if (customerAppCompatTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subItemDesc");
                customerAppCompatTextView6 = null;
            }
            customerAppCompatTextView6.setText(abnormalItemInfoEntity.getSubItemDesc());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView7 = this.f43620b;
            if (customerAppCompatTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subItemDesc");
                customerAppCompatTextView7 = null;
            }
            customerAppCompatTextView7.setVisibility(8);
        }
        CharSequence abnormalRemark = abnormalItemInfoEntity.getAbnormalRemark();
        if (!(abnormalRemark == null || abnormalRemark.length() == 0)) {
            z = false;
        }
        if (!z) {
            CustomerAppCompatTextView customerAppCompatTextView8 = this.f43621c;
            if (customerAppCompatTextView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("abnormalRemark");
                customerAppCompatTextView8 = null;
            }
            customerAppCompatTextView8.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView9 = this.f43621c;
            if (customerAppCompatTextView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("abnormalRemark");
                customerAppCompatTextView9 = null;
            }
            customerAppCompatTextView9.setText(abnormalItemInfoEntity.getAbnormalRemark());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView10 = this.f43621c;
            if (customerAppCompatTextView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("abnormalRemark");
                customerAppCompatTextView10 = null;
            }
            customerAppCompatTextView10.setVisibility(8);
        }
        if (abnormalItemInfoEntity.getAmount() > 0) {
            CustomerAppCompatTextView customerAppCompatTextView11 = this.f43622d;
            if (customerAppCompatTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("amount");
                customerAppCompatTextView11 = null;
            }
            customerAppCompatTextView11.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView12 = this.f43622d;
            if (customerAppCompatTextView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("amount");
            } else {
                customerAppCompatTextView = customerAppCompatTextView12;
            }
            customerAppCompatTextView.setText(Intrinsics.stringPlus("x", Integer.valueOf(abnormalItemInfoEntity.getAmount())));
        }
    }
}
