package com.didi.soda.customer.blocks.card;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.didi.soda.customer.foundation.imageloader.ImageResourceReadyListener;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/customer/blocks/card/Skin$update$1", "Lcom/didi/soda/customer/foundation/imageloader/ImageResourceReadyListener;", "onResourceReady", "", "resource", "Landroid/graphics/drawable/Drawable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicWidget.kt */
public final class Skin$update$1 implements ImageResourceReadyListener {
    final /* synthetic */ TopicWidget $this_update;

    Skin$update$1(TopicWidget topicWidget) {
        this.$this_update = topicWidget;
    }

    public void onResourceReady(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        ImageResourceReadyListener.DefaultImpls.onResourceReady(this, drawable);
        ((ImageView) this.$this_update.findViewById(R.id.customer_topic_second_image_view)).setImageDrawable(drawable);
    }
}
