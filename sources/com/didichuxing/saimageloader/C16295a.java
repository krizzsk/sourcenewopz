package com.didichuxing.saimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;

/* renamed from: com.didichuxing.saimageloader.a */
/* compiled from: GlideV3Wrapper */
class C16295a {

    /* renamed from: a */
    private Context f48591a = null;

    /* renamed from: b */
    private ImageView f48592b = null;

    /* renamed from: c */
    private Object f48593c = null;

    /* renamed from: d */
    private Object f48594d = null;

    /* renamed from: e */
    private Object f48595e = null;

    C16295a(Context context) {
        this.f48591a = context;
    }

    /* renamed from: a */
    static C16295a m34808a(Context context) {
        return new C16295a(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C16295a mo120426a(Object obj) {
        this.f48593c = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C16295a mo120428b(Object obj) {
        this.f48594d = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C16295a mo120429c(Object obj) {
        this.f48595e = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo120427a(ImageView imageView) {
        this.f48592b = imageView;
        m34809a();
    }

    /* renamed from: a */
    private void m34809a() {
        RequestBuilder<Drawable> requestBuilder;
        Object obj = this.f48593c;
        if (obj instanceof Drawable) {
            this.f48592b.setImageDrawable((Drawable) obj);
            return;
        }
        if (obj instanceof String) {
            requestBuilder = Glide.with(this.f48591a).load((String) this.f48593c);
        } else if (obj instanceof Integer) {
            requestBuilder = Glide.with(this.f48591a).load((Integer) this.f48593c);
        } else if (obj instanceof Uri) {
            requestBuilder = Glide.with(this.f48591a).loadFromMediaStore((Uri) this.f48593c);
        } else if (obj instanceof URL) {
            requestBuilder = Glide.with(this.f48591a).load((URL) this.f48593c);
        } else if (obj instanceof Bitmap) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) this.f48593c).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            requestBuilder = Glide.with(this.f48591a).load(byteArrayOutputStream.toByteArray());
        } else if (obj instanceof File) {
            requestBuilder = Glide.with(this.f48591a).load((File) this.f48593c);
        } else if (obj instanceof byte[]) {
            requestBuilder = Glide.with(this.f48591a).load((byte[]) this.f48593c);
        } else {
            requestBuilder = Glide.with(this.f48591a).load(this.f48593c);
        }
        if (requestBuilder != null) {
            requestBuilder = requestBuilder.diskCacheStrategy(DiskCacheStrategy.SOURCE);
        }
        if (requestBuilder != null) {
            Object obj2 = this.f48594d;
            if (obj2 instanceof Integer) {
                requestBuilder = requestBuilder.placeholder(((Integer) obj2).intValue());
            } else if (obj2 instanceof Drawable) {
                requestBuilder = requestBuilder.placeholder((Drawable) obj2);
            }
        }
        if (requestBuilder != null) {
            Object obj3 = this.f48595e;
            if (obj3 instanceof Integer) {
                requestBuilder = requestBuilder.error(((Integer) obj3).intValue());
            } else if (obj3 instanceof Drawable) {
                requestBuilder = requestBuilder.error((Drawable) obj3);
            }
        }
        if (requestBuilder != null) {
            requestBuilder.into(this.f48592b);
        }
    }
}
