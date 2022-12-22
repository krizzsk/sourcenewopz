package com.didichuxing.drtl.tookit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\n\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\b\u0001\u0010\t\u001a\u00020\n¨\u0006\r"}, mo175978d2 = {"setSrc", "", "Landroid/widget/ImageView;", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "", "setViewBackground", "Landroid/view/View;", "drtl_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: BitmapSetter.kt */
public final class BitmapSetterKt {
    public static final void setViewBackground(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setViewBackground");
        if (DRtlToolkit.rtl()) {
            Context context = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            view.setBackground(DRtlToolkit.getAutoMirroredDrawable(context, i));
            return;
        }
        view.setBackgroundResource(i);
    }

    public static final void setViewBackground(View view, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setViewBackground");
        if (drawable != null) {
            DrtlViewExKt.autoMirrored(drawable);
        }
        view.setBackground(drawable);
    }

    public static final void setSrc(ImageView imageView, int i) {
        Intrinsics.checkParameterIsNotNull(imageView, "$this$setSrc");
        if (DRtlToolkit.rtl()) {
            Context context = imageView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            imageView.setImageDrawable(DRtlToolkit.getAutoMirroredDrawable(context, i));
            return;
        }
        imageView.setImageResource(i);
    }

    public static final void setSrc(ImageView imageView, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(imageView, "$this$setSrc");
        if (drawable != null) {
            DrtlViewExKt.autoMirrored(drawable);
        }
        imageView.setImageDrawable(drawable);
    }

    public static /* synthetic */ void setSrc$default(ImageView imageView, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        setSrc(imageView, bitmap, z);
    }

    public static final void setSrc(ImageView imageView, Bitmap bitmap, boolean z) {
        Intrinsics.checkParameterIsNotNull(imageView, "$this$setSrc");
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        if (DRtlToolkit.rtl()) {
            imageView.setImageBitmap(DRtlToolkit.bitmapMirror(bitmap, z));
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }
}
