package com.datadog.android.core.internal.utils;

import android.content.ComponentName;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"UNKNOWN_DESTINATION_URL", "", "resolveViewUrl", "Landroid/content/ComponentName;", "", "dd-sdk-android_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtilsKt {
    public static final String UNKNOWN_DESTINATION_URL = "Unknown";

    public static final String resolveViewUrl(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof FragmentNavigator.Destination) {
            String className = ((FragmentNavigator.Destination) obj).getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "className");
            return className;
        } else if (obj instanceof DialogFragmentNavigator.Destination) {
            String className2 = ((DialogFragmentNavigator.Destination) obj).getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "className");
            return className2;
        } else if (obj instanceof ActivityNavigator.Destination) {
            ComponentName component = ((ActivityNavigator.Destination) obj).getComponent();
            return component == null ? "Unknown" : resolveViewUrl(component);
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            String canonicalName = obj.getClass().getCanonicalName();
            String simpleName = canonicalName == null ? obj.getClass().getSimpleName() : canonicalName;
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.canonicalName ?: javaClass.simpleName");
            return simpleName;
        }
    }

    public static final String resolveViewUrl(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "<this>");
        String className = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "className");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        if (StringsKt.startsWith$default(className, packageName, false, 2, (Object) null)) {
            String className2 = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "className");
            return className2;
        }
        String className3 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className3, "className");
        if (StringsKt.contains$default((CharSequence) className3, '.', false, 2, (Object) null)) {
            String className4 = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className4, "className");
            return className4;
        }
        return componentName.getPackageName() + '.' + componentName.getClassName();
    }
}
