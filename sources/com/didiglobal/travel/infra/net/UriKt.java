package com.didiglobal.travel.infra.net;

import android.net.Uri;
import com.didi.raven.config.RavenKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a;\u0010\u0007\u001a\u00020\b*\u00020\b2*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\n\"\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\r\u001a!\u0010\u000e\u001a\u00020\b*\u00020\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u001a'\u0010\u000e\u001a\u00020\b*\u00020\b2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\u0011H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo175978d2 = {"createUri", "Landroid/net/Uri;", "block", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/net/UriCreator;", "", "Lkotlin/ExtensionFunctionType;", "appendParams", "Landroid/net/Uri$Builder;", "nameValuePairs", "", "Lkotlin/Pair;", "", "(Landroid/net/Uri$Builder;[Lkotlin/Pair;)Landroid/net/Uri$Builder;", "plus", "param", "paramList", "", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Uri.kt */
public final class UriKt {
    public static final Uri createUri(Function1<? super UriCreator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        UriCreator r0 = Intrinsics.checkParameterIsNotNull(UriCreator.m47086constructorimpl(new Uri.Builder()), RavenKey.VERSION);
        function1.invoke(r0);
        return UriCreator.m47084buildimpl$lib_common_release(r0.m47105unboximpl());
    }

    public static final Uri.Builder appendParams(Uri.Builder builder, Pair<String, String>... pairArr) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$appendParams");
        Intrinsics.checkParameterIsNotNull(pairArr, "nameValuePairs");
        if (pairArr.length == 0) {
            return builder;
        }
        return plus(builder, (List<Pair<String, String>>) ArraysKt.toList((T[]) pairArr));
    }

    public static final Uri.Builder plus(Uri.Builder builder, Pair<String, String> pair) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pair, "param");
        String component1 = pair.component1();
        String component2 = pair.component2();
        boolean z = true;
        if (component1.length() > 0) {
            if (component2.length() <= 0) {
                z = false;
            }
            if (z) {
                builder.appendQueryParameter(component1, component2);
            }
        }
        return builder;
    }

    public static final Uri.Builder plus(Uri.Builder builder, List<Pair<String, String>> list) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$plus");
        Intrinsics.checkParameterIsNotNull(list, "paramList");
        for (Pair plus : list) {
            plus(builder, (Pair<String, String>) plus);
        }
        return builder;
    }
}
