package com.didi.payment.commonsdk.utils;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "dm", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "mKeyBoardListen", "Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener$KeyBoardListener;", "mOriginHeight", "", "mPreHeight", "getRootView", "()Landroid/view/View;", "softKeyboardHeight", "onGlobalLayout", "", "setKeyBoardListener", "keyBoardListen", "KeyBoardListener", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NKeyboardChangeListener.kt */
public final class NKeyboardChangeListener implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final View f30199a;

    /* renamed from: b */
    private int f30200b;

    /* renamed from: c */
    private int f30201c;

    /* renamed from: d */
    private KeyBoardListener f30202d;

    /* renamed from: e */
    private final DisplayMetrics f30203e;

    /* renamed from: f */
    private final int f30204f;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener$KeyBoardListener;", "", "onKeyboardChange", "", "isShow", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NKeyboardChangeListener.kt */
    public interface KeyBoardListener {
        void onKeyboardChange(boolean z);
    }

    public NKeyboardChangeListener(View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.f30199a = view;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.f30203e = displayMetrics;
        this.f30204f = displayMetrics.heightPixels / 4;
    }

    public final View getRootView() {
        return this.f30199a;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f30199a.getWindowVisibleDisplayFrame(rect);
        if (this.f30199a.getBottom() - rect.bottom > this.f30204f) {
            KeyBoardListener keyBoardListener = this.f30202d;
            Intrinsics.checkNotNull(keyBoardListener);
            keyBoardListener.onKeyboardChange(true);
            return;
        }
        KeyBoardListener keyBoardListener2 = this.f30202d;
        Intrinsics.checkNotNull(keyBoardListener2);
        keyBoardListener2.onKeyboardChange(false);
    }

    public final void setKeyBoardListener(KeyBoardListener keyBoardListener) {
        Intrinsics.checkNotNullParameter(keyBoardListener, "keyBoardListen");
        this.f30202d = keyBoardListener;
    }
}
