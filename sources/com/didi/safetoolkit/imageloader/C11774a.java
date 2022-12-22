package com.didi.safetoolkit.imageloader;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.Target;
import java.io.File;

/* renamed from: com.didi.safetoolkit.imageloader.a */
/* compiled from: SfImageLoader */
class C11774a implements ISfImageLoader {

    /* renamed from: a */
    private RequestManager f34523a;

    /* renamed from: a */
    private static Object m24381a(Object obj) {
        return obj == null ? "" : obj;
    }

    public C11774a(Context context) {
        this.f34523a = Glide.with(context);
    }

    public void loadInto(Object obj, View view) {
        Object a = m24381a(obj);
        if (m24382a(view)) {
            try {
                if (view instanceof ImageView) {
                    m24380a(a, 0).into((ImageView) view);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void loadInto(Object obj, View view, int i) {
        Object a = m24381a(obj);
        if (m24382a(view)) {
            try {
                if (view instanceof ImageView) {
                    m24380a(a, i).into((ImageView) view);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void cancel(Object obj) {
        if (obj instanceof ImageView) {
            this.f34523a.clear((View) (ImageView) obj);
        } else if (obj instanceof Target) {
            this.f34523a.clear((Target<?>) (Target) obj);
        }
    }

    /* renamed from: a */
    private RequestBuilder m24380a(Object obj, int i) {
        if (obj instanceof Integer) {
            return ((RequestBuilder) this.f34523a.asBitmap().placeholder(i)).load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return ((RequestBuilder) this.f34523a.asBitmap().placeholder(i)).load((Uri) obj);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str) || !str.endsWith(".gif")) {
                return ((RequestBuilder) this.f34523a.asBitmap().placeholder(i)).load(str);
            }
            return ((RequestBuilder) this.f34523a.asGif().placeholder(i)).load(str);
        } else if (obj instanceof File) {
            return ((RequestBuilder) this.f34523a.asBitmap().placeholder(i)).load((File) obj);
        } else {
            throw new IllegalArgumentException("This source typeLocal is not accepted. {src = " + obj + "}");
        }
    }

    /* renamed from: a */
    private static boolean m24382a(View view) {
        return (view == null || view.getVisibility() == 8) ? false : true;
    }
}
