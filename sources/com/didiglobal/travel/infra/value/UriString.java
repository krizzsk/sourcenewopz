package com.didiglobal.travel.infra.value;

import android.net.Uri;
import com.didiglobal.travel.infra.net.UriCreator;
import com.didiglobal.travel.infra.net.UriKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\f\u001a\u00020\u00002*\u0010\r\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f0\u000e\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0014J)\u0010\u0015\u001a\u00020\u00072\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\b\u001aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J'\u0010\"\u001a\u00020\u00002\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%J)\u0010&\u001a\u00020\u00072\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\b\u001aH\b¢\u0006\u0004\b(\u0010\u001cJ\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/value/UriString;", "", "url", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "uri", "Landroid/net/Uri;", "getUri-impl", "(Ljava/lang/String;)Landroid/net/Uri;", "getUrl", "()Ljava/lang/String;", "appendParam", "nameValuePairs", "", "Lkotlin/Pair;", "appendParam-impl", "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/lang/String;", "name", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "buildUpon", "block", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/net/UriCreator;", "", "Lkotlin/ExtensionFunctionType;", "buildUpon-impl", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Landroid/net/Uri;", "equals", "", "other", "hashCode", "", "plus", "param", "plus-impl", "(Ljava/lang/String;Lkotlin/Pair;)Ljava/lang/String;", "rebuild", "Landroid/net/Uri$Builder;", "rebuild-impl", "toString", "Companion", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Uri.kt */
public final class UriString {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final String f51455a;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m47251constructorimpl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47252equalsimpl(String str, Object obj) {
        return (obj instanceof UriString) && Intrinsics.areEqual((Object) str, (Object) ((UriString) obj).m47259unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47253equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47255hashCodeimpl(String str) {
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47258toStringimpl(String str) {
        return "UriString(url=" + str + ")";
    }

    public boolean equals(Object obj) {
        return m47252equalsimpl(this.f51455a, obj);
    }

    public int hashCode() {
        return m47255hashCodeimpl(this.f51455a);
    }

    public String toString() {
        return m47258toStringimpl(this.f51455a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m47259unboximpl() {
        return this.f51455a;
    }

    private /* synthetic */ UriString(String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this.f51455a = str;
    }

    public final String getUrl() {
        return this.f51455a;
    }

    /* renamed from: getUri-impl  reason: not valid java name */
    public static final Uri m47254getUriimpl(String str) {
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(url)");
        return parse;
    }

    /* renamed from: plus-impl  reason: not valid java name */
    public static final String m47256plusimpl(String str, Pair<String, String> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "param");
        return m47247appendParamimpl(str, pair.getFirst(), pair.getSecond());
    }

    /* renamed from: appendParam-impl  reason: not valid java name */
    public static final String m47248appendParamimpl(String str, Pair<String, String>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "nameValuePairs");
        if (pairArr.length == 0) {
            return str;
        }
        Uri.Builder buildUpon = m47254getUriimpl(str).buildUpon();
        UriKt.plus(buildUpon, (List<Pair<String, String>>) ArraysKt.toList((T[]) pairArr));
        Uri build = buildUpon.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "uri.buildUpon().apply(block).build()");
        String uri = build.toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "rebuild { this + nameVal…irs.toList() }.toString()");
        return m47251constructorimpl(uri);
    }

    /* renamed from: buildUpon-impl  reason: not valid java name */
    public static final Uri m47250buildUponimpl(String str, Function1<? super UriCreator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        return UriKt.createUri(function1);
    }

    /* renamed from: rebuild-impl  reason: not valid java name */
    public static final Uri m47257rebuildimpl(String str, Function1<? super Uri.Builder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Uri.Builder buildUpon = m47254getUriimpl(str).buildUpon();
        function1.invoke(buildUpon);
        Uri build = buildUpon.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "uri.buildUpon().apply(block).build()");
        return build;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/value/UriString$Companion;", "", "()V", "of", "Lcom/didiglobal/travel/infra/value/UriString;", "text", "", "(Ljava/lang/String;)Ljava/lang/String;", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Uri.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: of */
        public final String mo124955of(String str) {
            Intrinsics.checkParameterIsNotNull(str, "text");
            return UriString.m47251constructorimpl(str);
        }
    }

    /* renamed from: appendParam-impl  reason: not valid java name */
    public static final String m47247appendParamimpl(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str2, "name");
        Intrinsics.checkParameterIsNotNull(str3, "value");
        Uri.Builder buildUpon = m47254getUriimpl(str).buildUpon();
        buildUpon.appendQueryParameter(str2, str3);
        Uri build = buildUpon.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "uri.buildUpon().apply(block).build()");
        String uri = build.toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "rebuild { appendQueryPar…name, value) }.toString()");
        return m47251constructorimpl(uri);
    }
}
