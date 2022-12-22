package com.didi.app.nova.skeleton.image;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.image.glide.SkeletonGlide;
import com.didi.app.nova.skeleton.image.performance.ImagePerformance;
import com.didi.app.nova.skeleton.image.performance.ImagePerformanceListener;

public class Fly {

    /* renamed from: a */
    private static Context f8442a;

    /* renamed from: b */
    private static ImagePerformanceListener f8443b;

    public static void setup(Context context) {
        Context applicationContext = context.getApplicationContext();
        f8442a = applicationContext;
        SkeletonGlide.setup(applicationContext);
    }

    public static void setmImagePerformanceListener(ImagePerformanceListener imagePerformanceListener) {
        f8443b = imagePerformanceListener;
    }

    public static SKRequestManager with(Context context) {
        return new SKRequestManager(context);
    }

    public static SKRequestManager with(Activity activity) {
        return new SKRequestManager(activity);
    }

    public static SKRequestManager with(FragmentActivity fragmentActivity) {
        return new SKRequestManager(fragmentActivity);
    }

    public static SKRequestManager with(Fragment fragment) {
        return new SKRequestManager(fragment);
    }

    public static SKRequestManager with(ScopeContext scopeContext) {
        return new SKRequestManager(scopeContext);
    }

    /* renamed from: a */
    static void m5644a(ImagePerformance imagePerformance) {
        ImagePerformanceListener imagePerformanceListener = f8443b;
        if (imagePerformanceListener != null) {
            imagePerformanceListener.onImagePerformance(imagePerformance);
        }
    }

    public static void clear(View view) {
        Glide.with(f8442a).clear(view);
    }

    public static void clearMemory() {
        try {
            Glide.get(f8442a).clearMemory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearDiskCache() {
        try {
            Glide.get(f8442a).clearDiskCache();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
