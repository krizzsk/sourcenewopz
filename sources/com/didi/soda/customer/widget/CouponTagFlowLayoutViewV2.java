package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ColorUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\bJ\u001c\u0010\u0015\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/CouponTagFlowLayoutViewV2;", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTagRowCount", "", "createActTv", "Landroid/view/View;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/PromptEntity;", "parent", "Landroid/view/ViewGroup;", "getLineCounts", "initChildren", "", "actEntityList", "", "flowWidth", "setData", "data", "datas", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CouponTagFlowLayoutViewV2.kt */
public final class CouponTagFlowLayoutViewV2 extends NovaFlowLayout {

    /* renamed from: a */
    private int f41451a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CouponTagFlowLayoutViewV2(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponTagFlowLayoutViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponTagFlowLayoutViewV2(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setData(PromptEntity promptEntity, int i) {
        Intrinsics.checkNotNullParameter(promptEntity, "data");
        List arrayList = new ArrayList();
        arrayList.add(promptEntity);
        setData((List<? extends PromptEntity>) arrayList, i);
    }

    public final void setData(List<? extends PromptEntity> list, int i) {
        Intrinsics.checkNotNullParameter(list, "datas");
        this.f41451a = 0;
        m29341a(list, i);
    }

    public final int getLineCounts() {
        return this.f41451a;
    }

    /* renamed from: a */
    private final void m29341a(List<? extends PromptEntity> list, int i) {
        int i2;
        removeAllViews();
        List arrayList = new ArrayList();
        if (!CollectionsUtil.isEmpty(list)) {
            this.f41451a = 1;
            int size = list.size() - 1;
            if (size >= 0) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = i3 + 1;
                    PromptEntity promptEntity = (PromptEntity) list.get(i3);
                    if (!TextUtils.isEmpty(promptEntity.content)) {
                        RelativeLayout relativeLayout = new RelativeLayout(getContext());
                        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                        View createActTv = createActTv(promptEntity, relativeLayout);
                        int measuredWidth = createActTv.getMeasuredWidth();
                        if (i3 == 0) {
                            i2 = measuredWidth + createActTv.getPaddingLeft() + createActTv.getPaddingRight();
                        } else {
                            i2 = getChildSpacing() + measuredWidth + createActTv.getPaddingLeft() + createActTv.getPaddingRight();
                        }
                        i4 += i2;
                        if (i4 > i && list.size() > 1) {
                            this.f41451a = 2;
                        }
                        arrayList.add(relativeLayout);
                    }
                    if (i5 > size) {
                        break;
                    }
                    i3 = i5;
                }
            }
            addView(arrayList);
        }
    }

    public final View createActTv(PromptEntity promptEntity, ViewGroup viewGroup) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(promptEntity, "entity");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_layout_tag_flow_v2_item, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_ctl_tag_flow_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…stomer_ctl_tag_flow_root)");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tag_flow_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.customer_tag_flow_tv)");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_tag_flow_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.customer_tag_flow_icon)");
        TextView textView2 = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_tag_flow_img);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.customer_tag_flow_img)");
        ImageView imageView = (ImageView) findViewById4;
        try {
            i = Color.parseColor(promptEntity.fontColor);
        } catch (Exception unused) {
            i = ResourceHelper.getColor(R.color.rf_color_brands_2_72_31B77E);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            i2 = Color.parseColor(promptEntity.backColor);
        } catch (Exception unused2) {
            i2 = ColorUtil.getColorWithAlpha(0.1f, ResourceHelper.getColor(R.color.rf_color_brands_2_72_31B77E));
        }
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_12));
        constraintLayout.setBackground(gradientDrawable);
        textView.setText(promptEntity.content);
        textView.setTextColor(i);
        CharSequence charSequence = promptEntity.imgUrl;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            imageView.setVisibility(0);
            textView2.setVisibility(8);
            FlyImageLoader.loadImage1x1(getContext(), promptEntity.imgUrl).placeholder((int) R.drawable.ic_tag_flow_img).error((int) R.drawable.ic_tag_flow_img).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_12), 0, RoundedCornersTransformation.CornerType.LEFT, true)).into(imageView);
        } else {
            CharSequence charSequence2 = promptEntity.icon;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                try {
                    imageView.setVisibility(8);
                    textView2.setVisibility(0);
                    textView2.setText(getResources().getIdentifier(promptEntity.icon, TypedValues.Custom.S_STRING, getContext().getPackageName()));
                    textView2.setTextColor(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                textView2.setVisibility(8);
                imageView.setVisibility(8);
            }
        }
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        return inflate;
    }
}
