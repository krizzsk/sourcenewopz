package com.google.android.gms.common.internal;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import rui.config.RConfigConstants;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class ResourceUtils {
    private static final Uri zza = new Uri.Builder().scheme(UriUtil.QUALIFIED_RESOURCE_SCHEME).authority("com.google.android.gms").appendPath(RConfigConstants.TYPE_DRAWABLE).build();

    private ResourceUtils() {
    }
}
