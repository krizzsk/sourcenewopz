package com.didi.entrega.bill.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/bill/widgets/BillRecycleView;", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arr", "", "parentLocY", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "findTopChild", "Landroid/view/View;", "getTransparencyRect", "Landroid/graphics/Rect;", "getViewLocY", "view", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRecycleView.kt */
public final class BillRecycleView extends NovaRecyclerView {

    /* renamed from: a */
    private int[] f19606a;

    /* renamed from: b */
    private int f19607b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillRecycleView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillRecycleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f19606a = new int[2];
        this.f19607b = -1;
    }

    /* renamed from: a */
    private final View m14632a() {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        if (getChildCount() <= 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(0)) == null) {
            return null;
        }
        return findViewHolderForAdapterPosition.itemView;
    }

    private final Rect getTransparencyRect() {
        View a = m14632a();
        if (a == null) {
            return null;
        }
        if (this.f19607b < 0) {
            this.f19607b = m14631a(this);
        }
        int a2 = m14631a(a);
        if (a2 - this.f19607b <= 0) {
            return null;
        }
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = getWidth();
        rect.bottom = a2 - this.f19607b;
        return rect;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() != 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        Rect transparencyRect = getTransparencyRect();
        if (transparencyRect == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (transparencyRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private final int m14631a(View view) {
        view.getLocationOnScreen(this.f19606a);
        return this.f19606a[1];
    }
}
