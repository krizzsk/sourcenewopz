package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/business/BaseTagView;", "Lcom/didi/soda/customer/widget/text/RichTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindData", "", "textColor", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "content", "", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "getLimitedMaxWidth", "isOverSize", "", "shouldShow", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseTagView.kt */
public class BaseTagView extends RichTextView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseTagView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setMaxLines(1);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.MEDIUM);
    }

    public int getLimitedMaxWidth() {
        return ResourceHelper.getDimensionPixelSize(R.dimen.customer_124px);
    }

    /* renamed from: a */
    private final boolean m29416a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !m29415a();
    }

    /* renamed from: a */
    private final boolean m29415a() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (getMeasuredWidth() > getLimitedMaxWidth()) {
            return true;
        }
        return false;
    }

    public final void bindData(Integer num, Drawable drawable, String str) {
        CharSequence charSequence;
        if (drawable != null) {
            setBackground(drawable);
        }
        if (num != null) {
            num.intValue();
            setTextColor(num.intValue());
        }
        if (str != null) {
            charSequence = str;
        }
        setText(charSequence);
        setVisibility(m29416a(str) ? 0 : 8);
    }
}
