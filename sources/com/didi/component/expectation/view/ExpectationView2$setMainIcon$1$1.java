package com.didi.component.expectation.view;

import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.resource.warehouse.tools.OmegaUtil;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/component/expectation/view/ExpectationView2$setMainIcon$1$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", "throwable", "", "onFinalImageSet", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "comp-expectation_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExpectationView2.kt */
public final class ExpectationView2$setMainIcon$1$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ boolean $hasCache;
    final /* synthetic */ long $startTime;
    final /* synthetic */ String $url;

    ExpectationView2$setMainIcon$1$1(String str, boolean z, long j) {
        this.$url = str;
        this.$hasCache = z;
        this.$startTime = j;
    }

    public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        Intrinsics.checkNotNullParameter(str, "id");
        LogUtil.m26314i("ExpectationViewV2", "setMainIcon.onFinalImageSet:url = " + this.$url + ", hasCache = " + this.$hasCache);
        if (!this.$hasCache) {
            OmegaUtil.loadUrlIfNeedDownloadSuccessEvent(this.$url, SystemClock.elapsedRealtime() - this.$startTime);
        }
    }

    public void onFailure(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(th, "throwable");
        LogUtil.m26314i("ExpectationViewV2", "setMainIcon.onFailure:url = " + this.$url + ", hasCache = " + this.$hasCache + ", throwable = " + th);
        OmegaUtil.loadUrlIfNeedDownloadFailEvent(this.$url, SystemClock.elapsedRealtime() - this.$startTime, th.toString());
    }
}
