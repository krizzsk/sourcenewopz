package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaox extends zzaoa {
    private final NativeAppInstallAdMapper zzdpo;

    public zzaox(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdpo = nativeAppInstallAdMapper;
    }

    public final zzaek zztu() {
        return null;
    }

    public final IObjectWrapper zztv() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdpo.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdpo.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zzaee(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
        }
        return arrayList;
    }

    public final String getBody() {
        return this.zzdpo.getBody();
    }

    public final zzaes zztt() {
        NativeAd.Image icon = this.zzdpo.getIcon();
        if (icon != null) {
            return new zzaee(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final String getCallToAction() {
        return this.zzdpo.getCallToAction();
    }

    public final double getStarRating() {
        return this.zzdpo.getStarRating();
    }

    public final String getStore() {
        return this.zzdpo.getStore();
    }

    public final String getPrice() {
        return this.zzdpo.getPrice();
    }

    public final void recordImpression() {
        this.zzdpo.recordImpression();
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdpo.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdpo.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdpo.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
        this.zzdpo.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdpo.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdpo.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.zzdpo.getExtras();
    }

    public final zzzd getVideoController() {
        if (this.zzdpo.getVideoController() != null) {
            return this.zzdpo.getVideoController().zzdz();
        }
        return null;
    }

    public final IObjectWrapper zzvr() {
        View adChoicesContent = this.zzdpo.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzvs() {
        View zzafo = this.zzdpo.zzafo();
        if (zzafo == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafo);
    }
}
