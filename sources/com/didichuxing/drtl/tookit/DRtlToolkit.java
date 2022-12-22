package com.didichuxing.drtl.tookit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rui.config.RConfigConstants;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007¨\u0006\u000f"}, mo175978d2 = {"Lcom/didichuxing/drtl/tookit/DRtlToolkit;", "", "()V", "bitmapMirror", "Landroid/graphics/Bitmap;", "bitmap", "recycle", "", "getAutoMirroredDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawableRes", "", "rtl", "drtl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DRtlToolkit.kt */
public final class DRtlToolkit {
    public static final DRtlToolkit INSTANCE = new DRtlToolkit();

    private DRtlToolkit() {
    }

    @JvmStatic
    public static final boolean rtl() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    @JvmStatic
    public static final Drawable getAutoMirroredDrawable(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Drawable drawable = context.getResources().getDrawable(i);
        DrtlViewExKt.autoMirrored(drawable);
        Intrinsics.checkExpressionValueIsNotNull(drawable, RConfigConstants.TYPE_DRAWABLE);
        return drawable;
    }

    public static /* synthetic */ Bitmap bitmapMirror$default(Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return bitmapMirror(bitmap, z);
    }

    @JvmStatic
    public static final Bitmap bitmapMirror(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "createBitmap");
        createBitmap.setDensity(bitmap.getDensity());
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
