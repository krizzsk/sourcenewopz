package com.didi.payment.base.view;

import android.app.Activity;
import android.view.View;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;

public class PayGlobalLoading {
    public static void show(View view) {
        if (view != null && view.getContext() != null) {
            Loading.make(view.getContext(), view).show();
        }
    }

    public static void show(View view, int i) {
        if (view != null && view.getContext() != null) {
            Loading.make(view.getContext(), LoadingRenderType.ANIMATION, view, i).show();
        }
    }

    public static void show(View view, boolean z) {
        if (view != null && view.getContext() != null) {
            Loading.make(view.getContext(), LoadingRenderType.ANIMATION, view, z).show();
        }
    }

    public static void show(View view, LoadingConfig loadingConfig) {
        if (view != null && view.getContext() != null && loadingConfig != null) {
            Loading.make(view.getContext(), view, loadingConfig).show();
        }
    }

    public static void show(Activity activity, int i) {
        if (activity != null) {
            show(activity.findViewById(i));
        }
    }

    public static void show(Activity activity, int i, int i2) {
        if (activity != null) {
            show(activity.findViewById(i), i2);
        }
    }

    public static void show(Activity activity, int i, boolean z) {
        if (activity != null) {
            show(activity.findViewById(i), z);
        }
    }

    public static void show(Activity activity, int i, LoadingConfig loadingConfig) {
        if (activity != null) {
            show(activity.findViewById(i), loadingConfig);
        }
    }

    public static void hide() {
        Loading.hide();
    }

    public static void hide(View view) {
        Loading.hide(view);
    }
}
