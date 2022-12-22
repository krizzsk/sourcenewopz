package com.didi.sdk.util;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import com.didi.sdk.util.glide.GlideModelLoader;
import java.io.InputStream;

public class BaseGlideModule extends LibraryGlideModule {
    public void registerComponents(Context context, Glide glide, Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new GlideModelLoader.Factory());
    }
}
