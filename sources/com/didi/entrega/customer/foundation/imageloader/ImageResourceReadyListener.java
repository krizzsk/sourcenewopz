package com.didi.entrega.customer.foundation.imageloader;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/imageloader/ImageResourceReadyListener;", "", "onResourceReady", "", "resource", "Landroid/graphics/drawable/Drawable;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ImageResourceReadyListener.kt */
public interface ImageResourceReadyListener {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ImageResourceReadyListener.kt */
    public static final class DefaultImpls {
        public static void onResourceReady(ImageResourceReadyListener imageResourceReadyListener, Drawable drawable) {
            Intrinsics.checkNotNullParameter(imageResourceReadyListener, "this");
            Intrinsics.checkNotNullParameter(drawable, "resource");
        }
    }

    void onResourceReady(Drawable drawable);
}
