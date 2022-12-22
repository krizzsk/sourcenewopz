package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ShortIterator;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lkotlin/jvm/internal/ArrayShortIterator;", "Lkotlin/collections/ShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextShort", "", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.i */
/* compiled from: ArrayIterators.kt */
final class C21499i extends ShortIterator {

    /* renamed from: a */
    private int f59943a;

    /* renamed from: b */
    private final short[] f59944b;

    public C21499i(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        this.f59944b = sArr;
    }

    public boolean hasNext() {
        return this.f59943a < this.f59944b.length;
    }

    public short nextShort() {
        try {
            short[] sArr = this.f59944b;
            int i = this.f59943a;
            this.f59943a = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f59943a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
