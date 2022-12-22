package com.datadog.android.rum.resource;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Ljava/io/InputStream;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumResourceInputStream.kt */
final class RumResourceInputStream$skip$1 extends Lambda implements Function1<InputStream, Long> {

    /* renamed from: $n */
    final /* synthetic */ long f4024$n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RumResourceInputStream$skip$1(long j) {
        super(1);
        this.f4024$n = j;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Long.valueOf(invoke((InputStream) obj));
    }

    public final long invoke(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$callWithErrorTracking");
        return inputStream.skip(this.f4024$n);
    }
}
