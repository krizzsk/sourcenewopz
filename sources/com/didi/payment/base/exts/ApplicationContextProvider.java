package com.didi.payment.base.exts;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.didi.payment.base.screenshot.ScreenShotListenManager;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016JO\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0016J;\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/base/exts/ApplicationContextProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ApplicationContextProvider.kt */
public final class ApplicationContextProvider extends ContentProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Context f29900a;

    public int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    public Void getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    public Void insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    public Void query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/base/exts/ApplicationContextProvider$Companion;", "", "()V", "ctx", "Landroid/content/Context;", "getContext", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ApplicationContextProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Context getContext() {
            Context access$getCtx$cp = ApplicationContextProvider.f29900a;
            if (access$getCtx$cp != null) {
                return access$getCtx$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ctx");
            return null;
        }
    }

    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "requireNotNull(context) …er.\" }.applicationContext");
            f29900a = applicationContext;
            ScreenShotListenManager.INSTANCE.start();
            return true;
        }
        throw new IllegalArgumentException("Cannot find context from the provider.".toString());
    }
}
