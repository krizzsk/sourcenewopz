package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.bumptech.glide.integration.webp.WebpGlideLibraryModule;
import com.didi.app.nova.skeleton.image.glide.internal.SkeletonGlideModule;
import com.didi.component.common.util.PaxGlideModule;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.util.BaseGlideModule;
import com.didi.sdk.util.DidiGlideModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final DidiGlideModule appGlideModule = new DidiGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable(ICacheProvider.PROVIDER_KEY_GLIDE, 3)) {
            SystemUtils.log(3, ICacheProvider.PROVIDER_KEY_GLIDE, "Discovered AppGlideModule from annotation: com.didi.sdk.util.DidiGlideModule", (Throwable) null, "com.bumptech.glide.GeneratedAppGlideModuleImpl", 22);
            SystemUtils.log(3, ICacheProvider.PROVIDER_KEY_GLIDE, "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule", (Throwable) null, "com.bumptech.glide.GeneratedAppGlideModuleImpl", 23);
            SystemUtils.log(3, ICacheProvider.PROVIDER_KEY_GLIDE, "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.webp.WebpGlideLibraryModule", (Throwable) null, "com.bumptech.glide.GeneratedAppGlideModuleImpl", 24);
            SystemUtils.log(3, ICacheProvider.PROVIDER_KEY_GLIDE, "Discovered LibraryGlideModule from annotation: com.didi.app.nova.skeleton.image.glide.internal.SkeletonGlideModule", (Throwable) null, "com.bumptech.glide.GeneratedAppGlideModuleImpl", 25);
            SystemUtils.log(3, ICacheProvider.PROVIDER_KEY_GLIDE, "Discovered LibraryGlideModule from annotation: com.didi.component.common.util.PaxGlideModule", (Throwable) null, "com.bumptech.glide.GeneratedAppGlideModuleImpl", 26);
            SystemUtils.log(3, ICacheProvider.PROVIDER_KEY_GLIDE, "Discovered LibraryGlideModule from annotation: com.didi.sdk.util.BaseGlideModule", (Throwable) null, "com.bumptech.glide.GeneratedAppGlideModuleImpl", 27);
        }
    }

    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        this.appGlideModule.applyOptions(context, glideBuilder);
    }

    public void registerComponents(Context context, Glide glide, Registry registry) {
        new OkHttpLibraryGlideModule().registerComponents(context, glide, registry);
        new WebpGlideLibraryModule().registerComponents(context, glide, registry);
        new SkeletonGlideModule().registerComponents(context, glide, registry);
        new PaxGlideModule().registerComponents(context, glide, registry);
        new BaseGlideModule().registerComponents(context, glide, registry);
        this.appGlideModule.registerComponents(context, glide, registry);
    }

    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    /* access modifiers changed from: package-private */
    public GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }
}
