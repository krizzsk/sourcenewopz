package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.content.res.Resources;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.rum.tracking.InteractionPredicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\n"}, mo175978d2 = {"idAsStringHexa", "", "id", "", "resolveTargetName", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "target", "", "resourceIdName", "dd-sdk-android_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GesturesUtils.kt */
public final class GesturesUtilsKt {
    public static final String resolveTargetName(InteractionPredicate interactionPredicate, Object obj) {
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(obj, "target");
        String targetName = interactionPredicate.getTargetName(obj);
        CharSequence charSequence = targetName;
        return !(charSequence == null || charSequence.length() == 0) ? targetName : "";
    }

    public static final String resourceIdName(int i) {
        try {
            Context context = (Context) CoreFeature.INSTANCE.getContextRef$dd_sdk_android_release().get();
            String str = null;
            if (context != null) {
                Resources resources = context.getResources();
                if (resources != null) {
                    str = resources.getResourceEntryName(i);
                }
            }
            if (str == null) {
                return m2495a(i);
            }
            return str;
        } catch (Resources.NotFoundException unused) {
            return m2495a(i);
        }
    }

    /* renamed from: a */
    private static final String m2495a(int i) {
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return Intrinsics.stringPlus("0x", num);
    }
}
