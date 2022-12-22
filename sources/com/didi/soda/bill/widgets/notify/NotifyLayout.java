package com.didi.soda.bill.widgets.notify;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0012\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001cH\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001cH\u0002JG\u0010)\u001a\u00020%\"\u0004\b\u0000\u0010*\"\u0004\b\u0001\u0010+2\b\u0010,\u001a\u0004\u0018\u0001H*2\b\u0010-\u001a\u0004\u0018\u0001H+2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u00020%0/H\u0002¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0015J0\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0014J\u0018\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0014J\b\u0010;\u001a\u00020%H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/notify/NotifyLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "animatorListener", "com/didi/soda/bill/widgets/notify/NotifyLayout$animatorListener$1", "Lcom/didi/soda/bill/widgets/notify/NotifyLayout$animatorListener$1;", "isNoticing", "", "()Z", "setNoticing", "(Z)V", "mainContentView", "Landroid/view/View;", "notifyHolder", "Lcom/didi/soda/bill/widgets/notify/NotifyHolder;", "getNotifyHolder", "()Lcom/didi/soda/bill/widgets/notify/NotifyHolder;", "setNotifyHolder", "(Lcom/didi/soda/bill/widgets/notify/NotifyHolder;)V", "notifyView", "overlap", "", "cancelNoticing", "", "doNotice", "holder", "initAnimationView", "let", "T", "R", "t", "r", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "notice", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "releaseAnimationView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NotifyLayout.kt */
public final class NotifyLayout extends FrameLayout {

    /* renamed from: a */
    private View f39313a;

    /* renamed from: b */
    private View f39314b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f39315c = ((float) CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()));

    /* renamed from: d */
    private boolean f39316d;

    /* renamed from: e */
    private NotifyHolder f39317e;

    /* renamed from: f */
    private final Lazy f39318f = LazyKt.lazy(new NotifyLayout$animator$2(this));
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final NotifyLayout$animatorListener$1 f39319g = new NotifyLayout$animatorListener$1(this);

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotifyLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotifyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotifyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean isNoticing() {
        return this.f39316d;
    }

    public final void setNoticing(boolean z) {
        this.f39316d = z;
    }

    public final NotifyHolder getNotifyHolder() {
        return this.f39317e;
    }

    public final void setNotifyHolder(NotifyHolder notifyHolder) {
        this.f39317e = notifyHolder;
    }

    /* access modifiers changed from: private */
    public final ValueAnimator getAnimator() {
        Object value = this.f39318f.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-animator>(...)");
        return (ValueAnimator) value;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m27846a(this.f39314b, this.f39313a, new NotifyLayout$onMeasure$1(this));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m27846a(this.f39314b, this.f39313a, new NotifyLayout$onLayout$1(this));
    }

    /* renamed from: a */
    private final <T, R> void m27846a(T t, R r, Function2<? super T, ? super R, Unit> function2) {
        if (t != null && r != null) {
            function2.invoke(t, r);
        }
    }

    public final boolean notice() {
        if (this.f39316d || !isAttachedToWindow()) {
            return false;
        }
        if (this.f39313a == null && getChildCount() == 1) {
            this.f39313a = getChildAt(0);
        }
        NotifyHolder notifyHolder = this.f39317e;
        if (notifyHolder == null || !notifyHolder.isPrepared(new NotifyLayout$notice$1$prepared$1(this, notifyHolder))) {
            return false;
        }
        m27845a(notifyHolder);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27845a(NotifyHolder notifyHolder) {
        m27847b(notifyHolder);
        this.f39316d = true;
        if (getAnimator().isRunning()) {
            getAnimator().reverse();
        } else {
            getAnimator().start();
        }
    }

    /* renamed from: b */
    private final void m27847b(NotifyHolder notifyHolder) {
        if (this.f39314b == null) {
            View view = notifyHolder.getView(this);
            this.f39314b = view;
            addView(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27844a() {
        View view = this.f39314b;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewSafeHelper.safeRemoveView((ViewGroup) parent, view);
            }
        }
        this.f39314b = null;
        this.f39313a = null;
    }

    public final void cancelNoticing() {
        getAnimator().reverse();
        this.f39316d = false;
    }
}
