package com.google.firebase.dynamiclinks;

import android.net.Uri;
import android.os.Bundle;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.internal.zze;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
public final class DynamicLink {
    private final Bundle zze;

    DynamicLink(Bundle bundle) {
        this.zze = bundle;
    }

    /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
    public static final class GoogleAnalyticsParameters {
        Bundle zzf;

        private GoogleAnalyticsParameters(Bundle bundle) {
            this.zzf = bundle;
        }

        /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
        public static final class Builder {
            private final Bundle zzf;

            public Builder() {
                this.zzf = new Bundle();
            }

            public Builder(String str, String str2, String str3) {
                Bundle bundle = new Bundle();
                this.zzf = bundle;
                bundle.putString("utm_source", str);
                this.zzf.putString("utm_medium", str2);
                this.zzf.putString("utm_campaign", str3);
            }

            public final Builder setSource(String str) {
                this.zzf.putString("utm_source", str);
                return this;
            }

            public final Builder setMedium(String str) {
                this.zzf.putString("utm_medium", str);
                return this;
            }

            public final Builder setCampaign(String str) {
                this.zzf.putString("utm_campaign", str);
                return this;
            }

            public final Builder setTerm(String str) {
                this.zzf.putString("utm_term", str);
                return this;
            }

            public final Builder setContent(String str) {
                this.zzf.putString("utm_content", str);
                return this;
            }

            public final GoogleAnalyticsParameters build() {
                return new GoogleAnalyticsParameters(this.zzf);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
    public static final class ItunesConnectAnalyticsParameters {
        final Bundle zzf;

        private ItunesConnectAnalyticsParameters(Bundle bundle) {
            this.zzf = bundle;
        }

        /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
        public static final class Builder {
            private final Bundle zzf = new Bundle();

            public final Builder setProviderToken(String str) {
                this.zzf.putString("pt", str);
                return this;
            }

            public final Builder setAffiliateToken(String str) {
                this.zzf.putString("at", str);
                return this;
            }

            public final Builder setCampaignToken(String str) {
                this.zzf.putString(UserDataStore.CITY, str);
                return this;
            }

            public final ItunesConnectAnalyticsParameters build() {
                return new ItunesConnectAnalyticsParameters(this.zzf);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
    public static final class NavigationInfoParameters {
        final Bundle zzf;

        private NavigationInfoParameters(Bundle bundle) {
            this.zzf = bundle;
        }

        /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
        public static final class Builder {
            private final Bundle zzf = new Bundle();

            public final Builder setForcedRedirectEnabled(boolean z) {
                this.zzf.putInt("efr", z ? 1 : 0);
                return this;
            }

            public final NavigationInfoParameters build() {
                return new NavigationInfoParameters(this.zzf);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
    public static final class SocialMetaTagParameters {
        final Bundle zzf;

        private SocialMetaTagParameters(Bundle bundle) {
            this.zzf = bundle;
        }

        /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
        public static final class Builder {
            private final Bundle zzf = new Bundle();

            public final Builder setTitle(String str) {
                this.zzf.putString(UserDataStore.STATE, str);
                return this;
            }

            public final Builder setDescription(String str) {
                this.zzf.putString("sd", str);
                return this;
            }

            public final Builder setImageUrl(Uri uri) {
                this.zzf.putParcelable("si", uri);
                return this;
            }

            public final SocialMetaTagParameters build() {
                return new SocialMetaTagParameters(this.zzf);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
    public static final class IosParameters {
        final Bundle zzf;

        private IosParameters(Bundle bundle) {
            this.zzf = bundle;
        }

        /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
        public static final class Builder {
            private final Bundle zzf;

            public Builder(String str) {
                Bundle bundle = new Bundle();
                this.zzf = bundle;
                bundle.putString("ibi", str);
            }

            public final Builder setFallbackUrl(Uri uri) {
                this.zzf.putParcelable("ifl", uri);
                return this;
            }

            public final Builder setCustomScheme(String str) {
                this.zzf.putString("ius", str);
                return this;
            }

            public final Builder setIpadFallbackUrl(Uri uri) {
                this.zzf.putParcelable("ipfl", uri);
                return this;
            }

            public final Builder setIpadBundleId(String str) {
                this.zzf.putString("ipbi", str);
                return this;
            }

            public final Builder setAppStoreId(String str) {
                this.zzf.putString("isi", str);
                return this;
            }

            public final Builder setMinimumVersion(String str) {
                this.zzf.putString("imv", str);
                return this;
            }

            public final IosParameters build() {
                return new IosParameters(this.zzf);
            }
        }
    }

    public final Uri getUri() {
        Bundle bundle = this.zze;
        zze.zzb(bundle);
        Uri uri = (Uri) bundle.getParcelable("dynamicLink");
        if (uri != null) {
            return uri;
        }
        Uri.Builder builder = new Uri.Builder();
        Uri parse = Uri.parse(bundle.getString("domainUriPrefix"));
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        Bundle bundle2 = bundle.getBundle("parameters");
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj != null) {
                builder.appendQueryParameter(str, obj.toString());
            }
        }
        return builder.build();
    }

    /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
    public static final class AndroidParameters {
        final Bundle zzf;

        private AndroidParameters(Bundle bundle) {
            this.zzf = bundle;
        }

        /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
        public static final class Builder {
            private final Bundle zzf;

            public Builder() {
                if (FirebaseApp.getInstance() != null) {
                    Bundle bundle = new Bundle();
                    this.zzf = bundle;
                    bundle.putString("apn", FirebaseApp.getInstance().getApplicationContext().getPackageName());
                    return;
                }
                throw new IllegalStateException("FirebaseApp not initialized.");
            }

            public Builder(String str) {
                Bundle bundle = new Bundle();
                this.zzf = bundle;
                bundle.putString("apn", str);
            }

            public final Builder setFallbackUrl(Uri uri) {
                this.zzf.putParcelable("afl", uri);
                return this;
            }

            public final Builder setMinimumVersion(int i) {
                this.zzf.putInt("amv", i);
                return this;
            }

            public final AndroidParameters build() {
                return new AndroidParameters(this.zzf);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
    public static final class Builder {
        private final Bundle zze = new Bundle();
        private final zze zzg;
        private final Bundle zzh;

        public Builder(zze zze2) {
            this.zzg = zze2;
            if (FirebaseApp.getInstance() != null) {
                this.zze.putString("apiKey", FirebaseApp.getInstance().getOptions().getApiKey());
            }
            Bundle bundle = new Bundle();
            this.zzh = bundle;
            this.zze.putBundle("parameters", bundle);
        }

        public final Builder setLongLink(Uri uri) {
            this.zze.putParcelable("dynamicLink", uri);
            return this;
        }

        public final Builder setLink(Uri uri) {
            this.zzh.putParcelable("link", uri);
            return this;
        }

        @Deprecated
        public final Builder setDynamicLinkDomain(String str) {
            if (str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$") || str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$")) {
                this.zze.putString("domain", str);
                Bundle bundle = this.zze;
                String valueOf = String.valueOf(str);
                bundle.putString("domainUriPrefix", valueOf.length() != 0 ? "https://".concat(valueOf) : new String("https://"));
                return this;
            }
            throw new IllegalArgumentException("Use setDomainUriPrefix() instead, setDynamicLinkDomain() is only applicable for *.page.link and *.app.goo.gl domains.");
        }

        public final Builder setDomainUriPrefix(String str) {
            if (str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$") || str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$")) {
                this.zze.putString("domain", str.replace("https://", ""));
            }
            this.zze.putString("domainUriPrefix", str);
            return this;
        }

        public final Builder setAndroidParameters(AndroidParameters androidParameters) {
            this.zzh.putAll(androidParameters.zzf);
            return this;
        }

        public final Builder setIosParameters(IosParameters iosParameters) {
            this.zzh.putAll(iosParameters.zzf);
            return this;
        }

        public final Builder setGoogleAnalyticsParameters(GoogleAnalyticsParameters googleAnalyticsParameters) {
            this.zzh.putAll(googleAnalyticsParameters.zzf);
            return this;
        }

        public final Builder setItunesConnectAnalyticsParameters(ItunesConnectAnalyticsParameters itunesConnectAnalyticsParameters) {
            this.zzh.putAll(itunesConnectAnalyticsParameters.zzf);
            return this;
        }

        public final Builder setSocialMetaTagParameters(SocialMetaTagParameters socialMetaTagParameters) {
            this.zzh.putAll(socialMetaTagParameters.zzf);
            return this;
        }

        public final Builder setNavigationInfoParameters(NavigationInfoParameters navigationInfoParameters) {
            this.zzh.putAll(navigationInfoParameters.zzf);
            return this;
        }

        public final DynamicLink buildDynamicLink() {
            zze.zzb(this.zze);
            return new DynamicLink(this.zze);
        }

        public final Task<ShortDynamicLink> buildShortDynamicLink() {
            zzb();
            return this.zzg.zza(this.zze);
        }

        public final Task<ShortDynamicLink> buildShortDynamicLink(int i) {
            zzb();
            this.zze.putInt(AbsDomainSuffixModel.SUFFIX, i);
            return this.zzg.zza(this.zze);
        }

        private final void zzb() {
            if (this.zze.getString("apiKey") == null) {
                throw new IllegalArgumentException("Missing API key. Set with setApiKey().");
            }
        }
    }
}
