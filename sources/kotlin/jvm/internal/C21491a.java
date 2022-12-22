package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lkotlin/jvm/internal/ArrayBooleanIterator;", "Lkotlin/collections/BooleanIterator;", "array", "", "([Z)V", "index", "", "hasNext", "", "nextBoolean", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.a */
/* compiled from: ArrayIterators.kt */
final class C21491a extends BooleanIterator {

    /* renamed from: a */
    private int f59927a;

    /* renamed from: b */
    private final boolean[] f59928b;

    public C21491a(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "array");
        this.f59928b = zArr;
    }

    public boolean hasNext() {
        return this.f59927a < this.f59928b.length;
    }

    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f59928b;
            int i = this.f59927a;
            this.f59927a = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f59927a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
