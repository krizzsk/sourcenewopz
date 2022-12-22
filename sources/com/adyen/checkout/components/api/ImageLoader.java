package com.adyen.checkout.components.api;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.adyen.checkout.components.api.LogoApi;
import com.adyen.checkout.components.api.LogoConnectionTask;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u0011H\u0007J4\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u0011H\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/ImageLoader;", "", "logoApi", "Lcom/adyen/checkout/components/api/LogoApi;", "(Lcom/adyen/checkout/components/api/LogoApi;)V", "callbacks", "", "", "Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;", "imageViews", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "load", "", "txVariant", "view", "placeholder", "", "errorFallback", "txSubVariant", "Companion", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ImageLoader.kt */
public final class ImageLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f623d;

    /* renamed from: a */
    private final LogoApi f624a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, LogoConnectionTask.LogoCallback> f625b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<String, WeakReference<ImageView>> f626c = new HashMap();

    @JvmStatic
    public static final ImageLoader getInstance(Context context, Environment environment) {
        return Companion.getInstance(context, environment);
    }

    public final void load(String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, imageView, 0, 0, 12, (Object) null);
    }

    public final void load(String str, ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, imageView, i, 0, 8, (Object) null);
    }

    public final void load(String str, String str2, ImageView imageView) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, str2, imageView, 0, 0, 24, (Object) null);
    }

    public final void load(String str, String str2, ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load$default(this, str, str2, imageView, i, 0, 16, (Object) null);
    }

    public ImageLoader(LogoApi logoApi) {
        Intrinsics.checkNotNullParameter(logoApi, "logoApi");
        this.f624a = logoApi;
    }

    public static /* synthetic */ void load$default(ImageLoader imageLoader, String str, ImageView imageView, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        imageLoader.load(str, imageView, i, i2);
    }

    public final void load(String str, ImageView imageView, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        load(str, "", imageView, i, i2);
    }

    public static /* synthetic */ void load$default(ImageLoader imageLoader, String str, String str2, ImageView imageView, int i, int i2, int i3, Object obj) {
        imageLoader.load(str, str2, imageView, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public final void load(String str, String str2, ImageView imageView, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "txVariant");
        Intrinsics.checkNotNullParameter(str2, "txSubVariant");
        Intrinsics.checkNotNullParameter(imageView, "view");
        if (i != 0) {
            imageView.setImageResource(i);
        }
        String str3 = str + str2 + imageView.hashCode();
        if (this.f625b.containsKey(str3)) {
            this.f625b.remove(str3);
            this.f626c.remove(str3);
        }
        LogoConnectionTask.LogoCallback imageLoader$load$callback$1 = new ImageLoader$load$callback$1(this, str3, i2);
        this.f626c.put(str3, new WeakReference(imageView));
        this.f625b.put(str3, imageLoader$load$callback$1);
        this.f624a.getLogo(str, str2, (LogoApi.Size) null, imageLoader$load$callback$1);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/ImageLoader$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/adyen/checkout/components/api/ImageLoader;", "context", "Landroid/content/Context;", "environment", "Lcom/adyen/checkout/core/api/Environment;", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ImageLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageLoader getInstance(Context context, Environment environment) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(environment, "environment");
            LogoApi.Companion companion = LogoApi.Companion;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
            return new ImageLoader(companion.getInstance(environment, displayMetrics));
        }
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        f623d = tag;
    }
}
