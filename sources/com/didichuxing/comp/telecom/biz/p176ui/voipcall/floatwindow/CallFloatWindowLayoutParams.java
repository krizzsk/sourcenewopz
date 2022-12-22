package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow;

import android.view.WindowManager;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/CallFloatWindowLayoutParams;", "", "()V", "alignEnd", "", "getAlignEnd", "()Z", "setAlignEnd", "(Z)V", "cacheX", "", "getCacheX", "()Ljava/lang/Integer;", "setCacheX", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cacheY", "getCacheY", "setCacheY", "callBack", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/CallFloatWindowCallback;", "getCallBack", "()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/CallFloatWindowCallback;", "setCallBack", "(Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/CallFloatWindowCallback;)V", "lp", "Landroid/view/WindowManager$LayoutParams;", "getLp", "()Landroid/view/WindowManager$LayoutParams;", "setLp", "(Landroid/view/WindowManager$LayoutParams;)V", "hasLocationCache", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.CallFloatWindowLayoutParams */
/* compiled from: FloatWindowHelper.kt */
public final class CallFloatWindowLayoutParams {

    /* renamed from: a */
    private WindowManager.LayoutParams f46319a;

    /* renamed from: b */
    private Integer f46320b;

    /* renamed from: c */
    private Integer f46321c;

    /* renamed from: d */
    private boolean f46322d;

    /* renamed from: e */
    private CallFloatWindowCallback f46323e;

    public final WindowManager.LayoutParams getLp() {
        return this.f46319a;
    }

    public final void setLp(WindowManager.LayoutParams layoutParams) {
        this.f46319a = layoutParams;
    }

    public final Integer getCacheX() {
        return this.f46320b;
    }

    public final void setCacheX(Integer num) {
        this.f46320b = num;
    }

    public final Integer getCacheY() {
        return this.f46321c;
    }

    public final void setCacheY(Integer num) {
        this.f46321c = num;
    }

    public final boolean getAlignEnd() {
        return this.f46322d;
    }

    public final void setAlignEnd(boolean z) {
        this.f46322d = z;
    }

    public final CallFloatWindowCallback getCallBack() {
        return this.f46323e;
    }

    public final void setCallBack(CallFloatWindowCallback callFloatWindowCallback) {
        this.f46323e = callFloatWindowCallback;
    }

    public final boolean hasLocationCache() {
        return (this.f46320b == null && this.f46321c == null) ? false : true;
    }
}
