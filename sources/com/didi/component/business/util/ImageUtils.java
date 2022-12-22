package com.didi.component.business.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

public class ImageUtils {
    public static final void glideLoad(Context context, String str, ImageView imageView) {
        if (context != null && !TextUtils.isEmpty(str) && imageView != null) {
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(context).asBitmap().load(str).into(imageView);
            }
        }
    }

    public static final void glideLoad(Context context, String str, ImageView imageView, int i) {
        if (context != null && !TextUtils.isEmpty(str) && imageView != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                    return;
                }
            }
            ((RequestBuilder) ((RequestBuilder) Glide.with(context).asBitmap().load(str).placeholder(i)).error(i)).into(imageView);
        }
    }
}
