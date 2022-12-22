package com.didi.soda.bill.widgets.tip;

import android.content.Context;
import android.widget.FrameLayout;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/tip/NormalTipItemView;", "Landroid/widget/FrameLayout;", "Lcom/didi/soda/bill/widgets/tip/ITipItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "tipAmountText", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "dynamicFitTextSize", "", "setData", "", "text", "", "isSelected", "", "setSelectedState", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NormalTipItemView.kt */
public final class NormalTipItemView extends FrameLayout implements ITipItemView {

    /* renamed from: a */
    private final CustomerAppCompatTextView f39328a;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalTipItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundResource(R.drawable.customer_skin_selector_bill_tip_bg);
        CustomerAppCompatTextView customerAppCompatTextView = new CustomerAppCompatTextView(context);
        this.f39328a = customerAppCompatTextView;
        customerAppCompatTextView.setTextColor(context.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        this.f39328a.setFontType(IToolsService.FontType.LIGHT);
        this.f39328a.setTextSize(1, m27853a());
        addView(this.f39328a, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    public final void setData(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f39328a.setText(str);
        setSelectedState(z);
    }

    public void setSelectedState(boolean z) {
        setSelected(z);
        if (z) {
            this.f39328a.setFontType(IToolsService.FontType.MEDIUM);
            this.f39328a.setTextColor(SkinUtil.getBrandPrimaryColor());
            return;
        }
        this.f39328a.setFontType(IToolsService.FontType.LIGHT);
        this.f39328a.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
    }

    /* renamed from: a */
    private final float m27853a() {
        return CustomerSystemUtil.getScreenWidth(getContext()) > 640 ? 18.0f : 14.0f;
    }
}
