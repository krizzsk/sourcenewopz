package com.didi.app.nova.skeleton.image.glide.internal;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.module.LibraryGlideModule;
import com.didi.app.nova.skeleton.image.glide.FitUri;
import com.didi.app.nova.skeleton.image.glide.internal.DiFitUriLoader;
import com.didi.app.nova.skeleton.image.glide.internal.SodaUrlLoader;
import com.didi.sdk.apm.SystemUtils;
import java.io.InputStream;

public class SkeletonGlideModule extends LibraryGlideModule {
    private static final String TAG = "SkeletonGlideModule";

    public void registerComponents(Context context, Glide glide, Registry registry) {
        SystemUtils.log(4, TAG, "registerComponents: success", (Throwable) null, "com.didi.app.nova.skeleton.image.glide.internal.SkeletonGlideModule", 29);
        registry.prepend(FitUri.class, InputStream.class, new DiFitUriLoader.Factory()).prepend(SodaUrl.class, InputStream.class, new SodaUrlLoader.Factory());
    }
}
