package com.didi.global.globalgenerickit.template.misoperation;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.didi.global.globalgenerickit.eventtracker.ImgLoadTracker;
import java.util.Map;

/* compiled from: MisOperationBinder */
class ViewHolder$3 implements RequestListener<Drawable> {
    final /* synthetic */ C8592a this$0;
    final /* synthetic */ Map val$omega;
    final /* synthetic */ long val$startDownloadTime;
    final /* synthetic */ String val$url;

    ViewHolder$3(C8592a aVar, String str, Map map, long j) {
        this.this$0 = aVar;
        this.val$url = str;
        this.val$omega = map;
        this.val$startDownloadTime = j;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        ImgLoadTracker.loadUrlRetOmega(this.val$url, this.val$omega, 1, this.val$startDownloadTime);
        return false;
    }

    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        ImgLoadTracker.loadUrlRetOmega(this.val$url, this.val$omega, 0, this.val$startDownloadTime);
        return false;
    }
}
