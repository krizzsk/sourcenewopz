package com.didiglobal.travel.infra.net;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@UriMaker
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0004\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\rJ\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\rJ\u001f\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\rJ\u001f\u0010 \u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\rJ\u001f\u0010\"\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\rJ\u0015\u0010$\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\t\u0010'\u001a\u00020\tHÖ\u0001J\u001c\u0010(\u001a\u00020\u0007*\u00020\t2\u0006\u0010)\u001a\u00020\u000bH\u0004¢\u0006\u0004\b*\u0010\rJ\u001c\u0010(\u001a\u00020\u0007*\u00020\t2\u0006\u0010)\u001a\u00020+H\u0004¢\u0006\u0004\b*\u0010,J\u001c\u0010(\u001a\u00020\u0007*\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0004¢\u0006\u0004\b*\u0010-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo175978d2 = {"Lcom/didiglobal/travel/infra/net/UriCreator;", "", "builder", "Landroid/net/Uri$Builder;", "constructor-impl", "(Landroid/net/Uri$Builder;)Landroid/net/Uri$Builder;", "appendPath", "", "newSegment", "", "encoded", "", "appendPath-impl", "(Landroid/net/Uri$Builder;Ljava/lang/String;Z)V", "build", "Landroid/net/Uri;", "build-impl$lib_common_release", "(Landroid/net/Uri$Builder;)Landroid/net/Uri;", "clearQuery", "clearQuery-impl", "(Landroid/net/Uri$Builder;)V", "equals", "other", "fragment", "fragment-impl", "hashCode", "", "host", "authority", "host-impl", "opaquePart", "opaquePart-impl", "path", "path-impl", "query", "query-impl", "scheme", "scheme-impl", "(Landroid/net/Uri$Builder;Ljava/lang/String;)V", "toString", "param", "value", "param-impl", "", "(Landroid/net/Uri$Builder;Ljava/lang/String;Ljava/lang/Number;)V", "(Landroid/net/Uri$Builder;Ljava/lang/String;Ljava/lang/String;)V", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Uri.kt */
public final class UriCreator {

    /* renamed from: a */
    private final Uri.Builder f51421a;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Uri.Builder m47086constructorimpl(Uri.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        return builder;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47087equalsimpl(Uri.Builder builder, Object obj) {
        return (obj instanceof UriCreator) && Intrinsics.areEqual((Object) builder, (Object) ((UriCreator) obj).m47105unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47088equalsimpl0(Uri.Builder builder, Uri.Builder builder2) {
        return Intrinsics.areEqual((Object) builder, (Object) builder2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47091hashCodeimpl(Uri.Builder builder) {
        if (builder != null) {
            return builder.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47104toStringimpl(Uri.Builder builder) {
        return "UriCreator(builder=" + builder + ")";
    }

    public boolean equals(Object obj) {
        return m47087equalsimpl(this.f51421a, obj);
    }

    public int hashCode() {
        return m47091hashCodeimpl(this.f51421a);
    }

    public String toString() {
        return m47104toStringimpl(this.f51421a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Uri.Builder m47105unboximpl() {
        return this.f51421a;
    }

    private /* synthetic */ UriCreator(Uri.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.f51421a = builder;
    }

    /* renamed from: scheme-impl  reason: not valid java name */
    public static final void m47103schemeimpl(Uri.Builder builder, String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        builder.scheme(str);
    }

    /* renamed from: host-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47093hostimpl$default(Uri.Builder builder, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        m47092hostimpl(builder, str, z);
    }

    /* renamed from: host-impl  reason: not valid java name */
    public static final void m47092hostimpl(Uri.Builder builder, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "authority");
        if (z) {
            builder.encodedAuthority(str);
        } else {
            builder.authority(str);
        }
    }

    /* renamed from: path-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47100pathimpl$default(Uri.Builder builder, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        m47099pathimpl(builder, str, z);
    }

    /* renamed from: path-impl  reason: not valid java name */
    public static final void m47099pathimpl(Uri.Builder builder, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        if (z) {
            builder.encodedPath(str);
        } else {
            builder.path(str);
        }
    }

    /* renamed from: appendPath-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47082appendPathimpl$default(Uri.Builder builder, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        m47081appendPathimpl(builder, str, z);
    }

    /* renamed from: appendPath-impl  reason: not valid java name */
    public static final void m47081appendPathimpl(Uri.Builder builder, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "newSegment");
        if (z) {
            builder.appendEncodedPath(str);
        } else {
            builder.appendPath(str);
        }
    }

    /* renamed from: query-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47102queryimpl$default(Uri.Builder builder, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        m47101queryimpl(builder, str, z);
    }

    /* renamed from: query-impl  reason: not valid java name */
    public static final void m47101queryimpl(Uri.Builder builder, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "query");
        if (z) {
            builder.encodedQuery(str);
        } else {
            builder.query(str);
        }
    }

    /* renamed from: clearQuery-impl  reason: not valid java name */
    public static final void m47085clearQueryimpl(Uri.Builder builder) {
        builder.clearQuery();
    }

    /* renamed from: fragment-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47090fragmentimpl$default(Uri.Builder builder, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        m47089fragmentimpl(builder, str, z);
    }

    /* renamed from: fragment-impl  reason: not valid java name */
    public static final void m47089fragmentimpl(Uri.Builder builder, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "fragment");
        if (z) {
            builder.encodedFragment(str);
        } else {
            builder.fragment(str);
        }
    }

    /* renamed from: opaquePart-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47095opaquePartimpl$default(Uri.Builder builder, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        m47094opaquePartimpl(builder, str, z);
    }

    /* renamed from: opaquePart-impl  reason: not valid java name */
    public static final void m47094opaquePartimpl(Uri.Builder builder, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "opaquePart");
        if (z) {
            builder.encodedOpaquePart(str);
        } else {
            builder.opaquePart(str);
        }
    }

    /* renamed from: param-impl  reason: not valid java name */
    public static final void m47097paramimpl(Uri.Builder builder, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$param");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            builder.appendQueryParameter((String) charSequence, str2);
        }
    }

    /* renamed from: param-impl  reason: not valid java name */
    public static final void m47096paramimpl(Uri.Builder builder, String str, Number number) {
        Intrinsics.checkParameterIsNotNull(str, "$this$param");
        Intrinsics.checkParameterIsNotNull(number, "value");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            builder.appendQueryParameter((String) charSequence, number.toString());
        }
    }

    /* renamed from: param-impl  reason: not valid java name */
    public static final void m47098paramimpl(Uri.Builder builder, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "$this$param");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            builder.appendQueryParameter((String) charSequence, String.valueOf(z));
        }
    }

    /* renamed from: build-impl$lib_common_release  reason: not valid java name */
    public static final Uri m47084buildimpl$lib_common_release(Uri.Builder builder) {
        Uri build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
        return build;
    }
}
