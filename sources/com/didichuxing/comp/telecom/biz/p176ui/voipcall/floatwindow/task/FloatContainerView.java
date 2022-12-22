package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.task;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/FloatContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customTouchListener", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/CustomTouchCallback;", "getCustomTouchListener", "()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/CustomTouchCallback;", "setCustomTouchListener", "(Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/CustomTouchCallback;)V", "lastX", "", "lastY", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.task.FloatContainerView */
/* compiled from: FloatContaninerView.kt */
public final class FloatContainerView extends FrameLayout {

    /* renamed from: a */
    private CustomTouchCallback f46342a;

    /* renamed from: b */
    private int f46343b;

    /* renamed from: c */
    private int f46344c;

    public FloatContainerView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatContainerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public final CustomTouchCallback getCustomTouchListener() {
        return this.f46342a;
    }

    public final void setCustomTouchListener(CustomTouchCallback customTouchCallback) {
        this.f46342a = customTouchCallback;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "ev");
        if (motionEvent.getAction() == 0) {
            this.f46343b = (int) motionEvent.getRawX();
            this.f46344c = (int) motionEvent.getRawY();
            CustomTouchCallback customTouchCallback = this.f46342a;
            if (customTouchCallback != null) {
                customTouchCallback.onTouch(this, motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "ev");
        if (motionEvent.getAction() == 2) {
            int rawX = ((int) motionEvent.getRawX()) - this.f46343b;
            int rawY = ((int) motionEvent.getRawY()) - this.f46344c;
            int touchSlop = ViewConfiguration.getTouchSlop();
            if (rawX >= touchSlop || rawY >= touchSlop) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "ev");
        CustomTouchCallback customTouchCallback = this.f46342a;
        return customTouchCallback != null ? customTouchCallback.onTouch(this, motionEvent) : super.onTouchEvent(motionEvent);
    }
}
