package com.didi.rfusion.widget.progress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.ext.RFViewExtKt;
import com.didi.rfusion.widget.RFTextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/rfusion/widget/progress/RFVerticalProgress;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "createProgressItem", "Landroid/view/View;", "entity", "Lcom/didi/rfusion/widget/progress/RFVerticalProgressEntity;", "position", "size", "setData", "", "items", "", "setOrientation", "orientation", "ViewHolder", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFVerticalProgress.kt */
public final class RFVerticalProgress extends LinearLayout {

    /* renamed from: a */
    private HashMap f33656a;

    public RFVerticalProgress(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFVerticalProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33656a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33656a == null) {
            this.f33656a = new HashMap();
        }
        View view = (View) this.f33656a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33656a.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFVerticalProgress(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFVerticalProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setOrientation(1);
    }

    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
        }
    }

    public final void setData(List<RFVerticalProgressEntity> list) {
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        removeAllViews();
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            addView(m23710a((RFVerticalProgressEntity) next, i, list.size()));
            i = i2;
        }
    }

    /* renamed from: a */
    private final View m23710a(RFVerticalProgressEntity rFVerticalProgressEntity, int i, int i2) {
        float f;
        int i3 = i;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.rf_item_vertical_progress, this, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…al_progress, this, false)");
        ViewHolder viewHolder = new ViewHolder(inflate);
        viewHolder.getTvTitle().setText(rFVerticalProgressEntity.getTitle());
        viewHolder.getTvSubtitle().setText(rFVerticalProgressEntity.getSubTitle());
        if (i3 == 0) {
            RFViewExtKt.setPadding$default(viewHolder.getItemView(), (Integer) null, 0, (Integer) null, (Integer) null, 13, (Object) null);
        } else {
            if (rFVerticalProgressEntity.getType() == 1) {
                f = RFResUtils.getDimens(R.dimen.rf_dimen_8);
            } else {
                f = RFResUtils.getDimens(R.dimen.rf_dimen_2);
            }
            RFViewExtKt.setPadding$default(viewHolder.getItemView(), (Integer) null, Integer.valueOf((int) f), (Integer) null, (Integer) null, 13, (Object) null);
        }
        int type = rFVerticalProgressEntity.getType();
        if (type == 0) {
            RFViewExtKt.setPadding$default(viewHolder.getTvSubtitle(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_84)), 7, (Object) null);
            viewHolder.getTvTitle().setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_3_60_999999));
            viewHolder.getTvTitle().setTypeface(3);
            viewHolder.getTvSubtitle().setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_3_60_999999));
            viewHolder.getLineDrawable().setColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_5_90_E5E5E5));
            viewHolder.getNormalDrawable().setColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_5_90_E5E5E5));
            viewHolder.getIvCircle().setBackground(viewHolder.getNormalDrawable());
        } else if (type == 1) {
            RFViewExtKt.setPadding$default(viewHolder.getTvSubtitle(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_90)), 7, (Object) null);
            viewHolder.getTvTitle().setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_brands_1_100));
            viewHolder.getTvTitle().setTypeface(1);
            viewHolder.getTvSubtitle().setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_brands_1_100));
            viewHolder.getLineDrawable().setColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_5_90_E5E5E5));
            viewHolder.getIvCircle().setBackground(viewHolder.getSelectedDrawable());
        } else if (type == 2) {
            RFViewExtKt.setPadding$default(viewHolder.getTvSubtitle(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_84)), 7, (Object) null);
            viewHolder.getTvTitle().setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_1_0_000000));
            viewHolder.getTvTitle().setTypeface(1);
            viewHolder.getTvSubtitle().setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_1_0_000000));
            viewHolder.getLineDrawable().setColor(RFResUtils.getColor(getContext(), R.color.rf_color_brands_1_100));
            viewHolder.getNormalDrawable().setColor(RFResUtils.getColor(getContext(), R.color.rf_color_brands_1_100));
            viewHolder.getIvCircle().setBackground(viewHolder.getNormalDrawable());
        }
        if (i3 >= i2 - 1) {
            viewHolder.getViewLine().setVisibility(8);
        } else {
            viewHolder.getViewLine().setVisibility(0);
        }
        viewHolder.getViewLine().setBackground(viewHolder.getLineDrawable());
        return viewHolder.getItemView();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/rfusion/widget/progress/RFVerticalProgress$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "ivCircle", "getIvCircle", "lineDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getLineDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "normalDrawable", "getNormalDrawable", "setNormalDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "selectedDrawable", "Landroid/graphics/drawable/Drawable;", "getSelectedDrawable", "()Landroid/graphics/drawable/Drawable;", "tvSubtitle", "Lcom/didi/rfusion/widget/RFTextView;", "getTvSubtitle", "()Lcom/didi/rfusion/widget/RFTextView;", "tvTitle", "getTvTitle", "viewLine", "getViewLine", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFVerticalProgress.kt */
    private static final class ViewHolder {
        private final View itemView;
        private final View ivCircle;
        private final GradientDrawable lineDrawable;
        private GradientDrawable normalDrawable;
        private final Drawable selectedDrawable;
        private final RFTextView tvSubtitle;
        private final RFTextView tvTitle;
        private final View viewLine;

        public ViewHolder(View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.itemView = view;
            View findViewById = view.findViewById(R.id.rf_iv_circle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.rf_iv_circle)");
            this.ivCircle = findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.rf_tv_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.rf_tv_title)");
            this.tvTitle = (RFTextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.rf_tv_subtitle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.rf_tv_subtitle)");
            this.tvSubtitle = (RFTextView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.rf_view_line);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.rf_view_line)");
            this.viewLine = findViewById4;
            Drawable drawable = RFResUtils.getDrawable(this.itemView.getContext(), R.drawable.rf_shape_line_vertical_progress);
            if (drawable != null) {
                this.lineDrawable = (GradientDrawable) drawable;
                Drawable drawable2 = RFResUtils.getDrawable(this.itemView.getContext(), R.drawable.rf_layer_circle_vertical_progress_selected);
                Intrinsics.checkExpressionValueIsNotNull(drawable2, "RFResUtils.getDrawable(i…rtical_progress_selected)");
                this.selectedDrawable = drawable2;
                Drawable drawable3 = RFResUtils.getDrawable(this.itemView.getContext(), R.drawable.rf_shape_circle_vertical_progress);
                if (drawable3 != null) {
                    this.normalDrawable = (GradientDrawable) drawable3;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }

        public final View getItemView() {
            return this.itemView;
        }

        public final View getIvCircle() {
            return this.ivCircle;
        }

        public final RFTextView getTvTitle() {
            return this.tvTitle;
        }

        public final RFTextView getTvSubtitle() {
            return this.tvSubtitle;
        }

        public final View getViewLine() {
            return this.viewLine;
        }

        public final GradientDrawable getLineDrawable() {
            return this.lineDrawable;
        }

        public final Drawable getSelectedDrawable() {
            return this.selectedDrawable;
        }

        public final GradientDrawable getNormalDrawable() {
            return this.normalDrawable;
        }

        public final void setNormalDrawable(GradientDrawable gradientDrawable) {
            Intrinsics.checkParameterIsNotNull(gradientDrawable, "<set-?>");
            this.normalDrawable = gradientDrawable;
        }
    }
}
