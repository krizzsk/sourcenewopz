package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.internal.ads.zzzl;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class AdManagerAdRequest extends AdRequest {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static final class Builder extends AdRequest.Builder {
        public final AdManagerAdRequest build() {
            return new AdManagerAdRequest(this);
        }

        public final Builder setPublisherProvidedId(String str) {
            this.zzada.zzcj(str);
            return this;
        }

        public final Builder addCustomTargeting(String str, String str2) {
            this.zzada.zzd(str, str2);
            return this;
        }

        public final Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzada.zzd(str, TextUtils.join(",", list));
            }
            return this;
        }

        public final Builder addCategoryExclusion(String str) {
            this.zzada.zzcl(str);
            return this;
        }

        public final Builder setAdInfo(AdInfo adInfo) {
            this.zzada.zza(adInfo);
            return this;
        }
    }

    private AdManagerAdRequest(Builder builder) {
        super(builder);
    }

    public final String getPublisherProvidedId() {
        return this.zzadb.getPublisherProvidedId();
    }

    public final Bundle getCustomTargeting() {
        return this.zzadb.getCustomTargeting();
    }

    public final zzzl zzdt() {
        return this.zzadb;
    }
}
