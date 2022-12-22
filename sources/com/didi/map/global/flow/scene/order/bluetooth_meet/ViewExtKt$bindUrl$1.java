package com.didi.map.global.flow.scene.order.bluetooth_meet;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\fH\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/ViewExtKt$bindUrl$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewExt.kt */
public final class ViewExtKt$bindUrl$1 extends CustomTarget<Bitmap> {
    final /* synthetic */ int $defaultResId;
    final /* synthetic */ ImageView $this_bindUrl;

    public void onLoadCleared(Drawable drawable) {
    }

    ViewExtKt$bindUrl$1(ImageView imageView, int i) {
        this.$this_bindUrl = imageView;
        this.$defaultResId = i;
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        Intrinsics.checkNotNullParameter(bitmap, "resource");
        this.$this_bindUrl.setImageBitmap(bitmap);
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        int i = this.$defaultResId;
        if (i > 0) {
            this.$this_bindUrl.setImageResource(i);
        }
    }
}
