package com.didi.component.savingcenter;

import android.graphics.drawable.Animatable;
import com.didi.component.common.util.GLog;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, mo175978d2 = {"com/didi/component/savingcenter/SavingCenterView$setIcon$build$1", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", "throwable", "", "onFinalImageSet", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "onIntermediateImageFailed", "onIntermediateImageSet", "onRelease", "onSubmit", "callerContext", "", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterView.kt */
public final class SavingCenterView$setIcon$build$1 implements ControllerListener<ImageInfo> {
    final /* synthetic */ String $url;
    final /* synthetic */ SavingCenterView this$0;

    public void onIntermediateImageFailed(String str, Throwable th) {
    }

    public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
    }

    public void onRelease(String str) {
    }

    public void onSubmit(String str, Object obj) {
    }

    SavingCenterView$setIcon$build$1(SavingCenterView savingCenterView, String str) {
        this.this$0 = savingCenterView;
        this.$url = str;
    }

    public void onFailure(String str, Throwable th) {
        GLog.m7965d(this.this$0.getTAG(), "saving center load img fail");
    }

    public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        GLog.m7965d(this.this$0.getTAG(), "saving center load img success");
        if (!Intrinsics.areEqual((Object) this.$url, this.this$0.getMIcon().getTag())) {
            this.this$0.getMIcon().setTag(this.$url);
            this.this$0.playDelay();
        }
    }
}
