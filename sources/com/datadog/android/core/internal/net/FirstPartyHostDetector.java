package com.datadog.android.core.internal.net;

import com.didi.sdk.util.GlobalCountryCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "", "hosts", "", "", "(Ljava/util/List;)V", "<set-?>", "knownHosts", "getKnownHosts$dd_sdk_android_release", "()Ljava/util/List;", "addKnownHosts", "", "isEmpty", "", "isFirstPartyUrl", "url", "Lokhttp3/HttpUrl;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FirstPartyHostDetector.kt */
public final class FirstPartyHostDetector {

    /* renamed from: a */
    private List<String> f3491a;

    public FirstPartyHostDetector(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "hosts");
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String str : iterable) {
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, GlobalCountryCode.AMERICA);
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                arrayList.add(lowerCase);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        this.f3491a = (List) arrayList;
    }

    public final List<String> getKnownHosts$dd_sdk_android_release() {
        return this.f3491a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isFirstPartyUrl(okhttp3.HttpUrl r7) {
        /*
            r6 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r7 = r7.host()
            java.util.List<java.lang.String> r0 = r6.f3491a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001e
        L_0x001c:
            r2 = 0
            goto L_0x0055
        L_0x001e:
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r4 = "*"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r4 != 0) goto L_0x0052
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = "host"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            java.lang.String r4 = "."
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r1)
            r4 = 2
            r5 = 0
            boolean r1 = kotlin.text.StringsKt.endsWith$default(r7, r1, r3, r4, r5)
            if (r1 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r1 = 0
            goto L_0x0053
        L_0x0052:
            r1 = 1
        L_0x0053:
            if (r1 == 0) goto L_0x0022
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.core.internal.net.FirstPartyHostDetector.isFirstPartyUrl(okhttp3.HttpUrl):boolean");
    }

    public final boolean isFirstPartyUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            return false;
        }
        return isFirstPartyUrl(parse);
    }

    public final boolean isEmpty() {
        return this.f3491a.isEmpty();
    }

    public final void addKnownHosts(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "hosts");
        Collection collection = this.f3491a;
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String str : iterable) {
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, GlobalCountryCode.AMERICA);
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                arrayList.add(lowerCase);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        this.f3491a = CollectionsKt.plus(collection, (List) arrayList);
    }
}
