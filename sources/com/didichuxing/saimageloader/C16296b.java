package com.didichuxing.saimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
import java.net.URL;

/* renamed from: com.didichuxing.saimageloader.b */
/* compiled from: GlideV4Wrapper */
class C16296b {

    /* renamed from: a */
    private Context f48596a = null;

    /* renamed from: b */
    private ImageView f48597b = null;

    /* renamed from: c */
    private Object f48598c = null;

    /* renamed from: d */
    private Object f48599d = null;

    /* renamed from: e */
    private Object f48600e = null;

    private C16296b(Context context) {
        this.f48596a = context;
    }

    /* renamed from: a */
    static C16296b m34814a(Context context) {
        return new C16296b(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C16296b mo120430a(Object obj) {
        this.f48598c = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C16296b mo120432b(Object obj) {
        this.f48599d = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C16296b mo120433c(Object obj) {
        this.f48600e = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo120431a(ImageView imageView) {
        this.f48597b = imageView;
        m34815a();
    }

    /* renamed from: a */
    private void m34815a() {
        RequestBuilder<Drawable> requestBuilder;
        Object obj = this.f48598c;
        if (obj instanceof String) {
            requestBuilder = Glide.with(this.f48596a).load((String) this.f48598c);
        } else if (obj instanceof Integer) {
            requestBuilder = Glide.with(this.f48596a).load((Integer) this.f48598c);
        } else if (obj instanceof Drawable) {
            requestBuilder = Glide.with(this.f48596a).load((Drawable) this.f48598c);
        } else if (obj instanceof Bitmap) {
            requestBuilder = Glide.with(this.f48596a).load((Bitmap) this.f48598c);
        } else if (obj instanceof Uri) {
            requestBuilder = Glide.with(this.f48596a).load((Uri) this.f48598c);
        } else if (obj instanceof URL) {
            requestBuilder = Glide.with(this.f48596a).load((URL) this.f48598c);
        } else if (obj instanceof File) {
            requestBuilder = Glide.with(this.f48596a).load((File) this.f48598c);
        } else if (obj instanceof byte[]) {
            requestBuilder = Glide.with(this.f48596a).load((byte[]) this.f48598c);
        } else {
            requestBuilder = Glide.with(this.f48596a).load(this.f48598c);
        }
        if (requestBuilder != null) {
            requestBuilder = (RequestBuilder) requestBuilder.diskCacheStrategy(DiskCacheStrategy.DATA);
        }
        if (requestBuilder != null) {
            Object obj2 = this.f48599d;
            if (obj2 instanceof Integer) {
                requestBuilder = (RequestBuilder) requestBuilder.placeholder(((Integer) obj2).intValue());
            } else if (obj2 instanceof Drawable) {
                requestBuilder = (RequestBuilder) requestBuilder.placeholder((Drawable) obj2);
            }
        }
        if (requestBuilder != null) {
            Object obj3 = this.f48600e;
            if (obj3 instanceof Integer) {
                requestBuilder = (RequestBuilder) requestBuilder.error(((Integer) obj3).intValue());
            } else if (obj3 instanceof Drawable) {
                requestBuilder = (RequestBuilder) requestBuilder.error((Drawable) obj3);
            }
        }
        if (requestBuilder != null) {
            requestBuilder.into(this.f48597b);
        }
    }
}
