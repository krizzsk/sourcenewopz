package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0002J \u0010\u0018\u001a\u00020\u00142\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\u0015\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010#J\u000e\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006+"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid;", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHomeBusinessGridConfig", "Lcom/didi/soda/home/topgun/widget/HomeBusinessGridConfig;", "addAndMeasureDivider", "content", "", "tag", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "originWidth", "exceptHeight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "removeLastDividerForRow", "setData", "list", "", "Lcom/didi/soda/customer/foundation/rpc/entity/PromptEntity;", "viewWidth", "setDefaultConfig", "setDivider", "divider", "setItemSpace", "itemSpace", "", "(Ljava/lang/Float;)V", "setLineSpace", "lineSpace", "setMaxRow", "maxRow", "setShowDividerIndex", "index", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBusinessGrid.kt */
public final class HomeBusinessGrid extends NovaFlowLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIVIDER_DEFAULT = "";
    public static final String DIVIDER_DOT = "dot";
    public static final String DIVIDER_SPACE_DOT = "space_and_dot";

    /* renamed from: a */
    private HomeBusinessGridConfig f43085a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessGrid(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeBusinessGrid(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBusinessGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        m30492a();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid$Companion;", "", "()V", "DIVIDER_DEFAULT", "", "DIVIDER_DOT", "DIVIDER_SPACE_DOT", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeBusinessGrid.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private final void m30492a() {
        HomeBusinessGridConfig homeBusinessGridConfig = new HomeBusinessGridConfig(1, "", MathKt.roundToInt(getContext().getResources().getDimension(R.dimen.rf_dimen_20)), getContext().getResources().getDimension(R.dimen.rf_dimen_20), 0, 16, (DefaultConstructorMarker) null);
        this.f43085a = homeBusinessGridConfig;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        setChildSpacing(homeBusinessGridConfig.getItemSpace());
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f43085a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setRowSpacing(homeBusinessGridConfig2.getLineSpace());
    }

    public final void setMaxRow(int i) {
        HomeBusinessGridConfig homeBusinessGridConfig = this.f43085a;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        if (i <= 1) {
            i = 1;
        }
        homeBusinessGridConfig.setMaxRow(i);
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f43085a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setMaxRows(homeBusinessGridConfig2.getMaxRow());
    }

    public final void setDivider(String str) {
        HomeBusinessGridConfig homeBusinessGridConfig = this.f43085a;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        homeBusinessGridConfig.setDivider(str);
    }

    public final void setShowDividerIndex(int i) {
        HomeBusinessGridConfig homeBusinessGridConfig = this.f43085a;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        homeBusinessGridConfig.setShowDividerIndex(i);
    }

    public final void setItemSpace(Float f) {
        int i;
        HomeBusinessGridConfig homeBusinessGridConfig = this.f43085a;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        if (f != null) {
            i = DisplayUtils.dip2px(getContext(), f.floatValue() / ((float) 2));
        } else {
            i = MathKt.roundToInt(getContext().getResources().getDimension(R.dimen.customer_4px));
        }
        homeBusinessGridConfig.setItemSpace(i);
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f43085a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setChildSpacing(homeBusinessGridConfig2.getItemSpace());
    }

    public final void setLineSpace(Float f) {
        float f2;
        HomeBusinessGridConfig homeBusinessGridConfig = this.f43085a;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        if (f != null) {
            f2 = (float) DisplayUtils.dip2px(getContext(), f.floatValue() / ((float) 2));
        } else {
            f2 = getContext().getResources().getDimension(R.dimen.customer_14px);
        }
        homeBusinessGridConfig.setLineSpace(f2);
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f43085a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setRowSpacing(homeBusinessGridConfig2.getLineSpace());
    }

    public final void setData(List<? extends PromptEntity> list, int i) {
        int i2 = i;
        removeAllViews();
        Collection collection = list;
        int i3 = 0;
        if (collection == null || collection.isEmpty()) {
            setVisibility(8);
            return;
        }
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        for (PromptEntity promptEntity : list) {
            int i6 = i4 + 1;
            if (promptEntity != null) {
                CharSequence charSequence = promptEntity.content;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    IconAndTextView iconAndTextView = new IconAndTextView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                    iconAndTextView.setData(promptEntity.icon, promptEntity.content, 1);
                    iconAndTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
                    if (iconAndTextView.getMeasuredWidth() + i5 + getChildSpacing() >= i2) {
                        int iconWidthAndMargin = (i2 - i5) - iconAndTextView.getIconWidthAndMargin();
                        if (iconAndTextView.hasEnoughSpaceShowContent(iconWidthAndMargin)) {
                            iconAndTextView.setVisibility(0);
                            iconAndTextView.setTextWidth(iconWidthAndMargin);
                            addView(iconAndTextView, layoutParams);
                            z = true;
                        } else {
                            iconAndTextView.setVisibility(8);
                        }
                        if (getMaxRows() <= 1) {
                            break;
                        }
                        i4 = i6;
                        i5 = 0;
                    } else {
                        int measuredWidth = i5 + iconAndTextView.getMeasuredWidth() + getChildSpacing();
                        addView(iconAndTextView, layoutParams);
                        HomeBusinessGridConfig homeBusinessGridConfig = this.f43085a;
                        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
                        if (homeBusinessGridConfig == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
                            homeBusinessGridConfig = null;
                        }
                        if (!Intrinsics.areEqual((Object) homeBusinessGridConfig.getDivider(), (Object) "dot") || i4 == list.size() - 1) {
                            HomeBusinessGridConfig homeBusinessGridConfig3 = this.f43085a;
                            if (homeBusinessGridConfig3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
                                homeBusinessGridConfig3 = null;
                            }
                            if (!Intrinsics.areEqual((Object) homeBusinessGridConfig3.getDivider(), (Object) DIVIDER_SPACE_DOT) || i4 == list.size() - 1) {
                                i5 = measuredWidth;
                            } else {
                                HomeBusinessGridConfig homeBusinessGridConfig4 = this.f43085a;
                                if (homeBusinessGridConfig4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
                                } else {
                                    homeBusinessGridConfig2 = homeBusinessGridConfig4;
                                }
                                i5 = homeBusinessGridConfig2.getShowDividerIndex() <= i4 ? m30491a("·", DIVIDER_SPACE_DOT, layoutParams, measuredWidth, iconAndTextView.getMeasuredHeight()) : m30491a(" ", DIVIDER_SPACE_DOT, layoutParams, measuredWidth, iconAndTextView.getMeasuredHeight());
                            }
                        } else {
                            i5 = m30491a("·", "dot", layoutParams, measuredWidth, iconAndTextView.getMeasuredHeight());
                        }
                        i4 = i6;
                        z = true;
                    }
                }
            }
            i4 = i6;
        }
        if (z) {
            m30493b();
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    /* renamed from: a */
    private final int m30491a(String str, String str2, ViewGroup.LayoutParams layoutParams, int i, int i2) {
        View inflate = View.inflate(getContext(), R.layout.customer_layout_home_business_grid_divider, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.customer_custom_business_divider_content);
        int measureText = i + ((int) textView.getPaint().measureText(str)) + getChildSpacing();
        textView.setText(str);
        inflate.setTag(str2);
        layoutParams.height = i2;
        addView(inflate, layoutParams);
        return measureText;
    }

    /* renamed from: b */
    private final void m30493b() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) childAt;
                if (Intrinsics.areEqual(frameLayout.getTag(), (Object) "dot") || Intrinsics.areEqual(frameLayout.getTag(), (Object) DIVIDER_SPACE_DOT)) {
                    frameLayout.setVisibility(8);
                }
            }
        }
    }
}
