package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "", "Lkotlin/UByte;", "invoke"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* compiled from: _UArrays.kt */
final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements Function0<Iterator<? extends UByte>> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    public final Iterator<UByte> invoke() {
        return UByteArray.m47716iteratorimpl(this.$this_withIndex);
    }
}
