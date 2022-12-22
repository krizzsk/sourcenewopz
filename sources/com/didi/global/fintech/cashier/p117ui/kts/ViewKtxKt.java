package com.didi.global.fintech.cashier.p117ui.kts;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0007\u001a\u00020\b*\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\f\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000f\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011\u001a\u0012\u0010\u0014\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0012\u0010\u0014\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011\u001a\u0014\u0010\u0015\u001a\u00020\b*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u001a\u0012\u0010\u0018\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0011\u001a\u0012\u0010\u001a\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0011\"*\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, mo175978d2 = {"value", "", "isVisible", "Landroid/view/View;", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "click", "", "duration", "", "block", "Lkotlin/Function1;", "content", "Landroid/widget/TextView;", "", "dp2px", "", "dp", "", "dp2pxF", "load", "Landroid/widget/ImageView;", "url", "sp2px", "sp", "sp2pxF", "cashier_ui_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.kts.ViewKtxKt */
/* compiled from: ViewKtx.kt */
public final class ViewKtxKt {
    public static final float dp2pxF(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return ContextKtxKt.dp2pxF(context, f);
    }

    public static final float dp2pxF(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return ContextKtxKt.dp2pxF(context, i);
    }

    public static final int dp2px(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return ContextKtxKt.dp2px(context, f);
    }

    public static final int dp2px(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return ContextKtxKt.dp2px(context, i);
    }

    public static final int sp2px(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return ContextKtxKt.sp2px(context, i);
    }

    public static final float sp2pxF(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return ContextKtxKt.sp2pxF(context, i);
    }

    public static /* synthetic */ void click$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 3000;
        }
        click(view, j, function1);
    }

    public static final void click(View view, long j, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (function1 == null) {
            view.setOnClickListener((View.OnClickListener) null);
        } else {
            view.setOnClickListener(new ViewKtxKt$click$1(function1, j));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if ((r4.length() > 0) == true) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void content(android.widget.TextView r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x000b
        L_0x0009:
            r0 = 0
            goto L_0x0019
        L_0x000b:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 != r0) goto L_0x0009
        L_0x0019:
            r2 = 0
            if (r0 == 0) goto L_0x001e
            r0 = r3
            goto L_0x001f
        L_0x001e:
            r0 = r2
        L_0x001f:
            if (r0 != 0) goto L_0x0022
            goto L_0x002c
        L_0x0022:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            r3.setVisibility(r1)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x002c:
            if (r2 != 0) goto L_0x0033
            r4 = 8
            r3.setVisibility(r4)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.content(android.widget.TextView, java.lang.String):void");
    }

    public static final void load(ImageView imageView, String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str == null) {
            unit = null;
        } else {
            Glide.with((View) imageView).load(str).into(imageView);
            imageView.setVisibility(0);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            imageView.setVisibility(8);
        }
    }

    public static final boolean isVisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final void setVisible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }
}
