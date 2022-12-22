package com.didi.app.nova.skeleton.image;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.image.glide.SkeletonGlide;
import java.io.File;

public class SKRequestManager {

    /* renamed from: a */
    RequestManager f8456a;

    public SKRequestManager(ScopeContext scopeContext) {
        this.f8456a = SkeletonGlide.with(scopeContext);
    }

    public SKRequestManager(Context context) {
        this.f8456a = Glide.with(context);
    }

    public SKRequestManager(Activity activity) {
        this.f8456a = Glide.with(activity);
    }

    public SKRequestManager(FragmentActivity fragmentActivity) {
        this.f8456a = Glide.with((Activity) fragmentActivity);
    }

    public SKRequestManager(Fragment fragment) {
        this.f8456a = Glide.with(fragment);
    }

    public SKDrawableTypeRequest<Bitmap> asBitmap() {
        return new SKDrawableTypeRequest<>(this.f8456a.asBitmap());
    }

    public SKDrawableTypeRequest<GifDrawable> asGif() {
        return new SKDrawableTypeRequest<>(this.f8456a.asGif());
    }

    public SKDrawableTypeRequest<File> downloadOnly() {
        return new SKDrawableTypeRequest(this.f8456a.downloadOnly()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
    }

    public void clear(View view) {
        this.f8456a.clear(view);
    }

    public SKDrawableTypeRequest<Drawable> load(String str) {
        return new SKDrawableTypeRequest(this.f8456a.asDrawable()).load(str);
    }

    public SKDrawableTypeRequest<Drawable> load(Uri uri) {
        return new SKDrawableTypeRequest(this.f8456a.asDrawable()).load(uri);
    }

    public SKDrawableTypeRequest<Drawable> load(File file) {
        return new SKDrawableTypeRequest(this.f8456a.asDrawable()).load(file);
    }

    public SKDrawableTypeRequest<Drawable> load(Integer num) {
        return new SKDrawableTypeRequest(this.f8456a.asDrawable()).load(num);
    }

    public SKDrawableTypeRequest<Drawable> load(FitType fitType, String str) {
        return new SKDrawableTypeRequest(this.f8456a.asDrawable()).load(fitType, str);
    }
}
