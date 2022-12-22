package com.didi.entrega.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J0\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/entrega/bill/widgets/BillPhoneLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "primaryView", "Landroid/view/View;", "addView", "", "child", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "checkNeedMeasure", "", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPhoneLayout.kt */
public final class BillPhoneLayout extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String targetTag = "primaryView";

    /* renamed from: a */
    private View f19605a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPhoneLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPhoneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillPhoneLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPhoneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Object obj;
        super.addView(view, i, layoutParams);
        if (view == null) {
            obj = null;
        } else {
            obj = view.getTag();
        }
        if (Intrinsics.areEqual(obj, (Object) targetTag)) {
            this.f19605a = view;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        if (childCount > 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i5 + 1;
                View childAt = getChildAt(i5);
                childAt.layout(i6, 0, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + 0);
                i6 += childAt.getMeasuredWidth();
                if (i7 < childCount) {
                    i5 = i7;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m14630a() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (getChildAt(i).getVisibility() == 8) {
                    return false;
                }
                if (i2 >= childCount) {
                    break;
                }
                i = i2;
            }
        }
        if (this.f19605a == null || getChildCount() != 2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int childCount;
        super.onMeasure(i, i2);
        if (m14630a()) {
            int size = View.MeasureSpec.getSize(i);
            int childCount2 = getChildCount();
            int i4 = 0;
            if (childCount2 > 0) {
                int i5 = 0;
                i3 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    i3 += getChildAt(i5).getMeasuredWidth();
                    if (i6 >= childCount2) {
                        break;
                    }
                    i5 = i6;
                }
            } else {
                i3 = 0;
            }
            if (i3 > size && (childCount = getChildCount()) > 0) {
                while (true) {
                    int i7 = i4 + 1;
                    View childAt = getChildAt(i4);
                    if (!Intrinsics.areEqual((Object) childAt, (Object) this.f19605a)) {
                        View view = this.f19605a;
                        Intrinsics.checkNotNull(view);
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(size - view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                    }
                    if (i7 < childCount) {
                        i4 = i7;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/bill/widgets/BillPhoneLayout$Companion;", "", "()V", "targetTag", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillPhoneLayout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
