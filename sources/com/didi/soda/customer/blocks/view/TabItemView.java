package com.didi.soda.customer.blocks.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/view/TabItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabDesc", "Lcom/didi/soda/customer/widget/text/RichTextView;", "timeFrame", "bindProps", "", "tabInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "getColorWithAlpha", "alpha", "", "baseColor", "parseColor", "colorString", "", "defaultColorRes", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabItemView.kt */
public final class TabItemView extends RelativeLayout {

    /* renamed from: a */
    private RichTextView f40672a;

    /* renamed from: b */
    private RichTextView f40673b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_item_blocks_tab, this, true);
        View findViewById = inflate.findViewById(R.id.customer_tv_tab_time_frame);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_tab_time_frame)");
        this.f40672a = (RichTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tv_tab_tab_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_tab_tab_desc)");
        this.f40673b = (RichTextView) findViewById2;
    }

    public final void bindProps(TabInfoEntity tabInfoEntity) {
        Intrinsics.checkNotNullParameter(tabInfoEntity, "tabInfoEntity");
        int a = m28895a(tabInfoEntity.getBgColor(), R.color.rf_color_white_100_FFFFFF);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(a);
        gradientDrawable.setGradientType(0);
        setBackground(gradientDrawable);
        RichTextView richTextView = this.f40672a;
        RichTextView richTextView2 = null;
        if (richTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeFrame");
            richTextView = null;
        }
        String title = tabInfoEntity.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        richTextView.setText(title);
        RichTextView richTextView3 = this.f40673b;
        if (richTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabDesc");
        } else {
            richTextView2 = richTextView3;
        }
        String statusDesc = tabInfoEntity.getStatusDesc();
        if (statusDesc != null) {
            str = statusDesc;
        }
        richTextView2.setText(str);
    }

    /* renamed from: a */
    private final int m28895a(String str, int i) {
        if (str == null) {
            return ResourceHelper.getColor(i);
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return ResourceHelper.getColor(i);
        }
    }

    public final int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * ((float) 255)))) << 24) + (i & 16777215);
    }
}
