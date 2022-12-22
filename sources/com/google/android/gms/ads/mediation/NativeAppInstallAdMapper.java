package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzdxg;
    private String zzexa;
    private List<NativeAd.Image> zzexb;
    private NativeAd.Image zzexc;
    private String zzexd;
    private double zzexe;
    private String zzexf;
    private String zzexg;

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

    public final void setStarRating(double d) {
        this.zzexe = d;
    }

    public final void setStore(String str) {
        this.zzexf = str;
    }

    public final void setPrice(String str) {
        this.zzexg = str;
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

    public final double getStarRating() {
        return this.zzexe;
    }

    public final String getStore() {
        return this.zzexf;
    }

    public final String getPrice() {
        return this.zzexg;
    }
}
