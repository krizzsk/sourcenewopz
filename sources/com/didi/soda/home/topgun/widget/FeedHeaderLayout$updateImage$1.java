package com.didi.soda.home.topgun.widget;

import com.didi.app.nova.skeleton.image.ImageRequestListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/home/topgun/widget/FeedHeaderLayout$updateImage$1", "Lcom/didi/app/nova/skeleton/image/ImageRequestListener;", "", "onException", "", "e", "Ljava/lang/Exception;", "isFirstResource", "onResourceReady", "resource", "isFromMemoryCache", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FeedHeaderLayout.kt */
public final class FeedHeaderLayout$updateImage$1 implements ImageRequestListener<Object> {
    final /* synthetic */ Function0<Unit> $specialImageLoadFail;

    public boolean onResourceReady(Object obj, boolean z, boolean z2) {
        return false;
    }

    FeedHeaderLayout$updateImage$1(Function0<Unit> function0) {
        this.$specialImageLoadFail = function0;
    }

    public boolean onException(Exception exc, boolean z) {
        this.$specialImageLoadFail.invoke();
        return false;
    }
}
