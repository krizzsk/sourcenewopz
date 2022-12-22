package com.didi.dimina.container.secondparty.permission;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.checker.DoubleChecker;
import com.didi.dimina.container.secondparty.permission.checker.PermissionChecker;
import com.didi.dimina.container.secondparty.permission.option.Option;
import com.didi.dimina.container.secondparty.permission.source.ActivitySource;
import com.didi.dimina.container.secondparty.permission.source.ContextSource;
import com.didi.dimina.container.secondparty.permission.source.FragmentSource;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.dimina.container.secondparty.permission.source.SupportFragmentSource;
import java.io.File;
import java.util.List;

public class AndPermission {

    /* renamed from: a */
    private static final PermissionChecker f17308a = new DoubleChecker();

    public static Option with(Context context) {
        return new Boot(m12857a(context));
    }

    public static Option with(Fragment fragment) {
        return new Boot(new SupportFragmentSource(fragment));
    }

    public static Option with(android.app.Fragment fragment) {
        return new Boot(new FragmentSource(fragment));
    }

    public static Option with(Activity activity) {
        return new Boot(new ActivitySource(activity));
    }

    public static boolean hasAlwaysDeniedPermission(Context context, List<String> list) {
        return m12858a(m12857a(context), list);
    }

    public static boolean hasAlwaysDeniedPermission(Fragment fragment, List<String> list) {
        return m12858a((Source) new SupportFragmentSource(fragment), list);
    }

    public static boolean hasAlwaysDeniedPermission(android.app.Fragment fragment, List<String> list) {
        return m12858a((Source) new FragmentSource(fragment), list);
    }

    public static boolean hasAlwaysDeniedPermission(Activity activity, List<String> list) {
        return m12858a((Source) new ActivitySource(activity), list);
    }

    /* renamed from: a */
    private static boolean m12858a(Source source, List<String> list) {
        for (String isShowRationalePermission : list) {
            if (!source.isShowRationalePermission(isShowRationalePermission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAlwaysDeniedPermission(Context context, String... strArr) {
        return m12859a(m12857a(context), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(Fragment fragment, String... strArr) {
        return m12859a((Source) new SupportFragmentSource(fragment), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(android.app.Fragment fragment, String... strArr) {
        return m12859a((Source) new FragmentSource(fragment), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(Activity activity, String... strArr) {
        return m12859a((Source) new ActivitySource(activity), strArr);
    }

    /* renamed from: a */
    private static boolean m12859a(Source source, String... strArr) {
        for (String isShowRationalePermission : strArr) {
            if (!source.isShowRationalePermission(isShowRationalePermission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPermissions(Context context, String... strArr) {
        return f17308a.hasPermission(context, strArr);
    }

    public static boolean hasPermissions(Fragment fragment, String... strArr) {
        return hasPermissions((Activity) fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(android.app.Fragment fragment, String... strArr) {
        return hasPermissions(fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(Activity activity, String... strArr) {
        return f17308a.hasPermission((Context) activity, strArr);
    }

    public static boolean hasPermissions(Context context, String[]... strArr) {
        for (String[] hasPermission : strArr) {
            if (!f17308a.hasPermission(context, hasPermission)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasPermissions(Fragment fragment, String[]... strArr) {
        return hasPermissions((Activity) fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(android.app.Fragment fragment, String[]... strArr) {
        return hasPermissions(fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(Activity activity, String[]... strArr) {
        for (String[] hasPermission : strArr) {
            if (!f17308a.hasPermission((Context) activity, hasPermission)) {
                return false;
            }
        }
        return true;
    }

    public static Uri getFileUri(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context) + ".file.path.share", file);
    }

    public static Uri getFileUri(Fragment fragment, File file) {
        return getFileUri(fragment.getContext(), file);
    }

    public static Uri getFileUri(android.app.Fragment fragment, File file) {
        return getFileUri(fragment.getActivity(), file);
    }

    public static Uri getFileUri(Activity activity, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(activity, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(activity) + ".file.path.share", file);
    }

    /* renamed from: a */
    private static Source m12857a(Context context) {
        if (context instanceof Activity) {
            return new ActivitySource((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            return m12857a(((ContextWrapper) context).getBaseContext());
        }
        return new ContextSource(context);
    }

    private AndPermission() {
    }
}
