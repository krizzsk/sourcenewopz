package com.adyen.checkout.components.analytics;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.URLUtil;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.util.LocaleUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class AnalyticEvent implements Parcelable {
    public static final Parcelable.Creator<AnalyticEvent> CREATOR = new Parcelable.Creator<AnalyticEvent>() {
        public AnalyticEvent createFromParcel(Parcel parcel) {
            return new AnalyticEvent(parcel);
        }

        public AnalyticEvent[] newArray(int i) {
            return new AnalyticEvent[i];
        }
    };

    /* renamed from: a */
    private static final String f593a = "dropin";

    /* renamed from: b */
    private static final String f594b = "components";

    /* renamed from: c */
    private static final String f595c = "1";

    /* renamed from: d */
    private static final String f596d = "android";

    /* renamed from: e */
    private static final String f597e = "payload_version";

    /* renamed from: f */
    private static final String f598f = "version";

    /* renamed from: g */
    private static final String f599g = "flavor";

    /* renamed from: h */
    private static final String f600h = "component";

    /* renamed from: i */
    private static final String f601i = "locale";

    /* renamed from: j */
    private static final String f602j = "platform";

    /* renamed from: k */
    private static final String f603k = "referer";

    /* renamed from: l */
    private static final String f604l = "device_brand";

    /* renamed from: m */
    private static final String f605m = "device_model";

    /* renamed from: n */
    private static final String f606n = "system_version";

    /* renamed from: o */
    private final String f607o = "1";

    /* renamed from: p */
    private final String f608p = "4.1.0";

    /* renamed from: q */
    private final String f609q;

    /* renamed from: r */
    private final String f610r;

    /* renamed from: s */
    private final String f611s;

    /* renamed from: t */
    private final String f612t = "android";

    /* renamed from: u */
    private final String f613u;

    /* renamed from: v */
    private final String f614v = Build.BRAND;

    /* renamed from: w */
    private final String f615w = Build.MODEL;

    /* renamed from: x */
    private final String f616x = String.valueOf(Build.VERSION.SDK_INT);

    public enum Flavor {
        DROPIN,
        COMPONENT
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: com.adyen.checkout.components.analytics.AnalyticEvent$2 */
    static /* synthetic */ class C13162 {

        /* renamed from: $SwitchMap$com$adyen$checkout$components$analytics$AnalyticEvent$Flavor */
        static final /* synthetic */ int[] f617xca590ab;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.checkout.components.analytics.AnalyticEvent$Flavor[] r0 = com.adyen.checkout.components.analytics.AnalyticEvent.Flavor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f617xca590ab = r0
                com.adyen.checkout.components.analytics.AnalyticEvent$Flavor r1 = com.adyen.checkout.components.analytics.AnalyticEvent.Flavor.DROPIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f617xca590ab     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.components.analytics.AnalyticEvent$Flavor r1 = com.adyen.checkout.components.analytics.AnalyticEvent.Flavor.COMPONENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.analytics.AnalyticEvent.C13162.<clinit>():void");
        }
    }

    public static AnalyticEvent create(Context context, Flavor flavor, String str, Locale locale) {
        String str2;
        int i = C13162.f617xca590ab[flavor.ordinal()];
        if (i == 1) {
            str2 = f593a;
        } else if (i == 2) {
            str2 = f594b;
        } else {
            throw new CheckoutException("Unexpected flavor - " + flavor.name());
        }
        return new AnalyticEvent(context.getPackageName(), str2, str, LocaleUtil.toLanguageTag(locale));
    }

    AnalyticEvent(Parcel parcel) {
        this.f609q = parcel.readString();
        this.f610r = parcel.readString();
        this.f611s = parcel.readString();
        this.f613u = parcel.readString();
    }

    private AnalyticEvent(String str, String str2, String str3, String str4) {
        this.f613u = str;
        this.f611s = str4;
        this.f609q = str2;
        this.f610r = str3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public URL mo14301a(String str) throws MalformedURLException {
        if (URLUtil.isValidUrl(str)) {
            Uri parse = Uri.parse(str);
            return new URL(new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).appendQueryParameter(f597e, "1").appendQueryParameter("version", "4.1.0").appendQueryParameter(f599g, this.f609q).appendQueryParameter(f600h, this.f610r).appendQueryParameter("locale", this.f611s).appendQueryParameter("platform", "android").appendQueryParameter(f603k, this.f613u).appendQueryParameter(f604l, this.f614v).appendQueryParameter("device_model", this.f615w).appendQueryParameter(f606n, this.f616x).build().toString());
        }
        throw new MalformedURLException("Invalid URL format - " + str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f609q);
        parcel.writeString(this.f610r);
        parcel.writeString(this.f611s);
        parcel.writeString(this.f613u);
    }
}
