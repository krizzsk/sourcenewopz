package com.didi.soda.bill.dialog;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import java.io.File;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/bill/dialog/PayFailGuideFloatingView$textFormat$1", "Lcom/didi/app/nova/skeleton/image/ImageDownloadListener;", "onFailure", "", "e", "Ljava/lang/Exception;", "onSuccess", "file", "Ljava/io/File;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayFailGuideFloatingView.kt */
public final class PayFailGuideFloatingView$textFormat$1 implements ImageDownloadListener {
    final /* synthetic */ PayChannelEntity $channel;
    final /* synthetic */ String $content;
    final /* synthetic */ boolean $isGrey;
    final /* synthetic */ View $view;
    final /* synthetic */ PayFailGuideFloatingView this$0;

    public void onFailure(Exception exc) {
    }

    PayFailGuideFloatingView$textFormat$1(PayFailGuideFloatingView payFailGuideFloatingView, View view, String str, PayChannelEntity payChannelEntity, boolean z) {
        this.this$0 = payFailGuideFloatingView;
        this.$view = view;
        this.$content = str;
        this.$channel = payChannelEntity;
        this.$isGrey = z;
    }

    public void onSuccess(File file) {
        this.this$0.m27684a(this.$view, this.$content, this.$channel, this.$isGrey, true, new BitmapDrawable(BitmapUtil.convertFileToBitmap(file)));
    }
}
