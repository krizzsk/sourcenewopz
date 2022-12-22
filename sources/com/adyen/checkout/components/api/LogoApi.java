package com.adyen.checkout.components.api;

import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.adyen.checkout.components.api.LogoConnectionTask;
import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J*\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\tR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/LogoApi;", "", "host", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "(Ljava/lang/String;Landroid/util/DisplayMetrics;)V", "cache", "Landroid/util/LruCache;", "Landroid/graphics/drawable/BitmapDrawable;", "connectionsMap", "", "Lcom/adyen/checkout/components/api/LogoConnectionTask;", "densityExtension", "logoUrlFormat", "buildUrl", "txVariant", "txSubVariant", "size", "Lcom/adyen/checkout/components/api/LogoApi$Size;", "cancelAll", "", "cancelLogoRequest", "clearCache", "getDensityExtension", "densityDpi", "", "getLogo", "callback", "Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;", "getSizeVariant", "isDifferentHost", "", "hostUrl", "taskFinished", "logoUrl", "logo", "Companion", "Size", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogoApi.kt */
public final class LogoApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int KILO_BYTE_SIZE = 1024;

    /* renamed from: e */
    private static final String f627e;

    /* renamed from: f */
    private static final String f628f = "images/logos/%1$s/%2$s.png";

    /* renamed from: g */
    private static final Size f629g = Size.SMALL;

    /* renamed from: h */
    private static final int f630h = 8;

    /* renamed from: i */
    private static final int f631i = Companion.getMaxCacheSize();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static LogoApi f632j;

    /* renamed from: a */
    private final Map<String, LogoConnectionTask> f633a = new HashMap();

    /* renamed from: b */
    private final String f634b;

    /* renamed from: c */
    private final String f635c;

    /* renamed from: d */
    private final LruCache<String, BitmapDrawable> f636d;

    /* renamed from: a */
    private final String m1032a(int i) {
        return i <= 120 ? "-ldpi" : i <= 160 ? "" : i <= 240 ? "-hdpi" : i <= 320 ? "-xhdpi" : i <= 480 ? "-xxhdpi" : "-xxxhdpi";
    }

    @JvmStatic
    public static final LogoApi getInstance(Environment environment, DisplayMetrics displayMetrics) {
        return Companion.getInstance(environment, displayMetrics);
    }

    @Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/LogoApi$Companion;", "", "()V", "CACHE_FRACTION_SIZE", "", "DEFAULT_SIZE", "Lcom/adyen/checkout/components/api/LogoApi$Size;", "KILO_BYTE_SIZE", "LOGO_PATH", "", "LRU_CACHE_MAX_SIZE", "TAG", "sInstance", "Lcom/adyen/checkout/components/api/LogoApi;", "getInstance", "environment", "Lcom/adyen/checkout/core/api/Environment;", "displayMetrics", "Landroid/util/DisplayMetrics;", "getMaxCacheSize", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogoApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LogoApi getInstance(Environment environment, DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(environment, "environment");
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            String baseUrl = environment.getBaseUrl();
            Intrinsics.checkNotNullExpressionValue(baseUrl, "environment.baseUrl");
            synchronized (LogoApi.class) {
                LogoApi access$getSInstance$cp = LogoApi.f632j;
                if (access$getSInstance$cp != null && !access$getSInstance$cp.m1036a(baseUrl)) {
                    return access$getSInstance$cp;
                }
                if (access$getSInstance$cp != null) {
                    access$getSInstance$cp.m1035a();
                }
                LogoApi logoApi = new LogoApi(baseUrl, displayMetrics);
                Companion companion = LogoApi.Companion;
                LogoApi.f632j = logoApi;
                return logoApi;
            }
        }

        /* access modifiers changed from: private */
        public final int getMaxCacheSize() {
            return ((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 8;
        }
    }

    public LogoApi(String str, DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        this.f634b = Intrinsics.stringPlus(str, f628f);
        this.f635c = m1032a(displayMetrics.densityDpi);
        this.f636d = new LogoApi$cache$1(f631i);
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        f627e = tag;
    }

    public final void getLogo(String str, String str2, Size size, LogoConnectionTask.LogoCallback logoCallback) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(logoCallback, "callback");
        String str3 = f627e;
        Logger.m1082v(str3, "getLogo - " + str + ", " + str2 + ", " + size);
        String a = m1034a(str, str2, size);
        synchronized (this) {
            BitmapDrawable bitmapDrawable = this.f636d.get(a);
            if (bitmapDrawable != null) {
                Logger.m1082v(f627e, "returning cached logo");
                logoCallback.onLogoReceived(bitmapDrawable);
                Unit unit = Unit.INSTANCE;
            } else if (!this.f633a.containsKey(a)) {
                LogoConnectionTask logoConnectionTask = new LogoConnectionTask(this, a, logoCallback);
                this.f633a.put(a, logoConnectionTask);
                ThreadManager.EXECUTOR.submit(logoConnectionTask);
            } else {
                LogoConnectionTask logoConnectionTask2 = this.f633a.get(a);
                if (logoConnectionTask2 != null) {
                    logoConnectionTask2.addCallback(logoCallback);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    public final void cancelLogoRequest(String str, String str2, Size size) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Logger.m1076d(f627e, "cancelLogoRequest");
        String a = m1034a(str, str2, size);
        synchronized (this) {
            LogoConnectionTask remove = this.f633a.remove(a);
            if (remove != null) {
                remove.cancel(true);
                Logger.m1076d(f627e, StatusResponseUtils.RESULT_CANCELED);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cancelAll() {
        synchronized (this) {
            for (LogoConnectionTask cancel : this.f633a.values()) {
                cancel.cancel(true);
            }
            this.f633a.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void taskFinished(String str, BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(str, "logoUrl");
        synchronized (this) {
            this.f633a.remove(str);
            if (bitmapDrawable != null) {
                this.f636d.put(str, bitmapDrawable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: a */
    private final String m1034a(String str, String str2, Size size) {
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            str = str + IOUtils.DIR_SEPARATOR_UNIX + str2;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(this.f634b, Arrays.copyOf(new Object[]{m1033a(size), Intrinsics.stringPlus(str, this.f635c)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    /* renamed from: a */
    private final String m1033a(Size size) {
        if (size == null) {
            size = f629g;
        }
        return size.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m1035a() {
        this.f636d.evictAll();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m1036a(String str) {
        return !StringsKt.startsWith$default(this.f634b, str, false, 2, (Object) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/LogoApi$Size;", "", "(Ljava/lang/String;I)V", "toString", "", "SMALL", "MEDIUM", "LARGE", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogoApi.kt */
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE;

        public String toString() {
            String name = name();
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            if (name != null) {
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }
}
