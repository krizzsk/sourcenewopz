package com.didi.soda.customer.blocks.widget.binder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.didi.soda.blocks.style.BlockLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/binder/BlockLayoutWrap;", "Lcom/didi/soda/blocks/style/BlockLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkForPress", "Ljava/lang/Runnable;", "maskDrawable", "Landroid/graphics/drawable/GradientDrawable;", "maskIsPressed", "", "cancelLongPress", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onWindowFocusChanged", "hasWindowFocus", "removeCheckForPressCallback", "setMaskColor", "maskColor", "", "setMaskRadius", "radius", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TouchableMaskBinder.kt */
final class BlockLayoutWrap extends BlockLayout {

    /* renamed from: a */
    private boolean f40753a;

    /* renamed from: b */
    private final GradientDrawable f40754b;

    /* renamed from: c */
    private final Runnable f40755c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BlockLayoutWrap(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    public void mo102643a() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlockLayoutWrap(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlockLayoutWrap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40754b = new GradientDrawable();
        this.f40755c = new Runnable() {
            public final void run() {
                BlockLayoutWrap.m28928a(BlockLayoutWrap.this);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28928a(BlockLayoutWrap blockLayoutWrap) {
        Intrinsics.checkNotNullParameter(blockLayoutWrap, "this$0");
        blockLayoutWrap.f40753a = true;
        blockLayoutWrap.invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.f40753a) {
            this.f40754b.setBounds(0, 0, getWidth(), getHeight());
            this.f40754b.draw(canvas);
        }
    }

    public final void setMaskColor(int i) {
        this.f40754b.setColor(i);
    }

    public final void setMaskRadius(float f) {
        this.f40754b.setCornerRadius(f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            postDelayed(this.f40755c, (long) ViewConfiguration.getTapTimeout());
        } else if (action == 1 || action == 3) {
            if (this.f40753a) {
                this.f40753a = false;
                invalidate();
            }
            m28929b();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m28929b();
    }

    public void cancelLongPress() {
        super.cancelLongPress();
        m28929b();
    }

    /* renamed from: b */
    private final void m28929b() {
        removeCallbacks(this.f40755c);
    }
}
