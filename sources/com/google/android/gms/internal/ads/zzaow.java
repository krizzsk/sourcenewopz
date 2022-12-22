package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaow extends zzaof {
    private final NativeContentAdMapper zzdpn;

    public zzaow(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdpn = nativeContentAdMapper;
    }

    public final zzaek zztu() {
        return null;
    }

    public final IObjectWrapper zztv() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdpn.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdpn.getImages();
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
        return this.zzdpn.getBody();
    }

    public final zzaes zztw() {
        NativeAd.Image logo = this.zzdpn.getLogo();
        if (logo != null) {
            return new zzaee(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    public final String getCallToAction() {
        return this.zzdpn.getCallToAction();
    }

    public final String getAdvertiser() {
        return this.zzdpn.getAdvertiser();
    }

    public final void recordImpression() {
        this.zzdpn.recordImpression();
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdpn.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdpn.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdpn.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
        this.zzdpn.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdpn.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdpn.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.zzdpn.getExtras();
    }

    public final IObjectWrapper zzvr() {
        View adChoicesContent = this.zzdpn.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final zzzd getVideoController() {
        if (this.zzdpn.getVideoController() != null) {
            return this.zzdpn.getVideoController().zzdz();
        }
        return null;
    }

    public final IObjectWrapper zzvs() {
        View zzafo = this.zzdpn.zzafo();
        if (zzafo == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafo);
    }
}
