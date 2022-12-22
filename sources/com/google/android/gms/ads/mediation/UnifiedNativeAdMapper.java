package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class UnifiedNativeAdMapper {
    private Bundle extras = new Bundle();
    private VideoController zzcks;
    private String zzdxg;
    private String zzexa;
    private List<NativeAd.Image> zzexb;
    private NativeAd.Image zzexc;
    private String zzexd;
    private String zzexf;
    private String zzexg;
    private View zzexh;
    private boolean zzexi;
    private String zzexk;
    private Double zzexl;
    private View zzexm;
    private Object zzexn;
    private boolean zzexo;
    private boolean zzexp;
    private float zzexq;

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void setHeadline(String str) {
        this.zzexa = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzexb = list;
    }

    public final void setBody(String str) {
        this.zzdxg = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzexc = image;
    }

    public final void setCallToAction(String str) {
        this.zzexd = str;
    }

    public final void setAdvertiser(String str) {
        this.zzexk = str;
    }

    public final void setStarRating(Double d) {
        this.zzexl = d;
    }

    public final void setStore(String str) {
        this.zzexf = str;
    }

    public final void setPrice(String str) {
        this.zzexg = str;
    }

    public final void zza(VideoController videoController) {
        this.zzcks = videoController;
    }

    public void setHasVideoContent(boolean z) {
        this.zzexi = z;
    }

    public void setAdChoicesContent(View view) {
        this.zzexm = view;
    }

    public void setMediaView(View view) {
        this.zzexh = view;
    }

    public void setMediaContentAspectRatio(float f) {
        this.zzexq = f;
    }

    public final void zzm(Object obj) {
        this.zzexn = obj;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.zzexo = z;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.zzexp = z;
    }

    public final String getHeadline() {
        return this.zzexa;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzexb;
    }

    public final String getBody() {
        return this.zzdxg;
    }

    public final NativeAd.Image getIcon() {
        return this.zzexc;
    }

    public final String getCallToAction() {
        return this.zzexd;
    }

    public final String getAdvertiser() {
        return this.zzexk;
    }

    public final Double getStarRating() {
        return this.zzexl;
    }

    public final String getStore() {
        return this.zzexf;
    }

    public final String getPrice() {
        return this.zzexg;
    }

    public final VideoController getVideoController() {
        return this.zzcks;
    }

    public boolean hasVideoContent() {
        return this.zzexi;
    }

    public View getAdChoicesContent() {
        return this.zzexm;
    }

    public final View zzafo() {
        return this.zzexh;
    }

    public float getMediaContentAspectRatio() {
        return this.zzexq;
    }

    public final Object zzka() {
        return this.zzexn;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzexo;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzexp;
    }
}
