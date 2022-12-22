package com.didi.soda.globalcart.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0013R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/GlobalCartExpandView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "expandIcon", "Landroid/widget/TextView;", "expandNameTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "isOrderHistoryIcon", "", "mNum", "initView", "", "putAway", "setIcon", "icon", "", "setNum", "num", "isHistory", "setTextColor", "color", "showAll", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartExpandView.kt */
public final class GlobalCartExpandView extends ConstraintLayout {

    /* renamed from: a */
    private CustomerAppCompatTextView f42341a;

    /* renamed from: b */
    private TextView f42342b;

    /* renamed from: c */
    private int f42343c;

    /* renamed from: d */
    private boolean f42344d;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalCartExpandView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalCartExpandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCartExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    public final void initView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_widget_global_cart_expand_layout, this);
        View findViewById = findViewById(R.id.customer_tv_expand_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_expand_name)");
        this.f42341a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_expand_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_expand_icon)");
        this.f42342b = (TextView) findViewById2;
    }

    public final void setTextColor(int i) {
        CustomerAppCompatTextView customerAppCompatTextView = this.f42341a;
        TextView textView = null;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandNameTv");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setTextColor(i);
        TextView textView2 = this.f42342b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
        } else {
            textView = textView2;
        }
        textView.setTextColor(i);
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "icon");
        TextView textView = this.f42342b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            textView = null;
        }
        textView.setText(str);
    }

    public static /* synthetic */ void setNum$default(GlobalCartExpandView globalCartExpandView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        globalCartExpandView.setNum(i, z);
    }

    public final void setNum(int i, boolean z) {
        this.f42343c = i;
        this.f42344d = z;
        showAll();
    }

    public final void showAll() {
        CustomerAppCompatTextView customerAppCompatTextView = this.f42341a;
        TextView textView = null;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandNameTv");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setText(getResources().getString(R.string.customer_global_cart_items_collapse));
        if (this.f42344d) {
            TextView textView2 = this.f42342b;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            } else {
                textView = textView2;
            }
            textView.setText(getResources().getString(R.string.rf_icon_v3_small_outlined_spread));
            return;
        }
        TextView textView3 = this.f42342b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
        } else {
            textView = textView3;
        }
        textView.setText(getResources().getString(R.string.rf_icon_v3_outlined_spread));
    }

    public final void putAway() {
        CustomerAppCompatTextView customerAppCompatTextView = this.f42341a;
        TextView textView = null;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandNameTv");
            customerAppCompatTextView = null;
        }
        Resources resources = getResources();
        int i = this.f42343c;
        customerAppCompatTextView.setText(resources.getQuantityString(R.plurals.customer_show_all, i, new Object[]{Integer.valueOf(i)}));
        if (this.f42344d) {
            TextView textView2 = this.f42342b;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            } else {
                textView = textView2;
            }
            textView.setText(getResources().getString(R.string.rf_icon_v3_small_outlined_pickup));
            return;
        }
        TextView textView3 = this.f42342b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
        } else {
            textView = textView3;
        }
        textView.setText(getResources().getString(R.string.rf_icon_v3_outlined_pickup));
    }
}
