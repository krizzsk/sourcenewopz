package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lkotlin/jvm/internal/ArrayLongIterator;", "Lkotlin/collections/LongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextLong", "", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.h */
/* compiled from: ArrayIterators.kt */
final class C21498h extends LongIterator {

    /* renamed from: a */
    private int f59941a;

    /* renamed from: b */
    private final long[] f59942b;

    public C21498h(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        this.f59942b = jArr;
    }

    public boolean hasNext() {
        return this.f59941a < this.f59942b.length;
    }

    public long nextLong() {
        try {
            long[] jArr = this.f59942b;
            int i = this.f59941a;
            this.f59941a = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f59941a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
