package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.task.CustomTouchCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/FloatWindowHelper$configWindowView$1", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/CustomTouchCallback;", "downTime", "", "isDraged", "", "lastX", "", "lastY", "onTouch", "v", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.FloatWindowHelper$configWindowView$1 */
/* compiled from: FloatWindowHelper.kt */
public final class FloatWindowHelper$configWindowView$1 implements CustomTouchCallback {
    final /* synthetic */ WindowManager.LayoutParams $lp;
    final /* synthetic */ CallFloatWindowLayoutParams $params;
    final /* synthetic */ Ref.IntRef $screenWidth;
    private long downTime;
    private boolean isDraged;
    private int lastX;
    private int lastY;
    final /* synthetic */ FloatWindowHelper this$0;

    FloatWindowHelper$configWindowView$1(FloatWindowHelper floatWindowHelper, WindowManager.LayoutParams layoutParams, Ref.IntRef intRef, CallFloatWindowLayoutParams callFloatWindowLayoutParams) {
        this.this$0 = floatWindowHelper;
        this.$lp = layoutParams;
        this.$screenWidth = intRef;
        this.$params = callFloatWindowLayoutParams;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i = 0;
        if (view == null || motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastX = (int) motionEvent.getRawX();
            this.lastY = (int) motionEvent.getRawY();
            this.downTime = System.currentTimeMillis();
            this.isDraged = false;
        } else if (action == 1) {
            if (System.currentTimeMillis() - this.downTime < ((long) ViewConfiguration.getTapTimeout())) {
                view.performClick();
                this.isDraged = false;
            } else {
                this.isDraged = true;
            }
            if (this.$screenWidth.element != 0) {
                if (this.lastX > this.$screenWidth.element / 2) {
                    this.$lp.x = this.$screenWidth.element - view.getWidth();
                } else {
                    this.$lp.x = 0;
                }
                CallFloatWindowCallback callBack = this.$params.getCallBack();
                if (callBack != null) {
                    callBack.onLocationChanged(this.$lp.x, this.$lp.y);
                }
                WindowManager access$getWindowManager$p = this.this$0.f46325a;
                if (access$getWindowManager$p != null) {
                    access$getWindowManager$p.updateViewLayout(view, this.$lp);
                }
            }
        } else if (action == 2) {
            int rawX = ((int) motionEvent.getRawX()) - this.lastX;
            int rawY = ((int) motionEvent.getRawY()) - this.lastY;
            int left = view.getLeft() + rawX;
            int right = view.getRight() + rawX;
            int top = view.getTop() + rawY;
            int bottom = view.getBottom() + rawY;
            if (left < 0) {
                right = view.getWidth();
                left = 0;
            }
            if (top < 0) {
                bottom = view.getHeight();
            } else {
                i = top;
            }
            view.layout(left, i, right, bottom);
            this.lastX = (int) motionEvent.getRawX();
            this.lastY = (int) motionEvent.getRawY();
            this.$lp.x = this.lastX - (view.getWidth() / 2);
            this.$lp.y = this.lastY - (view.getHeight() / 2);
            WindowManager access$getWindowManager$p2 = this.this$0.f46325a;
            if (access$getWindowManager$p2 != null) {
                access$getWindowManager$p2.updateViewLayout(view, this.$lp);
            }
        }
        return this.isDraged;
    }
}
