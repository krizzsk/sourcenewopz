package com.didi.rfusion.widget.progress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.ext.RFViewExtKt;
import com.didi.rfusion.widget.RFTextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fJ\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/rfusion/widget/progress/RFVerticalProgressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/rfusion/widget/progress/RFVerticalProgressAdapter$ViewHolder;", "()V", "verticalProgressItems", "", "Lcom/didi/rfusion/widget/progress/RFVerticalProgressEntity;", "addItem", "", "item", "clear", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "index", "setItems", "items", "", "ViewHolder", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFVerticalProgressAdapter.kt */
public final class RFVerticalProgressAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private final List<RFVerticalProgressEntity> f33657a = new ArrayList();

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rf_item_vertical_progress, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…_progress, parent, false)");
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        float f;
        ViewHolder viewHolder2 = viewHolder;
        int i2 = i;
        Intrinsics.checkParameterIsNotNull(viewHolder2, "holder");
        View view = viewHolder2.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        Context context = view.getContext();
        RFVerticalProgressEntity rFVerticalProgressEntity = this.f33657a.get(i2);
        viewHolder.getTvTitle().setText(rFVerticalProgressEntity.getTitle());
        viewHolder.getTvSubtitle().setText(rFVerticalProgressEntity.getSubTitle());
        if (i2 == 0) {
            View view2 = viewHolder2.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            RFViewExtKt.setPadding$default(view2, (Integer) null, 0, (Integer) null, (Integer) null, 13, (Object) null);
        } else {
            if (rFVerticalProgressEntity.getType() == 1) {
                f = RFResUtils.getDimens(R.dimen.rf_dimen_8);
            } else {
                f = RFResUtils.getDimens(R.dimen.rf_dimen_2);
            }
            View view3 = viewHolder2.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "itemView");
            RFViewExtKt.setPadding$default(view3, (Integer) null, Integer.valueOf((int) f), (Integer) null, (Integer) null, 13, (Object) null);
        }
        int type = rFVerticalProgressEntity.getType();
        if (type == 0) {
            RFViewExtKt.setPadding$default(viewHolder.getTvSubtitle(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(context, R.dimen.rf_dimen_84)), 7, (Object) null);
            viewHolder.getTvTitle().setTextColor(RFResUtils.getColor(context, R.color.rf_color_gery_3_60_999999));
            viewHolder.getTvTitle().setTypeface(3);
            viewHolder.getTvSubtitle().setTextColor(RFResUtils.getColor(context, R.color.rf_color_gery_3_60_999999));
            viewHolder.getLineDrawable().setColor(RFResUtils.getColor(context, R.color.rf_color_gery_5_90_E5E5E5));
            viewHolder.getNormalDrawable().setColor(RFResUtils.getColor(context, R.color.rf_color_gery_5_90_E5E5E5));
            viewHolder.getIvCircle().setBackground(viewHolder.getNormalDrawable());
        } else if (type == 1) {
            RFViewExtKt.setPadding$default(viewHolder.getTvSubtitle(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(context, R.dimen.rf_dimen_90)), 7, (Object) null);
            viewHolder.getTvTitle().setTextColor(RFResUtils.getColor(context, R.color.rf_color_brands_1_100));
            viewHolder.getTvTitle().setTypeface(1);
            viewHolder.getTvSubtitle().setTextColor(RFResUtils.getColor(context, R.color.rf_color_brands_1_100));
            viewHolder.getLineDrawable().setColor(RFResUtils.getColor(context, R.color.rf_color_gery_5_90_E5E5E5));
            viewHolder.getIvCircle().setBackground(viewHolder.getSelectedDrawable());
        } else if (type == 2) {
            RFViewExtKt.setPadding$default(viewHolder.getTvSubtitle(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf((int) RFResUtils.getDimens(context, R.dimen.rf_dimen_84)), 7, (Object) null);
            viewHolder.getTvTitle().setTextColor(RFResUtils.getColor(context, R.color.rf_color_gery_1_0_000000));
            viewHolder.getTvTitle().setTypeface(1);
            viewHolder.getTvSubtitle().setTextColor(RFResUtils.getColor(context, R.color.rf_color_gery_1_0_000000));
            viewHolder.getLineDrawable().setColor(RFResUtils.getColor(context, R.color.rf_color_brands_1_100));
            viewHolder.getNormalDrawable().setColor(RFResUtils.getColor(context, R.color.rf_color_brands_1_100));
            viewHolder.getIvCircle().setBackground(viewHolder.getNormalDrawable());
        }
        if (rFVerticalProgressEntity == ((RFVerticalProgressEntity) CollectionsKt.last(this.f33657a))) {
            viewHolder.getViewLine().setVisibility(8);
        } else {
            viewHolder.getViewLine().setVisibility(0);
        }
        viewHolder.getViewLine().setBackground(viewHolder.getLineDrawable());
    }

    public int getItemCount() {
        return this.f33657a.size();
    }

    public final void addItem(RFVerticalProgressEntity rFVerticalProgressEntity) {
        Intrinsics.checkParameterIsNotNull(rFVerticalProgressEntity, "item");
        this.f33657a.add(rFVerticalProgressEntity);
        notifyItemInserted(this.f33657a.size() - 1);
    }

    public final void removeItem(int i) {
        if (i < this.f33657a.size()) {
            this.f33657a.remove(i);
            notifyItemRemoved(i);
        }
    }

    public final void clear() {
        this.f33657a.clear();
        notifyDataSetChanged();
    }

    public final void setItems(List<RFVerticalProgressEntity> list) {
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        this.f33657a.clear();
        this.f33657a.addAll(list);
        notifyDataSetChanged();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/rfusion/widget/progress/RFVerticalProgressAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivCircle", "getIvCircle", "()Landroid/view/View;", "lineDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getLineDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "normalDrawable", "getNormalDrawable", "setNormalDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "selectedDrawable", "Landroid/graphics/drawable/Drawable;", "getSelectedDrawable", "()Landroid/graphics/drawable/Drawable;", "tvSubtitle", "Lcom/didi/rfusion/widget/RFTextView;", "getTvSubtitle", "()Lcom/didi/rfusion/widget/RFTextView;", "tvTitle", "getTvTitle", "viewLine", "getViewLine", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFVerticalProgressAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final View ivCircle;
        private final GradientDrawable lineDrawable;
        private GradientDrawable normalDrawable;
        private final Drawable selectedDrawable;
        private final RFTextView tvSubtitle;
        private final RFTextView tvTitle;
        private final View viewLine;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.rf_iv_circle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.rf_iv_circle)");
            this.ivCircle = findViewById;
            View findViewById2 = view.findViewById(R.id.rf_tv_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.rf_tv_title)");
            this.tvTitle = (RFTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.rf_tv_subtitle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.rf_tv_subtitle)");
            this.tvSubtitle = (RFTextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.rf_view_line);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.rf_view_line)");
            this.viewLine = findViewById4;
            Drawable drawable = RFResUtils.getDrawable(view.getContext(), R.drawable.rf_shape_line_vertical_progress);
            if (drawable != null) {
                this.lineDrawable = (GradientDrawable) drawable;
                Drawable drawable2 = RFResUtils.getDrawable(view.getContext(), R.drawable.rf_layer_circle_vertical_progress_selected);
                Intrinsics.checkExpressionValueIsNotNull(drawable2, "RFResUtils.getDrawable(i…rtical_progress_selected)");
                this.selectedDrawable = drawable2;
                Drawable drawable3 = RFResUtils.getDrawable(view.getContext(), R.drawable.rf_shape_circle_vertical_progress);
                if (drawable3 != null) {
                    this.normalDrawable = (GradientDrawable) drawable3;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
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
