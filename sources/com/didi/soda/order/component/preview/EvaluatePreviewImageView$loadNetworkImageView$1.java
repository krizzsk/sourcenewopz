package com.didi.soda.order.component.preview;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.didi.soda.customer.foundation.imageloader.ImageResourceReadyListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/order/component/preview/EvaluatePreviewImageView$loadNetworkImageView$1", "Lcom/didi/soda/customer/foundation/imageloader/ImageResourceReadyListener;", "onResourceReady", "", "resource", "Landroid/graphics/drawable/Drawable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EvaluatePreviewImageView.kt */
public final class EvaluatePreviewImageView$loadNetworkImageView$1 implements ImageResourceReadyListener {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ EvaluatePreviewImageView this$0;

    EvaluatePreviewImageView$loadNetworkImageView$1(EvaluatePreviewImageView evaluatePreviewImageView, String str) {
        this.this$0 = evaluatePreviewImageView;
        this.$imageUrl = str;
    }

    public void onResourceReady(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        if (!this.this$0.f43441e) {
            ImageView access$getImageView$p = this.this$0.f43437a;
            if (access$getImageView$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                access$getImageView$p = null;
            }
            access$getImageView$p.setImageDrawable(drawable);
            this.this$0.m30751a(this.$imageUrl, drawable);
        }
    }
}
