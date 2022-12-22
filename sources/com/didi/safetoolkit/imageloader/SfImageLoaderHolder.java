package com.didi.safetoolkit.imageloader;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.collection.SparseArrayCompat;
import java.lang.ref.WeakReference;

public class SfImageLoaderHolder {

    /* renamed from: a */
    private static SparseArrayCompat<WeakReference<ISfImageLoader>> f34521a = new SparseArrayCompat<>();

    /* renamed from: b */
    private static final ISfImageLoader f34522b = new SfImageLoaderStub();

    public static ISfImageLoader getInstance(Context context) {
        if (context == null || ((context instanceof Activity) && !m24379a((Activity) context))) {
            return f34522b;
        }
        int hashCode = context.hashCode();
        WeakReference weakReference = f34521a.get(hashCode);
        ISfImageLoader iSfImageLoader = weakReference != null ? (ISfImageLoader) weakReference.get() : null;
        if (iSfImageLoader != null) {
            return iSfImageLoader;
        }
        C11774a aVar = new C11774a(context);
        f34521a.put(hashCode, new WeakReference(aVar));
        return aVar;
    }

    /* renamed from: a */
    private static boolean m24379a(Activity activity) {
        return activity != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed());
    }

    private static class SfImageLoaderStub implements ISfImageLoader {
        public void cancel(Object obj) {
        }

        public void loadInto(Object obj, View view) {
        }

        public void loadInto(Object obj, View view, int i) {
        }

        private SfImageLoaderStub() {
        }
    }
}
