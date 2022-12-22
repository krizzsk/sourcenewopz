package com.didiglobal.travel.infra.content;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0002H\u0007\u001a&\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0002\u001a.\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0002\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a-\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"color", "", "Landroid/content/res/Resources;", "id", "theme", "Landroid/content/res/Resources$Theme;", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableForDensity", "density", "string", "", "formatArgs", "", "", "(Landroid/content/res/Resources;I[Ljava/lang/Object;)Ljava/lang/String;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Resources.kt */
public final class ResourcesKt {
    public static /* synthetic */ int color$default(Resources resources, int i, Resources.Theme theme, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            theme = null;
        }
        return color(resources, i, theme);
    }

    public static final int color(Resources resources, int i, Resources.Theme theme) {
        Intrinsics.checkParameterIsNotNull(resources, "$this$color");
        try {
            return ResourcesCompat.getColor(resources, i, theme);
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    public static /* synthetic */ Drawable drawable$default(Resources resources, int i, Resources.Theme theme, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            theme = null;
        }
        return drawable(resources, i, theme);
    }

    public static final Drawable drawable(Resources resources, int i, Resources.Theme theme) {
        Intrinsics.checkParameterIsNotNull(resources, "$this$drawable");
        try {
            return ResourcesCompat.getDrawable(resources, i, theme);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static /* synthetic */ Drawable drawableForDensity$default(Resources resources, int i, int i2, Resources.Theme theme, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            theme = null;
        }
        return drawableForDensity(resources, i, i2, theme);
    }

    public static final Drawable drawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
        Intrinsics.checkParameterIsNotNull(resources, "$this$drawableForDensity");
        try {
            return ResourcesCompat.getDrawableForDensity(resources, i, i2, theme);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static final String string(Resources resources, int i) {
        Intrinsics.checkParameterIsNotNull(resources, "$this$string");
        try {
            String string = resources.getString(i);
            Intrinsics.checkExpressionValueIsNotNull(string, "this.getString(id)");
            return string;
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    public static final String string(Resources resources, int i, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(resources, "$this$string");
        Intrinsics.checkParameterIsNotNull(objArr, "formatArgs");
        try {
            String string = resources.getString(i, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "this.getString(id, *formatArgs)");
            return string;
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }
}
