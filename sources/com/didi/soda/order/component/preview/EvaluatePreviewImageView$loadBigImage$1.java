package com.didi.soda.order.component.preview;

import com.didi.app.nova.skeleton.image.ImageRequestListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/soda/order/component/preview/EvaluatePreviewImageView$loadBigImage$1", "Lcom/didi/app/nova/skeleton/image/ImageRequestListener;", "", "onException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isFirstResource", "onResourceReady", "resource", "isFromMemoryCache", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EvaluatePreviewImageView.kt */
public final class EvaluatePreviewImageView$loadBigImage$1 implements ImageRequestListener<Object> {
    final /* synthetic */ EvaluatePreviewImageView this$0;

    public boolean onException(Exception exc, boolean z) {
        Intrinsics.checkNotNullParameter(exc, "e");
        return true;
    }

    EvaluatePreviewImageView$loadBigImage$1(EvaluatePreviewImageView evaluatePreviewImageView) {
        this.this$0 = evaluatePreviewImageView;
    }

    public boolean onResourceReady(Object obj, boolean z, boolean z2) {
        this.this$0.f43441e = true;
        return false;
    }
}
