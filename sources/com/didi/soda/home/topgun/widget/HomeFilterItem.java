package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.home.topgun.model.FilterModel;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeFilterItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxFreeWidth", "getMaxFreeWidth", "()I", "setMaxFreeWidth", "(I)V", "maxWidth", "getMaxWidth", "setMaxWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setupMaxFreeWidth", "updateItem", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFilterLayout.kt */
public final class HomeFilterItem extends LinearLayout {

    /* renamed from: a */
    private int f43122a;

    /* renamed from: b */
    private int f43123b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeFilterItem(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeFilterItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeFilterItem(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFilterItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43122a = CustomerExtentionKt.getPx(R.dimen.customer_400px);
        this.f43123b = -1;
        setOrientation(0);
        setBackgroundResource(R.drawable.customer_skin_home_selector_filter_item);
        setGravity(16);
        int px = CustomerExtentionKt.getPx(R.dimen.customer_32px);
        setPadding(px, 0, px, 0);
        LayoutInflater.from(context).inflate(R.layout.customer_home_filter_layout_item, this);
    }

    public final int getMaxWidth() {
        return this.f43122a;
    }

    public final void setMaxWidth(int i) {
        this.f43122a = i;
    }

    public final int getMaxFreeWidth() {
        return this.f43123b;
    }

    public final void setMaxFreeWidth(int i) {
        this.f43123b = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f43122a, Integer.MIN_VALUE), i2);
    }

    /* renamed from: a */
    private final void m30513a() {
        if (this.f43123b < 0) {
            int i = 0;
            measure(View.MeasureSpec.makeMeasureSpec(this.f43122a, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = ((RFIconView) findViewById(R.id.customer_tv_home_filter_icon)).getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = ((RFIconView) findViewById(R.id.customer_tv_home_filter_icon)).getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                i = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            }
            this.f43123b = ((this.f43122a - (getPaddingLeft() + getPaddingRight())) - i) - measuredWidth;
            ((ExpandTextView) findViewById(R.id.customer_tv_home_filter_text)).setMaxAnimWidth(this.f43123b);
        }
    }

    public final void updateItem(FilterModel filterModel) {
        String str;
        String str2;
        FilterModel.FilterItemRvModel selectedItem;
        Intrinsics.checkNotNullParameter(filterModel, "filterModel");
        setSelected(filterModel.mHeadLineLight);
        ((ExpandTextView) findViewById(R.id.customer_tv_home_filter_text)).setSelected(filterModel.mHeadLineLight);
        m30513a();
        if (filterModel.getCurrentHeaderLine() == null) {
            ((ExpandTextView) findViewById(R.id.customer_tv_home_filter_text)).setTextWithAnim("", "");
        } else {
            String preHeadLine = filterModel.getPreHeadLine();
            String currentHeaderLine = filterModel.getCurrentHeaderLine();
            Intrinsics.checkNotNullExpressionValue(currentHeaderLine, "filterModel.currentHeaderLine");
            if (((ExpandTextView) findViewById(R.id.customer_tv_home_filter_text)).setTextWithAnim(preHeadLine, currentHeaderLine)) {
                filterModel.syncPreHeaderLine();
            }
        }
        if (filterModel.mShowType == 5) {
            ((RFIconView) findViewById(R.id.customer_tv_home_filter_icon)).setVisibility(8);
        } else {
            ((RFIconView) findViewById(R.id.customer_tv_home_filter_icon)).setVisibility(0);
        }
        boolean z = true;
        String str3 = null;
        if (isSelected()) {
            CharSequence charSequence = filterModel.mSelectedImage;
            str = !(charSequence == null || charSequence.length() == 0) ? filterModel.mSelectedImage : null;
            if (filterModel.mShowType == 7 && filterModel.getSelectedNumber() == 1) {
                List<FilterModel.FilterComponentModel> list = filterModel.mFilterComponent;
                if (list != null) {
                    loop0:
                    while (true) {
                        str2 = null;
                        for (FilterModel.FilterComponentModel next : list) {
                            if (next != null && (selectedItem = next.getSelectedItem()) != null) {
                                str2 = selectedItem.mSelectedImg;
                            }
                        }
                        break loop0;
                    }
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    str = str2;
                }
            }
        } else {
            CharSequence charSequence2 = filterModel.mImage;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            str = !z ? filterModel.mImage : null;
        }
        CharSequence charSequence3 = str;
        if (!TextUtils.isEmpty(charSequence3)) {
            ((ImageView) findViewById(R.id.customer_tv_home_filter_image)).setVisibility(0);
            Object tag = ((ImageView) findViewById(R.id.customer_tv_home_filter_image)).getTag();
            if (tag != null) {
                str3 = tag.toString();
            }
            if (!TextUtils.equals(str3, charSequence3)) {
                FlyImageLoader.loadImage1x1(getContext(), str).fitCenter().dontAnimate().into((ImageView) findViewById(R.id.customer_tv_home_filter_image));
                ((ImageView) findViewById(R.id.customer_tv_home_filter_image)).setTag(str);
                return;
            }
            return;
        }
        ((ImageView) findViewById(R.id.customer_tv_home_filter_image)).setVisibility(8);
    }
}
