package com.didiglobal.travel.infra.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u001c\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u000b\u001a\u0017\u0010\f\u001a\u0004\u0018\u00010\r\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u0002H\b\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a-\u0010\u000e\u001a\u00020\r*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, mo175978d2 = {"colorOf", "", "Landroid/content/Context;", "id", "dimenOf", "", "dimenSizeOf", "drawableOf", "Landroid/graphics/drawable/Drawable;", "getSysService", "T", "(Landroid/content/Context;)Ljava/lang/Object;", "getSysServiceName", "", "stringOf", "formatArgs", "", "", "(Landroid/content/Context;I[Ljava/lang/Object;)Ljava/lang/String;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Context.kt */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSysService(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getSysService");
        Intrinsics.reifiedOperationMarker(4, "T");
        return ContextCompat.getSystemService(context, Object.class);
    }

    public static final /* synthetic */ <T> String getSysServiceName(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getSysServiceName");
        Intrinsics.reifiedOperationMarker(4, "T");
        return ContextCompat.getSystemServiceName(context, Object.class);
    }

    public static final int colorOf(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$this$colorOf");
        try {
            return ResourcesCompat.getColor(context.getResources(), i, context.getTheme());
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    public static final float dimenOf(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$this$dimenOf");
        try {
            return context.getResources().getDimension(i);
        } catch (Resources.NotFoundException unused) {
            return 0.0f;
        }
    }

    public static final int dimenSizeOf(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$this$dimenSizeOf");
        try {
            return context.getResources().getDimensionPixelSize(i);
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    public static final Drawable drawableOf(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$this$drawableOf");
        return ContextCompat.getDrawable(context, i);
    }

    public static final String stringOf(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$this$stringOf");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return ResourcesKt.string(resources, i);
    }

    public static final String stringOf(Context context, int i, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(context, "$this$stringOf");
        Intrinsics.checkParameterIsNotNull(objArr, "formatArgs");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return ResourcesKt.string(resources, i, Arrays.copyOf(objArr, objArr.length));
    }
}
