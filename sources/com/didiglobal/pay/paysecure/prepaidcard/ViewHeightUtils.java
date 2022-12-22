package com.didiglobal.pay.paysecure.prepaidcard;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/ViewHeightUtils;", "", "viewObserving", "Landroid/view/View;", "(Landroid/view/View;)V", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "mObservedView", "usableHPrevious", "", "computeUsableHeight", "resetLayoutByUsableHeight", "", "usableHeight", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ViewHeightUtils.kt */
public final class ViewHeightUtils {

    /* renamed from: a */
    private View f50403a;

    /* renamed from: b */
    private int f50404b;

    /* renamed from: c */
    private ViewGroup.LayoutParams f50405c;

    public ViewHeightUtils(View view) {
        Intrinsics.checkParameterIsNotNull(view, "viewObserving");
        this.f50403a = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
            final /* synthetic */ ViewHeightUtils this$0;

            {
                this.this$0 = r1;
            }

            public final void onGlobalLayout() {
                ViewHeightUtils viewHeightUtils = this.this$0;
                viewHeightUtils.m36256a(viewHeightUtils.m36255a());
            }
        });
        ViewGroup.LayoutParams layoutParams = this.f50403a.getLayoutParams();
        Intrinsics.checkExpressionValueIsNotNull(layoutParams, "mObservedView.layoutParams");
        this.f50405c = layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36256a(int i) {
        if (i != this.f50404b) {
            this.f50405c.height = i;
            this.f50403a.requestLayout();
            this.f50404b = i;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m36255a() {
        Rect rect = new Rect();
        this.f50403a.getLocalVisibleRect(rect);
        SystemUtils.log(4, "benzhang", rect.bottom + " | " + this.f50403a.getHeight(), (Throwable) null, "com.didiglobal.pay.paysecure.prepaidcard.ViewHeightUtils", 34);
        return 0;
    }
}
