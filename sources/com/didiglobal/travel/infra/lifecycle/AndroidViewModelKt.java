package com.didiglobal.travel.infra.lifecycle;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.AndroidViewModel;
import com.didiglobal.travel.infra.content.ContextKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo175978d2 = {"appContext", "Landroid/content/Context;", "Landroidx/lifecycle/AndroidViewModel;", "getAppContext", "(Landroidx/lifecycle/AndroidViewModel;)Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "getResources", "(Landroidx/lifecycle/AndroidViewModel;)Landroid/content/res/Resources;", "getString", "", "resId", "", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: AndroidViewModel.kt */
public final class AndroidViewModelKt {
    public static final Context getAppContext(AndroidViewModel androidViewModel) {
        Intrinsics.checkParameterIsNotNull(androidViewModel, "$this$appContext");
        Application application = androidViewModel.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "getApplication()");
        return application;
    }

    public static final Resources getResources(AndroidViewModel androidViewModel) {
        Intrinsics.checkParameterIsNotNull(androidViewModel, "$this$resources");
        Application application = androidViewModel.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "getApplication<Application>()");
        Resources resources = application.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "getApplication<Application>().resources");
        return resources;
    }

    public static final String getString(AndroidViewModel androidViewModel, int i) {
        Intrinsics.checkParameterIsNotNull(androidViewModel, "$this$getString");
        Application application = androidViewModel.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "getApplication<Application>()");
        return ContextKt.stringOf(application, i);
    }
}
