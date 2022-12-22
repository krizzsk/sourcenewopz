package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzapp extends zzaog {
    private final UnifiedNativeAdMapper zzdpy;

    public zzapp(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdpy = unifiedNativeAdMapper;
    }

    public final zzaek zztu() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdpy.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdpy.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image next : images) {
                arrayList.add(new zzaee(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
            }
        }
        return arrayList;
    }

    public final String getBody() {
        return this.zzdpy.getBody();
    }

    public final zzaes zztt() {
        NativeAd.Image icon = this.zzdpy.getIcon();
        if (icon != null) {
            return new zzaee(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final String getCallToAction() {
        return this.zzdpy.getCallToAction();
    }

    public final String getAdvertiser() {
        return this.zzdpy.getAdvertiser();
    }

    public final double getStarRating() {
        if (this.zzdpy.getStarRating() != null) {
            return this.zzdpy.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String getStore() {
        return this.zzdpy.getStore();
    }

    public final String getPrice() {
        return this.zzdpy.getPrice();
    }

    public final zzzd getVideoController() {
        if (this.zzdpy.getVideoController() != null) {
            return this.zzdpy.getVideoController().zzdz();
        }
        return null;
    }

    public final IObjectWrapper zzvr() {
        View adChoicesContent = this.zzdpy.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzvs() {
        View zzafo = this.zzdpy.zzafo();
        if (zzafo == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafo);
    }

    public final float getMediaContentAspectRatio() {
        return this.zzdpy.getMediaContentAspectRatio();
    }

    public final float getVideoDuration() {
        return this.zzdpy.getDuration();
    }

    public final float getVideoCurrentTime() {
        return this.zzdpy.getCurrentTime();
    }

    public final IObjectWrapper zztv() {
        Object zzka = this.zzdpy.zzka();
        if (zzka == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzka);
    }

    public final Bundle getExtras() {
        return this.zzdpy.getExtras();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdpy.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdpy.getOverrideClickHandling();
    }

    public final void recordImpression() {
        this.zzdpy.recordImpression();
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdpy.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdpy.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
        this.zzdpy.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
