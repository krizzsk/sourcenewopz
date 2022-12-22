package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J)\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0007J.\u0010\u001b\u001a\u00020\u000f2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/IconAndTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIconView", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "mTextView", "Lcom/didi/soda/customer/widget/text/RichTextView;", "getIconWidthAndMargin", "hasEnoughSpaceShowContent", "", "desiredWidth", "restoreDefaultLayout", "", "setData", "iconString", "", "textString", "maxLine", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "setTextWidth", "newWidth", "shouldShow", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IconAndTextView.kt */
public class IconAndTextView extends LinearLayout {

    /* renamed from: a */
    private IconRichTextView f43185a;

    /* renamed from: b */
    private RichTextView f43186b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IconAndTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IconAndTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IconAndTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconAndTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundResource(R.color.rf_color_white_100_FFFFFF);
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_layout_home_business_grid_item, this);
        View findViewById = inflate.findViewById(R.id.customer_custom_business_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_custom_business_icon)");
        this.f43185a = (IconRichTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_custom_business_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_custom_business_text)");
        this.f43186b = (RichTextView) findViewById2;
    }

    public final boolean shouldShow(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get("content")) == null)) {
            str = obj.toString();
        }
        return !TextUtils.isEmpty(str);
    }

    public final void setData(String str, String str2, Integer num) {
        m30540a();
        CharSequence charSequence = str2;
        if (!TextUtils.isEmpty(charSequence)) {
            setVisibility(0);
            this.f43186b.setVisibility(0);
            this.f43186b.setText(charSequence);
            if (num != null && num.intValue() > 1) {
                this.f43186b.setMaxLines(num.intValue());
            }
            CharSequence charSequence2 = str;
            if (!TextUtils.isEmpty(charSequence2)) {
                this.f43185a.setVisibility(0);
                this.f43185a.setText(charSequence2);
                return;
            }
            this.f43185a.setVisibility(8);
            return;
        }
        this.f43185a.setVisibility(8);
        this.f43186b.setVisibility(8);
        setVisibility(8);
    }

    public final void setTextWidth(int i) {
        if (this.f43186b.getVisibility() == 0) {
            this.f43186b.getLayoutParams().width = i;
        }
    }

    public final int getIconWidthAndMargin() {
        int i = 0;
        if (this.f43185a.getVisibility() != 0) {
            return 0;
        }
        int measuredWidth = this.f43185a.getMeasuredWidth() + 0;
        ViewGroup.LayoutParams layoutParams = this.f43185a.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        int i2 = measuredWidth + (marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = this.f43185a.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams;
        if (marginLayoutParams3 != null) {
            i = marginLayoutParams3.rightMargin;
        }
        return this.f43185a.getPaddingRight() + i2 + i + this.f43185a.getPaddingLeft();
    }

    public final boolean hasEnoughSpaceShowContent(int i) {
        return !TextUtils.isEmpty(TextUtils.ellipsize(this.f43186b.getText(), this.f43186b.getPaint(), (float) i, TextUtils.TruncateAt.END));
    }

    /* renamed from: a */
    private final void m30540a() {
        this.f43186b.setMaxLines(1);
    }
}
