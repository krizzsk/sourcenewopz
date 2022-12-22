package com.didi.map.global.flow.scene.order.bluetooth_meet;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.DiDiTypeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n\u001a\f\u0010\u0010\u001a\u00020\u0006*\u0004\u0018\u00010\b\u001a\u0014\u0010\u0011\u001a\u00020\u0006*\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\f\u0010\u0014\u001a\u00020\u0006*\u0004\u0018\u00010\b¨\u0006\u0015"}, mo175978d2 = {"dp2px", "", "context", "Landroid/content/Context;", "dp", "setViewTouchDelegate", "", "view", "Landroid/view/View;", "expandTouchWidth", "", "bindUrl", "Landroid/widget/ImageView;", "url", "", "defaultResId", "gone", "setDidiTypeFont", "font", "Lcom/didiglobal/font/DiDiTypeface;", "show", "sdk-mapflow_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewExt.kt */
public final class ViewExtKt {
    public static final void show(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public static final void gone(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static final void setDidiTypeFont(View view, DiDiTypeface diDiTypeface) {
        Intrinsics.checkNotNullParameter(diDiTypeface, "font");
        if (view != null) {
            DIDIFontUtils.Companion.setTypeface(view.getContext(), (Object) view, diDiTypeface);
        }
    }

    public static /* synthetic */ void bindUrl$default(ImageView imageView, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        bindUrl(imageView, str, i);
    }

    public static final void bindUrl(ImageView imageView, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, "url");
        Glide.with(imageView.getContext()).asBitmap().load(str).into(new ViewExtKt$bindUrl$1(imageView, i));
    }

    public static final void setViewTouchDelegate(View view, int i) {
        ViewGroup viewGroup = null;
        ViewParent parent = view == null ? null : view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable(i, viewGroup) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ ViewGroup f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    ViewExtKt.m18789a(View.this, this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18789a(View view, int i, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "$parentView");
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i;
        rect.left -= i;
        rect.right += i;
        viewGroup.setTouchDelegate(new TouchDelegate(rect, view));
    }

    public static final float dp2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }
}
