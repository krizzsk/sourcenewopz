package com.didiglobal.travel.infra.value;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, mo175978d2 = {"asUriString", "Lcom/didiglobal/travel/infra/value/UriString;", "", "(Ljava/lang/String;)Ljava/lang/String;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Uri.kt */
public final class UriKt {
    public static final String asUriString(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$asUriString");
        return UriString.Companion.mo124955of(str);
    }
}
